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
    private Intent fpm;
    private LinearLayout hfn;
    private ForumWriteData imW;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView niF;
    private c niG;
    private LinearLayout niH;
    private TextView niI;
    private EditText niJ;
    private TextView niK;
    private TextView niL;
    private TextView niM;
    private TextView niN;
    private TextView niO;
    private TextView niP;
    private TextView niQ;
    private TextView niR;
    private TextView niS;
    private int niT = 0;
    private int expireType = -1;
    private boolean niU = false;
    private boolean niV = false;

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
                this.imW = (ForumWriteData) serializableExtra;
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
        this.niF = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.niF.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.niF, layoutParams);
        this.niG = new c(this.mPageContext);
        this.niF.setAdapter(this.niG);
        bvT();
        bMf();
        dsN();
        bNr();
        this.niF.addHeaderView(this.niH);
        this.niF.addFooterView(this.hfn);
        this.niG.setData(this.mData);
        dNF();
        this.niJ.requestFocus();
        this.niJ.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.niJ);
            }
        }, 150L);
    }

    private void bvT() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.niS = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.niS.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.niS.setEnabled(false);
    }

    private void bMf() {
        this.niH = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.niI = (TextView) this.niH.findViewById(R.id.vote_item_tip);
        this.niJ = (EditText) this.niH.findViewById(R.id.vote_title);
    }

    private void dsN() {
        this.hfn = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.niK = (TextView) this.hfn.findViewById(R.id.write_vote_type);
        this.niL = (TextView) this.hfn.findViewById(R.id.vote_type_single);
        this.niM = (TextView) this.hfn.findViewById(R.id.vote_type_multiple);
        this.niN = (TextView) this.hfn.findViewById(R.id.write_vote_time);
        this.niO = (TextView) this.hfn.findViewById(R.id.vote_time_forever);
        this.niP = (TextView) this.hfn.findViewById(R.id.vote_time_1_day);
        this.niQ = (TextView) this.hfn.findViewById(R.id.vote_time_7_days);
        this.niR = (TextView) this.hfn.findViewById(R.id.vote_time_30_days);
    }

    private void dNF() {
        if (this.mWriteVoteData != null) {
            this.niJ.setText(this.mWriteVoteData.getTitle());
            this.niT = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dNI();
            dNJ();
            this.niV = dNH();
            xH(this.niU && this.niV);
        }
    }

    private void bNr() {
        this.niL.setOnClickListener(this);
        this.niM.setOnClickListener(this);
        this.niO.setOnClickListener(this);
        this.niP.setOnClickListener(this);
        this.niQ.setOnClickListener(this);
        this.niR.setOnClickListener(this);
        this.niJ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.niJ.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.niU = false;
                        b.this.xH(false);
                        return;
                    }
                    if (af.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = af.subStringWithEmoji(obj, 40);
                        b.this.niJ.setText(subStringWithEmoji);
                        b.this.niJ.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.niJ.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.niU = true;
                    b.this.xH(b.this.niV);
                }
            }
        });
        this.niG.a(new c.InterfaceC0841c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0841c
            public void dNK() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.niF.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.niG.setData(b.this.mData);
                    }
                });
                b.this.niV = b.this.dNH();
                b.this.xH(b.this.niU && b.this.niV);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0841c
            public void KA(int i) {
                b.this.mData.remove(i);
                b.this.niF.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.niG.setData(b.this.mData);
                    }
                });
                b.this.niV = b.this.dNH();
                b.this.xH(b.this.niU && b.this.niV);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0841c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.niV = b.this.dNH();
                b.this.xH(b.this.niU && b.this.niV);
            }
        });
        this.niF.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.niS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dNG = b.this.dNG();
                HashMap hashMap = new HashMap();
                int size = dNG.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dNG.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.niJ.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.niT);
                b.this.mWriteVoteData.setOptions(dNG);
                b.this.fpm = new Intent();
                b.this.fpm.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.TA(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TA(String str) {
        if (this.imW != null) {
            String str2 = this.imW.forumId;
            String str3 = this.imW.forumName;
            PostPrefixData postPrefixData = this.imW.prefixData;
            AntiData antiData = this.imW.antiData;
            int i = this.imW.forumLevel;
            String str4 = this.imW.avatar;
            int i2 = this.imW.privateThread;
            String str5 = this.imW.firstDir;
            String str6 = this.imW.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.imW.mFrom);
            writeActivityConfig.setCallFrom(this.imW.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.imW != null ? this.imW.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.imW != null ? this.imW.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qV(int i) {
        ap.setViewTextColor(this.niI, R.color.cp_cont_d);
        this.niJ.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.niJ.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.niK.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.niN.setTextColor(ap.getColor(R.color.cp_cont_b));
        if (this.niU && this.niV) {
            this.niS.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.niS.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dNI();
        dNJ();
        if (this.niG != null) {
            this.niG.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dNG() {
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
    public boolean dNH() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xH(boolean z) {
        this.niS.setEnabled(z);
        if (z) {
            this.niS.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.niS.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dNI() {
        e(this.niL, this.niT != 1);
        e(this.niM, this.niT == 1);
    }

    private void dNJ() {
        e(this.niO, this.expireType == -1);
        e(this.niP, this.expireType == 1);
        e(this.niQ, this.expireType == 7);
        e(this.niR, this.expireType == 30);
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
    public boolean bvP() {
        return this.niH != null && this.niF != null && this.niH.getTop() == 0 && this.niF.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bvQ() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bvR() {
        return this.fpm;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.niT = 0;
            dNI();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.niT = 1;
            dNI();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dNJ();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dNJ();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dNJ();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dNJ();
        }
    }
}
