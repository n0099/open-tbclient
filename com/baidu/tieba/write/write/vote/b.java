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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
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
    private LinearLayout gNZ;
    private ForumWriteData hRH;
    private Intent iPc;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private TextView mFA;
    private TextView mFB;
    private TextView mFC;
    private BdRecyclerView mFp;
    private c mFq;
    private LinearLayout mFr;
    private TextView mFs;
    private EditText mFt;
    private TextView mFu;
    private TextView mFv;
    private TextView mFw;
    private TextView mFx;
    private TextView mFy;
    private TextView mFz;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private int mFD = 0;
    private int expireType = -1;
    private boolean mFE = false;
    private boolean mFF = false;

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
                this.hRH = (ForumWriteData) serializableExtra;
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
        this.mFp = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.mFp.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.mFp, layoutParams);
        this.mFq = new c(this.mPageContext);
        this.mFp.setAdapter(this.mFq);
        bmb();
        bBA();
        ddI();
        bCM();
        this.mFp.addHeaderView(this.mFr);
        this.mFp.addFooterView(this.gNZ);
        this.mFq.setData(this.mData);
        dxL();
        this.mFt.requestFocus();
        this.mFt.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.mFt);
            }
        }, 150L);
    }

    private void bmb() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.mFC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.mFC.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.mFC.setEnabled(false);
    }

    private void bBA() {
        this.mFr = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.mFs = (TextView) this.mFr.findViewById(R.id.vote_item_tip);
        this.mFt = (EditText) this.mFr.findViewById(R.id.vote_title);
    }

    private void ddI() {
        this.gNZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.mFu = (TextView) this.gNZ.findViewById(R.id.write_vote_type);
        this.mFv = (TextView) this.gNZ.findViewById(R.id.vote_type_single);
        this.mFw = (TextView) this.gNZ.findViewById(R.id.vote_type_multiple);
        this.mFx = (TextView) this.gNZ.findViewById(R.id.write_vote_time);
        this.mFy = (TextView) this.gNZ.findViewById(R.id.vote_time_forever);
        this.mFz = (TextView) this.gNZ.findViewById(R.id.vote_time_1_day);
        this.mFA = (TextView) this.gNZ.findViewById(R.id.vote_time_7_days);
        this.mFB = (TextView) this.gNZ.findViewById(R.id.vote_time_30_days);
    }

    private void dxL() {
        if (this.mWriteVoteData != null) {
            this.mFt.setText(this.mWriteVoteData.getTitle());
            this.mFD = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dxO();
            dxP();
            this.mFF = dxN();
            wG(this.mFE && this.mFF);
        }
    }

    private void bCM() {
        this.mFv.setOnClickListener(this);
        this.mFw.setOnClickListener(this);
        this.mFy.setOnClickListener(this);
        this.mFz.setOnClickListener(this);
        this.mFA.setOnClickListener(this);
        this.mFB.setOnClickListener(this);
        this.mFt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.mFt.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.mFE = false;
                        b.this.wG(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.mFt.setText(subStringWithEmoji);
                        b.this.mFt.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.mFt.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.mFE = true;
                    b.this.wG(b.this.mFF);
                }
            }
        });
        this.mFq.a(new c.InterfaceC0791c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0791c
            public void dxQ() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.mFp.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mFq.setData(b.this.mData);
                    }
                });
                b.this.mFF = b.this.dxN();
                b.this.wG(b.this.mFE && b.this.mFF);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0791c
            public void Hv(int i) {
                b.this.mData.remove(i);
                b.this.mFp.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mFq.setData(b.this.mData);
                    }
                });
                b.this.mFF = b.this.dxN();
                b.this.wG(b.this.mFE && b.this.mFF);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0791c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.mFF = b.this.dxN();
                b.this.wG(b.this.mFE && b.this.mFF);
            }
        });
        this.mFp.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.mFC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dxM = b.this.dxM();
                HashMap hashMap = new HashMap();
                int size = dxM.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dxM.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.mFt.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.mFD);
                b.this.mWriteVoteData.setOptions(dxM);
                b.this.iPc = new Intent();
                b.this.iPc.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                if (b.this.hRH != null) {
                    b.this.Qc(b.this.mTitle);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qc(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hRH == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hRH.forumId;
            String str8 = this.hRH.forumName;
            postPrefixData = this.hRH.prefixData;
            antiData = this.hRH.antiData;
            int i3 = this.hRH.forumLevel;
            String str9 = this.hRH.avatar;
            int i4 = this.hRH.privateThread;
            String str10 = this.hRH.firstDir;
            str2 = this.hRH.secondDir;
            str3 = str10;
            i = i4;
            str4 = str9;
            i2 = i3;
            str5 = str8;
            str6 = str7;
        }
        WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str6, str5, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
        writeActivityConfig.getIntent().putExtra("from", "frs");
        writeActivityConfig.setCallFrom("2");
        if (!StringUtils.isNull(str)) {
            writeActivityConfig.setTitle(str, true);
        }
        writeActivityConfig.setForumLevel(i2);
        writeActivityConfig.setForumAvatar(str4);
        writeActivityConfig.setPrivateThread(i);
        writeActivityConfig.setForumDir(str3, str2);
        writeActivityConfig.setProfessionZone(this.hRH != null ? this.hRH.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hRH != null ? this.hRH.frsTabInfo : null);
        if (this.mWriteVoteData != null) {
            writeActivityConfig.setShowVoteData(this.mWriteVoteData);
        }
        writeActivityConfig.setIntentActionActivityForwardResult();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ot(int i) {
        ao.setViewTextColor(this.mFs, R.color.cp_cont_d);
        this.mFt.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        this.mFt.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.mFu.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.mFx.setTextColor(ao.getColor(R.color.cp_cont_b));
        if (this.mFE && this.mFF) {
            this.mFC.setTextColor(ao.getColor(R.color.cp_link_tip_a));
        } else {
            this.mFC.setTextColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dxO();
        dxP();
        if (this.mFq != null) {
            this.mFq.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dxM() {
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
    public boolean dxN() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wG(boolean z) {
        this.mFC.setEnabled(z);
        if (z) {
            this.mFC.setTextColor(ao.getColor(R.color.cp_link_tip_a));
        } else {
            this.mFC.setTextColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dxO() {
        e(this.mFv, this.mFD != 1);
        e(this.mFw, this.mFD == 1);
    }

    private void dxP() {
        e(this.mFy, this.expireType == -1);
        e(this.mFz, this.expireType == 1);
        e(this.mFA, this.expireType == 7);
        e(this.mFB, this.expireType == 30);
    }

    private void e(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
        if (z) {
            ao.setViewTextColor(textView, R.color.cp_link_tip_a);
            gradientDrawable.setColor(ao.getColor(R.color.cp_btn_d));
            textView.setBackgroundDrawable(gradientDrawable);
            return;
        }
        ao.setViewTextColor(textView, R.color.cp_cont_b);
        gradientDrawable.setColor(ao.getColor(R.color.cp_bg_line_j));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blX() {
        return this.mFr != null && this.mFp != null && this.mFr.getTop() == 0 && this.mFp.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blY() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent blZ() {
        return this.iPc;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.mFD = 0;
            dxO();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.mFD = 1;
            dxO();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dxP();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dxP();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dxP();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dxP();
        }
    }
}
