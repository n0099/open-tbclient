package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.media.TransportMediator;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
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
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.at;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.dp;
import com.baidu.tieba.pb.pb.main.ev;
import com.baidu.tieba.pb.pb.main.ex;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao {
    private static final int evp = TbadkCoreApplication.m9getInst().getListItemRule().yA();
    private BdListView Im;
    private View bLH;
    private NoNetworkView bMH;
    private View.OnClickListener csa;
    private RelativeLayout egK;
    private dp eln;
    private View epB;
    private com.baidu.tbadk.core.view.a esM;
    private SubPbModel euV;
    private com.baidu.tieba.pb.data.j eul;
    private ThreadSkinView evE;
    private bb evF;
    private View evI;
    private ArrayList<PostData> evM;
    private String evN;
    private TextView evO;
    private b evj;
    private View evq;
    private ba evr;
    private NewSubPbActivity evs;
    private RelativeLayout evt;
    private TextView evu;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.y mNoDataView = null;
    private TbRichTextView.e eva = null;
    private View.OnClickListener RA = null;
    private TbRichTextView.f euZ = null;
    private NavigationBar mNavigationBar = null;
    private View aom = null;
    private TextView evv = null;
    private LinearLayout evw = null;
    private HeadImageView evx = null;
    private ClickableHeaderImageView epP = null;
    private TextView amq = null;
    private ImageView evy = null;
    private TextView evz = null;
    private TextView evA = null;
    private TextView ejT = null;
    private EllipsizeRichTextView evB = null;
    private TbImageView evC = null;
    private PlayVoiceBntNew bvE = null;
    private TextView evD = null;
    private MorePopupWindow evG = null;
    private ev evH = null;
    private com.baidu.tbadk.core.dialog.c esA = null;
    private Dialog esg = null;
    private com.baidu.tbadk.core.dialog.a esi = null;
    private boolean cCs = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bIW = null;
    private NewSubPbActivity.a evJ = null;
    private NewSubPbActivity.a evK = null;
    private ArrayList<IconData> ejz = null;
    private ArrayList<IconData> cYe = null;
    private com.baidu.tbadk.editortools.pb.n dnB = null;
    private String evL = null;
    private int aMF = 0;
    private PostData eiL = null;
    private int evP = 0;
    private int evQ = 2;
    private int evR = 0;
    private boolean evk = true;
    protected HashMap<Long, HashSet<String>> evS = new HashMap<>();
    protected final b.a evT = new ap(this);
    private View.OnClickListener ejA = new at(this);
    private com.baidu.tieba.pb.a.d ejB = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener evU = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.egK = null;
        this.evq = null;
        this.Im = null;
        this.evr = null;
        this.evs = null;
        this.bMH = null;
        this.evt = null;
        this.evu = null;
        this.epB = null;
        this.evF = null;
        this.evI = null;
        this.csa = null;
        this.mProgress = null;
        this.evO = null;
        this.evs = newSubPbActivity;
        this.csa = onClickListener;
        this.egK = (RelativeLayout) LayoutInflater.from(this.evs.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_layout, (ViewGroup) null);
        this.evq = LayoutInflater.from(this.evs.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_head, (ViewGroup) null);
        this.evu = (TextView) this.egK.findViewById(w.h.no_reply_list_view);
        this.evO = (TextView) this.egK.findViewById(w.h.subpb_editor_tool_reply_text);
        this.evO.setOnClickListener(this.csa);
        this.bMH = (NoNetworkView) this.egK.findViewById(w.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.af(this.evs.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60);
        aPu();
        XT();
        this.evt = (RelativeLayout) this.egK.findViewById(w.h.sub_pb_body_layout);
        this.Im = (BdListView) this.egK.findViewById(w.h.new_sub_pb_list);
        this.evE = (ThreadSkinView) LayoutInflater.from(this.evs.getPageContext().getPageActivity()).inflate(w.j.thread_skin_layout, (ViewGroup) null);
        this.Im.addHeaderView(this.evE);
        this.Im.addHeaderView(this.evq);
        this.bLH = BdListViewHelper.a(this.evs.getActivity(), this.Im, BdListViewHelper.HeadType.DEFAULT);
        this.evr = new ba(this.evs.getPageContext().getPageActivity());
        this.evr.I(this.ejA);
        this.evr.setIsFromCDN(this.mIsFromCDN);
        this.evr.jj(true);
        this.Im.setAdapter((ListAdapter) this.evr);
        this.evF = new bb(this.evs.getPageContext());
        this.evI = this.evF.getView();
        this.Im.setNextPage(this.evF);
        this.evF.setOnClickListener(this.csa);
        this.Im.setOnItemClickListener(this.evU);
        this.Im.setOnTouchListener(this.ejB);
        this.mProgress = (ProgressBar) this.egK.findViewById(w.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.evq != null) {
            this.evq.setVisibility(4);
        }
        if (this.evt != null) {
            this.evt.setVisibility(4);
        }
        this.epB = com.baidu.tbadk.ala.c.oa().h(this.evs.getActivity(), 4);
        if (this.epB != null) {
            this.epB.setVisibility(8);
            this.evw.addView(this.epB, 3);
        }
    }

    public ListView getListView() {
        return this.Im;
    }

    public void XT() {
        this.evw = (LinearLayout) this.evq.findViewById(w.h.subpb_head_user_info_root);
        this.evw.setOnClickListener(this.csa);
        this.evx = (HeadImageView) this.evq.findViewById(w.h.photo);
        this.evx.setRadius(com.baidu.adp.lib.util.k.g(this.evs.getActivity(), w.f.ds30));
        this.epP = (ClickableHeaderImageView) this.evq.findViewById(w.h.god_user_photo);
        this.epP.setGodIconMargin(0);
        this.epP.setGodIconWidth(w.f.ds24);
        this.epP.setRadius(com.baidu.adp.lib.util.k.g(this.evs.getActivity(), w.f.ds30));
        this.amq = (TextView) this.evq.findViewById(w.h.user_name);
        this.evy = (ImageView) this.evq.findViewById(w.h.user_rank);
        this.evz = (TextView) this.evq.findViewById(w.h.floor_owner);
        this.evv = (TextView) this.evq.findViewById(w.h.see_subject);
        this.evv.setOnClickListener(this.csa);
        this.evA = (TextView) this.evq.findViewById(w.h.floor);
        this.ejT = (TextView) this.evq.findViewById(w.h.time);
        this.evB = (EllipsizeRichTextView) this.evq.findViewById(w.h.content_text);
        this.evB.setOnClickListener(this.csa);
        com.baidu.tbadk.core.util.aq.i(this.evB, w.e.cp_cont_b);
        this.evB.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        this.evB.setLineSpacing(0.0f, 1.25f);
        this.evC = (TbImageView) this.evq.findViewById(w.h.sub_pb_image);
        this.evC.setOnClickListener(this.csa);
        this.evD = (TextView) this.evq.findViewById(w.h.advert);
        this.bvE = (PlayVoiceBntNew) this.evq.findViewById(w.h.voice_btn);
        this.evq.setOnTouchListener(this.ejB);
        this.evq.setOnClickListener(this.csa);
    }

    public void jh(boolean z) {
        if (this.bLH != null && this.bLH.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bLH.getLayoutParams();
            if (z) {
                aPs();
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.evs.getPageContext().getPageActivity(), w.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.evs.getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bLH.setLayoutParams(layoutParams);
        }
    }

    private void aPs() {
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_close, w.g.subpb_navigationbar_close);
    }

    public View aPt() {
        return this.bLH;
    }

    public void aPu() {
        this.mNavigationBar = (NavigationBar) this.egK.findViewById(w.h.view_navigation_bar);
        this.aom = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aom.getLayoutParams();
            int g = com.baidu.adp.lib.util.k.g(this.evs.getPageContext().getPageActivity(), w.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aom != null && (this.aom.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aom.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aom.setPadding(com.baidu.adp.lib.util.k.g(this.evs.getPageContext().getPageActivity(), w.f.ds32), this.aom.getPaddingTop(), this.aom.getPaddingRight(), this.aom.getPaddingBottom());
            this.aom.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_back, w.g.subpb_navigationbar_back);
    }

    public NavigationBar Kt() {
        return this.mNavigationBar;
    }

    public void ba(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.esg == null) {
            this.esg = new Dialog(this.evs.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.esg.setCanceledOnTouchOutside(true);
            this.esg.setCancelable(true);
            View inflate = LayoutInflater.from(this.evs.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
            this.evs.getLayoutMode().t(inflate);
            this.esg.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.esg.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.af(this.evs.getPageContext().getPageActivity()) * 0.9d);
            this.esg.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.esg.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.esg.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.esg.findViewById(w.h.disable_reply_btn);
        if ("".equals(sparseArray.get(w.h.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(w.h.tag_del_post_id, sparseArray.get(w.h.tag_del_post_id));
            sparseArray2.put(w.h.tag_del_post_type, sparseArray.get(w.h.tag_del_post_type));
            sparseArray2.put(w.h.tag_del_post_is_self, sparseArray.get(w.h.tag_del_post_is_self));
            sparseArray2.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            textView.setOnClickListener(new ax(this));
        }
        if ("".equals(sparseArray.get(w.h.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(w.h.tag_forbid_user_name, sparseArray.get(w.h.tag_forbid_user_name));
            sparseArray3.put(w.h.tag_manage_user_identity, sparseArray.get(w.h.tag_manage_user_identity));
            sparseArray3.put(w.h.tag_forbid_user_post_id, sparseArray.get(w.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ay(this));
        }
        if (!((sparseArray.get(w.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(w.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(w.l.un_mute);
            } else {
                textView3.setText(w.l.mute);
            }
            sparseArray4.put(w.h.tag_is_mem, sparseArray.get(w.h.tag_is_mem));
            sparseArray4.put(w.h.tag_user_mute_mute_userid, sparseArray.get(w.h.tag_user_mute_mute_userid));
            sparseArray4.put(w.h.tag_user_mute_mute_username, sparseArray.get(w.h.tag_user_mute_mute_username));
            sparseArray4.put(w.h.tag_user_mute_post_id, sparseArray.get(w.h.tag_user_mute_post_id));
            sparseArray4.put(w.h.tag_user_mute_thread_id, sparseArray.get(w.h.tag_user_mute_thread_id));
            textView3.setOnClickListener(new az(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.esg, this.evs.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.h.tag_del_post_id, str);
        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = w.l.del_post_confirm;
        if (i == 0) {
            i3 = w.l.del_thread_confirm;
        }
        this.esi = new com.baidu.tbadk.core.dialog.a(this.evs.getPageContext().getPageActivity());
        this.esi.bZ(i3);
        this.esi.A(sparseArray);
        this.esi.a(w.l.dialog_ok, new aq(this, sparseArray));
        this.esi.b(w.l.dialog_cancel, new ar(this));
        this.esi.av(true);
        this.esi.b(this.evs.getPageContext());
        this.esi.tQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iS(boolean z) {
        if (this.Im != null) {
            if (!z) {
                this.Im.setEnabled(z);
            } else {
                this.Im.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.esA != null) {
            this.esA.dismiss();
            this.esA = null;
        }
        if (z) {
            string = this.evs.getResources().getString(w.l.remove_mark);
        } else {
            string = this.evs.getResources().getString(w.l.mark);
        }
        this.esA = new com.baidu.tbadk.core.dialog.c(this.evs.getPageContext().getPageActivity());
        this.esA.cc(w.l.operation);
        this.esA.a(new String[]{this.evs.getResources().getString(w.l.copy), string}, bVar);
        this.esA.d(this.evs.getPageContext());
        this.esA.tT();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.evJ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.evK = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.evs.showToast(this.evs.getResources().getString(w.l.delete_success));
        } else if (str != null && z2) {
            this.evs.showToast(str);
        }
    }

    public void aZ(View view) {
        if (this.bLH != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bLH.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Im != null) {
                    this.Im.removeHeaderView(this.bLH);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bLH.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.evs.getActivity(), w.f.ds98)));
            } else if (this.Im != null) {
                this.Im.addHeaderView(this.bLH, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.Dn() != null) {
            this.dnB = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.egK.addView(nVar.Dn(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.evj = bVar;
    }

    public void aPv() {
        if (this.Im != null) {
            this.evR = this.Im.getLastVisiblePosition();
        }
    }

    public void aPw() {
        if (this.euV != null) {
            if ((!aPz() && this.evI != null && this.evI.isShown()) || com.baidu.tbadk.core.util.x.q(this.evM)) {
                this.euV.jl(false);
            } else {
                this.euV.jl(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.euV = subPbModel;
    }

    public void aPx() {
        a(this.evs);
        this.Im.setNextPage(this.evF);
    }

    public void k(PostData postData) {
        int i;
        if (postData != null) {
            postData.lt(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aPz() && this.evI != null && this.evI.isShown()) {
                i = (this.evR - this.evQ) - 1;
            } else {
                i = this.evR - this.evQ;
            }
            int p = com.baidu.tbadk.core.util.x.p(this.evM);
            if (i > p) {
                i = p;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.evM, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, postData2);
            com.baidu.tbadk.core.util.x.b(arrayList, postData);
            this.evr.setDatas(arrayList);
            this.evr.notifyDataSetChanged();
            this.Im.smoothScrollToPosition(this.evR + 2);
            this.Im.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Im.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Im.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.egK;
    }

    public void axI() {
        if (this.evG != null) {
            com.baidu.adp.lib.g.j.a(this.evG, this.evs.getPageContext().getPageActivity());
        }
        if (this.esA != null) {
            this.esA.dismiss();
        }
        if (this.esi != null) {
            this.esi.dismiss();
        }
        if (this.esg != null) {
            com.baidu.adp.lib.g.j.b(this.esg, this.evs.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.eln != null) {
            this.eln.dismiss();
        }
    }

    public void aPy() {
        this.Im.setNextPage(this.evF);
        this.evF.xd();
    }

    public void ik(boolean z) {
        this.cCs = z;
    }

    public void setIsFromPb(boolean z) {
        this.evk = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (jVar != null) {
            if (this.evk && this.evq != null) {
                this.evr.jk(true);
                this.evq.setVisibility(8);
                this.Im.removeHeaderView(this.evq);
                this.evQ = 1;
            }
            this.eul = jVar;
            this.evr.h(this.eul.Kn());
            if (this.evq != null) {
                this.evq.setVisibility(0);
            }
            if (this.evt != null) {
                this.evt.setVisibility(0);
            }
            if (jVar.aKW() != null) {
                this.evL = jVar.aKW().getId();
                this.aMF = jVar.aKW().bjp();
                if (this.aMF > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.evs.getPageContext().getString(w.l.which_floor_reply), Integer.valueOf(this.aMF)));
                    this.evO.setText(String.format(this.evs.getPageContext().getString(w.l.reply_some_floor), Integer.valueOf(this.aMF)));
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.evs.aPr()) {
                    str = "PB";
                }
                if (jVar.aKW().sJ() != null) {
                    this.evE.a(this.evs.getPageContext(), jVar.aKW().sJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", jVar.aLc().getId(), jVar.aLc().getName(), jVar.Kn().getId(), str));
                } else {
                    this.evE.a(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.evF.xd();
                this.evr.setHasMoreData(true);
            } else {
                this.evF.xe();
                this.evr.setHasMoreData(false);
            }
            this.evM = jVar.aLa();
            if (com.baidu.tbadk.core.util.x.q(this.evM)) {
                this.Im.setNextPage(null);
                if (this.evk) {
                    this.evu.setVisibility(0);
                }
            } else {
                this.Im.setNextPage(this.evF);
                if (this.evk) {
                    this.evu.setVisibility(8);
                }
            }
            if (this.evM == null || this.evM.size() <= evp) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.evM.size() - evp;
                oD(size);
                int firstVisiblePosition = this.Im.getFirstVisiblePosition() - size;
                View childAt = this.Im.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.evr.setDatas(this.evM);
            boolean z2 = false;
            if (jVar.Kn() != null && jVar.Kn().getAuthor() != null && (userId = jVar.Kn().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.evr.B(i, z2);
            this.evr.notifyDataSetChanged();
            a(jVar.aKW(), jVar.atS(), jVar.oe(), i, z);
            if (i4 > 0) {
                this.Im.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void oD(int i) {
        if (this.evM != null) {
            if (this.evM.size() <= i) {
                this.evM.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.evM.iterator();
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

    public boolean aPz() {
        return this.evr.bDg;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.evk) {
            this.eiL = postData;
            if (!StringUtils.isNull(postData.bjv())) {
                this.evC.setVisibility(0);
                this.evC.c(postData.bjv(), 10, true);
            } else {
                this.evC.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bjx = postData.bjx();
            if (bjx != null && bjx.fxO) {
                this.evD.setVisibility(0);
            } else {
                this.evD.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.evq.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.evq.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.evA.setText((CharSequence) null);
            this.amq.setText((CharSequence) null);
            this.evz.setVisibility(8);
            if (!this.evk) {
                a(postData.getAuthor());
                if (z) {
                    this.evz.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i(this.evz, w.e.cp_link_tip_a);
                }
            }
            this.ejT.setText(com.baidu.tbadk.core.util.au.q(postData.getTime()));
            if (this.cCs) {
                int i2 = w.g.img_default_100;
            } else {
                int i3 = w.g.icon_click;
            }
            this.evA.setText(String.format(this.evs.getPageContext().getString(w.l.is_floor), Integer.valueOf(postData.bjp())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.evB, postData.axm());
            if (StringUtils.isNull(postData.bjv()) && !a && postData.Iw() != null) {
                this.bvE.setVisibility(0);
                this.bvE.setTag(postData.Iw());
                return;
            }
            this.bvE.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gq = com.baidu.tbadk.util.u.gq(name_show);
            com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aF(metaData.getSealPrefix()) + 2 : 0) + gq > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.amq.setText(af(metaData.getSealPrefix(), name_show));
            } else {
                this.amq.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.epB != null) {
                if (metaData.getAlaUserData().anchor_live == 0 && metaData.getAlaUserData().enter_live == 0) {
                    this.epB.setVisibility(8);
                } else {
                    this.epB.setVisibility(0);
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.QS = metaData.getAlaUserData();
                    bVar.type = 4;
                    this.epB.setTag(bVar);
                }
            }
            this.evP = 0;
            this.evP = metaData.getLevel_id();
            if (this.evP > 0) {
                this.evy.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.evy, BitmapHelper.getSmallGradeResourceIdNew(this.evP));
                this.evy.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.evP)));
                this.evy.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.evy.setOnClickListener(null);
            } else {
                this.evy.setVisibility(8);
            }
            if (metaData.isGod()) {
                this.epP.setVisibility(0);
                this.evx.setVisibility(8);
                this.epP.setUserId(metaData.getUserId());
                this.epP.setUserName(metaData.getUserName());
                this.epP.c(metaData.getPortrait(), 28, false);
            } else {
                this.epP.setVisibility(8);
                this.evx.setVisibility(0);
                this.evx.setUserId(metaData.getUserId());
                this.evx.setUserName(metaData.getUserName());
                this.evx.setDefaultResource(w.g.transparent_bg);
                this.evx.setDefaultErrorResource(w.g.icon_default_avatar100);
                this.evx.c(metaData.getPortrait(), 28, false);
            }
            this.evw.setTag(w.h.tag_user_id, metaData.getUserId());
            this.evw.setTag(w.h.tag_user_name, metaData.getUserName());
            this.evw.setTag(w.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Io() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Io().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Iv());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.cc(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.bnn());
                        continue;
                    case 17:
                        String str = next.Iz().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.IE()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Iv() == null || tbRichTextData.Iv().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Iv());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.evs.getPageContext().getString(w.l.refresh_view_title_text), this.RA));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.evs.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.evt, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, w.g.pic_emotion07, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds300), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds480), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds360)), dVar, a);
        }
        this.evt.setVisibility(0);
        this.Im.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.dnB.Em();
        com.baidu.tbadk.core.util.aq.k(this.mNoDataView, w.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.evs.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fV(int i) {
        a(NoDataViewFactory.d.E(i, w.l.refresh_view_title_text));
        if (this.evj != null) {
            this.evj.bb(this.egK);
        }
        this.evO.setVisibility(8);
    }

    public void nN(String str) {
        a(NoDataViewFactory.d.ae(str, this.evs.getPageContext().getString(w.l.refresh_view_title_text)));
        if (this.evj != null) {
            this.evj.bb(this.egK);
        }
        this.evO.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Im.setVisibility(0);
            this.evO.setVisibility(0);
            this.egK.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.RA = onClickListener;
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
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = postData.getAuthor().getUserId();
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
            if (this.eul != null && this.eul.Kn() != null && this.eul.Kn().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.eul.Kn().getAuthor().getUserId();
                String userId4 = postData.getAuthor().getUserId();
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
                    userId = postData.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.bjp() != 1 ? 0 : 1;
                    if (ex.g(postData)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                        sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(w.h.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_del_post_is_self, true);
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(w.h.tag_del_post_is_self, false);
                        sparseArray.put(w.h.tag_del_post_type, 0);
                        sparseArray.put(w.h.tag_del_post_id, "");
                    }
                    sparseArray.put(w.h.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
                    if (!z6) {
                        sparseArray.put(w.h.tag_should_manage_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                    } else {
                        sparseArray.put(w.h.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(w.h.tag_user_mute_visible, true);
                        sparseArray.put(w.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.getAuthor() != null) {
                            sparseArray.put(w.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                            sparseArray.put(w.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                        }
                        if (this.eul.Kn() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.eul.Kn().getId());
                        }
                        sparseArray.put(w.h.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(w.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(w.h.tag_should_delete_visible, true);
                        sparseArray.put(w.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(w.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(w.h.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(w.h.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.bjp() != 1) {
            }
            if (ex.g(postData)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(w.h.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(w.h.tag_forbid_user_post_id, postData.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void ji(boolean z) {
        if (this.eln != null && this.eln.aNg() != null) {
            if (z) {
                this.eln.aNg().setText(w.l.remove_mark);
            } else {
                this.eln.aNg().setText(w.l.mark);
            }
            this.eln.refreshUI();
        }
    }

    public View aPA() {
        return this.evI;
    }

    public void onChangeSkinType(int i) {
        this.evs.getLayoutMode().aj(i == 1);
        this.evs.getLayoutMode().t(this.egK);
        this.evs.getLayoutMode().t(this.evq);
        this.mNavigationBar.onChangeSkinType(this.evs.getPageContext(), i);
        if (this.evv != null) {
            com.baidu.tbadk.core.util.aq.i(this.evv, w.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aq.i(this.evu, w.e.cp_cont_d);
        this.bMH.onChangeSkinType(this.evs.getPageContext(), i);
        this.evs.getLayoutMode().t(this.evI);
        com.baidu.tbadk.core.util.aq.i(this.evB, w.e.cp_cont_b);
        this.evB.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        if (this.dnB != null && this.dnB.Dn() != null) {
            this.dnB.Dn().onChangeSkinType(i);
        }
        this.evF.dk(i);
        this.bvE.bbd();
        com.baidu.tbadk.core.util.aq.i(this.evO, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.evO, w.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.aq.i(this.evz, w.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.aq.i(this.amq, w.e.cp_cont_c);
        if (this.evP > 0) {
            com.baidu.tbadk.core.util.aq.c(this.evy, BitmapHelper.getSmallGradeResourceIdNew(this.evP));
        }
        this.evO.setAlpha(0.95f);
        if (this.evr != null) {
            this.evr.notifyDataSetChanged();
        }
    }

    public void aPB() {
        this.mProgress.setVisibility(0);
    }

    public void aPC() {
        this.Im.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.evF.xe();
    }

    public void Zh() {
        this.Im.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.evF.Zh();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bIW = onLongClickListener;
        this.evq.setOnLongClickListener(this.bIW);
    }

    public View aPD() {
        return this.evq;
    }

    public TextView aPE() {
        return this.evO;
    }

    public void nO(String str) {
        int nP = this.evr.nP(str);
        if (nP > -1) {
            this.evr.oE(nP);
            if (nP > 2) {
                this.Im.setSelection(nP - 2);
            } else {
                this.Im.setSelection(nP);
            }
            this.Im.invalidate();
        }
    }

    public View aPF() {
        return this.evv;
    }

    public View aPG() {
        return this.evC;
    }

    public MorePopupWindow aPH() {
        return this.evG;
    }

    public void avw() {
        if (this.esM == null) {
            this.esM = new com.baidu.tbadk.core.view.a(this.evs.getPageContext());
        }
        this.esM.aK(true);
    }

    public void aJt() {
        if (this.esM != null) {
            this.esM.aK(false);
        }
    }

    public TextView aPI() {
        return this.evB;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.euZ = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.eva = eVar;
    }

    public dp aPJ() {
        return this.eln;
    }

    public void acE() {
    }

    public void acF() {
    }

    public void onActivityDestroy() {
    }

    public void aPK() {
        if (this.evs.aPq()) {
        }
    }

    public View aPL() {
        return this.evw;
    }

    private SpannableStringBuilder af(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.evs.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
