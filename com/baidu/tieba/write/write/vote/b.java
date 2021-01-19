package com.baidu.tieba.write.write.vote;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.tbadkCore.c;
import com.baidu.tieba.write.write.vote.WriteVoteViewAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout bZT;
    private Intent gcE;
    private ForumWriteData jnN;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView odY;
    private WriteVoteViewAdapter odZ;
    private LinearLayout oea;
    private TextView oeb;
    private EditText oec;
    private TextView oed;
    private TextView oee;
    private TextView oef;
    private TextView oeg;
    private TextView oeh;
    private TextView oei;
    private TextView oej;
    private TextView oek;
    private TextView oel;
    private int oem = 0;
    private int expireType = -1;
    private boolean oen = false;
    private boolean oeo = false;

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra("extra_data");
            if (serializableExtra instanceof WriteVoteData) {
                this.mWriteVoteData = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.jnN = (ForumWriteData) serializableExtra;
            }
            this.mTitle = intent.getStringExtra("title");
        }
        if (this.mWriteVoteData == null || x.isEmpty(this.mWriteVoteData.getOptions()) || this.mWriteVoteData.getOptions().size() < 2) {
            this.mData = new ArrayList();
            this.mData.add(new WriteVoteItemData());
            this.mData.add(new WriteVoteItemData());
        } else {
            this.mData = this.mWriteVoteData.getOptions();
        }
        init();
    }

    private void init() {
        this.odY = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.odY.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.odY, layoutParams);
        this.odZ = new WriteVoteViewAdapter(this.mPageContext);
        this.odY.setAdapter(this.odZ);
        bEt();
        bVL();
        dCW();
        bYg();
        this.odY.addHeaderView(this.oea);
        this.odY.addFooterView(this.bZT);
        this.odZ.setData(this.mData);
        dXI();
        this.oec.requestFocus();
        this.oec.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.oec);
            }
        }, 150L);
    }

    private void bEt() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.oel = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.oel.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.oel.setEnabled(false);
    }

    private void bVL() {
        this.oea = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.oeb = (TextView) this.oea.findViewById(R.id.vote_item_tip);
        this.oec = (EditText) this.oea.findViewById(R.id.vote_title);
    }

    private void dCW() {
        this.bZT = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.oed = (TextView) this.bZT.findViewById(R.id.write_vote_type);
        this.oee = (TextView) this.bZT.findViewById(R.id.vote_type_single);
        this.oef = (TextView) this.bZT.findViewById(R.id.vote_type_multiple);
        this.oeg = (TextView) this.bZT.findViewById(R.id.write_vote_time);
        this.oeh = (TextView) this.bZT.findViewById(R.id.vote_time_forever);
        this.oei = (TextView) this.bZT.findViewById(R.id.vote_time_1_day);
        this.oej = (TextView) this.bZT.findViewById(R.id.vote_time_7_days);
        this.oek = (TextView) this.bZT.findViewById(R.id.vote_time_30_days);
    }

    private void dXI() {
        if (this.mWriteVoteData != null) {
            this.oec.setText(this.mWriteVoteData.getTitle());
            this.oem = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dXL();
            dXM();
            this.oeo = dXK();
            zt(this.oen && this.oeo);
        }
    }

    private void bYg() {
        this.oee.setOnClickListener(this);
        this.oef.setOnClickListener(this);
        this.oeh.setOnClickListener(this);
        this.oei.setOnClickListener(this);
        this.oej.setOnClickListener(this);
        this.oek.setOnClickListener(this);
        this.oec.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (editable != null) {
                    String obj = editable.toString();
                    if (StringUtils.isNull(obj)) {
                        b.this.oec.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.oen = false;
                        b.this.zt(false);
                        return;
                    }
                    String replace = obj.replace(" ", "");
                    if (ad.getTextLengthWithEmoji(replace) > 40) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    String subStringWithEmoji = ad.subStringWithEmoji(replace, 40);
                    if (!subStringWithEmoji.equals(editable.toString())) {
                        b.this.oec.setText(subStringWithEmoji);
                        b.this.oec.setSelection(subStringWithEmoji.length());
                    }
                    b.this.oec.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.oen = true;
                    b.this.zt(b.this.oeo);
                }
            }
        });
        this.odZ.a(new WriteVoteViewAdapter.c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void dXN() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.odY.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.odZ.setData(b.this.mData);
                    }
                });
                b.this.oeo = b.this.dXK();
                b.this.zt(b.this.oen && b.this.oeo);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void Ll(int i) {
                b.this.mData.remove(i);
                b.this.odY.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.odZ.setData(b.this.mData);
                    }
                });
                b.this.oeo = b.this.dXK();
                b.this.zt(b.this.oen && b.this.oeo);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.oeo = b.this.dXK();
                b.this.zt(b.this.oen && b.this.oeo);
            }
        });
        this.odY.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.oel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dXJ = b.this.dXJ();
                HashMap hashMap = new HashMap();
                int size = dXJ.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dXJ.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.oec.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.oem);
                b.this.mWriteVoteData.setOptions(dXJ);
                b.this.gcE = new Intent();
                b.this.gcE.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.Uw(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uw(String str) {
        if (this.jnN != null && !WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumWriteData(this.jnN).setShowVoteData(this.mWriteVoteData).setTitle(str).send();
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rs(int i) {
        ao.setViewTextColor(this.oeb, R.color.CAM_X0109);
        this.oec.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        this.oec.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.oed.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.oeg.setTextColor(ao.getColor(R.color.CAM_X0105));
        if (this.oen && this.oeo) {
            this.oel.setTextColor(ao.getColor(R.color.CAM_X0302));
        } else {
            this.oel.setTextColor(c.m(ao.getColor(R.color.CAM_X0302), 0.5f));
        }
        dXL();
        dXM();
        if (this.odZ != null) {
            this.odZ.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dXJ() {
        ArrayList arrayList = new ArrayList();
        if (this.mData == null) {
            return arrayList;
        }
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
            writeVoteItemData.setId(i + 1);
            writeVoteItemData.setText(this.mData.get(i).getText());
            arrayList.add(writeVoteItemData);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dXK() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zt(boolean z) {
        this.oel.setEnabled(z);
        if (z) {
            this.oel.setTextColor(ao.getColor(R.color.CAM_X0302));
        } else {
            this.oel.setTextColor(c.m(ao.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void dXL() {
        e(this.oee, this.oem != 1);
        e(this.oef, this.oem == 1);
    }

    private void dXM() {
        e(this.oeh, this.expireType == -1);
        e(this.oei, this.expireType == 1);
        e(this.oej, this.expireType == 7);
        e(this.oek, this.expireType == 30);
    }

    private void e(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
        if (z) {
            ao.setViewTextColor(textView, R.color.CAM_X0302);
            gradientDrawable.setColor(ao.getColor(R.color.CAM_X0905));
            textView.setBackgroundDrawable(gradientDrawable);
            return;
        }
        ao.setViewTextColor(textView, R.color.CAM_X0105);
        gradientDrawable.setColor(ao.getColor(R.color.CAM_X0209));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEp() {
        return this.oea != null && this.odY != null && this.oea.getTop() == 0 && this.odY.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEq() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEr() {
        return this.gcE;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.oem = 0;
            dXL();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.oem = 1;
            dXL();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dXM();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dXM();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dXM();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dXM();
        }
    }
}
