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
import com.baidu.tbadk.core.util.az;
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
    protected View.OnClickListener aEP;
    protected TextView aEq;
    protected UserIconBox aSO;
    protected UserIconBox azs;
    protected ClickableLayout4Frame bAG;
    protected TextView bAH;
    protected Button bAI;
    protected d bAJ;
    protected LinearLayout bAK;
    protected TextView bAL;
    protected View bAM;
    protected View.OnClickListener bAO;
    protected View.OnClickListener bAP;
    protected View.OnClickListener bAQ;
    private ArrayList<ak> bAU;
    private String bAV;
    protected HeadImageView bwb;
    protected TextView bwc;
    protected ImageView bwd;
    protected TextView bwf;
    protected ImageView bwg;
    protected ImageView bwh;
    protected TbRichTextView bwi;
    protected View.OnClickListener bzY;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected ProgressBar mProgress;
    protected BdListView vl;
    protected View Xm = null;
    protected View bAE = null;
    protected a bAF = null;
    protected LinearLayout bAN = null;
    protected int bvM = 0;
    protected boolean bvJ = true;
    protected boolean bvK = true;
    private boolean mIsFromCDN = true;
    protected Button bAR = null;
    protected com.baidu.tbadk.widget.richText.s ack = null;
    protected com.baidu.tbadk.widget.richText.r bzl = null;
    protected View.OnLongClickListener bAS = null;
    private ArrayList<IconData> bvR = null;
    private ArrayList<IconData> ayZ = null;
    protected PbEditor azJ = null;
    private String bAT = null;
    private String bAW = null;
    private boolean bAX = false;
    protected AdapterView.OnItemClickListener bAY = new m(this);
    protected AdapterView.OnItemLongClickListener uJ = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.vl = null;
        this.mActivity = null;
        this.bAG = null;
        this.bwb = null;
        this.aEq = null;
        this.bwc = null;
        this.bwd = null;
        this.bAH = null;
        this.bwg = null;
        this.bwf = null;
        this.bwi = null;
        this.bwh = null;
        this.bAI = null;
        this.bAJ = null;
        this.bAK = null;
        this.bAL = null;
        this.bAM = null;
        this.aSO = null;
        this.azs = null;
        this.aEP = null;
        this.bAO = null;
        this.bzY = null;
        this.bAP = null;
        this.bAQ = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aEP = onClickListener;
        this.bzY = onClickListener2;
        this.bAO = onClickListener3;
        this.bAP = onClickListener4;
        this.bAQ = onClickListener5;
        Cm();
        this.bAG = (ClickableLayout4Frame) this.Xm.findViewById(v.sub_pb_body_layout);
        this.vl = (BdListView) this.Xm.findViewById(v.new_sub_pb_list);
        this.bAE.setOnClickListener(new o(this));
        this.bAK = (LinearLayout) this.Xm.findViewById(v.sub_pb_bottom_layout);
        YW();
        this.bAL = (TextView) this.Xm.findViewById(v.sub_pb_bottom_text);
        this.bwb = (HeadImageView) this.bAE.findViewById(v.photo);
        this.aEq = (TextView) this.bAE.findViewById(v.user_name);
        this.bwc = (TextView) this.bAE.findViewById(v.user_rank);
        this.bwd = (ImageView) this.bAE.findViewById(v.user_gender);
        this.bwh = (ImageView) this.bAE.findViewById(v.reply);
        this.bAI = (Button) this.bAE.findViewById(v.manage_btn);
        this.bAH = (TextView) this.bAE.findViewById(v.floor);
        this.bwg = (ImageView) this.bAE.findViewById(v.floor_owner);
        this.bwf = (TextView) this.bAE.findViewById(v.time);
        this.aSO = (UserIconBox) this.bAE.findViewById(v.user_icon_box);
        this.azs = (UserIconBox) this.bAE.findViewById(v.user_tshow_icon_box);
        this.bwi = (TbRichTextView) this.bAE.findViewById(v.richText);
        this.bwi.setTextSize(TbConfig.getContentSize());
        this.bwi.setVoiceViewRes(w.voice_play_btn);
        this.vl.addHeaderView(this.bAE);
        v(onClickListener3);
        this.bAJ = new d(this.mActivity);
        this.bAM = this.bAJ.getView();
        this.vl.setNextPage(this.bAJ);
        this.bAJ.setOnClickListener(this.aEP);
        this.vl.setOnItemClickListener(this.bAY);
        this.vl.setOnItemLongClickListener(this.uJ);
        this.bAK.setOnClickListener(this.aEP);
        this.mProgress = (ProgressBar) this.Xm.findViewById(v.progress);
        this.bwb.setOnClickListener(onClickListener3);
        init();
        if (this.bAE != null) {
            this.bAE.setVisibility(4);
        }
        if (this.bAG != null) {
            this.bAG.setVisibility(4);
        }
        if (this.bAK != null) {
            this.bAK.setVisibility(4);
        }
    }

    protected void YW() {
        this.azJ = (PbEditor) this.Xm.findViewById(v.sub_pb_editor);
        this.azJ.au(true);
        this.azJ.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.azJ.setMaxTextCount(140);
    }

    protected void v(View.OnClickListener onClickListener) {
        this.bAF = new a(this.mActivity, onClickListener);
        this.bAF.u(this.bzY);
        this.bAF.setIsFromCDN(this.mIsFromCDN);
        this.vl.setAdapter((ListAdapter) this.bAF);
    }

    protected void Cm() {
        this.Xm = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, w.new_sub_pb_layout, null);
        this.bAE = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity, w.new_sub_pb_head, null);
    }

    protected void init() {
        this.bvM = Math.min(com.baidu.adp.lib.util.m.dip2px(this.mActivity, 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        Zf();
        onChangeSkinType(TbadkApplication.m251getInst().getSkinType());
    }

    public void Ch() {
        if (!this.azJ.BD()) {
            hd(null);
        }
    }

    public String Ze() {
        return this.bAV;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new p(this, view, i), 300L);
    }

    protected void Zf() {
        TextView textView = new TextView(this.mActivity);
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.azJ.setAudioFocusable(z);
    }

    public boolean YV() {
        this.bAX = false;
        if (this.azJ.isVisible()) {
            this.azJ.Ce();
            this.azJ.hide();
            this.bAK.setEnabled(true);
            return true;
        }
        this.azJ.clearData();
        this.bAT = null;
        this.bAV = null;
        this.bAU = null;
        return false;
    }

    public void dY(boolean z) {
        this.bvK = z;
        this.bAF.dY(z);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.ack = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.bzl = rVar;
    }

    public void gT(int i) {
        this.bwi.setMaxImageWidth(i);
        this.bwi.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.vl.setOnScrollListener(onScrollListener);
    }

    public void Bv() {
        this.azJ.Bv();
    }

    public void Bu() {
        this.azJ.Bu();
    }

    public View getRootView() {
        return this.Xm;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.azJ.getAudioData();
    }

    public void BS() {
        this.azJ.BS();
    }

    public void p(ArrayList<String> arrayList) {
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
                    this.azJ.getEditText().getText().insert(this.azJ.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void aB(String str, String str2) {
        this.bAV = str2;
        hd(str);
        new Handler().postDelayed(new q(this, str2), 200L);
    }

    public void hd(String str) {
        this.bAX = true;
        this.azJ.Bc();
        this.bAK.setEnabled(false);
        if (str != null) {
            this.azJ.getEditText().setText(this.mActivity.getResources().getString(y.reply_sub_floor).replace("%s", str));
            this.azJ.getEditText().setSelection(this.azJ.getEditText().getText().length());
        }
        if (this.azJ.BD()) {
            this.azJ.Cd();
            this.azJ.Ch();
        } else {
            this.azJ.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.azJ.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.mActivity, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void he(String str) {
        this.bAX = true;
        this.azJ.Bc();
        this.bAK.setEnabled(false);
        this.azJ.getEditText().setText(str);
        this.azJ.getEditText().setSelection(this.azJ.getEditText().getText().length());
        if (this.azJ.BD()) {
            this.azJ.Cd();
            this.azJ.Ch();
        } else {
            this.azJ.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.azJ.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.mActivity, "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void Zg() {
        this.bAX = false;
        this.azJ.hide();
        this.bAK.setEnabled(true);
    }

    public void Zh() {
        this.vl.setNextPage(this.bAJ);
        this.bAJ.YK();
    }

    public void dX(boolean z) {
        this.bvJ = z;
    }

    public void Zi() {
        this.bAF.setDatas(null);
        this.bAF.notifyDataSetChanged();
        this.azJ.getEditText().setText("");
        this.azJ.clearData();
    }

    public String Zj() {
        return this.bAT;
    }

    public void a(ar arVar, int i) {
        String userId;
        boolean z = true;
        if (arVar != null) {
            if (this.bAE != null) {
                this.bAE.setVisibility(0);
            }
            if (this.bAG != null) {
                this.bAG.setVisibility(0);
            }
            if (this.bAK != null) {
                this.bAK.setVisibility(0);
            }
            if (arVar.Au() != null) {
                this.bAT = arVar.Au().getId();
            }
            if (arVar.hasMore()) {
                this.vl.setNextPage(this.bAJ);
                this.bAF.en(true);
            } else {
                this.vl.setNextPage(null);
                this.bAF.en(false);
            }
            this.bAJ.gS(c(arVar));
            this.bAU = arVar.Aw();
            this.bAF.setDatas(this.bAU);
            if (arVar.AA() == null || arVar.AA().getAuthor() == null || (userId = arVar.AA().getAuthor().getUserId()) == null || !userId.equals(TbadkApplication.getCurrentAccount())) {
                z = false;
            }
            this.bAF.t(i, z);
            this.bAF.notifyDataSetChanged();
            a(arVar.Au(), arVar.Az(), arVar.zP());
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.azJ.setOnActionListener(new r(this, wVar));
        }
    }

    protected int c(ar arVar) {
        if (arVar == null) {
            return 0;
        }
        return arVar.getTotalCount() - arVar.Aw().size();
    }

    public void setPosition(int i) {
        this.vl.setSelection(i);
        this.vl.invalidate();
    }

    public void hf(String str) {
        int gZ;
        if (str != null && !str.equals("") && (gZ = this.bAF.gZ(str)) >= 0) {
            this.vl.setSelection(gZ + 1);
            this.vl.invalidate();
        }
    }

    public void Zk() {
        this.azJ.clearData();
    }

    public View Zl() {
        return this.bwh;
    }

    protected void a(ak akVar, boolean z, boolean z2) {
        int i;
        if (akVar != null) {
            this.bwb.setTag(null);
            this.bwb.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.bAE.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bAE.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(v.tag_clip_board, akVar);
            sparseArray.put(v.tag_is_subpb, false);
            this.bwh.setTag(sparseArray);
            if (!this.bvK) {
                this.bwb.setVisibility(8);
            }
            this.aEq.setOnClickListener(this.bAO);
            this.aEq.setText((CharSequence) null);
            this.bwc.setText((CharSequence) null);
            this.bwc.setBackgroundDrawable(null);
            this.bwg.setVisibility(8);
            this.bAH.setText((CharSequence) null);
            this.bwh.setOnClickListener(this.aEP);
            TbadkApplication.m251getInst().getSkinType();
            aw.b(this.bwf, com.baidu.tieba.s.pb_listitem_post_time, 1);
            this.bwf.setText(az.j(akVar.getTime()));
            if (z) {
                this.bwg.setVisibility(0);
                aw.c(this.bwg, u.icon_floorhost);
            }
            if (this.bvJ) {
                i = u.img_default_100;
            } else {
                i = u.icon_click;
            }
            this.bwi.setDefaultImageId(i);
            this.bAH.setText(String.format(this.mActivity.getString(y.is_floor), Integer.valueOf(akVar.Ag())));
            String portrait = akVar.getAuthor().getPortrait();
            if (akVar.getAuthor() != null) {
                this.aEq.setText(akVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = akVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    aw.b(this.aEq, com.baidu.tieba.s.cp_cont_h, 1);
                } else {
                    aw.b(this.aEq, com.baidu.tieba.s.cp_cont_f, 1);
                }
                int level_id = akVar.getAuthor().getLevel_id();
                int is_bawu = akVar.getAuthor().getIs_bawu();
                String bawu_type = akVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bwc.setVisibility(0);
                    this.bwc.setText(String.valueOf(level_id));
                    aw.h((View) this.bwc, com.baidu.tbadk.core.util.d.bn(level_id));
                    this.bwc.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.bwc.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bwc.setText((CharSequence) null);
                        aw.h((View) this.bwc, u.pb_manager);
                        this.bwc.setOnClickListener(this.bAP);
                    } else if (bawu_type.equals("assist")) {
                        this.bwc.setText((CharSequence) null);
                        aw.h((View) this.bwc, u.pb_assist);
                        this.bwc.setOnClickListener(this.bAP);
                    }
                }
                if (akVar.getAuthor().getGender() == 2) {
                    aw.c(this.bwd, u.icon_pop_girl_square);
                    this.bwd.setVisibility(0);
                } else {
                    this.bwd.setVisibility(8);
                }
                this.bvR = akVar.getAuthor().getIconInfo();
                this.ayZ = akVar.getAuthor().getTShowInfo();
                if (this.aSO != null) {
                    this.aSO.setOnClickListener(this.bAP);
                    this.aSO.a(this.bvR, i2, this.mActivity.getResources().getDimensionPixelSize(t.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(t.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(t.pb_icon_margin));
                }
                if (this.azs != null) {
                    this.azs.setOnClickListener(this.bAQ);
                    this.azs.a(this.ayZ, 2, this.mActivity.getResources().getDimensionPixelSize(t.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(t.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(t.big_icon_margin), true);
                }
            }
            this.bwb.setUserId(akVar.getAuthor().getUserId());
            this.aEq.setTag(akVar.getAuthor().getUserId());
            this.bwb.setDefaultResource(u.photo);
            this.bwb.c(portrait, 28, false);
            this.bwi.b(this.bvJ, false);
            this.bwi.setIsFromCDN(this.mIsFromCDN);
            this.bwi.setText(akVar.Ah());
            this.bwi.setOnImageClickListener(this.ack);
            this.bwi.setOnEmotionClickListener(this.bzl);
            this.bAI.setVisibility(8);
            if (!TextUtils.isEmpty(akVar.getBimg_url()) && this.bvJ) {
                this.bwi.setBackgroundDrawable(null);
                this.bwi.setTag(akVar.getBimg_url());
                com.baidu.adp.lib.f.d.ef().a(akVar.getBimg_url(), 19, new s(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bwi.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bwi.setPadding(0, 0, 0, 0);
            this.bwi.setLayoutParams(layoutParams);
            this.bwi.setBackgroundDrawable(null);
        }
    }

    public View Zm() {
        return this.bAM;
    }

    public String Zn() {
        return this.azJ.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().L(i == 1);
        this.mActivity.getLayoutMode().h(this.Xm);
        this.mActivity.getLayoutMode().h(this.bAE);
        this.mActivity.getLayoutMode().h(this.bAM);
        aw.h((View) this.bAR, u.btn_pb_editor_post_btn);
        aw.c(this.bwh, u.btn_pb_reply_selector);
        this.bwi.setTextColor(aw.getColor(com.baidu.tieba.s.pb_listitem_content));
        this.bwi.setVideoImageId(u.pic_video);
        this.azJ.changeSkinType(i);
    }

    public void XD() {
        this.vl.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void Zo() {
        this.mProgress.setVisibility(0);
    }

    public void Zp() {
        this.mProgress.setVisibility(8);
    }

    public void Zq() {
        this.vl.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bAJ.XW();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bAS = onLongClickListener;
        this.bAE.setOnLongClickListener(this.bAS);
    }

    public View Zr() {
        return this.bAE;
    }

    public void hc(String str) {
        int gZ = this.bAF.gZ(str);
        if (gZ > -1) {
            this.vl.setSelection(gZ + 1);
            this.vl.invalidate();
        }
    }

    public void ep(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean Cj() {
        return this.azJ.Cj();
    }

    public PbEditor EQ() {
        return this.azJ;
    }
}
