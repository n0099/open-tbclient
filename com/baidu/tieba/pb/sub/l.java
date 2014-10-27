package com.baidu.tieba.pb.sub;

import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.data.ar;
import com.baidu.tieba.editortool.PbEditor;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    protected View.OnClickListener aEF;
    protected TextView aEg;
    protected UserIconBox aSA;
    protected UserIconBox azj;
    protected View.OnClickListener bAA;
    protected View.OnClickListener bAB;
    protected View.OnClickListener bAC;
    private ArrayList<ak> bAG;
    private String bAH;
    protected ClickableLayout4Frame bAs;
    protected TextView bAt;
    protected Button bAu;
    protected d bAv;
    protected LinearLayout bAw;
    protected TextView bAx;
    protected View bAy;
    protected HeadImageView bvN;
    protected TextView bvO;
    protected ImageView bvP;
    protected TextView bvR;
    protected ImageView bvS;
    protected ImageView bvT;
    protected TbRichTextView bvU;
    protected View.OnClickListener bzK;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected ProgressBar mProgress;
    protected BdListView vl;
    protected View Xi = null;
    protected View bAq = null;
    protected a bAr = null;
    protected LinearLayout bAz = null;
    protected int bvy = 0;
    protected boolean bvv = true;
    protected boolean bvw = true;
    private boolean mIsFromCDN = true;
    protected Button bAD = null;
    protected com.baidu.tbadk.widget.richText.s acf = null;
    protected com.baidu.tbadk.widget.richText.r byX = null;
    protected View.OnLongClickListener bAE = null;
    private ArrayList<IconData> bvD = null;
    private ArrayList<IconData> ayQ = null;
    protected PbEditor azA = null;
    private String bAF = null;
    private String bAI = null;
    private boolean bAJ = false;
    protected AdapterView.OnItemClickListener bAK = new m(this);
    protected AdapterView.OnItemLongClickListener uJ = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.vl = null;
        this.mActivity = null;
        this.bAs = null;
        this.bvN = null;
        this.aEg = null;
        this.bvO = null;
        this.bvP = null;
        this.bAt = null;
        this.bvS = null;
        this.bvR = null;
        this.bvU = null;
        this.bvT = null;
        this.bAu = null;
        this.bAv = null;
        this.bAw = null;
        this.bAx = null;
        this.bAy = null;
        this.aSA = null;
        this.azj = null;
        this.aEF = null;
        this.bAA = null;
        this.bzK = null;
        this.bAB = null;
        this.bAC = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aEF = onClickListener;
        this.bzK = onClickListener2;
        this.bAA = onClickListener3;
        this.bAB = onClickListener4;
        this.bAC = onClickListener5;
        Ck();
        this.bAs = (ClickableLayout4Frame) this.Xi.findViewById(v.sub_pb_body_layout);
        this.vl = (BdListView) this.Xi.findViewById(v.new_sub_pb_list);
        this.bAq.setOnClickListener(new o(this));
        this.bAw = (LinearLayout) this.Xi.findViewById(v.sub_pb_bottom_layout);
        YT();
        this.bAx = (TextView) this.Xi.findViewById(v.sub_pb_bottom_text);
        this.bvN = (HeadImageView) this.bAq.findViewById(v.photo);
        this.aEg = (TextView) this.bAq.findViewById(v.user_name);
        this.bvO = (TextView) this.bAq.findViewById(v.user_rank);
        this.bvP = (ImageView) this.bAq.findViewById(v.user_gender);
        this.bvT = (ImageView) this.bAq.findViewById(v.reply);
        this.bAu = (Button) this.bAq.findViewById(v.manage_btn);
        this.bAt = (TextView) this.bAq.findViewById(v.floor);
        this.bvS = (ImageView) this.bAq.findViewById(v.floor_owner);
        this.bvR = (TextView) this.bAq.findViewById(v.time);
        this.aSA = (UserIconBox) this.bAq.findViewById(v.user_icon_box);
        this.azj = (UserIconBox) this.bAq.findViewById(v.user_tshow_icon_box);
        this.bvU = (TbRichTextView) this.bAq.findViewById(v.richText);
        this.bvU.setTextSize(TbConfig.getContentSize());
        this.bvU.setVoiceViewRes(w.voice_play_btn);
        this.vl.addHeaderView(this.bAq);
        v(onClickListener3);
        this.bAv = new d(this.mActivity);
        this.bAy = this.bAv.getView();
        this.vl.setNextPage(this.bAv);
        this.bAv.setOnClickListener(this.aEF);
        this.vl.setOnItemClickListener(this.bAK);
        this.vl.setOnItemLongClickListener(this.uJ);
        this.bAw.setOnClickListener(this.aEF);
        this.mProgress = (ProgressBar) this.Xi.findViewById(v.progress);
        this.bvN.setOnClickListener(onClickListener3);
        init();
        if (this.bAq != null) {
            this.bAq.setVisibility(4);
        }
        if (this.bAs != null) {
            this.bAs.setVisibility(4);
        }
        if (this.bAw != null) {
            this.bAw.setVisibility(4);
        }
    }

    protected void YT() {
        this.azA = (PbEditor) this.Xi.findViewById(v.sub_pb_editor);
        this.azA.au(true);
        this.azA.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.azA.setMaxTextCount(140);
    }

    protected void v(View.OnClickListener onClickListener) {
        this.bAr = new a(this.mActivity, onClickListener);
        this.bAr.u(this.bzK);
        this.bAr.setIsFromCDN(this.mIsFromCDN);
        this.vl.setAdapter((ListAdapter) this.bAr);
    }

    protected void Ck() {
        this.Xi = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, w.new_sub_pb_layout, null);
        this.bAq = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, w.new_sub_pb_head, null);
    }

    protected void init() {
        this.bvy = Math.min(com.baidu.adp.lib.util.m.dip2px(this.mActivity, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        Zc();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void Cf() {
        if (!this.azA.BB()) {
            hd(null);
        }
    }

    public String Zb() {
        return this.bAH;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new p(this, view, i), 300L);
    }

    protected void Zc() {
        TextView textView = new TextView(this.mActivity);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.azA.setAudioFocusable(z);
    }

    public boolean YS() {
        this.bAJ = false;
        if (this.azA.isVisible()) {
            this.azA.Cc();
            this.azA.hide();
            this.bAw.setEnabled(true);
            return true;
        }
        this.azA.clearData();
        this.bAF = null;
        this.bAH = null;
        this.bAG = null;
        return false;
    }

    public void dY(boolean z) {
        this.bvw = z;
        this.bAr.dY(z);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.acf = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.byX = rVar;
    }

    public void gT(int i) {
        this.bvU.setMaxImageWidth(i);
        this.bvU.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.vl.setOnScrollListener(onScrollListener);
    }

    public void Bt() {
        this.azA.Bt();
    }

    public void Bs() {
        this.azA.Bs();
    }

    public View getRootView() {
        return this.Xi;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.azA.getAudioData();
    }

    public void BQ() {
        this.azA.BQ();
    }

    public void o(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < arrayList.size()) {
                    sb.append("@");
                    sb.append(arrayList.get(i2));
                    sb.append(" ");
                    i = i2 + 1;
                } else {
                    String sb2 = sb.toString();
                    this.azA.getEditText().getText().insert(this.azA.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void aB(String str, String str2) {
        this.bAH = str2;
        hd(str);
        new Handler().postDelayed(new q(this, str2), 200L);
    }

    public void hd(String str) {
        this.bAJ = true;
        this.azA.Ba();
        this.bAw.setEnabled(false);
        if (str != null) {
            this.azA.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", str));
            this.azA.getEditText().setSelection(this.azA.getEditText().getText().length());
        }
        if (this.azA.BB()) {
            this.azA.Cb();
            this.azA.Cf();
        } else {
            this.azA.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.azA.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.mActivity, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(String str) {
        this.bAJ = true;
        this.azA.Ba();
        this.bAw.setEnabled(false);
        this.azA.getEditText().setText(str);
        this.azA.getEditText().setSelection(this.azA.getEditText().getText().length());
        if (this.azA.BB()) {
            this.azA.Cb();
            this.azA.Cf();
        } else {
            this.azA.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.azA.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.mActivity, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Zd() {
        this.bAJ = false;
        this.azA.hide();
        this.bAw.setEnabled(true);
    }

    public void Ze() {
        this.vl.setNextPage(this.bAv);
        this.bAv.YH();
    }

    public void dX(boolean z) {
        this.bvv = z;
    }

    public void Zf() {
        this.bAr.setDatas(null);
        this.bAr.notifyDataSetChanged();
        this.azA.getEditText().setText("");
        this.azA.clearData();
    }

    public String Zg() {
        return this.bAF;
    }

    public void a(ar arVar, int i) {
        String userId;
        boolean z = true;
        if (arVar != null) {
            if (this.bAq != null) {
                this.bAq.setVisibility(0);
            }
            if (this.bAs != null) {
                this.bAs.setVisibility(0);
            }
            if (this.bAw != null) {
                this.bAw.setVisibility(0);
            }
            if (arVar.As() != null) {
                this.bAF = arVar.As().getId();
            }
            if (arVar.hasMore()) {
                this.vl.setNextPage(this.bAv);
                this.bAr.en(true);
            } else {
                this.vl.setNextPage(null);
                this.bAr.en(false);
            }
            this.bAv.gS(c(arVar));
            this.bAG = arVar.Au();
            this.bAr.setDatas(this.bAG);
            if (arVar.Ay() == null || arVar.Ay().getAuthor() == null || (userId = arVar.Ay().getAuthor().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
                z = false;
            }
            this.bAr.t(i, z);
            this.bAr.notifyDataSetChanged();
            a(arVar.As(), arVar.Ax(), arVar.zN());
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.azA.setOnActionListener(new r(this, wVar));
        }
    }

    protected int c(ar arVar) {
        if (arVar == null) {
            return 0;
        }
        return arVar.getTotalCount() - arVar.Au().size();
    }

    public void setPosition(int i) {
        this.vl.setSelection(i);
        this.vl.invalidate();
    }

    public void hf(String str) {
        int gZ;
        if (str != null && !str.equals("") && (gZ = this.bAr.gZ(str)) >= 0) {
            this.vl.setSelection(gZ + 1);
            this.vl.invalidate();
        }
    }

    public void Zh() {
        this.azA.clearData();
    }

    public View Zi() {
        return this.bvT;
    }

    protected void a(ak akVar, boolean z, boolean z2) {
        int i;
        if (akVar != null) {
            this.bvN.setTag(null);
            this.bvN.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.bAq.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bAq.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(v.tag_clip_board, akVar);
            sparseArray.put(v.tag_is_subpb, false);
            this.bvT.setTag(sparseArray);
            if (!this.bvw) {
                this.bvN.setVisibility(8);
            }
            this.aEg.setOnClickListener(this.bAA);
            this.aEg.setText((CharSequence) null);
            this.bvO.setText((CharSequence) null);
            this.bvO.setBackgroundDrawable(null);
            this.bvS.setVisibility(8);
            this.bAt.setText((CharSequence) null);
            this.bvT.setOnClickListener(this.aEF);
            TbadkApplication.m251getInst().getSkinType();
            aw.b(this.bvR, com.baidu.tieba.s.pb_listitem_post_time, 1);
            this.bvR.setText(ay.j(akVar.getTime()));
            if (z) {
                this.bvS.setVisibility(0);
                aw.c(this.bvS, u.icon_floorhost);
            }
            if (this.bvv) {
                i = u.img_default_100;
            } else {
                i = u.icon_click;
            }
            this.bvU.setDefaultImageId(i);
            this.bAt.setText(String.format(this.mActivity.getString(y.is_floor), Integer.valueOf(akVar.Ae())));
            String portrait = akVar.getAuthor().getPortrait();
            if (akVar.getAuthor() != null) {
                this.aEg.setText(akVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = akVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    aw.b(this.aEg, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    aw.b(this.aEg, com.baidu.tieba.s.cp_cont_f, 1);
                }
                int level_id = akVar.getAuthor().getLevel_id();
                int is_bawu = akVar.getAuthor().getIs_bawu();
                String bawu_type = akVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bvO.setVisibility(0);
                    this.bvO.setText(String.valueOf(level_id));
                    aw.h((View) this.bvO, com.baidu.tbadk.core.util.d.bn(level_id));
                    this.bvO.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.bvO.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bvO.setText((CharSequence) null);
                        aw.h((View) this.bvO, u.pb_manager);
                        this.bvO.setOnClickListener(this.bAB);
                    } else if (bawu_type.equals("assist")) {
                        this.bvO.setText((CharSequence) null);
                        aw.h((View) this.bvO, u.pb_assist);
                        this.bvO.setOnClickListener(this.bAB);
                    }
                }
                if (akVar.getAuthor().getGender() == 2) {
                    aw.c(this.bvP, u.icon_pop_girl_square);
                    this.bvP.setVisibility(0);
                } else {
                    this.bvP.setVisibility(8);
                }
                this.bvD = akVar.getAuthor().getIconInfo();
                this.ayQ = akVar.getAuthor().getTShowInfo();
                if (this.aSA != null) {
                    this.aSA.setOnClickListener(this.bAB);
                    this.aSA.a(this.bvD, i2, this.mActivity.getResources().getDimensionPixelSize(t.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(t.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(t.pb_icon_margin));
                }
                if (this.azj != null) {
                    this.azj.setOnClickListener(this.bAC);
                    this.azj.a(this.ayQ, 2, this.mActivity.getResources().getDimensionPixelSize(t.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(t.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(t.big_icon_margin), true);
                }
            }
            this.bvN.setUserId(akVar.getAuthor().getUserId());
            this.aEg.setTag(akVar.getAuthor().getUserId());
            this.bvN.setDefaultResource(u.photo);
            this.bvN.c(portrait, 28, false);
            this.bvU.b(this.bvv, false);
            this.bvU.setIsFromCDN(this.mIsFromCDN);
            this.bvU.setText(akVar.Af());
            this.bvU.setOnImageClickListener(this.acf);
            this.bvU.setOnEmotionClickListener(this.byX);
            this.bAu.setVisibility(8);
            if (!TextUtils.isEmpty(akVar.getBimg_url()) && this.bvv) {
                this.bvU.setBackgroundDrawable(null);
                this.bvU.setTag(akVar.getBimg_url());
                com.baidu.adp.lib.f.d.ef().a(akVar.getBimg_url(), 19, new s(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvU.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bvU.setPadding(0, 0, 0, 0);
            this.bvU.setLayoutParams(layoutParams);
            this.bvU.setBackgroundDrawable(null);
        }
    }

    public View Zj() {
        return this.bAy;
    }

    public String Zk() {
        return this.azA.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.Xi);
        this.mActivity.getLayoutMode().h(this.bAq);
        this.mActivity.getLayoutMode().h(this.bAy);
        aw.h((View) this.bAD, u.btn_pb_editor_post_btn);
        aw.c(this.bvT, u.btn_pb_reply_selector);
        this.bvU.setTextColor(aw.getColor(com.baidu.tieba.s.pb_listitem_content));
        this.bvU.setVideoImageId(u.pic_video);
        this.azA.changeSkinType(i);
    }

    public void XA() {
        this.vl.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void Zl() {
        this.mProgress.setVisibility(0);
    }

    public void Zm() {
        this.mProgress.setVisibility(8);
    }

    public void Zn() {
        this.vl.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bAv.XT();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bAE = onLongClickListener;
        this.bAq.setOnLongClickListener(this.bAE);
    }

    public View Zo() {
        return this.bAq;
    }

    public void hc(String str) {
        int gZ = this.bAr.gZ(str);
        if (gZ > -1) {
            this.vl.setSelection(gZ + 1);
            this.vl.invalidate();
        }
    }

    public void ep(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean Ch() {
        return this.azA.Ch();
    }

    public PbEditor EO() {
        return this.azA;
    }
}
