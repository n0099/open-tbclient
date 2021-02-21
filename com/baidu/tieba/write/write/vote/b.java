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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ag;
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
    private LinearLayout cdZ;
    private Intent geY;
    private ForumWriteData jtH;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private TextView ooA;
    private TextView ooB;
    private TextView ooC;
    private TextView ooD;
    private int ooE = 0;
    private int ooF = -1;
    private boolean ooG = false;
    private boolean ooH = false;
    private BdRecyclerView ooq;
    private WriteVoteViewAdapter oor;
    private LinearLayout oos;
    private TextView oot;
    private EditText oou;
    private TextView oov;
    private TextView oow;
    private TextView oox;
    private TextView ooy;
    private TextView ooz;

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
                this.jtH = (ForumWriteData) serializableExtra;
            }
            this.mTitle = intent.getStringExtra("title");
        }
        if (this.mWriteVoteData == null || y.isEmpty(this.mWriteVoteData.getOptions()) || this.mWriteVoteData.getOptions().size() < 2) {
            this.mData = new ArrayList();
            this.mData.add(new WriteVoteItemData());
            this.mData.add(new WriteVoteItemData());
        } else {
            this.mData = this.mWriteVoteData.getOptions();
        }
        init();
    }

    private void init() {
        this.ooq = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.ooq.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.ooq, layoutParams);
        this.oor = new WriteVoteViewAdapter(this.mPageContext);
        this.ooq.setAdapter(this.oor);
        bEL();
        bWw();
        cQV();
        bZl();
        this.ooq.addHeaderView(this.oos);
        this.ooq.addFooterView(this.cdZ);
        this.oor.setData(this.mData);
        eab();
        this.oou.requestFocus();
        this.oou.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.oou);
            }
        }, 150L);
    }

    private void bEL() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.ooD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.ooD.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.ooD.setEnabled(false);
    }

    private void bWw() {
        this.oos = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.oot = (TextView) this.oos.findViewById(R.id.vote_item_tip);
        this.oou = (EditText) this.oos.findViewById(R.id.vote_title);
    }

    private void cQV() {
        this.cdZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.oov = (TextView) this.cdZ.findViewById(R.id.write_vote_type);
        this.oow = (TextView) this.cdZ.findViewById(R.id.vote_type_single);
        this.oox = (TextView) this.cdZ.findViewById(R.id.vote_type_multiple);
        this.ooy = (TextView) this.cdZ.findViewById(R.id.write_vote_time);
        this.ooz = (TextView) this.cdZ.findViewById(R.id.vote_time_forever);
        this.ooA = (TextView) this.cdZ.findViewById(R.id.vote_time_1_day);
        this.ooB = (TextView) this.cdZ.findViewById(R.id.vote_time_7_days);
        this.ooC = (TextView) this.cdZ.findViewById(R.id.vote_time_30_days);
    }

    private void eab() {
        if (this.mWriteVoteData != null) {
            this.oou.setText(this.mWriteVoteData.getTitle());
            this.ooE = this.mWriteVoteData.getIs_multi();
            this.ooF = this.mWriteVoteData.getExpire_type();
            eae();
            eaf();
            this.ooH = ead();
            zO(this.ooG && this.ooH);
        }
    }

    private void bZl() {
        this.oow.setOnClickListener(this);
        this.oox.setOnClickListener(this);
        this.ooz.setOnClickListener(this);
        this.ooA.setOnClickListener(this);
        this.ooB.setOnClickListener(this);
        this.ooC.setOnClickListener(this);
        this.oou.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.oou.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.ooG = false;
                        b.this.zO(false);
                        return;
                    }
                    String replace = obj.replace(" ", "");
                    if (ag.getTextLengthWithEmoji(replace) > 40) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    String subStringWithEmoji = ag.subStringWithEmoji(replace, 40);
                    if (!subStringWithEmoji.equals(editable.toString())) {
                        b.this.oou.setText(subStringWithEmoji);
                        b.this.oou.setSelection(subStringWithEmoji.length());
                    }
                    b.this.oou.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.ooG = true;
                    b.this.zO(b.this.ooH);
                }
            }
        });
        this.oor.a(new WriteVoteViewAdapter.c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void eag() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.ooq.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oor.setData(b.this.mData);
                    }
                });
                b.this.ooH = b.this.ead();
                b.this.zO(b.this.ooG && b.this.ooH);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void LG(int i) {
                b.this.mData.remove(i);
                b.this.ooq.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oor.setData(b.this.mData);
                    }
                });
                b.this.ooH = b.this.ead();
                b.this.zO(b.this.ooG && b.this.ooH);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.ooH = b.this.ead();
                b.this.zO(b.this.ooG && b.this.ooH);
            }
        });
        this.ooq.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.ooD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> eac = b.this.eac();
                HashMap hashMap = new HashMap();
                int size = eac.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = eac.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.oou.getText().toString());
                b.this.mWriteVoteData.setExpire_type(b.this.ooF);
                b.this.mWriteVoteData.setIs_multi(b.this.ooE);
                b.this.mWriteVoteData.setOptions(eac);
                b.this.geY = new Intent();
                b.this.geY.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.VG(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VG(String str) {
        if (this.jtH != null && !WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumWriteData(this.jtH).setShowVoteData(this.mWriteVoteData).setTitle(str).send();
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
        ap.setViewTextColor(this.oot, R.color.CAM_X0109);
        this.oou.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.oou.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.oov.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.ooy.setTextColor(ap.getColor(R.color.CAM_X0105));
        if (this.ooG && this.ooH) {
            this.ooD.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ooD.setTextColor(c.l(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
        eae();
        eaf();
        if (this.oor != null) {
            this.oor.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> eac() {
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
    public boolean ead() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(boolean z) {
        this.ooD.setEnabled(z);
        if (z) {
            this.ooD.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ooD.setTextColor(c.l(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void eae() {
        f(this.oow, this.ooE != 1);
        f(this.oox, this.ooE == 1);
    }

    private void eaf() {
        f(this.ooz, this.ooF == -1);
        f(this.ooA, this.ooF == 1);
        f(this.ooB, this.ooF == 7);
        f(this.ooC, this.ooF == 30);
    }

    private void f(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
        if (z) {
            ap.setViewTextColor(textView, R.color.CAM_X0302);
            gradientDrawable.setColor(ap.getColor(R.color.CAM_X0905));
            textView.setBackgroundDrawable(gradientDrawable);
            return;
        }
        ap.setViewTextColor(textView, R.color.CAM_X0105);
        gradientDrawable.setColor(ap.getColor(R.color.CAM_X0209));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEH() {
        return this.oos != null && this.ooq != null && this.oos.getTop() == 0 && this.ooq.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return this.geY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.ooE = 0;
            eae();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.ooE = 1;
            eae();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.ooF = -1;
            eaf();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.ooF = 1;
            eaf();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.ooF = 7;
            eaf();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.ooF = 30;
            eaf();
        }
    }
}
