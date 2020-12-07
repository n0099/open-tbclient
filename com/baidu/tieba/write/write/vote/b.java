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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ae;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.vote.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout bXZ;
    private Intent fXD;
    private ForumWriteData jfR;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView ogV;
    private c ogW;
    private LinearLayout ogX;
    private TextView ogY;
    private EditText ogZ;
    private TextView oha;
    private TextView ohb;
    private TextView ohc;
    private TextView ohd;
    private TextView ohe;
    private TextView ohf;
    private TextView ohg;
    private TextView ohh;
    private TextView ohi;
    private int ohj = 0;
    private int expireType = -1;
    private boolean ohk = false;
    private boolean ohl = false;

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
                this.jfR = (ForumWriteData) serializableExtra;
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
        this.ogV = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.ogV.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.ogV, layoutParams);
        this.ogW = new c(this.mPageContext);
        this.ogV.setAdapter(this.ogW);
        bFP();
        bWW();
        dGX();
        bZp();
        this.ogV.addHeaderView(this.ogX);
        this.ogV.addFooterView(this.bXZ);
        this.ogW.setData(this.mData);
        ecC();
        this.ogZ.requestFocus();
        this.ogZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.ogZ);
            }
        }, 150L);
    }

    private void bFP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.ohi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.ohi.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.ohi.setEnabled(false);
    }

    private void bWW() {
        this.ogX = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.ogY = (TextView) this.ogX.findViewById(R.id.vote_item_tip);
        this.ogZ = (EditText) this.ogX.findViewById(R.id.vote_title);
    }

    private void dGX() {
        this.bXZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.oha = (TextView) this.bXZ.findViewById(R.id.write_vote_type);
        this.ohb = (TextView) this.bXZ.findViewById(R.id.vote_type_single);
        this.ohc = (TextView) this.bXZ.findViewById(R.id.vote_type_multiple);
        this.ohd = (TextView) this.bXZ.findViewById(R.id.write_vote_time);
        this.ohe = (TextView) this.bXZ.findViewById(R.id.vote_time_forever);
        this.ohf = (TextView) this.bXZ.findViewById(R.id.vote_time_1_day);
        this.ohg = (TextView) this.bXZ.findViewById(R.id.vote_time_7_days);
        this.ohh = (TextView) this.bXZ.findViewById(R.id.vote_time_30_days);
    }

    private void ecC() {
        if (this.mWriteVoteData != null) {
            this.ogZ.setText(this.mWriteVoteData.getTitle());
            this.ohj = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            ecF();
            ecG();
            this.ohl = ecE();
            zz(this.ohk && this.ohl);
        }
    }

    private void bZp() {
        this.ohb.setOnClickListener(this);
        this.ohc.setOnClickListener(this);
        this.ohe.setOnClickListener(this);
        this.ohf.setOnClickListener(this);
        this.ohg.setOnClickListener(this);
        this.ohh.setOnClickListener(this);
        this.ogZ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.ogZ.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.ohk = false;
                        b.this.zz(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.ogZ.setText(subStringWithEmoji);
                        b.this.ogZ.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.ogZ.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.ohk = true;
                    b.this.zz(b.this.ohl);
                }
            }
        });
        this.ogW.a(new c.InterfaceC0909c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0909c
            public void ecH() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.ogV.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ogW.setData(b.this.mData);
                    }
                });
                b.this.ohl = b.this.ecE();
                b.this.zz(b.this.ohk && b.this.ohl);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0909c
            public void Ng(int i) {
                b.this.mData.remove(i);
                b.this.ogV.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ogW.setData(b.this.mData);
                    }
                });
                b.this.ohl = b.this.ecE();
                b.this.zz(b.this.ohk && b.this.ohl);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0909c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.ohl = b.this.ecE();
                b.this.zz(b.this.ohk && b.this.ohl);
            }
        });
        this.ogV.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.ohi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> ecD = b.this.ecD();
                HashMap hashMap = new HashMap();
                int size = ecD.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = ecD.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.ogZ.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.ohj);
                b.this.mWriteVoteData.setOptions(ecD);
                b.this.fXD = new Intent();
                b.this.fXD.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.We(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We(String str) {
        if (this.jfR != null) {
            String str2 = this.jfR.forumId;
            String str3 = this.jfR.forumName;
            PostPrefixData postPrefixData = this.jfR.prefixData;
            AntiData antiData = this.jfR.antiData;
            int i = this.jfR.forumLevel;
            String str4 = this.jfR.avatar;
            int i2 = this.jfR.privateThread;
            String str5 = this.jfR.firstDir;
            String str6 = this.jfR.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.jfR.mFrom);
            writeActivityConfig.setCallFrom(this.jfR.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.jfR != null ? this.jfR.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.jfR != null ? this.jfR.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
        ap.setViewTextColor(this.ogY, R.color.CAM_X0109);
        this.ogZ.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.ogZ.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.oha.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.ohd.setTextColor(ap.getColor(R.color.CAM_X0105));
        if (this.ohk && this.ohl) {
            this.ohi.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ohi.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
        ecF();
        ecG();
        if (this.ogW != null) {
            this.ogW.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> ecD() {
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
    public boolean ecE() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zz(boolean z) {
        this.ohi.setEnabled(z);
        if (z) {
            this.ohi.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ohi.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void ecF() {
        e(this.ohb, this.ohj != 1);
        e(this.ohc, this.ohj == 1);
    }

    private void ecG() {
        e(this.ohe, this.expireType == -1);
        e(this.ohf, this.expireType == 1);
        e(this.ohg, this.expireType == 7);
        e(this.ohh, this.expireType == 30);
    }

    private void e(TextView textView, boolean z) {
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
    public boolean bFL() {
        return this.ogX != null && this.ogV != null && this.ogX.getTop() == 0 && this.ogV.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXD;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.ohj = 0;
            ecF();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.ohj = 1;
            ecF();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            ecG();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            ecG();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            ecG();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            ecG();
        }
    }
}
