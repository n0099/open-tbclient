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
/* loaded from: classes7.dex */
public class b implements View.OnClickListener, com.baidu.tbadk.suspended.a {
    private LinearLayout cfz;
    private Intent ggB;
    private ForumWriteData jvq;
    private LinearLayout mContentView;
    private List<WriteVoteItemData> mData;
    private NavigationBar mNavigationBar;
    private TbPageContext<WriteVoteActivity> mPageContext;
    private String mTitle;
    private WriteVoteData mWriteVoteData;
    private EditText oqA;
    private TextView oqB;
    private TextView oqC;
    private TextView oqD;
    private TextView oqE;
    private TextView oqF;
    private TextView oqG;
    private TextView oqH;
    private TextView oqI;
    private TextView oqJ;
    private int oqK = 0;
    private int oqL = -1;
    private boolean oqM = false;
    private boolean oqN = false;
    private BdRecyclerView oqw;
    private WriteVoteViewAdapter oqx;
    private LinearLayout oqy;
    private TextView oqz;

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
                this.jvq = (ForumWriteData) serializableExtra;
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
        this.oqw = new BdRecyclerView(this.mPageContext.getPageActivity());
        this.oqw.setLayoutManager(new LinearLayoutManager(this.mPageContext.getPageActivity()));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.topMargin = l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds27);
        this.mContentView.addView(this.oqw, layoutParams);
        this.oqx = new WriteVoteViewAdapter(this.mPageContext);
        this.oqw.setAdapter(this.oqx);
        bEP();
        bWC();
        cRc();
        bZr();
        this.oqw.addHeaderView(this.oqy);
        this.oqw.addFooterView(this.cfz);
        this.oqx.setData(this.mData);
        eaj();
        this.oqA.requestFocus();
        this.oqA.postDelayed(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.1
            @Override // java.lang.Runnable
            public void run() {
                l.showSoftKeyPad(b.this.mPageContext.getPageActivity(), b.this.oqA);
            }
        }, 150L);
    }

    private void bEP() {
        this.mNavigationBar.setCenterTextTitle(this.mPageContext.getResources().getString(R.string.write_add_vote));
        this.oqJ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.mPageContext.getResources().getString(R.string.done));
        this.oqJ.setTextSize(0, l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds44));
        this.oqJ.setEnabled(false);
    }

    private void bWC() {
        this.oqy = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_header, (ViewGroup) null);
        this.oqz = (TextView) this.oqy.findViewById(R.id.vote_item_tip);
        this.oqA = (EditText) this.oqy.findViewById(R.id.vote_title);
    }

    private void cRc() {
        this.cfz = (LinearLayout) LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.view_vote_footer, (ViewGroup) null);
        this.oqB = (TextView) this.cfz.findViewById(R.id.write_vote_type);
        this.oqC = (TextView) this.cfz.findViewById(R.id.vote_type_single);
        this.oqD = (TextView) this.cfz.findViewById(R.id.vote_type_multiple);
        this.oqE = (TextView) this.cfz.findViewById(R.id.write_vote_time);
        this.oqF = (TextView) this.cfz.findViewById(R.id.vote_time_forever);
        this.oqG = (TextView) this.cfz.findViewById(R.id.vote_time_1_day);
        this.oqH = (TextView) this.cfz.findViewById(R.id.vote_time_7_days);
        this.oqI = (TextView) this.cfz.findViewById(R.id.vote_time_30_days);
    }

    private void eaj() {
        if (this.mWriteVoteData != null) {
            this.oqA.setText(this.mWriteVoteData.getTitle());
            this.oqK = this.mWriteVoteData.getIs_multi();
            this.oqL = this.mWriteVoteData.getExpire_type();
            eam();
            ean();
            this.oqN = eal();
            zN(this.oqM && this.oqN);
        }
    }

    private void bZr() {
        this.oqC.setOnClickListener(this);
        this.oqD.setOnClickListener(this);
        this.oqF.setOnClickListener(this);
        this.oqG.setOnClickListener(this);
        this.oqH.setOnClickListener(this);
        this.oqI.setOnClickListener(this);
        this.oqA.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.write.write.vote.b.2
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
                        b.this.oqA.setTypeface(Typeface.defaultFromStyle(0));
                        b.this.oqM = false;
                        b.this.zN(false);
                        return;
                    }
                    String replace = obj.replace(" ", "");
                    if (ag.getTextLengthWithEmoji(replace) > 40) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_toast), 20));
                    }
                    String subStringWithEmoji = ag.subStringWithEmoji(replace, 40);
                    if (!subStringWithEmoji.equals(editable.toString())) {
                        b.this.oqA.setText(subStringWithEmoji);
                        b.this.oqA.setSelection(subStringWithEmoji.length());
                    }
                    b.this.oqA.setTypeface(Typeface.defaultFromStyle(1));
                    b.this.oqM = true;
                    b.this.zN(b.this.oqN);
                }
            }
        });
        this.oqx.a(new WriteVoteViewAdapter.c() { // from class: com.baidu.tieba.write.write.vote.b.3
            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void eao() {
                b.this.mData.add(new WriteVoteItemData());
                b.this.oqw.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oqx.setData(b.this.mData);
                    }
                });
                b.this.oqN = b.this.eal();
                b.this.zN(b.this.oqM && b.this.oqN);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void LK(int i) {
                b.this.mData.remove(i);
                b.this.oqw.post(new Runnable() { // from class: com.baidu.tieba.write.write.vote.b.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.oqx.setData(b.this.mData);
                    }
                });
                b.this.oqN = b.this.eal();
                b.this.zN(b.this.oqM && b.this.oqN);
            }

            @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.c
            public void a(WriteVoteItemData writeVoteItemData, int i) {
                b.this.mData.set(i, writeVoteItemData);
                b.this.oqN = b.this.eal();
                b.this.zN(b.this.oqM && b.this.oqN);
            }
        });
        this.oqw.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.tieba.write.write.vote.b.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    l.hideSoftKeyPad(b.this.mPageContext.getPageActivity(), recyclerView);
                }
            }
        });
        this.oqJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.write.write.vote.b.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                List<WriteVoteItemData> eak = b.this.eak();
                HashMap hashMap = new HashMap();
                int size = eak.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = eak.get(i);
                    if (hashMap.containsKey(writeVoteItemData.getText())) {
                        b.this.mPageContext.showToast(String.format(b.this.mPageContext.getString(R.string.write_vote_repeat_toast), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                    hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                }
                b.this.mWriteVoteData = new WriteVoteData();
                b.this.mWriteVoteData.setTitle(b.this.oqA.getText().toString());
                b.this.mWriteVoteData.setExpire_type(b.this.oqL);
                b.this.mWriteVoteData.setIs_multi(b.this.oqK);
                b.this.mWriteVoteData.setOptions(eak);
                b.this.ggB = new Intent();
                b.this.ggB.putExtra(IntentConfig.WRITE_VOTE_DATA, b.this.mWriteVoteData);
                b.this.mPageContext.getPageActivity().finish();
                b.this.VN(b.this.mTitle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VN(String str) {
        if (this.jvq != null && !WriteActivityConfig.isAsyncWriting()) {
            WriteActivityConfig.newInstance(this.mPageContext.getPageActivity()).setType(9).setForumWriteData(this.jvq).setShowVoteData(this.mWriteVoteData).setTitle(str).send();
        }
    }

    @Override // com.baidu.tbadk.suspended.a
    public void rz(int i) {
        ap.setViewTextColor(this.oqz, R.color.CAM_X0109);
        this.oqA.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.oqA.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.oqB.setTextColor(ap.getColor(R.color.CAM_X0105));
        this.oqE.setTextColor(ap.getColor(R.color.CAM_X0105));
        if (this.oqM && this.oqN) {
            this.oqJ.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.oqJ.setTextColor(c.l(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
        eam();
        ean();
        if (this.oqx != null) {
            this.oqx.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<WriteVoteItemData> eak() {
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
    public boolean eal() {
        int size = this.mData.size();
        for (int i = 0; i < size; i++) {
            if (StringUtils.isNull(this.mData.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN(boolean z) {
        this.oqJ.setEnabled(z);
        if (z) {
            this.oqJ.setTextColor(ap.getColor(R.color.CAM_X0302));
        } else {
            this.oqJ.setTextColor(c.l(ap.getColor(R.color.CAM_X0302), 0.5f));
        }
    }

    private void eam() {
        f(this.oqC, this.oqK != 1);
        f(this.oqD, this.oqK == 1);
    }

    private void ean() {
        f(this.oqF, this.oqL == -1);
        f(this.oqG, this.oqL == 1);
        f(this.oqH, this.oqL == 7);
        f(this.oqI, this.oqL == 30);
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
    public boolean bEL() {
        return this.oqy != null && this.oqw != null && this.oqy.getTop() == 0 && this.oqw.getFirstVisiblePosition() == 0;
    }

    @Override // com.baidu.tbadk.suspended.a
    public boolean bEM() {
        return true;
    }

    @Override // com.baidu.tbadk.suspended.a
    public Intent bEN() {
        return this.ggB;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vote_type_single) {
            this.oqK = 0;
            eam();
        } else if (view.getId() == R.id.vote_type_multiple) {
            this.oqK = 1;
            eam();
        } else if (view.getId() == R.id.vote_time_forever) {
            this.oqL = -1;
            ean();
        } else if (view.getId() == R.id.vote_time_1_day) {
            this.oqL = 1;
            ean();
        } else if (view.getId() == R.id.vote_time_7_days) {
            this.oqL = 7;
            ean();
        } else if (view.getId() == R.id.vote_time_30_days) {
            this.oqL = 30;
            ean();
        }
    }
}
