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
    private LinearLayout haP;
    private ForumWriteData ifP;
    private Intent jdZ;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private TextView mYA;
    private TextView mYB;
    private BdRecyclerView mYo;
    private c mYp;
    private LinearLayout mYq;
    private TextView mYr;
    private EditText mYs;
    private TextView mYt;
    private TextView mYu;
    private TextView mYv;
    private TextView mYw;
    private TextView mYx;
    private TextView mYy;
    private TextView mYz;
    private int mYC = 0;
    private int expireType = -1;
    private boolean mYD = false;
    private boolean mYE = false;

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
                this.ifP = (ForumWriteData) serializableExtra;
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
        this.mYo = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.mYo.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.mYo, layoutParams);
        this.mYp = new c(this.mPageContext);
        this.mYo.setAdapter(this.mYp);
        buO();
        bKU();
        dpa();
        bMg();
        this.mYo.addHeaderView(this.mYq);
        this.mYo.addFooterView(this.haP);
        this.mYp.setData(this.mData);
        dJy();
        this.mYs.requestFocus();
        this.mYs.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.mYs);
            }
        }, 150L);
    }

    private void buO() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.mYB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.mYB.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.mYB.setEnabled(false);
    }

    private void bKU() {
        this.mYq = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.mYr = (TextView) this.mYq.findViewById(R.id.vote_item_tip);
        this.mYs = (EditText) this.mYq.findViewById(R.id.vote_title);
    }

    private void dpa() {
        this.haP = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.mYt = (TextView) this.haP.findViewById(R.id.write_vote_type);
        this.mYu = (TextView) this.haP.findViewById(R.id.vote_type_single);
        this.mYv = (TextView) this.haP.findViewById(R.id.vote_type_multiple);
        this.mYw = (TextView) this.haP.findViewById(R.id.write_vote_time);
        this.mYx = (TextView) this.haP.findViewById(R.id.vote_time_forever);
        this.mYy = (TextView) this.haP.findViewById(R.id.vote_time_1_day);
        this.mYz = (TextView) this.haP.findViewById(R.id.vote_time_7_days);
        this.mYA = (TextView) this.haP.findViewById(R.id.vote_time_30_days);
    }

    private void dJy() {
        if (this.mWriteVoteData != null) {
            this.mYs.setText(this.mWriteVoteData.getTitle());
            this.mYC = this.mWriteVoteData.getIsMulti();
            this.expireType = this.mWriteVoteData.getExpireType();
            dJB();
            dJC();
            this.mYE = dJA();
            xw(this.mYD && this.mYE);
        }
    }

    private void bMg() {
        this.mYu.setOnClickListener(this);
        this.mYv.setOnClickListener(this);
        this.mYx.setOnClickListener(this);
        this.mYy.setOnClickListener(this);
        this.mYz.setOnClickListener(this);
        this.mYA.setOnClickListener(this);
        this.mYs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.mYs.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.mYD = false;
                        b.this.xw(false);
                        return;
                    }
                    if (ae.getTextLengthWithEmoji(obj) > 40) {
                        String subStringWithEmoji = ae.subStringWithEmoji(obj, 40);
                        b.this.mYs.setText(subStringWithEmoji);
                        b.this.mYs.setSelection(subStringWithEmoji.length());
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    b.this.mYs.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.mYD = true;
                    b.this.xw(b.this.mYE);
                }
            }
        });
        this.mYp.a(new c.InterfaceC0844c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0844c
            public void dJD() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.mYo.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mYp.setData(b.this.mData);
                    }
                });
                b.this.mYE = b.this.dJA();
                b.this.xw(b.this.mYD && b.this.mYE);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0844c
            public void JV(int i) {
                b.this.mData.remove(i);
                b.this.mYo.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.mYp.setData(b.this.mData);
                    }
                });
                b.this.mYE = b.this.dJA();
                b.this.xw(b.this.mYD && b.this.mYE);
            }

            @Override // com.baidu.tieba.write.write.vote.c.InterfaceC0844c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.mYE = b.this.dJA();
                b.this.xw(b.this.mYD && b.this.mYE);
            }
        });
        this.mYo.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.mYB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dJz = b.this.dJz();
                HashMap hashMap = new HashMap();
                int size = dJz.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dJz.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.mYs.getText().toString());
                b.this.mWriteVoteData.setExpireType(b.this.expireType);
                b.this.mWriteVoteData.setIsMulti(b.this.mYC);
                b.this.mWriteVoteData.setOptions(dJz);
                b.this.jdZ = new Intent();
                b.this.jdZ.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                if (b.this.ifP != null) {
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
        if (this.ifP == null) {
            str2 = "";
            str3 = "";
            i = 0;
            str4 = null;
            i2 = -1;
            str5 = null;
            str6 = "0";
        } else {
            String str7 = this.ifP.forumId;
            String str8 = this.ifP.forumName;
            postPrefixData = this.ifP.prefixData;
            antiData = this.ifP.antiData;
            int i3 = this.ifP.forumLevel;
            String str9 = this.ifP.avatar;
            int i4 = this.ifP.privateThread;
            String str10 = this.ifP.firstDir;
            str2 = this.ifP.secondDir;
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
        writeActivityConfig.setProfessionZone(this.ifP != null ? this.ifP.defaultZone : -1);
        writeActivityConfig.setFrsTabInfo(this.ifP != null ? this.ifP.frsTabInfo : null);
        if (this.mWriteVoteData != null) {
            writeActivityConfig.setShowVoteData(this.mWriteVoteData);
        }
        writeActivityConfig.setIntentActionActivityForwardResult();
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
    }

    @Override // com.baidu.tbadk.suspended.a
    public void qE(int i) {
        ap.setViewTextColor(this.mYr, R.color.cp_cont_d);
        this.mYs.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.mYs.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.mYt.setTextColor(ap.getColor(R.color.cp_cont_b));
        this.mYw.setTextColor(ap.getColor(R.color.cp_cont_b));
        if (this.mYD && this.mYE) {
            this.mYB.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.mYB.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
        dJB();
        dJC();
        if (this.mYp != null) {
            this.mYp.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dJz() {
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
    public boolean dJA() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xw(boolean z) {
        this.mYB.setEnabled(z);
        if (z) {
            this.mYB.setTextColor(ap.getColor(R.color.cp_link_tip_a));
        } else {
            this.mYB.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.cp_link_tip_a), 0.5f));
        }
    }

    private void dJB() {
        e(this.mYu, this.mYC != 1);
        e(this.mYv, this.mYC == 1);
    }

    private void dJC() {
        e(this.mYx, this.expireType == -1);
        e(this.mYy, this.expireType == 1);
        e(this.mYz, this.expireType == 7);
        e(this.mYA, this.expireType == 30);
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
    public boolean buK() {
        return this.mYq != null && this.mYo != null && this.mYq.getTop() == 0 && this.mYo.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean buL() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent buM() {
        return this.jdZ;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.mYC = 0;
            dJB();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.mYC = 1;
            dJB();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.expireType = -1;
            dJC();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.expireType = 1;
            dJC();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.expireType = 7;
            dJC();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.expireType = 30;
            dJC();
        }
    }
}
