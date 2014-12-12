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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.ba;
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
    protected UserIconBox aBn;
    protected TextView aFV;
    protected View.OnClickListener aGs;
    protected UserIconBox aUb;
    protected View.OnClickListener bDI;
    protected View.OnClickListener bEB;
    protected View.OnClickListener bEC;
    protected View.OnClickListener bED;
    private ArrayList<com.baidu.tieba.tbadkCore.b.k> bEH;
    private String bEI;
    protected ClickableLayout4Frame bEt;
    protected TextView bEu;
    protected Button bEv;
    protected d bEw;
    protected LinearLayout bEx;
    protected TextView bEy;
    protected View bEz;
    protected HeadImageView bzS;
    protected TextView bzT;
    protected ImageView bzU;
    protected TextView bzW;
    protected ImageView bzX;
    protected ImageView bzY;
    protected TbRichTextView bzZ;
    protected BaseActivity mActivity;
    protected Handler mHandler;
    protected BdListView mListView;
    protected ProgressBar mProgress;
    protected View rootView = null;
    protected View bEr = null;
    protected a bEs = null;
    protected LinearLayout bEA = null;
    protected int mImageMaxWidth = 0;
    protected boolean bzy = true;
    protected boolean bzz = true;
    private boolean mIsFromCDN = true;
    protected Button bEE = null;
    protected com.baidu.tbadk.widget.richText.s ajW = null;
    protected com.baidu.tbadk.widget.richText.r bDh = null;
    protected View.OnLongClickListener bEF = null;
    private ArrayList<IconData> bzF = null;
    private ArrayList<IconData> aBa = null;
    protected PbEditor aBE = null;
    private String bEG = null;
    private String bEJ = null;
    private boolean bEK = false;
    protected AdapterView.OnItemClickListener bEL = new m(this);
    protected AdapterView.OnItemLongClickListener wP = new n(this);

    public l(BaseActivity baseActivity, boolean z, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4, View.OnClickListener onClickListener5) {
        this.mListView = null;
        this.mActivity = null;
        this.bEt = null;
        this.bzS = null;
        this.aFV = null;
        this.bzT = null;
        this.bzU = null;
        this.bEu = null;
        this.bzX = null;
        this.bzW = null;
        this.bzZ = null;
        this.bzY = null;
        this.bEv = null;
        this.bEw = null;
        this.bEx = null;
        this.bEy = null;
        this.bEz = null;
        this.aUb = null;
        this.aBn = null;
        this.aGs = null;
        this.bEB = null;
        this.bDI = null;
        this.bEC = null;
        this.bED = null;
        this.mHandler = null;
        this.mProgress = null;
        this.mActivity = baseActivity;
        this.mHandler = new Handler();
        this.aGs = onClickListener;
        this.bDI = onClickListener2;
        this.bEB = onClickListener3;
        this.bEC = onClickListener4;
        this.bED = onClickListener5;
        Zy();
        this.bEt = (ClickableLayout4Frame) this.rootView.findViewById(w.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(w.new_sub_pb_list);
        this.bEr.setOnClickListener(new o(this));
        this.bEx = (LinearLayout) this.rootView.findViewById(w.sub_pb_bottom_layout);
        Zq();
        this.bEy = (TextView) this.rootView.findViewById(w.sub_pb_bottom_text);
        this.bzS = (HeadImageView) this.bEr.findViewById(w.photo);
        this.aFV = (TextView) this.bEr.findViewById(w.user_name);
        this.bzT = (TextView) this.bEr.findViewById(w.user_rank);
        this.bzU = (ImageView) this.bEr.findViewById(w.user_gender);
        this.bzY = (ImageView) this.bEr.findViewById(w.reply);
        this.bEv = (Button) this.bEr.findViewById(w.manage_btn);
        this.bEu = (TextView) this.bEr.findViewById(w.floor);
        this.bzX = (ImageView) this.bEr.findViewById(w.floor_owner);
        this.bzW = (TextView) this.bEr.findViewById(w.time);
        this.aUb = (UserIconBox) this.bEr.findViewById(w.user_icon_box);
        this.aBn = (UserIconBox) this.bEr.findViewById(w.user_tshow_icon_box);
        this.bzZ = (TbRichTextView) this.bEr.findViewById(w.richText);
        this.bzZ.setTextSize(TbConfig.getContentSize());
        this.bzZ.setVoiceViewRes(x.voice_play_btn);
        this.mListView.addHeaderView(this.bEr);
        B(onClickListener3);
        this.bEw = new d(this.mActivity.getPageContext().getPageActivity());
        this.bEz = this.bEw.getView();
        this.mListView.setNextPage(this.bEw);
        this.bEw.setOnClickListener(this.aGs);
        this.mListView.setOnItemClickListener(this.bEL);
        this.mListView.setOnItemLongClickListener(this.wP);
        this.bEx.setOnClickListener(this.aGs);
        this.mProgress = (ProgressBar) this.rootView.findViewById(w.progress);
        this.bzS.setOnClickListener(onClickListener3);
        init();
        if (this.bEr != null) {
            this.bEr.setVisibility(4);
        }
        if (this.bEt != null) {
            this.bEt.setVisibility(4);
        }
        if (this.bEx != null) {
            this.bEx.setVisibility(4);
        }
    }

    protected void Zq() {
        this.aBE = (PbEditor) this.rootView.findViewById(w.sub_pb_editor);
        this.aBE.aI(true);
        this.aBE.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aBE.setMaxTextCount(140);
    }

    protected void B(View.OnClickListener onClickListener) {
        this.bEs = new a(this.mActivity.getPageContext().getPageActivity(), onClickListener);
        this.bEs.A(this.bDI);
        this.bEs.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bEs);
    }

    protected void Zy() {
        this.rootView = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_layout, null);
        this.bEr = com.baidu.adp.lib.g.b.ek().inflate(this.mActivity.getPageContext().getPageActivity(), x.new_sub_pb_head, null);
    }

    protected void init() {
        this.mImageMaxWidth = Math.min(com.baidu.adp.lib.util.l.dip2px(this.mActivity.getPageContext().getPageActivity(), 427.0f), (int) TbConfig.PB_IMAGE_NEW_MAX_WIDTH);
        ZB();
        onChangeSkinType(TbadkCoreApplication.m255getInst().getSkinType());
    }

    public void Zz() {
        if (!this.aBE.afj()) {
            hC(null);
        }
    }

    public String ZA() {
        return this.bEI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i, View view) {
        new Handler().postDelayed(new p(this, view, i), 300L);
    }

    protected void ZB() {
        TextView textView = new TextView(this.mActivity.getPageContext().getPageActivity());
        textView.setLineSpacing(0.0f, 1.2f);
        textView.setTextSize(TbConfig.getContentSize());
    }

    public void setAudioFocusable(boolean z) {
        this.aBE.setAudioFocusable(z);
    }

    public boolean Zp() {
        this.bEK = false;
        if (this.aBE.isVisible()) {
            this.aBE.afG();
            this.aBE.hide();
            this.bEx.setEnabled(true);
            return true;
        }
        this.aBE.clearData();
        this.bEG = null;
        this.bEI = null;
        this.bEH = null;
        return false;
    }

    public void dJ(boolean z) {
        this.bzz = z;
        this.bEs.dJ(z);
    }

    public void setOnImageClickListener(com.baidu.tbadk.widget.richText.s sVar) {
        this.ajW = sVar;
    }

    public void setOnEmotionClickListener(com.baidu.tbadk.widget.richText.r rVar) {
        this.bDh = rVar;
    }

    public void gZ(int i) {
        this.bzZ.setMaxImageWidth(i);
        this.bzZ.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void Yo() {
        this.aBE.Yo();
    }

    public void Yp() {
        this.aBE.Yp();
    }

    public View getRootView() {
        return this.rootView;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aBE.getAudioData();
    }

    public void Fq() {
        this.aBE.Fq();
    }

    public void z(ArrayList<String> arrayList) {
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
                    this.aBE.getEditText().getText().insert(this.aBE.getEditText().getSelectionStart(), sb2);
                    return;
                }
            }
        }
    }

    public void aL(String str, String str2) {
        this.bEI = str2;
        hC(str);
        new Handler().postDelayed(new q(this, str2), 200L);
    }

    public void hC(String str) {
        this.bEK = true;
        this.aBE.yB();
        this.bEx.setEnabled(false);
        if (str != null) {
            this.aBE.getEditText().setText(this.mActivity.getResources().getString(z.reply_sub_floor).replace("%s", str));
            this.aBE.getEditText().setSelection(this.aBE.getEditText().getText().length());
        }
        if (this.aBE.afj()) {
            this.aBE.afF();
            this.aBE.Zz();
        } else {
            this.aBE.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aBE.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hD(String str) {
        this.bEK = true;
        this.aBE.yB();
        this.bEx.setEnabled(false);
        this.aBE.getEditText().setText(str);
        this.aBE.getEditText().setSelection(this.aBE.getEditText().getText().length());
        if (this.aBE.afj()) {
            this.aBE.afF();
            this.aBE.Zz();
        } else {
            this.aBE.getEditText().requestFocus();
            this.mActivity.ShowSoftKeyPadDelay(this.aBE.getEditText(), Constants.MEDIA_INFO);
        }
        TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void ZC() {
        this.bEK = false;
        this.aBE.hide();
        this.bEx.setEnabled(true);
    }

    public void ZD() {
        this.mListView.setNextPage(this.bEw);
        this.bEw.startLoadData();
    }

    public void dI(boolean z) {
        this.bzy = z;
    }

    public void Ir() {
        this.bEs.setDatas(null);
        this.bEs.notifyDataSetChanged();
        this.aBE.getEditText().setText("");
        this.aBE.clearData();
    }

    public String ZE() {
        return this.bEG;
    }

    public void a(com.baidu.tieba.tbadkCore.b.o oVar, int i) {
        String userId;
        boolean z = true;
        if (oVar != null) {
            if (this.bEr != null) {
                this.bEr.setVisibility(0);
            }
            if (this.bEt != null) {
                this.bEt.setVisibility(0);
            }
            if (this.bEx != null) {
                this.bEx.setVisibility(0);
            }
            if (oVar.ahc() != null) {
                this.bEG = oVar.ahc().getId();
            }
            if (oVar.hasMore()) {
                this.mListView.setNextPage(this.bEw);
                this.bEs.dY(true);
            } else {
                this.mListView.setNextPage(null);
                this.bEs.dY(false);
            }
            this.bEw.gY(c(oVar));
            this.bEH = oVar.ahe();
            this.bEs.setDatas(this.bEH);
            if (oVar.ahh() == null || oVar.ahh().getAuthor() == null || (userId = oVar.ahh().getAuthor().getUserId()) == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = false;
            }
            this.bEs.t(i, z);
            this.bEs.notifyDataSetChanged();
            a(oVar.ahc(), oVar.Rv(), oVar.li());
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.w wVar) {
        if (wVar != null) {
            this.aBE.a(this.mActivity.getPageContext(), new r(this, wVar));
        }
    }

    protected int c(com.baidu.tieba.tbadkCore.b.o oVar) {
        if (oVar == null) {
            return 0;
        }
        return oVar.getTotalCount() - oVar.ahe().size();
    }

    public void setPosition(int i) {
        this.mListView.setSelection(i);
        this.mListView.invalidate();
    }

    public void hE(String str) {
        int hy;
        if (str != null && !str.equals("") && (hy = this.bEs.hy(str)) >= 0) {
            this.mListView.setSelection(hy + 1);
            this.mListView.invalidate();
        }
    }

    public void clearContent() {
        this.aBE.clearData();
    }

    public View ZF() {
        return this.bzY;
    }

    protected void a(com.baidu.tieba.tbadkCore.b.k kVar, boolean z, boolean z2) {
        int i;
        if (kVar != null) {
            this.bzS.setTag(null);
            this.bzS.setUserId(null);
            SparseArray sparseArray = (SparseArray) this.bEr.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                this.bEr.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.tag_clip_board, kVar);
            sparseArray.put(w.tag_is_subpb, false);
            this.bzY.setTag(sparseArray);
            if (!this.bzz) {
                this.bzS.setVisibility(8);
            }
            this.aFV.setOnClickListener(this.bEB);
            this.aFV.setText((CharSequence) null);
            this.bzT.setText((CharSequence) null);
            this.bzT.setBackgroundDrawable(null);
            this.bzX.setVisibility(8);
            this.bEu.setText((CharSequence) null);
            this.bzY.setOnClickListener(this.aGs);
            TbadkCoreApplication.m255getInst().getSkinType();
            ax.b(this.bzW, t.pb_listitem_post_time, 1);
            this.bzW.setText(ba.n(kVar.getTime()));
            if (z) {
                this.bzX.setVisibility(0);
                ax.c(this.bzX, v.icon_floorhost);
            }
            if (this.bzy) {
                i = v.img_default_100;
            } else {
                i = v.icon_click;
            }
            this.bzZ.setDefaultImageId(i);
            this.bEu.setText(String.format(this.mActivity.getPageContext().getString(z.is_floor), Integer.valueOf(kVar.agT())));
            String portrait = kVar.getAuthor().getPortrait();
            if (kVar.getAuthor() != null) {
                this.aFV.setText(kVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = kVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    ax.b(this.aFV, t.cp_cont_h, 1);
                } else {
                    ax.b(this.aFV, t.cp_cont_f, 1);
                }
                int level_id = kVar.getAuthor().getLevel_id();
                int is_bawu = kVar.getAuthor().getIs_bawu();
                String bawu_type = kVar.getAuthor().getBawu_type();
                int i2 = 3;
                if (level_id != 0) {
                    this.bzT.setVisibility(0);
                    this.bzT.setText(String.valueOf(level_id));
                    ax.i((View) this.bzT, com.baidu.tbadk.core.util.d.bK(level_id));
                    this.bzT.setOnClickListener(null);
                    i2 = 2;
                } else {
                    this.bzT.setVisibility(8);
                }
                if (is_bawu != 0) {
                    if (bawu_type.equals("manager")) {
                        this.bzT.setText((CharSequence) null);
                        ax.i((View) this.bzT, v.pb_manager);
                        this.bzT.setOnClickListener(this.bEC);
                    } else if (bawu_type.equals("assist")) {
                        this.bzT.setText((CharSequence) null);
                        ax.i((View) this.bzT, v.pb_assist);
                        this.bzT.setOnClickListener(this.bEC);
                    }
                }
                if (kVar.getAuthor().getGender() == 2) {
                    ax.c(this.bzU, v.icon_pop_girl_square);
                    this.bzU.setVisibility(0);
                } else {
                    this.bzU.setVisibility(8);
                }
                this.bzF = kVar.getAuthor().getIconInfo();
                this.aBa = kVar.getAuthor().getTShowInfo();
                if (this.aUb != null) {
                    this.aUb.setOnClickListener(this.bEC);
                    this.aUb.a(this.bzF, i2, this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_width), this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_height), this.mActivity.getResources().getDimensionPixelSize(u.pb_icon_margin));
                }
                if (this.aBn != null) {
                    this.aBn.setOnClickListener(this.bED);
                    this.aBn.a(this.aBa, 2, this.mActivity.getResources().getDimensionPixelSize(u.big_icon_width), this.mActivity.getResources().getDimensionPixelSize(u.big_icon_height), this.mActivity.getResources().getDimensionPixelSize(u.big_icon_margin), true);
                }
            }
            this.bzS.setUserId(kVar.getAuthor().getUserId());
            this.bzS.setUserName(kVar.getAuthor().getUserName());
            this.aFV.setTag(w.tag_user_id, kVar.getAuthor().getUserId());
            this.aFV.setTag(w.tag_user_name, kVar.getAuthor().getUserName());
            this.bzS.setDefaultResource(v.photo);
            this.bzS.d(portrait, 28, false);
            this.bzZ.c(this.bzy, false);
            this.bzZ.setIsFromCDN(this.mIsFromCDN);
            this.bzZ.setText(kVar.agU());
            this.bzZ.setOnImageClickListener(this.ajW);
            this.bzZ.setOnEmotionClickListener(this.bDh);
            this.bEv.setVisibility(8);
            if (!TextUtils.isEmpty(kVar.getBimg_url()) && this.bzy) {
                this.bzZ.setBackgroundDrawable(null);
                this.bzZ.setTag(kVar.getBimg_url());
                com.baidu.adp.lib.f.d.ee().a(kVar.getBimg_url(), 19, new s(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bzZ.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bzZ.setPadding(0, 0, 0, 0);
            this.bzZ.setLayoutParams(layoutParams);
            this.bzZ.setBackgroundDrawable(null);
        }
    }

    public View ZG() {
        return this.bEz;
    }

    public String ZH() {
        return this.aBE.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.mActivity.getLayoutMode().ab(i == 1);
        this.mActivity.getLayoutMode().h(this.rootView);
        this.mActivity.getLayoutMode().h(this.bEr);
        this.mActivity.getLayoutMode().h(this.bEz);
        ax.i((View) this.bEE, v.btn_pb_editor_post_btn);
        ax.c(this.bzY, v.btn_pb_reply_selector);
        this.bzZ.setTextColor(ax.getColor(t.pb_listitem_content));
        this.bzZ.setVideoImageId(v.pic_video);
        this.aBE.b(this.mActivity.getPageContext(), i);
    }

    public void Ya() {
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(0);
    }

    public void ZI() {
        this.mProgress.setVisibility(0);
    }

    public void ZJ() {
        this.mProgress.setVisibility(8);
    }

    public void ZK() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bEw.qz();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bEF = onLongClickListener;
        this.bEr.setOnLongClickListener(this.bEF);
    }

    public View ZL() {
        return this.bEr;
    }

    public void hB(String str) {
        int hy = this.bEs.hy(str);
        if (hy > -1) {
            this.mListView.setSelection(hy + 1);
            this.mListView.invalidate();
        }
    }

    public void ea(boolean z) {
        this.mIsFromCDN = z;
    }

    public boolean Fl() {
        return this.aBE.Fl();
    }

    public PbEditor Fh() {
        return this.aBE;
    }
}
