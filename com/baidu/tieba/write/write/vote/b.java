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
    private ForumWriteData hRF;
    private Intent iPa;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private TextView mFA;
    private BdRecyclerView mFn;
    private c mFo;
    private LinearLayout mFp;
    private TextView mFq;
    private EditText mFr;
    private TextView mFs;
    private TextView mFt;
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
    private int mFB = 0;
    private int expireType = -1;
    private boolean mFC = false;
    private boolean mFD = false;

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
                this.hRF = (ForumWriteData) serializableExtra;
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
        this.mFn = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.mFn.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.mFn, layoutParams);
        this.mFo = new c(this.mPageContext);
        this.mFn.setAdapter(this.mFo);
        bmb();
        bBA();
        ddI();
        bCM();
        this.mFn.addHeaderView(this.mFp);
        this.mFn.addFooterView(this.gNZ);
        this.mFo.setData(this.mData);
        dxK();
        this.mFr.requestFocus();
        this.mFr.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.mFr);
            }
        }, 150L);
    }

    private void bmb() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.mFA = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.mFA.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.mFA.setEnabled(false);
    }

    private void bBA() {
        this.mFp = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.mFq = (TextView) this.mFp.findViewById(R.id.vote_item_tip);
        this.mFr = (EditText) this.mFp.findViewById(R.id.vote_title);
    }

    private void ddI() {
        this.gNZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.mFs = (TextView) this.gNZ.findViewById(R.id.write_vote_type);
        this.mFt = (TextView) this.gNZ.findViewById(R.id.vote_type_single);
        this.mFu = (TextView) this.gNZ.findViewById(R.id.vote_type_multiple);
        this.mFv = (TextView) this.gNZ.findViewById(R.id.write_vote_time);
        this.mFw = (TextView) this.gNZ.findViewById(R.id.vote_time_forever);
        this.mFx = (TextView) this.gNZ.findViewById(R.id.vote_time_1_day);
        this.mFy = (TextView) this.gNZ.findViewById(R.id.vote_time_7_days);
        this.mFz = (TextView) this.gNZ.findViewById(R.id.vote_time_30_days);
    }

    private void dxK() {
        if (this.mWriteVoteData != null) {
            this.mFr.setText(this.mWriteVoteData.getTitle());
            this.mFB = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dxN();
            dxO();
            this.mFD = dxM();
            wG(this.mFC && this.mFD);
        }
    }

    private void bCM() {
        this.mFt.setOnClickListener(this);
        this.mFu.setOnClickListener(this);
        this.mFw.setOnClickListener(this);
        this.mFx.setOnClickListener(this);
        this.mFy.setOnClickListener(this);
        this.mFz.setOnClickListener(this);
        this.mFr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.mFr.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.mFC = false;
                        b.this.wG(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.mFr.setText(subStringWithEmoji);
                        b.this.mFr.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.mFr.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.mFC = true;
                    b.this.wG(b.this.mFD);
                }
            }
        });
        this.mFo.a(new c.InterfaceC0791c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0791c
            public void dxP() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.mFn.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mFo.setData(b.this.mData);
                    }
                });
                b.this.mFD = b.this.dxM();
                b.this.wG(b.this.mFC && b.this.mFD);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0791c
            public void Hv(int i) {
                b.this.mData.remove(i);
                b.this.mFn.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mFo.setData(b.this.mData);
                    }
                });
                b.this.mFD = b.this.dxM();
                b.this.wG(b.this.mFC && b.this.mFD);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0791c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.mFD = b.this.dxM();
                b.this.wG(b.this.mFC && b.this.mFD);
            }
        });
        this.mFn.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.mFA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dxL = b.this.dxL();
                HashMap hashMap = new HashMap();
                int size = dxL.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dxL.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.mFr.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.mFB);
                b.this.mWriteVoteData.setOptions(dxL);
                b.this.iPa = new Intent();
                b.this.iPa.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                if (b.this.hRF != null) {
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
        if (this.hRF == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hRF.forumId;
            String str8 = this.hRF.forumName;
            postPrefixData = this.hRF.prefixData;
            antiData = this.hRF.antiData;
            int i3 = this.hRF.forumLevel;
            String str9 = this.hRF.avatar;
            int i4 = this.hRF.privateThread;
            String str10 = this.hRF.firstDir;
            str2 = this.hRF.secondDir;
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
        writeActivityConfig.setProfessionZone(this.hRF != null ? this.hRF.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hRF != null ? this.hRF.frsTabInfo : null);
        if (this.mWriteVoteData != null) {
            writeActivityConfig.setShowVoteData(this.mWriteVoteData);
        }
        writeActivityConfig.setIntentActionActivityForwardResult();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ot(int i) {
        ao.setViewTextColor(this.mFq, R.color.cp_cont_d);
        this.mFr.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        this.mFr.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.mFs.setTextColor(ao.getColor(R.color.cp_cont_b));
        this.mFv.setTextColor(ao.getColor(R.color.cp_cont_b));
        if (this.mFC && this.mFD) {
            this.mFA.setTextColor(ao.getColor(R.color.cp_link_tip_a));
        } else {
            this.mFA.setTextColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dxN();
        dxO();
        if (this.mFo != null) {
            this.mFo.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dxL() {
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
    public boolean dxM() {
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
        this.mFA.setEnabled(z);
        if (z) {
            this.mFA.setTextColor(ao.getColor(R.color.cp_link_tip_a));
        } else {
            this.mFA.setTextColor(com.baidu.tieba.tbadkCore.c.l(ao.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dxN() {
        e(this.mFt, this.mFB != 1);
        e(this.mFu, this.mFB == 1);
    }

    private void dxO() {
        e(this.mFw, this.expireType == -1);
        e(this.mFx, this.expireType == 1);
        e(this.mFy, this.expireType == 7);
        e(this.mFz, this.expireType == 30);
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
        return this.mFp != null && this.mFn != null && this.mFp.getTop() == 0 && this.mFn.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean blY() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent blZ() {
        return this.iPa;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.mFB = 0;
            dxN();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.mFB = 1;
            dxN();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dxO();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dxO();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dxO();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dxO();
        }
    }
}
