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
import com.baidu.tieba.pb.pb.main.dr;
import com.baidu.tieba.pb.pb.main.ex;
import com.baidu.tieba.pb.pb.main.ez;
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
    private static final int euT = TbadkCoreApplication.m9getInst().getListItemRule().yc();
    private BdListView IK;
    private View bJx;
    private NoNetworkView bKx;
    private ProgressBar bqO;
    private View.OnClickListener crj;
    private RelativeLayout egn;
    private dr ekR;
    private View epb;
    private com.baidu.tbadk.core.view.a esm;
    private com.baidu.tieba.pb.data.j etQ;
    private b euN;
    private View euU;
    private ba euV;
    private NewSubPbActivity euW;
    private RelativeLayout euX;
    private TextView euY;
    private SubPbModel euz;
    private ThreadSkinView evi;
    private bb evj;
    private View evm;
    private ArrayList<PostData> evq;
    private String evr;
    private TextView evs;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.y mNoDataView = null;
    private TbRichTextView.e euE = null;
    private View.OnClickListener Rg = null;
    private TbRichTextView.f euD = null;
    private NavigationBar mNavigationBar = null;
    private View anY = null;
    private TextView euZ = null;
    private LinearLayout eva = null;
    private HeadImageView evb = null;
    private ClickableHeaderImageView epp = null;
    private TextView amc = null;
    private ImageView evc = null;
    private TextView evd = null;
    private TextView eve = null;
    private TextView ejx = null;
    private EllipsizeRichTextView evf = null;
    private TbImageView evg = null;
    private PlayVoiceBntNew btu = null;
    private TextView evh = null;
    private MorePopupWindow evk = null;
    private ex evl = null;
    private com.baidu.tbadk.core.dialog.c esa = null;
    private Dialog erG = null;
    private com.baidu.tbadk.core.dialog.a erI = null;
    private boolean cBC = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bGM = null;
    private NewSubPbActivity.a evn = null;
    private NewSubPbActivity.a evo = null;
    private ArrayList<IconData> ejd = null;
    private ArrayList<IconData> cXq = null;
    private com.baidu.tbadk.editortools.pb.n dmL = null;
    private String evp = null;
    private int aMn = 0;
    private PostData eio = null;
    private int evt = 0;
    private int evu = 2;
    private int evv = 0;
    private boolean euO = true;
    protected HashMap<Long, HashSet<String>> evw = new HashMap<>();
    protected final b.a evx = new ap(this);
    private View.OnClickListener eje = new at(this);
    private com.baidu.tieba.pb.a.d ejf = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener evy = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.egn = null;
        this.euU = null;
        this.IK = null;
        this.euV = null;
        this.euW = null;
        this.bKx = null;
        this.euX = null;
        this.euY = null;
        this.epb = null;
        this.evj = null;
        this.evm = null;
        this.crj = null;
        this.bqO = null;
        this.evs = null;
        this.euW = newSubPbActivity;
        this.crj = onClickListener;
        this.egn = (RelativeLayout) LayoutInflater.from(this.euW.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_layout, (ViewGroup) null);
        this.euU = LayoutInflater.from(this.euW.getPageContext().getPageActivity()).inflate(w.j.new_sub_pb_head, (ViewGroup) null);
        this.euY = (TextView) this.egn.findViewById(w.h.no_reply_list_view);
        this.evs = (TextView) this.egn.findViewById(w.h.subpb_editor_tool_reply_text);
        this.evs.setOnClickListener(this.crj);
        this.bKx = (NoNetworkView) this.egn.findViewById(w.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.ag(this.euW.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(w.f.ds60);
        aOk();
        Wu();
        this.euX = (RelativeLayout) this.egn.findViewById(w.h.sub_pb_body_layout);
        this.IK = (BdListView) this.egn.findViewById(w.h.new_sub_pb_list);
        this.evi = (ThreadSkinView) LayoutInflater.from(this.euW.getPageContext().getPageActivity()).inflate(w.j.thread_skin_layout, (ViewGroup) null);
        this.IK.addHeaderView(this.evi);
        this.IK.addHeaderView(this.euU);
        this.bJx = BdListViewHelper.a(this.euW.getActivity(), this.IK, BdListViewHelper.HeadType.DEFAULT);
        this.euV = new ba(this.euW.getPageContext().getPageActivity());
        this.euV.H(this.eje);
        this.euV.setIsFromCDN(this.mIsFromCDN);
        this.euV.ja(true);
        this.IK.setAdapter((ListAdapter) this.euV);
        this.evj = new bb(this.euW.getPageContext());
        this.evm = this.evj.getView();
        this.IK.setNextPage(this.evj);
        this.evj.setOnClickListener(this.crj);
        this.IK.setOnItemClickListener(this.evy);
        this.IK.setOnTouchListener(this.ejf);
        this.bqO = (ProgressBar) this.egn.findViewById(w.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.euU != null) {
            this.euU.setVisibility(4);
        }
        if (this.euX != null) {
            this.euX.setVisibility(4);
        }
        this.epb = com.baidu.tbadk.ala.c.nD().h(this.euW.getActivity(), 4);
        if (this.epb != null) {
            this.epb.setVisibility(8);
            this.eva.addView(this.epb, 3);
        }
    }

    public ListView getListView() {
        return this.IK;
    }

    public void Wu() {
        this.eva = (LinearLayout) this.euU.findViewById(w.h.subpb_head_user_info_root);
        this.eva.setOnClickListener(this.crj);
        this.evb = (HeadImageView) this.euU.findViewById(w.h.photo);
        this.evb.setRadius(com.baidu.adp.lib.util.k.g(this.euW.getActivity(), w.f.ds30));
        this.epp = (ClickableHeaderImageView) this.euU.findViewById(w.h.god_user_photo);
        this.epp.setGodIconMargin(0);
        this.epp.setGodIconWidth(w.f.ds24);
        this.epp.setRadius(com.baidu.adp.lib.util.k.g(this.euW.getActivity(), w.f.ds30));
        this.amc = (TextView) this.euU.findViewById(w.h.user_name);
        this.evc = (ImageView) this.euU.findViewById(w.h.user_rank);
        this.evd = (TextView) this.euU.findViewById(w.h.floor_owner);
        this.euZ = (TextView) this.euU.findViewById(w.h.see_subject);
        this.euZ.setOnClickListener(this.crj);
        this.eve = (TextView) this.euU.findViewById(w.h.floor);
        this.ejx = (TextView) this.euU.findViewById(w.h.time);
        this.evf = (EllipsizeRichTextView) this.euU.findViewById(w.h.content_text);
        this.evf.setOnClickListener(this.crj);
        com.baidu.tbadk.core.util.aq.i((View) this.evf, w.e.cp_cont_b);
        this.evf.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        this.evf.setLineSpacing(0.0f, 1.25f);
        this.evg = (TbImageView) this.euU.findViewById(w.h.sub_pb_image);
        this.evg.setOnClickListener(this.crj);
        this.evh = (TextView) this.euU.findViewById(w.h.advert);
        this.btu = (PlayVoiceBntNew) this.euU.findViewById(w.h.voice_btn);
        this.euU.setOnTouchListener(this.ejf);
        this.euU.setOnClickListener(this.crj);
    }

    public void iY(boolean z) {
        if (this.bJx != null && this.bJx.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bJx.getLayoutParams();
            if (z) {
                aOi();
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.euW.getPageContext().getPageActivity(), w.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.g(this.euW.getPageContext().getPageActivity(), w.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bJx.setLayoutParams(layoutParams);
        }
    }

    private void aOi() {
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_close, w.g.subpb_navigationbar_close);
    }

    public View aOj() {
        return this.bJx;
    }

    public void aOk() {
        this.mNavigationBar = (NavigationBar) this.egn.findViewById(w.h.view_navigation_bar);
        this.anY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.anY.getLayoutParams();
            int g = com.baidu.adp.lib.util.k.g(this.euW.getPageContext().getPageActivity(), w.f.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.anY != null && (this.anY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.anY.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.anY.setPadding(com.baidu.adp.lib.util.k.g(this.euW.getPageContext().getPageActivity(), w.f.ds32), this.anY.getPaddingTop(), this.anY.getPaddingRight(), this.anY.getPaddingBottom());
            this.anY.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(w.g.subpb_navigationbar_back, w.g.subpb_navigationbar_back);
    }

    public NavigationBar JT() {
        return this.mNavigationBar;
    }

    public void bc(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.erG == null) {
            this.erG = new Dialog(this.euW.getPageContext().getPageActivity(), w.m.common_alert_dialog);
            this.erG.setCanceledOnTouchOutside(true);
            this.erG.setCancelable(true);
            View inflate = LayoutInflater.from(this.euW.getPageContext().getPageActivity()).inflate(w.j.forum_manage_dialog, (ViewGroup) null);
            this.euW.getLayoutMode().t(inflate);
            this.erG.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.erG.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.ag(this.euW.getPageContext().getPageActivity()) * 0.9d);
            this.erG.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.erG.findViewById(w.h.del_post_btn);
        TextView textView2 = (TextView) this.erG.findViewById(w.h.forbid_user_btn);
        TextView textView3 = (TextView) this.erG.findViewById(w.h.disable_reply_btn);
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
        com.baidu.adp.lib.g.j.a(this.erG, this.euW.getPageContext());
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
        this.erI = new com.baidu.tbadk.core.dialog.a(this.euW.getPageContext().getPageActivity());
        this.erI.bW(i3);
        this.erI.A(sparseArray);
        this.erI.a(w.l.dialog_ok, new aq(this, sparseArray));
        this.erI.b(w.l.dialog_cancel, new ar(this));
        this.erI.at(true);
        this.erI.b(this.euW.getPageContext());
        this.erI.ts();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(boolean z) {
        if (this.IK != null) {
            if (!z) {
                this.IK.setEnabled(z);
            } else {
                this.IK.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.esa != null) {
            this.esa.dismiss();
            this.esa = null;
        }
        if (z) {
            string = this.euW.getResources().getString(w.l.remove_mark);
        } else {
            string = this.euW.getResources().getString(w.l.mark);
        }
        this.esa = new com.baidu.tbadk.core.dialog.c(this.euW.getPageContext().getPageActivity());
        this.esa.bZ(w.l.operation);
        this.esa.a(new String[]{this.euW.getResources().getString(w.l.copy), string}, bVar);
        this.esa.d(this.euW.getPageContext());
        this.esa.tv();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.evn = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.evo = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.bqO != null) {
            this.bqO.setVisibility(8);
        }
        if (z && z2) {
            this.euW.showToast(this.euW.getResources().getString(w.l.delete_success));
        } else if (str != null && z2) {
            this.euW.showToast(str);
        }
    }

    public void bb(View view) {
        if (this.bJx != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bJx.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.IK != null) {
                    this.IK.removeHeaderView(this.bJx);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bJx.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.g(this.euW.getActivity(), w.f.ds98)));
            } else if (this.IK != null) {
                this.IK.addHeaderView(this.bJx, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.CP() != null) {
            this.dmL = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.egn.addView(nVar.CP(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.euN = bVar;
    }

    public void aOl() {
        if (this.IK != null) {
            this.evv = this.IK.getLastVisiblePosition();
        }
    }

    public void aOm() {
        if (this.euz != null) {
            if ((!aOp() && this.evm != null && this.evm.isShown()) || com.baidu.tbadk.core.util.x.q(this.evq)) {
                this.euz.jc(false);
            } else {
                this.euz.jc(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.euz = subPbModel;
    }

    public void aOn() {
        a(this.euW);
        this.IK.setNextPage(this.evj);
    }

    public void k(PostData postData) {
        int i;
        if (postData != null) {
            postData.lg(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!aOp() && this.evm != null && this.evm.isShown()) {
                i = (this.evv - this.evu) - 1;
            } else {
                i = this.evv - this.evu;
            }
            int p = com.baidu.tbadk.core.util.x.p(this.evq);
            if (i > p) {
                i = p;
            }
            ArrayList<PostData> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.x.a(this.evq, 0, i));
            com.baidu.tbadk.core.util.x.b(arrayList, postData2);
            com.baidu.tbadk.core.util.x.b(arrayList, postData);
            this.euV.setDatas(arrayList);
            this.euV.notifyDataSetChanged();
            this.IK.smoothScrollToPosition(this.evv + 2);
            this.IK.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.IK.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.IK.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.egn;
    }

    public void awO() {
        if (this.evk != null) {
            com.baidu.adp.lib.g.j.a(this.evk, this.euW.getPageContext().getPageActivity());
        }
        if (this.esa != null) {
            this.esa.dismiss();
        }
        if (this.erI != null) {
            this.erI.dismiss();
        }
        if (this.erG != null) {
            com.baidu.adp.lib.g.j.b(this.erG, this.euW.getPageContext());
        }
        if (this.bqO != null) {
            this.bqO.setVisibility(8);
        }
        if (this.ekR != null) {
            this.ekR.dismiss();
        }
    }

    public void aOo() {
        this.IK.setNextPage(this.evj);
        this.evj.wH();
    }

    public void ib(boolean z) {
        this.cBC = z;
    }

    public void setIsFromPb(boolean z) {
        this.euO = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (jVar != null) {
            if (this.euO && this.euU != null) {
                this.euV.jb(true);
                this.euU.setVisibility(8);
                this.IK.removeHeaderView(this.euU);
                this.evu = 1;
            }
            this.etQ = jVar;
            this.euV.h(this.etQ.JN());
            if (this.euU != null) {
                this.euU.setVisibility(0);
            }
            if (this.euX != null) {
                this.euX.setVisibility(0);
            }
            if (jVar.aJO() != null) {
                this.evp = jVar.aJO().getId();
                this.aMn = jVar.aJO().bhD();
                if (this.aMn > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.euW.getPageContext().getString(w.l.which_floor_reply), Integer.valueOf(this.aMn)));
                    this.evs.setText(String.format(this.euW.getPageContext().getString(w.l.reply_some_floor), Integer.valueOf(this.aMn)));
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.euW.aOh()) {
                    str = "PB";
                }
                if (jVar.aJO().sl() != null) {
                    this.evi.a(this.euW.getPageContext(), jVar.aJO().sl(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", jVar.aJU().getId(), jVar.aJU().getName(), jVar.JN().getId(), str));
                } else {
                    this.evi.a(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.evj.wH();
                this.euV.setHasMoreData(true);
            } else {
                this.evj.wI();
                this.euV.setHasMoreData(false);
            }
            this.evq = jVar.aJS();
            if (com.baidu.tbadk.core.util.x.q(this.evq)) {
                this.IK.setNextPage(null);
                if (this.euO) {
                    this.euY.setVisibility(0);
                }
            } else {
                this.IK.setNextPage(this.evj);
                if (this.euO) {
                    this.euY.setVisibility(8);
                }
            }
            if (this.evq == null || this.evq.size() <= euT) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.evq.size() - euT;
                oz(size);
                int firstVisiblePosition = this.IK.getFirstVisiblePosition() - size;
                View childAt = this.IK.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.euV.setDatas(this.evq);
            boolean z2 = false;
            if (jVar.JN() != null && jVar.JN().getAuthor() != null && (userId = jVar.JN().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.euV.B(i, z2);
            this.euV.notifyDataSetChanged();
            a(jVar.aJO(), jVar.asY(), jVar.nH(), i, z);
            if (i4 > 0) {
                this.IK.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void oz(int i) {
        if (this.evq != null) {
            if (this.evq.size() <= i) {
                this.evq.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.evq.iterator();
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

    public boolean aOp() {
        return this.euV.bAW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.euO) {
            this.eio = postData;
            if (!StringUtils.isNull(postData.bhJ())) {
                this.evg.setVisibility(0);
                this.evg.c(postData.bhJ(), 10, true);
            } else {
                this.evg.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bhL = postData.bhL();
            if (bhL != null && bhL.ftO) {
                this.evh.setVisibility(0);
            } else {
                this.evh.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.euU.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.euU.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(w.h.tag_clip_board, postData);
            sparseArray.put(w.h.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.eve.setText((CharSequence) null);
            this.amc.setText((CharSequence) null);
            this.evd.setVisibility(8);
            if (!this.euO) {
                a(postData.getAuthor());
                if (z) {
                    this.evd.setVisibility(0);
                    com.baidu.tbadk.core.util.aq.i((View) this.evd, w.e.cp_link_tip_a);
                }
            }
            this.ejx.setText(com.baidu.tbadk.core.util.au.q(postData.getTime()));
            if (this.cBC) {
                int i2 = w.g.img_default_100;
            } else {
                int i3 = w.g.icon_click;
            }
            this.eve.setText(String.format(this.euW.getPageContext().getString(w.l.is_floor), Integer.valueOf(postData.bhD())));
            postData.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.evf, postData.aws());
            if (StringUtils.isNull(postData.bhJ()) && !a && postData.HX() != null) {
                this.btu.setVisibility(0);
                this.btu.setTag(postData.HX());
                return;
            }
            this.btu.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gk = com.baidu.tbadk.util.u.gk(name_show);
            com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aK(metaData.getSealPrefix()) + 2 : 0) + gk > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.amc.setText(ae(metaData.getSealPrefix(), name_show));
            } else {
                this.amc.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.epb != null) {
                if (metaData.getAlaUserData().anchor_live == 0 && metaData.getAlaUserData().enter_live == 0) {
                    this.epb.setVisibility(8);
                } else {
                    this.epb.setVisibility(0);
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.Qx = metaData.getAlaUserData();
                    bVar.type = 4;
                    this.epb.setTag(bVar);
                }
            }
            this.evt = 0;
            this.evt = metaData.getLevel_id();
            if (this.evt > 0) {
                this.evc.setVisibility(0);
                com.baidu.tbadk.core.util.aq.c(this.evc, BitmapHelper.getSmallGradeResourceIdNew(this.evt));
                this.evc.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(w.l.degree_in_forum), Integer.valueOf(this.evt)));
                this.evc.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.evc.setOnClickListener(null);
            } else {
                this.evc.setVisibility(8);
            }
            if (metaData.isGod()) {
                this.epp.setVisibility(0);
                this.evb.setVisibility(8);
                this.epp.setUserId(metaData.getUserId());
                this.epp.setUserName(metaData.getUserName());
                this.epp.c(metaData.getPortrait(), 28, false);
            } else {
                this.epp.setVisibility(8);
                this.evb.setVisibility(0);
                this.evb.setUserId(metaData.getUserId());
                this.evb.setUserName(metaData.getUserName());
                this.evb.setDefaultResource(w.g.transparent_bg);
                this.evb.setDefaultErrorResource(w.g.icon_default_avatar100);
                this.evb.c(metaData.getPortrait(), 28, false);
            }
            this.eva.setTag(w.h.tag_user_id, metaData.getUserId());
            this.eva.setTag(w.h.tag_user_name, metaData.getUserName());
            this.eva.setTag(w.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.HP() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.HP().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.HW());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.ca(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.blC());
                        continue;
                    case 17:
                        String str = next.Ia().mGifInfo.mSharpText;
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
        if (!tbRichTextData.If()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.HW() == null || tbRichTextData.HW().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.HW());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.euW.getPageContext().getString(w.l.refresh_view_title_text), this.Rg));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.euW.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.euX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, w.g.pic_emotion07, com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds300), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds480), com.baidu.adp.lib.util.k.g(pageActivity, w.f.ds360)), dVar, a);
        }
        this.euX.setVisibility(0);
        this.IK.setVisibility(8);
        this.bqO.setVisibility(8);
        this.dmL.DO();
        com.baidu.tbadk.core.util.aq.k(this.mNoDataView, w.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.euW.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fS(int i) {
        a(NoDataViewFactory.d.E(i, w.l.refresh_view_title_text));
        if (this.euN != null) {
            this.euN.bd(this.egn);
        }
        this.evs.setVisibility(8);
    }

    public void nI(String str) {
        a(NoDataViewFactory.d.ad(str, this.euW.getPageContext().getString(w.l.refresh_view_title_text)));
        if (this.euN != null) {
            this.euN.bd(this.egn);
        }
        this.evs.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.IK.setVisibility(0);
            this.evs.setVisibility(0);
            this.egn.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.Rg = onClickListener;
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
            if (this.etQ != null && this.etQ.JN() != null && this.etQ.JN().getAuthor() != null && postData.getAuthor() != null) {
                String userId3 = this.etQ.JN().getAuthor().getUserId();
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
                    int i2 = postData.bhD() != 1 ? 0 : 1;
                    if (ez.g(postData)) {
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
                        if (this.etQ.JN() != null) {
                            sparseArray.put(w.h.tag_user_mute_thread_id, this.etQ.JN().getId());
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
            if (postData.bhD() != 1) {
            }
            if (ez.g(postData)) {
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

    public void iZ(boolean z) {
        if (this.ekR != null && this.ekR.aLW() != null) {
            if (z) {
                this.ekR.aLW().setText(w.l.remove_mark);
            } else {
                this.ekR.aLW().setText(w.l.mark);
            }
            this.ekR.wk();
        }
    }

    public View aOq() {
        return this.evm;
    }

    public void onChangeSkinType(int i) {
        this.euW.getLayoutMode().ah(i == 1);
        this.euW.getLayoutMode().t(this.egn);
        this.euW.getLayoutMode().t(this.euU);
        this.mNavigationBar.onChangeSkinType(this.euW.getPageContext(), i);
        if (this.euZ != null) {
            com.baidu.tbadk.core.util.aq.i((View) this.euZ, w.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.aq.i((View) this.euY, w.e.cp_cont_d);
        this.bKx.onChangeSkinType(this.euW.getPageContext(), i);
        this.euW.getLayoutMode().t(this.evm);
        com.baidu.tbadk.core.util.aq.i((View) this.evf, w.e.cp_cont_b);
        this.evf.setLinkTextColor(com.baidu.tbadk.core.util.aq.getColor(w.e.cp_link_tip_c));
        if (this.dmL != null && this.dmL.CP() != null) {
            this.dmL.CP().onChangeSkinType(i);
        }
        this.evj.dh(i);
        this.btu.ayg();
        com.baidu.tbadk.core.util.aq.i((View) this.evs, w.e.cp_cont_d);
        com.baidu.tbadk.core.util.aq.j(this.evs, w.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.aq.i((View) this.evd, w.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.aq.i((View) this.amc, w.e.cp_cont_c);
        if (this.evt > 0) {
            com.baidu.tbadk.core.util.aq.c(this.evc, BitmapHelper.getSmallGradeResourceIdNew(this.evt));
        }
        this.evs.setAlpha(0.95f);
        if (this.euV != null) {
            this.euV.notifyDataSetChanged();
        }
    }

    public void aOr() {
        this.bqO.setVisibility(0);
    }

    public void aOs() {
        this.IK.setVisibility(0);
        this.bqO.setVisibility(8);
        this.evj.wI();
    }

    public void XI() {
        this.IK.setVisibility(0);
        this.bqO.setVisibility(8);
        this.evj.XI();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bGM = onLongClickListener;
        this.euU.setOnLongClickListener(this.bGM);
    }

    public View aOt() {
        return this.euU;
    }

    public TextView aOu() {
        return this.evs;
    }

    public void nJ(String str) {
        int nK = this.euV.nK(str);
        if (nK > -1) {
            this.euV.oA(nK);
            if (nK > 2) {
                this.IK.setSelection(nK - 2);
            } else {
                this.IK.setSelection(nK);
            }
            this.IK.invalidate();
        }
    }

    public View aOv() {
        return this.euZ;
    }

    public View aOw() {
        return this.evg;
    }

    public MorePopupWindow aOx() {
        return this.evk;
    }

    public void auC() {
        if (this.esm == null) {
            this.esm = new com.baidu.tbadk.core.view.a(this.euW.getPageContext());
        }
        this.esm.aI(true);
    }

    public void aIn() {
        if (this.esm != null) {
            this.esm.aI(false);
        }
    }

    public TextView aOy() {
        return this.evf;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.euD = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.euE = eVar;
    }

    public dr aOz() {
        return this.ekR;
    }

    public void abg() {
    }

    public void abh() {
    }

    public void onActivityDestroy() {
    }

    public void aOA() {
        if (this.euW.aOg()) {
        }
    }

    public View aOB() {
        return this.eva;
    }

    private SpannableStringBuilder ae(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, w.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.euW.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
