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
    private LinearLayout haT;
    private ForumWriteData ifV;
    private Intent jef;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView mYG;
    private c mYH;
    private LinearLayout mYI;
    private TextView mYJ;
    private EditText mYK;
    private TextView mYL;
    private TextView mYM;
    private TextView mYN;
    private TextView mYO;
    private TextView mYP;
    private TextView mYQ;
    private TextView mYR;
    private TextView mYS;
    private TextView mYT;
    private int mYU = 0;
    private int expireType = -1;
    private boolean mYV = false;
    private boolean mYW = false;

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
                this.ifV = (ForumWriteData) serializableExtra;
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
        this.mYG = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.mYG.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.mYG, layoutParams);
        this.mYH = new c(this.mPageContext);
        this.mYG.setAdapter(this.mYH);
        buP();
        bKV();
        dpd();
        bMh();
        this.mYG.addHeaderView(this.mYI);
        this.mYG.addFooterView(this.haT);
        this.mYH.setData(this.mData);
        dJH();
        this.mYK.requestFocus();
        this.mYK.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.mYK);
            }
        }, 150L);
    }

    private void buP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.mYT = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.mYT.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.mYT.setEnabled(false);
    }

    private void bKV() {
        this.mYI = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.mYJ = (TextView) this.mYI.findViewById(R.id.vote_item_tip);
        this.mYK = (EditText) this.mYI.findViewById(R.id.vote_title);
    }

    private void dpd() {
        this.haT = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.mYL = (TextView) this.haT.findViewById(R.id.write_vote_type);
        this.mYM = (TextView) this.haT.findViewById(R.id.vote_type_single);
        this.mYN = (TextView) this.haT.findViewById(R.id.vote_type_multiple);
        this.mYO = (TextView) this.haT.findViewById(R.id.write_vote_time);
        this.mYP = (TextView) this.haT.findViewById(R.id.vote_time_forever);
        this.mYQ = (TextView) this.haT.findViewById(R.id.vote_time_1_day);
        this.mYR = (TextView) this.haT.findViewById(R.id.vote_time_7_days);
        this.mYS = (TextView) this.haT.findViewById(R.id.vote_time_30_days);
    }

    private void dJH() {
        if (this.mWriteVoteData != null) {
            this.mYK.setText(this.mWriteVoteData.getTitle());
            this.mYU = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dJK();
            dJL();
            this.mYW = dJJ();
            xy(this.mYV && this.mYW);
        }
    }

    private void bMh() {
        this.mYM.setOnClickListener(this);
        this.mYN.setOnClickListener(this);
        this.mYP.setOnClickListener(this);
        this.mYQ.setOnClickListener(this);
        this.mYR.setOnClickListener(this);
        this.mYS.setOnClickListener(this);
        this.mYK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.mYK.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.mYV = false;
                        b.this.xy(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.mYK.setText(subStringWithEmoji);
                        b.this.mYK.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.mYK.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.mYV = true;
                    b.this.xy(b.this.mYW);
                }
            }
        });
        this.mYH.a(new c.InterfaceC0844c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0844c
            public void dJM() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.mYG.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mYH.setData(b.this.mData);
                    }
                });
                b.this.mYW = b.this.dJJ();
                b.this.xy(b.this.mYV && b.this.mYW);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0844c
            public void JV(int i) {
                b.this.mData.remove(i);
                b.this.mYG.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mYH.setData(b.this.mData);
                    }
                });
                b.this.mYW = b.this.dJJ();
                b.this.xy(b.this.mYV && b.this.mYW);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0844c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.mYW = b.this.dJJ();
                b.this.xy(b.this.mYV && b.this.mYW);
            }
        });
        this.mYG.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.mYT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dJI = b.this.dJI();
                HashMap hashMap = new HashMap();
                int size = dJI.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dJI.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.mYK.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.mYU);
                b.this.mWriteVoteData.setOptions(dJI);
                b.this.jef = new Intent();
                b.this.jef.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                if (b.this.ifV != null) {
                    b.this.Tb(b.this.mTitle);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tb(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.ifV == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.ifV.forumId;
            String str8 = this.ifV.forumName;
            postPrefixData = this.ifV.prefixData;
            antiData = this.ifV.antiData;
            int i3 = this.ifV.forumLevel;
            String str9 = this.ifV.avatar;
            int i4 = this.ifV.privateThread;
            String str10 = this.ifV.firstDir;
            str2 = this.ifV.secondDir;
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
        writeActivityConfig.setProfessionZone(this.ifV != null ? this.ifV.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.ifV != null ? this.ifV.frsTabInfo : null);
        if (this.mWriteVoteData != null) {
            writeActivityConfig.setShowVoteData(this.mWriteVoteData);
        }
        writeActivityConfig.setIntentActionActivityForwardResult();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
        ap.setViewTextColor(this.mYJ, R.color.cp_cont_d);
        this.mYK.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.mYK.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.mYL.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.mYO.setTextColor(ap.getColor(R.color.cp_cont_b));
        if (this.mYV && this.mYW) {
            this.mYT.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.mYT.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dJK();
        dJL();
        if (this.mYH != null) {
            this.mYH.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dJI() {
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
    public boolean dJJ() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xy(boolean z) {
        this.mYT.setEnabled(z);
        if (z) {
            this.mYT.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.mYT.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dJK() {
        e(this.mYM, this.mYU != 1);
        e(this.mYN, this.mYU == 1);
    }

    private void dJL() {
        e(this.mYP, this.expireType == -1);
        e(this.mYQ, this.expireType == 1);
        e(this.mYR, this.expireType == 7);
        e(this.mYS, this.expireType == 30);
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
    public boolean buL() {
        return this.mYI != null && this.mYG != null && this.mYI.getTop() == 0 && this.mYG.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buN() {
        return this.jef;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.mYU = 0;
            dJK();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.mYU = 1;
            dJK();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dJL();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dJL();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dJL();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dJL();
        }
    }
}
