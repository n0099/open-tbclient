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
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.dn;
import com.baidu.tieba.pb.pb.main.eq;
import com.baidu.tieba.pb.pb.main.er;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class af {
    private static final int dWR = TbadkCoreApplication.m9getInst().getListItemRule().wD();
    private View.OnClickListener aZG;
    private View bxU;
    private NoNetworkView bza;
    private ProgressBar cbl;
    private RelativeLayout dKi;
    private dn dOR;
    private com.baidu.tbadk.core.view.b dUZ;
    private View dWS;
    private au dWT;
    private NewSubPbActivity dWU;
    private RelativeLayout dWV;
    private LinearLayout dWX;
    public RelativeLayout dXc;
    public LinearLayout dXd;
    public ImageView dXe;
    public TextView dXf;
    public ImageView dXg;
    private ImageView dXh;
    private ThreadSkinView dXi;
    private com.baidu.tieba.pb.view.c dXj;
    private LinearLayout dXk;
    private av dXl;
    private View dXo;
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> dXs;
    private String dXt;
    private com.baidu.tieba.pb.data.m dXu;
    private int maxImageWidth;
    private BdListView zt;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private TbRichTextView.d dWH = null;
    private View.OnClickListener KH = null;
    private TbRichTextView.e dWG = null;
    private NavigationBar mNavigationBar = null;
    private TextView dWW = null;
    private TextView So = null;
    private HeadImageView dNv = null;
    private ClickableHeaderImageView dWY = null;
    private TextView aOX = null;
    private ImageView dNw = null;
    private ImageView dNy = null;
    private TextView dWZ = null;
    private ImageView dNB = null;
    private TextView dNA = null;
    private TbRichTextView dND = null;
    private ImageView dNC = null;
    private ImageView dXa = null;
    private TextView dXb = null;
    private MorePopupWindow dXm = null;
    private eq dXn = null;
    private com.baidu.tbadk.core.dialog.c dUI = null;
    private UserIconBox bTj = null;
    private UserIconBox aef = null;
    private Dialog dUp = null;
    private com.baidu.tbadk.core.dialog.a dUr = null;
    private boolean ctv = true;
    private boolean dNc = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bvu = null;
    private NewSubPbActivity.a dXp = null;
    private NewSubPbActivity.a dXq = null;
    private ArrayList<IconData> dNg = null;
    private ArrayList<IconData> bBy = null;
    private com.baidu.tbadk.editortools.d.p deA = null;
    private String dXr = null;
    private int aEu = 0;
    private com.baidu.tieba.tbadkCore.data.s dMl = null;
    protected HashMap<Long, HashSet<String>> dXv = new HashMap<>();
    protected final b.a dXw = new ag(this);
    private View.OnClickListener dNh = new an(this);
    private com.baidu.tieba.pb.a.d dME = new com.baidu.tieba.pb.a.d(new ao(this));
    protected AdapterView.OnItemClickListener dXx = new ap(this);
    protected AdapterView.OnItemLongClickListener yR = new aq(this);

    public af(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dKi = null;
        this.dWS = null;
        this.zt = null;
        this.dWT = null;
        this.dWU = null;
        this.bza = null;
        this.dWV = null;
        this.dXl = null;
        this.dXo = null;
        this.aZG = null;
        this.cbl = null;
        this.dWU = newSubPbActivity;
        this.aZG = onClickListener;
        this.dKi = (RelativeLayout) LayoutInflater.from(this.dWU.getPageContext().getPageActivity()).inflate(u.h.new_sub_pb_layout, (ViewGroup) null);
        this.dWS = LayoutInflater.from(this.dWU.getPageContext().getPageActivity()).inflate(u.h.new_sub_pb_head, (ViewGroup) null);
        this.bza = (NoNetworkView) this.dKi.findViewById(u.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.A(this.dWU.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(u.e.ds60);
        aIm();
        Td();
        this.dWV = (RelativeLayout) this.dKi.findViewById(u.g.sub_pb_body_layout);
        this.zt = (BdListView) this.dKi.findViewById(u.g.new_sub_pb_list);
        this.dXi = (ThreadSkinView) LayoutInflater.from(this.dWU.getPageContext().getPageActivity()).inflate(u.h.thread_skin_layout, (ViewGroup) null);
        this.zt.addHeaderView(this.dXi);
        this.zt.addHeaderView(this.dWS);
        this.bxU = BdListViewHelper.a(this.dWU.getActivity(), this.zt, BdListViewHelper.HeadType.DEFAULT);
        this.dWT = new au(this.dWU.getPageContext().getPageActivity());
        this.dWT.J(this.dNh);
        this.dWT.setIsFromCDN(this.mIsFromCDN);
        this.dWT.hZ(true);
        this.zt.setAdapter((ListAdapter) this.dWT);
        this.dXl = new av(this.dWU.getPageContext());
        this.dXo = this.dXl.getView();
        this.zt.setNextPage(this.dXl);
        this.dXl.setOnClickListener(this.aZG);
        this.zt.setOnItemClickListener(this.dXx);
        this.zt.setOnItemLongClickListener(this.yR);
        this.zt.setOnTouchListener(this.dME);
        this.cbl = (ProgressBar) this.dKi.findViewById(u.g.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.dWS != null) {
            this.dWS.setVisibility(4);
        }
        if (this.dWV != null) {
            this.dWV.setVisibility(4);
        }
    }

    public void Td() {
        this.dWX = (LinearLayout) this.dWS.findViewById(u.g.user_layout);
        this.dNv = (HeadImageView) this.dWS.findViewById(u.g.photo);
        this.dNv.setRadius(com.baidu.adp.lib.util.k.c(this.dWU.getActivity(), u.e.ds40));
        this.dNv.setOnClickListener(this.aZG);
        this.dWY = (ClickableHeaderImageView) this.dWS.findViewById(u.g.god_user_photo);
        this.dWY.setGodIconMargin(0);
        this.dWY.setRadius(com.baidu.adp.lib.util.k.c(this.dWU.getActivity(), u.e.ds40));
        this.dWY.setOnClickListener(this.aZG);
        this.aOX = (TextView) this.dWS.findViewById(u.g.user_name);
        this.dNw = (ImageView) this.dWS.findViewById(u.g.user_rank);
        this.dNy = (ImageView) this.dWS.findViewById(u.g.user_gender);
        this.dNC = (ImageView) this.dWS.findViewById(u.g.reply);
        this.dXa = (ImageView) this.dWS.findViewById(u.g.more);
        this.dWZ = (TextView) this.dWS.findViewById(u.g.floor);
        this.dWZ.setTextSize(TbConfig.getContentSizeOfLzl(this.dWU.getApplicationContext()));
        this.dNB = (ImageView) this.dWS.findViewById(u.g.floor_owner);
        this.dNA = (TextView) this.dWS.findViewById(u.g.time);
        this.dNA.setTextSize(TbConfig.getContentSizeOfLzl(this.dWU.getApplicationContext()));
        this.bTj = (UserIconBox) this.dWS.findViewById(u.g.user_icon_box);
        this.aef = (UserIconBox) this.dWS.findViewById(u.g.user_tshow_icon_box);
        this.dND = (TbRichTextView) this.dWS.findViewById(u.g.richText);
        this.dND.Hr();
        this.dND.i(this.ctv, true);
        this.dND.setIsFromCDN(this.mIsFromCDN);
        this.dND.setImageViewStretch(true);
        this.dND.setTextSize(TbConfig.getContentSize());
        this.dND.setVoiceViewRes(u.h.voice_play_btn);
        this.dWS.setOnTouchListener(this.dME);
        this.dWS.setOnClickListener(this.aZG);
        this.dXb = (TextView) this.dWS.findViewById(u.g.pb_item_tail_content);
        this.dXb.setOnClickListener(this.aZG);
        this.dXc = (RelativeLayout) this.dWS.findViewById(u.g.chudian_info_container);
        this.dXd = (LinearLayout) this.dWS.findViewById(u.g.landmark_container);
        this.dXe = (ImageView) this.dWS.findViewById(u.g.landmark_icon);
        this.dXf = (TextView) this.dWS.findViewById(u.g.landmark_content);
        this.dXg = (ImageView) this.dWS.findViewById(u.g.ad_icon);
        this.dXh = (ImageView) this.dWS.findViewById(u.g.subpb_newchudian_advertise);
        this.dXk = (LinearLayout) this.dWS.findViewById(u.g.chudian_container);
    }

    public void aIm() {
        this.mNavigationBar = (NavigationBar) this.dKi.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.So = this.mNavigationBar.setTitleText("");
        this.dWW = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dWU.getResources().getString(u.j.view_subject), this.aZG);
        this.dWW.setVisibility(8);
    }

    public void aZ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.dUp == null) {
            this.dUp = new Dialog(this.dWU.getPageContext().getPageActivity(), u.k.common_alert_dialog);
            this.dUp.setCanceledOnTouchOutside(true);
            this.dUp.setCancelable(true);
            View inflate = LayoutInflater.from(this.dWU.getPageContext().getPageActivity()).inflate(u.h.forum_manage_dialog, (ViewGroup) null);
            this.dWU.getLayoutMode().w(inflate);
            this.dUp.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.dUp.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.A(this.dWU.getPageContext().getPageActivity()) * 0.9d);
            this.dUp.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.dUp.findViewById(u.g.del_post_btn);
        TextView textView2 = (TextView) this.dUp.findViewById(u.g.forbid_user_btn);
        TextView textView3 = (TextView) this.dUp.findViewById(u.g.disable_reply_btn);
        if ("".equals(sparseArray.get(u.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(u.g.tag_del_post_id, sparseArray.get(u.g.tag_del_post_id));
            sparseArray2.put(u.g.tag_del_post_type, sparseArray.get(u.g.tag_del_post_type));
            sparseArray2.put(u.g.tag_del_post_is_self, sparseArray.get(u.g.tag_del_post_is_self));
            sparseArray2.put(u.g.tag_manage_user_identity, sparseArray.get(u.g.tag_manage_user_identity));
            textView.setOnClickListener(new ar(this));
        }
        if ("".equals(sparseArray.get(u.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(u.g.tag_forbid_user_name, sparseArray.get(u.g.tag_forbid_user_name));
            sparseArray3.put(u.g.tag_manage_user_identity, sparseArray.get(u.g.tag_manage_user_identity));
            sparseArray3.put(u.g.tag_forbid_user_post_id, sparseArray.get(u.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new as(this));
        }
        if (!((sparseArray.get(u.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(u.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(u.j.un_mute);
            } else {
                textView3.setText(u.j.mute);
            }
            sparseArray4.put(u.g.tag_is_mem, sparseArray.get(u.g.tag_is_mem));
            sparseArray4.put(u.g.tag_user_mute_mute_userid, sparseArray.get(u.g.tag_user_mute_mute_userid));
            sparseArray4.put(u.g.tag_user_mute_mute_username, sparseArray.get(u.g.tag_user_mute_mute_username));
            sparseArray4.put(u.g.tag_user_mute_post_id, sparseArray.get(u.g.tag_user_mute_post_id));
            sparseArray4.put(u.g.tag_user_mute_thread_id, sparseArray.get(u.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new at(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.dUp, this.dWU.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(u.g.tag_del_post_id, str);
        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = u.j.del_post_confirm;
        if (i == 0) {
            i3 = u.j.del_thread_confirm;
        }
        this.dUr = new com.baidu.tbadk.core.dialog.a(this.dWU.getPageContext().getPageActivity());
        this.dUr.bM(i3);
        this.dUr.x(sparseArray);
        this.dUr.a(u.j.dialog_ok, new ah(this, sparseArray));
        this.dUr.b(u.j.dialog_cancel, new ai(this));
        this.dUr.an(true);
        this.dUr.b(this.dWU.getPageContext());
        this.dUr.rT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hK(boolean z) {
        if (this.zt != null) {
            if (!z) {
                this.zt.setEnabled(z);
            } else {
                this.zt.postDelayed(new aj(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.dUI != null) {
            this.dUI.dismiss();
            this.dUI = null;
        }
        if (z) {
            string = this.dWU.getResources().getString(u.j.remove_mark);
        } else {
            string = this.dWU.getResources().getString(u.j.mark);
        }
        this.dUI = new com.baidu.tbadk.core.dialog.c(this.dWU.getPageContext().getPageActivity());
        this.dUI.bP(u.j.operation);
        this.dUI.a(new String[]{this.dWU.getResources().getString(u.j.copy), string}, bVar);
        this.dUI.d(this.dWU.getPageContext());
        this.dUI.rW();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.dXp = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.dXq = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.cbl != null) {
            this.cbl.setVisibility(8);
        }
        if (z && z2) {
            this.dWU.showToast(this.dWU.getResources().getString(u.j.success));
        } else if (str != null && z2) {
            this.dWU.showToast(str);
        }
    }

    public void aY(View view) {
        if (this.bxU != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bxU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.zt != null) {
                    this.zt.removeHeaderView(this.bxU);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bxU.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.dWU.getActivity(), u.e.ds98)));
            } else if (this.zt != null) {
                this.zt.f(this.bxU, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void e(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Bl() != null) {
            this.deA = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dKi.addView(pVar.Bl(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new ak(this, view, i), 300L);
    }

    public void hh(boolean z) {
        this.dNc = z;
        this.dWT.hh(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.zt.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.zt.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.dKi;
    }

    public void bz(String str, String str2) {
        this.dXt = str2;
        new Handler().postDelayed(new al(this, str2, str), 200L);
    }

    public void avf() {
        if (this.dXm != null) {
            com.baidu.adp.lib.h.j.a(this.dXm, this.dWU.getPageContext().getPageActivity());
        }
        if (this.dUI != null) {
            this.dUI.dismiss();
        }
        if (this.dUr != null) {
            this.dUr.dismiss();
        }
        if (this.dUp != null) {
            com.baidu.adp.lib.h.j.b(this.dUp, this.dWU.getPageContext());
        }
        if (this.cbl != null) {
            this.cbl.setVisibility(8);
        }
        if (this.dOR != null) {
            this.dOR.dismiss();
        }
    }

    public void aIn() {
        this.zt.setNextPage(this.dXl);
        this.dXl.vh();
    }

    public void hg(boolean z) {
        this.ctv = z;
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
            this.dXu = mVar;
            this.dWT.p(this.dXu.Ix());
            if (this.dWS != null) {
                this.dWS.setVisibility(0);
            }
            if (this.dWV != null) {
                this.dWV.setVisibility(0);
            }
            if (mVar.aEe() != null) {
                this.dXr = mVar.aEe().getId();
                this.aEu = mVar.aEe().bcm();
                if (this.aEu > 0) {
                    this.So.setText(String.format(this.dWU.getPageContext().getString(u.j.is_floor), Integer.valueOf(this.aEu)));
                } else {
                    this.So.setText((CharSequence) null);
                }
                String str = this.dWU.aIk() ? "PB" : null;
                if (mVar.aEe().qZ() != null) {
                    this.dXi.a(this.dWU.getPageContext(), mVar.aEe().qZ(), com.baidu.tieba.tbadkCore.d.a.a("PB", "c0132", mVar.aEl().getId(), mVar.aEl().getName(), mVar.Ix().getId(), str));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dNv.getLayoutParams();
                    marginLayoutParams.topMargin = (int) this.dWU.getResources().getDimension(u.e.ds20);
                    this.dNv.setLayoutParams(marginLayoutParams);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.dWY.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) this.dWU.getResources().getDimension(u.e.ds20);
                    this.dWY.setLayoutParams(marginLayoutParams2);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.dWX.getLayoutParams();
                    marginLayoutParams3.topMargin = (int) this.dWU.getResources().getDimension(u.e.ds36);
                    this.dWX.setLayoutParams(marginLayoutParams3);
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.dXa.getLayoutParams();
                    marginLayoutParams4.topMargin = (int) this.dWU.getResources().getDimension(u.e.ds34);
                    this.dXa.setLayoutParams(marginLayoutParams4);
                } else {
                    this.dXi.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.dXl.vh();
                this.dWT.setHasMoreData(true);
            } else {
                this.dXl.vi();
                this.dWT.setHasMoreData(false);
            }
            this.dXs = mVar.aEi();
            if (this.dXs == null || this.dXs.size() == 0) {
                this.zt.setNextPage(null);
            } else {
                this.zt.setNextPage(this.dXl);
            }
            if (this.dXs == null || this.dXs.size() <= dWR) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.dXs.size() - dWR;
                ny(size);
                int firstVisiblePosition = this.zt.getFirstVisiblePosition() - size;
                View childAt = this.zt.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.dWT.setDatas(this.dXs);
            if (mVar.Ix() != null && mVar.Ix().getAuthor() != null && (userId = mVar.Ix().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.dWT.J(i, z2);
            this.dWT.notifyDataSetChanged();
            a(mVar.aEe(), mVar.aqc(), mVar.mK(), i, z);
            if (i4 > 0) {
                this.zt.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View aIo() {
        return this.dNC;
    }

    private void ny(int i) {
        if (this.dXs != null) {
            if (this.dXs.size() <= i) {
                this.dXs.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = this.dXs.iterator();
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

    public boolean aIp() {
        return this.dWT.aXl;
    }

    private void a(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            this.dXj = com.baidu.tieba.pb.d.a(this.dWU);
            if (this.dXj != null) {
                com.baidu.tbadk.core.util.av.c(this.dXh, u.f.label_ad);
                this.dXh.setVisibility(0);
                this.dXj.a(this.dMl, this.dXw);
                this.dXk.removeAllViews();
                this.dXk.addView(this.dXj.getView());
                this.dXk.setVisibility(0);
            }
        }
    }

    protected void a(com.baidu.tieba.tbadkCore.data.s sVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (sVar != null) {
            this.dMl = sVar;
            com.baidu.tieba.tbadkCore.data.i bcw = sVar.bcw();
            if (bcw != null && bcw.eXl) {
                int bbO = bcw.bbO();
                if (bbO == 2 || bbO == 1 || bbO == 3) {
                    this.dXc.setVisibility(8);
                    a(bcw);
                } else {
                    this.dXc.setVisibility(0);
                    this.dXg.setBackgroundDrawable(com.baidu.tbadk.core.util.av.getDrawable(u.f.label_ad));
                    String position = bcw.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.dXd.setVisibility(0);
                        this.dXf.setText(position);
                    }
                    this.dND.setOnLinkImageClickListener(this.dWG);
                    this.dND.setOnImageClickListener(this.dWH);
                }
            } else {
                this.dXc.setVisibility(8);
                if (z3) {
                    this.dND.setOnImageClickListener(this.dWH);
                }
            }
            this.dNv.setTag(null);
            this.dNv.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.dWS.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.dWS.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(u.g.tag_clip_board, sVar);
            sparseArray.put(u.g.tag_is_subpb, false);
            a(sVar, i, sparseArray);
            this.dXa.setTag(sparseArray);
            this.dNC.setTag(sparseArray);
            this.aOX.setOnClickListener(this.aZG);
            this.aOX.setText((CharSequence) null);
            this.dNB.setVisibility(8);
            this.dWZ.setText((CharSequence) null);
            this.dXa.setOnClickListener(this.aZG);
            this.dNC.setOnClickListener(this.aZG);
            com.baidu.tbadk.core.util.av.c(this.dNA, u.d.common_color_10078, 1);
            this.dNA.setText(ba.y(sVar.getTime()));
            if (z) {
                this.dNB.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(this.dNB, u.f.icon_floorhost);
                this.dNB.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
            if (this.ctv) {
                i2 = u.f.img_default_100;
            } else {
                i2 = u.f.icon_click;
            }
            this.dND.setDefaultImageId(i2);
            this.dWZ.setText(String.format(this.dWU.getPageContext().getString(u.j.is_floor), Integer.valueOf(sVar.bcm())));
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                String name_show = sVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.u.gx(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                this.aOX.setText(name_show);
                ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.av.c(this.aOX, u.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.av.c(this.aOX, u.d.cp_cont_f, 1);
                }
                int level_id = sVar.getAuthor().getLevel_id();
                int is_bawu = sVar.getAuthor().getIs_bawu();
                String bawu_type = sVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !er.f(this.dMl)) {
                    this.dNw.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(this.dNw, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.dNw.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                    this.dNw.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                    this.dNw.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.dNw.setVisibility(8);
                }
                int i4 = this.dXh.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.dNw.setOnClickListener(this.aZG);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.av.c(this.dNw, u.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.av.c(this.dNw, u.f.pb_assist);
                    }
                }
                if (sVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.av.c(this.dNy, u.f.icon_pb_pop_girl);
                    this.dNy.setVisibility(0);
                } else if (sVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.av.c(this.dNy, u.f.icon_pb_pop_boy);
                    this.dNy.setVisibility(0);
                } else {
                    this.dNy.setVisibility(8);
                }
                this.dNy.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.dNg = sVar.getAuthor().getIconInfo();
                this.bBy = sVar.getAuthor().getTShowInfoNew();
                if (this.bTj != null) {
                    if (er.f(sVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.dNg.size()) {
                                break;
                            }
                            IconData iconData = this.dNg.get(i6);
                            if (!ba.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.dNg = arrayList;
                    }
                    this.bTj.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                    this.bTj.setOnClickListener(this.aZG);
                    this.bTj.vy();
                    this.bTj.a(this.dNg, i4, this.dWU.getResources().getDimensionPixelSize(u.e.ds30), this.dWU.getResources().getDimensionPixelSize(u.e.ds30), this.dWU.getResources().getDimensionPixelSize(u.e.ds10));
                }
                if (this.aef != null) {
                    this.aef.setOnClickListener(this.aZG);
                    if (this.bBy != null && this.bBy.size() > 0 && this.bBy.get(0) != null) {
                        this.aef.setTag(this.bBy.get(0).getUrl());
                    }
                    this.aef.a(this.bBy, 2, this.dWU.getResources().getDimensionPixelSize(u.e.ds30), this.dWU.getResources().getDimensionPixelSize(u.e.ds32), this.dWU.getResources().getDimensionPixelSize(u.e.ds8), true);
                }
            }
            a(this.dND, 0);
            if (sVar.getAuthor().getGodUserData().getId() != null && sVar.getAuthor().getGodUserData().getType() == 2) {
                this.dWY.setVisibility(0);
                this.dNv.setVisibility(4);
                this.dWY.setUserId(sVar.getAuthor().getUserId());
                this.dWY.setUserName(sVar.getAuthor().getUserName());
                this.dWY.c(portrait, 28, false);
            } else {
                this.dWY.setVisibility(8);
                this.dNv.setVisibility(0);
                this.dNv.setUserId(sVar.getAuthor().getUserId());
                this.dNv.setUserName(sVar.getAuthor().getUserName());
                this.dNv.setDefaultResource(u.f.transparent_bg);
                this.dNv.setDefaultErrorResource(u.f.icon_default_avatar100);
                this.dNv.c(portrait, 28, false);
            }
            if (!this.dNc) {
                this.dNv.setVisibility(8);
                this.dWY.setVisibility(8);
            }
            this.aOX.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
            this.aOX.setTag(u.g.tag_user_name, sVar.getAuthor().getUserName());
            this.dND.setText(sVar.auL());
            if (!TextUtils.isEmpty(sVar.getBimg_url())) {
                this.dND.setBackgroundDrawable(null);
                this.dND.setTag(sVar.getBimg_url());
                this.dND.setOnClickListener(this.aZG);
                this.dND.setTextViewOnClickListener(this.aZG);
                this.dND.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.dG().a(sVar.getBimg_url(), 19, new am(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dND.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.dND.setPadding(0, 0, 0, 0);
                this.dND.setLayoutParams(layoutParams);
                this.dND.setBackgroundDrawable(null);
            }
            if (sVar != null) {
                com.baidu.tieba.pb.view.u.a(sVar.aIV(), this.dXb, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth);
            this.dND.setMaxImageHeight((int) (this.maxImageWidth * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dWU.getPageContext().getString(u.j.refresh_view_title_text), this.KH));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.dWU.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.dWV, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, u.f.pic_emotion07, com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds320), com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds480), com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds360)), dVar, a, false);
        }
        this.dWV.setVisibility(0);
        this.zt.setVisibility(8);
        this.cbl.setVisibility(8);
        this.deA.Cu();
        com.baidu.tbadk.core.util.av.l(this.mNoDataView, u.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.dWU.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fN(int i) {
        a(NoDataViewFactory.d.v(i, u.j.refresh_view_title_text));
    }

    public void nK(String str) {
        a(NoDataViewFactory.d.af(str, this.dWU.getPageContext().getString(u.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.zt.setVisibility(0);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.KH = onClickListener;
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
    public void a(com.baidu.tieba.tbadkCore.data.s sVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (sVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = sVar.getAuthor().getUserId();
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
            if (this.dXu != null && this.dXu.Ix() != null && this.dXu.Ix().getAuthor() != null && sVar.getAuthor() != null) {
                String userId3 = this.dXu.Ix().getAuthor().getUserId();
                String userId4 = sVar.getAuthor().getUserId();
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
                    userId = sVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = sVar.bcm() != 1 ? 0 : 1;
                    if (er.f(sVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(u.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                        sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(u.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(u.g.tag_del_post_is_self, true);
                        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(u.g.tag_del_post_id, sVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(u.g.tag_del_post_is_self, false);
                        sparseArray.put(u.g.tag_del_post_type, 0);
                        sparseArray.put(u.g.tag_del_post_id, "");
                    }
                    sparseArray.put(u.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z6) {
                        sparseArray.put(u.g.tag_should_manage_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(u.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(u.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(u.g.tag_user_mute_visible, true);
                        sparseArray.put(u.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(u.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(u.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.dXu.Ix() != null) {
                            sparseArray.put(u.g.tag_user_mute_thread_id, this.dXu.Ix().getId());
                        }
                        sparseArray.put(u.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(u.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(u.g.tag_should_delete_visible, true);
                        sparseArray.put(u.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(u.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(u.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(u.g.tag_del_post_id, sVar.getId());
                        return;
                    }
                    sparseArray.put(u.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = sVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (sVar.bcm() != 1) {
            }
            if (er.f(sVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(u.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(u.g.tag_forbid_user_post_id, sVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void a(View view, boolean z, boolean z2) {
        this.dOR = new dn(this.dWU.getPageContext(), this.aZG);
        this.dOR.hA(TbadkCoreApplication.isLogin());
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(u.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(u.g.tag_clip_board, sVar);
            sparseArray2.put(u.g.tag_is_subpb, false);
            this.dOR.aGk().setTag(sparseArray2);
            if (z2) {
                this.dOR.aGk().setText(u.j.remove_mark);
            } else {
                this.dOR.aGk().setText(u.j.mark);
            }
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray3.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(u.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray3.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(u.g.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray3.get(u.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray3.get(u.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                this.dOR.aGl().setText(u.j.manage);
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(u.g.tag_should_manage_visible, true);
                sparseArray4.put(u.g.tag_manage_user_identity, sparseArray3.get(u.g.tag_manage_user_identity));
                sparseArray4.put(u.g.tag_del_post_is_self, sparseArray3.get(u.g.tag_del_post_is_self));
                sparseArray4.put(u.g.tag_del_post_id, sparseArray3.get(u.g.tag_del_post_id));
                sparseArray4.put(u.g.tag_del_post_type, sparseArray3.get(u.g.tag_del_post_type));
                sparseArray4.put(u.g.tag_forbid_user_name, sparseArray3.get(u.g.tag_forbid_user_name));
                sparseArray4.put(u.g.tag_forbid_user_post_id, sparseArray3.get(u.g.tag_forbid_user_post_id));
                if (booleanValue2) {
                    sparseArray4.put(u.g.tag_user_mute_visible, true);
                    sparseArray4.put(u.g.tag_is_mem, sparseArray3.get(u.g.tag_is_mem));
                    sparseArray4.put(u.g.tag_user_mute_mute_userid, sparseArray3.get(u.g.tag_user_mute_mute_userid));
                    sparseArray4.put(u.g.tag_user_mute_mute_username, sparseArray3.get(u.g.tag_user_mute_mute_username));
                    sparseArray4.put(u.g.tag_user_mute_post_id, sparseArray3.get(u.g.tag_user_mute_post_id));
                    sparseArray4.put(u.g.tag_user_mute_thread_id, sparseArray3.get(u.g.tag_user_mute_thread_id));
                } else {
                    sparseArray4.put(u.g.tag_user_mute_visible, false);
                }
                this.dOR.aGl().setTag(sparseArray4);
                this.dOR.aGl().setVisibility(0);
            } else {
                this.dOR.aGl().setVisibility(8);
            }
            if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(u.g.tag_should_delete_visible, true);
                sparseArray5.put(u.g.tag_manage_user_identity, sparseArray3.get(u.g.tag_manage_user_identity));
                sparseArray5.put(u.g.tag_del_post_is_self, Boolean.valueOf(booleanValue3));
                sparseArray5.put(u.g.tag_del_post_id, sparseArray3.get(u.g.tag_del_post_id));
                sparseArray5.put(u.g.tag_del_post_type, sparseArray3.get(u.g.tag_del_post_type));
                this.dOR.aGn().setTag(sparseArray5);
                this.dOR.aGn().setVisibility(0);
            } else {
                this.dOR.aGn().setVisibility(8);
            }
            SparseArray sparseArray6 = (SparseArray) view.getTag();
            boolean booleanValue4 = sparseArray6.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray6.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray6.get(u.g.tag_should_manage_visible)).booleanValue() : false) && booleanValue4) {
                SparseArray sparseArray7 = new SparseArray();
                sparseArray7.put(u.g.tag_user_mute_visible, true);
                sparseArray7.put(u.g.tag_is_mem, sparseArray6.get(u.g.tag_is_mem));
                sparseArray7.put(u.g.tag_user_mute_mute_userid, sparseArray6.get(u.g.tag_user_mute_mute_userid));
                sparseArray7.put(u.g.tag_user_mute_mute_username, sparseArray6.get(u.g.tag_user_mute_mute_username));
                sparseArray7.put(u.g.tag_user_mute_post_id, sparseArray6.get(u.g.tag_user_mute_post_id));
                sparseArray7.put(u.g.tag_user_mute_thread_id, sparseArray6.get(u.g.tag_user_mute_thread_id));
                sparseArray7.put(u.g.tag_del_post_is_self, sparseArray6.get(u.g.tag_del_post_is_self));
                sparseArray7.put(u.g.tag_del_post_type, sparseArray6.get(u.g.tag_del_post_type));
                sparseArray7.put(u.g.tag_del_post_id, sparseArray6.get(u.g.tag_del_post_id));
                sparseArray7.put(u.g.tag_manage_user_identity, sparseArray6.get(u.g.tag_manage_user_identity));
                this.dOR.aGm().setText(u.j.mute_option);
                this.dOR.aGm().setTag(sparseArray7);
                this.dOR.aGm().setVisibility(0);
                this.dOR.aGl().setVisibility(8);
            } else {
                String str2 = sparseArray6.get(u.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(u.g.tag_forbid_user_post_id) : null;
                if (er.f(sparseArray6.get(u.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray6.get(u.g.tag_clip_board) : null) ? false : TbadkCoreApplication.isLogin() & z) {
                    this.dOR.aGm().setVisibility(0);
                    this.dOR.aGm().setTag(str2);
                } else {
                    this.dOR.aGm().setVisibility(8);
                }
            }
        }
        this.dOR.aGo().setVisibility(8);
        this.dOR.aGr();
        this.dOR.uP();
    }

    public void hY(boolean z) {
        if (this.dOR != null && this.dOR.aGk() != null) {
            if (z) {
                this.dOR.aGk().setText(u.j.remove_mark);
            } else {
                this.dOR.aGk().setText(u.j.mark);
            }
            this.dOR.uP();
        }
    }

    public View aIq() {
        return this.dXo;
    }

    public void onChangeSkinType(int i) {
        this.dWU.getLayoutMode().ad(i == 1);
        this.dWU.getLayoutMode().w(this.dKi);
        this.dWU.getLayoutMode().w(this.dWS);
        this.mNavigationBar.onChangeSkinType(this.dWU.getPageContext(), i);
        if (this.dWW != null) {
            com.baidu.tbadk.core.util.av.b(this.dWW, u.d.cp_cont_b, u.d.cp_cont_b);
        }
        this.bza.onChangeSkinType(this.dWU.getPageContext(), i);
        this.dWU.getLayoutMode().w(this.dXo);
        com.baidu.tbadk.core.util.av.c(this.dNC, u.f.icon_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.av.c(this.dXa, u.f.btn_pb_more_btn_selector);
        this.dND.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10039));
        this.dND.setVideoImageId(u.f.pic_video);
        if (this.deA != null && this.deA.Bl() != null) {
            this.deA.Bl().onChangeSkinType(i);
        }
    }

    public void aIr() {
        this.cbl.setVisibility(0);
    }

    public void aIs() {
        this.zt.setVisibility(0);
        this.cbl.setVisibility(8);
        this.dXl.vi();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bvu = onLongClickListener;
        this.dWS.setOnLongClickListener(this.bvu);
    }

    public View aIt() {
        return this.dWS;
    }

    public void nL(String str) {
        int nM = this.dWT.nM(str);
        if (nM > -1) {
            this.zt.setSelection(nM + 1);
            this.zt.invalidate();
        }
    }

    public View aIu() {
        return this.dWW;
    }

    public MorePopupWindow aIv() {
        return this.dXm;
    }

    public HeadImageView aIw() {
        return this.dNv;
    }

    public ClickableHeaderImageView aIx() {
        return this.dWY;
    }

    public TextView getUserNameView() {
        return this.aOX;
    }

    public UserIconBox aIy() {
        return this.bTj;
    }

    public ImageView aIz() {
        return this.dNw;
    }

    public UserIconBox aIA() {
        return this.aef;
    }

    public void asK() {
        if (this.dUZ == null) {
            this.dUZ = new com.baidu.tbadk.core.view.b(this.dWU.getPageContext());
        }
        this.dUZ.aB(true);
    }

    public void aHL() {
        if (this.dUZ != null) {
            this.dUZ.aB(false);
        }
    }

    public TextView aIB() {
        return this.dXb;
    }

    public TbRichTextView aIC() {
        return this.dND;
    }

    public TextView aID() {
        if (this.dND == null) {
            return null;
        }
        return this.dND.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.dWG = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.dWH = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.dND != null) {
            this.dND.setOnEmotionClickListener(cVar);
        }
    }

    public View Wg() {
        return this.dXa;
    }

    public dn aIE() {
        return this.dOR;
    }

    public void Ye() {
        if (this.dXj != null) {
            this.dXj.Ye();
        }
    }

    public void atv() {
        if (this.dXj != null) {
            this.dXj.atv();
        }
    }

    public void onActivityDestroy() {
        if (this.dXj != null) {
            this.dXj.onActivityDestroy();
        }
    }

    public void aIF() {
        if (!this.dWU.aIj() && this.dXj != null) {
            this.dXj.aIF();
        }
    }
}
