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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.view.ClickableLayout4Frame;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l {
    protected UserIconBox aCo;
    protected View.OnClickListener aHC;
    protected TextView aHf;
    protected UserIconBox aVu;
    protected HeadImageView bBC;
    protected TextView bBD;
    protected ImageView bBE;
    protected TextView bBG;
    protected ImageView bBH;
    protected ImageView bBI;
    protected TbRichTextView bBJ;
    protected View.OnClickListener bFt;
    protected ClickableLayout4Frame bGe;
    protected TextView bGf;
    protected Button bGg;
    protected d bGh;
    protected LinearLayout bGi;
    protected TextView bGj;
    protected View bGk;
    protected View.OnClickListener bGm;
    protected View.OnClickListener bGn;
    protected View.OnClickListener bGo;
    private ArrayList<com.baidu.tieba.tbadkCore.b.k> bGs;
    private String bGt;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected BdListView mListView;
    protected ProgressBar mProgress;
    protected View rootView = null;
    protected View bGc = null;
    protected a bGd = null;
    protected LinearLayout bGl = null;
    protected int mImageMaxWidth = 0;
    protected boolean bBi = true;
    protected boolean bBj = true;
    private boolean mIsFromCDN = true;
    protected Button bGp = null;
    protected com.baidu.tbadk.widget.richText.s akz = null;
    protected com.baidu.tbadk.widget.richText.r bES = null;
    protected View.OnLongClickListener bGq = null;
    private ArrayList<IconData> bBp = null;
    private ArrayList<IconData> aCb = null;
    protected PbEditor aCF = null;
    private String bGr = null;
    private String bGu = null;
    private boolean bGv = false;
    protected AdapterView.OnItemClickListener bGw = new m(this);
    protected AdapterView.OnItemLongClickListener wP = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.mListView = null;
        this.mActivity = null;
        this.bGe = null;
        this.bBC = null;
        this.aHf = null;
        this.bBD = null;
        this.bBE = null;
        this.bGf = null;
        this.bBH = null;
        this.bBG = null;
        this.bBJ = null;
        this.bBI = null;
        this.bGg = null;
        this.bGh = null;
        this.bGi = null;
        this.bGj = null;
        this.bGk = null;
        this.aVu = null;
        this.aCo = null;
        this.aHC = null;
        this.bGm = null;
        this.bFt = null;
        this.bGn = null;
        this.bGo = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aHC = onClickListener;
        this.bFt = onClickListener2;
        this.bGm = onClickListener3;
        this.bGn = onClickListener4;
        this.bGo = onClickListener5;
        aad();
        this.bGe = (ClickableLayout4Frame) this.rootView.findViewById(w.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(w.new_sub_pb_list);
        this.bGc.setOnClickListener(new o(this));
        this.bGi = (LinearLayout) this.rootView.findViewById(w.sub_pb_bottom_layout);
        ZV();
        this.bGj = (TextView) this.rootView.findViewById(w.sub_pb_bottom_text);
        this.bBC = (HeadImageView) this.bGc.findViewById(w.photo);
        this.aHf = (TextView) this.bGc.findViewById(w.user_name);
        this.bBD = (TextView) this.bGc.findViewById(w.user_rank);
        this.bBE = (ImageView) this.bGc.findViewById(w.user_gender);
        this.bBI = (ImageView) this.bGc.findViewById(w.reply);
        this.bGg = (Button) this.bGc.findViewById(w.manage_btn);
        this.bGf = (TextView) this.bGc.findViewById(w.floor);
        this.bBH = (ImageView) this.bGc.findViewById(w.floor_owner);
        this.bBG = (TextView) this.bGc.findViewById(w.time);
        this.aVu = (UserIconBox) this.bGc.findViewById(w.user_icon_box);
        this.aCo = (UserIconBox) this.bGc.findViewById(w.user_tshow_icon_box);
        this.bBJ = (TbRichTextView) this.bGc.findViewById(w.richText);
        this.bBJ.setTextSize(TbConfig.getContentSize());
        this.bBJ.setVoiceViewRes(x.voice_play_btn);
        this.mListView.addHeaderView(this.bGc);
        C(onClickListener3);
        this.bGh = new d(this.mActivity.getPageContext().getPageActivity());
        this.bGk = this.bGh.getView();
        this.mListView.setNextPage(this.bGh);
        this.bGh.setOnClickListener(this.aHC);
        this.mListView.setOnItemClickListener(this.bGw);
        this.mListView.setOnItemLongClickListener(this.wP);
        this.bGi.setOnClickListener(this.aHC);
        this.mProgress = (ProgressBar) this.rootView.findViewById(w.progress);
        this.bBC.setOnClickListener(onClickListener3);
        init();
        if (this.bGc != null) {
            this.bGc.setVisibility(4);
        }
        if (this.bGe != null) {
            this.bGe.setVisibility(4);
        }
        if (this.bGi != null) {
            this.bGi.setVisibility(4);
        }
    }

    protected void ZV() {
        this.aCF = (PbEditor) this.rootView.findViewById(w.sub_pb_editor);
        this.aCF.aK(true);
        this.aCF.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aCF.setMaxTextCount(140);
    }

    protected void C(View.OnClickListener onClickListener) {
        this.bGd = new a(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bGd.B(this.bFt);
        this.bGd.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bGd);
    }

    protected void aad() {
        this.rootView = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_layout, null);
        this.bGc = com.baidu.adp.lib.g.b.ei().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_head, null);
    }

    protected void init() {
        this.mImageMaxWidth = Math.min(com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        aag();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void aae() {
        if (!this.aCF.afN()) {
            hJ(null);
        }
    }

    public String aaf() {
        return this.bGt;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new p(this, view, i), 300L);
    }

    protected void aag() {
        TextView textView = new TextView(this.mActivity.getPageContext().getPageActivity());
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.aCF.setAudioFocusable(z);
    }

    public boolean ZU() {
        this.bGv = false;
        if (this.aCF.isVisible()) {
            this.aCF.agk();
            this.aCF.hide();
            this.bGi.setEnabled(true);
            return true;
        }
        this.aCF.clearData();
        this.bGr = null;
        this.bGt = null;
        this.bGs = null;
        return false;
    }

    public void dP(boolean z) {
        this.bBj = z;
        this.bGd.dP(z);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.akz = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.bES = rVar;
    }

    public void hi(int i) {
        this.bBJ.setMaxImageWidth(i);
        this.bBJ.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void YT() {
        this.aCF.YT();
    }

    public void YU() {
        this.aCF.YU();
    }

    public View getRootView() {
        return this.rootView;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aCF.getAudioData();
    }

    public void FO() {
        this.aCF.FO();
    }

    public void A(ArrayList<String> arrayList) {
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
                    this.aCF.getEditText().getText().insert(this.aCF.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void aO(String str, String str2) {
        this.bGt = str2;
        hJ(str);
        new Handler().postDelayed(new q(this, str2), 200L);
    }

    public void hJ(String str) {
        this.bGv = true;
        this.aCF.yR();
        this.bGi.setEnabled(false);
        if (str != null) {
            this.aCF.getEditText().setText(this.mActivity.getResources().getString(z.reply_sub_floor).replace("%s", str));
            this.aCF.getEditText().setSelection(this.aCF.getEditText().getText().length());
        }
        if (this.aCF.afN()) {
            this.aCF.agj();
            this.aCF.aae();
        } else {
            this.aCF.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aCF.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hK(String str) {
        this.bGv = true;
        this.aCF.yR();
        this.bGi.setEnabled(false);
        this.aCF.getEditText().setText(str);
        this.aCF.getEditText().setSelection(this.aCF.getEditText().getText().length());
        if (this.aCF.afN()) {
            this.aCF.agj();
            this.aCF.aae();
        } else {
            this.aCF.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aCF.getEditText(), 200);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void aah() {
        this.bGv = false;
        this.aCF.hide();
        this.bGi.setEnabled(true);
    }

    public void aai() {
        this.mListView.setNextPage(this.bGh);
        this.bGh.startLoadData();
    }

    public void dO(boolean z) {
        this.bBi = z;
    }

    public void IP() {
        this.bGd.setDatas(null);
        this.bGd.notifyDataSetChanged();
        this.aCF.getEditText().setText("");
        this.aCF.clearData();
    }

    public String aaj() {
        return this.bGr;
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i) {
        String userId;
        boolean z = true;
        if (oVar != null) {
            if (this.bGc != null) {
                this.bGc.setVisibility(0);
            }
            if (this.bGe != null) {
                this.bGe.setVisibility(0);
            }
            if (this.bGi != null) {
                this.bGi.setVisibility(0);
            }
            if (oVar.ahH() != null) {
                this.bGr = oVar.ahH().getId();
            }
            if (oVar.hasMore()) {
                this.mListView.setNextPage(this.bGh);
                this.bGd.ee(true);
            } else {
                this.mListView.setNextPage(null);
                this.bGd.ee(false);
            }
            this.bGh.hh(c(oVar));
            this.bGs = oVar.ahJ();
            this.bGd.setDatas(this.bGs);
            if (oVar.ahM() == null || oVar.ahM().getAuthor() == null || (userId = oVar.ahM().getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            this.bGd.u(i, z);
            this.bGd.notifyDataSetChanged();
            a(oVar.ahH(), oVar.RR(), oVar.li());
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aCF.a(this.mActivity.getPageContext(), new r(this, wVar));
        }
    }

    protected int c(com.baidu.tieba.tbadkCore.b.o oVar) {
        if (oVar == null) {
            return 0;
        }
        return oVar.getTotalCount() - oVar.ahJ().size();
    }

    public void setPosition(int i) {
        this.mListView.setSelection(i);
        this.mListView.invalidate();
    }

    public void hL(String str) {
        int hF;
        if (str != null && !str.equals("") && (hF = this.bGd.hF(str)) >= 0) {
            this.mListView.setSelection(hF + 1);
            this.mListView.invalidate();
        }
    }

    public void clearContent() {
        this.aCF.clearData();
    }

    public View aak() {
        return this.bBI;
    }

    protected void a(com.baidu.tieba.tbadkCore.b.k kVar, boolean z, boolean z2) {
        int i;
        if (kVar != null) {
            this.bBC.setTag(null);
            this.bBC.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.bGc.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bGc.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.tag_clip_board, kVar);
            sparseArray.put(w.tag_is_subpb, false);
            this.bBI.setTag(sparseArray);
            if (!this.bBj) {
                this.bBC.setVisibility(8);
            }
            this.aHf.setOnClickListener(this.bGm);
            this.aHf.setText((CharSequence) null);
            this.bBD.setText((CharSequence) null);
            this.bBD.setBackgroundDrawable(null);
            this.bBH.setVisibility(8);
            this.bGf.setText((CharSequence) null);
            this.bBI.setOnClickListener(this.aHC);
            bc.b(this.bBG, t.pb_listitem_post_time, 1);
            this.bBG.setText(bf.n(kVar.getTime()));
            if (z) {
                this.bBH.setVisibility(0);
                bc.c(this.bBH, v.icon_floorhost);
            }
            if (this.bBi) {
                i = v.img_default_100;
            } else {
                i = v.icon_click;
            }
            this.bBJ.setDefaultImageId(i);
            this.bGf.setText(String.format(this.mActivity.getPageContext().getString(z.is_floor), Integer.valueOf(kVar.ahy())));
            String portrait = kVar.getAuthor().getPortrait();
            if (kVar.getAuthor() != null) {
                this.aHf.setText(kVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    bc.b(this.aHf, t.cp_cont_h, 1);
                } else {
                    bc.b(this.aHf, t.cp_cont_f, 1);
                }
                int level_id = kVar.getAuthor().getLevel_id();
                int is_bawu = kVar.getAuthor().getIs_bawu();
                String bawu_type = kVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bBD.setVisibility(0);
                    this.bBD.setText(String.valueOf(level_id));
                    bc.i((View) this.bBD, com.baidu.tbadk.core.util.d.bP(level_id));
                    this.bBD.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.bBD.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bBD.setText((CharSequence) null);
                        bc.i((View) this.bBD, v.pb_manager);
                        this.bBD.setOnClickListener(this.bGn);
                    } else if (bawu_type.equals("assist")) {
                        this.bBD.setText((CharSequence) null);
                        bc.i((View) this.bBD, v.pb_assist);
                        this.bBD.setOnClickListener(this.bGn);
                    }
                }
                if (kVar.getAuthor().getGender() == 2) {
                    bc.c(this.bBE, v.icon_pop_girl_square);
                    this.bBE.setVisibility(0);
                } else {
                    this.bBE.setVisibility(8);
                }
                this.bBp = kVar.getAuthor().getIconInfo();
                this.aCb = kVar.getAuthor().getTShowInfo();
                if (this.aVu != null) {
                    this.aVu.setOnClickListener(this.bGn);
                    this.aVu.a(this.bBp, i2, this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_margin));
                }
                if (this.aCo != null) {
                    this.aCo.setOnClickListener(this.bGo);
                    this.aCo.a(this.aCb, 2, this.mActivity.getResources().getDimensionPixelSize(u.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(u.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(u.big_icon_margin), true);
                }
            }
            this.bBC.setUserId(kVar.getAuthor().getUserId());
            this.bBC.setUserName(kVar.getAuthor().getUserName());
            this.aHf.setTag(w.tag_user_id, kVar.getAuthor().getUserId());
            this.aHf.setTag(w.tag_user_name, kVar.getAuthor().getUserName());
            this.bBC.setDefaultResource(v.photo);
            this.bBC.d(portrait, 28, false);
            this.bBJ.c(this.bBi, false);
            this.bBJ.setIsFromCDN(this.mIsFromCDN);
            this.bBJ.setText(kVar.ahz());
            this.bBJ.setOnImageClickListener(this.akz);
            this.bBJ.setOnEmotionClickListener(this.bES);
            this.bGg.setVisibility(8);
            if (!TextUtils.isEmpty(kVar.getBimg_url()) && this.bBi) {
                this.bBJ.setBackgroundDrawable(null);
                this.bBJ.setTag(kVar.getBimg_url());
                com.baidu.adp.lib.f.d.ec().a(kVar.getBimg_url(), 19, new s(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bBJ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bBJ.setPadding(0, 0, 0, 0);
            this.bBJ.setLayoutParams(layoutParams);
            this.bBJ.setBackgroundDrawable(null);
        }
    }

    public View aal() {
        return this.bGk;
    }

    public String aam() {
        return this.aCF.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.rootView);
        this.mActivity.getLayoutMode().h(this.bGc);
        this.mActivity.getLayoutMode().h(this.bGk);
        bc.i((View) this.bGp, v.btn_pb_editor_post_btn);
        bc.c(this.bBI, v.btn_pb_reply_selector);
        this.bBJ.setTextColor(bc.getColor(t.pb_listitem_content));
        this.bBJ.setVideoImageId(v.pic_video);
        this.aCF.b(this.mActivity.getPageContext(), i);
    }

    public void YF() {
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void aan() {
        this.mProgress.setVisibility(0);
    }

    public void aao() {
        this.mProgress.setVisibility(8);
    }

    public void aap() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bGh.qK();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bGq = onLongClickListener;
        this.bGc.setOnLongClickListener(this.bGq);
    }

    public View aaq() {
        return this.bGc;
    }

    public void hI(String str) {
        int hF = this.bGd.hF(str);
        if (hF > -1) {
            this.mListView.setSelection(hF + 1);
            this.mListView.invalidate();
        }
    }

    public void eg(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean FJ() {
        return this.aCF.FJ();
    }

    public PbEditor FF() {
        return this.aCF;
    }
}
