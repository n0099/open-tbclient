package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.FrameLayout;
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
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.es;
import com.baidu.tieba.pb.pb.main.et;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class x {
    private static final int doG = TbadkCoreApplication.m411getInst().getListItemRule().yG();
    private BdListView Je;
    private ProgressBar aQj;
    private NoNetworkView bhl;
    private View.OnClickListener brL;
    private RelativeLayout dbk;
    public RelativeLayout dir;
    public LinearLayout dis;
    public ImageView dit;
    public TextView diu;
    public ImageView div;
    private com.baidu.tbadk.core.view.b dmg;
    private View doH;
    private an doI;
    private NewSubPbActivity doJ;
    private RelativeLayout doK;
    private ImageView doQ;
    private TextView doT;
    private ao doU;
    private View doX;
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> dpb;
    private String dpc;
    private com.baidu.tieba.pb.data.g dpd;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.p mNoDataView = null;
    private TbRichTextView.d doz = null;
    private View.OnClickListener PQ = null;
    private TbRichTextView.e doy = null;
    private NavigationBar mNavigationBar = null;
    private TextView doL = null;
    private TextView WM = null;
    private HeadImageView deT = null;
    private ClickableHeaderImageView doM = null;
    private TextView aPp = null;
    private ImageView deU = null;
    private ImageView deW = null;
    private TextView doN = null;
    private ImageView deZ = null;
    private TextView deY = null;
    private TbRichTextView ddA = null;
    private ImageView dfa = null;
    private TextView doO = null;
    private TextView doP = null;
    private PbNewChudianCommonView doR = null;
    private CoverFlowView<com.baidu.tieba.tbadkCore.data.k> doS = null;
    private MorePopupWindow doV = null;
    private es doW = null;
    private com.baidu.tbadk.core.dialog.c dlQ = null;
    private UserIconBox bvK = null;
    private UserIconBox ahN = null;
    private Dialog dlx = null;
    private com.baidu.tbadk.core.dialog.a dlz = null;
    private boolean ddo = true;
    private boolean ddp = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener bdQ = null;
    private NewSubPbActivity.a doY = null;
    private NewSubPbActivity.a doZ = null;
    private ArrayList<IconData> deI = null;
    private ArrayList<IconData> bjm = null;
    private com.baidu.tbadk.editortools.d.p cye = null;
    private String dpa = null;
    private int aHV = 0;
    private com.baidu.tieba.tbadkCore.data.s dcY = null;
    protected HashMap<Long, HashSet<String>> djP = new HashMap<>();
    protected final b.a daU = new y(this);
    private View.OnClickListener deJ = new af(this);
    private com.baidu.tieba.pb.a.c dds = new com.baidu.tieba.pb.a.c(new ag(this));
    protected AdapterView.OnItemClickListener dpe = new ah(this);
    protected AdapterView.OnItemLongClickListener Iz = new ai(this);

    public x(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.dbk = null;
        this.doH = null;
        this.Je = null;
        this.doI = null;
        this.doJ = null;
        this.bhl = null;
        this.doK = null;
        this.doU = null;
        this.doX = null;
        this.brL = null;
        this.aQj = null;
        this.doJ = newSubPbActivity;
        this.brL = onClickListener;
        this.dbk = (RelativeLayout) LayoutInflater.from(this.doJ.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_layout, (ViewGroup) null);
        this.doH = LayoutInflater.from(this.doJ.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_head, (ViewGroup) null);
        this.bhl = (NoNetworkView) this.dbk.findViewById(t.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.B(this.doJ.getBaseContext()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
        azM();
        OK();
        this.doK = (RelativeLayout) this.dbk.findViewById(t.g.sub_pb_body_layout);
        this.Je = (BdListView) this.dbk.findViewById(t.g.new_sub_pb_list);
        this.Je.addHeaderView(this.doH);
        this.doI = new an(this.doJ.getPageContext().getPageActivity());
        this.doI.N(this.deJ);
        this.doI.setIsFromCDN(this.mIsFromCDN);
        this.Je.setAdapter((ListAdapter) this.doI);
        this.doU = new ao(this.doJ.getPageContext());
        this.doX = this.doU.getView();
        this.Je.setNextPage(this.doU);
        this.doU.setOnClickListener(this.brL);
        this.Je.setOnItemClickListener(this.dpe);
        this.Je.setOnItemLongClickListener(this.Iz);
        this.Je.setOnTouchListener(this.dds);
        this.aQj = (ProgressBar) this.dbk.findViewById(t.g.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.doH != null) {
            this.doH.setVisibility(4);
        }
        if (this.doK != null) {
            this.doK.setVisibility(4);
        }
    }

    public void OK() {
        this.deT = (HeadImageView) this.doH.findViewById(t.g.photo);
        this.deT.setOnClickListener(this.brL);
        this.doM = (ClickableHeaderImageView) this.doH.findViewById(t.g.god_user_photo);
        this.doM.setGodIconMargin(0);
        this.doM.setOnClickListener(this.brL);
        this.aPp = (TextView) this.doH.findViewById(t.g.user_name);
        this.deU = (ImageView) this.doH.findViewById(t.g.user_rank);
        this.deW = (ImageView) this.doH.findViewById(t.g.user_gender);
        this.dfa = (ImageView) this.doH.findViewById(t.g.reply);
        this.doO = (TextView) this.doH.findViewById(t.g.manage_btn);
        this.doN = (TextView) this.doH.findViewById(t.g.floor);
        this.deZ = (ImageView) this.doH.findViewById(t.g.floor_owner);
        this.deY = (TextView) this.doH.findViewById(t.g.time);
        this.bvK = (UserIconBox) this.doH.findViewById(t.g.user_icon_box);
        this.ahN = (UserIconBox) this.doH.findViewById(t.g.user_tshow_icon_box);
        this.ddA = (TbRichTextView) this.doH.findViewById(t.g.richText);
        this.ddA.IY();
        this.ddA.h(this.ddo, true);
        this.ddA.setIsFromCDN(this.mIsFromCDN);
        this.ddA.setImageViewStretch(true);
        this.ddA.setTextSize(TbConfig.getContentSize());
        this.ddA.setVoiceViewRes(t.h.voice_play_btn);
        this.doH.setOnTouchListener(this.dds);
        this.doH.setOnClickListener(this.brL);
        this.doP = (TextView) this.doH.findViewById(t.g.pb_item_tail_content);
        this.doP.setOnClickListener(this.brL);
        this.dir = (RelativeLayout) this.doH.findViewById(t.g.chudian_info_container);
        this.dis = (LinearLayout) this.doH.findViewById(t.g.landmark_container);
        this.dit = (ImageView) this.doH.findViewById(t.g.landmark_icon);
        this.diu = (TextView) this.doH.findViewById(t.g.landmark_content);
        this.div = (ImageView) this.doH.findViewById(t.g.ad_icon);
        this.doQ = (ImageView) this.doH.findViewById(t.g.subpb_newchudian_advertise);
        this.doT = (TextView) this.doH.findViewById(t.g.chudian_pic);
    }

    public void azM() {
        this.mNavigationBar = (NavigationBar) this.dbk.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.WM = this.mNavigationBar.setTitleText("");
        this.doL = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.doJ.getResources().getString(t.j.view_subject), this.brL);
        this.doL.setVisibility(8);
    }

    public void awl() {
        this.doW = new es(this.doJ.getPageContext(), this.brL);
        this.doW.gf(TbadkCoreApplication.isLogin());
        this.doV = new MorePopupWindow(this.doJ.getPageContext().getPageActivity(), this.doW.getView(), this.doJ.getResources().getDrawable(t.f.bg_collect), null);
        this.doV.setTouchInterceptor(new aj(this));
        this.doV.onChangeSkinType(this.doJ, TbadkCoreApplication.m411getInst().getSkinType(), at.getDrawable(t.f.bg_collect));
    }

    public void aN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.dlx == null) {
            this.dlx = new Dialog(this.doJ.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.dlx.setCanceledOnTouchOutside(true);
            this.dlx.setCancelable(true);
            View inflate = LayoutInflater.from(this.doJ.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
            this.doJ.getLayoutMode().x(inflate);
            this.dlx.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.dlx.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.B(this.doJ.getPageContext().getPageActivity()) * 0.9d);
            this.dlx.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.dlx.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.dlx.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.dlx.findViewById(t.g.disable_reply_btn);
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
            textView.setOnClickListener(new ak(this));
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
            textView2.setOnClickListener(new al(this));
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
            sparseArray4.put(t.g.tag_user_mute_msg, sparseArray.get(t.g.tag_user_mute_msg));
            textView3.setOnClickListener(new am(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.dlx, this.doJ.getPageContext());
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
        this.dlz = new com.baidu.tbadk.core.dialog.a(this.doJ.getPageContext().getPageActivity());
        this.dlz.ca(i3);
        this.dlz.x(sparseArray);
        this.dlz.a(t.j.dialog_ok, new z(this, sparseArray));
        this.dlz.b(t.j.dialog_cancel, new aa(this));
        this.dlz.am(true);
        this.dlz.b(this.doJ.getPageContext());
        this.dlz.up();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go(boolean z) {
        if (this.Je != null) {
            if (!z) {
                this.Je.setEnabled(z);
            } else {
                this.Je.postDelayed(new ab(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.dlQ != null) {
            this.dlQ.dismiss();
            this.dlQ = null;
        }
        if (z) {
            string = this.doJ.getResources().getString(t.j.remove_mark);
        } else {
            string = this.doJ.getResources().getString(t.j.mark);
        }
        this.dlQ = new com.baidu.tbadk.core.dialog.c(this.doJ.getPageContext().getPageActivity());
        this.dlQ.cd(t.j.operation);
        this.dlQ.a(new String[]{this.doJ.getResources().getString(t.j.copy), string}, bVar);
        this.dlQ.d(this.doJ.getPageContext());
        this.dlQ.us();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.doY = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.doZ = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.aQj != null) {
            this.aQj.setVisibility(8);
        }
        if (z && z2) {
            this.doJ.showToast(this.doJ.getResources().getString(t.j.success));
        } else if (str != null && z2) {
            this.doJ.showToast(str);
        }
    }

    public void aM(View view) {
        if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
        } else {
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
        }
    }

    public void e(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Dh() != null) {
            this.cye = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.dbk.addView(pVar.Dh(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i, View view) {
        new Handler().postDelayed(new ac(this, view, i), 300L);
    }

    public void fR(boolean z) {
        this.ddp = z;
        this.doI.fR(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Je.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.Je.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.dbk;
    }

    public void bt(String str, String str2) {
        this.dpc = str2;
        new Handler().postDelayed(new ad(this, str2, str), 200L);
    }

    public void amI() {
        if (this.doV != null) {
            com.baidu.adp.lib.h.j.a(this.doV, this.doJ.getPageContext().getPageActivity());
        }
        if (this.dlQ != null) {
            this.dlQ.dismiss();
        }
        if (this.dlz != null) {
            this.dlz.dismiss();
        }
        if (this.dlx != null) {
            com.baidu.adp.lib.h.j.b(this.dlx, this.doJ.getPageContext());
        }
        if (this.aQj != null) {
            this.aQj.setVisibility(8);
        }
    }

    public void azN() {
        this.Je.setNextPage(this.doU);
        this.doU.xu();
    }

    public void fQ(boolean z) {
        this.ddo = z;
    }

    public void a(com.baidu.tieba.pb.data.g gVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z2 = false;
        if (gVar != null) {
            this.dpd = gVar;
            this.doI.h(this.dpd.LC());
            if (this.doH != null) {
                this.doH.setVisibility(0);
            }
            if (this.doK != null) {
                this.doK.setVisibility(0);
            }
            if (gVar.avI() != null) {
                this.dpa = gVar.avI().getId();
                this.aHV = gVar.avI().aTs();
                if (this.aHV > 0) {
                    this.WM.setText(String.format(this.doJ.getPageContext().getString(t.j.is_floor), Integer.valueOf(this.aHV)));
                } else {
                    this.WM.setText((CharSequence) null);
                }
            }
            if (gVar.hasMore()) {
                this.doU.xu();
                this.doI.setHasMoreData(true);
            } else {
                this.doU.xv();
                this.doI.setHasMoreData(false);
            }
            this.dpb = gVar.avM();
            if (this.dpb == null || this.dpb.size() == 0) {
                this.Je.setNextPage(null);
            } else {
                this.Je.setNextPage(this.doU);
            }
            if (this.dpb == null || this.dpb.size() <= doG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.dpb.size() - doG;
                mp(size);
                int firstVisiblePosition = this.Je.getFirstVisiblePosition() - size;
                View childAt = this.Je.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.doI.setDatas(this.dpb);
            if (gVar.LC() != null && gVar.LC().getAuthor() != null && (userId = gVar.LC().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.doI.t(i, z2);
            this.doI.notifyDataSetChanged();
            a(gVar.avI(), gVar.ahG(), gVar.pu(), i, z);
            if (i4 > 0) {
                this.Je.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View azO() {
        return this.dfa;
    }

    private void mp(int i) {
        if (this.dpb != null) {
            if (this.dpb.size() <= i) {
                this.dpb.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = this.dpb.iterator();
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

    public boolean azP() {
        return this.doI.aXX;
    }

    private int l(List<com.baidu.tieba.tbadkCore.data.k> list, int i) {
        int i2;
        if (list == null || list.size() <= 0 || i <= 0) {
            return 0;
        }
        int i3 = 1;
        for (int i4 = 0; i4 != list.size(); i4++) {
            com.baidu.tieba.tbadkCore.data.k kVar = list.get(i4);
            int width = kVar.getWidth();
            int height = kVar.getHeight();
            if (width > 1 && (i2 = (int) ((height * i) / width)) > i3) {
                i3 = i2;
            }
        }
        return i3;
    }

    private void a(com.baidu.tieba.tbadkCore.data.i iVar) {
        if (iVar != null) {
            if (this.doR == null) {
                this.doR = (PbNewChudianCommonView) this.doH.findViewById(t.g.subpb_newchudian_common);
            }
            if (this.doS == null) {
                this.doS = (CoverFlowView) this.doH.findViewById(t.g.subpb_newchudian_coverflowview);
            }
            at.c(this.doQ, t.f.icon_tuiguang);
            this.doQ.setVisibility(0);
            this.doR.a(iVar, this.doJ, this.daU);
            if (!com.baidu.adp.lib.g.c.hr().ah(17)) {
                at.b(this.doT, t.d.cp_cont_b, 1);
                this.doT.setVisibility(0);
                return;
            }
            List<com.baidu.tieba.tbadkCore.data.k> aSS = iVar.aSS();
            if (aSS != null && aSS.size() > 0) {
                Context context = this.doJ.getPageContext().getContext();
                com.baidu.adp.lib.util.k.c(context, t.e.ds320);
                int B = (com.baidu.adp.lib.util.k.B(context) - com.baidu.adp.lib.util.k.c(context, t.e.ds104)) - com.baidu.adp.lib.util.k.c(context, t.e.ds32);
                int i = (int) (B / 1.7777778f);
                int l = l(aSS, B);
                if (i > l) {
                    i = l;
                }
                com.baidu.tieba.pb.view.g gVar = new com.baidu.tieba.pb.view.g(context, this.daU);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                gVar.setLayoutParams(layoutParams);
                this.doS.setCallback(new com.baidu.tieba.pb.d(gVar, context, this.daU));
                this.doS.setVisibility(0);
                if (aSS.size() > 3) {
                    aSS = aSS.subList(0, 3);
                }
                this.doS.setDisableParentEvent(true);
                com.baidu.tieba.tbadkCore.data.k kVar = aSS.get(0);
                if (!ay.isEmpty(kVar.aSX())) {
                    gVar.dqx.setText(kVar.aSX());
                    gVar.dqx.setVisibility(0);
                } else {
                    gVar.dqx.setVisibility(8);
                }
                if (!ay.isEmpty(kVar.getSubTitle())) {
                    gVar.dqy.setText(kVar.getSubTitle());
                    gVar.dqy.setVisibility(0);
                } else {
                    gVar.dqy.setVisibility(8);
                }
                if (gVar.dqx.getVisibility() != 0 && gVar.dqy.getVisibility() != 0) {
                    gVar.setVisibility(8);
                } else {
                    gVar.ao(kVar.rA(), 1);
                }
                this.doS.setCoverFlowFactory(new com.baidu.tieba.pb.e(gVar, i));
                this.doS.setData(aSS);
            }
        }
    }

    protected void a(com.baidu.tieba.tbadkCore.data.s sVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (sVar != null) {
            this.dcY = sVar;
            com.baidu.tieba.tbadkCore.data.i aTC = sVar.aTC();
            if (aTC != null && aTC.epn) {
                int aSU = aTC.aSU();
                if (aSU == 2 || aSU == 1) {
                    this.dir.setVisibility(8);
                    a(aTC);
                } else {
                    this.dir.setVisibility(0);
                    this.div.setBackgroundDrawable(at.getDrawable(t.f.icon_tuiguang));
                    String position = aTC.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.dis.setVisibility(0);
                        this.diu.setText(position);
                    }
                    this.ddA.setOnLinkImageClickListener(this.doy);
                    this.ddA.setOnImageClickListener(this.doz);
                }
            } else {
                this.dir.setVisibility(8);
                if (z3) {
                    this.ddA.setOnImageClickListener(this.doz);
                }
            }
            this.deT.setTag(null);
            this.deT.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.doH.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.doH.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_is_subpb, false);
            a(sVar, i, sparseArray);
            this.dfa.setTag(sparseArray);
            this.aPp.setOnClickListener(this.brL);
            this.aPp.setText((CharSequence) null);
            this.deZ.setVisibility(8);
            this.doN.setText((CharSequence) null);
            this.dfa.setOnClickListener(this.brL);
            at.b(this.deY, t.d.pb_listitem_post_time, 1);
            this.deY.setText(ay.w(sVar.getTime()));
            if (z) {
                this.deZ.setVisibility(0);
                at.c(this.deZ, t.f.icon_floorhost);
            }
            if (this.ddo) {
                i2 = t.f.img_default_100;
            } else {
                i2 = t.f.icon_click;
            }
            this.ddA.setDefaultImageId(i2);
            this.doN.setText(String.format(this.doJ.getPageContext().getString(t.j.is_floor), Integer.valueOf(sVar.aTs())));
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                String name_show = sVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.r.go(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.r.d(name_show, 0, 14)) + "...";
                }
                this.aPp.setText(name_show);
                ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    at.b(this.aPp, t.d.cp_cont_h, 1);
                } else {
                    at.b(this.aPp, t.d.cp_cont_f, 1);
                }
                int level_id = sVar.getAuthor().getLevel_id();
                int is_bawu = sVar.getAuthor().getIs_bawu();
                String bawu_type = sVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !et.g(this.dcY)) {
                    this.deU.setVisibility(0);
                    at.c(this.deU, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.deU.setContentDescription(String.format(TbadkCoreApplication.m411getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                    this.deU.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.deU.setVisibility(8);
                }
                int i4 = this.doQ.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.deU.setOnClickListener(this.brL);
                    if (bawu_type.equals("manager")) {
                        at.c(this.deU, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        at.c(this.deU, t.f.pb_assist);
                    }
                }
                if (sVar.getAuthor().getGender() == 2) {
                    at.c(this.deW, t.f.icon_pb_pop_girl);
                    this.deW.setVisibility(0);
                } else if (sVar.getAuthor().getGender() == 1) {
                    at.c(this.deW, t.f.icon_pb_pop_boy);
                    this.deW.setVisibility(0);
                } else {
                    this.deW.setVisibility(8);
                }
                this.deI = sVar.getAuthor().getIconInfo();
                this.bjm = sVar.getAuthor().getTShowInfoNew();
                if (this.bvK != null) {
                    if (et.g(sVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.deI.size()) {
                                break;
                            }
                            IconData iconData = this.deI.get(i6);
                            if (!ay.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.deI = arrayList;
                    }
                    this.bvK.setOnClickListener(this.brL);
                    this.bvK.a(this.deI, i4, this.doJ.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.doJ.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.doJ.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (this.ahN != null) {
                    this.ahN.setOnClickListener(this.brL);
                    if (this.bjm != null && this.bjm.size() > 0 && this.bjm.get(0) != null) {
                        this.ahN.setTag(this.bjm.get(0).getUrl());
                    }
                    this.ahN.a(this.bjm, 2, this.doJ.getResources().getDimensionPixelSize(t.e.ds30), this.doJ.getResources().getDimensionPixelSize(t.e.small_icon_height), this.doJ.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                }
            }
            a(this.ddA, (int) this.doJ.getResources().getDimension(t.e.ds76));
            if (sVar.getAuthor().getGodUserData().getId() != null && sVar.getAuthor().getGodUserData().getType() == 2) {
                this.doM.setVisibility(0);
                this.deT.setVisibility(4);
                this.doM.setUserId(sVar.getAuthor().getUserId());
                this.doM.setUserName(sVar.getAuthor().getUserName());
                this.doM.c(portrait, 28, false);
            } else {
                this.doM.setVisibility(8);
                this.deT.setVisibility(0);
                this.deT.setUserId(sVar.getAuthor().getUserId());
                this.deT.setUserName(sVar.getAuthor().getUserName());
                this.deT.setDefaultResource(t.f.transparent_bg);
                this.deT.setDefaultErrorResource(t.f.icon_default_avatar100);
                this.deT.c(portrait, 28, false);
            }
            if (!this.ddp) {
                this.deT.setVisibility(8);
                this.doM.setVisibility(8);
            }
            this.aPp.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
            this.aPp.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            this.ddA.setText(sVar.amn());
            this.doO.setVisibility(8);
            if (!TextUtils.isEmpty(sVar.getBimg_url())) {
                this.ddA.setBackgroundDrawable(null);
                this.ddA.setTag(sVar.getBimg_url());
                this.ddA.setOnClickListener(this.brL);
                this.ddA.setTextViewOnClickListener(this.brL);
                this.ddA.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.hr().a(sVar.getBimg_url(), 19, new ae(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ddA.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.ddA.setPadding(0, 0, 0, 0);
                this.ddA.setLayoutParams(layoutParams);
                this.ddA.setBackgroundDrawable(null);
            }
            if (sVar != null) {
                com.baidu.tieba.pb.view.h.a(sVar.aAu(), this.doP, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth - i);
            this.ddA.setMaxImageHeight((int) ((this.maxImageWidth - i) * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.doJ.getPageContext().getString(t.j.refresh_view_title_text), this.PQ));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.doJ.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.doK, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds140)), dVar, a, false);
        }
        this.doK.setVisibility(0);
        this.Je.setVisibility(8);
        this.aQj.setVisibility(8);
        this.cye.Es();
        at.l(this.mNoDataView, t.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.doJ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void gk(int i) {
        a(NoDataViewFactory.d.v(i, t.j.refresh_view_title_text));
    }

    public void mf(String str) {
        a(NoDataViewFactory.d.ag(str, this.doJ.getPageContext().getString(t.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.Je.setVisibility(0);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.PQ = onClickListener;
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
            if (this.dpd != null && this.dpd.LC() != null && this.dpd.LC().getAuthor() != null && sVar.getAuthor() != null) {
                String userId3 = this.dpd.LC().getAuthor().getUserId();
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
                    int i2 = sVar.aTs() != 1 ? 0 : 1;
                    if (et.g(sVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                        sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(t.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_del_post_is_self, true);
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(t.g.tag_del_post_is_self, false);
                        sparseArray.put(t.g.tag_del_post_type, 0);
                        sparseArray.put(t.g.tag_del_post_id, "");
                    }
                    sparseArray.put(t.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
                    if (!z6) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (sVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                        }
                        if (this.dpd.LC() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.dpd.LC().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, sVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(t.g.tag_del_post_id, sVar.getId());
                        return;
                    }
                    sparseArray.put(t.g.tag_should_delete_visible, false);
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
            if (sVar.aTs() != 1) {
            }
            if (et.g(sVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(t.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(t.g.tag_forbid_user_post_id, sVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View azQ() {
        return this.doX;
    }

    public void onChangeSkinType(int i) {
        this.doJ.getLayoutMode().ab(i == 1);
        this.doJ.getLayoutMode().x(this.dbk);
        this.doJ.getLayoutMode().x(this.doH);
        this.mNavigationBar.onChangeSkinType(this.doJ.getPageContext(), i);
        this.bhl.onChangeSkinType(this.doJ.getPageContext(), i);
        this.doJ.getLayoutMode().x(this.doX);
        at.c(this.dfa, t.f.btn_pb_reply_selector);
        this.ddA.setTextColor(at.getColor(t.d.pb_listitem_content));
        this.ddA.setVideoImageId(t.f.pic_video);
        if (this.cye != null && this.cye.Dh() != null) {
            this.cye.Dh().onChangeSkinType(i);
        }
    }

    public void azR() {
        this.aQj.setVisibility(0);
    }

    public void azS() {
        this.Je.setVisibility(0);
        this.aQj.setVisibility(8);
        this.doU.xv();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bdQ = onLongClickListener;
        this.doH.setOnLongClickListener(this.bdQ);
    }

    public View azT() {
        return this.doH;
    }

    public void mg(String str) {
        int mh = this.doI.mh(str);
        if (mh > -1) {
            this.Je.setSelection(mh + 1);
            this.Je.invalidate();
        }
    }

    public View azU() {
        return this.doL;
    }

    public es azV() {
        return this.doW;
    }

    public MorePopupWindow azW() {
        return this.doV;
    }

    public HeadImageView azX() {
        return this.deT;
    }

    public ClickableHeaderImageView azY() {
        return this.doM;
    }

    public TextView getUserNameView() {
        return this.aPp;
    }

    public UserIconBox azZ() {
        return this.bvK;
    }

    public ImageView aAa() {
        return this.deU;
    }

    public UserIconBox aAb() {
        return this.ahN;
    }

    public void akp() {
        if (this.dmg == null) {
            this.dmg = new com.baidu.tbadk.core.view.b(this.doJ.getPageContext());
        }
        this.dmg.ay(true);
    }

    public void azf() {
        if (this.dmg != null) {
            this.dmg.ay(false);
        }
    }

    public TextView aAc() {
        return this.doP;
    }

    public TbRichTextView aAd() {
        return this.ddA;
    }

    public TextView aAe() {
        if (this.ddA == null) {
            return null;
        }
        return this.ddA.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.doy = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.doz = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.ddA != null) {
            this.ddA.setOnEmotionClickListener(cVar);
        }
    }
}
