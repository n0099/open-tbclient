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
    private static final int bPy = TbadkCoreApplication.m411getInst().getListItemRule().vp();
    private TbPageContext<?> Yt;
    private View.OnClickListener aPn;
    private ag bPA;
    private NoNetworkView bPB;
    private RelativeLayout bPC;
    private aj bPG;
    private View bPH;
    private ArrayList<com.baidu.tieba.tbadkCore.data.j> bPO;
    private String bPP;
    private View bPz;
    private BdListView mListView;
    private ProgressBar mProgress;
    private View rootView;
    private com.baidu.tbadk.core.view.x mNoDataView = null;
    private View.OnClickListener NN = null;
    private NavigationBar mNavigationBar = null;
    private TextView bPD = null;
    private TextView RS = null;
    private HeadImageView bMu = null;
    private TextView aBn = null;
    private ImageView bMv = null;
    private ImageView bMw = null;
    private TextView bPE = null;
    private ImageView bMz = null;
    private TextView bMy = null;
    private TbRichTextView bMB = null;
    private ImageView bMA = null;
    private Button bPF = null;
    private MorePopupWindow bKE = null;
    private cf bKF = null;
    private com.baidu.tbadk.core.dialog.e bOe = null;
    private UserIconBox aQL = null;
    private UserIconBox aKy = null;
    private Dialog bNM = null;
    private com.baidu.tbadk.core.dialog.a bNN = null;
    private boolean bLh = false;
    private boolean bLi = true;
    private boolean mIsFromCDN = true;
    private Button bPI = null;
    private View.OnLongClickListener bPJ = null;
    private r bPK = null;
    private r bPL = null;
    private ArrayList<IconData> bMd = null;
    private ArrayList<IconData> aKj = null;
    private PbEditor aKP = null;
    private String bPM = null;
    private int bPN = 0;
    private String bPQ = null;
    private boolean bPR = false;
    private com.baidu.tieba.pb.b.d bKH = new com.baidu.tieba.pb.b.d(new t(this));
    private boolean bPS = false;
    protected AdapterView.OnItemClickListener bPT = new y(this);
    protected AdapterView.OnItemLongClickListener Hw = new z(this);

    public s(TbPageContext<?> tbPageContext, View.OnClickListener onClickListener) {
        this.rootView = null;
        this.bPz = null;
        this.mListView = null;
        this.bPA = null;
        this.Yt = null;
        this.bPB = null;
        this.bPC = null;
        this.bPG = null;
        this.bPH = null;
        this.aPn = null;
        this.mProgress = null;
        this.Yt = tbPageContext;
        this.aPn = onClickListener;
        this.rootView = com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.new_sub_pb_layout, null);
        this.bPz = com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.new_sub_pb_head, null);
        this.bPB = (NoNetworkView) this.rootView.findViewById(com.baidu.tieba.q.view_no_network);
        adb();
        He();
        this.bPC = (RelativeLayout) this.rootView.findViewById(com.baidu.tieba.q.sub_pb_body_layout);
        this.mListView = (BdListView) this.rootView.findViewById(com.baidu.tieba.q.new_sub_pb_list);
        this.mListView.addHeaderView(this.bPz);
        this.bPA = new ag(this.Yt.getPageActivity());
        this.bPA.w(this.aPn);
        this.bPA.setIsFromCDN(this.mIsFromCDN);
        this.mListView.setAdapter((ListAdapter) this.bPA);
        this.bPG = new aj(this.Yt.getPageActivity());
        this.bPH = this.bPG.getView();
        this.mListView.setNextPage(this.bPG);
        this.bPG.setOnClickListener(this.aPn);
        this.mListView.setOnItemClickListener(this.bPT);
        this.mListView.setOnItemLongClickListener(this.Hw);
        this.mListView.setOnTouchListener(this.bKH);
        this.mProgress = (ProgressBar) this.rootView.findViewById(com.baidu.tieba.q.progress);
        adc();
        onChangeSkinType(TbadkCoreApplication.m411getInst().getSkinType());
        if (this.bPz != null) {
            this.bPz.setVisibility(4);
        }
        if (this.bPC != null) {
            this.bPC.setVisibility(4);
        }
    }

    public void He() {
        this.bMu = (HeadImageView) this.bPz.findViewById(com.baidu.tieba.q.photo);
        this.bMu.setOnClickListener(this.aPn);
        this.aBn = (TextView) this.bPz.findViewById(com.baidu.tieba.q.user_name);
        this.bMv = (ImageView) this.bPz.findViewById(com.baidu.tieba.q.user_rank);
        this.bMw = (ImageView) this.bPz.findViewById(com.baidu.tieba.q.user_gender);
        this.bMA = (ImageView) this.bPz.findViewById(com.baidu.tieba.q.reply);
        this.bPF = (Button) this.bPz.findViewById(com.baidu.tieba.q.manage_btn);
        this.bPE = (TextView) this.bPz.findViewById(com.baidu.tieba.q.floor);
        this.bMz = (ImageView) this.bPz.findViewById(com.baidu.tieba.q.floor_owner);
        this.bMy = (TextView) this.bPz.findViewById(com.baidu.tieba.q.time);
        this.aQL = (UserIconBox) this.bPz.findViewById(com.baidu.tieba.q.user_icon_box);
        this.aKy = (UserIconBox) this.bPz.findViewById(com.baidu.tieba.q.user_tshow_icon_box);
        this.bMB = (TbRichTextView) this.bPz.findViewById(com.baidu.tieba.q.richText);
        this.bMB.ED();
        this.bMB.setTextSize(TbConfig.getContentSize());
        this.bMB.setVoiceViewRes(com.baidu.tieba.r.voice_play_btn);
        this.bMB.setOnTouchListener(this.bKH);
        this.bPz.setOnClickListener(this.aPn);
    }

    public void adb() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(com.baidu.tieba.q.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.RS = this.mNavigationBar.setTitleText("");
        this.bPD = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.Yt.getResources().getString(com.baidu.tieba.t.view_subject), this.aPn);
        this.bPD.setVisibility(8);
    }

    public void aaP() {
        this.bKF = new cf(this.Yt, this.aPn);
        this.bKE = new MorePopupWindow(this.Yt.getPageActivity(), this.bKF.getView(), this.Yt.getResources().getDrawable(com.baidu.tieba.p.bg_collect), null);
        this.bKE.setTouchInterceptor(new aa(this));
        this.bKE.onChangeSkinType((BaseActivity) this.Yt.getOrignalPage(), TbadkCoreApplication.m411getInst().getSkinType(), ay.getDrawable(com.baidu.tieba.p.bg_collect));
    }

    public void P(View view) {
        if (this.bNM == null) {
            this.bNM = new Dialog(this.Yt.getPageActivity(), com.baidu.tieba.u.common_alert_dialog);
            this.bNM.setCanceledOnTouchOutside(true);
            this.bNM.setCancelable(true);
            this.bNM.setContentView(com.baidu.adp.lib.g.b.hr().inflate(this.Yt.getPageActivity(), com.baidu.tieba.r.forum_manage_dialog, null));
            WindowManager.LayoutParams attributes = this.bNM.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.n.M(this.Yt.getPageActivity()) * 0.9d);
            this.bNM.getWindow().setAttributes(attributes);
        }
        Button button = (Button) this.bNM.findViewById(com.baidu.tieba.q.del_post_btn);
        Button button2 = (Button) this.bNM.findViewById(com.baidu.tieba.q.forbid_user_btn);
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
            com.baidu.adp.lib.g.k.a(this.bNM, this.Yt);
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
        this.bNN = new com.baidu.tbadk.core.dialog.a(this.Yt.getPageActivity());
        this.bNN.bu(i3);
        this.bNN.v(sparseArray);
        this.bNN.a(com.baidu.tieba.t.dialog_ok, new ad(this, sparseArray));
        this.bNN.b(com.baidu.tieba.t.dialog_cancel, new ae(this));
        this.bNN.ag(true);
        this.bNN.b(this.Yt);
        this.bNN.rL();
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
        if (this.bOe != null) {
            this.bOe.dismiss();
            this.bOe = null;
        }
        if (z) {
            string = this.Yt.getString(com.baidu.tieba.t.remove_mark);
        } else {
            string = this.Yt.getString(com.baidu.tieba.t.mark);
        }
        this.bOe = new com.baidu.tbadk.core.dialog.e(this.Yt.getPageActivity());
        this.bOe.bx(com.baidu.tieba.t.operation);
        this.bOe.a(new String[]{this.Yt.getString(com.baidu.tieba.t.copy), string}, hVar);
        this.bOe.d(this.Yt);
        this.bOe.rN();
    }

    public void a(r rVar) {
        this.bPK = rVar;
    }

    public void b(r rVar) {
        this.bPL = rVar;
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
        adf();
    }

    public void adc() {
        this.aKP = (PbEditor) this.rootView.findViewById(com.baidu.tieba.q.sub_pb_editor);
        this.aKP.aX(true);
        this.aKP.getEditText().setFilters(new InputFilter[]{new InputFilter.LengthFilter(140)});
        this.aKP.setMaxTextCount(140);
    }

    public void add() {
        if (!this.aKP.anx()) {
            iu(null);
        }
    }

    public String ade() {
        return this.bPP;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i, View view) {
        new Handler().postDelayed(new u(this, view, i), 300L);
    }

    public void dT(boolean z) {
        this.bLi = z;
        this.bPA.dT(z);
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
        return this.aKP.getAudioData();
    }

    public void Ks() {
        this.aKP.Ks();
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
            int selectionStart = this.aKP.getEditText().getSelectionStart();
            if (selectionStart < 0) {
                this.aKP.getEditText().setText(sb2);
            } else {
                this.aKP.getEditText().getText().insert(selectionStart, sb2);
            }
        }
    }

    public void aV(String str, String str2) {
        this.bPP = str2;
        iu(str);
        new Handler().postDelayed(new v(this, str2), 200L);
    }

    public void iu(String str) {
        el(true);
        this.aKP.CR();
        if (str != null) {
            this.aKP.getEditText().setText(this.Yt.getResources().getString(com.baidu.tieba.t.reply_sub_floor).replace("%s", str));
            this.aKP.getEditText().setSelection(this.aKP.getEditText().getText().length());
        }
        if (this.aKP.anx()) {
            this.aKP.anT();
            this.aKP.add();
        } else {
            this.aKP.getEditText().requestFocus();
            com.baidu.adp.lib.util.n.d(this.Yt.getPageActivity(), this.aKP.getEditText());
        }
        TiebaStatic.eventStat(this.Yt.getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iv(String str) {
        el(true);
        this.aKP.CR();
        this.aKP.getEditText().setText(str);
        this.aKP.getEditText().setSelection(this.aKP.getEditText().getText().length());
        if (this.aKP.anx()) {
            this.aKP.anT();
            this.aKP.add();
        } else {
            this.aKP.getEditText().requestFocus();
            com.baidu.adp.lib.util.n.d(this.Yt.getPageActivity(), this.aKP.getEditText());
        }
        TiebaStatic.eventStat(this.Yt.getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
    }

    public void adf() {
        el(false);
        this.aKP.hide();
    }

    public void acx() {
        if (this.bKE != null) {
            com.baidu.adp.lib.g.k.a(this.bKE, this.Yt.getPageActivity());
        }
        if (this.aKP != null) {
            this.aKP.anT();
        }
        if (this.bOe != null) {
            this.bOe.dismiss();
        }
        adf();
        if (this.bNN != null) {
            this.bNN.dismiss();
        }
        if (this.bNM != null) {
            com.baidu.adp.lib.g.k.b(this.bNM, this.Yt);
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
    }

    public void adg() {
        this.mListView.setNextPage(this.bPG);
        this.bPG.startLoadData();
    }

    public void setIsShowImage(boolean z) {
        this.bLh = z;
    }

    public String adh() {
        return this.bPM;
    }

    public void a(com.baidu.tieba.pb.a.c cVar, int i) {
        int i2;
        int i3;
        int i4;
        String userId;
        boolean z = false;
        if (cVar != null) {
            if (this.bPz != null) {
                this.bPz.setVisibility(0);
            }
            if (this.bPC != null) {
                this.bPC.setVisibility(0);
            }
            if (cVar.aaB() != null) {
                this.bPM = cVar.aaB().getId();
                this.bPN = cVar.aaB().aoC();
                if (this.bPN > 0) {
                    this.RS.setText(String.format(this.Yt.getString(com.baidu.tieba.t.is_floor), Integer.valueOf(this.bPN)));
                } else {
                    this.RS.setText((CharSequence) null);
                }
            }
            if (cVar.hasMore()) {
                this.bPG.startLoadData();
                this.bPA.em(true);
            } else {
                this.bPG.ux();
                this.bPA.em(false);
            }
            this.bPO = cVar.aaD();
            if (this.bPO == null || this.bPO.size() == 0) {
                this.mListView.setNextPage(null);
            } else {
                this.mListView.setNextPage(this.bPG);
            }
            if (this.bPO == null || this.bPO.size() <= bPy) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.bPO.size() - bPy;
                hH(i4);
                i3 = this.mListView.getFirstVisiblePosition() - i4;
                View childAt = this.mListView.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
            }
            this.bPA.setDatas(this.bPO);
            if (cVar.aaI() != null && cVar.aaI().getAuthor() != null && (userId = cVar.aaI().getAuthor().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z = true;
            }
            this.bPA.p(i, z);
            this.bPA.notifyDataSetChanged();
            a(cVar.aaB(), cVar.Us(), cVar.pq(), i);
            if (i4 > 0) {
                this.mListView.setSelectionFromTop(i3, i2);
            }
        }
    }

    public void setOnActionListener(com.baidu.tbadk.editortool.v vVar) {
        if (vVar != null) {
            this.aKP.a(this.Yt, new w(this, vVar));
        }
    }

    public void clearContent() {
        this.aKP.clearData();
    }

    public View adi() {
        return this.bMA;
    }

    private void hH(int i) {
        if (this.bPO != null) {
            if (this.bPO.size() <= i) {
                this.bPO.clear();
            }
            int i2 = 0;
            Iterator<com.baidu.tieba.tbadkCore.data.j> it = this.bPO.iterator();
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

    public boolean adj() {
        return this.bPA.bQa;
    }

    protected void a(com.baidu.tieba.tbadkCore.data.j jVar, boolean z, boolean z2, int i) {
        int i2;
        if (jVar != null) {
            this.bMu.setTag(null);
            this.bMu.setUserId(null);
            SparseArray<Object> sparseArray = (SparseArray) this.bPz.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.bPz.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(com.baidu.tieba.q.tag_clip_board, jVar);
            sparseArray.put(com.baidu.tieba.q.tag_is_subpb, false);
            a(jVar, i, sparseArray);
            this.bMA.setTag(sparseArray);
            if (!this.bLi) {
                this.bMu.setVisibility(8);
            }
            this.aBn.setOnClickListener(this.aPn);
            this.aBn.setText((CharSequence) null);
            this.bMz.setVisibility(8);
            this.bPE.setText((CharSequence) null);
            this.bMA.setOnClickListener(this.aPn);
            ay.b(this.bMy, com.baidu.tieba.n.pb_listitem_post_time, 1);
            this.bMy.setText(bb.o(jVar.getTime()));
            if (z) {
                this.bMz.setVisibility(0);
                ay.c(this.bMz, com.baidu.tieba.p.icon_floorhost);
            }
            if (this.bLh) {
                i2 = com.baidu.tieba.p.img_default_100;
            } else {
                i2 = com.baidu.tieba.p.icon_click;
            }
            this.bMB.setDefaultImageId(i2);
            this.bPE.setText(String.format(this.Yt.getString(com.baidu.tieba.t.is_floor), Integer.valueOf(jVar.aoC())));
            String portrait = jVar.getAuthor().getPortrait();
            if (jVar.getAuthor() != null) {
                this.aBn.setText(jVar.getAuthor().getName_show());
                ArrayList<IconData> tShowInfo = jVar.getAuthor().getTShowInfo();
                if (tShowInfo != null && tShowInfo.size() > 0) {
                    ay.b(this.aBn, com.baidu.tieba.n.cp_cont_h, 1);
                } else {
                    ay.b(this.aBn, com.baidu.tieba.n.cp_cont_f, 1);
                }
                int level_id = jVar.getAuthor().getLevel_id();
                int is_bawu = jVar.getAuthor().getIs_bawu();
                String bawu_type = jVar.getAuthor().getBawu_type();
                int i3 = 3;
                if (level_id != 0) {
                    this.bMv.setVisibility(0);
                    ay.c(this.bMv, com.baidu.tbadk.core.util.c.bU(level_id));
                    this.bMv.setOnClickListener(null);
                    i3 = 2;
                } else {
                    this.bMv.setVisibility(8);
                }
                if (is_bawu != 0) {
                    this.bMv.setOnClickListener(this.aPn);
                    if (bawu_type.equals("manager")) {
                        ay.c(this.bMv, com.baidu.tieba.p.pb_manager);
                    } else if (bawu_type.equals("assist")) {
                        ay.c(this.bMv, com.baidu.tieba.p.pb_assist);
                    }
                }
                if (jVar.getAuthor().getGender() == 2) {
                    ay.c(this.bMw, com.baidu.tieba.p.icon_pop_girl_square);
                    this.bMw.setVisibility(0);
                } else {
                    this.bMw.setVisibility(8);
                }
                this.bMd = jVar.getAuthor().getIconInfo();
                this.aKj = jVar.getAuthor().getTShowInfo();
                if (this.aQL != null) {
                    this.aQL.setOnClickListener(this.aPn);
                    this.aQL.a(this.bMd, i3, this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_width), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_height), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.pb_icon_margin));
                }
                if (this.aKy != null) {
                    this.aKy.setOnClickListener(this.aPn);
                    this.aKy.a(this.aKj, 2, this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_width), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_height), this.Yt.getResources().getDimensionPixelSize(com.baidu.tieba.o.big_icon_margin), true);
                }
            }
            this.bMu.setUserId(jVar.getAuthor().getUserId());
            this.bMu.setUserName(jVar.getAuthor().getUserName());
            this.aBn.setTag(com.baidu.tieba.q.tag_user_id, jVar.getAuthor().getUserId());
            this.aBn.setTag(com.baidu.tieba.q.tag_user_name, jVar.getAuthor().getUserName());
            this.bMu.setDefaultResource(com.baidu.tieba.p.icon_default_avatar100);
            this.bMu.c(portrait, 28, false);
            this.bMB.c(this.bLh, false);
            this.bMB.setIsFromCDN(this.mIsFromCDN);
            this.bMB.setText(jVar.aoD());
            this.bPF.setVisibility(8);
            if (!TextUtils.isEmpty(jVar.getBimg_url())) {
                this.bMB.setBackgroundDrawable(null);
                this.bMB.setTag(jVar.getBimg_url());
                com.baidu.adp.lib.f.d.hl().a(jVar.getBimg_url(), 19, new x(this), null);
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bMB.getLayoutParams();
            layoutParams.bottomMargin = 0;
            layoutParams.topMargin = 0;
            this.bMB.setPadding(0, 0, 0, 0);
            this.bMB.setLayoutParams(layoutParams);
            this.bMB.setBackgroundDrawable(null);
        }
    }

    public void fv(int i) {
        com.baidu.tbadk.core.view.z a = com.baidu.tbadk.core.view.z.a(new com.baidu.tbadk.core.view.y(this.Yt.getString(com.baidu.tieba.t.refresh_view_title_text), this.NN));
        if (this.mNoDataView == null) {
            this.mNoDataView = NoDataViewFactory.a(this.Yt.getPageActivity(), this.bPC, com.baidu.tbadk.core.view.aa.a(NoDataViewFactory.ImgType.NODATA, 140), com.baidu.tbadk.core.view.ab.cv(i), a, false);
            this.mNoDataView.setOnClickListener(this.NN);
        }
        this.bPC.setVisibility(0);
        this.mNoDataView.setTextOption(com.baidu.tbadk.core.view.ab.cv(i));
        this.mNoDataView.onChangeSkinType(this.Yt, TbadkCoreApplication.m411getInst().getSkinType());
        this.mListView.setVisibility(8);
        this.mProgress.setVisibility(8);
        adf();
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
            int i2 = jVar.aoC() == 1 ? 0 : 1;
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

    public View adk() {
        return this.bPH;
    }

    public String adl() {
        if (this.aKP == null || this.aKP.getEditText() == null || this.aKP.getEditText().getText() == null) {
            return null;
        }
        return this.aKP.getEditText().getText().toString();
    }

    public void onChangeSkinType(int i) {
        this.Yt.getLayoutMode().ab(i == 1);
        this.Yt.getLayoutMode().j(this.rootView);
        this.Yt.getLayoutMode().j(this.bPz);
        this.mNavigationBar.onChangeSkinType(this.Yt, i);
        this.bPB.onChangeSkinType(this.Yt, i);
        this.Yt.getLayoutMode().j(this.bPH);
        ay.i((View) this.bPI, com.baidu.tieba.p.btn_pb_editor_post_btn);
        ay.c(this.bMA, com.baidu.tieba.p.btn_pb_reply_selector);
        this.bMB.setTextColor(ay.getColor(com.baidu.tieba.n.pb_listitem_content));
        this.bMB.setVideoImageId(com.baidu.tieba.p.pic_video);
        this.aKP.b(this.Yt, i);
    }

    public void adm() {
        this.mProgress.setVisibility(0);
    }

    public void adn() {
        this.mProgress.setVisibility(8);
    }

    public void ado() {
        this.mListView.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.bPG.ux();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.bPJ = onLongClickListener;
        this.bPz.setOnLongClickListener(this.bPJ);
    }

    public View adp() {
        return this.bPz;
    }

    public void iw(String str) {
        int ix = this.bPA.ix(str);
        if (ix > -1) {
            this.mListView.setSelection(ix + 1);
            this.mListView.invalidate();
        }
    }

    public boolean Kn() {
        return this.aKP.Kn();
    }

    public PbEditor Kj() {
        return this.aKP;
    }

    public boolean adq() {
        return this.bPR;
    }

    public void el(boolean z) {
        this.bPR = z;
    }

    public View adr() {
        return this.bPD;
    }

    public cf ads() {
        return this.bKF;
    }

    public MorePopupWindow adt() {
        return this.bKE;
    }

    public HeadImageView adu() {
        return this.bMu;
    }

    public TextView adv() {
        return this.aBn;
    }

    public UserIconBox adw() {
        return this.aQL;
    }

    public ImageView adx() {
        return this.bMv;
    }

    public UserIconBox ady() {
        return this.aKy;
    }

    public PbEditor adz() {
        return this.aKP;
    }
}
