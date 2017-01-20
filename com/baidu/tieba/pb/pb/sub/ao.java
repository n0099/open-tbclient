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
import com.baidu.tieba.pb.pb.main.dq;
import com.baidu.tieba.pb.pb.main.ew;
import com.baidu.tieba.pb.pb.main.ey;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class ao {
    private static final int erF = TbadkCoreApplication.m9getInst().getListItemRule().xG();
    private BdListView Bw;
    private View bCq;
    private NoNetworkView bDq;
    private ProgressBar bkd;
    private View.OnClickListener cpK;
    private RelativeLayout edS;
    private dq eia;
    private View eme;
    private com.baidu.tbadk.core.view.a epi;
    private com.baidu.tieba.pb.data.j eqJ;
    private View erG;
    private ba erH;
    private NewSubPbActivity erI;
    private RelativeLayout erJ;
    private TextView erK;
    private ThreadSkinView erU;
    private bb erV;
    private View erY;
    private SubPbModel erl;
    private b erz;
    private ArrayList<com.baidu.tieba.tbadkCore.data.p> esc;
    private String esd;
    private TextView ese;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private TbRichTextView.e erq = null;
    private View.OnClickListener Md = null;
    private TbRichTextView.f erp = null;
    private NavigationBar mNavigationBar = null;
    private View aiC = null;
    private TextView erL = null;
    private LinearLayout erM = null;
    private HeadImageView erN = null;
    private ClickableHeaderImageView emp = null;
    private TextView agJ = null;
    private ImageView erO = null;
    private TextView erP = null;
    private TextView erQ = null;
    private TextView egF = null;
    private EllipsizeRichTextView erR = null;
    private TbImageView erS = null;
    private PlayVoiceBntNew bmz = null;
    private TextView erT = null;
    private MorePopupWindow erW = null;
    private ew erX = null;
    private com.baidu.tbadk.core.dialog.c eoW = null;
    private Dialog eoD = null;
    private com.baidu.tbadk.core.dialog.a eoF = null;
    private boolean cAg = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bzG = null;
    private NewSubPbActivity.a erZ = null;
    private NewSubPbActivity.a esa = null;
    private ArrayList<IconData> egl = null;
    private ArrayList<IconData> cUY = null;
    private com.baidu.tbadk.editortools.pb.n dkr = null;
    private String esb = null;
    private int aGQ = 0;
    private com.baidu.tieba.tbadkCore.data.p efS = null;
    private int esf = 0;
    private int esg = 2;
    private int esh = 0;
    private boolean erA = true;
    protected HashMap<Long, HashSet<String>> esi = new HashMap<>();
    protected final b.a esj = new ap(this);
    private View.OnClickListener egm = new at(this);
    private com.baidu.tieba.pb.a.d egn = new com.baidu.tieba.pb.a.d(new au(this));
    protected AdapterView.OnItemClickListener esk = new av(this);
    protected AdapterView.OnItemLongClickListener mOnItemLongClickListener = new aw(this);

    public ao(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.edS = null;
        this.erG = null;
        this.Bw = null;
        this.erH = null;
        this.erI = null;
        this.bDq = null;
        this.erJ = null;
        this.erK = null;
        this.eme = null;
        this.erV = null;
        this.erY = null;
        this.cpK = null;
        this.bkd = null;
        this.ese = null;
        this.erI = newSubPbActivity;
        this.cpK = onClickListener;
        this.edS = (RelativeLayout) LayoutInflater.from(this.erI.getPageContext().getPageActivity()).inflate(r.j.new_sub_pb_layout, (ViewGroup) null);
        this.erG = LayoutInflater.from(this.erI.getPageContext().getPageActivity()).inflate(r.j.new_sub_pb_head, (ViewGroup) null);
        this.erK = (TextView) this.edS.findViewById(r.h.no_reply_list_view);
        this.ese = (TextView) this.edS.findViewById(r.h.subpb_editor_tool_reply_text);
        this.ese.setOnClickListener(this.cpK);
        this.bDq = (NoNetworkView) this.edS.findViewById(r.h.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.I(this.erI.getBaseContext()) - TbadkCoreApplication.m9getInst().getResources().getDimensionPixelSize(r.f.ds60);
        aOT();
        Vw();
        this.erJ = (RelativeLayout) this.edS.findViewById(r.h.sub_pb_body_layout);
        this.Bw = (BdListView) this.edS.findViewById(r.h.new_sub_pb_list);
        this.erU = (ThreadSkinView) LayoutInflater.from(this.erI.getPageContext().getPageActivity()).inflate(r.j.thread_skin_layout, (ViewGroup) null);
        this.Bw.addHeaderView(this.erU);
        this.Bw.addHeaderView(this.erG);
        this.bCq = BdListViewHelper.a(this.erI.getActivity(), this.Bw, BdListViewHelper.HeadType.DEFAULT);
        this.erH = new ba(this.erI.getPageContext().getPageActivity());
        this.erH.J(this.egm);
        this.erH.setIsFromCDN(this.mIsFromCDN);
        this.erH.je(true);
        this.Bw.setAdapter((ListAdapter) this.erH);
        this.erV = new bb(this.erI.getPageContext());
        this.erY = this.erV.getView();
        this.Bw.setNextPage(this.erV);
        this.erV.setOnClickListener(this.cpK);
        this.Bw.setOnItemClickListener(this.esk);
        this.Bw.setOnTouchListener(this.egn);
        this.bkd = (ProgressBar) this.edS.findViewById(r.h.progress);
        onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (this.erG != null) {
            this.erG.setVisibility(4);
        }
        if (this.erJ != null) {
            this.erJ.setVisibility(4);
        }
        this.eme = com.baidu.tbadk.ala.c.np().f(this.erI.getActivity(), 4);
        if (this.eme != null) {
            this.eme.setVisibility(8);
            this.erM.addView(this.eme, 3);
        }
    }

    public ListView getListView() {
        return this.Bw;
    }

    public void Vw() {
        this.erM = (LinearLayout) this.erG.findViewById(r.h.subpb_head_user_info_root);
        this.erM.setOnClickListener(this.cpK);
        this.erN = (HeadImageView) this.erG.findViewById(r.h.photo);
        this.erN.setRadius(com.baidu.adp.lib.util.k.e(this.erI.getActivity(), r.f.ds30));
        this.emp = (ClickableHeaderImageView) this.erG.findViewById(r.h.god_user_photo);
        this.emp.setGodIconMargin(0);
        this.emp.setGodIconWidth(r.f.ds24);
        this.emp.setRadius(com.baidu.adp.lib.util.k.e(this.erI.getActivity(), r.f.ds30));
        this.agJ = (TextView) this.erG.findViewById(r.h.user_name);
        this.erO = (ImageView) this.erG.findViewById(r.h.user_rank);
        this.erP = (TextView) this.erG.findViewById(r.h.floor_owner);
        this.erL = (TextView) this.erG.findViewById(r.h.see_subject);
        this.erL.setOnClickListener(this.cpK);
        this.erQ = (TextView) this.erG.findViewById(r.h.floor);
        this.egF = (TextView) this.erG.findViewById(r.h.time);
        this.erR = (EllipsizeRichTextView) this.erG.findViewById(r.h.content_text);
        this.erR.setOnClickListener(this.cpK);
        com.baidu.tbadk.core.util.ap.i((View) this.erR, r.e.cp_cont_b);
        this.erR.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
        this.erR.setLineSpacing(0.0f, 1.25f);
        this.erS = (TbImageView) this.erG.findViewById(r.h.sub_pb_image);
        this.erS.setOnClickListener(this.cpK);
        this.erT = (TextView) this.erG.findViewById(r.h.advert);
        this.bmz = (PlayVoiceBntNew) this.erG.findViewById(r.h.voice_btn);
        this.erG.setOnTouchListener(this.egn);
        this.erG.setOnClickListener(this.cpK);
    }

    public void jc(boolean z) {
        if (this.bCq != null && this.bCq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.bCq.getLayoutParams();
            if (z) {
                aOR();
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.erI.getPageContext().getPageActivity(), r.f.ds98);
            } else {
                layoutParams.height = com.baidu.adp.lib.util.k.e(this.erI.getPageContext().getPageActivity(), r.f.ds98) + UtilHelper.getLightStatusBarHeight();
            }
            this.bCq.setLayoutParams(layoutParams);
        }
    }

    private void aOR() {
        this.mNavigationBar.setmBackImageViewBg(r.g.subpb_navigationbar_close, r.g.subpb_navigationbar_close);
    }

    public View aOS() {
        return this.bCq;
    }

    public void aOT() {
        this.mNavigationBar = (NavigationBar) this.edS.findViewById(r.h.view_navigation_bar);
        this.aiC = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.aiC.getLayoutParams();
            int e = com.baidu.adp.lib.util.k.e(this.erI.getPageContext().getPageActivity(), r.f.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.aiC != null && (this.aiC.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.aiC.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.aiC.setPadding(com.baidu.adp.lib.util.k.e(this.erI.getPageContext().getPageActivity(), r.f.ds32), this.aiC.getPaddingTop(), this.aiC.getPaddingRight(), this.aiC.getPaddingBottom());
            this.aiC.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.setmBackImageViewBg(r.g.subpb_navigationbar_back, r.g.subpb_navigationbar_back);
    }

    public NavigationBar Jo() {
        return this.mNavigationBar;
    }

    public void bd(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.eoD == null) {
            this.eoD = new Dialog(this.erI.getPageContext().getPageActivity(), r.m.common_alert_dialog);
            this.eoD.setCanceledOnTouchOutside(true);
            this.eoD.setCancelable(true);
            View inflate = LayoutInflater.from(this.erI.getPageContext().getPageActivity()).inflate(r.j.forum_manage_dialog, (ViewGroup) null);
            this.erI.getLayoutMode().v(inflate);
            this.eoD.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.eoD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.I(this.erI.getPageContext().getPageActivity()) * 0.9d);
            this.eoD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.eoD.findViewById(r.h.del_post_btn);
        TextView textView2 = (TextView) this.eoD.findViewById(r.h.forbid_user_btn);
        TextView textView3 = (TextView) this.eoD.findViewById(r.h.disable_reply_btn);
        if ("".equals(sparseArray.get(r.h.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(r.h.tag_del_post_id, sparseArray.get(r.h.tag_del_post_id));
            sparseArray2.put(r.h.tag_del_post_type, sparseArray.get(r.h.tag_del_post_type));
            sparseArray2.put(r.h.tag_del_post_is_self, sparseArray.get(r.h.tag_del_post_is_self));
            sparseArray2.put(r.h.tag_manage_user_identity, sparseArray.get(r.h.tag_manage_user_identity));
            textView.setOnClickListener(new ax(this));
        }
        if ("".equals(sparseArray.get(r.h.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(r.h.tag_forbid_user_name, sparseArray.get(r.h.tag_forbid_user_name));
            sparseArray3.put(r.h.tag_manage_user_identity, sparseArray.get(r.h.tag_manage_user_identity));
            sparseArray3.put(r.h.tag_forbid_user_post_id, sparseArray.get(r.h.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ay(this));
        }
        if (!((sparseArray.get(r.h.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(r.h.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(r.l.un_mute);
            } else {
                textView3.setText(r.l.mute);
            }
            sparseArray4.put(r.h.tag_is_mem, sparseArray.get(r.h.tag_is_mem));
            sparseArray4.put(r.h.tag_user_mute_mute_userid, sparseArray.get(r.h.tag_user_mute_mute_userid));
            sparseArray4.put(r.h.tag_user_mute_mute_username, sparseArray.get(r.h.tag_user_mute_mute_username));
            sparseArray4.put(r.h.tag_user_mute_post_id, sparseArray.get(r.h.tag_user_mute_post_id));
            sparseArray4.put(r.h.tag_user_mute_thread_id, sparseArray.get(r.h.tag_user_mute_thread_id));
            textView3.setOnClickListener(new az(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.eoD, this.erI.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.h.tag_del_post_id, str);
        sparseArray.put(r.h.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(r.h.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = r.l.del_post_confirm;
        if (i == 0) {
            i3 = r.l.del_thread_confirm;
        }
        this.eoF = new com.baidu.tbadk.core.dialog.a(this.erI.getPageContext().getPageActivity());
        this.eoF.ca(i3);
        this.eoF.A(sparseArray);
        this.eoF.a(r.l.dialog_ok, new aq(this, sparseArray));
        this.eoF.b(r.l.dialog_cancel, new ar(this));
        this.eoF.au(true);
        this.eoF.b(this.erI.getPageContext());
        this.eoF.sV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iO(boolean z) {
        if (this.Bw != null) {
            if (!z) {
                this.Bw.setEnabled(z);
            } else {
                this.Bw.postDelayed(new as(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.eoW != null) {
            this.eoW.dismiss();
            this.eoW = null;
        }
        if (z) {
            string = this.erI.getResources().getString(r.l.remove_mark);
        } else {
            string = this.erI.getResources().getString(r.l.mark);
        }
        this.eoW = new com.baidu.tbadk.core.dialog.c(this.erI.getPageContext().getPageActivity());
        this.eoW.cd(r.l.operation);
        this.eoW.a(new String[]{this.erI.getResources().getString(r.l.copy), string}, bVar);
        this.eoW.d(this.erI.getPageContext());
        this.eoW.sY();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.erZ = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.esa = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.bkd != null) {
            this.bkd.setVisibility(8);
        }
        if (z && z2) {
            this.erI.showToast(this.erI.getResources().getString(r.l.delete_success));
        } else if (str != null && z2) {
            this.erI.showToast(str);
        }
    }

    public void bc(View view) {
        if (this.bCq != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bCq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.Bw != null) {
                    this.Bw.removeHeaderView(this.bCq);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bCq.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.e(this.erI.getActivity(), r.f.ds98)));
            } else if (this.Bw != null) {
                this.Bw.addHeaderView(this.bCq, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void f(com.baidu.tbadk.editortools.pb.n nVar) {
        if (nVar != null && nVar.Cw() != null) {
            this.dkr = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.edS.addView(nVar.Cw(), layoutParams);
        }
    }

    public void e(b bVar) {
        this.erz = bVar;
    }

    public void aOU() {
        if (this.Bw != null) {
            this.esh = this.Bw.getLastVisiblePosition();
        }
    }

    public void aOV() {
        if (this.erl != null) {
            if ((!aOY() && this.erY != null && this.erY.isShown()) || com.baidu.tbadk.core.util.w.s(this.esc)) {
                this.erl.jg(false);
            } else {
                this.erl.jg(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.erl = subPbModel;
    }

    public void aOW() {
        a(this.erI);
        this.Bw.setNextPage(this.erV);
    }

    public void j(com.baidu.tieba.tbadkCore.data.p pVar) {
        int i;
        if (pVar != null) {
            pVar.li(true);
            com.baidu.tieba.tbadkCore.data.p pVar2 = new com.baidu.tieba.tbadkCore.data.p();
            pVar2.setPostType(52);
            if (!aOY() && this.erY != null && this.erY.isShown()) {
                i = (this.esh - this.esg) - 1;
            } else {
                i = this.esh - this.esg;
            }
            int r = com.baidu.tbadk.core.util.w.r(this.esc);
            if (i > r) {
                i = r;
            }
            ArrayList<com.baidu.tieba.tbadkCore.data.p> arrayList = new ArrayList<>(com.baidu.tbadk.core.util.w.a(this.esc, 0, i));
            com.baidu.tbadk.core.util.w.b(arrayList, pVar2);
            com.baidu.tbadk.core.util.w.b(arrayList, pVar);
            this.erH.setDatas(arrayList);
            this.erH.notifyDataSetChanged();
            this.Bw.smoothScrollToPosition(this.esh + 2);
            this.Bw.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Bw.setOnScrollListener(onScrollListener);
    }

    public void a(BdListView.e eVar) {
        this.Bw.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.edS;
    }

    public void axs() {
        if (this.erW != null) {
            com.baidu.adp.lib.g.j.a(this.erW, this.erI.getPageContext().getPageActivity());
        }
        if (this.eoW != null) {
            this.eoW.dismiss();
        }
        if (this.eoF != null) {
            this.eoF.dismiss();
        }
        if (this.eoD != null) {
            com.baidu.adp.lib.g.j.b(this.eoD, this.erI.getPageContext());
        }
        if (this.bkd != null) {
            this.bkd.setVisibility(8);
        }
        if (this.eia != null) {
            this.eia.dismiss();
        }
    }

    public void aOX() {
        this.Bw.setNextPage(this.erV);
        this.erV.wk();
    }

    public void ii(boolean z) {
        this.cAg = z;
    }

    public void setIsFromPb(boolean z) {
        this.erA = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v47, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.baidu.tieba.pb.data.j jVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        if (jVar != null) {
            if (this.erA && this.erG != null) {
                this.erH.jf(true);
                this.erG.setVisibility(8);
                this.Bw.removeHeaderView(this.erG);
                this.esg = 1;
            }
            this.eqJ = jVar;
            this.erH.h(this.eqJ.Ji());
            if (this.erG != null) {
                this.erG.setVisibility(0);
            }
            if (this.erJ != null) {
                this.erJ.setVisibility(0);
            }
            if (jVar.aKw() != null) {
                this.esb = jVar.aKw().getId();
                this.aGQ = jVar.aKw().bhQ();
                if (this.aGQ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.erI.getPageContext().getString(r.l.which_floor_reply), Integer.valueOf(this.aGQ)));
                    this.ese.setText(String.format(this.erI.getPageContext().getString(r.l.reply_some_floor), Integer.valueOf(this.aGQ)));
                } else {
                    this.mNavigationBar.setCenterTextTitle(null);
                }
                String str = null;
                if (this.erI.aOQ()) {
                    str = "PB";
                }
                if (jVar.aKw().rR() != null) {
                    this.erU.a(this.erI.getPageContext(), jVar.aKw().rR(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", jVar.aKC().getId(), jVar.aKC().getName(), jVar.Ji().getId(), str));
                } else {
                    this.erU.a(null, null, null);
                }
            }
            if (jVar.hasMore()) {
                this.erV.wk();
                this.erH.setHasMoreData(true);
            } else {
                this.erV.wl();
                this.erH.setHasMoreData(false);
            }
            this.esc = jVar.aKA();
            if (com.baidu.tbadk.core.util.w.s(this.esc)) {
                this.Bw.setNextPage(null);
                if (this.erA) {
                    this.erK.setVisibility(0);
                }
            } else {
                this.Bw.setNextPage(this.erV);
                if (this.erA) {
                    this.erK.setVisibility(8);
                }
            }
            if (this.esc == null || this.esc.size() <= erF) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.esc.size() - erF;
                oJ(size);
                int firstVisiblePosition = this.Bw.getFirstVisiblePosition() - size;
                View childAt = this.Bw.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.erH.setDatas(this.esc);
            boolean z2 = false;
            if (jVar.Ji() != null && jVar.Ji().getAuthor() != null && (userId = jVar.Ji().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.erH.B(i, z2);
            this.erH.notifyDataSetChanged();
            a(jVar.aKw(), jVar.atD(), jVar.nt(), i, z);
            if (i4 > 0) {
                this.Bw.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void oJ(int i) {
        if (this.esc != null) {
            if (this.esc.size() <= i) {
                this.esc.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.p> it = this.esc.iterator();
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

    public boolean aOY() {
        return this.erH.btO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.baidu.tieba.tbadkCore.data.p pVar, boolean z, boolean z2, int i, boolean z3) {
        if (pVar != null && !this.erA) {
            this.efS = pVar;
            if (!StringUtils.isNull(pVar.bhW())) {
                this.erS.setVisibility(0);
                this.erS.c(pVar.bhW(), 10, true);
            } else {
                this.erS.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.h bhY = pVar.bhY();
            if (bhY != null && bhY.fpt) {
                this.erT.setVisibility(0);
            } else {
                this.erT.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.erG.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.erG.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(r.h.tag_clip_board, pVar);
            sparseArray.put(r.h.tag_is_subpb, false);
            a(pVar, i, sparseArray);
            this.erQ.setText((CharSequence) null);
            this.agJ.setText((CharSequence) null);
            this.erP.setVisibility(8);
            if (!this.erA) {
                a(pVar.getAuthor());
                if (z) {
                    this.erP.setVisibility(0);
                    com.baidu.tbadk.core.util.ap.i((View) this.erP, r.e.cp_link_tip_a);
                }
            }
            this.egF.setText(com.baidu.tbadk.core.util.at.r(pVar.getTime()));
            if (this.cAg) {
                int i2 = r.g.img_default_100;
            } else {
                int i3 = r.g.icon_click;
            }
            this.erQ.setText(String.format(this.erI.getPageContext().getString(r.l.is_floor), Integer.valueOf(pVar.bhQ())));
            pVar.getAuthor().getUserTbVipInfoData();
            boolean a = a(this.erR, pVar.awW());
            if (StringUtils.isNull(pVar.bhW()) && !a && pVar.Hx() != null) {
                this.bmz.setVisibility(0);
                this.bmz.setTag(pVar.Hx());
                return;
            }
            this.bmz.setVisibility(8);
        }
    }

    private void a(MetaData metaData) {
        if (metaData != null) {
            String name_show = metaData.getName_show();
            int gv = com.baidu.tbadk.util.u.gv(name_show);
            com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_c);
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? com.baidu.adp.lib.util.j.aQ(metaData.getSealPrefix()) + 2 : 0) + gv > 14) {
                name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.agJ.setText(ag(metaData.getSealPrefix(), name_show));
            } else {
                this.agJ.setText(name_show);
            }
            if (metaData.getAlaUserData() != null && this.eme != null) {
                if (metaData.getAlaUserData().anchor_live == 0 && metaData.getAlaUserData().enter_live == 0) {
                    this.eme.setVisibility(8);
                } else {
                    this.eme.setVisibility(0);
                    com.baidu.tbadk.ala.b bVar = new com.baidu.tbadk.ala.b();
                    bVar.Lv = metaData.getAlaUserData();
                    bVar.type = 4;
                    this.eme.setTag(bVar);
                }
            }
            this.esf = 0;
            this.esf = metaData.getLevel_id();
            if (this.esf > 0) {
                this.erO.setVisibility(0);
                com.baidu.tbadk.core.util.ap.c(this.erO, BitmapHelper.getSmallGradeResourceIdNew(this.esf));
                this.erO.setContentDescription(String.format(TbadkCoreApplication.m9getInst().getString(r.l.degree_in_forum), Integer.valueOf(this.esf)));
                this.erO.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.erO.setOnClickListener(null);
            } else {
                this.erO.setVisibility(8);
            }
            if (metaData.isGod()) {
                this.emp.setVisibility(0);
                this.erN.setVisibility(8);
                this.emp.setUserId(metaData.getUserId());
                this.emp.setUserName(metaData.getUserName());
                this.emp.c(metaData.getPortrait(), 28, false);
            } else {
                this.emp.setVisibility(8);
                this.erN.setVisibility(0);
                this.erN.setUserId(metaData.getUserId());
                this.erN.setUserName(metaData.getUserName());
                this.erN.setDefaultResource(r.g.transparent_bg);
                this.erN.setDefaultErrorResource(r.g.icon_default_avatar100);
                this.erN.c(metaData.getPortrait(), 28, false);
            }
            this.erM.setTag(r.h.tag_user_id, metaData.getUserId());
            this.erM.setTag(r.h.tag_user_name, metaData.getUserName());
            this.erM.setTag(r.h.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.Hq() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.Hq().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.append(next.Hw());
                        continue;
                    case 17:
                        String str = next.HA().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.append("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                    case 18:
                        tbRichTextData.cb(true);
                        textView.setMovementMethod(com.baidu.tieba.view.g.blN());
                        continue;
                }
            }
        }
        if (!tbRichTextData.HF()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.Hw() == null || tbRichTextData.Hw().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.Hw());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.erI.getPageContext().getString(r.l.refresh_view_title_text), this.Md));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.erI.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.erJ, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, r.g.pic_emotion07, com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds300), com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds480), com.baidu.adp.lib.util.k.e(pageActivity, r.f.ds360)), dVar, a);
        }
        this.erJ.setVisibility(0);
        this.Bw.setVisibility(8);
        this.bkd.setVisibility(8);
        this.dkr.Dv();
        com.baidu.tbadk.core.util.ap.k(this.mNoDataView, r.e.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.erI.getPageContext(), TbadkCoreApplication.m9getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fX(int i) {
        a(NoDataViewFactory.d.y(i, r.l.refresh_view_title_text));
        if (this.erz != null) {
            this.erz.be(this.edS);
        }
        this.ese.setVisibility(8);
    }

    public void oA(String str) {
        a(NoDataViewFactory.d.af(str, this.erI.getPageContext().getString(r.l.refresh_view_title_text)));
        if (this.erz != null) {
            this.erz.be(this.edS);
        }
        this.ese.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Bw.setVisibility(0);
            this.ese.setVisibility(0);
            this.edS.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.Md = onClickListener;
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
    public void a(com.baidu.tieba.tbadkCore.data.p pVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (pVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = pVar.getAuthor().getUserId();
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
            if (this.eqJ != null && this.eqJ.Ji() != null && this.eqJ.Ji().getAuthor() != null && pVar.getAuthor() != null) {
                String userId3 = this.eqJ.Ji().getAuthor().getUserId();
                String userId4 = pVar.getAuthor().getUserId();
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
                    userId = pVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = pVar.bhQ() != 1 ? 0 : 1;
                    if (ey.g(pVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.h.tag_forbid_user_name, pVar.getAuthor().getUserName());
                        sparseArray.put(r.h.tag_forbid_user_post_id, pVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(r.h.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.h.tag_del_post_is_self, true);
                        sparseArray.put(r.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(r.h.tag_del_post_id, pVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(r.h.tag_del_post_is_self, false);
                        sparseArray.put(r.h.tag_del_post_type, 0);
                        sparseArray.put(r.h.tag_del_post_id, "");
                    }
                    sparseArray.put(r.h.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(r.h.tag_forbid_user_post_id, pVar.getId());
                    if (!z6) {
                        sparseArray.put(r.h.tag_should_manage_visible, true);
                        sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.h.tag_forbid_user_name, pVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(r.h.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(r.h.tag_user_mute_visible, true);
                        sparseArray.put(r.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (pVar.getAuthor() != null) {
                            sparseArray.put(r.h.tag_user_mute_mute_userid, pVar.getAuthor().getUserId());
                            sparseArray.put(r.h.tag_user_mute_mute_username, pVar.getAuthor().getUserName());
                        }
                        if (this.eqJ.Ji() != null) {
                            sparseArray.put(r.h.tag_user_mute_thread_id, this.eqJ.Ji().getId());
                        }
                        sparseArray.put(r.h.tag_user_mute_post_id, pVar.getId());
                    } else {
                        sparseArray.put(r.h.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(r.h.tag_should_delete_visible, true);
                        sparseArray.put(r.h.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(r.h.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(r.h.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(r.h.tag_del_post_id, pVar.getId());
                        return;
                    }
                    sparseArray.put(r.h.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = pVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (pVar.bhQ() != 1) {
            }
            if (ey.g(pVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(r.h.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(r.h.tag_forbid_user_post_id, pVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void jd(boolean z) {
        if (this.eia != null && this.eia.aMz() != null) {
            if (z) {
                this.eia.aMz().setText(r.l.remove_mark);
            } else {
                this.eia.aMz().setText(r.l.mark);
            }
            this.eia.vN();
        }
    }

    public View aOZ() {
        return this.erY;
    }

    public void onChangeSkinType(int i) {
        this.erI.getLayoutMode().ai(i == 1);
        this.erI.getLayoutMode().v(this.edS);
        this.erI.getLayoutMode().v(this.erG);
        this.mNavigationBar.onChangeSkinType(this.erI.getPageContext(), i);
        if (this.erL != null) {
            com.baidu.tbadk.core.util.ap.i((View) this.erL, r.e.goto_see_subject_color);
        }
        com.baidu.tbadk.core.util.ap.i((View) this.erK, r.e.cp_cont_d);
        this.bDq.onChangeSkinType(this.erI.getPageContext(), i);
        this.erI.getLayoutMode().v(this.erY);
        com.baidu.tbadk.core.util.ap.i((View) this.erR, r.e.cp_cont_b);
        this.erR.setLinkTextColor(com.baidu.tbadk.core.util.ap.getColor(r.e.cp_link_tip_c));
        if (this.dkr != null && this.dkr.Cw() != null) {
            this.dkr.Cw().onChangeSkinType(i);
        }
        this.erV.dl(i);
        this.bmz.ayK();
        com.baidu.tbadk.core.util.ap.i((View) this.ese, r.e.cp_cont_d);
        com.baidu.tbadk.core.util.ap.j((View) this.ese, r.g.pb_ecomm_comment_bg);
        com.baidu.tbadk.core.util.ap.i((View) this.erP, r.e.cp_link_tip_a);
        com.baidu.tbadk.core.util.ap.i((View) this.agJ, r.e.cp_cont_c);
        if (this.esf > 0) {
            com.baidu.tbadk.core.util.ap.c(this.erO, BitmapHelper.getSmallGradeResourceIdNew(this.esf));
        }
        this.ese.setAlpha(0.95f);
        if (this.erH != null) {
            this.erH.notifyDataSetChanged();
        }
    }

    public void aPa() {
        this.bkd.setVisibility(0);
    }

    public void aPb() {
        this.Bw.setVisibility(0);
        this.bkd.setVisibility(8);
        this.erV.wl();
    }

    public void WK() {
        this.Bw.setVisibility(0);
        this.bkd.setVisibility(8);
        this.erV.WK();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bzG = onLongClickListener;
        this.erG.setOnLongClickListener(this.bzG);
    }

    public View aPc() {
        return this.erG;
    }

    public TextView aPd() {
        return this.ese;
    }

    public void oB(String str) {
        int oC = this.erH.oC(str);
        if (oC > -1) {
            this.erH.oK(oC);
            if (oC > 2) {
                this.Bw.setSelection(oC - 2);
            } else {
                this.Bw.setSelection(oC);
            }
            this.Bw.invalidate();
        }
    }

    public View aPe() {
        return this.erL;
    }

    public View aPf() {
        return this.erS;
    }

    public MorePopupWindow aPg() {
        return this.erW;
    }

    public void avh() {
        if (this.epi == null) {
            this.epi = new com.baidu.tbadk.core.view.a(this.erI.getPageContext());
        }
        this.epi.aJ(true);
    }

    public void aIO() {
        if (this.epi != null) {
            this.epi.aJ(false);
        }
    }

    public TextView aPh() {
        return this.erR;
    }

    public void setOnLinkImageClickListener(TbRichTextView.f fVar) {
        this.erp = fVar;
    }

    public void setOnImageClickListener(TbRichTextView.e eVar) {
        this.erq = eVar;
    }

    public dq aPi() {
        return this.eia;
    }

    public void aaj() {
    }

    public void aak() {
    }

    public void onActivityDestroy() {
    }

    public void aPj() {
        if (this.erI.aOP()) {
        }
    }

    public View aPk() {
        return this.erM;
    }

    private SpannableStringBuilder ag(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new at.a(str, r.g.pic_smalldot_title));
            return com.baidu.tieba.card.at.a((Context) this.erI.getActivity(), str2, (ArrayList<at.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }
}
