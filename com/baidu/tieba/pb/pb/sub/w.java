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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.pb.main.di;
import com.baidu.tieba.pb.pb.main.dj;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w {
    private static final int cLd = TbadkCoreApplication.m411getInst().getListItemRule().wS();
    private NoNetworkView bam;
    private View.OnClickListener bjD;
    private RelativeLayout cBw;
    public RelativeLayout cGG;
    public LinearLayout cGH;
    public ImageView cGI;
    public TextView cGJ;
    public ImageView cGK;
    private com.baidu.tbadk.core.view.b cJB;
    private com.baidu.tieba.pb.a.d cLA;
    private View cLe;
    private am cLf;
    private NewSubPbActivity cLg;
    private RelativeLayout cLh;
    private ImageView cLm;
    private TextView cLp;
    private an cLq;
    private View cLt;
    private ArrayList<com.baidu.tieba.tbadkCore.data.r> cLy;
    private String cLz;
    private BdListView mListView;
    private ProgressBar mProgress;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.o mNoDataView = null;
    private TbRichTextView.d cKW = null;
    private View.OnClickListener SY = null;
    private TbRichTextView.e cKV = null;
    private NavigationBar mNavigationBar = null;
    private TextView cLi = null;
    private TextView Yh = null;
    private HeadImageView cEn = null;
    private TextView aLp = null;
    private ImageView cEo = null;
    private ImageView cEq = null;
    private TextView cLj = null;
    private ImageView cEs = null;
    private TextView bIB = null;
    private TbRichTextView cDC = null;
    private ImageView cEt = null;
    private TextView cLk = null;
    private TextView cLl = null;
    private PbNewChudianCommonView cLn = null;
    private CoverFlowView<com.baidu.tieba.tbadkCore.data.j> cLo = null;
    private MorePopupWindow cLr = null;
    private di cLs = null;
    private com.baidu.tbadk.core.dialog.c cJn = null;
    private UserIconBox bnP = null;
    private UserIconBox agT = null;
    private Dialog cIU = null;
    private com.baidu.tbadk.core.dialog.a cIW = null;
    private boolean cDr = true;
    private boolean cDQ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aWS = null;
    private NewSubPbActivity.a cLu = null;
    private NewSubPbActivity.a cLv = null;
    private ArrayList<IconData> cDZ = null;
    private ArrayList<IconData> bcl = null;
    private com.baidu.tbadk.editortools.d.p cjc = null;
    private String cLw = null;
    private int cLx = 0;
    private com.baidu.tieba.tbadkCore.data.r cDb = null;
    protected HashMap<Long, HashSet<String>> cHQ = new HashMap<>();
    protected final a.InterfaceC0072a cBf = new x(this);
    private View.OnClickListener cEa = new ae(this);
    private com.baidu.tieba.pb.b.c cDu = new com.baidu.tieba.pb.b.c(new af(this));
    protected AdapterView.OnItemClickListener cLB = new ag(this);
    protected AdapterView.OnItemLongClickListener Ig = new ah(this);

    public w(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cBw = null;
        this.cLe = null;
        this.mListView = null;
        this.cLf = null;
        this.cLg = null;
        this.bam = null;
        this.cLh = null;
        this.cLq = null;
        this.cLt = null;
        this.bjD = null;
        this.mProgress = null;
        this.cLg = newSubPbActivity;
        this.bjD = onClickListener;
        this.cBw = (RelativeLayout) LayoutInflater.from(this.cLg.getPageContext().getPageActivity()).inflate(n.h.new_sub_pb_layout, (ViewGroup) null);
        this.cLe = LayoutInflater.from(this.cLg.getPageContext().getPageActivity()).inflate(n.h.new_sub_pb_head, (ViewGroup) null);
        this.bam = (NoNetworkView) this.cBw.findViewById(n.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.K(this.cLg.getBaseContext()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.e.ds60);
        any();
        Jg();
        this.cLh = (RelativeLayout) this.cBw.findViewById(n.g.sub_pb_body_layout);
        this.mListView = (BdListView) this.cBw.findViewById(n.g.new_sub_pb_list);
        this.mListView.addHeaderView(this.cLe);
        this.cLf = new am(this.cLg.getPageContext().getPageActivity());
        this.cLf.D(this.cEa);
        this.cLf.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cLf);
        this.cLq = new an(this.cLg.getPageContext());
        this.cLt = this.cLq.getView();
        this.mListView.setNextPage(this.cLq);
        this.cLq.setOnClickListener(this.bjD);
        this.mListView.setOnItemClickListener(this.cLB);
        this.mListView.setOnItemLongClickListener(this.Ig);
        this.mListView.setOnTouchListener(this.cDu);
        this.mProgress = (ProgressBar) this.cBw.findViewById(n.g.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cLe != null) {
            this.cLe.setVisibility(4);
        }
        if (this.cLh != null) {
            this.cLh.setVisibility(4);
        }
    }

    public void Jg() {
        this.cEn = (HeadImageView) this.cLe.findViewById(n.g.photo);
        this.cEn.setOnClickListener(this.bjD);
        this.aLp = (TextView) this.cLe.findViewById(n.g.user_name);
        this.cEo = (ImageView) this.cLe.findViewById(n.g.user_rank);
        this.cEq = (ImageView) this.cLe.findViewById(n.g.user_gender);
        this.cEt = (ImageView) this.cLe.findViewById(n.g.reply);
        this.cLk = (TextView) this.cLe.findViewById(n.g.manage_btn);
        this.cLj = (TextView) this.cLe.findViewById(n.g.floor);
        this.cEs = (ImageView) this.cLe.findViewById(n.g.floor_owner);
        this.bIB = (TextView) this.cLe.findViewById(n.g.time);
        this.bnP = (UserIconBox) this.cLe.findViewById(n.g.user_icon_box);
        this.agT = (UserIconBox) this.cLe.findViewById(n.g.user_tshow_icon_box);
        this.cDC = (TbRichTextView) this.cLe.findViewById(n.g.richText);
        this.cDC.Gd();
        this.cDC.g(this.cDr, true);
        this.cDC.setIsFromCDN(this.mIsFromCDN);
        this.cDC.setImageViewStretch(true);
        this.cDC.setTextSize(TbConfig.getContentSize());
        this.cDC.setVoiceViewRes(n.h.voice_play_btn);
        this.cLe.setOnTouchListener(this.cDu);
        this.cLe.setOnClickListener(this.bjD);
        this.cLl = (TextView) this.cLe.findViewById(n.g.pb_item_tail_content);
        this.cLl.setOnClickListener(this.bjD);
        this.cGG = (RelativeLayout) this.cLe.findViewById(n.g.chudian_info_container);
        this.cGH = (LinearLayout) this.cLe.findViewById(n.g.landmark_container);
        this.cGI = (ImageView) this.cLe.findViewById(n.g.landmark_icon);
        this.cGJ = (TextView) this.cLe.findViewById(n.g.landmark_content);
        this.cGK = (ImageView) this.cLe.findViewById(n.g.ad_icon);
        this.cLm = (ImageView) this.cLe.findViewById(n.g.subpb_newchudian_advertise);
        this.cLp = (TextView) this.cLe.findViewById(n.g.chudian_pic);
    }

    public void any() {
        this.mNavigationBar = (NavigationBar) this.cBw.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.Yh = this.mNavigationBar.setTitleText("");
        this.cLi = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cLg.getResources().getString(n.j.view_subject), this.bjD);
        this.cLi.setVisibility(8);
    }

    public void alj() {
        this.cLs = new di(this.cLg.getPageContext(), this.bjD);
        this.cLs.fg(TbadkCoreApplication.isLogin());
        this.cLr = new MorePopupWindow(this.cLg.getPageContext().getPageActivity(), this.cLs.getView(), this.cLg.getResources().getDrawable(n.f.bg_collect), null);
        this.cLr.setTouchInterceptor(new ai(this));
        this.cLr.onChangeSkinType(this.cLg, TbadkCoreApplication.m411getInst().getSkinType(), as.getDrawable(n.f.bg_collect));
    }

    public void ap(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cIU == null) {
            this.cIU = new Dialog(this.cLg.getPageContext().getPageActivity(), n.k.common_alert_dialog);
            this.cIU.setCanceledOnTouchOutside(true);
            this.cIU.setCancelable(true);
            View inflate = LayoutInflater.from(this.cLg.getPageContext().getPageActivity()).inflate(n.h.forum_manage_dialog, (ViewGroup) null);
            this.cLg.getLayoutMode().k(inflate);
            this.cIU.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cIU.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cLg.getPageContext().getPageActivity()) * 0.9d);
            this.cIU.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cIU.findViewById(n.g.del_post_btn);
        TextView textView2 = (TextView) this.cIU.findViewById(n.g.forbid_user_btn);
        TextView textView3 = (TextView) this.cIU.findViewById(n.g.disable_reply_btn);
        if ("".equals(sparseArray.get(n.g.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(n.g.tag_del_post_id, sparseArray.get(n.g.tag_del_post_id));
            sparseArray2.put(n.g.tag_del_post_type, sparseArray.get(n.g.tag_del_post_type));
            sparseArray2.put(n.g.tag_del_post_is_self, sparseArray.get(n.g.tag_del_post_is_self));
            sparseArray2.put(n.g.tag_manage_user_identity, sparseArray.get(n.g.tag_manage_user_identity));
            textView.setOnClickListener(new aj(this));
        }
        if ("".equals(sparseArray.get(n.g.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(n.g.tag_forbid_user_name, sparseArray.get(n.g.tag_forbid_user_name));
            sparseArray3.put(n.g.tag_manage_user_identity, sparseArray.get(n.g.tag_manage_user_identity));
            sparseArray3.put(n.g.tag_forbid_user_post_id, sparseArray.get(n.g.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ak(this));
        }
        if (!((sparseArray.get(n.g.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.g.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(n.j.un_mute);
            } else {
                textView3.setText(n.j.mute);
            }
            sparseArray4.put(n.g.tag_is_mem, sparseArray.get(n.g.tag_is_mem));
            sparseArray4.put(n.g.tag_user_mute_mute_userid, sparseArray.get(n.g.tag_user_mute_mute_userid));
            sparseArray4.put(n.g.tag_user_mute_mute_username, sparseArray.get(n.g.tag_user_mute_mute_username));
            sparseArray4.put(n.g.tag_user_mute_post_id, sparseArray.get(n.g.tag_user_mute_post_id));
            sparseArray4.put(n.g.tag_user_mute_thread_id, sparseArray.get(n.g.tag_user_mute_thread_id));
            textView3.setOnClickListener(new al(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.cIU, this.cLg.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(n.g.tag_del_post_id, str);
        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = n.j.del_post_confirm;
        if (i == 0) {
            i3 = n.j.del_thread_confirm;
        }
        this.cIW = new com.baidu.tbadk.core.dialog.a(this.cLg.getPageContext().getPageActivity());
        this.cIW.bG(i3);
        this.cIW.x(sparseArray);
        this.cIW.a(n.j.dialog_ok, new y(this, sparseArray));
        this.cIW.b(n.j.dialog_cancel, new z(this));
        this.cIW.ai(true);
        this.cIW.b(this.cLg.getPageContext());
        this.cIW.tf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new aa(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.cJn != null) {
            this.cJn.dismiss();
            this.cJn = null;
        }
        if (z) {
            string = this.cLg.getResources().getString(n.j.remove_mark);
        } else {
            string = this.cLg.getResources().getString(n.j.mark);
        }
        this.cJn = new com.baidu.tbadk.core.dialog.c(this.cLg.getPageContext().getPageActivity());
        this.cJn.bJ(n.j.operation);
        this.cJn.a(new String[]{this.cLg.getResources().getString(n.j.copy), string}, bVar);
        this.cJn.d(this.cLg.getPageContext());
        this.cJn.tj();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cLu = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.cLv = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cLg.showToast(this.cLg.getResources().getString(n.j.success));
        } else if (str != null && z2) {
            this.cLg.showToast(str);
        }
    }

    public void ao(View view) {
        if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
        } else {
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
        }
    }

    public void e(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Bj() != null) {
            this.cjc = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cBw.addView(pVar.Bj(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i, View view) {
        new Handler().postDelayed(new ab(this, view, i), 300L);
    }

    public void eU(boolean z) {
        this.cDQ = z;
        this.cLf.eU(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.cBw;
    }

    public void aW(String str, String str2) {
        this.cLz = str2;
        new Handler().postDelayed(new ac(this, str2, str), 200L);
    }

    public void ana() {
        if (this.cLr != null) {
            com.baidu.adp.lib.h.j.a(this.cLr, this.cLg.getPageContext().getPageActivity());
        }
        if (this.cJn != null) {
            this.cJn.dismiss();
        }
        if (this.cIW != null) {
            this.cIW.dismiss();
        }
        if (this.cIU != null) {
            com.baidu.adp.lib.h.j.b(this.cIU, this.cLg.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void anz() {
        this.mListView.setNextPage(this.cLq);
        this.cLq.startLoadData();
    }

    public void eS(boolean z) {
        this.cDr = z;
    }

    public void a(com.baidu.tieba.pb.a.d dVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (dVar != null) {
            this.cLA = dVar;
            this.cLf.g(this.cLA.Iv());
            if (this.cLe != null) {
                this.cLe.setVisibility(0);
            }
            if (this.cLh != null) {
                this.cLh.setVisibility(0);
            }
            if (dVar.akS() != null) {
                this.cLw = dVar.akS().getId();
                this.cLx = dVar.akS().aFq();
                if (this.cLx > 0) {
                    this.Yh.setText(String.format(this.cLg.getPageContext().getString(n.j.is_floor), Integer.valueOf(this.cLx)));
                } else {
                    this.Yh.setText((CharSequence) null);
                }
            }
            if (dVar.hasMore()) {
                this.cLq.startLoadData();
                this.cLf.setHasMoreData(true);
            } else {
                this.cLq.vP();
                this.cLf.setHasMoreData(false);
            }
            this.cLy = dVar.akW();
            if (this.cLy == null || this.cLy.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.cLq);
            }
            if (this.cLy == null || this.cLy.size() <= cLd) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.cLy.size() - cLd;
                kC(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cLf.setDatas(this.cLy);
            if (dVar.Iv() != null && dVar.Iv().getAuthor() != null && (userId = dVar.Iv().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cLf.r(i, z);
            this.cLf.notifyDataSetChanged();
            a(dVar.akS(), dVar.abn(), dVar.pN(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View anA() {
        return this.cEt;
    }

    private void kC(int i) {
        if (this.cLy != null) {
            if (this.cLy.size() <= i) {
                this.cLy.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.r> it = this.cLy.iterator();
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

    public boolean anB() {
        return this.cLf.cLJ;
    }

    private int g(List<com.baidu.tieba.tbadkCore.data.j> list, int i) {
        int i2;
        if (list == null || list.size() <= 0 || i <= 0) {
            return 0;
        }
        int i3 = 1;
        for (int i4 = 0; i4 != list.size(); i4++) {
            com.baidu.tieba.tbadkCore.data.j jVar = list.get(i4);
            int width = jVar.getWidth();
            int height = jVar.getHeight();
            if (width > 1 && (i2 = (int) ((height * i) / width)) > i3) {
                i3 = i2;
            }
        }
        return i3;
    }

    private void a(com.baidu.tieba.tbadkCore.data.h hVar) {
        if (hVar != null) {
            if (this.cLn == null) {
                this.cLn = (PbNewChudianCommonView) this.cLe.findViewById(n.g.subpb_newchudian_common);
            }
            if (this.cLo == null) {
                this.cLo = (CoverFlowView) this.cLe.findViewById(n.g.subpb_newchudian_coverflowview);
            }
            as.c(this.cLm, n.f.icon_tuiguang);
            this.cLm.setVisibility(0);
            this.cLn.a(hVar, this.cLg, this.cBf);
            if (!com.baidu.adp.lib.g.c.hd().X(17)) {
                as.b(this.cLp, n.d.cp_cont_b, 1);
                this.cLp.setVisibility(0);
                return;
            }
            List<com.baidu.tieba.tbadkCore.data.j> aER = hVar.aER();
            if (aER != null && aER.size() > 0) {
                Context context = this.cLg.getPageContext().getContext();
                com.baidu.adp.lib.util.k.d(context, n.e.ds320);
                int K = (com.baidu.adp.lib.util.k.K(context) - com.baidu.adp.lib.util.k.d(context, n.e.ds104)) - com.baidu.adp.lib.util.k.d(context, n.e.ds32);
                int i = (int) (K / 1.7777778f);
                int g = g(aER, K);
                if (i > g) {
                    i = g;
                }
                com.baidu.tieba.pb.view.g gVar = new com.baidu.tieba.pb.view.g(context, this.cBf);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                gVar.setLayoutParams(layoutParams);
                this.cLo.setCallback(new com.baidu.tieba.pb.c(gVar, context, this.cBf));
                this.cLo.setVisibility(0);
                if (aER.size() > 3) {
                    aER = aER.subList(0, 3);
                }
                if (aER.size() > 1) {
                    this.cLo.setDisableParentEvent(true);
                } else {
                    this.cLo.setDisableParentEvent(false);
                }
                com.baidu.tieba.tbadkCore.data.j jVar = aER.get(0);
                if (!ax.isEmpty(jVar.aEV())) {
                    gVar.cMO.setText(jVar.aEV());
                    gVar.cMO.setVisibility(0);
                } else {
                    gVar.cMO.setVisibility(8);
                }
                if (!ax.isEmpty(jVar.sX())) {
                    gVar.cMP.setText(jVar.sX());
                    gVar.cMP.setVisibility(0);
                } else {
                    gVar.cMP.setVisibility(8);
                }
                if (gVar.cMO.getVisibility() != 0 && gVar.cMP.getVisibility() != 0) {
                    gVar.setVisibility(8);
                } else {
                    gVar.ad(jVar.rt(), 1);
                }
                this.cLo.setCoverFlowFactory(new com.baidu.tieba.pb.d(gVar, i));
                this.cLo.setData(aER);
            }
        }
    }

    protected void a(com.baidu.tieba.tbadkCore.data.r rVar, boolean z, boolean z2, int i) {
        int i2;
        if (rVar != null) {
            this.cDb = rVar;
            com.baidu.tieba.tbadkCore.data.h aFA = rVar.aFA();
            if (aFA != null && aFA.dGJ) {
                int aET = aFA.aET();
                if (aET == 2 || aET == 1) {
                    this.cGG.setVisibility(8);
                    a(aFA);
                } else {
                    this.cGG.setVisibility(0);
                    this.cGK.setBackgroundDrawable(as.getDrawable(n.f.icon_tuiguang));
                    String position = aFA.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.cGH.setVisibility(0);
                        this.cGJ.setText(position);
                    }
                    this.cDC.setOnLinkImageClickListener(this.cKV);
                    this.cDC.setOnImageClickListener(this.cKW);
                }
            } else {
                this.cGG.setVisibility(8);
            }
            this.cEn.setTag(null);
            this.cEn.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cLe.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cLe.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(n.g.tag_clip_board, rVar);
            sparseArray.put(n.g.tag_is_subpb, false);
            a(rVar, i, sparseArray);
            this.cEt.setTag(sparseArray);
            if (!this.cDQ) {
                this.cEn.setVisibility(8);
            }
            this.aLp.setOnClickListener(this.bjD);
            this.aLp.setText((CharSequence) null);
            this.cEs.setVisibility(8);
            this.cLj.setText((CharSequence) null);
            this.cEt.setOnClickListener(this.bjD);
            as.b(this.bIB, n.d.pb_listitem_post_time, 1);
            this.bIB.setText(ax.s(rVar.getTime()));
            if (z) {
                this.cEs.setVisibility(0);
                as.c(this.cEs, n.f.icon_floorhost);
            }
            if (this.cDr) {
                i2 = n.f.img_default_100;
            } else {
                i2 = n.f.icon_click;
            }
            this.cDC.setDefaultImageId(i2);
            this.cLj.setText(String.format(this.cLg.getPageContext().getString(n.j.is_floor), Integer.valueOf(rVar.aFq())));
            String portrait = rVar.getAuthor().getPortrait();
            if (rVar.getAuthor() != null) {
                String name_show = rVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.o.gi(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                }
                this.aLp.setText(name_show);
                ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    as.b(this.aLp, n.d.cp_cont_h, 1);
                } else {
                    as.b(this.aLp, n.d.cp_cont_f, 1);
                }
                int level_id = rVar.getAuthor().getLevel_id();
                int is_bawu = rVar.getAuthor().getIs_bawu();
                String bawu_type = rVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !dj.e(this.cDb)) {
                    this.cEo.setVisibility(0);
                    as.c(this.cEo, com.baidu.tbadk.core.util.c.cj(level_id));
                    this.cEo.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.cEo.setVisibility(8);
                }
                int i4 = this.cLm.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.cEo.setOnClickListener(this.bjD);
                    if (bawu_type.equals("manager")) {
                        as.c(this.cEo, n.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        as.c(this.cEo, n.f.pb_assist);
                    }
                }
                if (rVar.getAuthor().getGender() == 2) {
                    as.c(this.cEq, n.f.icon_pb_pop_girl);
                    this.cEq.setVisibility(0);
                } else if (rVar.getAuthor().getGender() == 1) {
                    as.c(this.cEq, n.f.icon_pb_pop_boy);
                    this.cEq.setVisibility(0);
                } else {
                    this.cEq.setVisibility(8);
                }
                this.cDZ = rVar.getAuthor().getIconInfo();
                this.bcl = rVar.getAuthor().getTShowInfoNew();
                if (this.bnP != null) {
                    if (dj.e(rVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.cDZ.size()) {
                                break;
                            }
                            IconData iconData = this.cDZ.get(i6);
                            if (!ax.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.cDZ = arrayList;
                    }
                    this.bnP.setOnClickListener(this.bjD);
                    this.bnP.a(this.cDZ, i4, this.cLg.getResources().getDimensionPixelSize(n.e.pb_icon_width), this.cLg.getResources().getDimensionPixelSize(n.e.pb_icon_height), this.cLg.getResources().getDimensionPixelSize(n.e.pb_icon_margin));
                }
                if (this.agT != null) {
                    this.agT.setOnClickListener(this.bjD);
                    if (this.bcl != null && this.bcl.size() > 0 && this.bcl.get(0) != null) {
                        this.agT.setTag(this.bcl.get(0).getUrl());
                    }
                    this.agT.a(this.bcl, 2, this.cLg.getResources().getDimensionPixelSize(n.e.ds30), this.cLg.getResources().getDimensionPixelSize(n.e.small_icon_height), this.cLg.getResources().getDimensionPixelSize(n.e.small_icon_margin), true);
                }
            }
            a(this.cDC, (int) this.cLg.getResources().getDimension(n.e.ds76));
            this.cEn.setUserId(rVar.getAuthor().getUserId());
            this.cEn.setUserName(rVar.getAuthor().getUserName());
            this.aLp.setTag(n.g.tag_user_id, rVar.getAuthor().getUserId());
            this.aLp.setTag(n.g.tag_user_name, rVar.getAuthor().getUserName());
            this.cEn.setDefaultResource(n.f.icon_default_avatar100);
            this.cEn.d(portrait, 28, false);
            this.cDC.setText(rVar.aFr());
            this.cLk.setVisibility(8);
            if (!TextUtils.isEmpty(rVar.getBimg_url())) {
                this.cDC.setBackgroundDrawable(null);
                this.cDC.setTag(rVar.getBimg_url());
                this.cDC.setOnClickListener(this.bjD);
                this.cDC.setTextViewOnClickListener(this.bjD);
                this.cDC.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.hd().a(rVar.getBimg_url(), 19, new ad(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cDC.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.cDC.setPadding(0, 0, 0, 0);
                this.cDC.setLayoutParams(layoutParams);
                this.cDC.setBackgroundDrawable(null);
            }
            if (rVar != null) {
                com.baidu.tieba.pb.view.h.a(rVar.aoe(), this.cLl, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth - i);
            this.cDC.setMaxImageHeight((int) ((this.maxImageWidth - i) * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cLg.getPageContext().getString(n.j.refresh_view_title_text), this.SY));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.cLg.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.cLh, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.d(pageActivity, n.e.ds140)), dVar, a, false);
        }
        this.cLh.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.cjc.Cs();
        as.j(this.mNoDataView, n.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.cLg.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fv(int i) {
        a(NoDataViewFactory.d.C(i, n.j.refresh_view_title_text));
    }

    public void hw(String str) {
        a(NoDataViewFactory.d.ac(str, this.cLg.getPageContext().getString(n.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.SY = onClickListener;
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
    public void a(com.baidu.tieba.tbadkCore.data.r rVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        boolean z7;
        if (rVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = rVar.getAuthor().getUserId();
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
            if (this.cLA != null && this.cLA.Iv() != null && this.cLA.Iv().getAuthor() != null && rVar.getAuthor() != null) {
                String userId3 = this.cLA.Iv().getAuthor().getUserId();
                String userId4 = rVar.getAuthor().getUserId();
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
                    userId = rVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = rVar.aFq() != 1 ? 0 : 1;
                    if (dj.e(rVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                        sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(n.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.g.tag_del_post_is_self, true);
                        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(n.g.tag_del_post_id, rVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(n.g.tag_del_post_is_self, false);
                        sparseArray.put(n.g.tag_del_post_type, 0);
                        sparseArray.put(n.g.tag_del_post_id, "");
                    }
                    sparseArray.put(n.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z6) {
                        sparseArray.put(n.g.tag_should_manage_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(n.g.tag_user_mute_visible, true);
                        sparseArray.put(n.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(n.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(n.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cLA.Iv() != null) {
                            sparseArray.put(n.g.tag_user_mute_thread_id, this.cLA.Iv().getId());
                        }
                        sparseArray.put(n.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(n.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(n.g.tag_should_delete_visible, true);
                        sparseArray.put(n.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(n.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(n.g.tag_del_post_id, rVar.getId());
                        return;
                    }
                    sparseArray.put(n.g.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = rVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (rVar.aFq() != 1) {
            }
            if (dj.e(rVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(n.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(n.g.tag_forbid_user_post_id, rVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View anC() {
        return this.cLt;
    }

    public void onChangeSkinType(int i) {
        this.cLg.getLayoutMode().ac(i == 1);
        this.cLg.getLayoutMode().k(this.cBw);
        this.cLg.getLayoutMode().k(this.cLe);
        this.mNavigationBar.onChangeSkinType(this.cLg.getPageContext(), i);
        this.bam.onChangeSkinType(this.cLg.getPageContext(), i);
        this.cLg.getLayoutMode().k(this.cLt);
        as.c(this.cEt, n.f.btn_pb_reply_selector);
        this.cDC.setTextColor(as.getColor(n.d.pb_listitem_content));
        this.cDC.setVideoImageId(n.f.pic_video);
        if (this.cjc != null && this.cjc.Bj() != null) {
            this.cjc.Bj().onChangeSkinType(i);
        }
    }

    public void anD() {
        this.mProgress.setVisibility(0);
    }

    public void anE() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.cLq.vP();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aWS = onLongClickListener;
        this.cLe.setOnLongClickListener(this.aWS);
    }

    public View anF() {
        return this.cLe;
    }

    public void kM(String str) {
        int kN = this.cLf.kN(str);
        if (kN > -1) {
            this.mListView.setSelection(kN + 1);
            this.mListView.invalidate();
        }
    }

    public View anG() {
        return this.cLi;
    }

    public di anH() {
        return this.cLs;
    }

    public MorePopupWindow anI() {
        return this.cLr;
    }

    public HeadImageView anJ() {
        return this.cEn;
    }

    public TextView getUserNameView() {
        return this.aLp;
    }

    public UserIconBox anK() {
        return this.bnP;
    }

    public ImageView anL() {
        return this.cEo;
    }

    public UserIconBox anM() {
        return this.agT;
    }

    public void adL() {
        if (this.cJB == null) {
            this.cJB = new com.baidu.tbadk.core.view.b(this.cLg.getPageContext());
        }
        this.cJB.av(true);
    }

    public void ang() {
        if (this.cJB != null) {
            this.cJB.av(false);
        }
    }

    public TextView anN() {
        return this.cLl;
    }

    public TbRichTextView anO() {
        return this.cDC;
    }

    public TextView anP() {
        if (this.cDC == null) {
            return null;
        }
        return this.cDC.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.cKV = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.cKW = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.cDC != null) {
            this.cDC.setOnEmotionClickListener(cVar);
        }
    }
}
