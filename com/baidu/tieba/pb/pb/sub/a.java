package com.baidu.tieba.pb.pb.sub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.f.g;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.l;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.l;
import com.baidu.tieba.pb.pb.main.w;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.i;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a implements KeyboardEventLayout.a {
    private static final int iWG = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener akE;
    private BdTypeListView ekE;
    private com.baidu.tbadk.core.view.a fQQ;
    private TextView gEV;
    private e gRC;
    private View geR;
    private NoNetworkView gkY;
    private l iVr;
    private SubPbView iWH;
    private LinearLayout iWI;
    private View iWJ;
    private NewSubPbActivity iWK;
    private RelativeLayout iWL;
    private View iWP;
    private ThreadSkinView iWW;
    private d iWX;
    private View iWY;
    private SubPbModel iWm;
    private w iWp;
    private View iXa;
    private View iXc;
    private BlankView iXd;
    private com.baidu.tbadk.core.dialog.b iXf;
    private ArrayList<PostData> iXi;
    private RelativeLayout iXj;
    private ImageView iXk;
    private ImageView iXl;
    private c iXo;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener cLl = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iWM = null;
    private LinearLayout iWN = null;
    private HeadImageView iWO = null;
    private ClickableHeaderImageView iSR = null;
    private TextView cbW = null;
    private ImageView iWQ = null;
    private TextView iSK = null;
    private TextView iWR = null;
    private TextView iWS = null;
    private EllipsizeRichTextView iWT = null;
    private TbImageView iWU = null;
    private PlayVoiceBntNew NZ = null;
    private TextView iWV = null;
    private MorePopupWindow iWZ = null;
    private com.baidu.tbadk.core.dialog.b iXb = null;
    private Dialog iXe = null;
    private com.baidu.tbadk.core.dialog.a iPU = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a iXg = null;
    private NewSubPbActivity.a iXh = null;
    private h hRt = null;
    private int dOR = 0;
    private int iXm = 2;
    private int iXn = 0;
    private boolean dxw = true;
    private com.baidu.tieba.pb.a.c drk = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lW(false);
            a.this.lW(true);
            return true;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTapEvent(View view, MotionEvent motionEvent) {
            return false;
        }

        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onSingleTapConfirmed(View view, MotionEvent motionEvent) {
            return true;
        }
    });
    protected AdapterView.OnItemLongClickListener iXp = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.iXi, i);
            if (view != null && view.getTag() != null) {
                if (a.this.iWp == null) {
                    a.this.iWp = new w(a.this.iWK.getPageContext(), a.this.akE);
                }
                a.this.iWp.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.pR(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.iWp.a(sparseArray, a.this.iWm.clb(), z);
                if (z) {
                    a.this.iWp.coU().setVisibility(0);
                    a.this.iWp.coU().setTag(postData.getId());
                } else {
                    a.this.iWp.coU().setVisibility(8);
                }
                a.this.iWp.coS().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iXq = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.iWK != null && bc.checkUpIsLogin(a.this.iWK.getPageContext().getPageActivity())) {
                if ((a.this.iWK.hRk == null || a.this.iWm == null || a.this.iWm.bDg() == null || a.this.iWK.hRk.ks(a.this.iWm.bDg().replyPrivateFlag)) && a.this.iWm != null && a.this.hRt != null) {
                    a.this.crN();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.crP();
                        a.this.iWm.csn();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.hRt.setReplyId(str2);
                            a.this.hRt.vs(str);
                        }
                    }
                    a.this.crO();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.iWH = null;
        this.iWJ = null;
        this.ekE = null;
        this.iWK = null;
        this.gkY = null;
        this.iWL = null;
        this.iWP = null;
        this.iWX = null;
        this.iXc = null;
        this.akE = null;
        this.mProgress = null;
        this.gEV = null;
        this.iXj = null;
        this.iXk = null;
        this.iXl = null;
        this.iWK = newSubPbActivity;
        this.akE = onClickListener;
        this.iWH = (SubPbView) LayoutInflater.from(this.iWK.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iWJ = LayoutInflater.from(this.iWK.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iWI = (LinearLayout) this.iWH.findViewById(R.id.navigation_bar_group);
        this.iXj = (RelativeLayout) this.iWH.findViewById(R.id.subpb_editor_tool_comment);
        this.gEV = (TextView) this.iWH.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gEV.setOnClickListener(this.akE);
        this.iXk = (ImageView) this.iWH.findViewById(R.id.subpb_editor_tool_more_img);
        this.iXl = (ImageView) this.iWH.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iXl.setOnClickListener(this.akE);
        this.iXk.setOnClickListener(this.akE);
        this.gkY = (NoNetworkView) this.iWH.findViewById(R.id.view_no_network);
        bIw();
        bgi();
        this.iWL = (RelativeLayout) this.iWH.findViewById(R.id.sub_pb_body_layout);
        this.ekE = (BdTypeListView) this.iWH.findViewById(R.id.new_sub_pb_list);
        this.iWW = (ThreadSkinView) LayoutInflater.from(this.iWK.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.ekE.addHeaderView(this.iWW);
        this.ekE.addHeaderView(this.iWJ);
        this.geR = new TextView(newSubPbActivity.getActivity());
        this.geR.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.ekE.addHeaderView(this.geR, 0);
        this.iWH.setTopView(this.geR);
        this.iWH.setNavigationView(this.iWI);
        this.iWH.setListView(this.ekE);
        this.iWH.setContentView(this.iWL);
        this.iWX = new d(this.iWK.getPageContext());
        this.iWX.setLineGone();
        this.iXc = this.iWX.getView();
        this.ekE.setNextPage(this.iWX);
        this.iWX.setOnClickListener(this.akE);
        this.ekE.setOnItemClickListener(this.iXq);
        this.ekE.setOnItemLongClickListener(this.iXp);
        this.ekE.setOnTouchListener(this.drk);
        this.mProgress = (ProgressBar) this.iWH.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iWJ != null) {
            this.iWJ.setVisibility(4);
        }
        this.iWP = com.baidu.tbadk.ala.b.ayE().u(this.iWK.getActivity(), 4);
        if (this.iWP != null) {
            this.iWP.setVisibility(8);
            this.iWN.addView(this.iWP, 3);
        }
        this.iXo = new c(this.iWK, this.ekE);
        this.iXo.setFromCDN(this.mIsFromCDN);
        this.iXo.y(this.akE);
        this.iXo.wR();
    }

    public ListView getListView() {
        return this.ekE;
    }

    public void bgi() {
        this.iWN = (LinearLayout) this.iWJ.findViewById(R.id.subpb_head_user_info_root);
        this.iWN.setOnClickListener(this.akE);
        this.iWO = (HeadImageView) this.iWJ.findViewById(R.id.photo);
        this.iWO.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iWK.getActivity(), R.dimen.ds30));
        this.iWO.setClickable(false);
        this.iSR = (ClickableHeaderImageView) this.iWJ.findViewById(R.id.god_user_photo);
        this.iSR.setGodIconMargin(0);
        this.iSR.setGodIconWidth(R.dimen.ds24);
        this.iSR.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iWK.getActivity(), R.dimen.ds30));
        this.iSR.setClickable(false);
        this.cbW = (TextView) this.iWJ.findViewById(R.id.user_name);
        this.iWQ = (ImageView) this.iWJ.findViewById(R.id.user_rank);
        this.iWQ.setVisibility(8);
        this.iSK = (TextView) this.iWJ.findViewById(R.id.floor_owner);
        this.iWM = (TextView) this.iWJ.findViewById(R.id.see_subject);
        this.iWM.setOnClickListener(this.akE);
        this.iWR = (TextView) this.iWJ.findViewById(R.id.floor);
        this.iWS = (TextView) this.iWJ.findViewById(R.id.time);
        this.iWT = (EllipsizeRichTextView) this.iWJ.findViewById(R.id.content_text);
        this.iWT.setOnClickListener(this.akE);
        am.setViewTextColor(this.iWT, (int) R.color.cp_cont_b);
        this.iWT.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.iWT.setLineSpacing(0.0f, 1.25f);
        this.iWU = (TbImageView) this.iWJ.findViewById(R.id.sub_pb_image);
        this.iWU.setOnClickListener(this.akE);
        this.iWV = (TextView) this.iWJ.findViewById(R.id.advert);
        this.NZ = (PlayVoiceBntNew) this.iWJ.findViewById(R.id.voice_btn);
        this.iWJ.setOnTouchListener(this.drk);
        this.iWJ.setOnClickListener(this.akE);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iXf != null) {
            this.iXf.dismiss();
            this.iXf = null;
        }
        this.iXf = new com.baidu.tbadk.core.dialog.b(this.iWK.getPageContext().getPageActivity());
        if (z) {
            this.iXf.a(new String[]{this.iWK.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iXf.a(new String[]{this.iWK.getPageContext().getString(R.string.save_to_emotion), this.iWK.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iXf.d(this.iWK.getPageContext());
        this.iXf.aEH();
    }

    public void cE(View view) {
        this.iWY = view;
    }

    public void bIw() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iWK.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.iWK.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.iWH.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iXd != null) {
                    a.this.iWH.onFinish();
                } else {
                    a.this.iWK.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            layoutParams.leftMargin = dimens2;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.mBack != null && (this.mBack.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mBack.getLayoutParams();
            layoutParams2.width = dimens;
            layoutParams2.height = dimens;
            this.mBack.setLayoutParams(layoutParams2);
        }
        this.mNavigationBar.hideBottomLine();
    }

    public void cA(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.iXe == null) {
            this.iXe = new Dialog(this.iWK.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iXe.setCanceledOnTouchOutside(true);
            this.iXe.setCancelable(true);
            this.iXa = LayoutInflater.from(this.iWK.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iWK.getLayoutMode().onModeChanged(this.iXa);
            this.iXe.setContentView(this.iXa);
            WindowManager.LayoutParams attributes = this.iXe.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iWK.getPageContext().getPageActivity()) * 0.9d);
            this.iXe.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.iXe.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.iXe.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.iXe.findViewById(R.id.disable_reply_btn);
        int i = -1;
        if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
            i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
        }
        if ("".equals(sparseArray.get(R.id.tag_del_post_id)) || i == 2) {
            textView.setVisibility(8);
        } else {
            SparseArray sparseArray2 = (SparseArray) textView.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                textView.setTag(sparseArray2);
            }
            textView.setVisibility(0);
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iXe != null && (a.this.iXe instanceof Dialog)) {
                        g.b(a.this.iXe, a.this.iWK.getPageContext());
                    }
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            });
        }
        if ("".equals(sparseArray.get(R.id.tag_forbid_user_name)) && "".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            textView2.setVisibility(8);
        } else {
            SparseArray sparseArray3 = (SparseArray) textView2.getTag();
            if (sparseArray3 == null) {
                sparseArray3 = new SparseArray();
                textView2.setTag(sparseArray3);
            }
            textView2.setVisibility(0);
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iXe != null && (a.this.iXe instanceof Dialog)) {
                        g.b(a.this.iXe, a.this.iWK.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.iXg != null) {
                        a.this.iXg.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
                    }
                }
            });
        }
        if (!((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue())) {
            textView3.setVisibility(8);
        } else {
            SparseArray sparseArray4 = (SparseArray) textView3.getTag();
            if (sparseArray4 == null) {
                sparseArray4 = new SparseArray();
                textView3.setTag(sparseArray4);
            }
            textView3.setVisibility(0);
            if (z) {
                textView3.setText(R.string.un_mute);
            } else {
                textView3.setText(R.string.mute);
            }
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.iXe != null && (a.this.iXe instanceof Dialog)) {
                        g.b(a.this.iXe, a.this.iWK.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.iWK.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.iXe, this.iWK.getPageContext());
    }

    public void a(int i, String str, int i2, boolean z) {
        final SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        int i3 = R.string.del_post_confirm;
        if (i2 == 1002 && !z) {
            i3 = R.string.report_post_confirm;
        }
        if (i == 0) {
            if (i2 == 1002 && !z) {
                i3 = R.string.report_thread_confirm;
            } else {
                i3 = R.string.del_thread_confirm;
            }
        }
        this.iPU = new com.baidu.tbadk.core.dialog.a(this.iWK.getPageContext().getPageActivity());
        this.iPU.jW(i3);
        this.iPU.setYesButtonTag(sparseArray);
        this.iPU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.iXh != null) {
                    a.this.iXh.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.iPU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iPU.fH(true);
        this.iPU.b(this.iWK.getPageContext());
        if (z) {
            this.iPU.aEG();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bDg;
        if (this.iWK != null && sparseArray != null && this.iWJ != null) {
            if (this.gRC == null) {
                this.gRC = new e(this.iWK.getPageContext(), this.iWJ);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iWm != null && (bDg = this.iWm.bDg()) != null && bDg.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bDg.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.gRC.setDefaultReasonArray(new String[]{this.iWK.getString(R.string.delete_thread_reason_1), this.iWK.getString(R.string.delete_thread_reason_2), this.iWK.getString(R.string.delete_thread_reason_3), this.iWK.getString(R.string.delete_thread_reason_4), this.iWK.getString(R.string.delete_thread_reason_5)});
            this.gRC.setData(alVar);
            this.gRC.wn("4");
            this.gRC.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.iXh != null) {
                        a.this.iXh.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lW(final boolean z) {
        if (this.ekE != null) {
            if (!z) {
                this.ekE.setEnabled(z);
            } else {
                this.ekE.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.ekE.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iXg = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iXh = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iWK.showToast(this.iWK.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iWK.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aOy() != null) {
            this.hRt = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.iWL.addView(hVar.aOy(), layoutParams);
            this.hRt.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.csh();
                }
            });
        }
    }

    public void crN() {
        if (this.ekE != null) {
            this.iXn = this.ekE.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pR(boolean z) {
        if (this.iWm == null || this.iWm.csk() == null) {
            return false;
        }
        if (this.iWm.clb() != 0) {
            return false;
        }
        return (this.iVr == null || this.iVr.aAj() == null || this.iVr.aAj().aCr() == null || !TextUtils.equals(this.iVr.aAj().aCr().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void crO() {
        if (this.iWm != null) {
            if ((!crR() && this.iXc != null && this.iXc.isShown()) || v.isEmpty(this.iXi)) {
                this.iWm.qT(false);
            } else {
                this.iWm.qT(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iWm = subPbModel;
    }

    public void qQ(boolean z) {
        if (this.iWm != null && this.iWm.crL() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.iXd = new BlankView(this.iWK.getPageContext().getPageActivity());
            this.iWI.addView(this.iXd, 0, new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.iXd.setVisibility(0);
            this.iXd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.iWK.finish();
                }
            });
            this.iWH.setBlankView(this.iXd);
        }
    }

    public void crP() {
        b(this.iWK);
        this.ekE.setNextPage(this.iWX);
    }

    public void r(PostData postData) {
        int i;
        if (postData != null) {
            postData.sT(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!crR() && this.iXc != null && this.iXc.isShown()) {
                i = (this.iXn - this.iXm) - 1;
            } else {
                i = this.iXn - this.iXm;
            }
            int count = v.getCount(this.iXi);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.iXi, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.ekE.smoothScrollToPosition(this.iXn + 2);
            this.ekE.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.ekE.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.ekE.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.iWH;
    }

    public void cqu() {
        if (this.iWZ != null) {
            g.dismissPopupWindow(this.iWZ, this.iWK.getPageContext().getPageActivity());
        }
        if (this.iXb != null) {
            this.iXb.dismiss();
        }
        if (this.iPU != null) {
            this.iPU.dismiss();
        }
        if (this.iXe != null) {
            g.b(this.iXe, this.iWK.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iWp != null) {
            this.iWp.dismiss();
        }
    }

    public void crQ() {
        this.ekE.setNextPage(this.iWX);
        this.iWX.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dxw = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (lVar != null) {
            if (this.dxw && this.iWJ != null) {
                this.iWJ.setVisibility(8);
                this.ekE.removeHeaderView(this.iWJ);
                this.iXm = 1;
            }
            this.iVr = lVar;
            if (this.iWJ != null) {
                this.iWJ.setVisibility(0);
            }
            if (lVar.aAj() != null && lVar.aAj().aEm()) {
                this.iWM.setText(R.string.view_original);
            } else {
                this.iWM.setText(R.string.view_subject);
            }
            if (lVar.clB() != null) {
                this.dOR = lVar.clB().cLv();
                if (this.dOR > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iWK.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.dOR)));
                    if (this.iWK != null) {
                        this.gEV.setText(this.iWK.cpI());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.iWK.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.iWK.crL() ? "PB" : null;
                if (lVar.clB().aCM() != null) {
                    this.iWW.setData(this.iWK.getPageContext(), lVar.clB().aCM(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aPr().getId(), lVar.aPr().getName(), lVar.aAj().getId(), str));
                } else {
                    this.iWW.setData(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.iWX.startLoadData();
                this.iXo.setHasMoreData(true);
            } else {
                this.iWX.endLoadData();
                this.iXo.setHasMoreData(false);
            }
            this.iXi = lVar.clF();
            if (this.iXi == null || this.iXi.size() <= iWG) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.iXi.size() - iWG;
                zw(size);
                int firstVisiblePosition = this.ekE.getFirstVisiblePosition() - size;
                View childAt = this.ekE.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iXi);
            if (v.isEmpty(this.iXi)) {
                this.ekE.setNextPage(null);
                if (this.dxw) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.ekE.setNextPage(this.iWX);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(lVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dxw) {
                arrayList.add(0, lVar.clB());
            }
            this.iXo.b(this.iVr.aAj(), arrayList);
            a(lVar, lVar.clB(), lVar.bXN(), lVar.ayO(), i, z);
            if (i4 > 0) {
                this.ekE.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void zw(int i) {
        if (this.iXi != null) {
            if (this.iXi.size() <= i) {
                this.iXi.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iXi.iterator();
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

    public boolean crR() {
        return this.iXo.acd();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dxw) {
            if (!StringUtils.isNull(postData.cLC())) {
                this.iWU.setVisibility(0);
                this.iWU.startLoad(postData.cLC(), 10, true);
            } else {
                this.iWU.setVisibility(8);
            }
            i cLE = postData.cLE();
            if (cLE != null && cLE.khP) {
                this.iWV.setVisibility(0);
            } else {
                this.iWV.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iWJ.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iWJ.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iWR.setText((CharSequence) null);
            this.cbW.setText((CharSequence) null);
            this.iSK.setVisibility(8);
            if (!this.dxw) {
                c(postData.aCr());
                if (z) {
                    this.iSK.setVisibility(0);
                    am.setViewTextColor(this.iSK, (int) R.color.cp_link_tip_a);
                }
            }
            this.iWS.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.iWK.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cLv()));
            if (lVar.aAj() != null && lVar.aAj().aEm()) {
                this.iWR.setText((CharSequence) null);
            } else {
                this.iWR.setText(format);
            }
            postData.aCr().getUserTbVipInfoData();
            boolean a = a(this.iWT, postData.cLx());
            if (StringUtils.isNull(postData.cLC()) && !a && postData.aUf() != null) {
                this.NZ.setVisibility(0);
                this.NZ.setTag(postData.aUf());
                return;
            }
            this.NZ.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ad.getTextLength(name_show) > 14) {
                str = ad.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.cbW.setText(cA(metaData.getSealPrefix(), str));
            } else {
                this.cbW.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.iWP != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iWP.setVisibility(8);
                } else {
                    this.iWP.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cKd = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iWP.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.iSR.setVisibility(0);
                this.iWO.setVisibility(8);
                this.iSR.setUserId(metaData.getUserId());
                this.iSR.setUserName(metaData.getUserName());
                this.iSR.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbW, (int) R.color.cp_cont_r);
            } else {
                this.iSR.setVisibility(8);
                this.iWO.setVisibility(0);
                this.iWO.setUserId(metaData.getUserId());
                this.iWO.setUserName(metaData.getUserName());
                this.iWO.setDefaultResource(R.drawable.transparent_bg);
                this.iWO.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iWO.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbW, (int) R.color.cp_cont_c);
            }
            this.iWN.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iWN.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iWN.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.aTX() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.aTX().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.aUe());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.hn(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cTP());
                        continue;
                    case 17:
                        String str = next.aUi().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.j("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.aUm()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.aUe() == null || tbRichTextData.aUe().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.aUe());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iWK.getPageContext().getString(R.string.refresh_view_button_text), this.cLl));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iWK.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iWL, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.ekE.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.hRt.aPx();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iWK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void ww(int i) {
        b(NoDataViewFactory.d.cz(null, this.iWK.getResources().getString(R.string.refresh_view_title_text)));
        this.iXj.setVisibility(8);
    }

    public void zO(String str) {
        b(NoDataViewFactory.d.cz(str, this.iWK.getPageContext().getString(R.string.refresh_view_title_text)));
        this.iXj.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.ekE.setVisibility(0);
            this.iXj.setVisibility(0);
            this.iWH.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLl = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x028c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        int i2;
        boolean z4;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z5 = false;
            boolean z6 = false;
            if (i != 0) {
                if (i != 3) {
                    z5 = true;
                    z6 = true;
                }
                String userId2 = postData.aCr().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.iVr != null && this.iVr.aAj() != null && this.iVr.aAj().aCr() != null && postData.aCr() != null) {
                String userId3 = this.iVr.aAj().aCr().getUserId();
                String userId4 = postData.aCr().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aCr().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.cLv() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aCr() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCr().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCr().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCr().getPortrait());
                        }
                    } else {
                        z4 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z4));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z5) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.aCr() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCr().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCr().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCr().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCr() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCr().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCr().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCr().getName_show());
                        }
                        if (this.iVr.aAj() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iVr.aAj().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z3));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z = false;
            z2 = z6;
            z3 = false;
            userId = postData.aCr().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.cLv() == 1) {
            }
            if (!z5) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z4));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z5) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void qR(boolean z) {
        if (this.iWp != null && this.iWp.coS() != null) {
            if (z) {
                this.iWp.coS().setText(R.string.remove_mark);
            } else {
                this.iWp.coS().setText(R.string.mark);
            }
        }
    }

    public View crS() {
        return this.iXc;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iWH, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.iWL, R.color.cp_bg_line_d);
        this.iWK.getLayoutMode().setNightMode(i == 1);
        this.iWK.getLayoutMode().onModeChanged(this.iWH);
        this.iWK.getLayoutMode().onModeChanged(this.iWJ);
        this.mNavigationBar.onChangeSkinType(this.iWK.getPageContext(), i);
        if (this.iWM != null) {
            am.setViewTextColor(this.iWM, (int) R.color.goto_see_subject_color);
        }
        this.gkY.onChangeSkinType(this.iWK.getPageContext(), i);
        this.iWK.getLayoutMode().onModeChanged(this.iXc);
        am.setViewTextColor(this.iWT, (int) R.color.cp_cont_b);
        this.iWT.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.hRt != null && this.hRt.aOy() != null) {
            this.hRt.aOy().onChangeSkinType(i);
        }
        this.iWX.changeSkin(i);
        this.NZ.can();
        am.setViewTextColor(this.gEV, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.iSK, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.cbW, (int) R.color.cp_cont_c);
        this.gEV.setAlpha(0.95f);
        if (this.iWY != null) {
            com.baidu.tbadk.q.a.a(this.iWK.getPageContext(), this.iWY);
        }
        if (this.iXo != null) {
            this.iXo.notifyDataSetChanged();
        }
        this.iWK.getLayoutMode().onModeChanged(this.iXa);
    }

    public void crT() {
        this.mProgress.setVisibility(0);
    }

    public void crU() {
        this.ekE.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iWX.endLoadData();
    }

    public void bBj() {
        this.ekE.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iWX.bBj();
    }

    public boolean crV() {
        return this.iWH.crV();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iXo.setLongClickListener(onLongClickListener);
    }

    public View crW() {
        return this.iWJ;
    }

    public TextView bIB() {
        return this.gEV;
    }

    public ImageView crX() {
        return this.iXk;
    }

    public ImageView crY() {
        return this.iXl;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zx(int i) {
    }

    public View crZ() {
        return this.iWM;
    }

    public View csa() {
        return this.iWU;
    }

    public MorePopupWindow csb() {
        return this.iWZ;
    }

    public void showLoadingDialog() {
        if (this.fQQ == null) {
            this.fQQ = new com.baidu.tbadk.core.view.a(this.iWK.getPageContext());
        }
        this.fQQ.setDialogVisiable(true);
    }

    public void bqx() {
        if (this.fQQ != null) {
            this.fQQ.setDialogVisiable(false);
        }
    }

    public TextView csc() {
        return this.iWT;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iXo.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.iXo != null) {
            this.iXo.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.pb.pb.main.w csd() {
        return this.iWp;
    }

    public void bKD() {
    }

    public void bKE() {
    }

    public void aiL() {
        this.iWH.onDestroy();
    }

    public void cse() {
        if (this.iWK.isPaused()) {
        }
    }

    public View csf() {
        return this.iWN;
    }

    private SpannableStringBuilder cA(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iWK.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int csg() {
        if (this.hRt == null || this.hRt.aOy() == null) {
            return 0;
        }
        return this.hRt.aOy().getHeight();
    }

    public void csh() {
        if (this.gEV != null && this.hRt != null) {
            if (this.hRt.aPC()) {
                this.gEV.setText(R.string.draft_to_send);
            } else {
                this.gEV.setText(this.iWK.cpI());
            }
        }
    }
}
