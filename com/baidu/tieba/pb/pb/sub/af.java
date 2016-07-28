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
import com.baidu.tieba.pb.pb.main.eu;
import com.baidu.tieba.pb.pb.main.ev;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class af {
    private static final int ejt = TbadkCoreApplication.m10getInst().getListItemRule().wD();
    public ViewStub aSW;
    public TbImageView aSX;
    private View bAi;
    private NoNetworkView bBo;
    private View.OnClickListener baF;
    private ProgressBar cdm;
    private RelativeLayout dWr;
    private Cdo ebe;
    private com.baidu.tbadk.core.view.b ehA;
    public RelativeLayout ejE;
    public LinearLayout ejF;
    public ImageView ejG;
    public TextView ejH;
    public TextView ejI;
    private TextView ejJ;
    private ThreadSkinView ejK;
    private com.baidu.tieba.pb.view.c ejL;
    private LinearLayout ejM;
    private av ejN;
    private View ejQ;
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> ejU;
    private String ejV;
    private com.baidu.tieba.pb.data.m ejW;
    private View eju;
    private au ejv;
    private NewSubPbActivity ejw;
    private RelativeLayout ejx;
    private LinearLayout ejz;
    private int maxImageWidth;
    private BdListView zU;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private TbRichTextView.d ejj = null;
    private View.OnClickListener KG = null;
    private TbRichTextView.e eji = null;
    private NavigationBar mNavigationBar = null;
    private TextView ejy = null;
    private TextView SW = null;
    private HeadImageView dZI = null;
    private ClickableHeaderImageView ejA = null;
    private TextView aPR = null;
    private ImageView dZJ = null;
    private ImageView dZL = null;
    private TextView ejB = null;
    private ImageView dZO = null;
    private TextView dZN = null;
    private TbRichTextView dZQ = null;
    private ImageView dZP = null;
    private ImageView ejC = null;
    private TextView ejD = null;
    private MorePopupWindow ejO = null;
    private eu ejP = null;
    private com.baidu.tbadk.core.dialog.c ehj = null;
    private UserIconBox bVj = null;
    private UserIconBox aeT = null;
    private Dialog egQ = null;
    private com.baidu.tbadk.core.dialog.a egS = null;
    private boolean cwk = true;
    private boolean dZp = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bxI = null;
    private NewSubPbActivity.a ejR = null;
    private NewSubPbActivity.a ejS = null;
    private ArrayList<IconData> dZt = null;
    private ArrayList<IconData> cQe = null;
    private com.baidu.tbadk.editortools.d.p dhw = null;
    private String ejT = null;
    private int aFl = 0;
    private com.baidu.tieba.tbadkCore.data.s dYv = null;
    protected HashMap<Long, HashSet<String>> ejX = new HashMap<>();
    protected final b.a ejY = new ag(this);
    private View.OnClickListener dZu = new an(this);
    private com.baidu.tieba.pb.a.d dYQ = new com.baidu.tieba.pb.a.d(new ao(this));
    protected AdapterView.OnItemClickListener ejZ = new ap(this);
    protected AdapterView.OnItemLongClickListener zs = new aq(this);

    public af(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dWr = null;
        this.eju = null;
        this.zU = null;
        this.ejv = null;
        this.ejw = null;
        this.bBo = null;
        this.ejx = null;
        this.ejN = null;
        this.ejQ = null;
        this.baF = null;
        this.cdm = null;
        this.ejw = newSubPbActivity;
        this.baF = onClickListener;
        this.dWr = (RelativeLayout) LayoutInflater.from(this.ejw.getPageContext().getPageActivity()).inflate(u.h.new_sub_pb_layout, (ViewGroup) null);
        this.eju = LayoutInflater.from(this.ejw.getPageContext().getPageActivity()).inflate(u.h.new_sub_pb_head, (ViewGroup) null);
        this.bBo = (NoNetworkView) this.dWr.findViewById(u.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.A(this.ejw.getBaseContext()) - TbadkCoreApplication.m10getInst().getResources().getDimensionPixelSize(u.e.ds60);
        aLx();
        TL();
        this.ejx = (RelativeLayout) this.dWr.findViewById(u.g.sub_pb_body_layout);
        this.zU = (BdListView) this.dWr.findViewById(u.g.new_sub_pb_list);
        this.ejK = (ThreadSkinView) LayoutInflater.from(this.ejw.getPageContext().getPageActivity()).inflate(u.h.thread_skin_layout, (ViewGroup) null);
        this.zU.addHeaderView(this.ejK);
        this.zU.addHeaderView(this.eju);
        this.bAi = BdListViewHelper.a(this.ejw.getActivity(), this.zU, BdListViewHelper.HeadType.DEFAULT);
        this.ejv = new au(this.ejw.getPageContext().getPageActivity());
        this.ejv.K(this.dZu);
        this.ejv.setIsFromCDN(this.mIsFromCDN);
        this.ejv.il(true);
        this.zU.setAdapter((ListAdapter) this.ejv);
        this.ejN = new av(this.ejw.getPageContext());
        this.ejQ = this.ejN.getView();
        this.zU.setNextPage(this.ejN);
        this.ejN.setOnClickListener(this.baF);
        this.zU.setOnItemClickListener(this.ejZ);
        this.zU.setOnItemLongClickListener(this.zs);
        this.zU.setOnTouchListener(this.dYQ);
        this.cdm = (ProgressBar) this.dWr.findViewById(u.g.progress);
        onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        if (this.eju != null) {
            this.eju.setVisibility(4);
        }
        if (this.ejx != null) {
            this.ejx.setVisibility(4);
        }
    }

    public void TL() {
        this.ejz = (LinearLayout) this.eju.findViewById(u.g.user_layout);
        this.dZI = (HeadImageView) this.eju.findViewById(u.g.photo);
        this.aSX = (TbImageView) this.eju.findViewById(u.g.user_head_mask);
        this.dZI.setRadius(com.baidu.adp.lib.util.k.c(this.ejw.getActivity(), u.e.ds40));
        this.dZI.setOnClickListener(this.baF);
        this.ejA = (ClickableHeaderImageView) this.eju.findViewById(u.g.god_user_photo);
        this.aSW = (ViewStub) this.eju.findViewById(u.g.viewstub_headimage_mask);
        this.ejA.setGodIconMargin(0);
        this.ejA.setRadius(com.baidu.adp.lib.util.k.c(this.ejw.getActivity(), u.e.ds40));
        this.ejA.setOnClickListener(this.baF);
        this.aPR = (TextView) this.eju.findViewById(u.g.user_name);
        this.dZJ = (ImageView) this.eju.findViewById(u.g.user_rank);
        this.dZL = (ImageView) this.eju.findViewById(u.g.user_gender);
        this.dZP = (ImageView) this.eju.findViewById(u.g.reply);
        this.ejC = (ImageView) this.eju.findViewById(u.g.more);
        this.ejB = (TextView) this.eju.findViewById(u.g.floor);
        this.ejB.setTextSize(TbConfig.getContentSizeOfLzl(this.ejw.getApplicationContext()));
        this.dZO = (ImageView) this.eju.findViewById(u.g.floor_owner);
        this.dZN = (TextView) this.eju.findViewById(u.g.time);
        this.dZN.setTextSize(TbConfig.getContentSizeOfLzl(this.ejw.getApplicationContext()));
        this.bVj = (UserIconBox) this.eju.findViewById(u.g.user_icon_box);
        this.aeT = (UserIconBox) this.eju.findViewById(u.g.user_tshow_icon_box);
        this.dZQ = (TbRichTextView) this.eju.findViewById(u.g.richText);
        this.dZQ.Hp();
        this.dZQ.i(this.cwk, true);
        this.dZQ.setIsFromCDN(this.mIsFromCDN);
        this.dZQ.setImageViewStretch(true);
        this.dZQ.setTextSize(TbConfig.getContentSize());
        this.dZQ.setVoiceViewRes(u.h.voice_play_btn);
        this.eju.setOnTouchListener(this.dYQ);
        this.eju.setOnClickListener(this.baF);
        this.ejD = (TextView) this.eju.findViewById(u.g.pb_item_tail_content);
        this.ejD.setOnClickListener(this.baF);
        this.ejE = (RelativeLayout) this.eju.findViewById(u.g.chudian_info_container);
        this.ejF = (LinearLayout) this.eju.findViewById(u.g.landmark_container);
        this.ejG = (ImageView) this.eju.findViewById(u.g.landmark_icon);
        this.ejH = (TextView) this.eju.findViewById(u.g.landmark_content);
        this.ejI = (TextView) this.eju.findViewById(u.g.ad_icon);
        this.ejJ = (TextView) this.eju.findViewById(u.g.subpb_newchudian_advertise);
        this.ejM = (LinearLayout) this.eju.findViewById(u.g.chudian_container);
    }

    public void aLx() {
        this.mNavigationBar = (NavigationBar) this.dWr.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.SW = this.mNavigationBar.setTitleText("");
        this.ejy = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.ejw.getResources().getString(u.j.view_subject), this.baF);
        this.ejy.setVisibility(8);
    }

    public void aZ(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.egQ == null) {
            this.egQ = new Dialog(this.ejw.getPageContext().getPageActivity(), u.k.common_alert_dialog);
            this.egQ.setCanceledOnTouchOutside(true);
            this.egQ.setCancelable(true);
            View inflate = LayoutInflater.from(this.ejw.getPageContext().getPageActivity()).inflate(u.h.forum_manage_dialog, (ViewGroup) null);
            this.ejw.getLayoutMode().w(inflate);
            this.egQ.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.egQ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.A(this.ejw.getPageContext().getPageActivity()) * 0.9d);
            this.egQ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.egQ.findViewById(u.g.del_post_btn);
        TextView textView2 = (TextView) this.egQ.findViewById(u.g.forbid_user_btn);
        TextView textView3 = (TextView) this.egQ.findViewById(u.g.disable_reply_btn);
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
        com.baidu.adp.lib.h.j.a(this.egQ, this.ejw.getPageContext());
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
        this.egS = new com.baidu.tbadk.core.dialog.a(this.ejw.getPageContext().getPageActivity());
        this.egS.bM(i3);
        this.egS.A(sparseArray);
        this.egS.a(u.j.dialog_ok, new ah(this, sparseArray));
        this.egS.b(u.j.dialog_cancel, new ai(this));
        this.egS.ap(true);
        this.egS.b(this.ejw.getPageContext());
        this.egS.rS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hW(boolean z) {
        if (this.zU != null) {
            if (!z) {
                this.zU.setEnabled(z);
            } else {
                this.zU.postDelayed(new aj(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.ehj != null) {
            this.ehj.dismiss();
            this.ehj = null;
        }
        if (z) {
            string = this.ejw.getResources().getString(u.j.remove_mark);
        } else {
            string = this.ejw.getResources().getString(u.j.mark);
        }
        this.ehj = new com.baidu.tbadk.core.dialog.c(this.ejw.getPageContext().getPageActivity());
        this.ehj.bP(u.j.operation);
        this.ehj.a(new String[]{this.ejw.getResources().getString(u.j.copy), string}, bVar);
        this.ehj.d(this.ejw.getPageContext());
        this.ehj.rV();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.ejR = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.ejS = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.cdm != null) {
            this.cdm.setVisibility(8);
        }
        if (z && z2) {
            this.ejw.showToast(this.ejw.getResources().getString(u.j.success));
        } else if (str != null && z2) {
            this.ejw.showToast(str);
        }
    }

    public void aY(View view) {
        if (this.bAi != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bAi.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.zU != null) {
                    this.zU.removeHeaderView(this.bAi);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bAi.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.ejw.getActivity(), u.e.ds98)));
            } else if (this.zU != null) {
                this.zU.f(this.bAi, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Bl() != null) {
            this.dhw = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dWr.addView(pVar.Bl(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new ak(this, view, i), 300L);
    }

    public void hs(boolean z) {
        this.dZp = z;
        this.ejv.hs(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.zU.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.zU.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.dWr;
    }

    public void bE(String str, String str2) {
        this.ejV = str2;
        new Handler().postDelayed(new al(this, str2, str), 200L);
    }

    public void avR() {
        if (this.ejO != null) {
            com.baidu.adp.lib.h.j.a(this.ejO, this.ejw.getPageContext().getPageActivity());
        }
        if (this.ehj != null) {
            this.ehj.dismiss();
        }
        if (this.egS != null) {
            this.egS.dismiss();
        }
        if (this.egQ != null) {
            com.baidu.adp.lib.h.j.b(this.egQ, this.ejw.getPageContext());
        }
        if (this.cdm != null) {
            this.cdm.setVisibility(8);
        }
        if (this.ebe != null) {
            this.ebe.dismiss();
        }
    }

    public void aLy() {
        this.zU.setNextPage(this.ejN);
        this.ejN.vh();
    }

    public void hr(boolean z) {
        this.cwk = z;
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
            this.ejW = mVar;
            this.ejv.r(this.ejW.Iw());
            if (this.eju != null) {
                this.eju.setVisibility(0);
            }
            if (this.ejx != null) {
                this.ejx.setVisibility(0);
            }
            if (mVar.aHp() != null) {
                this.ejT = mVar.aHp().getId();
                this.aFl = mVar.aHp().bfB();
                if (this.aFl > 0) {
                    this.SW.setText(String.format(this.ejw.getPageContext().getString(u.j.is_floor), Integer.valueOf(this.aFl)));
                } else {
                    this.SW.setText((CharSequence) null);
                }
                String str = this.ejw.aLv() ? "PB" : null;
                if (mVar.aHp().qP() != null) {
                    this.ejK.a(this.ejw.getPageContext(), mVar.aHp().qP(), com.baidu.tieba.tbadkCore.d.a.b("PB", "c0132", mVar.aHv().getId(), mVar.aHv().getName(), mVar.Iw().getId(), str));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.dZI.getLayoutParams();
                    marginLayoutParams.topMargin = (int) this.ejw.getResources().getDimension(u.e.ds20);
                    this.dZI.setLayoutParams(marginLayoutParams);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.ejA.getLayoutParams();
                    marginLayoutParams2.topMargin = (int) this.ejw.getResources().getDimension(u.e.ds20);
                    this.ejA.setLayoutParams(marginLayoutParams2);
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.ejz.getLayoutParams();
                    marginLayoutParams3.topMargin = (int) this.ejw.getResources().getDimension(u.e.ds36);
                    this.ejz.setLayoutParams(marginLayoutParams3);
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.ejC.getLayoutParams();
                    marginLayoutParams4.topMargin = (int) this.ejw.getResources().getDimension(u.e.ds34);
                    this.ejC.setLayoutParams(marginLayoutParams4);
                } else {
                    this.ejK.a(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.ejN.vh();
                this.ejv.setHasMoreData(true);
            } else {
                this.ejN.vi();
                this.ejv.setHasMoreData(false);
            }
            this.ejU = mVar.aHt();
            if (this.ejU == null || this.ejU.size() == 0) {
                this.zU.setNextPage(null);
            } else {
                this.zU.setNextPage(this.ejN);
            }
            if (this.ejU == null || this.ejU.size() <= ejt) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.ejU.size() - ejt;
                nQ(size);
                int firstVisiblePosition = this.zU.getFirstVisiblePosition() - size;
                View childAt = this.zU.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.ejv.setDatas(this.ejU);
            if (mVar.Iw() != null && mVar.Iw().getAuthor() != null && (userId = mVar.Iw().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.ejv.N(i, z2);
            this.ejv.notifyDataSetChanged();
            a(mVar.aHp(), mVar.aqO(), mVar.mA(), i, z);
            if (i4 > 0) {
                this.zU.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View aLz() {
        return this.dZP;
    }

    private void nQ(int i) {
        if (this.ejU != null) {
            if (this.ejU.size() <= i) {
                this.ejU.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = this.ejU.iterator();
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

    public boolean aLA() {
        return this.ejv.aYj;
    }

    private void a(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            this.ejL = com.baidu.tieba.pb.d.a(this.ejw);
            if (this.ejL != null) {
                com.baidu.tbadk.core.util.av.j((View) this.ejJ, u.d.cp_cont_d);
                this.ejJ.setVisibility(0);
                this.ejL.a(this.dYv, this.ejY);
                this.ejM.removeAllViews();
                this.ejM.addView(this.ejL.getView());
                this.ejM.setVisibility(0);
            }
        }
    }

    protected void a(com.baidu.tieba.tbadkCore.data.s sVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (sVar != null) {
            this.dYv = sVar;
            com.baidu.tieba.tbadkCore.data.i bfL = sVar.bfL();
            if (bfL != null && bfL.fkn) {
                int bfd = bfL.bfd();
                if (bfd == 2 || bfd == 1 || bfd == 3) {
                    this.ejE.setVisibility(8);
                    a(bfL);
                } else {
                    this.ejE.setVisibility(0);
                    com.baidu.tbadk.core.util.av.j((View) this.ejI, u.d.cp_cont_d);
                    String position = bfL.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.ejF.setVisibility(0);
                        this.ejH.setText(position);
                    }
                    this.dZQ.setOnLinkImageClickListener(this.eji);
                    this.dZQ.setOnImageClickListener(this.ejj);
                }
            } else {
                this.ejE.setVisibility(8);
                if (z3) {
                    this.dZQ.setOnImageClickListener(this.ejj);
                }
            }
            this.dZI.setTag(null);
            this.dZI.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.eju.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.eju.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(u.g.tag_clip_board, sVar);
            sparseArray.put(u.g.tag_is_subpb, false);
            a(sVar, i, sparseArray);
            this.ejC.setTag(sparseArray);
            this.dZP.setTag(sparseArray);
            this.aPR.setOnClickListener(this.baF);
            this.aPR.setText((CharSequence) null);
            this.dZO.setVisibility(8);
            this.ejB.setText((CharSequence) null);
            this.ejC.setOnClickListener(this.baF);
            this.dZP.setOnClickListener(this.baF);
            com.baidu.tbadk.core.util.av.c(this.dZN, u.d.common_color_10078, 1);
            this.dZN.setText(ba.t(sVar.getTime()));
            if (z) {
                this.dZO.setVisibility(0);
                com.baidu.tbadk.core.util.av.c(this.dZO, u.f.icon_floorhost);
                this.dZO.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
            if (this.cwk) {
                i2 = u.f.img_default_100;
            } else {
                i2 = u.f.icon_click;
            }
            this.dZQ.setDefaultImageId(i2);
            this.ejB.setText(String.format(this.ejw.getPageContext().getString(u.j.is_floor), Integer.valueOf(sVar.bfB())));
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                String name_show = sVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.v.gw(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.v.d(name_show, 0, 14)) + "...";
                }
                this.aPR.setText(name_show);
                ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    com.baidu.tbadk.core.util.av.c(this.aPR, u.d.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.av.c(this.aPR, u.d.cp_cont_f, 1);
                }
                int level_id = sVar.getAuthor().getLevel_id();
                int is_bawu = sVar.getAuthor().getIs_bawu();
                String bawu_type = sVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !ev.g(this.dYv)) {
                    this.dZJ.setVisibility(0);
                    com.baidu.tbadk.core.util.av.c(this.dZJ, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.dZJ.setContentDescription(String.format(TbadkCoreApplication.m10getInst().getString(u.j.degree_in_forum), Integer.valueOf(level_id)));
                    this.dZJ.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                    this.dZJ.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.dZJ.setVisibility(8);
                }
                int i4 = this.ejJ.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.dZJ.setOnClickListener(this.baF);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.av.c(this.dZJ, u.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.av.c(this.dZJ, u.f.pb_assist);
                    }
                }
                if (sVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.av.c(this.dZL, u.f.icon_pb_pop_girl);
                    this.dZL.setVisibility(0);
                } else if (sVar.getAuthor().getGender() == 1) {
                    com.baidu.tbadk.core.util.av.c(this.dZL, u.f.icon_pb_pop_boy);
                    this.dZL.setVisibility(0);
                } else {
                    this.dZL.setVisibility(8);
                }
                this.dZL.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.dZt = sVar.getAuthor().getIconInfo();
                this.cQe = sVar.getAuthor().getTShowInfoNew();
                if (this.bVj != null) {
                    if (ev.g(sVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.dZt.size()) {
                                break;
                            }
                            IconData iconData = this.dZt.get(i6);
                            if (!ba.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.dZt = arrayList;
                    }
                    this.bVj.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
                    this.bVj.setOnClickListener(this.baF);
                    this.bVj.vy();
                    this.bVj.a(this.dZt, i4, this.ejw.getResources().getDimensionPixelSize(u.e.ds30), this.ejw.getResources().getDimensionPixelSize(u.e.ds30), this.ejw.getResources().getDimensionPixelSize(u.e.ds10));
                }
                if (this.aeT != null) {
                    this.aeT.setOnClickListener(this.baF);
                    if (this.cQe != null && this.cQe.size() > 0 && this.cQe.get(0) != null) {
                        this.aeT.setTag(this.cQe.get(0).getUrl());
                    }
                    this.aeT.a(this.cQe, 2, this.ejw.getResources().getDimensionPixelSize(u.e.ds30), this.ejw.getResources().getDimensionPixelSize(u.e.ds32), this.ejw.getResources().getDimensionPixelSize(u.e.ds8), true);
                }
            }
            a(this.dZQ, 0);
            UserTbVipInfoData userTbVipInfoData = sVar.getAuthor().getUserTbVipInfoData();
            if (userTbVipInfoData != null && !StringUtils.isNull(userTbVipInfoData.getvipV_url())) {
                this.ejA.setVisibility(0);
                this.dZI.setVisibility(4);
                if (userTbVipInfoData != null && userTbVipInfoData.getvipV_url() != null) {
                    if (this.aSW != null && this.dZp) {
                        if (this.aSX == null) {
                            this.aSW.inflate();
                            this.aSX = (TbImageView) this.eju.findViewById(u.g.user_head_mask);
                        }
                        this.aSX.c(userTbVipInfoData.getvipV_url(), 10, false);
                        this.ejA.setIsBigV(true);
                    }
                    this.ejA.setUserId(sVar.getAuthor().getUserId());
                    this.ejA.setUserName(sVar.getAuthor().getUserName());
                    this.ejA.c(portrait, 28, false);
                    return;
                }
                return;
            }
            if (sVar.getAuthor().getGodUserData().getId() != null && sVar.getAuthor().getGodUserData().getType() == 2) {
                this.ejA.setVisibility(0);
                this.dZI.setVisibility(4);
                this.ejA.setUserId(sVar.getAuthor().getUserId());
                this.ejA.setUserName(sVar.getAuthor().getUserName());
                this.ejA.c(portrait, 28, false);
            } else {
                this.ejA.setVisibility(8);
                this.dZI.setVisibility(0);
                this.dZI.setUserId(sVar.getAuthor().getUserId());
                this.dZI.setUserName(sVar.getAuthor().getUserName());
                this.dZI.setDefaultResource(u.f.transparent_bg);
                this.dZI.setDefaultErrorResource(u.f.icon_default_avatar100);
                this.dZI.c(portrait, 28, false);
            }
            if (!this.dZp) {
                this.dZI.setVisibility(8);
                this.ejA.setVisibility(8);
            }
            this.aPR.setTag(u.g.tag_user_id, sVar.getAuthor().getUserId());
            this.aPR.setTag(u.g.tag_user_name, sVar.getAuthor().getUserName());
            this.dZQ.setText(sVar.avx());
            if (!TextUtils.isEmpty(sVar.getBimg_url())) {
                this.dZQ.setBackgroundDrawable(null);
                this.dZQ.setTag(sVar.getBimg_url());
                this.dZQ.setOnClickListener(this.baF);
                this.dZQ.setTextViewOnClickListener(this.baF);
                this.dZQ.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.dF().a(sVar.getBimg_url(), 19, new am(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dZQ.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.dZQ.setPadding(0, 0, 0, 0);
                this.dZQ.setLayoutParams(layoutParams);
                this.dZQ.setBackgroundDrawable(null);
            }
            if (sVar != null) {
                com.baidu.tieba.pb.view.u.a(sVar.aMg(), this.ejD, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth);
            this.dZQ.setMaxImageHeight((int) (this.maxImageWidth * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.ejw.getPageContext().getString(u.j.refresh_view_title_text), this.KG));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.ejw.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.ejx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, u.f.pic_emotion07, com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds320), com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds480), com.baidu.adp.lib.util.k.c(pageActivity, u.e.ds360)), dVar, a, false);
        }
        this.ejx.setVisibility(0);
        this.zU.setVisibility(8);
        this.cdm.setVisibility(8);
        this.dhw.Ct();
        com.baidu.tbadk.core.util.av.l(this.mNoDataView, u.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.ejw.getPageContext(), TbadkCoreApplication.m10getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fM(int i) {
        a(NoDataViewFactory.d.v(i, u.j.refresh_view_title_text));
    }

    public void ox(String str) {
        a(NoDataViewFactory.d.af(str, this.ejw.getPageContext().getString(u.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.zU.setVisibility(0);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.KG = onClickListener;
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
            if (this.ejW != null && this.ejW.Iw() != null && this.ejW.Iw().getAuthor() != null && sVar.getAuthor() != null) {
                String userId3 = this.ejW.Iw().getAuthor().getUserId();
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
                    int i2 = sVar.bfB() != 1 ? 0 : 1;
                    if (ev.g(sVar)) {
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
                        if (this.ejW.Iw() != null) {
                            sparseArray.put(u.g.tag_user_mute_thread_id, this.ejW.Iw().getId());
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
            if (sVar.bfB() != 1) {
            }
            if (ev.g(sVar)) {
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
        this.ebe = new Cdo(this.ejw.getPageContext(), this.baF);
        this.ebe.hL(TbadkCoreApplication.isLogin());
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(u.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(u.g.tag_clip_board) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(u.g.tag_clip_board, sVar);
            sparseArray2.put(u.g.tag_is_subpb, false);
            this.ebe.aJv().setTag(sparseArray2);
            if (z2) {
                this.ebe.aJv().setText(u.j.remove_mark);
            } else {
                this.ebe.aJv().setText(u.j.mark);
            }
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray3.get(u.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(u.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray3.get(u.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(u.g.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray3.get(u.g.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray3.get(u.g.tag_del_post_is_self)).booleanValue() : false;
            if (sparseArray3.get(u.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray3.get(u.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                this.ebe.aJw().setText(u.j.manage);
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
                this.ebe.aJw().setTag(sparseArray4);
                this.ebe.aJw().setVisibility(0);
            } else {
                this.ebe.aJw().setVisibility(8);
            }
            if (booleanValue3) {
                SparseArray sparseArray5 = new SparseArray();
                sparseArray5.put(u.g.tag_should_delete_visible, true);
                sparseArray5.put(u.g.tag_manage_user_identity, sparseArray3.get(u.g.tag_manage_user_identity));
                sparseArray5.put(u.g.tag_del_post_is_self, Boolean.valueOf(booleanValue3));
                sparseArray5.put(u.g.tag_del_post_id, sparseArray3.get(u.g.tag_del_post_id));
                sparseArray5.put(u.g.tag_del_post_type, sparseArray3.get(u.g.tag_del_post_type));
                this.ebe.aJy().setTag(sparseArray5);
                this.ebe.aJy().setVisibility(0);
            } else {
                this.ebe.aJy().setVisibility(8);
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
                this.ebe.aJx().setText(u.j.mute_option);
                this.ebe.aJx().setTag(sparseArray7);
                this.ebe.aJx().setVisibility(0);
                this.ebe.aJw().setVisibility(8);
            } else {
                String str2 = sparseArray6.get(u.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray6.get(u.g.tag_forbid_user_post_id) : null;
                if (ev.g(sparseArray6.get(u.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray6.get(u.g.tag_clip_board) : null) ? false : TbadkCoreApplication.isLogin() & z) {
                    this.ebe.aJx().setVisibility(0);
                    this.ebe.aJx().setTag(str2);
                } else {
                    this.ebe.aJx().setVisibility(8);
                }
            }
        }
        this.ebe.aJz().setVisibility(8);
        this.ebe.aJC();
        this.ebe.uP();
    }

    public void ik(boolean z) {
        if (this.ebe != null && this.ebe.aJv() != null) {
            if (z) {
                this.ebe.aJv().setText(u.j.remove_mark);
            } else {
                this.ebe.aJv().setText(u.j.mark);
            }
            this.ebe.uP();
        }
    }

    public View aLB() {
        return this.ejQ;
    }

    public void onChangeSkinType(int i) {
        this.ejw.getLayoutMode().af(i == 1);
        this.ejw.getLayoutMode().w(this.dWr);
        this.ejw.getLayoutMode().w(this.eju);
        this.mNavigationBar.onChangeSkinType(this.ejw.getPageContext(), i);
        if (this.ejy != null) {
            com.baidu.tbadk.core.util.av.b(this.ejy, u.d.cp_cont_b, u.d.cp_cont_b);
        }
        this.bBo.onChangeSkinType(this.ejw.getPageContext(), i);
        this.ejw.getLayoutMode().w(this.ejQ);
        com.baidu.tbadk.core.util.av.c(this.dZP, u.f.icon_pb_reply_btn_selector);
        com.baidu.tbadk.core.util.av.c(this.ejC, u.f.btn_pb_more_btn_selector);
        this.dZQ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10039));
        this.dZQ.setVideoImageId(u.f.pic_video);
        if (this.dhw != null && this.dhw.Bl() != null) {
            this.dhw.Bl().onChangeSkinType(i);
        }
    }

    public void aLC() {
        this.cdm.setVisibility(0);
    }

    public void aLD() {
        this.zU.setVisibility(0);
        this.cdm.setVisibility(8);
        this.ejN.vi();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bxI = onLongClickListener;
        this.eju.setOnLongClickListener(this.bxI);
    }

    public View aLE() {
        return this.eju;
    }

    public void oy(String str) {
        int oz = this.ejv.oz(str);
        if (oz > -1) {
            this.zU.setSelection(oz + 1);
            this.zU.invalidate();
        }
    }

    public View aLF() {
        return this.ejy;
    }

    public MorePopupWindow aLG() {
        return this.ejO;
    }

    public HeadImageView aLH() {
        return this.dZI;
    }

    public ClickableHeaderImageView aLI() {
        return this.ejA;
    }

    public TextView getUserNameView() {
        return this.aPR;
    }

    public UserIconBox aLJ() {
        return this.bVj;
    }

    public ImageView aLK() {
        return this.dZJ;
    }

    public UserIconBox aLL() {
        return this.aeT;
    }

    public void atw() {
        if (this.ehA == null) {
            this.ehA = new com.baidu.tbadk.core.view.b(this.ejw.getPageContext());
        }
        this.ehA.aE(true);
    }

    public void aFN() {
        if (this.ehA != null) {
            this.ehA.aE(false);
        }
    }

    public TextView aLM() {
        return this.ejD;
    }

    public TbRichTextView aLN() {
        return this.dZQ;
    }

    public TextView aLO() {
        if (this.dZQ == null) {
            return null;
        }
        return this.dZQ.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.eji = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.ejj = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.dZQ != null) {
            this.dZQ.setOnEmotionClickListener(cVar);
        }
    }

    public View Wx() {
        return this.ejC;
    }

    public Cdo aLP() {
        return this.ebe;
    }

    public void Yy() {
        if (this.ejL != null) {
            this.ejL.Yy();
        }
    }

    public void auh() {
        if (this.ejL != null) {
            this.ejL.auh();
        }
    }

    public void onActivityDestroy() {
        if (this.ejL != null) {
            this.ejL.onActivityDestroy();
        }
    }

    public void aLQ() {
        if (!this.ejw.aLu() && this.ejL != null) {
            this.ejL.aLQ();
        }
    }
}
