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
    private Intent fXF;
    private ForumWriteData jfT;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView ogX;
    private c ogY;
    private LinearLayout ogZ;
    private TextView oha;
    private EditText ohb;
    private TextView ohc;
    private TextView ohd;
    private TextView ohe;
    private TextView ohf;
    private TextView ohg;
    private TextView ohh;
    private TextView ohi;
    private TextView ohj;
    private TextView ohk;
    private int ohl = 0;
    private int expireType = -1;
    private boolean ohm = false;
    private boolean ohn = false;

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
                this.jfT = (ForumWriteData) serializableExtra;
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
        this.ogX = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.ogX.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.ogX, layoutParams);
        this.ogY = new c(this.mPageContext);
        this.ogX.setAdapter(this.ogY);
        bFP();
        bWX();
        dGY();
        bZq();
        this.ogX.addHeaderView(this.ogZ);
        this.ogX.addFooterView(this.bXZ);
        this.ogY.setData(this.mData);
        ecD();
        this.ohb.requestFocus();
        this.ohb.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.ohb);
            }
        }, 150L);
    }

    private void bFP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.ohk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.ohk.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.ohk.setEnabled(false);
    }

    private void bWX() {
        this.ogZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.oha = (TextView) this.ogZ.findViewById(R.id.vote_item_tip);
        this.ohb = (EditText) this.ogZ.findViewById(R.id.vote_title);
    }

    private void dGY() {
        this.bXZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.ohc = (TextView) this.bXZ.findViewById(R.id.write_vote_type);
        this.ohd = (TextView) this.bXZ.findViewById(R.id.vote_type_single);
        this.ohe = (TextView) this.bXZ.findViewById(R.id.vote_type_multiple);
        this.ohf = (TextView) this.bXZ.findViewById(R.id.write_vote_time);
        this.ohg = (TextView) this.bXZ.findViewById(R.id.vote_time_forever);
        this.ohh = (TextView) this.bXZ.findViewById(R.id.vote_time_1_day);
        this.ohi = (TextView) this.bXZ.findViewById(R.id.vote_time_7_days);
        this.ohj = (TextView) this.bXZ.findViewById(R.id.vote_time_30_days);
    }

    private void ecD() {
        if (this.mWriteVoteData != null) {
            this.ohb.setText(this.mWriteVoteData.getTitle());
            this.ohl = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            ecG();
            ecH();
            this.ohn = ecF();
            zz(this.ohm && this.ohn);
        }
    }

    private void bZq() {
        this.ohd.setOnClickListener(this);
        this.ohe.setOnClickListener(this);
        this.ohg.setOnClickListener(this);
        this.ohh.setOnClickListener(this);
        this.ohi.setOnClickListener(this);
        this.ohj.setOnClickListener(this);
        this.ohb.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.ohb.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.ohm = false;
                        b.this.zz(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.ohb.setText(subStringWithEmoji);
                        b.this.ohb.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.ohb.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.ohm = true;
                    b.this.zz(b.this.ohn);
                }
            }
        });
        this.ogY.a(new c.InterfaceC0909c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0909c
            public void ecI() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.ogX.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ogY.setData(b.this.mData);
                    }
                });
                b.this.ohn = b.this.ecF();
                b.this.zz(b.this.ohm && b.this.ohn);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0909c
            public void Ng(int i) {
                b.this.mData.remove(i);
                b.this.ogX.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.ogY.setData(b.this.mData);
                    }
                });
                b.this.ohn = b.this.ecF();
                b.this.zz(b.this.ohm && b.this.ohn);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0909c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.ohn = b.this.ecF();
                b.this.zz(b.this.ohm && b.this.ohn);
            }
        });
        this.ogX.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.ohk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> ecE = b.this.ecE();
                HashMap hashMap = new HashMap();
                int size = ecE.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = ecE.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.ohb.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.ohl);
                b.this.mWriteVoteData.setOptions(ecE);
                b.this.fXF = new Intent();
                b.this.fXF.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.We(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void We(String str) {
        if (this.jfT != null) {
            String str2 = this.jfT.forumId;
            String str3 = this.jfT.forumName;
            PostPrefixData postPrefixData = this.jfT.prefixData;
            AntiData antiData = this.jfT.antiData;
            int i = this.jfT.forumLevel;
            String str4 = this.jfT.avatar;
            int i2 = this.jfT.privateThread;
            String str5 = this.jfT.firstDir;
            String str6 = this.jfT.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.jfT.mFrom);
            writeActivityConfig.setCallFrom(this.jfT.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.jfT != null ? this.jfT.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.jfT != null ? this.jfT.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void sN(int i) {
        ap.setViewTextColor(this.oha, R.color.CAM_X0109);
        this.ohb.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.ohb.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.ohc.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.ohf.setTextColor(ap.getColor(R.color.CAM_X0105));
        if (this.ohm && this.ohn) {
            this.ohk.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ohk.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
        ecG();
        ecH();
        if (this.ogY != null) {
            this.ogY.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> ecE() {
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
    public boolean ecF() {
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
        this.ohk.setEnabled(z);
        if (z) {
            this.ohk.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ohk.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void ecG() {
        e(this.ohd, this.ohl != 1);
        e(this.ohe, this.ohl == 1);
    }

    private void ecH() {
        e(this.ohg, this.expireType == -1);
        e(this.ohh, this.expireType == 1);
        e(this.ohi, this.expireType == 7);
        e(this.ohj, this.expireType == 30);
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
        return this.ogZ != null && this.ogX != null && this.ogZ.getTop() == 0 && this.ogX.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bFM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bFN() {
        return this.fXF;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.ohl = 0;
            ecG();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.ohl = 1;
            ecG();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            ecH();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            ecH();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            ecH();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            ecH();
        }
    }
}
