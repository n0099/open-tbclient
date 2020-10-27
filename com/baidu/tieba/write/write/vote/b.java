package com.baidu.tieba.write.write.vote;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.af;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.vote.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout bOJ;
    private Intent fJV;
    private ForumWriteData iOm;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView nKA;
    private c nKB;
    private LinearLayout nKC;
    private TextView nKD;
    private EditText nKE;
    private TextView nKF;
    private TextView nKG;
    private TextView nKH;
    private TextView nKI;
    private TextView nKJ;
    private TextView nKK;
    private TextView nKL;
    private TextView nKM;
    private TextView nKN;
    private int nKO = 0;
    private int expireType = -1;
    private boolean nKP = false;
    private boolean nKQ = false;

    public b(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        this.mPageContext = tbPageContext;
        this.mContentView = linearLayout;
        this.mNavigationBar = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVoteActivityConfig.EXTRA_DATA_KEY);
            if (serializableExtra instanceof WriteVoteData) {
                this.mWriteVoteData = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.iOm = (ForumWriteData) serializableExtra;
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
        this.nKA = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.nKA.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.nKA, layoutParams);
        this.nKB = new c(this.mPageContext);
        this.nKA.setAdapter(this.nKB);
        bAw();
        bRu();
        dzG();
        bTF();
        this.nKA.addHeaderView(this.nKC);
        this.nKA.addFooterView(this.bOJ);
        this.nKB.setData(this.mData);
        dUz();
        this.nKE.requestFocus();
        this.nKE.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.nKE);
            }
        }, 150L);
    }

    private void bAw() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.nKN = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.nKN.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.nKN.setEnabled(false);
    }

    private void bRu() {
        this.nKC = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.nKD = (TextView) this.nKC.findViewById(R.id.vote_item_tip);
        this.nKE = (EditText) this.nKC.findViewById(R.id.vote_title);
    }

    private void dzG() {
        this.bOJ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.nKF = (TextView) this.bOJ.findViewById(R.id.write_vote_type);
        this.nKG = (TextView) this.bOJ.findViewById(R.id.vote_type_single);
        this.nKH = (TextView) this.bOJ.findViewById(R.id.vote_type_multiple);
        this.nKI = (TextView) this.bOJ.findViewById(R.id.write_vote_time);
        this.nKJ = (TextView) this.bOJ.findViewById(R.id.vote_time_forever);
        this.nKK = (TextView) this.bOJ.findViewById(R.id.vote_time_1_day);
        this.nKL = (TextView) this.bOJ.findViewById(R.id.vote_time_7_days);
        this.nKM = (TextView) this.bOJ.findViewById(R.id.vote_time_30_days);
    }

    private void dUz() {
        if (this.mWriteVoteData != null) {
            this.nKE.setText(this.mWriteVoteData.getTitle());
            this.nKO = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dUC();
            dUD();
            this.nKQ = dUB();
            yF(this.nKP && this.nKQ);
        }
    }

    private void bTF() {
        this.nKG.setOnClickListener(this);
        this.nKH.setOnClickListener(this);
        this.nKJ.setOnClickListener(this);
        this.nKK.setOnClickListener(this);
        this.nKL.setOnClickListener(this);
        this.nKM.setOnClickListener(this);
        this.nKE.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.nKE.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.nKP = false;
                        b.this.yF(false);
                        return;
                    }
                    if (af.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = af.subStringWithEmoji(obj, 40);
                        b.this.nKE.setText(subStringWithEmoji);
                        b.this.nKE.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.nKE.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.nKP = true;
                    b.this.yF(b.this.nKQ);
                }
            }
        });
        this.nKB.a(new c.InterfaceC0874c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0874c
            public void dUE() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.nKA.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nKB.setData(b.this.mData);
                    }
                });
                b.this.nKQ = b.this.dUB();
                b.this.yF(b.this.nKP && b.this.nKQ);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0874c
            public void Ly(int i) {
                b.this.mData.remove(i);
                b.this.nKA.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nKB.setData(b.this.mData);
                    }
                });
                b.this.nKQ = b.this.dUB();
                b.this.yF(b.this.nKP && b.this.nKQ);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0874c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.nKQ = b.this.dUB();
                b.this.yF(b.this.nKP && b.this.nKQ);
            }
        });
        this.nKA.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.nKN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dUA = b.this.dUA();
                HashMap hashMap = new HashMap();
                int size = dUA.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dUA.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.nKE.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.nKO);
                b.this.mWriteVoteData.setOptions(dUA);
                b.this.fJV = new Intent();
                b.this.fJV.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.UN(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UN(String str) {
        if (this.iOm != null) {
            String str2 = this.iOm.forumId;
            String str3 = this.iOm.forumName;
            PostPrefixData postPrefixData = this.iOm.prefixData;
            AntiData antiData = this.iOm.antiData;
            int i = this.iOm.forumLevel;
            String str4 = this.iOm.avatar;
            int i2 = this.iOm.privateThread;
            String str5 = this.iOm.firstDir;
            String str6 = this.iOm.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.iOm.mFrom);
            writeActivityConfig.setCallFrom(this.iOm.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.iOm != null ? this.iOm.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.iOm != null ? this.iOm.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rE(int i) {
        ap.setViewTextColor(this.nKD, R.color.cp_cont_d);
        this.nKE.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.nKE.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.nKF.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.nKI.setTextColor(ap.getColor(R.color.cp_cont_b));
        if (this.nKP && this.nKQ) {
            this.nKN.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.nKN.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dUC();
        dUD();
        if (this.nKB != null) {
            this.nKB.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dUA() {
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
    public boolean dUB() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yF(boolean z) {
        this.nKN.setEnabled(z);
        if (z) {
            this.nKN.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.nKN.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dUC() {
        e(this.nKG, this.nKO != 1);
        e(this.nKH, this.nKO == 1);
    }

    private void dUD() {
        e(this.nKJ, this.expireType == -1);
        e(this.nKK, this.expireType == 1);
        e(this.nKL, this.expireType == 7);
        e(this.nKM, this.expireType == 30);
    }

    private void e(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
        if (z) {
            ap.setViewTextColor(textView, R.color.cp_link_tip_a);
            gradientDrawable.setColor(ap.getColor(R.color.cp_btn_d));
            textView.setBackgroundDrawable(gradientDrawable);
            return;
        }
        ap.setViewTextColor(textView, R.color.cp_cont_b);
        gradientDrawable.setColor(ap.getColor(R.color.cp_bg_line_j));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAs() {
        return this.nKC != null && this.nKA != null && this.nKC.getTop() == 0 && this.nKA.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bAt() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bAu() {
        return this.fJV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.nKO = 0;
            dUC();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.nKO = 1;
            dUC();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dUD();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dUD();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dUD();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dUD();
        }
    }
}
