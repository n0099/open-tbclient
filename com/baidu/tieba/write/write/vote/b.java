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
    private LinearLayout bSJ;
    private Intent fPu;
    private ForumWriteData iUV;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView nRX;
    private c nRY;
    private LinearLayout nRZ;
    private TextView nSa;
    private EditText nSb;
    private TextView nSc;
    private TextView nSd;
    private TextView nSe;
    private TextView nSf;
    private TextView nSg;
    private TextView nSh;
    private TextView nSi;
    private TextView nSj;
    private TextView nSk;
    private int nSl = 0;
    private int expireType = -1;
    private boolean nSm = false;
    private boolean nSn = false;

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
                this.iUV = (ForumWriteData) serializableExtra;
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
        this.nRX = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.nRX.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.nRX, layoutParams);
        this.nRY = new c(this.mPageContext);
        this.nRX.setAdapter(this.nRY);
        bCo();
        bTm();
        dBM();
        bVF();
        this.nRX.addHeaderView(this.nRZ);
        this.nRX.addFooterView(this.bSJ);
        this.nRY.setData(this.mData);
        dWY();
        this.nSb.requestFocus();
        this.nSb.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.nSb);
            }
        }, 150L);
    }

    private void bCo() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.nSk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.nSk.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.nSk.setEnabled(false);
    }

    private void bTm() {
        this.nRZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.nSa = (TextView) this.nRZ.findViewById(R.id.vote_item_tip);
        this.nSb = (EditText) this.nRZ.findViewById(R.id.vote_title);
    }

    private void dBM() {
        this.bSJ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.nSc = (TextView) this.bSJ.findViewById(R.id.write_vote_type);
        this.nSd = (TextView) this.bSJ.findViewById(R.id.vote_type_single);
        this.nSe = (TextView) this.bSJ.findViewById(R.id.vote_type_multiple);
        this.nSf = (TextView) this.bSJ.findViewById(R.id.write_vote_time);
        this.nSg = (TextView) this.bSJ.findViewById(R.id.vote_time_forever);
        this.nSh = (TextView) this.bSJ.findViewById(R.id.vote_time_1_day);
        this.nSi = (TextView) this.bSJ.findViewById(R.id.vote_time_7_days);
        this.nSj = (TextView) this.bSJ.findViewById(R.id.vote_time_30_days);
    }

    private void dWY() {
        if (this.mWriteVoteData != null) {
            this.nSb.setText(this.mWriteVoteData.getTitle());
            this.nSl = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dXb();
            dXc();
            this.nSn = dXa();
            yV(this.nSm && this.nSn);
        }
    }

    private void bVF() {
        this.nSd.setOnClickListener(this);
        this.nSe.setOnClickListener(this);
        this.nSg.setOnClickListener(this);
        this.nSh.setOnClickListener(this);
        this.nSi.setOnClickListener(this);
        this.nSj.setOnClickListener(this);
        this.nSb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.nSb.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.nSm = false;
                        b.this.yV(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.nSb.setText(subStringWithEmoji);
                        b.this.nSb.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.nSb.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.nSm = true;
                    b.this.yV(b.this.nSn);
                }
            }
        });
        this.nRY.a(new c.InterfaceC0892c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0892c
            public void dXd() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.nRX.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nRY.setData(b.this.mData);
                    }
                });
                b.this.nSn = b.this.dXa();
                b.this.yV(b.this.nSm && b.this.nSn);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0892c
            public void Mo(int i) {
                b.this.mData.remove(i);
                b.this.nRX.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nRY.setData(b.this.mData);
                    }
                });
                b.this.nSn = b.this.dXa();
                b.this.yV(b.this.nSm && b.this.nSn);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0892c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.nSn = b.this.dXa();
                b.this.yV(b.this.nSm && b.this.nSn);
            }
        });
        this.nRX.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.nSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dWZ = b.this.dWZ();
                HashMap hashMap = new HashMap();
                int size = dWZ.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dWZ.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.nSb.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.nSl);
                b.this.mWriteVoteData.setOptions(dWZ);
                b.this.fPu = new Intent();
                b.this.fPu.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.UP(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UP(String str) {
        if (this.iUV != null) {
            String str2 = this.iUV.forumId;
            String str3 = this.iUV.forumName;
            PostPrefixData postPrefixData = this.iUV.prefixData;
            AntiData antiData = this.iUV.antiData;
            int i = this.iUV.forumLevel;
            String str4 = this.iUV.avatar;
            int i2 = this.iUV.privateThread;
            String str5 = this.iUV.firstDir;
            String str6 = this.iUV.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.iUV.mFrom);
            writeActivityConfig.setCallFrom(this.iUV.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.iUV != null ? this.iUV.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.iUV != null ? this.iUV.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sm(int i) {
        ap.setViewTextColor(this.nSa, R.color.CAM_X0109);
        this.nSb.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.nSb.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.nSc.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.nSf.setTextColor(ap.getColor(R.color.CAM_X0105));
        if (this.nSm && this.nSn) {
            this.nSk.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.nSk.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
        dXb();
        dXc();
        if (this.nRY != null) {
            this.nRY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dWZ() {
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
    public boolean dXa() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV(boolean z) {
        this.nSk.setEnabled(z);
        if (z) {
            this.nSk.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.nSk.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void dXb() {
        e(this.nSd, this.nSl != 1);
        e(this.nSe, this.nSl == 1);
    }

    private void dXc() {
        e(this.nSg, this.expireType == -1);
        e(this.nSh, this.expireType == 1);
        e(this.nSi, this.expireType == 7);
        e(this.nSj, this.expireType == 30);
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
    public boolean bCk() {
        return this.nRZ != null && this.nRX != null && this.nRZ.getTop() == 0 && this.nRX.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bCl() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bCm() {
        return this.fPu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.nSl = 0;
            dXb();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.nSl = 1;
            dXb();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dXc();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dXc();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dXc();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dXc();
        }
    }
}
