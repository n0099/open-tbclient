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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes2.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout gIt;
    private ForumWriteData hLG;
    private Intent iIV;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView mxi;
    private c mxj;
    private LinearLayout mxk;
    private TextView mxl;
    private EditText mxm;
    private TextView mxn;
    private TextView mxo;
    private TextView mxp;
    private TextView mxq;
    private TextView mxr;
    private TextView mxs;
    private TextView mxt;
    private TextView mxu;
    private TextView mxv;
    private int mxw = 0;
    private int expireType = -1;
    private boolean mxx = false;
    private boolean mxy = false;

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
                this.hLG = (ForumWriteData) serializableExtra;
            }
            this.mTitle = intent.getStringExtra("title");
        }
        if (this.mWriteVoteData == null || w.isEmpty(this.mWriteVoteData.getOptions()) || this.mWriteVoteData.getOptions().size() < 2) {
            this.mData = new ArrayList();
            this.mData.add(new WriteVoteItemData());
            this.mData.add(new WriteVoteItemData());
        } else {
            this.mData = this.mWriteVoteData.getOptions();
        }
        init();
    }

    private void init() {
        this.mxi = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.mxi.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.mxi, layoutParams);
        this.mxj = new c(this.mPageContext);
        this.mxi.setAdapter(this.mxj);
        biq();
        bym();
        daB();
        bzy();
        this.mxi.addHeaderView(this.mxk);
        this.mxi.addFooterView(this.gIt);
        this.mxj.setData(this.mData);
        duy();
        this.mxm.requestFocus();
        this.mxm.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.mxm);
            }
        }, 150L);
    }

    private void biq() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.mxv = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.mxv.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.mxv.setEnabled(false);
    }

    private void bym() {
        this.mxk = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.mxl = (TextView) this.mxk.findViewById(R.id.vote_item_tip);
        this.mxm = (EditText) this.mxk.findViewById(R.id.vote_title);
    }

    private void daB() {
        this.gIt = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.mxn = (TextView) this.gIt.findViewById(R.id.write_vote_type);
        this.mxo = (TextView) this.gIt.findViewById(R.id.vote_type_single);
        this.mxp = (TextView) this.gIt.findViewById(R.id.vote_type_multiple);
        this.mxq = (TextView) this.gIt.findViewById(R.id.write_vote_time);
        this.mxr = (TextView) this.gIt.findViewById(R.id.vote_time_forever);
        this.mxs = (TextView) this.gIt.findViewById(R.id.vote_time_1_day);
        this.mxt = (TextView) this.gIt.findViewById(R.id.vote_time_7_days);
        this.mxu = (TextView) this.gIt.findViewById(R.id.vote_time_30_days);
    }

    private void duy() {
        if (this.mWriteVoteData != null) {
            this.mxm.setText(this.mWriteVoteData.getTitle());
            this.mxw = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            duB();
            duC();
            this.mxy = duA();
            wb(this.mxx && this.mxy);
        }
    }

    private void bzy() {
        this.mxo.setOnClickListener(this);
        this.mxp.setOnClickListener(this);
        this.mxr.setOnClickListener(this);
        this.mxs.setOnClickListener(this);
        this.mxt.setOnClickListener(this);
        this.mxu.setOnClickListener(this);
        this.mxm.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.mxm.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.mxx = false;
                        b.this.wb(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.mxm.setText(subStringWithEmoji);
                        b.this.mxm.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.mxm.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.mxx = true;
                    b.this.wb(b.this.mxy);
                }
            }
        });
        this.mxj.a(new c.InterfaceC0781c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0781c
            public void duD() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.mxi.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mxj.setData(b.this.mData);
                    }
                });
                b.this.mxy = b.this.duA();
                b.this.wb(b.this.mxx && b.this.mxy);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0781c
            public void Ha(int i) {
                b.this.mData.remove(i);
                b.this.mxi.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mxj.setData(b.this.mData);
                    }
                });
                b.this.mxy = b.this.duA();
                b.this.wb(b.this.mxx && b.this.mxy);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0781c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.mxy = b.this.duA();
                b.this.wb(b.this.mxx && b.this.mxy);
            }
        });
        this.mxi.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.mxv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> duz = b.this.duz();
                HashMap hashMap = new HashMap();
                int size = duz.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = duz.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.mxm.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.mxw);
                b.this.mWriteVoteData.setOptions(duz);
                b.this.iIV = new Intent();
                b.this.iIV.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                if (b.this.hLG != null) {
                    b.this.Pr(b.this.mTitle);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pr(String str) {
        String str2;
        String str3;
        int i;
        String str4;
        int i2;
        String str5;
        String str6;
        PostPrefixData postPrefixData = null;
        AntiData antiData = null;
        if (this.hLG == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.hLG.forumId;
            String str8 = this.hLG.forumName;
            postPrefixData = this.hLG.prefixData;
            antiData = this.hLG.antiData;
            int i3 = this.hLG.forumLevel;
            String str9 = this.hLG.avatar;
            int i4 = this.hLG.privateThread;
            String str10 = this.hLG.firstDir;
            str2 = this.hLG.secondDir;
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
        writeActivityConfig.setProfessionZone(this.hLG != null ? this.hLG.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.hLG != null ? this.hLG.frsTabInfo : null);
        if (this.mWriteVoteData != null) {
            writeActivityConfig.setShowVoteData(this.mWriteVoteData);
        }
        writeActivityConfig.setIntentActionActivityForwardResult();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    @Override // com.baidu.tbadk.suspended.a
    public void ob(int i) {
        an.setViewTextColor(this.mxl, (int) R.color.cp_cont_d);
        this.mxm.setHintTextColor(an.getColor(R.color.cp_cont_d));
        this.mxm.setTextColor(an.getColor(R.color.cp_cont_b));
        this.mxn.setTextColor(an.getColor(R.color.cp_cont_b));
        this.mxq.setTextColor(an.getColor(R.color.cp_cont_b));
        if (this.mxx && this.mxy) {
            this.mxv.setTextColor(an.getColor(R.color.cp_link_tip_a));
        } else {
            this.mxv.setTextColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        duB();
        duC();
        if (this.mxj != null) {
            this.mxj.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> duz() {
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
    public boolean duA() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb(boolean z) {
        this.mxv.setEnabled(z);
        if (z) {
            this.mxv.setTextColor(an.getColor(R.color.cp_link_tip_a));
        } else {
            this.mxv.setTextColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void duB() {
        e(this.mxo, this.mxw != 1);
        e(this.mxp, this.mxw == 1);
    }

    private void duC() {
        e(this.mxr, this.expireType == -1);
        e(this.mxs, this.expireType == 1);
        e(this.mxt, this.expireType == 7);
        e(this.mxu, this.expireType == 30);
    }

    private void e(TextView textView, boolean z) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mPageContext.getResources().getDimension(R.dimen.tbds10));
        if (z) {
            an.setViewTextColor(textView, (int) R.color.cp_link_tip_a);
            gradientDrawable.setColor(an.getColor(R.color.cp_btn_d));
            textView.setBackgroundDrawable(gradientDrawable);
            return;
        }
        an.setViewTextColor(textView, (int) R.color.cp_cont_b);
        gradientDrawable.setColor(an.getColor(R.color.cp_bg_line_j));
        textView.setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bim() {
        return this.mxk != null && this.mxi != null && this.mxk.getTop() == 0 && this.mxi.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bin() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bio() {
        return this.iIV;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.mxw = 0;
            duB();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.mxw = 1;
            duB();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            duC();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            duC();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            duC();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            duC();
        }
    }
}
