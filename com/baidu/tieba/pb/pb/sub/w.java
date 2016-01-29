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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.GodHeadImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.a;
import com.baidu.tieba.pb.pb.main.dx;
import com.baidu.tieba.pb.pb.main.dy;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.view.PbNewChudianCommonView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class w {
    private static final int cTL = TbadkCoreApplication.m411getInst().getListItemRule().yf();
    private BdListView IY;
    private ProgressBar aNo;
    private NoNetworkView bcA;
    private View.OnClickListener bmy;
    private RelativeLayout cIc;
    public RelativeLayout cOk;
    public LinearLayout cOl;
    public ImageView cOm;
    public TextView cOn;
    public ImageView cOo;
    private com.baidu.tbadk.core.view.b cRG;
    private View cTM;
    private am cTN;
    private NewSubPbActivity cTO;
    private RelativeLayout cTP;
    private ImageView cTV;
    private TextView cTY;
    private an cTZ;
    private View cUc;
    private ArrayList<com.baidu.tieba.tbadkCore.data.r> cUh;
    private String cUi;
    private com.baidu.tieba.pb.a.d cUj;
    private int maxImageWidth;
    private com.baidu.tbadk.core.view.o mNoDataView = null;
    private TbRichTextView.d cTE = null;
    private View.OnClickListener Ss = null;
    private TbRichTextView.e cTD = null;
    private NavigationBar mNavigationBar = null;
    private TextView cTQ = null;
    private TextView Yu = null;
    private HeadImageView cLD = null;
    private GodHeadImageView cTR = null;
    private TextView aMu = null;
    private ImageView cLE = null;
    private ImageView cLG = null;
    private TextView cTS = null;
    private ImageView cLJ = null;
    private TextView cLI = null;
    private TbRichTextView cKi = null;
    private ImageView cLK = null;
    private TextView cTT = null;
    private TextView cTU = null;
    private PbNewChudianCommonView cTW = null;
    private CoverFlowView<com.baidu.tieba.tbadkCore.data.j> cTX = null;
    private MorePopupWindow cUa = null;
    private dx cUb = null;
    private com.baidu.tbadk.core.dialog.c cRs = null;
    private UserIconBox bqH = null;
    private UserIconBox ahI = null;
    private Dialog cQZ = null;
    private com.baidu.tbadk.core.dialog.a cRb = null;
    private boolean cJX = true;
    private boolean cJY = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aZg = null;
    private NewSubPbActivity.a cUd = null;
    private NewSubPbActivity.a cUe = null;
    private ArrayList<IconData> cLs = null;
    private ArrayList<IconData> beA = null;
    private com.baidu.tbadk.editortools.d.p cnC = null;
    private String cUf = null;
    private int cUg = 0;
    private com.baidu.tieba.tbadkCore.data.r cJH = null;
    protected HashMap<Long, HashSet<String>> cPz = new HashMap<>();
    protected final a.InterfaceC0074a cHL = new x(this);
    private View.OnClickListener cLt = new ae(this);
    private com.baidu.tieba.pb.b.c cKb = new com.baidu.tieba.pb.b.c(new af(this));
    protected AdapterView.OnItemClickListener cUk = new ag(this);
    protected AdapterView.OnItemLongClickListener It = new ah(this);

    public w(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cIc = null;
        this.cTM = null;
        this.IY = null;
        this.cTN = null;
        this.cTO = null;
        this.bcA = null;
        this.cTP = null;
        this.cTZ = null;
        this.cUc = null;
        this.bmy = null;
        this.aNo = null;
        this.cTO = newSubPbActivity;
        this.bmy = onClickListener;
        this.cIc = (RelativeLayout) LayoutInflater.from(this.cTO.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_layout, (ViewGroup) null);
        this.cTM = LayoutInflater.from(this.cTO.getPageContext().getPageActivity()).inflate(t.h.new_sub_pb_head, (ViewGroup) null);
        this.bcA = (NoNetworkView) this.cIc.findViewById(t.g.view_no_network);
        this.maxImageWidth = com.baidu.adp.lib.util.k.K(this.cTO.getBaseContext()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(t.e.ds60);
        asb();
        MW();
        this.cTP = (RelativeLayout) this.cIc.findViewById(t.g.sub_pb_body_layout);
        this.IY = (BdListView) this.cIc.findViewById(t.g.new_sub_pb_list);
        this.IY.addHeaderView(this.cTM);
        this.cTN = new am(this.cTO.getPageContext().getPageActivity());
        this.cTN.J(this.cLt);
        this.cTN.setIsFromCDN(this.mIsFromCDN);
        this.IY.setAdapter((ListAdapter) this.cTN);
        this.cTZ = new an(this.cTO.getPageContext());
        this.cUc = this.cTZ.getView();
        this.IY.setNextPage(this.cTZ);
        this.cTZ.setOnClickListener(this.bmy);
        this.IY.setOnItemClickListener(this.cUk);
        this.IY.setOnItemLongClickListener(this.It);
        this.IY.setOnTouchListener(this.cKb);
        this.aNo = (ProgressBar) this.cIc.findViewById(t.g.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cTM != null) {
            this.cTM.setVisibility(4);
        }
        if (this.cTP != null) {
            this.cTP.setVisibility(4);
        }
    }

    public void MW() {
        this.cLD = (HeadImageView) this.cTM.findViewById(t.g.photo);
        this.cLD.setOnClickListener(this.bmy);
        this.cTR = (GodHeadImageView) this.cTM.findViewById(t.g.god_user_photo);
        this.cTR.setOnClickListener(this.bmy);
        this.aMu = (TextView) this.cTM.findViewById(t.g.user_name);
        this.cLE = (ImageView) this.cTM.findViewById(t.g.user_rank);
        this.cLG = (ImageView) this.cTM.findViewById(t.g.user_gender);
        this.cLK = (ImageView) this.cTM.findViewById(t.g.reply);
        this.cTT = (TextView) this.cTM.findViewById(t.g.manage_btn);
        this.cTS = (TextView) this.cTM.findViewById(t.g.floor);
        this.cLJ = (ImageView) this.cTM.findViewById(t.g.floor_owner);
        this.cLI = (TextView) this.cTM.findViewById(t.g.time);
        this.bqH = (UserIconBox) this.cTM.findViewById(t.g.user_icon_box);
        this.ahI = (UserIconBox) this.cTM.findViewById(t.g.user_tshow_icon_box);
        this.cKi = (TbRichTextView) this.cTM.findViewById(t.g.richText);
        this.cKi.HC();
        this.cKi.g(this.cJX, true);
        this.cKi.setIsFromCDN(this.mIsFromCDN);
        this.cKi.setImageViewStretch(true);
        this.cKi.setTextSize(TbConfig.getContentSize());
        this.cKi.setVoiceViewRes(t.h.voice_play_btn);
        this.cTM.setOnTouchListener(this.cKb);
        this.cTM.setOnClickListener(this.bmy);
        this.cTU = (TextView) this.cTM.findViewById(t.g.pb_item_tail_content);
        this.cTU.setOnClickListener(this.bmy);
        this.cOk = (RelativeLayout) this.cTM.findViewById(t.g.chudian_info_container);
        this.cOl = (LinearLayout) this.cTM.findViewById(t.g.landmark_container);
        this.cOm = (ImageView) this.cTM.findViewById(t.g.landmark_icon);
        this.cOn = (TextView) this.cTM.findViewById(t.g.landmark_content);
        this.cOo = (ImageView) this.cTM.findViewById(t.g.ad_icon);
        this.cTV = (ImageView) this.cTM.findViewById(t.g.subpb_newchudian_advertise);
        this.cTY = (TextView) this.cTM.findViewById(t.g.chudian_pic);
    }

    public void asb() {
        this.mNavigationBar = (NavigationBar) this.cIc.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.Yu = this.mNavigationBar.setTitleText("");
        this.cTQ = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cTO.getResources().getString(t.j.view_subject), this.bmy);
        this.cTQ.setVisibility(8);
    }

    public void apm() {
        this.cUb = new dx(this.cTO.getPageContext(), this.bmy);
        this.cUb.fv(TbadkCoreApplication.isLogin());
        this.cUa = new MorePopupWindow(this.cTO.getPageContext().getPageActivity(), this.cUb.getView(), this.cTO.getResources().getDrawable(t.f.bg_collect), null);
        this.cUa.setTouchInterceptor(new ai(this));
        this.cUa.onChangeSkinType(this.cTO, TbadkCoreApplication.m411getInst().getSkinType(), ar.getDrawable(t.f.bg_collect));
    }

    public void aF(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cQZ == null) {
            this.cQZ = new Dialog(this.cTO.getPageContext().getPageActivity(), t.k.common_alert_dialog);
            this.cQZ.setCanceledOnTouchOutside(true);
            this.cQZ.setCancelable(true);
            View inflate = LayoutInflater.from(this.cTO.getPageContext().getPageActivity()).inflate(t.h.forum_manage_dialog, (ViewGroup) null);
            this.cTO.getLayoutMode().x(inflate);
            this.cQZ.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cQZ.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cTO.getPageContext().getPageActivity()) * 0.9d);
            this.cQZ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cQZ.findViewById(t.g.del_post_btn);
        TextView textView2 = (TextView) this.cQZ.findViewById(t.g.forbid_user_btn);
        TextView textView3 = (TextView) this.cQZ.findViewById(t.g.disable_reply_btn);
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
            textView.setOnClickListener(new aj(this));
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
            textView2.setOnClickListener(new ak(this));
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
            textView3.setOnClickListener(new al(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.cQZ, this.cTO.getPageContext());
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
        this.cRb = new com.baidu.tbadk.core.dialog.a(this.cTO.getPageContext().getPageActivity());
        this.cRb.bY(i3);
        this.cRb.x(sparseArray);
        this.cRb.a(t.j.dialog_ok, new y(this, sparseArray));
        this.cRb.b(t.j.dialog_cancel, new z(this));
        this.cRb.aj(true);
        this.cRb.b(this.cTO.getPageContext());
        this.cRb.uj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        if (this.IY != null) {
            if (!z) {
                this.IY.setEnabled(z);
            } else {
                this.IY.postDelayed(new aa(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.cRs != null) {
            this.cRs.dismiss();
            this.cRs = null;
        }
        if (z) {
            string = this.cTO.getResources().getString(t.j.remove_mark);
        } else {
            string = this.cTO.getResources().getString(t.j.mark);
        }
        this.cRs = new com.baidu.tbadk.core.dialog.c(this.cTO.getPageContext().getPageActivity());
        this.cRs.cb(t.j.operation);
        this.cRs.a(new String[]{this.cTO.getResources().getString(t.j.copy), string}, bVar);
        this.cRs.d(this.cTO.getPageContext());
        this.cRs.un();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cUd = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.cUe = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.aNo != null) {
            this.aNo.setVisibility(8);
        }
        if (z && z2) {
            this.cTO.showToast(this.cTO.getResources().getString(t.j.success));
        } else if (str != null && z2) {
            this.cTO.showToast(str);
        }
    }

    public void aE(View view) {
        if (this.mNavigationBar.isNavigationBarExcludeStatusbarVisible()) {
            this.mNavigationBar.showNavigationBarExcludeStatusbar(false);
        } else {
            this.mNavigationBar.showNavigationBarExcludeStatusbar(true);
        }
    }

    public void e(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Cz() != null) {
            this.cnC = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cIc.addView(pVar.Cz(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i, View view) {
        new Handler().postDelayed(new ab(this, view, i), 300L);
    }

    public void fh(boolean z) {
        this.cJY = z;
        this.cTN.fh(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.IY.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.IY.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.cIc;
    }

    public void bd(String str, String str2) {
        this.cUi = str2;
        new Handler().postDelayed(new ac(this, str2, str), 200L);
    }

    public void ajp() {
        if (this.cUa != null) {
            com.baidu.adp.lib.h.j.a(this.cUa, this.cTO.getPageContext().getPageActivity());
        }
        if (this.cRs != null) {
            this.cRs.dismiss();
        }
        if (this.cRb != null) {
            this.cRb.dismiss();
        }
        if (this.cQZ != null) {
            com.baidu.adp.lib.h.j.b(this.cQZ, this.cTO.getPageContext());
        }
        if (this.aNo != null) {
            this.aNo.setVisibility(8);
        }
    }

    public void asc() {
        this.IY.setNextPage(this.cTZ);
        this.cTZ.xb();
    }

    public void fg(boolean z) {
        this.cJX = z;
    }

    public void a(com.baidu.tieba.pb.a.d dVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z2 = false;
        if (dVar != null) {
            this.cUj = dVar;
            this.cTN.h(this.cUj.Ki());
            if (this.cTM != null) {
                this.cTM.setVisibility(0);
            }
            if (this.cTP != null) {
                this.cTP.setVisibility(0);
            }
            if (dVar.aoQ() != null) {
                this.cUf = dVar.aoQ().getId();
                this.cUg = dVar.aoQ().aMw();
                if (this.cUg > 0) {
                    this.Yu.setText(String.format(this.cTO.getPageContext().getString(t.j.is_floor), Integer.valueOf(this.cUg)));
                } else {
                    this.Yu.setText((CharSequence) null);
                }
            }
            if (dVar.hasMore()) {
                this.cTZ.xb();
                this.cTN.setHasMoreData(true);
            } else {
                this.cTZ.xc();
                this.cTN.setHasMoreData(false);
            }
            this.cUh = dVar.aoU();
            if (this.cUh == null || this.cUh.size() == 0) {
                this.IY.setNextPage(null);
            } else {
                this.IY.setNextPage(this.cTZ);
            }
            if (this.cUh == null || this.cUh.size() <= cTL) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.cUh.size() - cTL;
                lg(size);
                int firstVisiblePosition = this.IY.getFirstVisiblePosition() - size;
                View childAt = this.IY.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            this.cTN.setDatas(this.cUh);
            if (dVar.Ki() != null && dVar.Ki().getAuthor() != null && (userId = dVar.Ki().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z2 = true;
            }
            this.cTN.t(i, z2);
            this.cTN.notifyDataSetChanged();
            a(dVar.aoQ(), dVar.aen(), dVar.qg(), i, z);
            if (i4 > 0) {
                this.IY.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View asd() {
        return this.cLK;
    }

    private void lg(int i) {
        if (this.cUh != null) {
            if (this.cUh.size() <= i) {
                this.cUh.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.r> it = this.cUh.iterator();
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

    public boolean ase() {
        return this.cTN.aUl;
    }

    private int h(List<com.baidu.tieba.tbadkCore.data.j> list, int i) {
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
            if (this.cTW == null) {
                this.cTW = (PbNewChudianCommonView) this.cTM.findViewById(t.g.subpb_newchudian_common);
            }
            if (this.cTX == null) {
                this.cTX = (CoverFlowView) this.cTM.findViewById(t.g.subpb_newchudian_coverflowview);
            }
            ar.c(this.cTV, t.f.icon_tuiguang);
            this.cTV.setVisibility(0);
            this.cTW.a(hVar, this.cTO, this.cHL);
            if (!com.baidu.adp.lib.g.c.hl().ai(17)) {
                ar.b(this.cTY, t.d.cp_cont_b, 1);
                this.cTY.setVisibility(0);
                return;
            }
            List<com.baidu.tieba.tbadkCore.data.j> aLX = hVar.aLX();
            if (aLX != null && aLX.size() > 0) {
                Context context = this.cTO.getPageContext().getContext();
                com.baidu.adp.lib.util.k.c(context, t.e.ds320);
                int K = (com.baidu.adp.lib.util.k.K(context) - com.baidu.adp.lib.util.k.c(context, t.e.ds104)) - com.baidu.adp.lib.util.k.c(context, t.e.ds32);
                int i = (int) (K / 1.7777778f);
                int h = h(aLX, K);
                if (i > h) {
                    i = h;
                }
                com.baidu.tieba.pb.view.g gVar = new com.baidu.tieba.pb.view.g(context, this.cHL);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, i, 0, 0);
                gVar.setLayoutParams(layoutParams);
                this.cTX.setCallback(new com.baidu.tieba.pb.c(gVar, context, this.cHL));
                this.cTX.setVisibility(0);
                if (aLX.size() > 3) {
                    aLX = aLX.subList(0, 3);
                }
                this.cTX.setDisableParentEvent(true);
                com.baidu.tieba.tbadkCore.data.j jVar = aLX.get(0);
                if (!aw.isEmpty(jVar.aMb())) {
                    gVar.cVC.setText(jVar.aMb());
                    gVar.cVC.setVisibility(0);
                } else {
                    gVar.cVC.setVisibility(8);
                }
                if (!aw.isEmpty(jVar.tV())) {
                    gVar.cVD.setText(jVar.tV());
                    gVar.cVD.setVisibility(0);
                } else {
                    gVar.cVD.setVisibility(8);
                }
                if (gVar.cVC.getVisibility() != 0 && gVar.cVD.getVisibility() != 0) {
                    gVar.setVisibility(8);
                } else {
                    gVar.af(jVar.rX(), 1);
                }
                this.cTX.setCoverFlowFactory(new com.baidu.tieba.pb.d(gVar, i));
                this.cTX.setData(aLX);
            }
        }
    }

    protected void a(com.baidu.tieba.tbadkCore.data.r rVar, boolean z, boolean z2, int i, boolean z3) {
        int i2;
        if (rVar != null) {
            this.cJH = rVar;
            com.baidu.tieba.tbadkCore.data.h aMF = rVar.aMF();
            if (aMF != null && aMF.dWF) {
                int aLZ = aMF.aLZ();
                if (aLZ == 2 || aLZ == 1) {
                    this.cOk.setVisibility(8);
                    a(aMF);
                } else {
                    this.cOk.setVisibility(0);
                    this.cOo.setBackgroundDrawable(ar.getDrawable(t.f.icon_tuiguang));
                    String position = aMF.getPosition();
                    if (!TextUtils.isEmpty(position)) {
                        this.cOl.setVisibility(0);
                        this.cOn.setText(position);
                    }
                    this.cKi.setOnLinkImageClickListener(this.cTD);
                    this.cKi.setOnImageClickListener(this.cTE);
                }
            } else {
                this.cOk.setVisibility(8);
                if (z3) {
                    this.cKi.setOnImageClickListener(this.cTE);
                }
            }
            this.cLD.setTag(null);
            this.cLD.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cTM.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cTM.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(t.g.tag_clip_board, rVar);
            sparseArray.put(t.g.tag_is_subpb, false);
            a(rVar, i, sparseArray);
            this.cLK.setTag(sparseArray);
            this.aMu.setOnClickListener(this.bmy);
            this.aMu.setText((CharSequence) null);
            this.cLJ.setVisibility(8);
            this.cTS.setText((CharSequence) null);
            this.cLK.setOnClickListener(this.bmy);
            ar.b(this.cLI, t.d.pb_listitem_post_time, 1);
            this.cLI.setText(aw.t(rVar.getTime()));
            if (z) {
                this.cLJ.setVisibility(0);
                ar.c(this.cLJ, t.f.icon_floorhost);
            }
            if (this.cJX) {
                i2 = t.f.img_default_100;
            } else {
                i2 = t.f.icon_click;
            }
            this.cKi.setDefaultImageId(i2);
            this.cTS.setText(String.format(this.cTO.getPageContext().getString(t.j.is_floor), Integer.valueOf(rVar.aMw())));
            String portrait = rVar.getAuthor().getPortrait();
            if (rVar.getAuthor() != null) {
                String name_show = rVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.o.gf(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.o.d(name_show, 0, 14)) + "...";
                }
                this.aMu.setText(name_show);
                ArrayList<IconData> tShowInfoNew = rVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    ar.b(this.aMu, t.d.cp_cont_h, 1);
                } else {
                    ar.b(this.aMu, t.d.cp_cont_f, 1);
                }
                int level_id = rVar.getAuthor().getLevel_id();
                int is_bawu = rVar.getAuthor().getIs_bawu();
                String bawu_type = rVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0 && !dy.g(this.cJH)) {
                    this.cLE.setVisibility(0);
                    ar.c(this.cLE, BitmapHelper.getSmallGradeResourceIdNew(level_id));
                    this.cLE.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.cLE.setVisibility(8);
                }
                int i4 = this.cTV.getVisibility() == 0 ? i3 - 1 : i3;
                if (is_bawu != 0) {
                    this.cLE.setOnClickListener(this.bmy);
                    if (bawu_type.equals("manager")) {
                        ar.c(this.cLE, t.f.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        ar.c(this.cLE, t.f.pb_assist);
                    }
                }
                if (rVar.getAuthor().getGender() == 2) {
                    ar.c(this.cLG, t.f.icon_pb_pop_girl);
                    this.cLG.setVisibility(0);
                } else if (rVar.getAuthor().getGender() == 1) {
                    ar.c(this.cLG, t.f.icon_pb_pop_boy);
                    this.cLG.setVisibility(0);
                } else {
                    this.cLG.setVisibility(8);
                }
                this.cLs = rVar.getAuthor().getIconInfo();
                this.beA = rVar.getAuthor().getTShowInfoNew();
                if (this.bqH != null) {
                    if (dy.g(rVar)) {
                        ArrayList<IconData> arrayList = new ArrayList<>();
                        int i5 = 0;
                        while (true) {
                            int i6 = i5;
                            if (i6 == this.cLs.size()) {
                                break;
                            }
                            IconData iconData = this.cLs.get(i6);
                            if (!aw.isEmpty(iconData.getIconName()) && iconData.getIconName().equals(IconData.redi_icon_name)) {
                                arrayList.add(iconData);
                            }
                            i5 = i6 + 1;
                        }
                        this.cLs = arrayList;
                    }
                    this.bqH.setOnClickListener(this.bmy);
                    this.bqH.a(this.cLs, i4, this.cTO.getResources().getDimensionPixelSize(t.e.pb_icon_width), this.cTO.getResources().getDimensionPixelSize(t.e.pb_icon_height), this.cTO.getResources().getDimensionPixelSize(t.e.pb_icon_margin));
                }
                if (this.ahI != null) {
                    this.ahI.setOnClickListener(this.bmy);
                    if (this.beA != null && this.beA.size() > 0 && this.beA.get(0) != null) {
                        this.ahI.setTag(this.beA.get(0).getUrl());
                    }
                    this.ahI.a(this.beA, 2, this.cTO.getResources().getDimensionPixelSize(t.e.ds30), this.cTO.getResources().getDimensionPixelSize(t.e.small_icon_height), this.cTO.getResources().getDimensionPixelSize(t.e.small_icon_margin), true);
                }
            }
            a(this.cKi, (int) this.cTO.getResources().getDimension(t.e.ds76));
            if (rVar.getAuthor().getGodUserData().getId() != null && rVar.getAuthor().getGodUserData().getType() == 2) {
                this.cTR.setVisibility(0);
                this.cLD.setVisibility(4);
                this.cTR.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
                this.cTR.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
                this.cTR.d(portrait, 28, false);
            } else {
                this.cTR.setVisibility(8);
                this.cLD.setVisibility(0);
                this.cLD.setUserId(rVar.getAuthor().getUserId());
                this.cLD.setUserName(rVar.getAuthor().getUserName());
                this.cLD.setDefaultResource(t.f.icon_default_avatar100);
                this.cLD.d(portrait, 28, false);
            }
            if (!this.cJY) {
                this.cLD.setVisibility(8);
                this.cTR.setVisibility(8);
            }
            this.aMu.setTag(t.g.tag_user_id, rVar.getAuthor().getUserId());
            this.aMu.setTag(t.g.tag_user_name, rVar.getAuthor().getUserName());
            this.cKi.setText(rVar.aiT());
            this.cTT.setVisibility(8);
            if (!TextUtils.isEmpty(rVar.getBimg_url())) {
                this.cKi.setBackgroundDrawable(null);
                this.cKi.setTag(rVar.getBimg_url());
                this.cKi.setOnClickListener(this.bmy);
                this.cKi.setTextViewOnClickListener(this.bmy);
                this.cKi.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.hl().a(rVar.getBimg_url(), 19, new ad(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cKi.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.cKi.setPadding(0, 0, 0, 0);
                this.cKi.setLayoutParams(layoutParams);
                this.cKi.setBackgroundDrawable(null);
            }
            if (rVar != null) {
                com.baidu.tieba.pb.view.h.a(rVar.asK(), this.cTU, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.maxImageWidth - i);
            this.cKi.setMaxImageHeight((int) ((this.maxImageWidth - i) * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cTO.getPageContext().getString(t.j.refresh_view_title_text), this.Ss));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.cTO.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.cTP, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.c(pageActivity, t.e.ds140)), dVar, a, false);
        }
        this.cTP.setVisibility(0);
        this.IY.setVisibility(8);
        this.aNo.setVisibility(8);
        this.cnC.DI();
        ar.l(this.mNoDataView, t.d.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.cTO.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fU(int i) {
        a(NoDataViewFactory.d.y(i, t.j.refresh_view_title_text));
    }

    public void hw(String str) {
        a(NoDataViewFactory.d.ac(str, this.cTO.getPageContext().getString(t.j.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.IY.setVisibility(0);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.Ss = onClickListener;
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
            if (this.cUj != null && this.cUj.Ki() != null && this.cUj.Ki().getAuthor() != null && rVar.getAuthor() != null) {
                String userId3 = this.cUj.Ki().getAuthor().getUserId();
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
                    int i2 = rVar.aMw() != 1 ? 0 : 1;
                    if (dy.g(rVar)) {
                        z6 = z2;
                    } else {
                        z3 = false;
                        z4 = false;
                        z6 = false;
                    }
                    if (!z6) {
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                        sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(t.g.tag_forbid_user_name, "");
                        z7 = false;
                    }
                    if (!z4) {
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_del_post_is_self, true);
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(t.g.tag_del_post_id, rVar.getId());
                        z7 = true;
                    } else {
                        sparseArray.put(t.g.tag_del_post_is_self, false);
                        sparseArray.put(t.g.tag_del_post_type, 0);
                        sparseArray.put(t.g.tag_del_post_id, "");
                    }
                    sparseArray.put(t.g.tag_should_manage_visible, Boolean.valueOf(z7));
                    sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
                    if (!z6) {
                        sparseArray.put(t.g.tag_should_manage_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(t.g.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(t.g.tag_user_mute_visible, true);
                        sparseArray.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (rVar.getAuthor() != null) {
                            sparseArray.put(t.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                            sparseArray.put(t.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                        }
                        if (this.cUj.Ki() != null) {
                            sparseArray.put(t.g.tag_user_mute_thread_id, this.cUj.Ki().getId());
                        }
                        sparseArray.put(t.g.tag_user_mute_post_id, rVar.getId());
                    } else {
                        sparseArray.put(t.g.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(t.g.tag_should_delete_visible, true);
                        sparseArray.put(t.g.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(t.g.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(t.g.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(t.g.tag_del_post_id, rVar.getId());
                        return;
                    }
                    sparseArray.put(t.g.tag_should_delete_visible, false);
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
            if (rVar.aMw() != 1) {
            }
            if (dy.g(rVar)) {
            }
            if (!z6) {
            }
            if (!z4) {
            }
            sparseArray.put(t.g.tag_should_manage_visible, Boolean.valueOf(z7));
            sparseArray.put(t.g.tag_forbid_user_post_id, rVar.getId());
            if (!z6) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View asf() {
        return this.cUc;
    }

    public void onChangeSkinType(int i) {
        this.cTO.getLayoutMode().ac(i == 1);
        this.cTO.getLayoutMode().x(this.cIc);
        this.cTO.getLayoutMode().x(this.cTM);
        this.mNavigationBar.onChangeSkinType(this.cTO.getPageContext(), i);
        this.bcA.onChangeSkinType(this.cTO.getPageContext(), i);
        this.cTO.getLayoutMode().x(this.cUc);
        ar.c(this.cLK, t.f.btn_pb_reply_selector);
        this.cKi.setTextColor(ar.getColor(t.d.pb_listitem_content));
        this.cKi.setVideoImageId(t.f.pic_video);
        if (this.cnC != null && this.cnC.Cz() != null) {
            this.cnC.Cz().onChangeSkinType(i);
        }
    }

    public void asg() {
        this.aNo.setVisibility(0);
    }

    public void ash() {
        this.IY.setVisibility(0);
        this.aNo.setVisibility(8);
        this.cTZ.xc();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aZg = onLongClickListener;
        this.cTM.setOnLongClickListener(this.aZg);
    }

    public View asi() {
        return this.cTM;
    }

    public void kS(String str) {
        int kT = this.cTN.kT(str);
        if (kT > -1) {
            this.IY.setSelection(kT + 1);
            this.IY.invalidate();
        }
    }

    public View asj() {
        return this.cTQ;
    }

    public dx ask() {
        return this.cUb;
    }

    public MorePopupWindow asl() {
        return this.cUa;
    }

    public HeadImageView asm() {
        return this.cLD;
    }

    public GodHeadImageView asn() {
        return this.cTR;
    }

    public TextView getUserNameView() {
        return this.aMu;
    }

    public UserIconBox aso() {
        return this.bqH;
    }

    public ImageView asp() {
        return this.cLE;
    }

    public UserIconBox asq() {
        return this.ahI;
    }

    public void agV() {
        if (this.cRG == null) {
            this.cRG = new com.baidu.tbadk.core.view.b(this.cTO.getPageContext());
        }
        this.cRG.aw(true);
    }

    public void arE() {
        if (this.cRG != null) {
            this.cRG.aw(false);
        }
    }

    public TextView asr() {
        return this.cTU;
    }

    public TbRichTextView ast() {
        return this.cKi;
    }

    public TextView asu() {
        if (this.cKi == null) {
            return null;
        }
        return this.cKi.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.cTD = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.cTE = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.cKi != null) {
            this.cKi.setOnEmotionClickListener(cVar);
        }
    }
}
