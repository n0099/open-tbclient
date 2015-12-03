package com.baidu.tieba.pb.pb.sub;

import android.app.Activity;
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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.bj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import com.baidu.tieba.pb.pb.main.cy;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class w {
    private static final int cHe = TbadkCoreApplication.m411getInst().getListItemRule().xj();
    private NoNetworkView aWm;
    private View.OnClickListener bfL;
    public RelativeLayout cCT;
    public LinearLayout cCU;
    public ImageView cCV;
    public TextView cCW;
    public ImageView cCX;
    private com.baidu.tbadk.core.view.b cFC;
    private int cHf;
    private View cHg;
    private al cHh;
    private NewSubPbActivity cHi;
    private RelativeLayout cHj;
    private am cHo;
    private View cHr;
    private ArrayList<com.baidu.tieba.tbadkCore.data.o> cHw;
    private String cHx;
    private com.baidu.tieba.pb.a.d cHy;
    private RelativeLayout cxP;
    private BdListView mListView;
    private ProgressBar mProgress;
    private com.baidu.tbadk.core.view.n mNoDataView = null;
    private TbRichTextView.d cGX = null;
    private View.OnClickListener Sy = null;
    private TbRichTextView.e cGW = null;
    private NavigationBar mNavigationBar = null;
    private TextView cHk = null;
    private TextView XE = null;
    private HeadImageView cAI = null;
    private TextView aJR = null;
    private ImageView cAJ = null;
    private ImageView cAL = null;
    private TextView cHl = null;
    private ImageView cAN = null;
    private TextView bEX = null;
    private TbRichTextView czX = null;
    private ImageView cAO = null;
    private TextView cHm = null;
    private TextView cHn = null;
    private MorePopupWindow cHp = null;
    private cy cHq = null;
    private com.baidu.tbadk.core.dialog.c cFo = null;
    private UserIconBox bjY = null;
    private UserIconBox aYE = null;
    private Dialog cEV = null;
    private com.baidu.tbadk.core.dialog.a cEX = null;
    private boolean czM = true;
    private boolean cAl = true;
    private boolean mIsFromCDN = true;
    private View.OnLongClickListener aSQ = null;
    private NewSubPbActivity.a cHs = null;
    private NewSubPbActivity.a cHt = null;
    private ArrayList<IconData> cAu = null;
    private ArrayList<IconData> aYm = null;
    private com.baidu.tbadk.editortools.d.p ceY = null;
    private String cHu = null;
    private int cHv = 0;
    private View.OnClickListener cAv = new x(this);
    private com.baidu.tieba.pb.b.c czP = new com.baidu.tieba.pb.b.c(new ad(this));
    protected AdapterView.OnItemClickListener cHz = new ae(this);
    protected AdapterView.OnItemLongClickListener HQ = new af(this);

    public w(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.cxP = null;
        this.cHg = null;
        this.mListView = null;
        this.cHh = null;
        this.cHi = null;
        this.aWm = null;
        this.cHj = null;
        this.cHo = null;
        this.cHr = null;
        this.bfL = null;
        this.mProgress = null;
        this.cHi = newSubPbActivity;
        this.bfL = onClickListener;
        this.cxP = (RelativeLayout) LayoutInflater.from(this.cHi.getPageContext().getPageActivity()).inflate(n.g.new_sub_pb_layout, (ViewGroup) null);
        this.cHg = LayoutInflater.from(this.cHi.getPageContext().getPageActivity()).inflate(n.g.new_sub_pb_head, (ViewGroup) null);
        this.aWm = (NoNetworkView) this.cxP.findViewById(n.f.view_no_network);
        this.cHf = com.baidu.adp.lib.util.k.K(this.cHi.getBaseContext()) - TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds60);
        amm();
        IP();
        this.cHj = (RelativeLayout) this.cxP.findViewById(n.f.sub_pb_body_layout);
        this.mListView = (BdListView) this.cxP.findViewById(n.f.new_sub_pb_list);
        this.mListView.addHeaderView(this.cHg);
        this.cHh = new al(this.cHi.getPageContext().getPageActivity());
        this.cHh.D(this.cAv);
        this.cHh.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.cHh);
        this.cHo = new am(this.cHi.getPageContext());
        this.cHr = this.cHo.getView();
        this.mListView.setNextPage(this.cHo);
        this.cHo.setOnClickListener(this.bfL);
        this.mListView.setOnItemClickListener(this.cHz);
        this.mListView.setOnItemLongClickListener(this.HQ);
        this.mListView.setOnTouchListener(this.czP);
        this.mProgress = (ProgressBar) this.cxP.findViewById(n.f.progress);
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.cHg != null) {
            this.cHg.setVisibility(4);
        }
        if (this.cHj != null) {
            this.cHj.setVisibility(4);
        }
    }

    public void IP() {
        this.cAI = (HeadImageView) this.cHg.findViewById(n.f.photo);
        this.cAI.setOnClickListener(this.bfL);
        this.aJR = (TextView) this.cHg.findViewById(n.f.user_name);
        this.cAJ = (ImageView) this.cHg.findViewById(n.f.user_rank);
        this.cAL = (ImageView) this.cHg.findViewById(n.f.user_gender);
        this.cAO = (ImageView) this.cHg.findViewById(n.f.reply);
        this.cHm = (TextView) this.cHg.findViewById(n.f.manage_btn);
        this.cHl = (TextView) this.cHg.findViewById(n.f.floor);
        this.cAN = (ImageView) this.cHg.findViewById(n.f.floor_owner);
        this.bEX = (TextView) this.cHg.findViewById(n.f.time);
        this.bjY = (UserIconBox) this.cHg.findViewById(n.f.user_icon_box);
        this.aYE = (UserIconBox) this.cHg.findViewById(n.f.user_tshow_icon_box);
        this.czX = (TbRichTextView) this.cHg.findViewById(n.f.richText);
        this.czX.Go();
        this.czX.f(this.czM, true);
        this.czX.setIsFromCDN(this.mIsFromCDN);
        this.czX.setImageViewStretch(true);
        this.czX.setTextSize(TbConfig.getContentSize());
        this.czX.setVoiceViewRes(n.g.voice_play_btn);
        this.cHg.setOnTouchListener(this.czP);
        this.cHg.setOnClickListener(this.bfL);
        this.cHn = (TextView) this.cHg.findViewById(n.f.pb_item_tail_content);
        this.cHn.setOnClickListener(this.bfL);
        this.cCT = (RelativeLayout) this.cHg.findViewById(n.f.chudian_info_container);
        this.cCU = (LinearLayout) this.cHg.findViewById(n.f.landmark_container);
        this.cCV = (ImageView) this.cHg.findViewById(n.f.landmark_icon);
        this.cCW = (TextView) this.cHg.findViewById(n.f.landmark_content);
        this.cCX = (ImageView) this.cHg.findViewById(n.f.ad_icon);
    }

    public void amm() {
        this.mNavigationBar = (NavigationBar) this.cxP.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.XE = this.mNavigationBar.setTitleText("");
        this.cHk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.cHi.getResources().getString(n.i.view_subject), this.bfL);
        this.cHk.setVisibility(8);
    }

    public void akc() {
        this.cHq = new cy(this.cHi.getPageContext(), this.bfL);
        this.cHq.fh(TbadkCoreApplication.isLogin());
        this.cHp = new MorePopupWindow(this.cHi.getPageContext().getPageActivity(), this.cHq.getView(), this.cHi.getResources().getDrawable(n.e.bg_collect), null);
        this.cHp.setTouchInterceptor(new ag(this));
        this.cHp.onChangeSkinType(this.cHi, TbadkCoreApplication.m411getInst().getSkinType(), as.getDrawable(n.e.bg_collect));
    }

    public void ak(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, boolean z) {
        if (this.cEV == null) {
            this.cEV = new Dialog(this.cHi.getPageContext().getPageActivity(), n.j.common_alert_dialog);
            this.cEV.setCanceledOnTouchOutside(true);
            this.cEV.setCancelable(true);
            View inflate = LayoutInflater.from(this.cHi.getPageContext().getPageActivity()).inflate(n.g.forum_manage_dialog, (ViewGroup) null);
            this.cHi.getLayoutMode().k(inflate);
            this.cEV.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.cEV.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.k.K(this.cHi.getPageContext().getPageActivity()) * 0.9d);
            this.cEV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.cEV.findViewById(n.f.del_post_btn);
        TextView textView2 = (TextView) this.cEV.findViewById(n.f.forbid_user_btn);
        TextView textView3 = (TextView) this.cEV.findViewById(n.f.disable_reply_btn);
        if ("".equals(sparseArray.get(n.f.tag_del_post_id))) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(n.f.tag_del_post_id, sparseArray.get(n.f.tag_del_post_id));
            sparseArray2.put(n.f.tag_del_post_type, sparseArray.get(n.f.tag_del_post_type));
            sparseArray2.put(n.f.tag_del_post_is_self, sparseArray.get(n.f.tag_del_post_is_self));
            sparseArray2.put(n.f.tag_manage_user_identity, sparseArray.get(n.f.tag_manage_user_identity));
            textView.setOnClickListener(new ah(this));
        }
        if ("".equals(sparseArray.get(n.f.tag_forbid_user_name))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(n.f.tag_forbid_user_name, sparseArray.get(n.f.tag_forbid_user_name));
            sparseArray3.put(n.f.tag_manage_user_identity, sparseArray.get(n.f.tag_manage_user_identity));
            sparseArray3.put(n.f.tag_forbid_user_post_id, sparseArray.get(n.f.tag_forbid_user_post_id));
            textView2.setOnClickListener(new ai(this));
        }
        if (!((sparseArray.get(n.f.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(n.f.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(n.i.un_mute);
            } else {
                textView3.setText(n.i.mute);
            }
            sparseArray4.put(n.f.tag_is_mem, sparseArray.get(n.f.tag_is_mem));
            sparseArray4.put(n.f.tag_user_mute_mute_userid, sparseArray.get(n.f.tag_user_mute_mute_userid));
            sparseArray4.put(n.f.tag_user_mute_mute_username, sparseArray.get(n.f.tag_user_mute_mute_username));
            sparseArray4.put(n.f.tag_user_mute_post_id, sparseArray.get(n.f.tag_user_mute_post_id));
            sparseArray4.put(n.f.tag_user_mute_thread_id, sparseArray.get(n.f.tag_user_mute_thread_id));
            textView3.setOnClickListener(new aj(this, z));
        }
        com.baidu.adp.lib.h.j.a(this.cEV, this.cHi.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(n.f.tag_del_post_id, str);
        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = n.i.del_post_confirm;
        if (i == 0) {
            i3 = n.i.del_thread_confirm;
        }
        this.cEX = new com.baidu.tbadk.core.dialog.a(this.cHi.getPageContext().getPageActivity());
        this.cEX.bN(i3);
        this.cEX.x(sparseArray);
        this.cEX.a(n.i.dialog_ok, new ak(this, sparseArray));
        this.cEX.b(n.i.dialog_cancel, new y(this));
        this.cEX.al(true);
        this.cEX.b(this.cHi.getPageContext());
        this.cEX.tv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new z(this, z), 10L);
            }
        }
    }

    public void a(c.b bVar, boolean z) {
        String string;
        if (this.cFo != null) {
            this.cFo.dismiss();
            this.cFo = null;
        }
        if (z) {
            string = this.cHi.getResources().getString(n.i.remove_mark);
        } else {
            string = this.cHi.getResources().getString(n.i.mark);
        }
        this.cFo = new com.baidu.tbadk.core.dialog.c(this.cHi.getPageContext().getPageActivity());
        this.cFo.bQ(n.i.operation);
        this.cFo.a(new String[]{this.cHi.getResources().getString(n.i.copy), string}, bVar);
        this.cFo.d(this.cHi.getPageContext());
        this.cFo.tz();
    }

    public void a(NewSubPbActivity.a aVar) {
        this.cHs = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.cHt = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.cHi.showToast(this.cHi.getResources().getString(n.i.success));
        } else if (str != null && z2) {
            this.cHi.showToast(str);
        }
    }

    public void aj(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bj.a((View) this.cxP, n.c.cp_link_tip_b, true);
                return;
            }
            return;
        }
        this.mNavigationBar.setVisibility(0);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            bj.r(this.cxP);
        }
    }

    public void e(com.baidu.tbadk.editortools.d.p pVar) {
        if (pVar != null && pVar.Bu() != null) {
            this.ceY = pVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.cxP.addView(pVar.Bu(), layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(int i, View view) {
        new Handler().postDelayed(new aa(this, view, i), 300L);
    }

    public void eV(boolean z) {
        this.cAl = z;
        this.cHh.eV(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.cxP;
    }

    public void bb(String str, String str2) {
        this.cHx = str2;
        new Handler().postDelayed(new ab(this, str2, str), 200L);
    }

    public void alO() {
        if (this.cHp != null) {
            com.baidu.adp.lib.h.j.a(this.cHp, this.cHi.getPageContext().getPageActivity());
        }
        if (this.cFo != null) {
            this.cFo.dismiss();
        }
        if (this.cEX != null) {
            this.cEX.dismiss();
        }
        if (this.cEV != null) {
            com.baidu.adp.lib.h.j.b(this.cEV, this.cHi.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void amn() {
        this.mListView.setNextPage(this.cHo);
        this.cHo.startLoadData();
    }

    public void eT(boolean z) {
        this.czM = z;
    }

    public void a(com.baidu.tieba.pb.a.d dVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (dVar != null) {
            this.cHy = dVar;
            this.cHh.e(this.cHy.ajT());
            if (this.cHg != null) {
                this.cHg.setVisibility(0);
            }
            if (this.cHj != null) {
                this.cHj.setVisibility(0);
            }
            if (dVar.ajK() != null) {
                this.cHu = dVar.ajK().getId();
                this.cHv = dVar.ajK().aDd();
                if (this.cHv > 0) {
                    this.XE.setText(String.format(this.cHi.getPageContext().getString(n.i.is_floor), Integer.valueOf(this.cHv)));
                } else {
                    this.XE.setText((CharSequence) null);
                }
            }
            if (dVar.hasMore()) {
                this.cHo.startLoadData();
                this.cHh.setHasMoreData(true);
            } else {
                this.cHo.wf();
                this.cHh.setHasMoreData(false);
            }
            this.cHw = dVar.ajO();
            if (this.cHw == null || this.cHw.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.cHo);
            }
            if (this.cHw == null || this.cHw.size() <= cHe) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.cHw.size() - cHe;
                kf(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.cHh.setDatas(this.cHw);
            if (dVar.ajT() != null && dVar.ajT().getAuthor() != null && (userId = dVar.ajT().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.cHh.q(i, z);
            this.cHh.notifyDataSetChanged();
            a(dVar.ajK(), dVar.aah(), dVar.qp(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public View amo() {
        return this.cAO;
    }

    private void kf(int i) {
        if (this.cHw != null) {
            if (this.cHw.size() <= i) {
                this.cHw.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.o> it = this.cHw.iterator();
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

    public boolean amp() {
        return this.cHh.cHH;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.o oVar, boolean z, boolean z2, int i) {
        int i2;
        if (oVar != null) {
            com.baidu.tieba.tbadkCore.data.g aDn = oVar.aDn();
            if (aDn != null && aDn.dzp) {
                this.cCT.setVisibility(0);
                this.cCX.setBackgroundDrawable(as.getDrawable(n.e.icon_tuiguang));
                String position = aDn.getPosition();
                if (!TextUtils.isEmpty(position)) {
                    this.cCU.setVisibility(0);
                    this.cCW.setText(position);
                }
                this.czX.setOnLinkImageClickListener(this.cGW);
                this.czX.setOnImageClickListener(this.cGX);
            } else {
                this.cCT.setVisibility(8);
            }
            this.cAI.setTag(null);
            this.cAI.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.cHg.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.cHg.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(n.f.tag_clip_board, oVar);
            sparseArray.put(n.f.tag_is_subpb, false);
            a(oVar, i, sparseArray);
            this.cAO.setTag(sparseArray);
            if (!this.cAl) {
                this.cAI.setVisibility(8);
            }
            this.aJR.setOnClickListener(this.bfL);
            this.aJR.setText((CharSequence) null);
            this.cAN.setVisibility(8);
            this.cHl.setText((CharSequence) null);
            this.cAO.setOnClickListener(this.bfL);
            as.b(this.bEX, n.c.pb_listitem_post_time, 1);
            this.bEX.setText(ax.s(oVar.getTime()));
            if (z) {
                this.cAN.setVisibility(0);
                as.c(this.cAN, n.e.icon_floorhost);
            }
            if (this.czM) {
                i2 = n.e.img_default_100;
            } else {
                i2 = n.e.icon_click;
            }
            this.czX.setDefaultImageId(i2);
            this.cHl.setText(String.format(this.cHi.getPageContext().getString(n.i.is_floor), Integer.valueOf(oVar.aDd())));
            String portrait = oVar.getAuthor().getPortrait();
            if (oVar.getAuthor() != null) {
                String name_show = oVar.getAuthor().getName_show();
                if (com.baidu.tbadk.util.o.ge(name_show) > 14) {
                    name_show = String.valueOf(com.baidu.tbadk.util.o.e(name_show, 0, 14)) + "...";
                }
                this.aJR.setText(name_show);
                ArrayList<IconData> tShowInfoNew = oVar.getAuthor().getTShowInfoNew();
                if (tShowInfoNew != null && tShowInfoNew.size() > 0) {
                    as.b(this.aJR, n.c.cp_cont_h, 1);
                } else {
                    as.b(this.aJR, n.c.cp_cont_f, 1);
                }
                int level_id = oVar.getAuthor().getLevel_id();
                int is_bawu = oVar.getAuthor().getIs_bawu();
                String bawu_type = oVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.cAJ.setVisibility(0);
                    as.c(this.cAJ, com.baidu.tbadk.core.util.c.cq(level_id));
                    this.cAJ.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.cAJ.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.cAJ.setOnClickListener(this.bfL);
                    if (bawu_type.equals("manager")) {
                        as.c(this.cAJ, n.e.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        as.c(this.cAJ, n.e.pb_assist);
                    }
                }
                if (oVar.getAuthor().getGender() == 2) {
                    as.c(this.cAL, n.e.icon_pb_pop_girl);
                    this.cAL.setVisibility(0);
                } else if (oVar.getAuthor().getGender() == 1) {
                    as.c(this.cAL, n.e.icon_pb_pop_boy);
                    this.cAL.setVisibility(0);
                } else {
                    this.cAL.setVisibility(8);
                }
                this.cAu = oVar.getAuthor().getIconInfo();
                this.aYm = oVar.getAuthor().getTShowInfoNew();
                if (this.bjY != null) {
                    this.bjY.setOnClickListener(this.bfL);
                    this.bjY.a(this.cAu, i3, this.cHi.getResources().getDimensionPixelSize(n.d.pb_icon_width), this.cHi.getResources().getDimensionPixelSize(n.d.pb_icon_height), this.cHi.getResources().getDimensionPixelSize(n.d.pb_icon_margin));
                }
                if (this.aYE != null) {
                    this.aYE.setOnClickListener(this.bfL);
                    if (this.aYm != null && this.aYm.size() > 0 && this.aYm.get(0) != null) {
                        this.aYE.setTag(this.aYm.get(0).getUrl());
                    }
                    this.aYE.a(this.aYm, 2, this.cHi.getResources().getDimensionPixelSize(n.d.ds30), this.cHi.getResources().getDimensionPixelSize(n.d.small_icon_height), this.cHi.getResources().getDimensionPixelSize(n.d.small_icon_margin), true);
                }
            }
            a(this.czX, (int) this.cHi.getResources().getDimension(n.d.ds76));
            this.cAI.setUserId(oVar.getAuthor().getUserId());
            this.cAI.setUserName(oVar.getAuthor().getUserName());
            this.aJR.setTag(n.f.tag_user_id, oVar.getAuthor().getUserId());
            this.aJR.setTag(n.f.tag_user_name, oVar.getAuthor().getUserName());
            this.cAI.setDefaultResource(n.e.icon_default_avatar100);
            this.cAI.d(portrait, 28, false);
            this.czX.setText(oVar.aDe());
            this.cHm.setVisibility(8);
            if (!TextUtils.isEmpty(oVar.getBimg_url())) {
                this.czX.setBackgroundDrawable(null);
                this.czX.setTag(oVar.getBimg_url());
                this.czX.setOnClickListener(this.bfL);
                this.czX.setTextViewOnClickListener(this.bfL);
                this.czX.setTextViewCheckSelection(false);
                com.baidu.adp.lib.g.c.hd().a(oVar.getBimg_url(), 19, new ac(this), null);
            } else {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.czX.getLayoutParams();
                layoutParams.bottomMargin = 0;
                layoutParams.topMargin = 0;
                this.czX.setPadding(0, 0, 0, 0);
                this.czX.setLayoutParams(layoutParams);
                this.czX.setBackgroundDrawable(null);
            }
            if (oVar != null) {
                com.baidu.tieba.pb.view.e.a(oVar.amT(), this.cHn, true, false, false);
            }
        }
    }

    private void a(TbRichTextView tbRichTextView, int i) {
        if (tbRichTextView != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
            layoutParams.leftMargin = i;
            tbRichTextView.setMaxImageWidth(this.cHf - i);
            this.czX.setMaxImageHeight((int) ((this.cHf - i) * 1.618f));
            tbRichTextView.setLayoutParams(layoutParams);
        }
    }

    private void a(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.cHi.getPageContext().getString(n.i.refresh_view_title_text), this.Sy));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.cHi.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.cHj, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.GIFT, com.baidu.adp.lib.util.k.d(pageActivity, n.d.ds140)), dVar, a, false);
        }
        this.cHj.setVisibility(0);
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.ceY.CD();
        as.j(this.mNoDataView, n.c.cp_bg_line_d);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.cHi.getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void fA(int i) {
        a(NoDataViewFactory.d.D(i, n.i.refresh_view_title_text));
    }

    public void hk(String str) {
        a(NoDataViewFactory.d.ad(str, this.cHi.getPageContext().getString(n.i.refresh_view_title_text)));
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void b(View.OnClickListener onClickListener) {
        this.Sy = onClickListener;
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
    public void a(com.baidu.tieba.tbadkCore.data.o oVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        String userId;
        boolean z6;
        if (oVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId2 = oVar.getAuthor().getUserId();
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
            if (this.cHy != null && this.cHy.ajT() != null && this.cHy.ajT().getAuthor() != null && oVar.getAuthor() != null) {
                String userId3 = this.cHy.ajT().getAuthor().getUserId();
                String userId4 = oVar.getAuthor().getUserId();
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
                    userId = oVar.getAuthor().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = oVar.aDd() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                        sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(n.f.tag_forbid_user_name, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.f.tag_del_post_is_self, true);
                        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(n.f.tag_del_post_id, oVar.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(n.f.tag_del_post_is_self, false);
                        sparseArray.put(n.f.tag_del_post_type, 0);
                        sparseArray.put(n.f.tag_del_post_id, "");
                    }
                    sparseArray.put(n.f.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
                    if (!z2) {
                        sparseArray.put(n.f.tag_should_manage_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                    } else {
                        sparseArray.put(n.f.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(n.f.tag_user_mute_visible, true);
                        sparseArray.put(n.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (oVar.getAuthor() != null) {
                            sparseArray.put(n.f.tag_user_mute_mute_userid, oVar.getAuthor().getUserId());
                            sparseArray.put(n.f.tag_user_mute_mute_username, oVar.getAuthor().getUserName());
                        }
                        if (this.cHy.ajT() != null) {
                            sparseArray.put(n.f.tag_user_mute_thread_id, this.cHy.ajT().getId());
                        }
                        sparseArray.put(n.f.tag_user_mute_post_id, oVar.getId());
                    } else {
                        sparseArray.put(n.f.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(n.f.tag_should_delete_visible, true);
                        sparseArray.put(n.f.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(n.f.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(n.f.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(n.f.tag_del_post_id, oVar.getId());
                        return;
                    }
                    sparseArray.put(n.f.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = oVar.getAuthor().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (oVar.aDd() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(n.f.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(n.f.tag_forbid_user_post_id, oVar.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public View amq() {
        return this.cHr;
    }

    public void onChangeSkinType(int i) {
        this.cHi.getLayoutMode().af(i == 1);
        this.cHi.getLayoutMode().k(this.cxP);
        this.cHi.getLayoutMode().k(this.cHg);
        this.mNavigationBar.onChangeSkinType(this.cHi.getPageContext(), i);
        this.aWm.onChangeSkinType(this.cHi.getPageContext(), i);
        this.cHi.getLayoutMode().k(this.cHr);
        as.c(this.cAO, n.e.btn_pb_reply_selector);
        this.czX.setTextColor(as.getColor(n.c.pb_listitem_content));
        this.czX.setVideoImageId(n.e.pic_video);
        if (this.ceY != null && this.ceY.Bu() != null) {
            this.ceY.Bu().onChangeSkinType(i);
        }
    }

    public void amr() {
        this.mProgress.setVisibility(0);
    }

    public void ams() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.cHo.wf();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aSQ = onLongClickListener;
        this.cHg.setOnLongClickListener(this.aSQ);
    }

    public View amt() {
        return this.cHg;
    }

    public void kO(String str) {
        int kP = this.cHh.kP(str);
        if (kP > -1) {
            this.mListView.setSelection(kP + 1);
            this.mListView.invalidate();
        }
    }

    public View amu() {
        return this.cHk;
    }

    public cy amv() {
        return this.cHq;
    }

    public MorePopupWindow amw() {
        return this.cHp;
    }

    public HeadImageView amx() {
        return this.cAI;
    }

    public TextView getUserNameView() {
        return this.aJR;
    }

    public UserIconBox amy() {
        return this.bjY;
    }

    public ImageView amz() {
        return this.cAJ;
    }

    public UserIconBox amA() {
        return this.aYE;
    }

    public void acC() {
        if (this.cFC == null) {
            this.cFC = new com.baidu.tbadk.core.view.b(this.cHi.getPageContext());
        }
        this.cFC.ay(true);
    }

    public void alU() {
        if (this.cFC != null) {
            this.cFC.ay(false);
        }
    }

    public TextView amB() {
        return this.cHn;
    }

    public TbRichTextView amC() {
        return this.czX;
    }

    public TextView amD() {
        if (this.czX == null) {
            return null;
        }
        return this.czX.getTextView();
    }

    public void setOnLinkImageClickListener(TbRichTextView.e eVar) {
        this.cGW = eVar;
    }

    public void setOnImageClickListener(TbRichTextView.d dVar) {
        this.cGX = dVar;
    }

    public void setOnEmotionClickListener(TbRichTextView.c cVar) {
        if (this.czX != null) {
            this.czX.setOnEmotionClickListener(cVar);
        }
    }
}
