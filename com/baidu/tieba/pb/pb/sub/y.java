package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.baidu.tbadk.core.util.UtilHelper;
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
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.b;
import com.baidu.tieba.pb.pb.main.dd;
import com.baidu.tieba.pb.pb.main.ej;
import com.baidu.tieba.pb.pb.main.ek;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class y {
    private static final int dqo = TbadkCoreApplication.m11getInst().getListItemRule().wz();
    private ProgressBar bDI;
    private View bbZ;
    private NoNetworkView bdb;
    private View.OnClickListener bnn;
    private RelativeLayout ddG;
    private dd diU;
    public RelativeLayout dkD;
    public LinearLayout dkE;
    public ImageView dkF;
    public TextView dkG;
    public ImageView dkH;
    private com.baidu.tbadk.core.view.b doA;
    private TextView dqB;
    private ao dqC;
    private View dqF;
    private ArrayList<com.baidu.tieba.tbadkCore.data.s> dqJ;
    private String dqK;
    private com.baidu.tieba.pb.data.h dqL;
    private View dqp;
    private an dqq;
    private NewSubPbActivity dqr;
    private RelativeLayout dqs;
    private ImageView dqy;
    private int maxImageWidth;
    private BdListView zu;
    private com.baidu.tbadk.core.view.q mNoDataView = null;
    private TbRichTextView.d dqh = null;
    private View.OnClickListener KH = null;
    private TbRichTextView.e dqg = null;
    private NavigationBar mNavigationBar = null;
    private TextView dqt = null;
    private TextView RX = null;
    private HeadImageView dhm = null;
    private ClickableHeaderImageView dqu = null;
    private TextView aLz = null;
    private ImageView dhn = null;
    private ImageView dhp = null;
    private TextView dqv = null;
    private ImageView dhs = null;
    private TextView dhr = null;
    private TbRichTextView dfT = null;
    private ImageView dht = null;
    private ImageView dqw = null;
    private TextView dqx = null;
    private PbNewChudianCommonView dqz = null;
    private CoverFlowView<com.baidu.tieba.tbadkCore.data.k> dqA = null;
    private MorePopupWindow dqD = null;
    private ej dqE = null;
    private com.baidu.tbadk.core.dialog.c dol = null;
    private UserIconBox bvy = null;
    private UserIconBox adH = null;
    private Dialog dnR = null;
    private com.baidu.tbadk.core.dialog.a dnT = null;
    private boolean dfI = true;
    private boolean dfJ = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aZy = null;
    private NewSubPbActivity.a dqG = null;
    private NewSubPbActivity.a dqH = null;
    private ArrayList<IconData> dhb = null;
    private ArrayList<IconData> bfm = null;
    private com.baidu.tbadk.editortools.d.p czd = null;
    private String dqI = null;
    private int aDU = 0;
    private com.baidu.tieba.tbadkCore.data.s dfs = null;
    protected HashMap<Long, HashSet<String>> dml = new HashMap<>();
    protected final b.a ddo = new z(this);
    private View.OnClickListener dhc = new ag(this);
    private com.baidu.tieba.pb.a.d dfM = new com.baidu.tieba.pb.a.d(new ah(this));
    protected AdapterView.OnItemClickListener dqM = new ai(this);
    protected AdapterView.OnItemLongClickListener yS = new aj(this);

    public y(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.ddG = null;
        this.dqp = null;
        this.zu = null;
        this.dqq = null;
        this.dqr = null;
        this.bdb = null;
        this.dqs = null;
        this.dqC = null;
        this.dqF = null;
        this.bnn = null;
        this.bDI = null;
        this.dqr = newSubPbActivity;
        this.bnn = onClickListener;
        this.ddG = (RelativeLayout) LayoutInflater.from(this.dqr.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_layout, (ViewGroup) null);
        this.dqp = LayoutInflater.from(this.dqr.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_head, (ViewGroup) null);
        this.bdb = (NoNetworkView) this.ddG.findViewById(t.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.B(this.dqr.getBaseContext()) - TbadkCoreApplication.m11getInst().getResources().getDimensionPixelSize(t.e.ds60);
        azT();
        Nz();
        this.dqs = (RelativeLayout) this.ddG.findViewById(t.g.sub_pb_body_layout);
        this.zu = (BdListView) this.ddG.findViewById(t.g.new_sub_pb_list);
        this.zu.addHeaderView(this.dqp);
        this.bbZ = BdListViewHelper.a(this.dqr.getActivity(), this.zu, BdListViewHelper.HeadType.DEFAULT);
        this.dqq = new an(this.dqr.getPageContext().getPageActivity());
        this.dqq.J(this.dhc);
        this.dqq.setIsFromCDN(this.mIsFromCDN);
        this.dqq.hf(true);
        this.zu.setAdapter((ListAdapter) this.dqq);
        this.dqC = new ao(this.dqr.getPageContext());
        this.dqF = this.dqC.getView();
        this.zu.setNextPage(this.dqC);
        this.dqC.setOnClickListener(this.bnn);
        this.zu.setOnItemClickListener(this.dqM);
        this.zu.setOnItemLongClickListener(this.yS);
        this.zu.setOnTouchListener(this.dfM);
        this.bDI = (ProgressBar) this.ddG.findViewById(t.g.progress);
        onChangeSkinType(TbadkCoreApplication.m11getInst().getSkinType());
        if (this.dqp != null) {
            this.dqp.setVisibility(4);
        }
        if (this.dqs != null) {
            this.dqs.setVisibility(4);
        }
    }

    public void Nz() {
        this.dhm = (HeadImageView) this.dqp.findViewById(t.g.photo);
        this.dhm.setRadius(com.baidu.adp.lib.util.k.c(this.dqr.getActivity(), t.e.ds40));
        this.dhm.setOnClickListener(this.bnn);
        this.dqu = (ClickableHeaderImageView) this.dqp.findViewById(t.g.god_user_photo);
        this.dqu.setGodIconMargin(0);
        this.dqu.setRadius(com.baidu.adp.lib.util.k.c(this.dqr.getActivity(), t.e.ds40));
        this.dqu.setOnClickListener(this.bnn);
        this.aLz = (TextView) this.dqp.findViewById(t.g.user_name);
        this.dhn = (ImageView) this.dqp.findViewById(t.g.user_rank);
        this.dhp = (ImageView) this.dqp.findViewById(t.g.user_gender);
        this.dht = (ImageView) this.dqp.findViewById(t.g.reply);
        this.dqw = (ImageView) this.dqp.findViewById(t.g.more);
        this.dqv = (TextView) this.dqp.findViewById(t.g.floor);
        this.dqv.setTextSize(TbConfig.getContentSizeOfLzl(this.dqr.getApplicationContext()));
        this.dhs = (ImageView) this.dqp.findViewById(t.g.floor_owner);
        this.dhr = (TextView) this.dqp.findViewById(t.g.time);
        this.dhr.setTextSize(TbConfig.getContentSizeOfLzl(this.dqr.getApplicationContext()));
        this.bvy = (UserIconBox) this.dqp.findViewById(t.g.user_icon_box);
        this.adH = (UserIconBox) this.dqp.findViewById(t.g.user_tshow_icon_box);
        this.dfT = (TbRichTextView) this.dqp.findViewById(t.g.richText);
        this.dfT.Ho();
        this.dfT.h(this.dfI, true);
        this.dfT.setIsFromCDN(this.mIsFromCDN);
        this.dfT.setImageViewStretch(true);
        this.dfT.setTextSize(TbConfig.getContentSize());
        this.dfT.setVoiceViewRes(t.h.voice_play_btn);
        this.dqp.setOnTouchListener(this.dfM);
        this.dqp.setOnClickListener(this.bnn);
        this.dqx = (TextView) this.dqp.findViewById(t.g.pb_item_tail_content);
        this.dqx.setOnClickListener(this.bnn);
        this.dkD = (RelativeLayout) this.dqp.findViewById(t.g.chudian_info_container);
        this.dkE = (LinearLayout) this.dqp.findViewById(t.g.landmark_container);
        this.dkF = (ImageView) this.dqp.findViewById(t.g.landmark_icon);
        this.dkG = (TextView) this.dqp.findViewById(t.g.landmark_content);
        this.dkH = (ImageView) this.dqp.findViewById(t.g.ad_icon);
        this.dqy = (ImageView) this.dqp.findViewById(t.g.subpb_newchudian_advertise);
        this.dqB = (TextView) this.dqp.findViewById(t.g.chudian_pic);
    }

    public void azT() {
        this.mNavigationBar = (NavigationBar) this.ddG.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.RX = this.mNavigationBar.setTitleText("");
        this.dqt = this.mNavigationBar.addTextButtonByDefTextColor(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.dqr.getResources().getString(t.j.view_subject), this.bnn);
        this.dqt.setVisibility(8);
    }

    public void aR(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.dnR == null) {
            this.dnR = new Dialog(this.dqr.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.dnR.setCanceledOnTouchOutside(true);
            this.dnR.setCancelable(true);
            View inflate = LayoutInflater.from(this.dqr.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
            this.dqr.getLayoutMode().x(inflate);
            this.dnR.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.dnR.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.B(this.dqr.getPageContext().getPageActivity()) * 0.9d);
            this.dnR.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.dnR.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.dnR.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.dnR.findViewById(t.g.disable_reply_btn);
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
            textView3.setOnClickListener(new am(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.dnR, this.dqr.getPageContext());
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
        this.dnT = new com.baidu.tbadk.core.dialog.a(this.dqr.getPageContext().getPageActivity());
        this.dnT.bM(i3);
        this.dnT.x(sparseArray);
        this.dnT.a(t.j.dialog_ok, new aa(this, sparseArray));
        this.dnT.b(t.j.dialog_cancel, new ab(this));
        this.dnT.ap(true);
        this.dnT.b(this.dqr.getPageContext());
        this.dnT.rU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gR(boolean z) {
        if (this.zu != null) {
            if (!z) {
                this.zu.setEnabled(z);
            } else {
                this.zu.postDelayed(new ac(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.dol != null) {
            this.dol.dismiss();
            this.dol = null;
        }
        if (z) {
            string = this.dqr.getResources().getString(t.j.remove_mark);
        } else {
            string = this.dqr.getResources().getString(t.j.mark);
        }
        this.dol = new com.baidu.tbadk.core.dialog.c(this.dqr.getPageContext().getPageActivity());
        this.dol.bP(t.j.operation);
        this.dol.a(new String[]{this.dqr.getResources().getString(t.j.copy), string}, bVar);
        this.dol.d(this.dqr.getPageContext());
        this.dol.rX();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.dqG = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.dqH = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.bDI != null) {
            this.bDI.setVisibility(8);
        }
        if (z && z2) {
            this.dqr.showToast(this.dqr.getResources().getString(t.j.success));
        } else if (str != null && z2) {
            this.dqr.showToast(str);
        }
    }

    public void aQ(View view) {
        if (this.bbZ != null && this.mNavigationBar != null) {
            if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
                this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
                if (UtilHelper.canUseStyleImmersiveSticky()) {
                    this.bbZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight()));
                } else if (this.zu != null) {
                    this.zu.removeHeaderView(this.bbZ);
                }
                this.mNavigationBar.setVisibility(8);
                return;
            }
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                this.bbZ.setLayoutParams(new AbsListView.LayoutParams(-1, UtilHelper.getLightStatusBarHeight() + com.baidu.adp.lib.util.k.c(this.dqr.getActivity(), t.e.ds98)));
            } else if (this.zu != null) {
                this.zu.f(this.bbZ, 0);
            }
            this.mNavigationBar.setVisibility(0);
        }
    }

    public void e(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Bb() != null) {
            this.czd = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.ddG.addView(pVar.Bb(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new ad(this, view, i), 300L);
    }

    public void gr(boolean z) {
        this.dfJ = z;
        this.dqq.gr(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.zu.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.zu.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.ddG;
    }

    public void by(String str, String str2) {
        this.dqK = str2;
        new Handler().postDelayed(new ae(this, str2, str), 200L);
    }

    public void amQ() {
        if (this.dqD != null) {
            com.baidu.adp.lib.h.j.a(this.dqD, this.dqr.getPageContext().getPageActivity());
        }
        if (this.dol != null) {
            this.dol.dismiss();
        }
        if (this.dnT != null) {
            this.dnT.dismiss();
        }
        if (this.dnR != null) {
            com.baidu.adp.lib.h.j.b(this.dnR, this.dqr.getPageContext());
        }
        if (this.bDI != null) {
            this.bDI.setVisibility(8);
        }
        if (this.diU != null) {
            this.diU.dismiss();
        }
    }

    public void azU() {
        this.zu.setNextPage(this.dqC);
        this.dqC.vg();
    }

    public void gq(boolean z) {
        this.dfI = z;
    }

    public void a(com.baidu.tieba.pb.data.h hVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z2 = false;
        if (hVar != null) {
            this.dqL = hVar;
            this.dqq.l(this.dqL.Kl());
            if (this.dqp != null) {
                this.dqp.setVisibility(0);
            }
            if (this.dqs != null) {
                this.dqs.setVisibility(0);
            }
            if (hVar.avO() != null) {
                this.dqI = hVar.avO().getId();
                this.aDU = hVar.avO().aTS();
                if (this.aDU > 0) {
                    this.RX.setText(String.format(this.dqr.getPageContext().getString(t.j.is_floor), Integer.valueOf(this.aDU)));
                } else {
                    this.RX.setText((CharSequence) null);
                }
            }
            if (hVar.hasMore()) {
                this.dqC.vg();
                this.dqq.setHasMoreData(true);
            } else {
                this.dqC.vh();
                this.dqq.setHasMoreData(false);
            }
            this.dqJ = hVar.avS();
            if (this.dqJ == null || this.dqJ.size() == 0) {
                this.zu.setNextPage(null);
            } else {
                this.zu.setNextPage(this.dqC);
            }
            if (this.dqJ == null || this.dqJ.size() <= dqo) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.dqJ.size() - dqo;
                ma(size);
                int firstVisiblePosition = this.zu.getFirstVisiblePosition() - size;
                View childAt = this.zu.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.dqq.setDatas(this.dqJ);
            if (hVar.Kl() != null && hVar.Kl().getAuthor() != null && (userId = hVar.Kl().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.dqq.v(i, z2);
            this.dqq.notifyDataSetChanged();
            a(hVar.avO(), hVar.ahN(), hVar.mP(), i, z);
            if (i4 > 0) {
                this.zu.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View azV() {
        return this.dht;
    }

    private void ma(int i) {
        if (this.dqJ != null) {
            if (this.dqJ.size() <= i) {
                this.dqJ.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.s> it = this.dqJ.iterator();
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

    public boolean azW() {
        return this.dqq.aTQ;
    }

    private int m(List<com.baidu.tieba.tbadkCore.data.k> list, int i) {
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
            if (this.dqz == null) {
                this.dqz = (PbNewChudianCommonView) this.dqp.findViewById(t.g.subpb_newchudian_common);
            }
            if (this.dqA == null) {
                this.dqA = (CoverFlowView) this.dqp.findViewById(t.g.subpb_newchudian_coverflowview);
            }
            at.c(this.dqy, t.f.icon_tuiguang);
            this.dqy.setVisibility(0);
            this.dqz.setVisibility(0);
            this.dqz.a(iVar, this.dqr, this.ddo);
            if (!com.baidu.adp.lib.g.c.dF().V(17)) {
                at.c(this.dqB, t.d.cp_cont_b, 1);
                this.dqB.setVisibility(0);
                return;
            }
            List<com.baidu.tieba.tbadkCore.data.k> aTt = iVar.aTt();
            if (aTt != null && aTt.size() > 0) {
                Context context = this.dqr.getPageContext().getContext();
                com.baidu.adp.lib.util.k.c(context, t.e.ds320);
                int B = (com.baidu.adp.lib.util.k.B(context) - com.baidu.adp.lib.util.k.c(context, t.e.ds104)) - com.baidu.adp.lib.util.k.c(context, t.e.ds32);
                int i = (int) (B / 1.7777778f);
                int m = m(aTt, B);
                if (i > m) {
                    i = m;
                }
                com.baidu.tieba.pb.view.m mVar = new com.baidu.tieba.pb.view.m(context, this.ddo);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                mVar.setLayoutParams(layoutParams);
                this.dqA.setCallback(new com.baidu.tieba.pb.d(mVar, context, this.ddo));
                this.dqA.setVisibility(0);
                if (aTt.size() > 3) {
                    aTt = aTt.subList(0, 3);
                }
                this.dqA.setDisableParentEvent(true);
                com.baidu.tieba.tbadkCore.data.k kVar = aTt.get(0);
                if (!ay.isEmpty(kVar.aTy())) {
                    mVar.dsB.setText(kVar.aTy());
                    mVar.dsB.setVisibility(0);
                } else {
                    mVar.dsB.setVisibility(8);
                }
                if (!ay.isEmpty(kVar.getSubTitle())) {
                    mVar.dsC.setText(kVar.getSubTitle());
                    mVar.dsC.setVisibility(0);
                } else {
                    mVar.dsC.setVisibility(8);
                }
                if (mVar.dsB.getVisibility() != 0 && mVar.dsC.getVisibility() != 0) {
                    mVar.setVisibility(8);
                } else {
                    mVar.as(kVar.oU(), 1);
                }
                this.dqA.setCoverFlowFactory(new com.baidu.tieba.pb.e(mVar, i));
                this.dqA.setData(aTt);
            }
        }
    }

    protected void a(com.baidu.tieba.tbadkCore.data.s sVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (sVar != null) {
            this.dfs = sVar;
            com.baidu.tieba.tbadkCore.data.i aUc = sVar.aUc();
            if (aUc != null && aUc.esx) {
                int aTv = aUc.aTv();
                if (aTv == 2 || aTv == 1) {
                    this.dkD.setVisibility(8);
                    a(aUc);
                } else {
                    this.dkD.setVisibility(0);
                    this.dkH.setBackgroundDrawable(at.getDrawable(t.f.icon_tuiguang));
                    String position = aUc.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.dkE.setVisibility(0);
                        this.dkG.setText(position);
                    }
                    this.dfT.setOnLinkImageClickListener(this.dqg);
                    this.dfT.setOnImageClickListener(this.dqh);
                }
            } else {
                this.dkD.setVisibility(8);
                if (z3) {
                    this.dfT.setOnImageClickListener(this.dqh);
                }
            }
            this.dhm.setTag(null);
            this.dhm.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.dqp.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.dqp.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(t.g.tag_clip_board, sVar);
            sparseArray.put(t.g.tag_is_subpb, false);
            a(sVar, i, sparseArray);
            this.dqw.setTag(sparseArray);
            this.dht.setTag(sparseArray);
            this.aLz.setOnClickListener(this.bnn);
            this.aLz.setText((CharSequence) null);
            this.dhs.setVisibility(8);
            this.dqv.setText((CharSequence) null);
            this.dqw.setOnClickListener(this.bnn);
            this.dht.setOnClickListener(this.bnn);
            at.c(this.dhr, t.d.pb_listitem_post_time, 1);
            this.dhr.setText(ay.x(sVar.getTime()));
            if (z) {
                this.dhs.setVisibility(0);
                at.c(this.dhs, t.f.icon_floorhost);
                this.dhs.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
            }
            if (this.dfI) {
                i2 = t.f.img_default_100;
            } else {
                i2 = t.f.icon_click;
            }
            this.dfT.setDefaultImageId(i2);
            this.dqv.setText(String.format(this.dqr.getPageContext().getString(t.j.is_floor), Integer.valueOf(sVar.aTS())));
            String portrait = sVar.getAuthor().getPortrait();
            if (sVar.getAuthor() != null) {
                String name_show = sVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.u.gp(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.u.d(name_show, 0, 14)) + "...";
                }
                this.aLz.setText(name_show);
                ArrayList<IconData> tShowInfoNew = sVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    at.c(this.aLz, t.d.cp_cont_h, 1);
                } else {
                    at.c(this.aLz, t.d.cp_cont_f, 1);
                }
                int level_id = sVar.getAuthor().getLevel_id();
                int is_bawu = sVar.getAuthor().getIs_bawu();
                String bawu_type = sVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !ek.g(this.dfs)) {
                    this.dhn.setVisibility(0);
                    at.c(this.dhn, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.dhn.setContentDescription(String.format(TbadkCoreApplication.m11getInst().getString(t.j.degree_in_forum), Integer.valueOf(level_id)));
                    this.dhn.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                    this.dhn.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.dhn.setVisibility(8);
                }
                int i4 = this.dqy.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.dhn.setOnClickListener(this.bnn);
                    if (bawu_type.equals("manager")) {
                        at.c(this.dhn, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        at.c(this.dhn, t.f.pb_assist);
                    }
                }
                if (sVar.getAuthor().getGender() == 2) {
                    at.c(this.dhp, t.f.icon_pb_pop_girl);
                    this.dhp.setVisibility(0);
                } else if (sVar.getAuthor().getGender() == 1) {
                    at.c(this.dhp, t.f.icon_pb_pop_boy);
                    this.dhp.setVisibility(0);
                } else {
                    this.dhp.setVisibility(8);
                }
                this.dhp.setAlpha(TransportMediator.KEYCODE_MEDIA_RECORD);
                this.dhb = sVar.getAuthor().getIconInfo();
                this.bfm = sVar.getAuthor().getTShowInfoNew();
                if (this.bvy != null) {
                    if (ek.g(sVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.dhb.size()) {
                                break;
                            }
                            IconData iconData = this.dhb.get(i6);
                            if (!ay.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.dhb = arrayList;
                    }
                    this.bvy.setOnClickListener(this.bnn);
                    this.bvy.vv();
                    this.bvy.a(this.dhb, i4, this.dqr.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.dqr.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.dqr.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (this.adH != null) {
                    this.adH.setOnClickListener(this.bnn);
                    if (this.bfm != null && this.bfm.size() > 0 && this.bfm.get(0) != null) {
                        this.adH.setTag(this.bfm.get(0).getUrl());
                    }
                    this.adH.a(this.bfm, 2, this.dqr.getResources().getDimensionPixelSize(t.e.ds30), this.dqr.getResources().getDimensionPixelSize(t.e.small_icon_height), this.dqr.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                }
            }
            a(this.dfT, 0);
            if (sVar.getAuthor().getGodUserData().getId() != null && sVar.getAuthor().getGodUserData().getType() == 2) {
                this.dqu.setVisibility(0);
                this.dhm.setVisibility(4);
                this.dqu.setUserId(sVar.getAuthor().getUserId());
                this.dqu.setUserName(sVar.getAuthor().getUserName());
                this.dqu.c(portrait, 28, false);
            } else {
                this.dqu.setVisibility(8);
                this.dhm.setVisibility(0);
                this.dhm.setUserId(sVar.getAuthor().getUserId());
                this.dhm.setUserName(sVar.getAuthor().getUserName());
                this.dhm.setDefaultResource(t.f.transparent_bg);
                this.dhm.setDefaultErrorResource(t.f.icon_default_avatar100);
                this.dhm.c(portrait, 28, false);
            }
            if (!this.dfJ) {
                this.dhm.setVisibility(8);
                this.dqu.setVisibility(8);
            }
            this.aLz.setTag(t.g.tag_user_id, sVar.getAuthor().getUserId());
            this.aLz.setTag(t.g.tag_user_name, sVar.getAuthor().getUserName());
            this.dfT.setText(sVar.amw());
            if (!TextUtils.isEmpty(sVar.getBimg_url())) {
                this.dfT.setBackgroundDrawable(null);
                this.dfT.setTag(sVar.getBimg_url());
                this.dfT.setOnClickListener(this.bnn);
                this.dfT.setTextViewOnClickListener(this.bnn);
                this.dfT.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.dF().a(sVar.getBimg_url(), 19, new af(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dfT.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.dfT.setPadding(0, 0, 0, 0);
                this.dfT.setLayoutParams(layoutParams);
                this.dfT.setBackgroundDrawable(null);
            }
            if (sVar != null) {
                com.baidu.tieba.pb.view.n.a(sVar.aAC(), this.dqx, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth);
            this.dfT.setMaxImageHeight((int) (this.maxImageWidth * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.dqr.getPageContext().getString(t.j.refresh_view_title_text), this.KH));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.dqr.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.dqs, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, t.f.pic_emotion07, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds320), com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds480), com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds360)), dVar, a, false);
        }
        this.dqs.setVisibility(0);
        this.zu.setVisibility(8);
        this.bDI.setVisibility(8);
        this.czd.Cl();
        at.l(this.mNoDataView, t.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.dqr.getPageContext(), TbadkCoreApplication.m11getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void hc(int i) {
        a(NoDataViewFactory.d.v(i, t.j.refresh_view_title_text));
    }

    public void mj(String str) {
        a(NoDataViewFactory.d.ag(str, this.dqr.getPageContext().getString(t.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.zu.setVisibility(0);
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
            if (this.dqL != null && this.dqL.Kl() != null && this.dqL.Kl().getAuthor() != null && sVar.getAuthor() != null) {
                String userId3 = this.dqL.Kl().getAuthor().getUserId();
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
                    int i2 = sVar.aTS() != 1 ? 0 : 1;
                    if (ek.g(sVar)) {
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
                        if (this.dqL.Kl() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.dqL.Kl().getId());
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
            if (sVar.aTS() != 1) {
            }
            if (ek.g(sVar)) {
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

    public void a(View view, boolean z, boolean z2) {
        this.diU = new dd(this.dqr.getPageContext(), this.bnn);
        this.diU.gI(TbadkCoreApplication.isLogin());
        if (view != null && view.getTag() != null) {
            SparseArray sparseArray = (SparseArray) view.getTag();
            com.baidu.tieba.tbadkCore.data.s sVar = sparseArray.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray.get(t.g.tag_clip_board) : null;
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(t.g.tag_clip_board, sVar);
            sparseArray2.put(t.g.tag_is_subpb, false);
            this.diU.axY().setTag(sparseArray2);
            if (z2) {
                this.diU.axY().setText(t.j.remove_mark);
            } else {
                this.diU.axY().setText(t.j.mark);
            }
            SparseArray sparseArray3 = (SparseArray) view.getTag();
            boolean booleanValue = sparseArray3.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(t.g.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue2 = sparseArray3.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray3.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            if (sparseArray3.get(t.g.tag_del_post_is_self) instanceof Boolean) {
                ((Boolean) sparseArray3.get(t.g.tag_del_post_is_self)).booleanValue();
            }
            if (sparseArray3.get(t.g.tag_forbid_user_post_id) instanceof String) {
                String str = (String) sparseArray3.get(t.g.tag_forbid_user_post_id);
            }
            if (booleanValue) {
                this.diU.axZ().setText(t.j.manage);
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
                this.diU.axZ().setTag(sparseArray4);
                this.diU.axZ().setVisibility(0);
            } else {
                this.diU.axZ().setVisibility(8);
            }
            this.diU.ayb().setVisibility(8);
            SparseArray sparseArray5 = (SparseArray) view.getTag();
            boolean booleanValue3 = sparseArray5.get(t.g.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(t.g.tag_user_mute_visible)).booleanValue() : false;
            if (!(sparseArray5.get(t.g.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray5.get(t.g.tag_should_manage_visible)).booleanValue() : false) && booleanValue3) {
                SparseArray sparseArray6 = new SparseArray();
                sparseArray6.put(t.g.tag_user_mute_visible, true);
                sparseArray6.put(t.g.tag_is_mem, sparseArray5.get(t.g.tag_is_mem));
                sparseArray6.put(t.g.tag_user_mute_mute_userid, sparseArray5.get(t.g.tag_user_mute_mute_userid));
                sparseArray6.put(t.g.tag_user_mute_mute_username, sparseArray5.get(t.g.tag_user_mute_mute_username));
                sparseArray6.put(t.g.tag_user_mute_post_id, sparseArray5.get(t.g.tag_user_mute_post_id));
                sparseArray6.put(t.g.tag_user_mute_thread_id, sparseArray5.get(t.g.tag_user_mute_thread_id));
                sparseArray6.put(t.g.tag_del_post_is_self, sparseArray5.get(t.g.tag_del_post_is_self));
                sparseArray6.put(t.g.tag_del_post_type, sparseArray5.get(t.g.tag_del_post_type));
                sparseArray6.put(t.g.tag_del_post_id, sparseArray5.get(t.g.tag_del_post_id));
                sparseArray6.put(t.g.tag_manage_user_identity, sparseArray5.get(t.g.tag_manage_user_identity));
                this.diU.aya().setText(t.j.mute_option);
                this.diU.aya().setTag(sparseArray6);
                this.diU.aya().setVisibility(0);
                this.diU.axZ().setVisibility(8);
            } else {
                String str2 = sparseArray5.get(t.g.tag_forbid_user_post_id) instanceof String ? (String) sparseArray5.get(t.g.tag_forbid_user_post_id) : null;
                if (ek.g(sparseArray5.get(t.g.tag_clip_board) instanceof com.baidu.tieba.tbadkCore.data.s ? (com.baidu.tieba.tbadkCore.data.s) sparseArray5.get(t.g.tag_clip_board) : null) ? false : TbadkCoreApplication.isLogin() & z) {
                    this.diU.aya().setVisibility(0);
                    this.diU.aya().setTag(str2);
                } else {
                    this.diU.aya().setVisibility(8);
                }
            }
        }
        this.diU.ayc().setVisibility(8);
        this.diU.ayf();
        this.diU.uP();
    }

    public void he(boolean z) {
        if (this.diU != null && this.diU.axY() != null) {
            if (z) {
                this.diU.axY().setText(t.j.remove_mark);
            } else {
                this.diU.axY().setText(t.j.mark);
            }
            this.diU.uP();
        }
    }

    public View azX() {
        return this.dqF;
    }

    public void onChangeSkinType(int i) {
        this.dqr.getLayoutMode().ae(i == 1);
        this.dqr.getLayoutMode().x(this.ddG);
        this.dqr.getLayoutMode().x(this.dqp);
        this.mNavigationBar.onChangeSkinType(this.dqr.getPageContext(), i);
        if (this.dqt != null) {
            at.b(this.dqt, t.d.cp_cont_b, t.d.s_navbar_title_color);
        }
        this.bdb.onChangeSkinType(this.dqr.getPageContext(), i);
        this.dqr.getLayoutMode().x(this.dqF);
        at.c(this.dht, t.f.icon_pb_reply_btn_selector);
        at.c(this.dqw, t.f.btn_pb_more_btn_selector);
        this.dfT.setTextColor(at.getColor(t.d.pb_listitem_content));
        this.dfT.setVideoImageId(t.f.pic_video);
        if (this.czd != null && this.czd.Bb() != null) {
            this.czd.Bb().onChangeSkinType(i);
        }
    }

    public void azY() {
        this.bDI.setVisibility(0);
    }

    public void azZ() {
        this.zu.setVisibility(0);
        this.bDI.setVisibility(8);
        this.dqC.vh();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aZy = onLongClickListener;
        this.dqp.setOnLongClickListener(this.aZy);
    }

    public View aAa() {
        return this.dqp;
    }

    public void mk(String str) {
        int ml = this.dqq.ml(str);
        if (ml > -1) {
            this.zu.setSelection(ml + 1);
            this.zu.invalidate();
        }
    }

    public View aAb() {
        return this.dqt;
    }

    public MorePopupWindow aAc() {
        return this.dqD;
    }

    public HeadImageView aAd() {
        return this.dhm;
    }

    public ClickableHeaderImageView aAe() {
        return this.dqu;
    }

    public TextView getUserNameView() {
        return this.aLz;
    }

    public UserIconBox aAf() {
        return this.bvy;
    }

    public ImageView aAg() {
        return this.dhn;
    }

    public UserIconBox aAh() {
        return this.adH;
    }

    public void akv() {
        if (this.doA == null) {
            this.doA = new com.baidu.tbadk.core.view.b(this.dqr.getPageContext());
        }
        this.doA.aD(true);
    }

    public void azx() {
        if (this.doA != null) {
            this.doA.aD(false);
        }
    }

    public TextView aAi() {
        return this.dqx;
    }

    public TbRichTextView aAj() {
        return this.dfT;
    }

    public TextView aAk() {
        if (this.dfT == null) {
            return null;
        }
        return this.dfT.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.dqg = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.dqh = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.dfT != null) {
            this.dfT.setOnEmotionClickListener(cVar);
        }
    }

    public View QJ() {
        return this.dqw;
    }

    public dd aAl() {
        return this.diU;
    }
}
