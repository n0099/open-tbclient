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
import com.baidu.tbadk.core.util.az;
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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ag {
    private static final int exH = TbadkCoreApplication.m9getInst().getListItemRule().xQ();
    private BdListView Cj;
    public ViewStub aYH;
    public TbImageView aYI;
    private View bLL;
    private NoNetworkView bMN;
    private View.OnClickListener bmo;
    private ProgressBar coW;
    private RelativeLayout eku;
    private Cdo epj;
    private com.baidu.tbadk.core.view.a evP;
    private View exI;
    private av exJ;
    private NewSubPbActivity exK;
    private RelativeLayout exL;
    private LinearLayout exN;
    public RelativeLayout exT;
    public LinearLayout exU;
    public ImageView exV;
    public TextView exW;
    public TextView exX;
    private TextView exY;
    private ThreadSkinView exZ;
    private com.baidu.tieba.pb.view.c eya;
    private LinearLayout eyb;
    private aw eyc;
    private View eyf;
    private ArrayList<com.baidu.tieba.tbadkCore.data.q> eyj;
    private String eyk;
    private com.baidu.tieba.pb.data.n eyl;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.v mNoDataView = null;
    private TbRichTextView.e exx = null;
    private View.OnClickListener MS = null;
    private TbRichTextView.f exw = null;
    private NavigationBar mNavigationBar = null;
    private TextView exM = null;
    private TextView VW = null;
    private HeadImageView enK = null;
    private HeadPendantView exO = null;
    private ClickableHeaderImageView exP = null;
    private TextView aVU = null;
    private ImageView enL = null;
    private ImageView enN = null;
    private TextView exQ = null;
    private ImageView enQ = null;
    private TextView enP = null;
    private TbRichTextView enS = null;
    private ImageView enR = null;
    private ImageView exR = null;
    private TextView exS = null;
    private MorePopupWindow eyd = null;
    private ev eye = null;
    private com.baidu.tbadk.core.dialog.c evy = null;
    private UserIconBox cgq = null;
    private UserIconBox ahw = null;
    private Dialog evf = null;
    private com.baidu.tbadk.core.dialog.a evh = null;
    private boolean cIH = true;
    private boolean enq = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bIY = null;
    private NewSubPbActivity.a eyg = null;
    private NewSubPbActivity.a eyh = null;
    private ArrayList<IconData> enu = null;
    private ArrayList<IconData> ddj = null;
    private com.baidu.tbadk.editortools.e.p duz = null;
    private String eyi = null;
    private int aHU = 0;
    private com.baidu.tieba.tbadkCore.data.q emB = null;
    protected HashMap<Long, HashSet<String>> eyn = new HashMap<>();
    protected final b.a eyo = new ah(this);
    private View.OnClickListener env = new ao(this);
    private com.baidu.tieba.pb.a.d emU = new com.baidu.tieba.pb.a.d(new ap(this));
    protected AdapterView.OnItemClickListener eyp = new aq(this);
    protected AdapterView.OnItemLongClickListener BH = new ar(this);

    public ag(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.eku = null;
        this.exI = null;
        this.Cj = null;
        this.exJ = null;
        this.exK = null;
        this.bMN = null;
        this.exL = null;
        this.eyc = null;
        this.eyf = null;
        this.bmo = null;
        this.coW = null;
        this.exK = newSubPbActivity;
        this.bmo = onClickListener;
        this.eku = (RelativeLayout) LayoutInflater.from(this.exK.getPageContext().getPageActivity()).inflate(r.h.new_sub_pb_layout, (ViewGroup) null);
        this.exI = LayoutInflater.from(this.exK.getPageContext().getPageActivity()).inflate(r.h.new_sub_pb_head, (ViewGroup) null);
        this.bMN = (NoNetworkView) this.eku.findViewById(r.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.K(this.exK.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.e.ds60);
        aQV();
        YM();
        this.exL = (RelativeLayout) this.eku.findViewById(r.g.sub_pb_body_layout);
        this.Cj = (BdListView) this.eku.findViewById(r.g.new_sub_pb_list);
        this.exZ = (ThreadSkinView) LayoutInflater.from(this.exK.getPageContext().getPageActivity()).inflate(r.h.thread_skin_layout, (ViewGroup) null);
        this.Cj.addHeaderView(this.exZ);
        this.Cj.addHeaderView(this.exI);
        this.bLL = BdListViewHelper.a(this.exK.getActivity(), this.Cj, BdListViewHelper.HeadType.DEFAULT);
        this.exJ = new av(this.exK.getPageContext().getPageActivity());
        this.exJ.H(this.env);
        this.exJ.setIsFromCDN(this.mIsFromCDN);
        this.exJ.iJ(true);
        this.Cj.setAdapter((ListAdapter) this.exJ);
        this.eyc = new aw(this.exK.getPageContext());
        this.eyf = this.eyc.getView();
        this.Cj.setNextPage(this.eyc);
        this.eyc.setOnClickListener(this.bmo);
        this.Cj.setOnItemClickListener(this.eyp);
        this.Cj.setOnItemLongClickListener(this.BH);
        this.Cj.setOnTouchListener(this.emU);
        this.coW = (ProgressBar) this.eku.findViewById(r.g.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.exI != null) {
            this.exI.setVisibility(4);
        }
        if (this.exL != null) {
            this.exL.setVisibility(4);
        }
    }

    public void YM() {
        this.exN = (LinearLayout) this.exI.findViewById(r.g.user_layout);
        this.enK = (HeadImageView) this.exI.findViewById(r.g.photo);
        this.aYI = (TbImageView) this.exI.findViewById(r.g.user_head_mask);
        this.enK.setRadius(com.baidu.adp.lib.util.k.e(this.exK.getActivity(), r.e.ds40));
        this.enK.setOnClickListener(this.bmo);
        this.exP = (ClickableHeaderImageView) this.exI.findViewById(r.g.god_user_photo);
        this.aYH = (ViewStub) this.exI.findViewById(r.g.viewstub_headimage_mask);
        this.exP.setGodIconMargin(0);
        this.exP.setRadius(com.baidu.adp.lib.util.k.e(this.exK.getActivity(), r.e.ds40));
        this.exP.setOnClickListener(this.bmo);
        this.exO = (HeadPendantView) this.exI.findViewById(r.g.subpb_pendant_photo);
        this.exO.wk();
        if (this.exO.getHeadView() != null) {
            this.exO.getHeadView().setIsRound(true);
            this.exO.getHeadView().setDrawBorder(false);
            this.exO.getHeadView().setOnClickListener(this.bmo);
        }
        if (this.exO.getPendantView() != null) {
            this.exO.getPendantView().setIsRound(true);
            this.exO.getPendantView().setDrawBorder(false);
        }
        this.aVU = (TextView) this.exI.findViewById(r.g.user_name);
        this.enL = (ImageView) this.exI.findViewById(r.g.user_rank);
        this.enN = (ImageView) this.exI.findViewById(r.g.user_gender);
        this.enR = (ImageView) this.exI.findViewById(r.g.reply);
        this.exR = (ImageView) this.exI.findViewById(r.g.more);
        this.exQ = (TextView) this.exI.findViewById(r.g.floor);
        this.exQ.setTextSize(TbConfig.getContentSizeOfLzl(this.exK.getApplicationContext()));
        this.enQ = (ImageView) this.exI.findViewById(r.g.floor_owner);
        this.enP = (TextView) this.exI.findViewById(r.g.time);
        this.enP.setTextSize(TbConfig.getContentSizeOfLzl(this.exK.getApplicationContext()));
        this.cgq = (UserIconBox) this.exI.findViewById(r.g.user_icon_box);
        this.ahw = (UserIconBox) this.exI.findViewById(r.g.user_tshow_icon_box);
        this.enS = (TbRichTextView) this.exI.findViewById(r.g.richText);
        this.enS.IO();
        this.enS.k(this.cIH, true);
        this.enS.setIsFromCDN(this.mIsFromCDN);
        this.enS.setImageViewStretch(true);
        this.enS.setTextSize(TbConfig.getContentSize());
        this.enS.setVoiceViewRes(r.h.voice_play_btn);
        this.exI.setOnTouchListener(this.emU);
        this.exI.setOnClickListener(this.bmo);
        this.exS = (TextView) this.exI.findViewById(r.g.pb_item_tail_content);
        this.exS.setOnClickListener(this.bmo);
        this.exT = (RelativeLayout) this.exI.findViewById(r.g.chudian_info_container);
        this.exU = (LinearLayout) this.exI.findViewById(r.g.landmark_container);
        this.exV = (ImageView) this.exI.findViewById(r.g.landmark_icon);
        this.exW = (TextView) this.exI.findViewById(r.g.landmark_content);
        this.exX = (TextView) this.exI.findViewById(r.g.ad_icon);
        this.exY = (TextView) this.exI.findViewById(r.g.subpb_newchudian_advertise);
        this.eyb = (LinearLayout) this.exI.findViewById(r.g.chudian_container);
    }

    public void aQV() {
        this.mNavigationBar = (NavigationBar) this.eku.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.VW = this.mNavigationBar.setTitleText("");
        this.exM = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.exK.getResources().getString(r.j.view_subject), this.bmo);
        this.exM.setVisibility(8);
    }

    public void aY(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.evf == null) {
            this.evf = new Dialog(this.exK.getPageContext().getPageActivity(), r.k.common_alert_dialog);
            this.evf.setCanceledOnTouchOutside(true);
            this.evf.setCancelable(true);
            View inflate = LayoutInflater.from(this.exK.getPageContext().getPageActivity()).inflate(r.h.forum_manage_dialog, (ViewGroup) null);
            this.exK.getLayoutMode().x(inflate);
            this.evf.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.evf.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.exK.getPageContext().getPageActivity()) * 0.9d);
            this.evf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.evf.findViewById(r.g.del_post_btn);
        TextView textView2 = (TextView) this.evf.findViewById(r.g.forbid_user_btn);
        TextView textView3 = (TextView) this.evf.findViewById(r.g.disable_reply_btn);
        if ("".equals(sparseArray.get(r.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(r.g.tag_del_post_id, sparseArray.get(r.g.tag_del_post_id));
            sparseArray2.put(r.g.tag_del_post_type, sparseArray.get(r.g.tag_del_post_type));
            sparseArray2.put(r.g.tag_del_post_is_self, sparseArray.get(r.g.tag_del_post_is_self));
            sparseArray2.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            textView.setOnClickListener(new as(this));
        }
        if ("".equals(sparseArray.get(r.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(r.g.tag_forbid_user_name, sparseArray.get(r.g.tag_forbid_user_name));
            sparseArray3.put(r.g.tag_manage_user_identity, sparseArray.get(r.g.tag_manage_user_identity));
            sparseArray3.put(r.g.tag_forbid_user_post_id, sparseArray.get(r.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new at(this));
        }
        if (!((sparseArray.get(r.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(r.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(r.j.un_mute);
            } else {
                textView3.setText(r.j.mute);
            }
            sparseArray4.put(r.g.tag_is_mem, sparseArray.get(r.g.tag_is_mem));
            sparseArray4.put(r.g.tag_user_mute_mute_userid, sparseArray.get(r.g.tag_user_mute_mute_userid));
            sparseArray4.put(r.g.tag_user_mute_mute_username, sparseArray.get(r.g.tag_user_mute_mute_username));
            sparseArray4.put(r.g.tag_user_mute_post_id, sparseArray.get(r.g.tag_user_mute_post_id));
            sparseArray4.put(r.g.tag_user_mute_thread_id, sparseArray.get(r.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new au(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.evf, this.exK.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_del_post_id, str);
        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = r.j.del_post_confirm;
        if (i == 0) {
            i3 = r.j.del_thread_confirm;
        }
        this.evh = new com.baidu.tbadk.core.dialog.a(this.exK.getPageContext().getPageActivity());
        this.evh.bZ(i3);
        this.evh.A(sparseArray);
        this.evh.a(r.j.dialog_ok, new ai(this, sparseArray));
        this.evh.b(r.j.dialog_cancel, new aj(this));
        this.evh.aq(true);
        this.evh.b(this.exK.getPageContext());
        this.evh.tm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iu(boolean z) {
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
        if (this.evy != null) {
            this.evy.dismiss();
            this.evy = null;
        }
        if (z) {
            string = this.exK.getResources().getString(r.j.remove_mark);
        } else {
            string = this.exK.getResources().getString(r.j.mark);
        }
        this.evy = new com.baidu.tbadk.core.dialog.c(this.exK.getPageContext().getPageActivity());
        this.evy.cc(r.j.operation);
        this.evy.a(new String[]{this.exK.getResources().getString(r.j.copy), string}, bVar);
        this.evy.d(this.exK.getPageContext());
        this.evy.tp();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.eyg = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.eyh = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.coW != null) {
            this.coW.setVisibility(8);
        }
        if (z && z2) {
            this.exK.showToast(this.exK.getResources().getString(r.j.success));
        } else if (str != null && z2) {
            this.exK.showToast(str);
        }
    }

    public void aX(View view) {
        if (this.bLL != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bLL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Cj != null) {
                    this.Cj.removeHeaderView(this.bLL);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bLL.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.exK.getActivity(), r.e.ds98)));
            } else if (this.Cj != null) {
                this.Cj.f(this.bLL, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.e.p pVar) {
        if (pVar != null && pVar.CG() != null) {
            this.duz = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.eku.addView(pVar.CG(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new al(this, view, i), 300L);
    }

    public void hR(boolean z) {
        this.enq = z;
        this.exJ.hR(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Cj.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.Cj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.eku;
    }

    public void bH(String str, String str2) {
        this.eyk = str2;
        new Handler().postDelayed(new am(this, str2, str), 200L);
    }

    public void aBc() {
        if (this.eyd != null) {
            com.baidu.adp.lib.h.j.a(this.eyd, this.exK.getPageContext().getPageActivity());
        }
        if (this.evy != null) {
            this.evy.dismiss();
        }
        if (this.evh != null) {
            this.evh.dismiss();
        }
        if (this.evf != null) {
            com.baidu.adp.lib.h.j.b(this.evf, this.exK.getPageContext());
        }
        if (this.coW != null) {
            this.coW.setVisibility(8);
        }
        if (this.epj != null) {
            this.epj.dismiss();
        }
    }

    public void aQW() {
        this.Cj.setNextPage(this.eyc);
        this.eyc.wB();
    }

    public void hQ(boolean z) {
        this.cIH = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v50, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z2 = false;
        if (nVar != null) {
            this.eyl = nVar;
            this.exJ.b(this.eyl.Jv());
            if (this.exI != null) {
                this.exI.setVisibility(0);
            }
            if (this.exL != null) {
                this.exL.setVisibility(0);
            }
            if (nVar.aMN() != null) {
                this.eyi = nVar.aMN().getId();
                this.aHU = nVar.aMN().bjO();
                if (this.aHU > 0) {
                    this.VW.setText(String.format(this.exK.getPageContext().getString(r.j.is_floor), Integer.valueOf(this.aHU)));
                } else {
                    this.VW.setText((CharSequence) null);
                }
                String str = this.exK.aQU() ? "PB" : null;
                if (nVar.aMN().sg() != null) {
                    this.exZ.a(this.exK.getPageContext(), nVar.aMN().sg(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", nVar.aMT().getId(), nVar.aMT().getName(), nVar.Jv().getId(), str));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.enK.getLayoutParams();
                    marginLayoutParams.topMargin = (int) this.exK.getResources().getDimension(r.e.ds20);
                    this.enK.setLayoutParams(marginLayoutParams);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.exP.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) this.exK.getResources().getDimension(r.e.ds20);
                    this.exP.setLayoutParams(marginLayoutParams2);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.exN.getLayoutParams();
                    marginLayoutParams3.topMargin = (int) this.exK.getResources().getDimension(r.e.ds36);
                    this.exN.setLayoutParams(marginLayoutParams3);
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.exR.getLayoutParams();
                    marginLayoutParams4.topMargin = (int) this.exK.getResources().getDimension(r.e.ds34);
                    this.exR.setLayoutParams(marginLayoutParams4);
                } else {
                    this.exZ.a(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.eyc.wB();
                this.exJ.setHasMoreData(true);
            } else {
                this.eyc.wC();
                this.exJ.setHasMoreData(false);
            }
            this.eyj = nVar.aMR();
            if (this.eyj == null || this.eyj.size() == 0) {
                this.Cj.setNextPage(null);
            } else {
                this.Cj.setNextPage(this.eyc);
            }
            if (this.eyj == null || this.eyj.size() <= exH) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.eyj.size() - exH;
                oE(size);
                int firstVisiblePosition = this.Cj.getFirstVisiblePosition() - size;
                View childAt = this.Cj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.exJ.setDatas(this.eyj);
            if (nVar.Jv() != null && nVar.Jv().getAuthor() != null && (userId = nVar.Jv().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.exJ.N(i, z2);
            this.exJ.notifyDataSetChanged();
            a(nVar.aMN(), nVar.awb(), nVar.nv(), i, z);
            if (i4 > 0) {
                this.Cj.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View aQX() {
        return this.enR;
    }

    private void oE(int i) {
        if (this.eyj != null) {
            if (this.eyj.size() <= i) {
                this.eyj.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.q> it = this.eyj.iterator();
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

    public boolean aQY() {
        return this.exJ.bev;
    }

    private void a(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            this.eya = com.baidu.tieba.pb.d.a(this.exK);
            if (this.eya != null) {
                com.baidu.tbadk.core.util.av.j((View) this.exY, r.d.common_color_10106);
                this.exY.setVisibility(0);
                this.exY.setText(TextUtils.isEmpty(iVar.getTagName()) ? (String) TbadkCoreApplication.m9getInst().getContext().getResources().getText(r.j.advert_label) : iVar.getTagName());
                this.eya.a(this.emB, this.eyo);
                this.eyb.removeAllViews();
                this.eyb.addView(this.eya.getView());
                this.eyb.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.tbadkCore.data.q qVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (qVar != null) {
            this.emB = qVar;
            com.baidu.tieba.tbadkCore.data.i bjY = qVar.bjY();
            if (bjY != null && bjY.fuN) {
                int bjt = bjY.bjt();
                if (bjt == 2 || bjt == 1 || bjt == 3) {
                    this.exT.setVisibility(8);
                    a(bjY);
                } else {
                    this.exT.setVisibility(0);
                    com.baidu.tbadk.core.util.av.j((View) this.exX, r.d.common_color_10106);
                    String position = bjY.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.exU.setVisibility(0);
                        this.exW.setText(position);
                    }
                    this.enS.setOnLinkImageClickListener(this.exw);
                    this.enS.setOnImageClickListener(this.exx);
                }
            } else {
                this.exT.setVisibility(8);
                if (z3) {
                    this.enS.setOnImageClickListener(this.exx);
                }
            }
            this.enK.setTag(null);
            this.enK.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.exI.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.exI.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(r.g.tag_clip_board, qVar);
            sparseArray.put(r.g.tag_is_subpb, false);
            a(qVar, i, sparseArray);
            this.exR.setTag(sparseArray);
            this.enR.setTag(sparseArray);
            this.aVU.setOnClickListener(this.bmo);
            this.aVU.setText((CharSequence) null);
            this.enQ.setVisibility(8);
            this.exQ.setText((CharSequence) null);
            this.exR.setOnClickListener(this.bmo);
            this.enR.setOnClickListener(this.bmo);
            com.baidu.tbadk.core.util.av.c(this.enP, r.d.common_color_10078, 1);
            this.enP.setText(az.t(qVar.getTime()));
            if (z) {
                this.enQ.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(this.enQ, r.f.icon_floorhost);
                this.enQ.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
            if (this.cIH) {
                i2 = r.f.img_default_100;
            } else {
                i2 = r.f.icon_click;
            }
            this.enS.setDefaultImageId(i2);
            this.exQ.setText(String.format(this.exK.getPageContext().getString(r.j.is_floor), Integer.valueOf(qVar.bjO())));
            String portrait = qVar.getAuthor().getPortrait();
            if (qVar.getAuthor() != null) {
                String name_show = qVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.v.gD(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                }
                this.aVU.setText(name_show);
                ArrayList<IconData> tShowInfoNew = qVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.av.c(this.aVU, r.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.av.c(this.aVU, r.d.cp_cont_f, 1);
                }
                int level_id = qVar.getAuthor().getLevel_id();
                int is_bawu = qVar.getAuthor().getIs_bawu();
                String bawu_type = qVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !ew.g(this.emB)) {
                    this.enL.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(this.enL, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.enL.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.j.degree_in_forum), Integer.valueOf(level_id)));
                    this.enL.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                    this.enL.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.enL.setVisibility(8);
                }
                int i4 = this.exY.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.enL.setOnClickListener(this.bmo);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.av.c(this.enL, r.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.av.c(this.enL, r.f.pb_assist);
                    }
                }
                if (qVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.av.c(this.enN, r.f.icon_pb_pop_girl);
                    this.enN.setVisibility(0);
                } else if (qVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.av.c(this.enN, r.f.icon_pb_pop_boy);
                    this.enN.setVisibility(0);
                } else {
                    this.enN.setVisibility(8);
                }
                this.enN.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.enu = qVar.getAuthor().getIconInfo();
                this.ddj = qVar.getAuthor().getTShowInfoNew();
                if (this.cgq != null) {
                    if (ew.g(qVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.enu.size()) {
                                break;
                            }
                            IconData iconData = this.enu.get(i6);
                            if (!az.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.enu = arrayList;
                    }
                    this.cgq.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
                    this.cgq.setOnClickListener(this.bmo);
                    this.cgq.wL();
                    this.cgq.a(this.enu, i4, this.exK.getResources().getDimensionPixelSize(r.e.ds30), this.exK.getResources().getDimensionPixelSize(r.e.ds30), this.exK.getResources().getDimensionPixelSize(r.e.ds10));
                }
                if (this.ahw != null) {
                    this.ahw.setOnClickListener(this.bmo);
                    if (this.ddj != null && this.ddj.size() > 0 && this.ddj.get(0) != null) {
                        this.ahw.setTag(this.ddj.get(0).getUrl());
                    }
                    this.ahw.a(this.ddj, 2, this.exK.getResources().getDimensionPixelSize(r.e.ds30), this.exK.getResources().getDimensionPixelSize(r.e.ds32), this.exK.getResources().getDimensionPixelSize(r.e.ds8), true);
                }
            }
            a(this.enS, 0);
            UserTbVipInfoData userTbVipInfoData = qVar.getAuthor().getUserTbVipInfoData();
            this.exI.setPadding(this.exK.getResources().getDimensionPixelSize(r.e.ds32), 0, this.exK.getResources().getDimensionPixelSize(r.e.ds32), 0);
            if (aRq()) {
                this.exI.setPadding(this.exK.getResources().getDimensionPixelSize(r.e.ds18), 0, this.exK.getResources().getDimensionPixelSize(r.e.ds32), 0);
                if (!this.enq) {
                    this.enK.setVisibility(8);
                    this.exP.setVisibility(8);
                    this.exO.setVisibility(8);
                }
                this.exP.setVisibility(8);
                this.enK.setVisibility(4);
                this.exO.setVisibility(0);
                this.exO.dX(qVar.getAuthor().getPendantData().pO());
                this.exO.getHeadView().c(portrait, 28, false);
                this.exO.getHeadView().setUserId(qVar.getAuthor().getUserId());
                this.exO.getHeadView().setUserName(qVar.getAuthor().getUserName());
            }
            if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url()) && !aRq()) {
                this.exP.setVisibility(0);
                this.enK.setVisibility(4);
                if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null) {
                    if (this.aYH != null && this.enq) {
                        if (this.aYI == null) {
                            this.aYH.inflate();
                            this.aYI = (TbImageView) this.exI.findViewById(r.g.user_head_mask);
                        }
                        this.aYI.c(userTbVipInfoData.getvipV_url(), 10, false);
                        this.exP.setIsBigV(true);
                    }
                    this.exP.setUserId(qVar.getAuthor().getUserId());
                    this.exP.setUserName(qVar.getAuthor().getUserName());
                    this.exP.c(portrait, 28, false);
                }
                this.exO.setVisibility(8);
                return;
            }
            if (qVar.getAuthor().getGodUserData().getId() != null && qVar.getAuthor().getGodUserData().getType() == 2 && !aRq()) {
                this.exP.setVisibility(0);
                this.enK.setVisibility(4);
                this.exO.setVisibility(8);
                this.exP.setUserId(qVar.getAuthor().getUserId());
                this.exP.setUserName(qVar.getAuthor().getUserName());
                this.exP.c(portrait, 28, false);
            } else if (!aRq()) {
                this.exP.setVisibility(8);
                this.enK.setVisibility(0);
                this.exO.setVisibility(8);
                this.enK.setUserId(qVar.getAuthor().getUserId());
                this.enK.setUserName(qVar.getAuthor().getUserName());
                this.enK.setDefaultResource(r.f.transparent_bg);
                this.enK.setDefaultErrorResource(r.f.icon_default_avatar100);
                this.enK.c(portrait, 28, false);
            }
            if (!this.enq) {
                this.enK.setVisibility(8);
                this.exP.setVisibility(8);
                this.exO.setVisibility(8);
            }
            this.aVU.setTag(r.g.tag_user_id, qVar.getAuthor().getUserId());
            this.aVU.setTag(r.g.tag_user_name, qVar.getAuthor().getUserName());
            this.enS.setText(qVar.aAI());
            if (!TextUtils.isEmpty(qVar.getBimg_url())) {
                this.enS.setBackgroundDrawable(null);
                this.enS.setTag(qVar.getBimg_url());
                this.enS.setOnClickListener(this.bmo);
                this.enS.setTextViewOnClickListener(this.bmo);
                this.enS.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.eA().a(qVar.getBimg_url(), 19, new an(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enS.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.enS.setPadding(0, 0, 0, 0);
                this.enS.setLayoutParams(layoutParams);
                this.enS.setBackgroundDrawable(null);
            }
            if (qVar != null) {
                com.baidu.tieba.pb.view.u.a(qVar.aRG(), this.exS, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth);
            this.enS.setMaxImageHeight((int) (this.maxImageWidth * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.exK.getPageContext().getString(r.j.refresh_view_title_text), this.MS));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.exK.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.exL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, r.f.pic_emotion07, com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds320), com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds480), com.baidu.adp.lib.util.k.e(pageActivity, r.e.ds360)), dVar, a, false);
        }
        this.exL.setVisibility(0);
        this.Cj.setVisibility(8);
        this.coW.setVisibility(8);
        this.duz.DO();
        com.baidu.tbadk.core.util.av.l(this.mNoDataView, r.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.exK.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gs(int i) {
        a(NoDataViewFactory.d.x(i, r.j.refresh_view_title_text));
    }

    public void pw(String str) {
        a(NoDataViewFactory.d.af(str, this.exK.getPageContext().getString(r.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Cj.setVisibility(0);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.MS = onClickListener;
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
            if (this.eyl != null && this.eyl.Jv() != null && this.eyl.Jv().getAuthor() != null && qVar.getAuthor() != null) {
                String userId3 = this.eyl.Jv().getAuthor().getUserId();
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
                    int i2 = qVar.bjO() != 1 ? 0 : 1;
                    if (ew.g(qVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                        sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(r.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_del_post_is_self, true);
                        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(r.g.tag_del_post_id, qVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(r.g.tag_del_post_is_self, false);
                        sparseArray.put(r.g.tag_del_post_type, 0);
                        sparseArray.put(r.g.tag_del_post_id, "");
                    }
                    sparseArray.put(r.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
                    if (!z6) {
                        sparseArray.put(r.g.tag_should_manage_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(r.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(r.g.tag_user_mute_visible, true);
                        sparseArray.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (qVar.getAuthor() != null) {
                            sparseArray.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                            sparseArray.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                        }
                        if (this.eyl.Jv() != null) {
                            sparseArray.put(r.g.tag_user_mute_thread_id, this.eyl.Jv().getId());
                        }
                        sparseArray.put(r.g.tag_user_mute_post_id, qVar.getId());
                    } else {
                        sparseArray.put(r.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(r.g.tag_should_delete_visible, true);
                        sparseArray.put(r.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(r.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(r.g.tag_del_post_id, qVar.getId());
                        return;
                    }
                    sparseArray.put(r.g.tag_should_delete_visible, false);
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
            if (qVar.bjO() != 1) {
            }
            if (ew.g(qVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(r.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(r.g.tag_forbid_user_post_id, qVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void a(View view, boolean z, boolean z2) {
        this.epj = new Cdo(this.exK.getPageContext(), this.bmo);
        this.epj.ij(TbadkCoreApplication.isLogin());
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.q qVar = sparseArray.get(r.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q ? (com.baidu.tieba.tbadkCore.data.q) sparseArray.get(r.g.tag_clip_board) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(r.g.tag_clip_board, qVar);
            sparseArray2.put(r.g.tag_is_subpb, false);
            this.epj.aOU().setTag(sparseArray2);
            if (z2) {
                this.epj.aOU().setText(r.j.remove_mark);
            } else {
                this.epj.aOU().setText(r.j.mark);
            }
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray3.get(r.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(r.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray3.get(r.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(r.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray3.get(r.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(r.g.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray3.get(r.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray3.get(r.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                this.epj.aOV().setText(r.j.manage);
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(r.g.tag_should_manage_visible, true);
                sparseArray4.put(r.g.tag_manage_user_identity, sparseArray3.get(r.g.tag_manage_user_identity));
                sparseArray4.put(r.g.tag_del_post_is_self, sparseArray3.get(r.g.tag_del_post_is_self));
                sparseArray4.put(r.g.tag_del_post_id, sparseArray3.get(r.g.tag_del_post_id));
                sparseArray4.put(r.g.tag_del_post_type, sparseArray3.get(r.g.tag_del_post_type));
                sparseArray4.put(r.g.tag_forbid_user_name, sparseArray3.get(r.g.tag_forbid_user_name));
                sparseArray4.put(r.g.tag_forbid_user_post_id, sparseArray3.get(r.g.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray4.put(r.g.tag_user_mute_visible, true);
                    sparseArray4.put(r.g.tag_is_mem, sparseArray3.get(r.g.tag_is_mem));
                    sparseArray4.put(r.g.tag_user_mute_mute_userid, sparseArray3.get(r.g.tag_user_mute_mute_userid));
                    sparseArray4.put(r.g.tag_user_mute_mute_username, sparseArray3.get(r.g.tag_user_mute_mute_username));
                    sparseArray4.put(r.g.tag_user_mute_post_id, sparseArray3.get(r.g.tag_user_mute_post_id));
                    sparseArray4.put(r.g.tag_user_mute_thread_id, sparseArray3.get(r.g.tag_user_mute_thread_id));
                } else {
                    sparseArray4.put(r.g.tag_user_mute_visible, false);
                }
                this.epj.aOV().setTag(sparseArray4);
                this.epj.aOV().setVisibility(0);
            } else {
                this.epj.aOV().setVisibility(8);
            }
            if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(r.g.tag_should_delete_visible, true);
                sparseArray5.put(r.g.tag_manage_user_identity, sparseArray3.get(r.g.tag_manage_user_identity));
                sparseArray5.put(r.g.tag_del_post_is_self, Boolean.valueOf(booleanValue3));
                sparseArray5.put(r.g.tag_del_post_id, sparseArray3.get(r.g.tag_del_post_id));
                sparseArray5.put(r.g.tag_del_post_type, sparseArray3.get(r.g.tag_del_post_type));
                this.epj.aOX().setTag(sparseArray5);
                this.epj.aOX().setVisibility(0);
            } else {
                this.epj.aOX().setVisibility(8);
            }
            SparseArray sparseArray6 = (SparseArray) view.getTag();
            boolean booleanValue4 = sparseArray6.get(r.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(r.g.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray6.get(r.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(r.g.tag_should_manage_visible)).booleanValue() : false) && booleanValue4) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(r.g.tag_user_mute_visible, true);
                sparseArray7.put(r.g.tag_is_mem, sparseArray6.get(r.g.tag_is_mem));
                sparseArray7.put(r.g.tag_user_mute_mute_userid, sparseArray6.get(r.g.tag_user_mute_mute_userid));
                sparseArray7.put(r.g.tag_user_mute_mute_username, sparseArray6.get(r.g.tag_user_mute_mute_username));
                sparseArray7.put(r.g.tag_user_mute_post_id, sparseArray6.get(r.g.tag_user_mute_post_id));
                sparseArray7.put(r.g.tag_user_mute_thread_id, sparseArray6.get(r.g.tag_user_mute_thread_id));
                sparseArray7.put(r.g.tag_del_post_is_self, sparseArray6.get(r.g.tag_del_post_is_self));
                sparseArray7.put(r.g.tag_del_post_type, sparseArray6.get(r.g.tag_del_post_type));
                sparseArray7.put(r.g.tag_del_post_id, sparseArray6.get(r.g.tag_del_post_id));
                sparseArray7.put(r.g.tag_manage_user_identity, sparseArray6.get(r.g.tag_manage_user_identity));
                this.epj.aOW().setText(r.j.mute_option);
                this.epj.aOW().setTag(sparseArray7);
                this.epj.aOW().setVisibility(0);
                this.epj.aOV().setVisibility(8);
            } else {
                String str2 = sparseArray6.get(r.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(r.g.tag_forbid_user_post_id) : null;
                if (ew.g(sparseArray6.get(r.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.q ? (com.baidu.tieba.tbadkCore.data.q) sparseArray6.get(r.g.tag_clip_board) : null) ? false : TbadkCoreApplication.isLogin() & z) {
                    this.epj.aOW().setVisibility(0);
                    this.epj.aOW().setTag(str2);
                } else {
                    this.epj.aOW().setVisibility(8);
                }
            }
        }
        this.epj.aOY().setVisibility(8);
        this.epj.aPb();
        this.epj.wf();
    }

    public void iI(boolean z) {
        if (this.epj != null && this.epj.aOU() != null) {
            if (z) {
                this.epj.aOU().setText(r.j.remove_mark);
            } else {
                this.epj.aOU().setText(r.j.mark);
            }
            this.epj.wf();
        }
    }

    public View aQZ() {
        return this.eyf;
    }

    public void onChangeSkinType(int i) {
        this.exK.getLayoutMode().ah(i == 1);
        this.exK.getLayoutMode().x(this.eku);
        this.exK.getLayoutMode().x(this.exI);
        this.mNavigationBar.onChangeSkinType(this.exK.getPageContext(), i);
        if (this.exM != null) {
            com.baidu.tbadk.core.util.av.b(this.exM, r.d.cp_cont_b, r.d.cp_cont_b);
        }
        this.bMN.onChangeSkinType(this.exK.getPageContext(), i);
        this.exK.getLayoutMode().x(this.eyf);
        com.baidu.tbadk.core.util.av.c(this.enR, r.f.icon_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.av.c(this.exR, r.f.btn_pb_more_btn_selector);
        this.enS.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10039));
        this.enS.setVideoImageId(r.f.pic_video);
        if (this.duz != null && this.duz.CG() != null) {
            this.duz.CG().onChangeSkinType(i);
        }
    }

    public void aRa() {
        this.coW.setVisibility(0);
    }

    public void aRb() {
        this.Cj.setVisibility(0);
        this.coW.setVisibility(8);
        this.eyc.wC();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bIY = onLongClickListener;
        this.exI.setOnLongClickListener(this.bIY);
    }

    public View aRc() {
        return this.exI;
    }

    public void px(String str) {
        int py = this.exJ.py(str);
        if (py > -1) {
            this.Cj.setSelection(py + 1);
            this.Cj.invalidate();
        }
    }

    public View aRd() {
        return this.exM;
    }

    public MorePopupWindow aRe() {
        return this.eyd;
    }

    public HeadImageView aRf() {
        return this.enK;
    }

    public ClickableHeaderImageView aRg() {
        return this.exP;
    }

    public TextView getUserNameView() {
        return this.aVU;
    }

    public UserIconBox aRh() {
        return this.cgq;
    }

    public ImageView aRi() {
        return this.enL;
    }

    public UserIconBox aRj() {
        return this.ahw;
    }

    public void ayI() {
        if (this.evP == null) {
            this.evP = new com.baidu.tbadk.core.view.a(this.exK.getPageContext());
        }
        this.evP.aF(true);
    }

    public void aLg() {
        if (this.evP != null) {
            this.evP.aF(false);
        }
    }

    public TextView aRk() {
        return this.exS;
    }

    public TbRichTextView aRl() {
        return this.enS;
    }

    public TextView aRm() {
        if (this.enS == null) {
            return null;
        }
        return this.enS.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.exw = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.exx = eVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.d dVar) {
        if (this.enS != null) {
            this.enS.setOnEmotionClickListener(dVar);
        }
    }

    public View abF() {
        return this.exR;
    }

    public HeadImageView aRn() {
        return this.exO.getHeadView();
    }

    public Cdo aRo() {
        return this.epj;
    }

    public void ady() {
        if (this.eya != null) {
            this.eya.ady();
        }
    }

    public void azt() {
        if (this.eya != null) {
            this.eya.azt();
        }
    }

    public void onActivityDestroy() {
        if (this.eya != null) {
            this.eya.onActivityDestroy();
        }
    }

    public void aRp() {
        if (!this.exK.Rn() && this.eya != null) {
            this.eya.aRp();
        }
    }

    private boolean aRq() {
        return (this.emB.getAuthor() == null || this.emB.getAuthor().getPendantData() == null || StringUtils.isNull(this.emB.getAuthor().getPendantData().pO())) ? false : true;
    }
}
