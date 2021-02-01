package com.baidu.tieba.write.write.vote;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tbadk.util.ag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.tbadkCore.c;
import com.baidu.tieba.write.write.vote.WriteVoteViewAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes8.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout cdZ;
    private Intent geT;
    private ForumWriteData jtt;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private BdRecyclerView onQ;
    private WriteVoteViewAdapter onR;
    private LinearLayout onS;
    private TextView onT;
    private EditText onU;
    private TextView onV;
    private TextView onW;
    private TextView onX;
    private TextView onY;
    private TextView onZ;
    private TextView ooa;
    private TextView oob;
    private TextView ooc;
    private TextView ood;
    private int ooe = 0;
    private int oof = -1;
    private boolean oog = false;
    private boolean ooh = false;

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
                this.jtt = (ForumWriteData) serializableExtra;
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
        this.onQ = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.onQ.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.onQ, layoutParams);
        this.onR = new WriteVoteViewAdapter(this.mPageContext);
        this.onQ.setAdapter(this.onR);
        bEL();
        bWp();
        cQO();
        bZe();
        this.onQ.addHeaderView(this.onS);
        this.onQ.addFooterView(this.cdZ);
        this.onR.setData(this.mData);
        dZT();
        this.onU.requestFocus();
        this.onU.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.onU);
            }
        }, 150L);
    }

    private void bEL() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.ood = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.ood.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.ood.setEnabled(false);
    }

    private void bWp() {
        this.onS = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.onT = (TextView) this.onS.findViewById(R.id.vote_item_tip);
        this.onU = (EditText) this.onS.findViewById(R.id.vote_title);
    }

    private void cQO() {
        this.cdZ = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.onV = (TextView) this.cdZ.findViewById(R.id.write_vote_type);
        this.onW = (TextView) this.cdZ.findViewById(R.id.vote_type_single);
        this.onX = (TextView) this.cdZ.findViewById(R.id.vote_type_multiple);
        this.onY = (TextView) this.cdZ.findViewById(R.id.write_vote_time);
        this.onZ = (TextView) this.cdZ.findViewById(R.id.vote_time_forever);
        this.ooa = (TextView) this.cdZ.findViewById(R.id.vote_time_1_day);
        this.oob = (TextView) this.cdZ.findViewById(R.id.vote_time_7_days);
        this.ooc = (TextView) this.cdZ.findViewById(R.id.vote_time_30_days);
    }

    private void dZT() {
        if (this.mWriteVoteData != null) {
            this.onU.setText(this.mWriteVoteData.getTitle());
            this.ooe = this.mWriteVoteData.getIs_multi();
            this.oof = this.mWriteVoteData.getExpire_type();
            dZW();
            dZX();
            this.ooh = dZV();
            zO(this.oog && this.ooh);
        }
    }

    private void bZe() {
        this.onW.setOnClickListener(this);
        this.onX.setOnClickListener(this);
        this.onZ.setOnClickListener(this);
        this.ooa.setOnClickListener(this);
        this.oob.setOnClickListener(this);
        this.ooc.setOnClickListener(this);
        this.onU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.onU.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.oog = false;
                        b.this.zO(false);
                        return;
                    }
                    String replace = obj.replace(" ", "");
                    if (ag.getTextLengthWithEmoji(replace) > 40) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    String subStringWithEmoji = ag.subStringWithEmoji(replace, 40);
                    if (!subStringWithEmoji.equals(editable.toString())) {
                        b.this.onU.setText(subStringWithEmoji);
                        b.this.onU.setSelection(subStringWithEmoji.length());
                    }
                    b.this.onU.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.oog = true;
                    b.this.zO(b.this.ooh);
                }
            }
        });
        this.onR.a(new WriteVoteViewAdapter.c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void dZY() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.onQ.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.onR.setData(b.this.mData);
                    }
                });
                b.this.ooh = b.this.dZV();
                b.this.zO(b.this.oog && b.this.ooh);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void LF(int i) {
                b.this.mData.remove(i);
                b.this.onQ.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.onR.setData(b.this.mData);
                    }
                });
                b.this.ooh = b.this.dZV();
                b.this.zO(b.this.oog && b.this.ooh);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.ooh = b.this.dZV();
                b.this.zO(b.this.oog && b.this.ooh);
            }
        });
        this.onQ.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.ood.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> dZU = b.this.dZU();
                HashMap hashMap = new HashMap();
                int size = dZU.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = dZU.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.onU.getText().toString());
                b.this.mWriteVoteData.setExpire_type(b.this.oof);
                b.this.mWriteVoteData.setIs_multi(b.this.ooe);
                b.this.mWriteVoteData.setOptions(dZU);
                b.this.geT = new Intent();
                b.this.geT.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.Vu(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vu(String str) {
        if (this.jtt != null && !WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumWriteData(this.jtt).setShowVoteData(this.mWriteVoteData).setTitle(str).send();
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rx(int i) {
        ap.setViewTextColor(this.onT, R.color.CAM_X0109);
        this.onU.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.onU.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.onV.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.onY.setTextColor(ap.getColor(R.color.CAM_X0105));
        if (this.oog && this.ooh) {
            this.ood.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ood.setTextColor(c.l(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
        dZW();
        dZX();
        if (this.onR != null) {
            this.onR.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> dZU() {
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
    public boolean dZV() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(boolean z) {
        this.ood.setEnabled(z);
        if (z) {
            this.ood.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.ood.setTextColor(c.l(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void dZW() {
        f(this.onW, this.ooe != 1);
        f(this.onX, this.ooe == 1);
    }

    private void dZX() {
        f(this.onZ, this.oof == -1);
        f(this.ooa, this.oof == 1);
        f(this.oob, this.oof == 7);
        f(this.ooc, this.oof == 30);
    }

    private void f(TextView textView, boolean z) {
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
    public boolean bEH() {
        return this.onS != null && this.onQ != null && this.onS.getTop() == 0 && this.onQ.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEI() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEJ() {
        return this.geT;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.ooe = 0;
            dZW();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.ooe = 1;
            dZW();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.oof = -1;
            dZX();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.oof = 1;
            dZX();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.oof = 7;
            dZX();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.oof = 30;
            dZX();
        }
    }
}
