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
    private BdRecyclerView mxf;
    private c mxg;
    private LinearLayout mxh;
    private TextView mxi;
    private EditText mxj;
    private TextView mxk;
    private TextView mxl;
    private TextView mxm;
    private TextView mxn;
    private TextView mxo;
    private TextView mxp;
    private TextView mxq;
    private TextView mxr;
    private TextView mxs;
    private int mxt = 0;
    private int expireType = -1;
    private boolean mxu = false;
    private boolean mxv = false;

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
        this.mxf = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.mxf.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.mxf, layoutParams);
        this.mxg = new c(this.mPageContext);
        this.mxf.setAdapter(this.mxg);
        biq();
        byl();
        daA();
        bzx();
        this.mxf.addHeaderView(this.mxh);
        this.mxf.addFooterView(this.gIt);
        this.mxg.setData(this.mData);
        duu();
        this.mxj.requestFocus();
        this.mxj.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.mxj);
            }
        }, 150L);
    }

    private void biq() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.mxs = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.mxs.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.mxs.setEnabled(false);
    }

    private void byl() {
        this.mxh = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.mxi = (TextView) this.mxh.findViewById(R.id.vote_item_tip);
        this.mxj = (EditText) this.mxh.findViewById(R.id.vote_title);
    }

    private void daA() {
        this.gIt = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.mxk = (TextView) this.gIt.findViewById(R.id.write_vote_type);
        this.mxl = (TextView) this.gIt.findViewById(R.id.vote_type_single);
        this.mxm = (TextView) this.gIt.findViewById(R.id.vote_type_multiple);
        this.mxn = (TextView) this.gIt.findViewById(R.id.write_vote_time);
        this.mxo = (TextView) this.gIt.findViewById(R.id.vote_time_forever);
        this.mxp = (TextView) this.gIt.findViewById(R.id.vote_time_1_day);
        this.mxq = (TextView) this.gIt.findViewById(R.id.vote_time_7_days);
        this.mxr = (TextView) this.gIt.findViewById(R.id.vote_time_30_days);
    }

    private void duu() {
        if (this.mWriteVoteData != null) {
            this.mxj.setText(this.mWriteVoteData.getTitle());
            this.mxt = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dux();
            duy();
            this.mxv = duw();
            wb(this.mxu && this.mxv);
        }
    }

    private void bzx() {
        this.mxl.setOnClickListener(this);
        this.mxm.setOnClickListener(this);
        this.mxo.setOnClickListener(this);
        this.mxp.setOnClickListener(this);
        this.mxq.setOnClickListener(this);
        this.mxr.setOnClickListener(this);
        this.mxj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.mxj.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.mxu = false;
                        b.this.wb(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.mxj.setText(subStringWithEmoji);
                        b.this.mxj.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.mxj.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.mxu = true;
                    b.this.wb(b.this.mxv);
                }
            }
        });
        this.mxg.a(new c.InterfaceC0780c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0780c
            public void duz() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.mxf.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mxg.setData(b.this.mData);
                    }
                });
                b.this.mxv = b.this.duw();
                b.this.wb(b.this.mxu && b.this.mxv);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0780c
            public void Ha(int i) {
                b.this.mData.remove(i);
                b.this.mxf.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mxg.setData(b.this.mData);
                    }
                });
                b.this.mxv = b.this.duw();
                b.this.wb(b.this.mxu && b.this.mxv);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0780c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.mxv = b.this.duw();
                b.this.wb(b.this.mxu && b.this.mxv);
            }
        });
        this.mxf.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.mxs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> duv = b.this.duv();
                HashMap hashMap = new HashMap();
                int size = duv.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = duv.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.mxj.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.mxt);
                b.this.mWriteVoteData.setOptions(duv);
                b.this.iIV = new Intent();
                b.this.iIV.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                if (b.this.hLG != null) {
                    b.this.Pq(b.this.mTitle);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pq(String str) {
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
        an.setViewTextColor(this.mxi, (int) R.color.cp_cont_d);
        this.mxj.setHintTextColor(an.getColor(R.color.cp_cont_d));
        this.mxj.setTextColor(an.getColor(R.color.cp_cont_b));
        this.mxk.setTextColor(an.getColor(R.color.cp_cont_b));
        this.mxn.setTextColor(an.getColor(R.color.cp_cont_b));
        if (this.mxu && this.mxv) {
            this.mxs.setTextColor(an.getColor(R.color.cp_link_tip_a));
        } else {
            this.mxs.setTextColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dux();
        duy();
        if (this.mxg != null) {
            this.mxg.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> duv() {
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
    public boolean duw() {
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
        this.mxs.setEnabled(z);
        if (z) {
            this.mxs.setTextColor(an.getColor(R.color.cp_link_tip_a));
        } else {
            this.mxs.setTextColor(com.baidu.tieba.tbadkCore.c.l(an.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dux() {
        e(this.mxl, this.mxt != 1);
        e(this.mxm, this.mxt == 1);
    }

    private void duy() {
        e(this.mxo, this.expireType == -1);
        e(this.mxp, this.expireType == 1);
        e(this.mxq, this.expireType == 7);
        e(this.mxr, this.expireType == 30);
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
        return this.mxh != null && this.mxf != null && this.mxh.getTop() == 0 && this.mxf.getFirstVisiblePosition() == 0;
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
            this.mxt = 0;
            dux();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.mxt = 1;
            dux();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            duy();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            duy();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            duy();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            duy();
        }
    }
}
