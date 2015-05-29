package com.baidu.tieba.pb.pb.sub;

import android.app.Dialog;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.cf;
import com.baidu.tieba.tbadkCore.PbEditor.PbEditor;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class s {
    private static final int bPx = TbadkCoreApplication.m411getInst().getListItemRule().vp();
    private TbPageContext<?> Yt;
    private View.OnClickListener aPm;
    private NoNetworkView bPA;
    private RelativeLayout bPB;
    private aj bPF;
    private View bPG;
    private ArrayList<com.baidu.tieba.tbadkCore.data.j> bPN;
    private String bPO;
    private View bPy;
    private ag bPz;
    private BdListView mListView;
    private ProgressBar mProgress;
    private View rootView;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private View.OnClickListener NN = null;
    private NavigationBar mNavigationBar = null;
    private TextView bPC = null;
    private TextView RS = null;
    private HeadImageView bMt = null;
    private TextView aBm = null;
    private ImageView bMu = null;
    private ImageView bMv = null;
    private TextView bPD = null;
    private ImageView bMy = null;
    private TextView bMx = null;
    private TbRichTextView bMA = null;
    private ImageView bMz = null;
    private Button bPE = null;
    private MorePopupWindow bKD = null;
    private cf bKE = null;
    private com.baidu.tbadk.core.dialog.e bOd = null;
    private UserIconBox aQK = null;
    private UserIconBox aKx = null;
    private Dialog bNL = null;
    private com.baidu.tbadk.core.dialog.a bNM = null;
    private boolean bLg = false;
    private boolean bLh = true;
    private boolean mIsFromCDN = true;
    private Button bPH = null;
    private View.OnLongClickListener bPI = null;
    private r bPJ = null;
    private r bPK = null;
    private ArrayList<IconData> bMc = null;
    private ArrayList<IconData> aKi = null;
    private PbEditor aKO = null;
    private String bPL = null;
    private int bPM = 0;
    private String bPP = null;
    private boolean bPQ = false;
    private com.baidu.tieba.pb.b.d bKG = new com.baidu.tieba.pb.b.d(new t(this));
    private boolean bPR = false;
    protected AdapterView.OnItemClickListener bPS = new y(this);
    protected AdapterView.OnItemLongClickListener Hw = new z(this);

    public s(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.rootView = null;
        this.bPy = null;
        this.mListView = null;
        this.bPz = null;
        this.Yt = null;
        this.bPA = null;
        this.bPB = null;
        this.bPF = null;
        this.bPG = null;
        this.aPm = null;
        this.mProgress = null;
        this.Yt = tbPageContext;
        this.aPm = onClickListener;
        this.rootView = com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.new_sub_pb_layout, null);
        this.bPy = com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.new_sub_pb_head, null);
        this.bPA = (NoNetworkView) this.rootView.findViewById(com.baidu.tieba.q.view_no_network);
        ada();
        Hd();
        this.bPB = (RelativeLayout) this.rootView.findViewById(com.baidu.tieba.q.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(com.baidu.tieba.q.new_sub_pb_list);
        this.mListView.addHeaderView(this.bPy);
        this.bPz = new ag(this.Yt.getPageActivity());
        this.bPz.w(this.aPm);
        this.bPz.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bPz);
        this.bPF = new aj(this.Yt.getPageActivity());
        this.bPG = this.bPF.getView();
        this.mListView.setNextPage(this.bPF);
        this.bPF.setOnClickListener(this.aPm);
        this.mListView.setOnItemClickListener(this.bPS);
        this.mListView.setOnItemLongClickListener(this.Hw);
        this.mListView.setOnTouchListener(this.bKG);
        this.mProgress = (ProgressBar) this.rootView.findViewById(com.baidu.tieba.q.progress);
        adb();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bPy != null) {
            this.bPy.setVisibility(4);
        }
        if (this.bPB != null) {
            this.bPB.setVisibility(4);
        }
    }

    public void Hd() {
        this.bMt = (HeadImageView) this.bPy.findViewById(com.baidu.tieba.q.photo);
        this.bMt.setOnClickListener(this.aPm);
        this.aBm = (TextView) this.bPy.findViewById(com.baidu.tieba.q.user_name);
        this.bMu = (ImageView) this.bPy.findViewById(com.baidu.tieba.q.user_rank);
        this.bMv = (ImageView) this.bPy.findViewById(com.baidu.tieba.q.user_gender);
        this.bMz = (ImageView) this.bPy.findViewById(com.baidu.tieba.q.reply);
        this.bPE = (Button) this.bPy.findViewById(com.baidu.tieba.q.manage_btn);
        this.bPD = (TextView) this.bPy.findViewById(com.baidu.tieba.q.floor);
        this.bMy = (ImageView) this.bPy.findViewById(com.baidu.tieba.q.floor_owner);
        this.bMx = (TextView) this.bPy.findViewById(com.baidu.tieba.q.time);
        this.aQK = (UserIconBox) this.bPy.findViewById(com.baidu.tieba.q.user_icon_box);
        this.aKx = (UserIconBox) this.bPy.findViewById(com.baidu.tieba.q.user_tshow_icon_box);
        this.bMA = (TbRichTextView) this.bPy.findViewById(com.baidu.tieba.q.richText);
        this.bMA.EC();
        this.bMA.setTextSize(TbConfig.getContentSize());
        this.bMA.setVoiceViewRes(com.baidu.tieba.r.voice_play_btn);
        this.bMA.setOnTouchListener(this.bKG);
        this.bPy.setOnClickListener(this.aPm);
    }

    public void ada() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.RS = this.mNavigationBar.setTitleText("");
        this.bPC = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.Yt.getResources().getString(com.baidu.tieba.t.view_subject), this.aPm);
        this.bPC.setVisibility(8);
    }

    public void aaO() {
        this.bKE = new cf(this.Yt, this.aPm);
        this.bKD = new MorePopupWindow(this.Yt.getPageActivity(), this.bKE.getView(), this.Yt.getResources().getDrawable(com.baidu.tieba.p.bg_collect), null);
        this.bKD.setTouchInterceptor(new aa(this));
        this.bKD.onChangeSkinType((BaseActivity) this.Yt.getOrignalPage(), TbadkCoreApplication.m411getInst().getSkinType(), ay.getDrawable(com.baidu.tieba.p.bg_collect));
    }

    public void P(View view) {
        if (this.bNL == null) {
            this.bNL = new Dialog(this.Yt.getPageActivity(), com.baidu.tieba.u.common_alert_dialog);
            this.bNL.setCanceledOnTouchOutside(true);
            this.bNL.setCancelable(true);
            this.bNL.setContentView(com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bNL.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.Yt.getPageActivity()) * 0.9d);
            this.bNL.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bNL.findViewById(com.baidu.tieba.q.del_post_btn);
        Button button2 = (Button) this.bNL.findViewById(com.baidu.tieba.q.forbid_user_btn);
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            if ("".equals(sparseArray.get(com.baidu.tieba.q.tag_del_post_id))) {
                button.setVisibility(8);
            } else {
                SparseArray sparseArray2 = (SparseArray) button.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    button.setTag(sparseArray2);
                }
                button.setVisibility(0);
                sparseArray2.put(com.baidu.tieba.q.tag_del_post_id, sparseArray.get(com.baidu.tieba.q.tag_del_post_id));
                sparseArray2.put(com.baidu.tieba.q.tag_del_post_type, sparseArray.get(com.baidu.tieba.q.tag_del_post_type));
                sparseArray2.put(com.baidu.tieba.q.tag_del_post_is_self, sparseArray.get(com.baidu.tieba.q.tag_del_post_is_self));
                sparseArray2.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity));
                button.setOnClickListener(new ab(this));
            }
            if ("".equals(sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name))) {
                button2.setVisibility(8);
            } else {
                SparseArray sparseArray3 = (SparseArray) button2.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    button2.setTag(sparseArray3);
                }
                button2.setVisibility(0);
                sparseArray3.put(com.baidu.tieba.q.tag_forbid_user_name, sparseArray.get(com.baidu.tieba.q.tag_forbid_user_name));
                sparseArray3.put(com.baidu.tieba.q.tag_manage_user_identity, sparseArray.get(com.baidu.tieba.q.tag_manage_user_identity));
                sparseArray3.put(com.baidu.tieba.q.tag_forbid_user_post_id, sparseArray.get(com.baidu.tieba.q.tag_forbid_user_post_id));
                button2.setOnClickListener(new ac(this));
            }
            com.baidu.adp.lib.g.k.a(this.bNL, this.Yt);
        }
    }

    public void a(int i, String str, int i2, boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.q.tag_del_post_id, str);
        sparseArray.put(com.baidu.tieba.q.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = com.baidu.tieba.t.del_post_confirm;
        if (i == 0) {
            i3 = com.baidu.tieba.t.del_thread_confirm;
        }
        this.bNM = new com.baidu.tbadk.core.dialog.a(this.Yt.getPageActivity());
        this.bNM.bu(i3);
        this.bNM.v(sparseArray);
        this.bNM.a(com.baidu.tieba.t.dialog_ok, new ad(this, sparseArray));
        this.bNM.b(com.baidu.tieba.t.dialog_cancel, new ae(this));
        this.bNM.ag(true);
        this.bNM.b(this.Yt);
        this.bNM.rL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ee(boolean z) {
        if (this.mListView != null) {
            if (!z) {
                this.mListView.setEnabled(z);
            } else {
                this.mListView.postDelayed(new af(this, z), 10L);
            }
        }
    }

    public void a(com.baidu.tbadk.core.dialog.h hVar, boolean z) {
        String string;
        if (this.bOd != null) {
            this.bOd.dismiss();
            this.bOd = null;
        }
        if (z) {
            string = this.Yt.getString(com.baidu.tieba.t.remove_mark);
        } else {
            string = this.Yt.getString(com.baidu.tieba.t.mark);
        }
        this.bOd = new com.baidu.tbadk.core.dialog.e(this.Yt.getPageActivity());
        this.bOd.bx(com.baidu.tieba.t.operation);
        this.bOd.a(new String[]{this.Yt.getString(com.baidu.tieba.t.copy), string}, hVar);
        this.bOd.d(this.Yt);
        this.bOd.rN();
    }

    public void a(r rVar) {
        this.bPJ = rVar;
    }

    public void b(r rVar) {
        this.bPK = rVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.Yt.showToast(this.Yt.getString(com.baidu.tieba.t.success));
        } else if (str != null && z2) {
            this.Yt.showToast(str);
        }
    }

    public void O(View view) {
        if (this.mNavigationBar.getVisibility() == 0) {
            this.mNavigationBar.setVisibility(8);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bq.a(this.rootView, com.baidu.tieba.n.cp_link_tip_b, true);
            }
        } else {
            this.mNavigationBar.setVisibility(0);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                bq.q(this.rootView);
            }
        }
        ade();
    }

    public void adb() {
        this.aKO = (PbEditor) this.rootView.findViewById(com.baidu.tieba.q.sub_pb_editor);
        this.aKO.aX(true);
        this.aKO.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aKO.setMaxTextCount(140);
    }

    public void adc() {
        if (!this.aKO.anw()) {
            iu(null);
        }
    }

    public String add() {
        return this.bPO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i, View view) {
        new Handler().postDelayed(new u(this, view, i), 300L);
    }

    public void dT(boolean z) {
        this.bLh = z;
        this.bPz.dT(z);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mListView.setOnScrollListener(onScrollListener);
    }

    public void d(com.baidu.adp.widget.ListView.x xVar) {
        this.mListView.setOnSrollToBottomListener(xVar);
    }

    public View getRootView() {
        return this.rootView;
    }

    public VoiceData.VoiceModel getAudioData() {
        return this.aKO.getAudioData();
    }

    public void Kr() {
        this.aKO.Kr();
    }

    public void u(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                sb.append("@");
                sb.append(arrayList.get(i2));
                sb.append(" ");
                i = i2 + 1;
            }
            String sb2 = sb.toString();
            int selectionStart = this.aKO.getEditText().getSelectionStart();
            if (selectionStart < 0) {
                this.aKO.getEditText().setText(sb2);
            } else {
                this.aKO.getEditText().getText().insert(selectionStart, sb2);
            }
        }
    }

    public void aV(String str, String str2) {
        this.bPO = str2;
        iu(str);
        new Handler().postDelayed(new v(this, str2), 200L);
    }

    public void iu(String str) {
        el(true);
        this.aKO.CQ();
        if (str != null) {
            this.aKO.getEditText().setText(this.Yt.getResources().getString(com.baidu.tieba.t.reply_sub_floor).replace("%s", str));
            this.aKO.getEditText().setSelection(this.aKO.getEditText().getText().length());
        }
        if (this.aKO.anw()) {
            this.aKO.anS();
            this.aKO.adc();
        } else {
            this.aKO.getEditText().requestFocus();
            com.baidu.adp.lib.util.n.d(this.Yt.getPageActivity(), this.aKO.getEditText());
        }
        TiebaStatic.eventStat(this.Yt.getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(String str) {
        el(true);
        this.aKO.CQ();
        this.aKO.getEditText().setText(str);
        this.aKO.getEditText().setSelection(this.aKO.getEditText().getText().length());
        if (this.aKO.anw()) {
            this.aKO.anS();
            this.aKO.adc();
        } else {
            this.aKO.getEditText().requestFocus();
            com.baidu.adp.lib.util.n.d(this.Yt.getPageActivity(), this.aKO.getEditText());
        }
        TiebaStatic.eventStat(this.Yt.getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void ade() {
        el(false);
        this.aKO.hide();
    }

    public void acw() {
        if (this.bKD != null) {
            com.baidu.adp.lib.g.k.a(this.bKD, this.Yt.getPageActivity());
        }
        if (this.aKO != null) {
            this.aKO.anS();
        }
        if (this.bOd != null) {
            this.bOd.dismiss();
        }
        ade();
        if (this.bNM != null) {
            this.bNM.dismiss();
        }
        if (this.bNL != null) {
            com.baidu.adp.lib.g.k.b(this.bNL, this.Yt);
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void adf() {
        this.mListView.setNextPage(this.bPF);
        this.bPF.startLoadData();
    }

    public void setIsShowImage(boolean z) {
        this.bLg = z;
    }

    public String adg() {
        return this.bPL;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (cVar != null) {
            if (this.bPy != null) {
                this.bPy.setVisibility(0);
            }
            if (this.bPB != null) {
                this.bPB.setVisibility(0);
            }
            if (cVar.aaA() != null) {
                this.bPL = cVar.aaA().getId();
                this.bPM = cVar.aaA().aoB();
                if (this.bPM > 0) {
                    this.RS.setText(String.format(this.Yt.getString(com.baidu.tieba.t.is_floor), Integer.valueOf(this.bPM)));
                } else {
                    this.RS.setText((CharSequence) null);
                }
            }
            if (cVar.hasMore()) {
                this.bPF.startLoadData();
                this.bPz.em(true);
            } else {
                this.bPF.ux();
                this.bPz.em(false);
            }
            this.bPN = cVar.aaC();
            if (this.bPN == null || this.bPN.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.bPF);
            }
            if (this.bPN == null || this.bPN.size() <= bPx) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.bPN.size() - bPx;
                hH(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.bPz.setDatas(this.bPN);
            if (cVar.aaH() != null && cVar.aaH().getAuthor() != null && (userId = cVar.aaH().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.bPz.p(i, z);
            this.bPz.notifyDataSetChanged();
            a(cVar.aaA(), cVar.Ur(), cVar.pq(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aKO.a(this.Yt, new w(this, vVar));
        }
    }

    public void clearContent() {
        this.aKO.clearData();
    }

    public View adh() {
        return this.bMz;
    }

    private void hH(int i) {
        if (this.bPN != null) {
            if (this.bPN.size() <= i) {
                this.bPN.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.j> it = this.bPN.iterator();
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

    public boolean adi() {
        return this.bPz.bPZ;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.j jVar, boolean z, boolean z2, int i) {
        int i2;
        if (jVar != null) {
            this.bMt.setTag(null);
            this.bMt.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.bPy.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.bPy.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, false);
            a(jVar, i, sparseArray);
            this.bMz.setTag(sparseArray);
            if (!this.bLh) {
                this.bMt.setVisibility(8);
            }
            this.aBm.setOnClickListener(this.aPm);
            this.aBm.setText((CharSequence) null);
            this.bMy.setVisibility(8);
            this.bPD.setText((CharSequence) null);
            this.bMz.setOnClickListener(this.aPm);
            ay.b(this.bMx, com.baidu.tieba.n.pb_listitem_post_time, 1);
            this.bMx.setText(bb.o(jVar.getTime()));
            if (z) {
                this.bMy.setVisibility(0);
                ay.c(this.bMy, com.baidu.tieba.p.icon_floorhost);
            }
            if (this.bLg) {
                i2 = com.baidu.tieba.p.img_default_100;
            } else {
                i2 = com.baidu.tieba.p.icon_click;
            }
            this.bMA.setDefaultImageId(i2);
            this.bPD.setText(String.format(this.Yt.getString(com.baidu.tieba.t.is_floor), Integer.valueOf(jVar.aoB())));
            String portrait = jVar.getAuthor().getPortrait();
            if (jVar.getAuthor() != null) {
                this.aBm.setText(jVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    ay.b(this.aBm, com.baidu.tieba.n.cp_cont_h, 1);
                } else {
                    ay.b(this.aBm, com.baidu.tieba.n.cp_cont_f, 1);
                }
                int level_id = jVar.getAuthor().getLevel_id();
                int is_bawu = jVar.getAuthor().getIs_bawu();
                String bawu_type = jVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.bMu.setVisibility(0);
                    ay.c(this.bMu, com.baidu.tbadk.core.util.c.bU(level_id));
                    this.bMu.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.bMu.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.bMu.setOnClickListener(this.aPm);
                    if (bawu_type.equals("manager")) {
                        ay.c(this.bMu, com.baidu.tieba.p.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        ay.c(this.bMu, com.baidu.tieba.p.pb_assist);
                    }
                }
                if (jVar.getAuthor().getGender() == 2) {
                    ay.c(this.bMv, com.baidu.tieba.p.icon_pop_girl_square);
                    this.bMv.setVisibility(0);
                } else {
                    this.bMv.setVisibility(8);
                }
                this.bMc = jVar.getAuthor().getIconInfo();
                this.aKi = jVar.getAuthor().getTShowInfo();
                if (this.aQK != null) {
                    this.aQK.setOnClickListener(this.aPm);
                    this.aQK.a(this.bMc, i3, this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_width), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_height), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_margin));
                }
                if (this.aKx != null) {
                    this.aKx.setOnClickListener(this.aPm);
                    this.aKx.a(this.aKi, 2, this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_width), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_height), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_margin), true);
                }
            }
            this.bMt.setUserId(jVar.getAuthor().getUserId());
            this.bMt.setUserName(jVar.getAuthor().getUserName());
            this.aBm.setTag(com.baidu.tieba.q.tag_user_id, jVar.getAuthor().getUserId());
            this.aBm.setTag(com.baidu.tieba.q.tag_user_name, jVar.getAuthor().getUserName());
            this.bMt.setDefaultResource(com.baidu.tieba.p.icon_default_avatar100);
            this.bMt.c(portrait, 28, false);
            this.bMA.c(this.bLg, false);
            this.bMA.setIsFromCDN(this.mIsFromCDN);
            this.bMA.setText(jVar.aoC());
            this.bPE.setVisibility(8);
            if (!TextUtils.isEmpty(jVar.getBimg_url())) {
                this.bMA.setBackgroundDrawable(null);
                this.bMA.setTag(jVar.getBimg_url());
                com.baidu.adp.lib.f.d.hl().a(jVar.getBimg_url(), 19, new x(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMA.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bMA.setPadding(0, 0, 0, 0);
            this.bMA.setLayoutParams(layoutParams);
            this.bMA.setBackgroundDrawable(null);
        }
    }

    public void fv(int i) {
        com.baidu.tbadk.core.view.z a = com.baidu.tbadk.core.view.z.a(new com.baidu.tbadk.core.view.y(this.Yt.getString(com.baidu.tieba.t.refresh_view_title_text), this.NN));
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Yt.getPageActivity(), this.bPB, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, 140), com.baidu.tbadk.core.view.ab.cv(i), a, false);
            this.mNoDataView.setOnClickListener(this.NN);
        }
        this.bPB.setVisibility(0);
        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(i));
        this.mNoDataView.onChangeSkinType(this.Yt, TbadkCoreApplication.m411getInst().getSkinType());
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        ade();
        this.mNoDataView.setVisibility(0);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.mListView.setVisibility(0);
        }
    }

    public void c(View.OnClickListener onClickListener) {
        this.NN = onClickListener;
    }

    public void a(com.baidu.tieba.tbadkCore.data.j jVar, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        if (jVar != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                String userId = jVar.getAuthor().getUserId();
                boolean z5 = userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId == null || userId.equals(GameInfoData.NOT_FROM_DETAIL) || userId.length() == 0) {
                    z = true;
                    z2 = false;
                } else {
                    z2 = z5;
                    z = true;
                }
            } else {
                String userId2 = jVar.getAuthor().getUserId();
                if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = false;
                    z2 = false;
                } else {
                    z = true;
                    z2 = false;
                }
            }
            int i2 = jVar.aoB() == 1 ? 0 : 1;
            if (z2) {
                sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(i));
                sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, jVar.getAuthor().getUserName());
                sparseArray.put(com.baidu.tieba.q.tag_forbid_user_post_id, jVar.getId());
                z3 = true;
            } else {
                sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, "");
                z3 = false;
            }
            if (z) {
                sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(i));
                sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, true);
                sparseArray.put(com.baidu.tieba.q.tag_del_post_type, Integer.valueOf(i2));
                sparseArray.put(com.baidu.tieba.q.tag_del_post_id, jVar.getId());
            } else {
                sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, false);
                sparseArray.put(com.baidu.tieba.q.tag_del_post_type, 0);
                sparseArray.put(com.baidu.tieba.q.tag_del_post_id, "");
                z4 = z3;
            }
            sparseArray.put(com.baidu.tieba.q.tag_should_manage_visible, Boolean.valueOf(z4));
        }
    }

    public View adj() {
        return this.bPG;
    }

    public String adk() {
        if (this.aKO == null || this.aKO.getEditText() == null || this.aKO.getEditText().getText() == null) {
            return null;
        }
        return this.aKO.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.Yt.getLayoutMode().ab(i == 1);
        this.Yt.getLayoutMode().j(this.rootView);
        this.Yt.getLayoutMode().j(this.bPy);
        this.mNavigationBar.onChangeSkinType(this.Yt, i);
        this.bPA.onChangeSkinType(this.Yt, i);
        this.Yt.getLayoutMode().j(this.bPG);
        ay.i((View) this.bPH, com.baidu.tieba.p.btn_pb_editor_post_btn);
        ay.c(this.bMz, com.baidu.tieba.p.btn_pb_reply_selector);
        this.bMA.setTextColor(ay.getColor(com.baidu.tieba.n.pb_listitem_content));
        this.bMA.setVideoImageId(com.baidu.tieba.p.pic_video);
        this.aKO.b(this.Yt, i);
    }

    public void adl() {
        this.mProgress.setVisibility(0);
    }

    public void adm() {
        this.mProgress.setVisibility(8);
    }

    public void adn() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bPF.ux();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bPI = onLongClickListener;
        this.bPy.setOnLongClickListener(this.bPI);
    }

    public View ado() {
        return this.bPy;
    }

    public void iw(String str) {
        int ix = this.bPz.ix(str);
        if (ix > -1) {
            this.mListView.setSelection(ix + 1);
            this.mListView.invalidate();
        }
    }

    public boolean Km() {
        return this.aKO.Km();
    }

    public PbEditor Ki() {
        return this.aKO;
    }

    public boolean adp() {
        return this.bPQ;
    }

    public void el(boolean z) {
        this.bPQ = z;
    }

    public View adq() {
        return this.bPC;
    }

    public cf adr() {
        return this.bKE;
    }

    public MorePopupWindow ads() {
        return this.bKD;
    }

    public HeadImageView adt() {
        return this.bMt;
    }

    public TextView adu() {
        return this.aBm;
    }

    public UserIconBox adv() {
        return this.aQK;
    }

    public ImageView adw() {
        return this.bMu;
    }

    public UserIconBox adx() {
        return this.aKx;
    }

    public PbEditor ady() {
        return this.aKO;
    }
}
