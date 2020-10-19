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
    private Intent fBA;
    private LinearLayout huq;
    private ForumWriteData iBQ;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView nyc;
    private c nyd;
    private LinearLayout nye;
    private TextView nyf;
    private EditText nyg;
    private TextView nyh;
    private TextView nyi;
    private TextView nyj;
    private TextView nyk;
    private TextView nyl;
    private TextView nym;
    private TextView nyn;
    private TextView nyo;
    private TextView nyp;
    private int nyq = 0;
    private int expireType = -1;
    private boolean nyr = false;
    private boolean nys = false;

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
                this.iBQ = (ForumWriteData) serializableExtra;
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
        this.nyc = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.nyc.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.nyc, layoutParams);
        this.nyd = new c(this.mPageContext);
        this.nyc.setAdapter(this.nyd);
        byD();
        bOP();
        dwy();
        bQI();
        this.nyc.addHeaderView(this.nye);
        this.nyc.addFooterView(this.huq);
        this.nyd.setData(this.mData);
        dRr();
        this.nyg.requestFocus();
        this.nyg.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.nyg);
            }
        }, 150L);
    }

    private void byD() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.nyp = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.nyp.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.nyp.setEnabled(false);
    }

    private void bOP() {
        this.nye = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.nyf = (TextView) this.nye.findViewById(R.id.vote_item_tip);
        this.nyg = (EditText) this.nye.findViewById(R.id.vote_title);
    }

    private void dwy() {
        this.huq = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.nyh = (TextView) this.huq.findViewById(R.id.write_vote_type);
        this.nyi = (TextView) this.huq.findViewById(R.id.vote_type_single);
        this.nyj = (TextView) this.huq.findViewById(R.id.vote_type_multiple);
        this.nyk = (TextView) this.huq.findViewById(R.id.write_vote_time);
        this.nyl = (TextView) this.huq.findViewById(R.id.vote_time_forever);
        this.nym = (TextView) this.huq.findViewById(R.id.vote_time_1_day);
        this.nyn = (TextView) this.huq.findViewById(R.id.vote_time_7_days);
        this.nyo = (TextView) this.huq.findViewById(R.id.vote_time_30_days);
    }

    private void dRr() {
        if (this.mWriteVoteData != null) {
            this.nyg.setText(this.mWriteVoteData.getTitle());
            this.nyq = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dRu();
            dRv();
            this.nys = dRt();
            yo(this.nyr && this.nys);
        }
    }

    private void bQI() {
        this.nyi.setOnClickListener(this);
        this.nyj.setOnClickListener(this);
        this.nyl.setOnClickListener(this);
        this.nym.setOnClickListener(this);
        this.nyn.setOnClickListener(this);
        this.nyo.setOnClickListener(this);
        this.nyg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.nyg.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.nyr = false;
                        b.this.yo(false);
                        return;
                    }
                    if (af.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = af.subStringWithEmoji(obj, 40);
                        b.this.nyg.setText(subStringWithEmoji);
                        b.this.nyg.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.nyg.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.nyr = true;
                    b.this.yo(b.this.nys);
                }
            }
        });
        this.nyd.a(new c.InterfaceC0859c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0859c
            public void dRw() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.nyc.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nyd.setData(b.this.mData);
                    }
                });
                b.this.nys = b.this.dRt();
                b.this.yo(b.this.nyr && b.this.nys);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0859c
            public void Lg(int i) {
                b.this.mData.remove(i);
                b.this.nyc.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.nyd.setData(b.this.mData);
                    }
                });
                b.this.nys = b.this.dRt();
                b.this.yo(b.this.nyr && b.this.nys);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0859c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.nys = b.this.dRt();
                b.this.yo(b.this.nyr && b.this.nys);
            }
        });
        this.nyc.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.nyp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dRs = b.this.dRs();
                HashMap hashMap = new HashMap();
                int size = dRs.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dRs.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.nyg.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.nyq);
                b.this.mWriteVoteData.setOptions(dRs);
                b.this.fBA = new Intent();
                b.this.fBA.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.Uo(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uo(String str) {
        if (this.iBQ != null) {
            String str2 = this.iBQ.forumId;
            String str3 = this.iBQ.forumName;
            PostPrefixData postPrefixData = this.iBQ.prefixData;
            AntiData antiData = this.iBQ.antiData;
            int i = this.iBQ.forumLevel;
            String str4 = this.iBQ.avatar;
            int i2 = this.iBQ.privateThread;
            String str5 = this.iBQ.firstDir;
            String str6 = this.iBQ.secondDir;
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(this.mPageContext.getPageActivity(), 9, str2, str3, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", this.iBQ.mFrom);
            writeActivityConfig.setCallFrom(this.iBQ.writeCallFrom);
            if (!StringUtils.isNull(str)) {
                writeActivityConfig.setTitle(str, true);
            }
            writeActivityConfig.setForumLevel(i);
            writeActivityConfig.setForumAvatar(str4);
            writeActivityConfig.setPrivateThread(i2);
            writeActivityConfig.setForumDir(str5, str6);
            writeActivityConfig.setProfessionZone(this.iBQ != null ? this.iBQ.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(this.iBQ != null ? this.iBQ.frsTabInfo : null);
            if (this.mWriteVoteData != null) {
                writeActivityConfig.setShowVoteData(this.mWriteVoteData);
            }
            writeActivityConfig.setIntentActionActivityForwardResult();
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rt(int i) {
        ap.setViewTextColor(this.nyf, R.color.cp_cont_d);
        this.nyg.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.nyg.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.nyh.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.nyk.setTextColor(ap.getColor(R.color.cp_cont_b));
        if (this.nyr && this.nys) {
            this.nyp.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.nyp.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dRu();
        dRv();
        if (this.nyd != null) {
            this.nyd.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dRs() {
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
    public boolean dRt() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yo(boolean z) {
        this.nyp.setEnabled(z);
        if (z) {
            this.nyp.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.nyp.setTextColor(com.baidu.tieba.tbadkCore.c.m(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dRu() {
        e(this.nyi, this.nyq != 1);
        e(this.nyj, this.nyq == 1);
    }

    private void dRv() {
        e(this.nyl, this.expireType == -1);
        e(this.nym, this.expireType == 1);
        e(this.nyn, this.expireType == 7);
        e(this.nyo, this.expireType == 30);
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
    public boolean byz() {
        return this.nye != null && this.nyc != null && this.nye.getTop() == 0 && this.nyc.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean byA() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent byB() {
        return this.fBA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.nyq = 0;
            dRu();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.nyq = 1;
            dRu();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dRv();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dRv();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dRv();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dRv();
        }
    }
}
