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
import com.baidu.tieba.tbadkCore.v;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes9.dex */
public class a implements KeyboardEventLayout.a {
    private static final int iVf = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aku;
    private BdTypeListView eko;
    private com.baidu.tbadk.core.view.a fQi;
    private TextView gDX;
    private e gQv;
    private View gei;
    private NoNetworkView gkq;
    private l iTQ;
    private SubPbModel iUL;
    private w iUO;
    private View iVB;
    private BlankView iVC;
    private com.baidu.tbadk.core.dialog.b iVE;
    private ArrayList<PostData> iVH;
    private RelativeLayout iVI;
    private ImageView iVJ;
    private ImageView iVK;
    private c iVN;
    private SubPbView iVg;
    private LinearLayout iVh;
    private View iVi;
    private NewSubPbActivity iVj;
    private RelativeLayout iVk;
    private View iVo;
    private ThreadSkinView iVv;
    private d iVw;
    private View iVx;
    private View iVz;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener cLa = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iVl = null;
    private LinearLayout iVm = null;
    private HeadImageView iVn = null;
    private ClickableHeaderImageView iRq = null;
    private TextView cbL = null;
    private ImageView iVp = null;
    private TextView iRj = null;
    private TextView iVq = null;
    private TextView iVr = null;
    private EllipsizeRichTextView iVs = null;
    private TbImageView iVt = null;
    private PlayVoiceBntNew NY = null;
    private TextView iVu = null;
    private MorePopupWindow iVy = null;
    private com.baidu.tbadk.core.dialog.b iVA = null;
    private Dialog iVD = null;
    private com.baidu.tbadk.core.dialog.a iOt = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a iVF = null;
    private NewSubPbActivity.a iVG = null;
    private h hPT = null;
    private int dOA = 0;
    private int iVL = 2;
    private int iVM = 0;
    private boolean dxj = true;
    private com.baidu.tieba.pb.a.c dqX = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lR(false);
            a.this.lR(true);
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
    protected AdapterView.OnItemLongClickListener iVO = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.iVH, i);
            if (view != null && view.getTag() != null) {
                if (a.this.iUO == null) {
                    a.this.iUO = new w(a.this.iVj.getPageContext(), a.this.aku);
                }
                a.this.iUO.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.pL(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.iUO.a(sparseArray, a.this.iUL.ckH(), z);
                if (z) {
                    a.this.iUO.coz().setVisibility(0);
                    a.this.iUO.coz().setTag(postData.getId());
                } else {
                    a.this.iUO.coz().setVisibility(8);
                }
                a.this.iUO.cox().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iVP = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.iVj != null && bc.checkUpIsLogin(a.this.iVj.getPageContext().getPageActivity())) {
                if ((a.this.iVj.hPK == null || a.this.iUL == null || a.this.iUL.bCZ() == null || a.this.iVj.hPK.ks(a.this.iUL.bCZ().replyPrivateFlag)) && a.this.iUL != null && a.this.hPT != null) {
                    a.this.crs();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cru();
                        a.this.iUL.crS();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.hPT.setReplyId(str2);
                            a.this.hPT.vt(str);
                        }
                    }
                    a.this.crt();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.iVg = null;
        this.iVi = null;
        this.eko = null;
        this.iVj = null;
        this.gkq = null;
        this.iVk = null;
        this.iVo = null;
        this.iVw = null;
        this.iVB = null;
        this.aku = null;
        this.mProgress = null;
        this.gDX = null;
        this.iVI = null;
        this.iVJ = null;
        this.iVK = null;
        this.iVj = newSubPbActivity;
        this.aku = onClickListener;
        this.iVg = (SubPbView) LayoutInflater.from(this.iVj.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iVi = LayoutInflater.from(this.iVj.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iVh = (LinearLayout) this.iVg.findViewById(R.id.navigation_bar_group);
        this.iVI = (RelativeLayout) this.iVg.findViewById(R.id.subpb_editor_tool_comment);
        this.gDX = (TextView) this.iVg.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gDX.setOnClickListener(this.aku);
        this.iVJ = (ImageView) this.iVg.findViewById(R.id.subpb_editor_tool_more_img);
        this.iVK = (ImageView) this.iVg.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iVK.setOnClickListener(this.aku);
        this.iVJ.setOnClickListener(this.aku);
        this.gkq = (NoNetworkView) this.iVg.findViewById(R.id.view_no_network);
        bIk();
        bgd();
        this.iVk = (RelativeLayout) this.iVg.findViewById(R.id.sub_pb_body_layout);
        this.eko = (BdTypeListView) this.iVg.findViewById(R.id.new_sub_pb_list);
        this.iVv = (ThreadSkinView) LayoutInflater.from(this.iVj.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.eko.addHeaderView(this.iVv);
        this.eko.addHeaderView(this.iVi);
        this.gei = new TextView(newSubPbActivity.getActivity());
        this.gei.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.eko.addHeaderView(this.gei, 0);
        this.iVg.setTopView(this.gei);
        this.iVg.setNavigationView(this.iVh);
        this.iVg.setListView(this.eko);
        this.iVg.setContentView(this.iVk);
        this.iVw = new d(this.iVj.getPageContext());
        this.iVw.setLineGone();
        this.iVB = this.iVw.getView();
        this.eko.setNextPage(this.iVw);
        this.iVw.setOnClickListener(this.aku);
        this.eko.setOnItemClickListener(this.iVP);
        this.eko.setOnItemLongClickListener(this.iVO);
        this.eko.setOnTouchListener(this.dqX);
        this.mProgress = (ProgressBar) this.iVg.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iVi != null) {
            this.iVi.setVisibility(4);
        }
        this.iVo = com.baidu.tbadk.ala.b.ayB().u(this.iVj.getActivity(), 4);
        if (this.iVo != null) {
            this.iVo.setVisibility(8);
            this.iVm.addView(this.iVo, 3);
        }
        this.iVN = new c(this.iVj, this.eko);
        this.iVN.setFromCDN(this.mIsFromCDN);
        this.iVN.y(this.aku);
        this.iVN.wM();
    }

    public ListView getListView() {
        return this.eko;
    }

    public void bgd() {
        this.iVm = (LinearLayout) this.iVi.findViewById(R.id.subpb_head_user_info_root);
        this.iVm.setOnClickListener(this.aku);
        this.iVn = (HeadImageView) this.iVi.findViewById(R.id.photo);
        this.iVn.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iVj.getActivity(), R.dimen.ds30));
        this.iVn.setClickable(false);
        this.iRq = (ClickableHeaderImageView) this.iVi.findViewById(R.id.god_user_photo);
        this.iRq.setGodIconMargin(0);
        this.iRq.setGodIconWidth(R.dimen.ds24);
        this.iRq.setRadius(com.baidu.adp.lib.util.l.getDimens(this.iVj.getActivity(), R.dimen.ds30));
        this.iRq.setClickable(false);
        this.cbL = (TextView) this.iVi.findViewById(R.id.user_name);
        this.iVp = (ImageView) this.iVi.findViewById(R.id.user_rank);
        this.iVp.setVisibility(8);
        this.iRj = (TextView) this.iVi.findViewById(R.id.floor_owner);
        this.iVl = (TextView) this.iVi.findViewById(R.id.see_subject);
        this.iVl.setOnClickListener(this.aku);
        this.iVq = (TextView) this.iVi.findViewById(R.id.floor);
        this.iVr = (TextView) this.iVi.findViewById(R.id.time);
        this.iVs = (EllipsizeRichTextView) this.iVi.findViewById(R.id.content_text);
        this.iVs.setOnClickListener(this.aku);
        am.setViewTextColor(this.iVs, (int) R.color.cp_cont_b);
        this.iVs.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.iVs.setLineSpacing(0.0f, 1.25f);
        this.iVt = (TbImageView) this.iVi.findViewById(R.id.sub_pb_image);
        this.iVt.setOnClickListener(this.aku);
        this.iVu = (TextView) this.iVi.findViewById(R.id.advert);
        this.NY = (PlayVoiceBntNew) this.iVi.findViewById(R.id.voice_btn);
        this.iVi.setOnTouchListener(this.dqX);
        this.iVi.setOnClickListener(this.aku);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iVE != null) {
            this.iVE.dismiss();
            this.iVE = null;
        }
        this.iVE = new com.baidu.tbadk.core.dialog.b(this.iVj.getPageContext().getPageActivity());
        if (z) {
            this.iVE.a(new String[]{this.iVj.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iVE.a(new String[]{this.iVj.getPageContext().getString(R.string.save_to_emotion), this.iVj.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iVE.d(this.iVj.getPageContext());
        this.iVE.aED();
    }

    public void cE(View view) {
        this.iVx = view;
    }

    public void bIk() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.iVj.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.iVj.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.iVg.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iVC != null) {
                    a.this.iVg.onFinish();
                } else {
                    a.this.iVj.finish();
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
        if (this.iVD == null) {
            this.iVD = new Dialog(this.iVj.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iVD.setCanceledOnTouchOutside(true);
            this.iVD.setCancelable(true);
            this.iVz = LayoutInflater.from(this.iVj.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iVj.getLayoutMode().onModeChanged(this.iVz);
            this.iVD.setContentView(this.iVz);
            WindowManager.LayoutParams attributes = this.iVD.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.iVj.getPageContext().getPageActivity()) * 0.9d);
            this.iVD.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.iVD.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.iVD.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.iVD.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.iVD != null && (a.this.iVD instanceof Dialog)) {
                        g.b(a.this.iVD, a.this.iVj.getPageContext());
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
                    if (a.this.iVD != null && (a.this.iVD instanceof Dialog)) {
                        g.b(a.this.iVD, a.this.iVj.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.iVF != null) {
                        a.this.iVF.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.iVD != null && (a.this.iVD instanceof Dialog)) {
                        g.b(a.this.iVD, a.this.iVj.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.iVj.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.iVD, this.iVj.getPageContext());
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
        this.iOt = new com.baidu.tbadk.core.dialog.a(this.iVj.getPageContext().getPageActivity());
        this.iOt.jW(i3);
        this.iOt.setYesButtonTag(sparseArray);
        this.iOt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.iVG != null) {
                    a.this.iVG.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.iOt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iOt.fG(true);
        this.iOt.b(this.iVj.getPageContext());
        if (z) {
            this.iOt.aEC();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bCZ;
        if (this.iVj != null && sparseArray != null && this.iVi != null) {
            if (this.gQv == null) {
                this.gQv = new e(this.iVj.getPageContext(), this.iVi);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iUL != null && (bCZ = this.iUL.bCZ()) != null && bCZ.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bCZ.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.gQv.setDefaultReasonArray(new String[]{this.iVj.getString(R.string.delete_thread_reason_1), this.iVj.getString(R.string.delete_thread_reason_2), this.iVj.getString(R.string.delete_thread_reason_3), this.iVj.getString(R.string.delete_thread_reason_4), this.iVj.getString(R.string.delete_thread_reason_5)});
            this.gQv.setData(alVar);
            this.gQv.wn("4");
            this.gQv.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.iVG != null) {
                        a.this.iVG.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lR(final boolean z) {
        if (this.eko != null) {
            if (!z) {
                this.eko.setEnabled(z);
            } else {
                this.eko.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eko.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iVF = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iVG = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iVj.showToast(this.iVj.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iVj.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aOu() != null) {
            this.hPT = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.iVk.addView(hVar.aOu(), layoutParams);
            this.hPT.a(new v.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    a.this.crM();
                }
            });
        }
    }

    public void crs() {
        if (this.eko != null) {
            this.iVM = this.eko.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pL(boolean z) {
        if (this.iUL == null || this.iUL.crP() == null) {
            return false;
        }
        if (this.iUL.ckH() != 0) {
            return false;
        }
        return (this.iTQ == null || this.iTQ.aAg() == null || this.iTQ.aAg().aCo() == null || !TextUtils.equals(this.iTQ.aAg().aCo().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void crt() {
        if (this.iUL != null) {
            if ((!crw() && this.iVB != null && this.iVB.isShown()) || com.baidu.tbadk.core.util.v.isEmpty(this.iVH)) {
                this.iUL.qN(false);
            } else {
                this.iUL.qN(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iUL = subPbModel;
    }

    public void qK(boolean z) {
        if (this.iUL != null && this.iUL.crq() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.iVC = new BlankView(this.iVj.getPageContext().getPageActivity());
            this.iVh.addView(this.iVC, 0, new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.iVC.setVisibility(0);
            this.iVC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.iVj.finish();
                }
            });
            this.iVg.setBlankView(this.iVC);
        }
    }

    public void cru() {
        b(this.iVj);
        this.eko.setNextPage(this.iVw);
    }

    public void r(PostData postData) {
        int i;
        if (postData != null) {
            postData.sN(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!crw() && this.iVB != null && this.iVB.isShown()) {
                i = (this.iVM - this.iVL) - 1;
            } else {
                i = this.iVM - this.iVL;
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.iVH);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.v.subList(this.iVH, 0, i));
            com.baidu.tbadk.core.util.v.add(arrayList, postData2);
            com.baidu.tbadk.core.util.v.add(arrayList, postData);
            this.eko.smoothScrollToPosition(this.iVM + 2);
            this.eko.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eko.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.eko.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.iVg;
    }

    public void cpZ() {
        if (this.iVy != null) {
            g.dismissPopupWindow(this.iVy, this.iVj.getPageContext().getPageActivity());
        }
        if (this.iVA != null) {
            this.iVA.dismiss();
        }
        if (this.iOt != null) {
            this.iOt.dismiss();
        }
        if (this.iVD != null) {
            g.b(this.iVD, this.iVj.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iUO != null) {
            this.iUO.dismiss();
        }
    }

    public void crv() {
        this.eko.setNextPage(this.iVw);
        this.iVw.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dxj = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (lVar != null) {
            if (this.dxj && this.iVi != null) {
                this.iVi.setVisibility(8);
                this.eko.removeHeaderView(this.iVi);
                this.iVL = 1;
            }
            this.iTQ = lVar;
            if (this.iVi != null) {
                this.iVi.setVisibility(0);
            }
            if (lVar.aAg() != null && lVar.aAg().aEi()) {
                this.iVl.setText(R.string.view_original);
            } else {
                this.iVl.setText(R.string.view_subject);
            }
            if (lVar.clg() != null) {
                this.dOA = lVar.clg().cLb();
                if (this.dOA > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iVj.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.dOA)));
                    if (this.iVj != null) {
                        this.gDX.setText(this.iVj.cpn());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.iVj.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.iVj.crq() ? "PB" : null;
                if (lVar.clg().aCJ() != null) {
                    this.iVv.setData(this.iVj.getPageContext(), lVar.clg().aCJ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aPn().getId(), lVar.aPn().getName(), lVar.aAg().getId(), str));
                } else {
                    this.iVv.setData(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.iVw.startLoadData();
                this.iVN.setHasMoreData(true);
            } else {
                this.iVw.endLoadData();
                this.iVN.setHasMoreData(false);
            }
            this.iVH = lVar.clk();
            if (this.iVH == null || this.iVH.size() <= iVf) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.iVH.size() - iVf;
                zo(size);
                int firstVisiblePosition = this.eko.getFirstVisiblePosition() - size;
                View childAt = this.eko.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.iVH);
            if (com.baidu.tbadk.core.util.v.isEmpty(this.iVH)) {
                this.eko.setNextPage(null);
                if (this.dxj) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.eko.setNextPage(this.iVw);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(lVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dxj) {
                arrayList.add(0, lVar.clg());
            }
            this.iVN.b(this.iTQ.aAg(), arrayList);
            a(lVar, lVar.clg(), lVar.bXv(), lVar.ayL(), i, z);
            if (i4 > 0) {
                this.eko.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void zo(int i) {
        if (this.iVH != null) {
            if (this.iVH.size() <= i) {
                this.iVH.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iVH.iterator();
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

    public boolean crw() {
        return this.iVN.aca();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dxj) {
            if (!StringUtils.isNull(postData.cLi())) {
                this.iVt.setVisibility(0);
                this.iVt.startLoad(postData.cLi(), 10, true);
            } else {
                this.iVt.setVisibility(8);
            }
            i cLk = postData.cLk();
            if (cLk != null && cLk.kgn) {
                this.iVu.setVisibility(0);
            } else {
                this.iVu.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iVi.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iVi.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iVq.setText((CharSequence) null);
            this.cbL.setText((CharSequence) null);
            this.iRj.setVisibility(8);
            if (!this.dxj) {
                c(postData.aCo());
                if (z) {
                    this.iRj.setVisibility(0);
                    am.setViewTextColor(this.iRj, (int) R.color.cp_link_tip_a);
                }
            }
            this.iVr.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.iVj.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cLb()));
            if (lVar.aAg() != null && lVar.aAg().aEi()) {
                this.iVq.setText((CharSequence) null);
            } else {
                this.iVq.setText(format);
            }
            postData.aCo().getUserTbVipInfoData();
            boolean a = a(this.iVs, postData.cLd());
            if (StringUtils.isNull(postData.cLi()) && !a && postData.aUb() != null) {
                this.NY.setVisibility(0);
                this.NY.setTag(postData.aUb());
                return;
            }
            this.NY.setVisibility(8);
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
                this.cbL.setText(cB(metaData.getSealPrefix(), str));
            } else {
                this.cbL.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.iVo != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iVo.setVisibility(8);
                } else {
                    this.iVo.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cJS = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iVo.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.iRq.setVisibility(0);
                this.iVn.setVisibility(8);
                this.iRq.setUserId(metaData.getUserId());
                this.iRq.setUserName(metaData.getUserName());
                this.iRq.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbL, (int) R.color.cp_cont_r);
            } else {
                this.iRq.setVisibility(8);
                this.iVn.setVisibility(0);
                this.iVn.setUserId(metaData.getUserId());
                this.iVn.setUserName(metaData.getUserName());
                this.iVn.setDefaultResource(R.drawable.transparent_bg);
                this.iVn.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iVn.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cbL, (int) R.color.cp_cont_c);
            }
            this.iVm.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iVm.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iVm.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.aTT() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.aTT().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.aUa());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.hm(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cTv());
                        continue;
                    case 17:
                        String str = next.aUe().mGifInfo.mSharpText;
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
        if (!tbRichTextData.aUi()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.aUa() == null || tbRichTextData.aUa().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.aUa());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iVj.getPageContext().getString(R.string.refresh_view_button_text), this.cLa));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iVj.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iVk, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.eko.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.hPT.aPt();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iVj.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wo(int i) {
        b(NoDataViewFactory.d.cA(null, this.iVj.getResources().getString(R.string.refresh_view_title_text)));
        this.iVI.setVisibility(8);
    }

    public void zN(String str) {
        b(NoDataViewFactory.d.cA(str, this.iVj.getPageContext().getString(R.string.refresh_view_title_text)));
        this.iVI.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eko.setVisibility(0);
            this.iVI.setVisibility(0);
            this.iVg.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.cLa = onClickListener;
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
                String userId2 = postData.aCo().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.iTQ != null && this.iTQ.aAg() != null && this.iTQ.aAg().aCo() != null && postData.aCo() != null) {
                String userId3 = this.iTQ.aAg().aCo().getUserId();
                String userId4 = postData.aCo().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aCo().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.cLb() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
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
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aCo().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aCo().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aCo() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aCo().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aCo().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aCo().getName_show());
                        }
                        if (this.iTQ.aAg() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iTQ.aAg().getId());
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
            userId = postData.aCo().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.cLb() == 1) {
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

    public void qL(boolean z) {
        if (this.iUO != null && this.iUO.cox() != null) {
            if (z) {
                this.iUO.cox().setText(R.string.remove_mark);
            } else {
                this.iUO.cox().setText(R.string.mark);
            }
        }
    }

    public View crx() {
        return this.iVB;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iVg, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.iVk, R.color.cp_bg_line_d);
        this.iVj.getLayoutMode().setNightMode(i == 1);
        this.iVj.getLayoutMode().onModeChanged(this.iVg);
        this.iVj.getLayoutMode().onModeChanged(this.iVi);
        this.mNavigationBar.onChangeSkinType(this.iVj.getPageContext(), i);
        if (this.iVl != null) {
            am.setViewTextColor(this.iVl, (int) R.color.goto_see_subject_color);
        }
        this.gkq.onChangeSkinType(this.iVj.getPageContext(), i);
        this.iVj.getLayoutMode().onModeChanged(this.iVB);
        am.setViewTextColor(this.iVs, (int) R.color.cp_cont_b);
        this.iVs.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.hPT != null && this.hPT.aOu() != null) {
            this.hPT.aOu().onChangeSkinType(i);
        }
        this.iVw.changeSkin(i);
        this.NY.bHt();
        am.setViewTextColor(this.gDX, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.iRj, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.cbL, (int) R.color.cp_cont_c);
        this.gDX.setAlpha(0.95f);
        if (this.iVx != null) {
            com.baidu.tbadk.q.a.a(this.iVj.getPageContext(), this.iVx);
        }
        if (this.iVN != null) {
            this.iVN.notifyDataSetChanged();
        }
        this.iVj.getLayoutMode().onModeChanged(this.iVz);
    }

    public void cry() {
        this.mProgress.setVisibility(0);
    }

    public void crz() {
        this.eko.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iVw.endLoadData();
    }

    public void bBd() {
        this.eko.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iVw.bBd();
    }

    public boolean crA() {
        return this.iVg.crA();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iVN.setLongClickListener(onLongClickListener);
    }

    public View crB() {
        return this.iVi;
    }

    public TextView bIp() {
        return this.gDX;
    }

    public ImageView crC() {
        return this.iVJ;
    }

    public ImageView crD() {
        return this.iVK;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zp(int i) {
    }

    public View crE() {
        return this.iVl;
    }

    public View crF() {
        return this.iVt;
    }

    public MorePopupWindow crG() {
        return this.iVy;
    }

    public void showLoadingDialog() {
        if (this.fQi == null) {
            this.fQi = new com.baidu.tbadk.core.view.a(this.iVj.getPageContext());
        }
        this.fQi.setDialogVisiable(true);
    }

    public void bqs() {
        if (this.fQi != null) {
            this.fQi.setDialogVisiable(false);
        }
    }

    public TextView crH() {
        return this.iVs;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iVN.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.iVN != null) {
            this.iVN.notifyDataSetChanged();
        }
    }

    public w crI() {
        return this.iUO;
    }

    public void bKq() {
    }

    public void bKr() {
    }

    public void aiI() {
        this.iVg.onDestroy();
    }

    public void crJ() {
        if (this.iVj.isPaused()) {
        }
    }

    public View crK() {
        return this.iVm;
    }

    private SpannableStringBuilder cB(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iVj.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int crL() {
        if (this.hPT == null || this.hPT.aOu() == null) {
            return 0;
        }
        return this.hPT.aOu().getHeight();
    }

    public void crM() {
        if (this.gDX != null && this.hPT != null) {
            if (this.hPT.aPy()) {
                this.gDX.setText(R.string.draft_to_send);
            } else {
                this.gDX.setText(this.iVj.cpn());
            }
        }
    }
}
