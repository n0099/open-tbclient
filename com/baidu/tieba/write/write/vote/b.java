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
    private LinearLayout bUt;
    private Intent fPL;
    private ForumWriteData iUj;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private TextView nQA;
    private TextView nQB;
    private TextView nQC;
    private TextView nQD;
    private TextView nQE;
    private TextView nQF;
    private TextView nQG;
    private TextView nQH;
    private BdRecyclerView nQu;
    private c nQv;
    private LinearLayout nQw;
    private TextView nQx;
    private EditText nQy;
    private TextView nQz;
    private int nQI = 0;
    private int expireType = -1;
    private boolean nQJ = false;
    private boolean nQK = false;

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
                this.iUj = (ForumWriteData) serializableExtra;
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
        this.nQu = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.nQu.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.nQu, layoutParams);
        this.nQv = new c(this.mPageContext);
        this.nQu.setAdapter(this.nQv);
        bCV();
        bTT();
        dCi();
        bWm();
        this.nQu.addHeaderView(this.nQw);
        this.nQu.addFooterView(this.bUt);
        this.nQv.setData(this.mData);
        dWZ();
        this.nQy.requestFocus();
        this.nQy.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.nQy);
            }
        }, 150L);
    }

    private void bCV() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.nQH = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.nQH.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.nQH.setEnabled(false);
    }

    private void bTT() {
        this.nQw = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.nQx = (TextView) this.nQw.findViewById(R.id.vote_item_tip);
        this.nQy = (EditText) this.nQw.findViewById(R.id.vote_title);
    }

    private void dCi() {
        this.bUt = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.nQz = (TextView) this.bUt.findViewById(R.id.write_vote_type);
        this.nQA = (TextView) this.bUt.findViewById(R.id.vote_type_single);
        this.nQB = (TextView) this.bUt.findViewById(R.id.vote_type_multiple);
        this.nQC = (TextView) this.bUt.findViewById(R.id.write_vote_time);
        this.nQD = (TextView) this.bUt.findViewById(R.id.vote_time_forever);
        this.nQE = (TextView) this.bUt.findViewById(R.id.vote_time_1_day);
        this.nQF = (TextView) this.bUt.findViewById(R.id.vote_time_7_days);
        this.nQG = (TextView) this.bUt.findViewById(R.id.vote_time_30_days);
    }

    private void dWZ() {
        if (this.mWriteVoteData != null) {
            this.nQy.setText(this.mWriteVoteData.getTitle());
            this.nQI = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dXc();
            dXd();
            this.nQK = dXb();
            yO(this.nQJ && this.nQK);
        }
    }

    private void bWm() {
        this.nQA.setOnClickListener(this);
        this.nQB.setOnClickListener(this);
        this.nQD.setOnClickListener(this);
        this.nQE.setOnClickListener(this);
        this.nQF.setOnClickListener(this);
        this.nQG.setOnClickListener(this);
        this.nQy.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.nQy.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.nQJ = false;
                        b.this.yO(false);
                        return;
                    }
                    if (af.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = af.subStringWithEmoji(obj, 40);
                        b.this.nQy.setText(subStringWithEmoji);
                        b.this.nQy.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.nQy.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.nQJ = true;
                    b.this.yO(b.this.nQK);
                }
            }
        });
        this.nQv.a(new c.InterfaceC0889c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0889c
            public void dXe() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.nQu.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nQv.setData(b.this.mData);
                    }
                });
                b.this.nQK = b.this.dXb();
                b.this.yO(b.this.nQJ && b.this.nQK);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0889c
            public void LL(int i) {
                b.this.mData.remove(i);
                b.this.nQu.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nQv.setData(b.this.mData);
                    }
                });
                b.this.nQK = b.this.dXb();
                b.this.yO(b.this.nQJ && b.this.nQK);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0889c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.nQK = b.this.dXb();
                b.this.yO(b.this.nQJ && b.this.nQK);
            }
        });
        this.nQu.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.nQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dXa = b.this.dXa();
                HashMap hashMap = new HashMap();
                int size = dXa.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dXa.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.nQy.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.nQI);
                b.this.mWriteVoteData.setOptions(dXa);
                b.this.fPL = new Intent();
                b.this.fPL.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.Ve(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ve(String str) {
        if (this.iUj != null) {
            String str2 = this.iUj.forumId;
            String str3 = this.iUj.forumName;
            PostPrefixData postPrefixData = this.iUj.prefixData;
            AntiData antiData = this.iUj.antiData;
            int i = this.iUj.forumLevel;
            String str4 = this.iUj.avatar;
            int i2 = this.iUj.privateThread;
            String str5 = this.iUj.firstDir;
            String str6 = this.iUj.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.iUj.mFrom);
            writeActivityConfig.setCallFrom(this.iUj.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.iUj != null ? this.iUj.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.iUj != null ? this.iUj.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rO(int i) {
        ap.setViewTextColor(this.nQx, R.color.cp_cont_d);
        this.nQy.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.nQy.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.nQz.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.nQC.setTextColor(ap.getColor(R.color.cp_cont_b));
        if (this.nQJ && this.nQK) {
            this.nQH.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.nQH.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dXc();
        dXd();
        if (this.nQv != null) {
            this.nQv.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dXa() {
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
    public boolean dXb() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yO(boolean z) {
        this.nQH.setEnabled(z);
        if (z) {
            this.nQH.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.nQH.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dXc() {
        e(this.nQA, this.nQI != 1);
        e(this.nQB, this.nQI == 1);
    }

    private void dXd() {
        e(this.nQD, this.expireType == -1);
        e(this.nQE, this.expireType == 1);
        e(this.nQF, this.expireType == 7);
        e(this.nQG, this.expireType == 30);
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
    public boolean bCR() {
        return this.nQw != null && this.nQu != null && this.nQw.getTop() == 0 && this.nQu.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCS() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCT() {
        return this.fPL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.nQI = 0;
            dXc();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.nQI = 1;
            dXc();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dXd();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dXd();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dXd();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dXd();
        }
    }
}
