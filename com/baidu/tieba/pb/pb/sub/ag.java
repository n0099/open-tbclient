package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.os.Handler;
import android.support.v4.media.TransportMediator;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.Cdo;
import com.baidu.tieba.pb.pb.main.ev;
import com.baidu.tieba.pb.pb.main.ew;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ag {
    private static final int evA = TbadkCoreApplication.m9getInst().getListItemRule().xN();
    private BdListView Cj;
    public ViewStub aYe;
    public TbImageView aYf;
    private View bLK;
    private NoNetworkView bMQ;
    private View.OnClickListener bmb;
    private ProgressBar coz;
    private RelativeLayout eiw;
    private Cdo enm;
    private com.baidu.tbadk.core.view.a etH;
    private View evB;
    private av evC;
    private NewSubPbActivity evD;
    private RelativeLayout evE;
    private LinearLayout evG;
    public RelativeLayout evM;
    public LinearLayout evN;
    public ImageView evO;
    public TextView evP;
    public TextView evQ;
    private TextView evR;
    private ThreadSkinView evS;
    private com.baidu.tieba.pb.view.c evT;
    private LinearLayout evU;
    private aw evV;
    private View evY;
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> ewc;
    private String ewd;
    private com.baidu.tieba.pb.data.m ewe;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private TbRichTextView.d evq = null;
    private View.OnClickListener MT = null;
    private TbRichTextView.e evp = null;
    private NavigationBar mNavigationBar = null;
    private TextView evF = null;
    private TextView VM = null;
    private HeadImageView elN = null;
    private HeadPendantView evH = null;
    private ClickableHeaderImageView evI = null;
    private TextView aVl = null;
    private ImageView elO = null;
    private ImageView elQ = null;
    private TextView evJ = null;
    private ImageView elT = null;
    private TextView elS = null;
    private TbRichTextView elV = null;
    private ImageView elU = null;
    private ImageView evK = null;
    private TextView evL = null;
    private MorePopupWindow evW = null;
    private ev evX = null;
    private com.baidu.tbadk.core.dialog.c etq = null;
    private UserIconBox cgs = null;
    private UserIconBox ahO = null;
    private Dialog esW = null;
    private com.baidu.tbadk.core.dialog.a esY = null;
    private boolean cHP = true;
    private boolean elt = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bIX = null;
    private NewSubPbActivity.a evZ = null;
    private NewSubPbActivity.a ewa = null;
    private ArrayList<IconData> elx = null;
    private ArrayList<IconData> dbL = null;
    private com.baidu.tbadk.editortools.d.p dtc = null;
    private String ewb = null;
    private int aIv = 0;
    private com.baidu.tieba.tbadkCore.data.q ekz = null;
    protected HashMap<Long, HashSet<String>> ewf = new HashMap<>();
    protected final b.a ewg = new ah(this);
    private View.OnClickListener ely = new ao(this);
    private com.baidu.tieba.pb.a.d ekU = new com.baidu.tieba.pb.a.d(new ap(this));
    protected AdapterView.OnItemClickListener ewh = new aq(this);
    protected AdapterView.OnItemLongClickListener BH = new ar(this);

    public ag(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eiw = null;
        this.evB = null;
        this.Cj = null;
        this.evC = null;
        this.evD = null;
        this.bMQ = null;
        this.evE = null;
        this.evV = null;
        this.evY = null;
        this.bmb = null;
        this.coz = null;
        this.evD = newSubPbActivity;
        this.bmb = onClickListener;
        this.eiw = (RelativeLayout) LayoutInflater.from(this.evD.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_layout, (ViewGroup) null);
        this.evB = LayoutInflater.from(this.evD.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_head, (ViewGroup) null);
        this.bMQ = (NoNetworkView) this.eiw.findViewById(t.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.K(this.evD.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(t.e.ds60);
        aQn();
        Yv();
        this.evE = (RelativeLayout) this.eiw.findViewById(t.g.sub_pb_body_layout);
        this.Cj = (BdListView) this.eiw.findViewById(t.g.new_sub_pb_list);
        this.evS = (ThreadSkinView) LayoutInflater.from(this.evD.getPageContext().getPageActivity()).inflate(t.h.thread_skin_layout, (ViewGroup) null);
        this.Cj.addHeaderView(this.evS);
        this.Cj.addHeaderView(this.evB);
        this.bLK = BdListViewHelper.a(this.evD.getActivity(), this.Cj, BdListViewHelper.HeadType.DEFAULT);
        this.evC = new av(this.evD.getPageContext().getPageActivity());
        this.evC.I(this.ely);
        this.evC.setIsFromCDN(this.mIsFromCDN);
        this.evC.iG(true);
        this.Cj.setAdapter((ListAdapter) this.evC);
        this.evV = new aw(this.evD.getPageContext());
        this.evY = this.evV.getView();
        this.Cj.setNextPage(this.evV);
        this.evV.setOnClickListener(this.bmb);
        this.Cj.setOnItemClickListener(this.ewh);
        this.Cj.setOnItemLongClickListener(this.BH);
        this.Cj.setOnTouchListener(this.ekU);
        this.coz = (ProgressBar) this.eiw.findViewById(t.g.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.evB != null) {
            this.evB.setVisibility(4);
        }
        if (this.evE != null) {
            this.evE.setVisibility(4);
        }
    }

    public void Yv() {
        this.evG = (LinearLayout) this.evB.findViewById(t.g.user_layout);
        this.elN = (HeadImageView) this.evB.findViewById(t.g.photo);
        this.aYf = (TbImageView) this.evB.findViewById(t.g.user_head_mask);
        this.elN.setRadius(com.baidu.adp.lib.util.k.e(this.evD.getActivity(), t.e.ds40));
        this.elN.setOnClickListener(this.bmb);
        this.evI = (ClickableHeaderImageView) this.evB.findViewById(t.g.god_user_photo);
        this.aYe = (ViewStub) this.evB.findViewById(t.g.viewstub_headimage_mask);
        this.evI.setGodIconMargin(0);
        this.evI.setRadius(com.baidu.adp.lib.util.k.e(this.evD.getActivity(), t.e.ds40));
        this.evI.setOnClickListener(this.bmb);
        this.evH = (HeadPendantView) this.evB.findViewById(t.g.subpb_pendant_photo);
        this.evH.vW();
        if (this.evH.getHeadView() != null) {
            this.evH.getHeadView().setIsRound(true);
            this.evH.getHeadView().setDrawBorder(false);
            this.evH.getHeadView().setOnClickListener(this.bmb);
        }
        if (this.evH.getPendantView() != null) {
            this.evH.getPendantView().setIsRound(true);
            this.evH.getPendantView().setDrawBorder(false);
        }
        this.aVl = (TextView) this.evB.findViewById(t.g.user_name);
        this.elO = (ImageView) this.evB.findViewById(t.g.user_rank);
        this.elQ = (ImageView) this.evB.findViewById(t.g.user_gender);
        this.elU = (ImageView) this.evB.findViewById(t.g.reply);
        this.evK = (ImageView) this.evB.findViewById(t.g.more);
        this.evJ = (TextView) this.evB.findViewById(t.g.floor);
        this.evJ.setTextSize(TbConfig.getContentSizeOfLzl(this.evD.getApplicationContext()));
        this.elT = (ImageView) this.evB.findViewById(t.g.floor_owner);
        this.elS = (TextView) this.evB.findViewById(t.g.time);
        this.elS.setTextSize(TbConfig.getContentSizeOfLzl(this.evD.getApplicationContext()));
        this.cgs = (UserIconBox) this.evB.findViewById(t.g.user_icon_box);
        this.ahO = (UserIconBox) this.evB.findViewById(t.g.user_tshow_icon_box);
        this.elV = (TbRichTextView) this.evB.findViewById(t.g.richText);
        this.elV.IO();
        this.elV.k(this.cHP, true);
        this.elV.setIsFromCDN(this.mIsFromCDN);
        this.elV.setImageViewStretch(true);
        this.elV.setTextSize(TbConfig.getContentSize());
        this.elV.setVoiceViewRes(t.h.voice_play_btn);
        this.evB.setOnTouchListener(this.ekU);
        this.evB.setOnClickListener(this.bmb);
        this.evL = (TextView) this.evB.findViewById(t.g.pb_item_tail_content);
        this.evL.setOnClickListener(this.bmb);
        this.evM = (RelativeLayout) this.evB.findViewById(t.g.chudian_info_container);
        this.evN = (LinearLayout) this.evB.findViewById(t.g.landmark_container);
        this.evO = (ImageView) this.evB.findViewById(t.g.landmark_icon);
        this.evP = (TextView) this.evB.findViewById(t.g.landmark_content);
        this.evQ = (TextView) this.evB.findViewById(t.g.ad_icon);
        this.evR = (TextView) this.evB.findViewById(t.g.subpb_newchudian_advertise);
        this.evU = (LinearLayout) this.evB.findViewById(t.g.chudian_container);
    }

    public void aQn() {
        this.mNavigationBar = (NavigationBar) this.eiw.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.VM = this.mNavigationBar.setTitleText("");
        this.evF = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.evD.getResources().getString(t.j.view_subject), this.bmb);
        this.evF.setVisibility(8);
    }

    public void aZ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.esW == null) {
            this.esW = new Dialog(this.evD.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.esW.setCanceledOnTouchOutside(true);
            this.esW.setCancelable(true);
            View inflate = LayoutInflater.from(this.evD.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
            this.evD.getLayoutMode().x(inflate);
            this.esW.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.esW.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.evD.getPageContext().getPageActivity()) * 0.9d);
            this.esW.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.esW.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.esW.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.esW.findViewById(t.g.disable_reply_btn);
        if ("".equals(sparseArray.get(t.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(t.g.tag_del_post_id, sparseArray.get(t.g.tag_del_post_id));
            sparseArray2.put(t.g.tag_del_post_type, sparseArray.get(t.g.tag_del_post_type));
            sparseArray2.put(t.g.tag_del_post_is_self, sparseArray.get(t.g.tag_del_post_is_self));
            sparseArray2.put(t.g.tag_manage_user_identity, sparseArray.get(t.g.tag_manage_user_identity));
            textView.setOnClickListener(new as(this));
        }
        if ("".equals(sparseArray.get(t.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(t.g.tag_forbid_user_name, sparseArray.get(t.g.tag_forbid_user_name));
            sparseArray3.put(t.g.tag_manage_user_identity, sparseArray.get(t.g.tag_manage_user_identity));
            sparseArray3.put(t.g.tag_forbid_user_post_id, sparseArray.get(t.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new at(this));
        }
        if (!((sparseArray.get(t.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(t.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(t.j.un_mute);
            } else {
                textView3.setText(t.j.mute);
            }
            sparseArray4.put(t.g.tag_is_mem, sparseArray.get(t.g.tag_is_mem));
            sparseArray4.put(t.g.tag_user_mute_mute_userid, sparseArray.get(t.g.tag_user_mute_mute_userid));
            sparseArray4.put(t.g.tag_user_mute_mute_username, sparseArray.get(t.g.tag_user_mute_mute_username));
            sparseArray4.put(t.g.tag_user_mute_post_id, sparseArray.get(t.g.tag_user_mute_post_id));
            sparseArray4.put(t.g.tag_user_mute_thread_id, sparseArray.get(t.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new au(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.esW, this.evD.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_del_post_id, str);
        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = t.j.del_post_confirm;
        if (i == 0) {
            i3 = t.j.del_thread_confirm;
        }
        this.esY = new com.baidu.tbadk.core.dialog.a(this.evD.getPageContext().getPageActivity());
        this.esY.bZ(i3);
        this.esY.A(sparseArray);
        this.esY.a(t.j.dialog_ok, new ai(this, sparseArray));
        this.esY.b(t.j.dialog_cancel, new aj(this));
        this.esY.aq(true);
        this.esY.b(this.evD.getPageContext());
        this.esY.sX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ir(boolean z) {
        if (this.Cj != null) {
            if (!z) {
                this.Cj.setEnabled(z);
            } else {
                this.Cj.postDelayed(new ak(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.etq != null) {
            this.etq.dismiss();
            this.etq = null;
        }
        if (z) {
            string = this.evD.getResources().getString(t.j.remove_mark);
        } else {
            string = this.evD.getResources().getString(t.j.mark);
        }
        this.etq = new com.baidu.tbadk.core.dialog.c(this.evD.getPageContext().getPageActivity());
        this.etq.cc(t.j.operation);
        this.etq.a(new String[]{this.evD.getResources().getString(t.j.copy), string}, bVar);
        this.etq.d(this.evD.getPageContext());
        this.etq.ta();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.evZ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.ewa = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.coz != null) {
            this.coz.setVisibility(8);
        }
        if (z && z2) {
            this.evD.showToast(this.evD.getResources().getString(t.j.success));
        } else if (str != null && z2) {
            this.evD.showToast(str);
        }
    }

    public void aY(View view) {
        if (this.bLK != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bLK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Cj != null) {
                    this.Cj.removeHeaderView(this.bLK);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bLK.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.evD.getActivity(), t.e.ds98)));
            } else if (this.Cj != null) {
                this.Cj.f(this.bLK, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.CG() != null) {
            this.dtc = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eiw.addView(pVar.CG(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new al(this, view, i), 300L);
    }

    public void hO(boolean z) {
        this.elt = z;
        this.evC.hO(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Cj.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.Cj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eiw;
    }

    public void bF(String str, String str2) {
        this.ewd = str2;
        new Handler().postDelayed(new am(this, str2, str), 200L);
    }

    public void aAE() {
        if (this.evW != null) {
            com.baidu.adp.lib.h.j.a(this.evW, this.evD.getPageContext().getPageActivity());
        }
        if (this.etq != null) {
            this.etq.dismiss();
        }
        if (this.esY != null) {
            this.esY.dismiss();
        }
        if (this.esW != null) {
            com.baidu.adp.lib.h.j.b(this.esW, this.evD.getPageContext());
        }
        if (this.coz != null) {
            this.coz.setVisibility(8);
        }
        if (this.enm != null) {
            this.enm.dismiss();
        }
    }

    public void aQo() {
        this.Cj.setNextPage(this.evV);
        this.evV.wl();
    }

    public void hN(boolean z) {
        this.cHP = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.m mVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z2 = false;
        if (mVar != null) {
            this.ewe = mVar;
            this.evC.r(this.ewe.Kw());
            if (this.evB != null) {
                this.evB.setVisibility(0);
            }
            if (this.evE != null) {
                this.evE.setVisibility(0);
            }
            if (mVar.aMh() != null) {
                this.ewb = mVar.aMh().getId();
                this.aIv = mVar.aMh().bjc();
                if (this.aIv > 0) {
                    this.VM.setText(String.format(this.evD.getPageContext().getString(t.j.is_floor), Integer.valueOf(this.aIv)));
                } else {
                    this.VM.setText((CharSequence) null);
                }
                String str = this.evD.aQl() ? "PB" : null;
                if (mVar.aMh().rU() != null) {
                    this.evS.a(this.evD.getPageContext(), mVar.aMh().rU(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", mVar.aMn().getId(), mVar.aMn().getName(), mVar.Kw().getId(), str));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.elN.getLayoutParams();
                    marginLayoutParams.topMargin = (int) this.evD.getResources().getDimension(t.e.ds20);
                    this.elN.setLayoutParams(marginLayoutParams);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.evI.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) this.evD.getResources().getDimension(t.e.ds20);
                    this.evI.setLayoutParams(marginLayoutParams2);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.evG.getLayoutParams();
                    marginLayoutParams3.topMargin = (int) this.evD.getResources().getDimension(t.e.ds36);
                    this.evG.setLayoutParams(marginLayoutParams3);
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.evK.getLayoutParams();
                    marginLayoutParams4.topMargin = (int) this.evD.getResources().getDimension(t.e.ds34);
                    this.evK.setLayoutParams(marginLayoutParams4);
                } else {
                    this.evS.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.evV.wl();
                this.evC.setHasMoreData(true);
            } else {
                this.evV.wm();
                this.evC.setHasMoreData(false);
            }
            this.ewc = mVar.aMl();
            if (this.ewc == null || this.ewc.size() == 0) {
                this.Cj.setNextPage(null);
            } else {
                this.Cj.setNextPage(this.evV);
            }
            if (this.ewc == null || this.ewc.size() <= evA) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.ewc.size() - evA;
                ou(size);
                int firstVisiblePosition = this.Cj.getFirstVisiblePosition() - size;
                View childAt = this.Cj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.evC.setDatas(this.ewc);
            if (mVar.Kw() != null && mVar.Kw().getAuthor() != null && (userId = mVar.Kw().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.evC.N(i, z2);
            this.evC.notifyDataSetChanged();
            a(mVar.aMh(), mVar.avC(), mVar.nv(), i, z);
            if (i4 > 0) {
                this.Cj.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View aQp() {
        return this.elU;
    }

    private void ou(int i) {
        if (this.ewc != null) {
            if (this.ewc.size() <= i) {
                this.ewc.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = this.ewc.iterator();
            while (it.hasNext()) {
                it.next();
                i2++;
                it.remove();
                if (i2 >= i) {
                    return;
                }
            }
        }
    }

    public boolean aQq() {
        return this.evC.bec;
    }

    private void a(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            this.evT = com.baidu.tieba.pb.d.a(this.evD);
            if (this.evT != null) {
                com.baidu.tbadk.core.util.av.j((View) this.evR, t.d.advert_label_color);
                this.evR.setVisibility(0);
                this.evR.setText(TextUtils.isEmpty(iVar.getTagName()) ? (String) TbadkCoreApplication.m9getInst().getContext().getResources().getText(t.j.advert_label) : iVar.getTagName());
                this.evT.a(this.ekz, this.ewg);
                this.evU.removeAllViews();
                this.evU.addView(this.evT.getView());
                this.evU.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.tbadkCore.data.q qVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (qVar != null) {
            this.ekz = qVar;
            com.baidu.tieba.tbadkCore.data.i bjm = qVar.bjm();
            if (bjm != null && bjm.fsh) {
                int biI = bjm.biI();
                if (biI == 2 || biI == 1 || biI == 3) {
                    this.evM.setVisibility(8);
                    a(bjm);
                } else {
                    this.evM.setVisibility(0);
                    com.baidu.tbadk.core.util.av.j((View) this.evQ, t.d.advert_label_color);
                    String position = bjm.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.evN.setVisibility(0);
                        this.evP.setText(position);
                    }
                    this.elV.setOnLinkImageClickListener(this.evp);
                    this.elV.setOnImageClickListener(this.evq);
                }
            } else {
                this.evM.setVisibility(8);
                if (z3) {
                    this.elV.setOnImageClickListener(this.evq);
                }
            }
            this.elN.setTag(null);
            this.elN.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.evB.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.evB.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(t.g.tag_clip_board, qVar);
            sparseArray.put(t.g.tag_is_subpb, false);
            a(qVar, i, sparseArray);
            this.evK.setTag(sparseArray);
            this.elU.setTag(sparseArray);
            this.aVl.setOnClickListener(this.bmb);
            this.aVl.setText((CharSequence) null);
            this.elT.setVisibility(8);
            this.evJ.setText((CharSequence) null);
            this.evK.setOnClickListener(this.bmb);
            this.elU.setOnClickListener(this.bmb);
            com.baidu.tbadk.core.util.av.c(this.elS, t.d.common_color_10078, 1);
            this.elS.setText(ba.t(qVar.getTime()));
            if (z) {
                this.elT.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(this.elT, t.f.icon_floorhost);
                this.elT.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
            if (this.cHP) {
                i2 = t.f.img_default_100;
            } else {
                i2 = t.f.icon_click;
            }
            this.elV.setDefaultImageId(i2);
            this.evJ.setText(String.format(this.evD.getPageContext().getString(t.j.is_floor), Integer.valueOf(qVar.bjc())));
            String portrait = qVar.getAuthor().getPortrait();
            if (qVar.getAuthor() != null) {
                String name_show = qVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.v.gz(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                }
                this.aVl.setText(name_show);
                ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.av.c(this.aVl, t.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.av.c(this.aVl, t.d.cp_cont_f, 1);
                }
                int level_id = qVar.getAuthor().getLevel_id();
                int is_bawu = qVar.getAuthor().getIs_bawu();
                String bawu_type = qVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !ew.g(this.ekz)) {
                    this.elO.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(this.elO, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.elO.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                    this.elO.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                    this.elO.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.elO.setVisibility(8);
                }
                int i4 = this.evR.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.elO.setOnClickListener(this.bmb);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.av.c(this.elO, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.av.c(this.elO, t.f.pb_assist);
                    }
                }
                if (qVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.av.c(this.elQ, t.f.icon_pb_pop_girl);
                    this.elQ.setVisibility(0);
                } else if (qVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.av.c(this.elQ, t.f.icon_pb_pop_boy);
                    this.elQ.setVisibility(0);
                } else {
                    this.elQ.setVisibility(8);
                }
                this.elQ.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.elx = qVar.getAuthor().getIconInfo();
                this.dbL = qVar.getAuthor().getTShowInfoNew();
                if (this.cgs != null) {
                    if (ew.g(qVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.elx.size()) {
                                break;
                            }
                            IconData iconData = this.elx.get(i6);
                            if (!ba.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.elx = arrayList;
                    }
                    this.cgs.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
                    this.cgs.setOnClickListener(this.bmb);
                    this.cgs.wC();
                    this.cgs.a(this.elx, i4, this.evD.getResources().getDimensionPixelSize(t.e.ds30), this.evD.getResources().getDimensionPixelSize(t.e.ds30), this.evD.getResources().getDimensionPixelSize(t.e.ds10));
                }
                if (this.ahO != null) {
                    this.ahO.setOnClickListener(this.bmb);
                    if (this.dbL != null && this.dbL.size() > 0 && this.dbL.get(0) != null) {
                        this.ahO.setTag(this.dbL.get(0).getUrl());
                    }
                    this.ahO.a(this.dbL, 2, this.evD.getResources().getDimensionPixelSize(t.e.ds30), this.evD.getResources().getDimensionPixelSize(t.e.ds32), this.evD.getResources().getDimensionPixelSize(t.e.ds8), true);
                }
            }
            a(this.elV, 0);
            UserTbVipInfoData userTbVipInfoData = qVar.getAuthor().getUserTbVipInfoData();
            this.evB.setPadding(this.evD.getResources().getDimensionPixelSize(t.e.ds32), 0, this.evD.getResources().getDimensionPixelSize(t.e.ds32), 0);
            if (aQI()) {
                this.evB.setPadding(this.evD.getResources().getDimensionPixelSize(t.e.ds18), 0, this.evD.getResources().getDimensionPixelSize(t.e.ds32), 0);
                if (!this.elt) {
                    this.elN.setVisibility(8);
                    this.evI.setVisibility(8);
                    this.evH.setVisibility(8);
                }
                this.evI.setVisibility(8);
                this.elN.setVisibility(4);
                this.evH.setVisibility(0);
                this.evH.dU(qVar.getAuthor().getPendantData().rc());
                this.evH.getHeadView().c(portrait, 28, false);
                this.evH.getHeadView().setUserId(qVar.getAuthor().getUserId());
                this.evH.getHeadView().setUserName(qVar.getAuthor().getUserName());
            }
            if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url()) && !aQI()) {
                this.evI.setVisibility(0);
                this.elN.setVisibility(4);
                if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null) {
                    if (this.aYe != null && this.elt) {
                        if (this.aYf == null) {
                            this.aYe.inflate();
                            this.aYf = (TbImageView) this.evB.findViewById(t.g.user_head_mask);
                        }
                        this.aYf.c(userTbVipInfoData.getvipV_url(), 10, false);
                        this.evI.setIsBigV(true);
                    }
                    this.evI.setUserId(qVar.getAuthor().getUserId());
                    this.evI.setUserName(qVar.getAuthor().getUserName());
                    this.evI.c(portrait, 28, false);
                }
                this.evH.setVisibility(8);
                return;
            }
            if (qVar.getAuthor().getGodUserData().getId() != null && qVar.getAuthor().getGodUserData().getType() == 2 && !aQI()) {
                this.evI.setVisibility(0);
                this.elN.setVisibility(4);
                this.evH.setVisibility(8);
                this.evI.setUserId(qVar.getAuthor().getUserId());
                this.evI.setUserName(qVar.getAuthor().getUserName());
                this.evI.c(portrait, 28, false);
            } else if (!aQI()) {
                this.evI.setVisibility(8);
                this.elN.setVisibility(0);
                this.evH.setVisibility(8);
                this.elN.setUserId(qVar.getAuthor().getUserId());
                this.elN.setUserName(qVar.getAuthor().getUserName());
                this.elN.setDefaultResource(t.f.transparent_bg);
                this.elN.setDefaultErrorResource(t.f.icon_default_avatar100);
                this.elN.c(portrait, 28, false);
            }
            if (!this.elt) {
                this.elN.setVisibility(8);
                this.evI.setVisibility(8);
                this.evH.setVisibility(8);
            }
            this.aVl.setTag(t.g.tag_user_id, qVar.getAuthor().getUserId());
            this.aVl.setTag(t.g.tag_user_name, qVar.getAuthor().getUserName());
            this.elV.setText(qVar.aAk());
            if (!TextUtils.isEmpty(qVar.getBimg_url())) {
                this.elV.setBackgroundDrawable(null);
                this.elV.setTag(qVar.getBimg_url());
                this.elV.setOnClickListener(this.bmb);
                this.elV.setTextViewOnClickListener(this.bmb);
                this.elV.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.eA().a(qVar.getBimg_url(), 19, new an(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.elV.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.elV.setPadding(0, 0, 0, 0);
                this.elV.setLayoutParams(layoutParams);
                this.elV.setBackgroundDrawable(null);
            }
            if (qVar != null) {
                com.baidu.tieba.pb.view.u.a(qVar.aQY(), this.evL, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth);
            this.elV.setMaxImageHeight((int) (this.maxImageWidth * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.evD.getPageContext().getString(t.j.refresh_view_title_text), this.MT));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.evD.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.evE, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, t.f.pic_emotion07, com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds320), com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds480), com.baidu.adp.lib.util.k.e(pageActivity, t.e.ds360)), dVar, a, false);
        }
        this.evE.setVisibility(0);
        this.Cj.setVisibility(8);
        this.coz.setVisibility(8);
        this.dtc.DO();
        com.baidu.tbadk.core.util.av.l(this.mNoDataView, t.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.evD.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void go(int i) {
        a(NoDataViewFactory.d.x(i, t.j.refresh_view_title_text));
    }

    public void pg(String str) {
        a(NoDataViewFactory.d.af(str, this.evD.getPageContext().getString(t.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Cj.setVisibility(0);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.MT = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.tbadkCore.data.q qVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (qVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = qVar.getAuthor().getUserId();
                boolean z8 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z8;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.ewe != null && this.ewe.Kw() != null && this.ewe.Kw().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.ewe.Kw().getAuthor().getUserId();
                String userId4 = qVar.getAuthor().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = false;
                        z3 = true;
                        z4 = true;
                    } else {
                        z5 = true;
                        z3 = false;
                        z4 = true;
                    }
                    userId = qVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = qVar.bjc() != 1 ? 0 : 1;
                    if (ew.g(qVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                        sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(t.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_del_post_is_self, true);
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(t.g.tag_del_post_id, qVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(t.g.tag_del_post_is_self, false);
                        sparseArray.put(t.g.tag_del_post_type, 0);
                        sparseArray.put(t.g.tag_del_post_id, "");
                    }
                    sparseArray.put(t.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z6) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.ewe.Kw() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.ewe.Kw().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(t.g.tag_del_post_id, qVar.getId());
                        return;
                    }
                    sparseArray.put(t.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = qVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (qVar.bjc() != 1) {
            }
            if (ew.g(qVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(t.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(t.g.tag_forbid_user_post_id, qVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void a(View view, boolean z, boolean z2) {
        this.enm = new Cdo(this.evD.getPageContext(), this.bmb);
        this.enm.ig(TbadkCoreApplication.isLogin());
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.q qVar = sparseArray.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q ? (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(t.g.tag_clip_board) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(t.g.tag_clip_board, qVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            this.enm.aOm().setTag(sparseArray2);
            if (z2) {
                this.enm.aOm().setText(t.j.remove_mark);
            } else {
                this.enm.aOm().setText(t.j.mark);
            }
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray3.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray3.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray3.get(t.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray3.get(t.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                this.enm.aOn().setText(t.j.manage);
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(t.g.tag_should_manage_visible, true);
                sparseArray4.put(t.g.tag_manage_user_identity, sparseArray3.get(t.g.tag_manage_user_identity));
                sparseArray4.put(t.g.tag_del_post_is_self, sparseArray3.get(t.g.tag_del_post_is_self));
                sparseArray4.put(t.g.tag_del_post_id, sparseArray3.get(t.g.tag_del_post_id));
                sparseArray4.put(t.g.tag_del_post_type, sparseArray3.get(t.g.tag_del_post_type));
                sparseArray4.put(t.g.tag_forbid_user_name, sparseArray3.get(t.g.tag_forbid_user_name));
                sparseArray4.put(t.g.tag_forbid_user_post_id, sparseArray3.get(t.g.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray4.put(t.g.tag_user_mute_visible, true);
                    sparseArray4.put(t.g.tag_is_mem, sparseArray3.get(t.g.tag_is_mem));
                    sparseArray4.put(t.g.tag_user_mute_mute_userid, sparseArray3.get(t.g.tag_user_mute_mute_userid));
                    sparseArray4.put(t.g.tag_user_mute_mute_username, sparseArray3.get(t.g.tag_user_mute_mute_username));
                    sparseArray4.put(t.g.tag_user_mute_post_id, sparseArray3.get(t.g.tag_user_mute_post_id));
                    sparseArray4.put(t.g.tag_user_mute_thread_id, sparseArray3.get(t.g.tag_user_mute_thread_id));
                } else {
                    sparseArray4.put(t.g.tag_user_mute_visible, false);
                }
                this.enm.aOn().setTag(sparseArray4);
                this.enm.aOn().setVisibility(0);
            } else {
                this.enm.aOn().setVisibility(8);
            }
            if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(t.g.tag_should_delete_visible, true);
                sparseArray5.put(t.g.tag_manage_user_identity, sparseArray3.get(t.g.tag_manage_user_identity));
                sparseArray5.put(t.g.tag_del_post_is_self, Boolean.valueOf(booleanValue3));
                sparseArray5.put(t.g.tag_del_post_id, sparseArray3.get(t.g.tag_del_post_id));
                sparseArray5.put(t.g.tag_del_post_type, sparseArray3.get(t.g.tag_del_post_type));
                this.enm.aOp().setTag(sparseArray5);
                this.enm.aOp().setVisibility(0);
            } else {
                this.enm.aOp().setVisibility(8);
            }
            SparseArray sparseArray6 = (SparseArray) view.getTag();
            boolean booleanValue4 = sparseArray6.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray6.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(t.g.tag_should_manage_visible)).booleanValue() : false) && booleanValue4) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(t.g.tag_user_mute_visible, true);
                sparseArray7.put(t.g.tag_is_mem, sparseArray6.get(t.g.tag_is_mem));
                sparseArray7.put(t.g.tag_user_mute_mute_userid, sparseArray6.get(t.g.tag_user_mute_mute_userid));
                sparseArray7.put(t.g.tag_user_mute_mute_username, sparseArray6.get(t.g.tag_user_mute_mute_username));
                sparseArray7.put(t.g.tag_user_mute_post_id, sparseArray6.get(t.g.tag_user_mute_post_id));
                sparseArray7.put(t.g.tag_user_mute_thread_id, sparseArray6.get(t.g.tag_user_mute_thread_id));
                sparseArray7.put(t.g.tag_del_post_is_self, sparseArray6.get(t.g.tag_del_post_is_self));
                sparseArray7.put(t.g.tag_del_post_type, sparseArray6.get(t.g.tag_del_post_type));
                sparseArray7.put(t.g.tag_del_post_id, sparseArray6.get(t.g.tag_del_post_id));
                sparseArray7.put(t.g.tag_manage_user_identity, sparseArray6.get(t.g.tag_manage_user_identity));
                this.enm.aOo().setText(t.j.mute_option);
                this.enm.aOo().setTag(sparseArray7);
                this.enm.aOo().setVisibility(0);
                this.enm.aOn().setVisibility(8);
            } else {
                String str2 = sparseArray6.get(t.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(t.g.tag_forbid_user_post_id) : null;
                if (ew.g(sparseArray6.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q ? (com.baidu.tieba.tbadkCore.data.q) sparseArray6.get(t.g.tag_clip_board) : null) ? false : TbadkCoreApplication.isLogin() & z) {
                    this.enm.aOo().setVisibility(0);
                    this.enm.aOo().setTag(str2);
                } else {
                    this.enm.aOo().setVisibility(8);
                }
            }
        }
        this.enm.aOq().setVisibility(8);
        this.enm.aOt();
        this.enm.vR();
    }

    public void iF(boolean z) {
        if (this.enm != null && this.enm.aOm() != null) {
            if (z) {
                this.enm.aOm().setText(t.j.remove_mark);
            } else {
                this.enm.aOm().setText(t.j.mark);
            }
            this.enm.vR();
        }
    }

    public View aQr() {
        return this.evY;
    }

    public void onChangeSkinType(int i) {
        this.evD.getLayoutMode().ah(i == 1);
        this.evD.getLayoutMode().x(this.eiw);
        this.evD.getLayoutMode().x(this.evB);
        this.mNavigationBar.onChangeSkinType(this.evD.getPageContext(), i);
        if (this.evF != null) {
            com.baidu.tbadk.core.util.av.b(this.evF, t.d.cp_cont_b, t.d.cp_cont_b);
        }
        this.bMQ.onChangeSkinType(this.evD.getPageContext(), i);
        this.evD.getLayoutMode().x(this.evY);
        com.baidu.tbadk.core.util.av.c(this.elU, t.f.icon_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.av.c(this.evK, t.f.btn_pb_more_btn_selector);
        this.elV.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10039));
        this.elV.setVideoImageId(t.f.pic_video);
        if (this.dtc != null && this.dtc.CG() != null) {
            this.dtc.CG().onChangeSkinType(i);
        }
    }

    public void aQs() {
        this.coz.setVisibility(0);
    }

    public void aQt() {
        this.Cj.setVisibility(0);
        this.coz.setVisibility(8);
        this.evV.wm();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bIX = onLongClickListener;
        this.evB.setOnLongClickListener(this.bIX);
    }

    public View aQu() {
        return this.evB;
    }

    public void ph(String str) {
        int pi = this.evC.pi(str);
        if (pi > -1) {
            this.Cj.setSelection(pi + 1);
            this.Cj.invalidate();
        }
    }

    public View aQv() {
        return this.evF;
    }

    public MorePopupWindow aQw() {
        return this.evW;
    }

    public HeadImageView aQx() {
        return this.elN;
    }

    public ClickableHeaderImageView aQy() {
        return this.evI;
    }

    public TextView getUserNameView() {
        return this.aVl;
    }

    public UserIconBox aQz() {
        return this.cgs;
    }

    public ImageView aQA() {
        return this.elO;
    }

    public UserIconBox aQB() {
        return this.ahO;
    }

    public void ayk() {
        if (this.etH == null) {
            this.etH = new com.baidu.tbadk.core.view.a(this.evD.getPageContext());
        }
        this.etH.aF(true);
    }

    public void aKF() {
        if (this.etH != null) {
            this.etH.aF(false);
        }
    }

    public TextView aQC() {
        return this.evL;
    }

    public TbRichTextView aQD() {
        return this.elV;
    }

    public TextView aQE() {
        if (this.elV == null) {
            return null;
        }
        return this.elV.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.evp = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.evq = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.elV != null) {
            this.elV.setOnEmotionClickListener(cVar);
        }
    }

    public View abt() {
        return this.evK;
    }

    public HeadImageView aQF() {
        return this.evH.getHeadView();
    }

    public Cdo aQG() {
        return this.enm;
    }

    public void adk() {
        if (this.evT != null) {
            this.evT.adk();
        }
    }

    public void ayV() {
        if (this.evT != null) {
            this.evT.ayV();
        }
    }

    public void onActivityDestroy() {
        if (this.evT != null) {
            this.evT.onActivityDestroy();
        }
    }

    public void aQH() {
        if (!this.evD.QV() && this.evT != null) {
            this.evT.aQH();
        }
    }

    private boolean aQI() {
        return (this.ekz.getAuthor() == null || this.ekz.getAuthor().getPendantData() == null || StringUtils.isNull(this.ekz.getAuthor().getPendantData().rc())) ? false : true;
    }
}
