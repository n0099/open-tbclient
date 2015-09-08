package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.os.Handler;
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
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import com.baidu.tieba.pb.pb.main.bz;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class t {
    private static final int cgW = TbadkCoreApplication.m411getInst().getListItemRule().wC();
    private NoNetworkView aRT;
    private View.OnClickListener aZv;
    private RelativeLayout bZv;
    private com.baidu.tbadk.core.view.a cfT;
    private View cgX;
    private ai cgY;
    private NewSubPbActivity cgZ;
    private RelativeLayout cha;
    private aj chf;
    private View chg;
    private ArrayList<com.baidu.tieba.tbadkCore.data.i> chm;
    private String chn;
    private com.baidu.tieba.pb.a.c cho;
    private BdListView mListView;
    private ProgressBar mProgress;
    private com.baidu.tbadk.core.view.u mNoDataView = null;
    private View.OnClickListener Sv = null;
    private NavigationBar mNavigationBar = null;
    private TextView chb = null;
    private TextView WU = null;
    private HeadImageView cdS = null;
    private TextView aIV = null;
    private ImageView cdT = null;
    private ImageView cdU = null;
    private TextView chc = null;
    private ImageView cdX = null;
    private TextView cdW = null;
    private TbRichTextView cdZ = null;
    private ImageView cdY = null;
    private TextView chd = null;
    private TextView che = null;
    private MorePopupWindow cbP = null;
    private bz cbQ = null;
    private com.baidu.tbadk.core.dialog.c cfF = null;
    private UserIconBox bcI = null;
    private UserIconBox aUb = null;
    private Dialog cfm = null;
    private com.baidu.tbadk.core.dialog.a cfo = null;
    private boolean ccz = true;
    private boolean ccA = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener chh = null;
    private NewSubPbActivity.a chi = null;
    private NewSubPbActivity.a chj = null;
    private ArrayList<IconData> cdB = null;
    private ArrayList<IconData> aTJ = null;
    private com.baidu.tbadk.editortools.c.n bWV = null;
    private String chk = null;
    private int chl = 0;
    private View.OnClickListener ccE = new u(this);
    private com.baidu.tieba.pb.b.c cbW = new com.baidu.tieba.pb.b.c(new aa(this));
    protected AdapterView.OnItemClickListener chp = new ab(this);
    protected AdapterView.OnItemLongClickListener Hx = new ac(this);

    public t(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.bZv = null;
        this.cgX = null;
        this.mListView = null;
        this.cgY = null;
        this.cgZ = null;
        this.aRT = null;
        this.cha = null;
        this.chf = null;
        this.chg = null;
        this.aZv = null;
        this.mProgress = null;
        this.cgZ = newSubPbActivity;
        this.aZv = onClickListener;
        this.bZv = (RelativeLayout) LayoutInflater.from(this.cgZ.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_layout, (ViewGroup) null);
        this.cgX = LayoutInflater.from(this.cgZ.getPageContext().getPageActivity()).inflate(i.g.new_sub_pb_head, (ViewGroup) null);
        this.aRT = (NoNetworkView) this.bZv.findViewById(i.f.view_no_network);
        afk();
        HJ();
        this.cha = (RelativeLayout) this.bZv.findViewById(i.f.sub_pb_body_layout);
        this.mListView = (BdListView) this.bZv.findViewById(i.f.new_sub_pb_list);
        this.mListView.addHeaderView(this.cgX);
        this.cgY = new ai(this.cgZ.getPageContext().getPageActivity());
        this.cgY.C(this.ccE);
        this.cgY.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cgY);
        this.chf = new aj(this.cgZ.getPageContext());
        this.chg = this.chf.getView();
        this.mListView.setNextPage(this.chf);
        this.chf.setOnClickListener(this.aZv);
        this.mListView.setOnItemClickListener(this.chp);
        this.mListView.setOnItemLongClickListener(this.Hx);
        this.mListView.setOnTouchListener(this.cbW);
        this.mProgress = (ProgressBar) this.bZv.findViewById(i.f.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cgX != null) {
            this.cgX.setVisibility(4);
        }
        if (this.cha != null) {
            this.cha.setVisibility(4);
        }
    }

    public void HJ() {
        this.cdS = (HeadImageView) this.cgX.findViewById(i.f.photo);
        this.cdS.setOnClickListener(this.aZv);
        this.aIV = (TextView) this.cgX.findViewById(i.f.user_name);
        this.cdT = (ImageView) this.cgX.findViewById(i.f.user_rank);
        this.cdU = (ImageView) this.cgX.findViewById(i.f.user_gender);
        this.cdY = (ImageView) this.cgX.findViewById(i.f.reply);
        this.chd = (TextView) this.cgX.findViewById(i.f.manage_btn);
        this.chc = (TextView) this.cgX.findViewById(i.f.floor);
        this.cdX = (ImageView) this.cgX.findViewById(i.f.floor_owner);
        this.cdW = (TextView) this.cgX.findViewById(i.f.time);
        this.bcI = (UserIconBox) this.cgX.findViewById(i.f.user_icon_box);
        this.aUb = (UserIconBox) this.cgX.findViewById(i.f.user_tshow_icon_box);
        this.cdZ = (TbRichTextView) this.cgX.findViewById(i.f.richText);
        this.cdZ.FC();
        this.cdZ.f(this.ccz, true);
        this.cdZ.setIsFromCDN(this.mIsFromCDN);
        this.cdZ.setImageViewStretch(true);
        this.cdZ.setTextSize(TbConfig.getContentSize());
        this.cdZ.setVoiceViewRes(i.g.voice_play_btn);
        this.cgX.setOnTouchListener(this.cbW);
        this.cgX.setOnClickListener(this.aZv);
        this.che = (TextView) this.cgX.findViewById(i.f.pb_item_tail_content);
        this.che.setOnClickListener(this.aZv);
    }

    public void afk() {
        this.mNavigationBar = (NavigationBar) this.bZv.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.WU = this.mNavigationBar.setTitleText("");
        this.chb = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cgZ.getResources().getString(i.h.view_subject), this.aZv);
        this.chb.setVisibility(8);
    }

    public void adn() {
        this.cbQ = new bz(this.cgZ.getPageContext(), this.aZv);
        this.cbQ.ey(TbadkCoreApplication.isLogin());
        this.cbP = new MorePopupWindow(this.cgZ.getPageContext().getPageActivity(), this.cbQ.getView(), this.cgZ.getResources().getDrawable(i.e.bg_collect), null);
        this.cbP.setTouchInterceptor(new ad(this));
        this.cbP.onChangeSkinType(this.cgZ, TbadkCoreApplication.m411getInst().getSkinType(), com.baidu.tbadk.core.util.al.getDrawable(i.e.bg_collect));
    }

    public void aa(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cfm == null) {
            this.cfm = new Dialog(this.cgZ.getPageContext().getPageActivity(), i.C0057i.common_alert_dialog);
            this.cfm.setCanceledOnTouchOutside(true);
            this.cfm.setCancelable(true);
            View inflate = LayoutInflater.from(this.cgZ.getPageContext().getPageActivity()).inflate(i.g.forum_manage_dialog, (ViewGroup) null);
            this.cgZ.getLayoutMode().k(inflate);
            this.cfm.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cfm.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cgZ.getPageContext().getPageActivity()) * 0.9d);
            this.cfm.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cfm.findViewById(i.f.del_post_btn);
        TextView textView2 = (TextView) this.cfm.findViewById(i.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cfm.findViewById(i.f.disable_reply_btn);
        if ("".equals(sparseArray.get(i.f.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(i.f.tag_del_post_id, sparseArray.get(i.f.tag_del_post_id));
            sparseArray2.put(i.f.tag_del_post_type, sparseArray.get(i.f.tag_del_post_type));
            sparseArray2.put(i.f.tag_del_post_is_self, sparseArray.get(i.f.tag_del_post_is_self));
            sparseArray2.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            textView.setOnClickListener(new ae(this));
        }
        if ("".equals(sparseArray.get(i.f.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(i.f.tag_forbid_user_name, sparseArray.get(i.f.tag_forbid_user_name));
            sparseArray3.put(i.f.tag_manage_user_identity, sparseArray.get(i.f.tag_manage_user_identity));
            sparseArray3.put(i.f.tag_forbid_user_post_id, sparseArray.get(i.f.tag_forbid_user_post_id));
            textView2.setOnClickListener(new af(this));
        }
        if (!((sparseArray.get(i.f.tag_display_reply_visible) instanceof Boolean) && ((Boolean) sparseArray.get(i.f.tag_display_reply_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(i.h.un_mute);
            } else {
                textView3.setText(i.h.mute);
            }
            sparseArray4.put(i.f.tag_is_mem, sparseArray.get(i.f.tag_is_mem));
            sparseArray4.put(i.f.tag_disable_reply_mute_userid, sparseArray.get(i.f.tag_disable_reply_mute_userid));
            sparseArray4.put(i.f.tag_disable_reply_mute_username, sparseArray.get(i.f.tag_disable_reply_mute_username));
            sparseArray4.put(i.f.tag_disable_reply_post_id, sparseArray.get(i.f.tag_disable_reply_post_id));
            sparseArray4.put(i.f.tag_disable_reply_thread_id, sparseArray.get(i.f.tag_disable_reply_thread_id));
            textView3.setOnClickListener(new ag(this, z));
        }
        com.baidu.adp.lib.g.j.a(this.cfm, this.cgZ.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_del_post_id, str);
        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = i.h.del_post_confirm;
        if (i == 0) {
            i3 = i.h.del_thread_confirm;
        }
        this.cfo = new com.baidu.tbadk.core.dialog.a(this.cgZ.getPageContext().getPageActivity());
        this.cfo.bF(i3);
        this.cfo.x(sparseArray);
        this.cfo.a(i.h.dialog_ok, new ah(this, sparseArray));
        this.cfo.b(i.h.dialog_cancel, new v(this));
        this.cfo.aj(true);
        this.cfo.b(this.cgZ.getPageContext());
        this.cfo.sU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eD(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new w(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.cfF != null) {
            this.cfF.dismiss();
            this.cfF = null;
        }
        if (z) {
            string = this.cgZ.getResources().getString(i.h.remove_mark);
        } else {
            string = this.cgZ.getResources().getString(i.h.mark);
        }
        this.cfF = new com.baidu.tbadk.core.dialog.c(this.cgZ.getPageContext().getPageActivity());
        this.cfF.bI(i.h.operation);
        this.cfF.a(new String[]{this.cgZ.getResources().getString(i.h.copy), string}, bVar);
        this.cfF.d(this.cgZ.getPageContext());
        this.cfF.sX();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.chi = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.chj = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cgZ.showToast(this.cgZ.getResources().getString(i.h.success));
        } else if (str != null && z2) {
            this.cgZ.showToast(str);
        }
    }

    public void Z(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bb.a((View) this.bZv, i.c.cp_link_tip_b, true);
                return;
            }
            return;
        }
        this.mNavigationBar.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bb.r(this.bZv);
        }
    }

    public void e(com.baidu.tbadk.editortools.c.n nVar) {
        if (nVar != null && nVar.AL() != null) {
            this.bWV = nVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.bZv.addView(nVar.AL(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(int i, View view) {
        new Handler().postDelayed(new x(this, view, i), 300L);
    }

    public void ep(boolean z) {
        this.ccA = z;
        this.cgY.ep(z);
    }

    public void iM(int i) {
        this.cdZ.setMaxImageWidth(i);
        this.cdZ.setMaxImageHeight((int) (i * 1.618f));
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.bZv;
    }

    public void aX(String str, String str2) {
        this.chn = str2;
        new Handler().postDelayed(new y(this, str2, str), 200L);
    }

    public void aeO() {
        if (this.cbP != null) {
            com.baidu.adp.lib.g.j.a(this.cbP, this.cgZ.getPageContext().getPageActivity());
        }
        if (this.cfF != null) {
            this.cfF.dismiss();
        }
        if (this.cfo != null) {
            this.cfo.dismiss();
        }
        if (this.cfm != null) {
            com.baidu.adp.lib.g.j.b(this.cfm, this.cgZ.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void afl() {
        this.mListView.setNextPage(this.chf);
        this.chf.startLoadData();
    }

    public void eo(boolean z) {
        this.ccz = z;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (cVar != null) {
            this.cho = cVar;
            this.cgY.e(this.cho.adk());
            if (this.cgX != null) {
                this.cgX.setVisibility(0);
            }
            if (this.cha != null) {
                this.cha.setVisibility(0);
            }
            if (cVar.adb() != null) {
                this.chk = cVar.adb().getId();
                this.chl = cVar.adb().auj();
                if (this.chl > 0) {
                    this.WU.setText(String.format(this.cgZ.getPageContext().getString(i.h.is_floor), Integer.valueOf(this.chl)));
                } else {
                    this.WU.setText((CharSequence) null);
                }
            }
            if (cVar.hasMore()) {
                this.chf.startLoadData();
                this.cgY.setHasMoreData(true);
            } else {
                this.chf.vG();
                this.cgY.setHasMoreData(false);
            }
            this.chm = cVar.adf();
            if (this.chm == null || this.chm.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.chf);
            }
            if (this.chm == null || this.chm.size() <= cgW) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.chm.size() - cgW;
                iN(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cgY.setDatas(this.chm);
            if (cVar.adk() != null && cVar.adk().getAuthor() != null && (userId = cVar.adk().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cgY.o(i, z);
            this.cgY.notifyDataSetChanged();
            a(cVar.adb(), cVar.Wb(), cVar.qo(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View afm() {
        return this.cdY;
    }

    private void iN(int i) {
        if (this.chm != null) {
            if (this.chm.size() <= i) {
                this.chm.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.i> it = this.chm.iterator();
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

    public boolean afn() {
        return this.cgY.chx;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.i iVar, boolean z, boolean z2, int i) {
        int i2;
        if (iVar != null) {
            this.cdS.setTag(null);
            this.cdS.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cgX.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cgX.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(i.f.tag_clip_board, iVar);
            sparseArray.put(i.f.tag_is_subpb, false);
            a(iVar, i, sparseArray);
            this.cdY.setTag(sparseArray);
            if (!this.ccA) {
                this.cdS.setVisibility(8);
            }
            this.aIV.setOnClickListener(this.aZv);
            this.aIV.setText((CharSequence) null);
            this.cdX.setVisibility(8);
            this.chc.setText((CharSequence) null);
            this.cdY.setOnClickListener(this.aZv);
            com.baidu.tbadk.core.util.al.b(this.cdW, i.c.pb_listitem_post_time, 1);
            this.cdW.setText(aq.m(iVar.getTime()));
            if (z) {
                this.cdX.setVisibility(0);
                com.baidu.tbadk.core.util.al.c(this.cdX, i.e.icon_floorhost);
            }
            if (this.ccz) {
                i2 = i.e.img_default_100;
            } else {
                i2 = i.e.icon_click;
            }
            this.cdZ.setDefaultImageId(i2);
            this.chc.setText(String.format(this.cgZ.getPageContext().getString(i.h.is_floor), Integer.valueOf(iVar.auj())));
            String portrait = iVar.getAuthor().getPortrait();
            if (iVar.getAuthor() != null) {
                this.aIV.setText(iVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = iVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    com.baidu.tbadk.core.util.al.b(this.aIV, i.c.cp_cont_h, 1);
                } else {
                    com.baidu.tbadk.core.util.al.b(this.aIV, i.c.cp_cont_f, 1);
                }
                int level_id = iVar.getAuthor().getLevel_id();
                int is_bawu = iVar.getAuthor().getIs_bawu();
                String bawu_type = iVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.cdT.setVisibility(0);
                    com.baidu.tbadk.core.util.al.c(this.cdT, com.baidu.tbadk.core.util.c.cg(level_id));
                    this.cdT.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.cdT.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.cdT.setOnClickListener(this.aZv);
                    if (bawu_type.equals("manager")) {
                        com.baidu.tbadk.core.util.al.c(this.cdT, i.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        com.baidu.tbadk.core.util.al.c(this.cdT, i.e.pb_assist);
                    }
                }
                if (iVar.getAuthor().getGender() == 2) {
                    com.baidu.tbadk.core.util.al.c(this.cdU, i.e.icon_pop_girl_square);
                    this.cdU.setVisibility(0);
                } else {
                    this.cdU.setVisibility(8);
                }
                this.cdB = iVar.getAuthor().getIconInfo();
                this.aTJ = iVar.getAuthor().getTShowInfo();
                if (this.bcI != null) {
                    this.bcI.setOnClickListener(this.aZv);
                    this.bcI.a(this.cdB, i3, this.cgZ.getResources().getDimensionPixelSize(i.d.pb_icon_width), this.cgZ.getResources().getDimensionPixelSize(i.d.pb_icon_height), this.cgZ.getResources().getDimensionPixelSize(i.d.pb_icon_margin));
                }
                if (this.aUb != null) {
                    this.aUb.setOnClickListener(this.aZv);
                    this.aUb.a(this.aTJ, 2, this.cgZ.getResources().getDimensionPixelSize(i.d.big_icon_width), this.cgZ.getResources().getDimensionPixelSize(i.d.big_icon_height), this.cgZ.getResources().getDimensionPixelSize(i.d.big_icon_margin), true);
                }
            }
            this.cdS.setUserId(iVar.getAuthor().getUserId());
            this.cdS.setUserName(iVar.getAuthor().getUserName());
            this.aIV.setTag(i.f.tag_user_id, iVar.getAuthor().getUserId());
            this.aIV.setTag(i.f.tag_user_name, iVar.getAuthor().getUserName());
            this.cdS.setDefaultResource(i.e.icon_default_avatar100);
            this.cdS.d(portrait, 28, false);
            this.cdZ.setText(iVar.auk());
            this.chd.setVisibility(8);
            if (!TextUtils.isEmpty(iVar.getBimg_url())) {
                this.cdZ.setBackgroundDrawable(null);
                this.cdZ.setTag(iVar.getBimg_url());
                this.cdZ.setOnClickListener(this.aZv);
                this.cdZ.setTextViewOnClickListener(this.aZv);
                this.cdZ.setTextViewCheckSelection(false);
                com.baidu.adp.lib.f.c.gZ().a(iVar.getBimg_url(), 19, new z(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.cdZ.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.cdZ.setPadding(0, 0, 0, 0);
                this.cdZ.setLayoutParams(layoutParams);
                this.cdZ.setBackgroundDrawable(null);
            }
            if (iVar != null) {
                com.baidu.tieba.pb.view.d.a(iVar.afQ(), this.che, true, false, false);
            }
        }
    }

    public void gc(int i) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cgZ.getPageContext().getString(i.h.refresh_view_title_text), this.Sv));
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.cgZ.getPageContext().getPageActivity(), this.cha, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NODATA, 140), NoDataViewFactory.d.cJ(i), a, false);
            this.mNoDataView.setOnClickListener(this.Sv);
        }
        this.cha.setVisibility(0);
        this.mNoDataView.setTextOption(NoDataViewFactory.d.cJ(i));
        this.mNoDataView.onChangeSkinType(this.cgZ.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.bWV.BZ();
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sv = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(com.baidu.tieba.tbadkCore.data.i iVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (iVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = iVar.getAuthor().getUserId();
                boolean z7 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z7;
                    z = true;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.cho != null && this.cho.adk() != null && this.cho.adk().getAuthor() != null && iVar.getAuthor() != null) {
                String userId3 = this.cho.adk().getAuthor().getUserId();
                String userId4 = iVar.getAuthor().getUserId();
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
                    userId = iVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = iVar.auj() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                        sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_forbid_user_name, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, true);
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, iVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(i.f.tag_del_post_is_self, false);
                        sparseArray.put(i.f.tag_del_post_type, 0);
                        sparseArray.put(i.f.tag_del_post_id, "");
                    }
                    sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
                    if (!z2) {
                        sparseArray.put(i.f.tag_should_manage_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_forbid_user_name, iVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(i.f.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(i.f.tag_display_reply_visible, true);
                        sparseArray.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (iVar.getAuthor() != null) {
                            sparseArray.put(i.f.tag_disable_reply_mute_userid, iVar.getAuthor().getUserId());
                            sparseArray.put(i.f.tag_disable_reply_mute_username, iVar.getAuthor().getUserName());
                        }
                        if (this.cho.adk() != null) {
                            sparseArray.put(i.f.tag_disable_reply_thread_id, this.cho.adk().getId());
                        }
                        sparseArray.put(i.f.tag_disable_reply_post_id, iVar.getId());
                    } else {
                        sparseArray.put(i.f.tag_display_reply_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(i.f.tag_should_delete_visible, true);
                        sparseArray.put(i.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(i.f.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(i.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(i.f.tag_del_post_id, iVar.getId());
                        return;
                    }
                    sparseArray.put(i.f.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = iVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (iVar.auj() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(i.f.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(i.f.tag_forbid_user_post_id, iVar.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View afo() {
        return this.chg;
    }

    public void onChangeSkinType(int i) {
        this.cgZ.getLayoutMode().ad(i == 1);
        this.cgZ.getLayoutMode().k(this.bZv);
        this.cgZ.getLayoutMode().k(this.cgX);
        this.mNavigationBar.onChangeSkinType(this.cgZ.getPageContext(), i);
        this.aRT.onChangeSkinType(this.cgZ.getPageContext(), i);
        this.cgZ.getLayoutMode().k(this.chg);
        com.baidu.tbadk.core.util.al.c(this.cdY, i.e.btn_pb_reply_selector);
        this.cdZ.setTextColor(com.baidu.tbadk.core.util.al.getColor(i.c.pb_listitem_content));
        this.cdZ.setVideoImageId(i.e.pic_video);
        if (this.bWV != null && this.bWV.AL() != null) {
            this.bWV.AL().onChangeSkinType(i);
        }
    }

    public void afp() {
        this.mProgress.setVisibility(0);
    }

    public void afq() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.chf.vG();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.chh = onLongClickListener;
        this.cgX.setOnLongClickListener(this.chh);
    }

    public View afr() {
        return this.cgX;
    }

    public void jz(String str) {
        int jA = this.cgY.jA(str);
        if (jA > -1) {
            this.mListView.setSelection(jA + 1);
            this.mListView.invalidate();
        }
    }

    public View afs() {
        return this.chb;
    }

    public bz aft() {
        return this.cbQ;
    }

    public MorePopupWindow afu() {
        return this.cbP;
    }

    public HeadImageView afv() {
        return this.cdS;
    }

    public TextView getUserNameView() {
        return this.aIV;
    }

    public UserIconBox afw() {
        return this.bcI;
    }

    public ImageView afx() {
        return this.cdT;
    }

    public UserIconBox afy() {
        return this.aUb;
    }

    public void Yx() {
        if (this.cfT == null) {
            this.cfT = new com.baidu.tbadk.core.view.a(this.cgZ.getPageContext());
        }
        this.cfT.av(true);
    }

    public void aeU() {
        if (this.cfT != null) {
            this.cfT.av(false);
        }
    }

    public TextView afz() {
        return this.che;
    }

    public TbRichTextView afA() {
        return this.cdZ;
    }

    public TextView afB() {
        if (this.cdZ == null) {
            return null;
        }
        return this.cdZ.getTextView();
    }
}
