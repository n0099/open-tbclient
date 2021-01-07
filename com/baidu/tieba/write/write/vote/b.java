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
/* loaded from: classes8.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout ceJ;
    private Intent ghm;
    private ForumWriteData jst;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView oiD;
    private WriteVoteViewAdapter oiE;
    private LinearLayout oiF;
    private TextView oiG;
    private EditText oiH;
    private TextView oiI;
    private TextView oiJ;
    private TextView oiK;
    private TextView oiL;
    private TextView oiM;
    private TextView oiN;
    private TextView oiO;
    private TextView oiP;
    private TextView oiQ;
    private int oiR = 0;
    private int expireType = -1;
    private boolean oiS = false;
    private boolean oiT = false;

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
                this.jst = (ForumWriteData) serializableExtra;
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
        this.oiD = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.oiD.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.oiD, layoutParams);
        this.oiE = new WriteVoteViewAdapter(this.mPageContext);
        this.oiD.setAdapter(this.oiE);
        bIl();
        bZD();
        dGO();
        cbY();
        this.oiD.addHeaderView(this.oiF);
        this.oiD.addFooterView(this.ceJ);
        this.oiE.setData(this.mData);
        ebA();
        this.oiH.requestFocus();
        this.oiH.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.oiH);
            }
        }, 150L);
    }

    private void bIl() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.oiQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.oiQ.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.oiQ.setEnabled(false);
    }

    private void bZD() {
        this.oiF = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.oiG = (TextView) this.oiF.findViewById(R.id.vote_item_tip);
        this.oiH = (EditText) this.oiF.findViewById(R.id.vote_title);
    }

    private void dGO() {
        this.ceJ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.oiI = (TextView) this.ceJ.findViewById(R.id.write_vote_type);
        this.oiJ = (TextView) this.ceJ.findViewById(R.id.vote_type_single);
        this.oiK = (TextView) this.ceJ.findViewById(R.id.vote_type_multiple);
        this.oiL = (TextView) this.ceJ.findViewById(R.id.write_vote_time);
        this.oiM = (TextView) this.ceJ.findViewById(R.id.vote_time_forever);
        this.oiN = (TextView) this.ceJ.findViewById(R.id.vote_time_1_day);
        this.oiO = (TextView) this.ceJ.findViewById(R.id.vote_time_7_days);
        this.oiP = (TextView) this.ceJ.findViewById(R.id.vote_time_30_days);
    }

    private void ebA() {
        if (this.mWriteVoteData != null) {
            this.oiH.setText(this.mWriteVoteData.getTitle());
            this.oiR = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            ebD();
            ebE();
            this.oiT = ebC();
            zx(this.oiS && this.oiT);
        }
    }

    private void cbY() {
        this.oiJ.setOnClickListener(this);
        this.oiK.setOnClickListener(this);
        this.oiM.setOnClickListener(this);
        this.oiN.setOnClickListener(this);
        this.oiO.setOnClickListener(this);
        this.oiP.setOnClickListener(this);
        this.oiH.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.oiH.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.oiS = false;
                        b.this.zx(false);
                        return;
                    }
                    String replace = obj.replace(" ", "");
                    if (ad.getTextLengthWithEmoji(replace) > 40) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    String subStringWithEmoji = ad.subStringWithEmoji(replace, 40);
                    if (!subStringWithEmoji.equals(editable.toString())) {
                        b.this.oiH.setText(subStringWithEmoji);
                        b.this.oiH.setSelection(subStringWithEmoji.length());
                    }
                    b.this.oiH.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.oiS = true;
                    b.this.zx(b.this.oiT);
                }
            }
        });
        this.oiE.a(new WriteVoteViewAdapter.c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void ebF() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.oiD.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oiE.setData(b.this.mData);
                    }
                });
                b.this.oiT = b.this.ebC();
                b.this.zx(b.this.oiS && b.this.oiT);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void MS(int i) {
                b.this.mData.remove(i);
                b.this.oiD.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oiE.setData(b.this.mData);
                    }
                });
                b.this.oiT = b.this.ebC();
                b.this.zx(b.this.oiS && b.this.oiT);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.oiT = b.this.ebC();
                b.this.zx(b.this.oiS && b.this.oiT);
            }
        });
        this.oiD.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.oiQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> ebB = b.this.ebB();
                HashMap hashMap = new HashMap();
                int size = ebB.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = ebB.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.oiH.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.oiR);
                b.this.mWriteVoteData.setOptions(ebB);
                b.this.ghm = new Intent();
                b.this.ghm.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.VD(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VD(String str) {
        if (this.jst != null && !WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumWriteData(this.jst).setShowVoteData(this.mWriteVoteData).setTitle(str).send();
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sY(int i) {
        ao.setViewTextColor(this.oiG, R.color.CAM_X0109);
        this.oiH.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        this.oiH.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.oiI.setTextColor(ao.getColor(R.color.CAM_X0105));
        this.oiL.setTextColor(ao.getColor(R.color.CAM_X0105));
        if (this.oiS && this.oiT) {
            this.oiQ.setTextColor(ao.getColor(R.color.CAM_X0302));
        } else {
            this.oiQ.setTextColor(c.m(ao.getColor(R.color.CAM_X0302), 0.5f));
        }
        ebD();
        ebE();
        if (this.oiE != null) {
            this.oiE.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> ebB() {
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
    public boolean ebC() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zx(boolean z) {
        this.oiQ.setEnabled(z);
        if (z) {
            this.oiQ.setTextColor(ao.getColor(R.color.CAM_X0302));
        } else {
            this.oiQ.setTextColor(c.m(ao.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void ebD() {
        e(this.oiJ, this.oiR != 1);
        e(this.oiK, this.oiR == 1);
    }

    private void ebE() {
        e(this.oiM, this.expireType == -1);
        e(this.oiN, this.expireType == 1);
        e(this.oiO, this.expireType == 7);
        e(this.oiP, this.expireType == 30);
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
    public boolean bIh() {
        return this.oiF != null && this.oiD != null && this.oiF.getTop() == 0 && this.oiD.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bIi() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bIj() {
        return this.ghm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.oiR = 0;
            ebD();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.oiR = 1;
            ebD();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            ebE();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            ebE();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            ebE();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            ebE();
        }
    }
}
