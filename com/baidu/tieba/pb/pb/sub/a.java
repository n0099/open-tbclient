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
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.at;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.f;
import com.baidu.tieba.NEGFeedBack.i;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.aa;
import com.baidu.tieba.pb.pb.sub.NewSubPbActivity;
import com.baidu.tieba.pb.pb.sub.b;
import com.baidu.tieba.pb.view.KeyboardEventLayout;
import com.baidu.tieba.pb.view.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes2.dex */
public class a implements KeyboardEventLayout.a {
    private static final int lXt = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aYB;
    private ImageView eFv;
    private NoNetworkView fJE;
    private LinearLayout fJF;
    private f.c fhg;
    private BdTypeListView gwr;
    private View iQc;
    private com.baidu.tbadk.core.view.a ixW;
    private com.baidu.tieba.NEGFeedBack.f jJX;
    private TextView jvO;
    private LinearLayout lQA;
    private HeadImageView lQB;
    private e lQe;
    private View lQy;
    private i lRy;
    private SubPbModel lWQ;
    private aa lWT;
    private p lWb;
    private View lXB;
    private ThreadSkinView lXI;
    private d lXJ;
    private View lXK;
    private View lXM;
    private View lXO;
    private BlankView lXP;
    private com.baidu.tbadk.core.dialog.b lXR;
    private ArrayList<PostData> lXU;
    private RelativeLayout lXV;
    private ImageView lXW;
    private ImageView lXX;
    private SubPbView lXu;
    private View lXv;
    private NewSubPbActivity lXw;
    private RelativeLayout lXx;
    private c lYa;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener eFA = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView lXy = null;
    private LinearLayout lXz = null;
    private HeadImageView lXA = null;
    private TextView eGI = null;
    private ImageView lXC = null;
    private TextView lTi = null;
    private TextView lXD = null;
    private TextView lXE = null;
    private EllipsizeRichTextView lXF = null;
    private TbImageView lXG = null;
    private PlayVoiceBntNew alm = null;
    private TextView lXH = null;
    private MorePopupWindow lXL = null;
    private com.baidu.tbadk.core.dialog.b lXN = null;
    private Dialog lXQ = null;
    private com.baidu.tbadk.core.dialog.a lQj = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a lXS = null;
    private NewSubPbActivity.a lXT = null;
    private h kKo = null;
    private int fUy = 0;
    private int lXY = 2;
    private int lXZ = 0;
    private boolean fzv = true;
    private boolean lIB = com.baidu.tbadk.a.d.biM();
    private com.baidu.tieba.pb.a.c ftt = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.8
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.rc(false);
            a.this.rc(true);
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
    protected AdapterView.OnItemLongClickListener lYb = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) x.getItem(a.this.lXU, i);
            if (view != null && view.getTag() != null) {
                if (a.this.lWT == null) {
                    a.this.lWT = new aa(a.this.lXw.getPageContext(), a.this.aYB);
                }
                a.this.lWT.Pd();
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                    sparseArray = null;
                }
                if (sparseArray == null) {
                    return true;
                }
                PostData postData2 = sparseArray.get(R.id.tag_clip_board) instanceof PostData ? (PostData) sparseArray.get(R.id.tag_clip_board) : null;
                boolean z2 = a.this.uL(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                aa aaVar = a.this.lWT;
                int djc = a.this.lWQ.djc();
                if (!a.this.lIB || postData2 == null || !postData2.nnK) {
                    z = false;
                }
                aaVar.a(sparseArray, djc, z2, z);
                if (z2) {
                    a.this.lWT.dnh().setVisibility(0);
                    a.this.lWT.dnh().setTag(postData.getId());
                } else {
                    a.this.lWT.dnh().setVisibility(8);
                }
                a.this.lWT.dnf().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener lYc = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.lXw != null && bg.checkUpIsLogin(a.this.lXw.getPageContext().getPageActivity())) {
                if ((a.this.lXw.kKi == null || a.this.lWQ == null || a.this.lWQ.cAh() == null || a.this.lXw.kKi.os(a.this.lWQ.cAh().replyPrivateFlag)) && a.this.lWQ != null && a.this.kKo != null) {
                    a.this.dqn();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.dqp();
                        a.this.lWQ.dqO();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.kKo.setReplyId(str2);
                            a.this.kKo.CN(str);
                        }
                    }
                    a.this.dqo();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.lXu = null;
        this.lXv = null;
        this.gwr = null;
        this.lQe = null;
        this.lXw = null;
        this.fJE = null;
        this.lXx = null;
        this.lXB = null;
        this.lXJ = null;
        this.lXO = null;
        this.aYB = null;
        this.mProgress = null;
        this.jvO = null;
        this.lXV = null;
        this.lXW = null;
        this.lXX = null;
        this.lXw = newSubPbActivity;
        this.aYB = onClickListener;
        this.lXu = (SubPbView) LayoutInflater.from(this.lXw.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.lXv = LayoutInflater.from(this.lXw.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.fJF = (LinearLayout) this.lXu.findViewById(R.id.navigation_bar_group);
        this.lXV = (RelativeLayout) this.lXu.findViewById(R.id.subpb_editor_tool_comment);
        this.jvO = (TextView) this.lXu.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.jvO.setOnClickListener(this.aYB);
        this.lXW = (ImageView) this.lXu.findViewById(R.id.subpb_editor_tool_more_img);
        this.lXX = (ImageView) this.lXu.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.lXX.setOnClickListener(this.aYB);
        this.lXW.setOnClickListener(this.aYB);
        this.fJE = (NoNetworkView) this.lXu.findViewById(R.id.view_no_network);
        cHg();
        bVL();
        this.lXx = (RelativeLayout) this.lXu.findViewById(R.id.sub_pb_body_layout);
        this.gwr = (BdTypeListView) this.lXu.findViewById(R.id.new_sub_pb_list);
        this.lXI = (ThreadSkinView) LayoutInflater.from(this.lXw.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.gwr.addHeaderView(this.lXI);
        this.gwr.addHeaderView(this.lXv);
        this.iQc = new TextView(newSubPbActivity.getActivity());
        this.iQc.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.gwr.addHeaderView(this.iQc, 0);
        this.lXu.setTopView(this.iQc);
        this.lXu.setNavigationView(this.fJF);
        this.lXu.setListView(this.gwr);
        this.lXu.setContentView(this.lXx);
        this.lXJ = new d(this.lXw.getPageContext());
        this.lXJ.setLineGone();
        this.lXO = this.lXJ.getView();
        this.gwr.setNextPage(this.lXJ);
        this.lXJ.setOnClickListener(this.aYB);
        this.gwr.setOnItemClickListener(this.lYc);
        this.gwr.setOnItemLongClickListener(this.lYb);
        this.gwr.setOnTouchListener(this.ftt);
        this.lQe = new e(newSubPbActivity.getPageContext());
        this.lQe.createView();
        this.lQe.setListPullRefreshListener(this.fhg);
        this.lQe.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        this.mProgress = (ProgressBar) this.lXu.findViewById(R.id.progress);
        this.lQy = this.lXu.findViewById(R.id.view_comment_top_line);
        this.lQA = (LinearLayout) this.lXu.findViewById(R.id.pb_editer_tool_comment_layout);
        this.lQB = (HeadImageView) this.lXu.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.lQB.setVisibility(0);
        this.lQB.setIsRound(true);
        this.lQB.setBorderWidth(l.getDimens(this.lXw, R.dimen.L_X01));
        this.lQB.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lQB.setDefaultBgResource(0);
        this.lQB.setDefaultResource(R.color.CAM_X0205);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.lQB.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.lXv != null) {
            this.lXv.setVisibility(4);
        }
        this.lXB = com.baidu.tbadk.ala.b.bjv().A(this.lXw.getActivity(), 4);
        if (this.lXB != null) {
            this.lXB.setVisibility(8);
            this.lXz.addView(this.lXB, 3);
        }
        this.lYa = new c(this.lXw, this.gwr);
        this.lYa.setFromCDN(this.mIsFromCDN);
        this.lYa.C(this.aYB);
        this.lYa.IY();
    }

    public ListView getListView() {
        return this.gwr;
    }

    public void bVL() {
        this.lXz = (LinearLayout) this.lXv.findViewById(R.id.subpb_head_user_info_root);
        this.lXz.setOnClickListener(this.aYB);
        this.lXA = (HeadImageView) this.lXv.findViewById(R.id.photo);
        this.lXA.setRadius(l.getDimens(this.lXw.getActivity(), R.dimen.tbds45));
        this.lXA.setClickable(false);
        this.eGI = (TextView) this.lXv.findViewById(R.id.user_name);
        this.lXC = (ImageView) this.lXv.findViewById(R.id.user_rank);
        this.lXC.setVisibility(8);
        this.lTi = (TextView) this.lXv.findViewById(R.id.floor_owner);
        this.lXy = (TextView) this.lXv.findViewById(R.id.see_subject);
        this.lXy.setOnClickListener(this.aYB);
        this.lXD = (TextView) this.lXv.findViewById(R.id.floor);
        this.lXE = (TextView) this.lXv.findViewById(R.id.time);
        this.lXF = (EllipsizeRichTextView) this.lXv.findViewById(R.id.content_text);
        this.lXF.setOnClickListener(this.aYB);
        ao.setViewTextColor(this.lXF, R.color.CAM_X0105);
        this.lXF.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        this.lXF.setLineSpacing(0.0f, 1.25f);
        this.lXG = (TbImageView) this.lXv.findViewById(R.id.sub_pb_image);
        this.lXG.setOnClickListener(this.aYB);
        this.lXH = (TextView) this.lXv.findViewById(R.id.advert);
        this.alm = (PlayVoiceBntNew) this.lXv.findViewById(R.id.voice_btn);
        this.lXv.setOnTouchListener(this.ftt);
        this.lXv.setOnClickListener(this.aYB);
    }

    public void a(b.InterfaceC0561b interfaceC0561b, boolean z) {
        if (this.lXR != null) {
            this.lXR.dismiss();
            this.lXR = null;
        }
        this.lXR = new com.baidu.tbadk.core.dialog.b(this.lXw.getPageContext().getPageActivity());
        if (z) {
            this.lXR.a(new String[]{this.lXw.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0561b);
        } else {
            this.lXR.a(new String[]{this.lXw.getPageContext().getString(R.string.save_to_emotion), this.lXw.getPageContext().getString(R.string.save_to_local)}, interfaceC0561b);
        }
        this.lXR.d(this.lXw.getPageContext());
        this.lXR.bqg();
    }

    public void dR(View view) {
        this.lXK = view;
    }

    public void cHg() {
        int dimens = l.getDimens(this.lXw.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.lXw.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.lXu.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.lXP != null) {
                    a.this.lXu.onFinish();
                } else {
                    a.this.lXw.finish();
                }
            }
        });
        ImageView backImageView = this.mNavigationBar.getBackImageView();
        this.eFv = backImageView;
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

    public void dN(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.lXQ == null) {
            this.lXQ = new Dialog(this.lXw.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lXQ.setCanceledOnTouchOutside(true);
            this.lXQ.setCancelable(true);
            this.lXM = LayoutInflater.from(this.lXw.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.lXw.getLayoutMode().onModeChanged(this.lXM);
            this.lXQ.setContentView(this.lXM);
            WindowManager.LayoutParams attributes = this.lXQ.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.lXw.getPageContext().getPageActivity()) * 0.9d);
            this.lXQ.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.lXQ.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.lXQ.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.lXQ.findViewById(R.id.disable_reply_btn);
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
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lXQ != null && (a.this.lXQ instanceof Dialog)) {
                        g.b(a.this.lXQ, a.this.lXw.getPageContext());
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
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lXQ != null && (a.this.lXQ instanceof Dialog)) {
                        g.b(a.this.lXQ, a.this.lXw.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.lXS != null) {
                        a.this.lXS.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lXQ != null && (a.this.lXQ instanceof Dialog)) {
                        g.b(a.this.lXQ, a.this.lXw.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.lXw.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.lXQ, this.lXw.getPageContext());
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
        this.lQj = new com.baidu.tbadk.core.dialog.a(this.lXw.getPageContext().getPageActivity());
        this.lQj.nu(i3);
        this.lQj.setYesButtonTag(sparseArray);
        this.lQj.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.lXT != null) {
                    a.this.lXT.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.lQj.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.13
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lQj.jD(true);
        this.lQj.b(this.lXw.getPageContext());
        if (z) {
            this.lQj.bqe();
        } else if (1 == this.lWQ.drg()) {
            com.baidu.tieba.NEGFeedBack.h hVar = new com.baidu.tieba.NEGFeedBack.h(this.lWQ.drg(), this.lWQ.drf(), this.lWQ.bJZ());
            hVar.ei(this.lWb.bBS().getId(), this.lWb.bBS().getName());
            hVar.setForumHeadUrl(this.lWQ.bKc());
            hVar.setUserLevel(this.lWQ.bKd());
            UserData userData = new UserData();
            userData.setIsManager(this.lWQ.getIsManager());
            a(sparseArray, hVar, userData);
        } else {
            h(sparseArray);
        }
    }

    private void h(final SparseArray<Object> sparseArray) {
        AntiData cAh;
        if (this.lXw != null && sparseArray != null && this.lXv != null) {
            if (this.jJX == null) {
                this.jJX = new com.baidu.tieba.NEGFeedBack.f(this.lXw.getPageContext(), this.lXv);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lWQ != null && (cAh = this.lWQ.cAh()) != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.jJX.setDefaultReasonArray(new String[]{this.lXw.getString(R.string.delete_thread_reason_1), this.lXw.getString(R.string.delete_thread_reason_2), this.lXw.getString(R.string.delete_thread_reason_3), this.lXw.getString(R.string.delete_thread_reason_4), this.lXw.getString(R.string.delete_thread_reason_5)});
            this.jJX.setData(atVar);
            this.jJX.DV("4");
            this.jJX.a(new f.b() { // from class: com.baidu.tieba.pb.pb.sub.a.14
                @Override // com.baidu.tieba.NEGFeedBack.f.b
                public void X(JSONArray jSONArray) {
                    String S = com.baidu.tbadk.core.util.at.S(jSONArray);
                    if (a.this.lXT != null) {
                        a.this.lXT.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    private void a(final SparseArray<Object> sparseArray, com.baidu.tieba.NEGFeedBack.h hVar, UserData userData) {
        AntiData cAh;
        if (this.lXw != null && sparseArray != null && this.lXv != null) {
            if (this.lRy == null) {
                this.lRy = new i(this.lXw.getPageContext(), this.lXv, hVar, userData);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.lWQ != null && (cAh = this.lWQ.cAh()) != null && cAh.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cAh.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            at atVar = new at();
            atVar.setFeedBackReasonMap(sparseArray2);
            this.lRy.setDefaultReasonArray(new String[]{this.lXw.getString(R.string.delete_thread_reason_1), this.lXw.getString(R.string.delete_thread_reason_2), this.lXw.getString(R.string.delete_thread_reason_3), this.lXw.getString(R.string.delete_thread_reason_4), this.lXw.getString(R.string.delete_thread_reason_5)});
            this.lRy.setData(atVar);
            this.lRy.DV("4");
            this.lRy.a(new i.b() { // from class: com.baidu.tieba.pb.pb.sub.a.15
                @Override // com.baidu.tieba.NEGFeedBack.i.b
                public void X(JSONArray jSONArray) {
                    String S = com.baidu.tbadk.core.util.at.S(jSONArray);
                    if (a.this.lXT != null) {
                        a.this.lXT.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), S});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rc(final boolean z) {
        if (this.gwr != null) {
            if (!z) {
                this.gwr.setEnabled(z);
            } else {
                this.gwr.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.gwr.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.lXS = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.lXT = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.lXw.showToast(this.lXw.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.lXw.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bAP() != null) {
            this.kKo = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.lXx.addView(hVar.bAP(), layoutParams);
            this.kKo.a(new y.a() { // from class: com.baidu.tieba.pb.pb.sub.a.3
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    a.this.dqI();
                }
            });
        }
    }

    public void dqn() {
        if (this.gwr != null) {
            this.lXZ = this.gwr.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uL(boolean z) {
        if (this.lWQ == null || this.lWQ.dqL() == null) {
            return false;
        }
        if (this.lWQ.djc() != 0) {
            return false;
        }
        return (this.lWb == null || this.lWb.bkV() == null || this.lWb.bkV().bnx() == null || !TextUtils.equals(this.lWb.bkV().bnx().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void dqo() {
        if (this.lWQ != null) {
            if ((!dqr() && this.lXO != null && this.lXO.isShown()) || x.isEmpty(this.lXU)) {
                this.lWQ.vS(false);
            } else {
                this.lWQ.vS(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.lWQ = subPbModel;
    }

    public void vP(boolean z) {
        if (this.lWQ != null && this.lWQ.dql() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.lXP = new BlankView(this.lXw.getPageContext().getPageActivity());
            this.fJF.addView(this.lXP, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.lXP.setVisibility(0);
            this.lXP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.lXw.finish();
                }
            });
            this.lXu.setBlankView(this.lXP);
        }
    }

    public void dqp() {
        b(this.lXw);
        this.gwr.setNextPage(this.lXJ);
    }

    public void v(PostData postData) {
        int i;
        if (postData != null) {
            postData.yc(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!dqr() && this.lXO != null && this.lXO.isShown()) {
                i = (this.lXZ - this.lXY) - 1;
            } else {
                i = this.lXZ - this.lXY;
            }
            int count = x.getCount(this.lXU);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(x.subList(this.lXU, 0, i));
            x.add(arrayList, postData2);
            x.add(arrayList, postData);
            this.gwr.smoothScrollToPosition(this.lXZ + 2);
            this.gwr.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.gwr.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.gwr.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.lXu;
    }

    public void doP() {
        if (this.lXL != null) {
            g.dismissPopupWindow(this.lXL, this.lXw.getPageContext().getPageActivity());
        }
        if (this.lXN != null) {
            this.lXN.dismiss();
        }
        if (this.lQj != null) {
            this.lQj.dismiss();
        }
        if (this.lXQ != null) {
            g.b(this.lXQ, this.lXw.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.lWT != null) {
            this.lWT.dismiss();
        }
    }

    public void dqq() {
        this.gwr.setNextPage(this.lXJ);
        this.lXJ.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.fzv = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v68, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z, boolean z2) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.fzv && this.lXv != null) {
                this.lXv.setVisibility(8);
                this.gwr.removeHeaderView(this.lXv);
                this.lXY = 1;
            }
            this.lWb = pVar;
            if (this.lWb.djF() != null) {
                this.lWb.djF().nnK = true;
            }
            if (this.lXv != null) {
                this.lXv.setVisibility(0);
            }
            if (pVar.bkV() != null && pVar.bkV().bmg()) {
                this.lXy.setText(R.string.view_original);
            } else {
                this.lXy.setText(R.string.view_subject);
            }
            if (pVar.djF() != null) {
                this.fUy = pVar.djF().dLm();
                if (this.fUy > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.lXw.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.fUy)));
                    if (this.lXw != null) {
                        this.jvO.setText(this.lXw.dnZ());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.lXw.getResources().getString(R.string.local_floor_reply));
                }
                String str = null;
                if (this.lXw.dql()) {
                    str = "PB";
                }
                if (pVar.djF().bnS() != null) {
                    this.lXI.setData(this.lXw.getPageContext(), pVar.djF().bnS(), com.baidu.tieba.tbadkCore.d.a.i("PB", "c0132", pVar.bBS().getId(), pVar.bBS().getName(), pVar.bkV().getId(), str));
                } else {
                    this.lXI.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.lXJ.startLoadData();
                this.lYa.setHasMoreData(true);
            } else {
                this.lXJ.endLoadData();
                this.lYa.setHasMoreData(false);
            }
            this.lXU = pVar.djN();
            if (this.lXU == null || this.lXU.size() <= lXt) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.lXU.size() - lXt;
                FV(size);
                int firstVisiblePosition = this.gwr.getFirstVisiblePosition() - size;
                View childAt = this.gwr.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.lXU);
            if (x.isEmpty(this.lXU)) {
                this.gwr.setNextPage(null);
                if (this.fzv) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.a.a());
                }
            } else {
                this.gwr.setNextPage(this.lXJ);
            }
            com.baidu.tieba.pb.pb.sub.a.b bVar = new com.baidu.tieba.pb.pb.sub.a.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.fzv) {
                arrayList.add(0, pVar.djF());
            }
            this.lYa.a(this.lWb.bkV(), arrayList);
            a(pVar, pVar.djF(), pVar.Vx(), pVar.bjE(), i, z);
            if (i4 > 0) {
                this.gwr.setSelectionFromTop(i3, i2);
            } else if (z2 && !com.baidu.tbadk.core.util.at.isEmpty(this.lXw.dqm().dmd())) {
                String dmd = this.lXw.dqm().dmd();
                int i5 = 0;
                while (true) {
                    final int i6 = i5;
                    if (i6 < arrayList.size()) {
                        if (!(arrayList.get(i6) instanceof PostData) || !dmd.equals(((PostData) arrayList.get(i6)).getId())) {
                            i5 = i6 + 1;
                        } else {
                            this.gwr.post(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.7
                                @Override // java.lang.Runnable
                                public void run() {
                                    int headerViewsCount = i6 + a.this.gwr.getHeaderViewsCount();
                                    if (headerViewsCount >= 1) {
                                        headerViewsCount--;
                                    }
                                    a.this.gwr.setSelection(headerViewsCount);
                                }
                            });
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (this.lWb.djK() > 1) {
                this.gwr.setPullRefresh(this.lQe);
                this.lXu.setEnableDragExit(false);
                return;
            }
            this.gwr.setPullRefresh(null);
            this.lXu.setEnableDragExit(true);
        }
    }

    private void FV(int i) {
        if (this.lXU != null) {
            if (this.lXU.size() <= i) {
                this.lXU.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.lXU.iterator();
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

    public boolean dqr() {
        return this.lYa.aHa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.fzv) {
            if (!StringUtils.isNull(postData.dLt())) {
                this.lXG.setVisibility(0);
                this.lXG.startLoad(postData.dLt(), 10, true);
            } else {
                this.lXG.setVisibility(8);
            }
            com.baidu.tieba.tbadkCore.data.i dLv = postData.dLv();
            if (dLv != null && dLv.nmr) {
                this.lXH.setVisibility(0);
            } else {
                this.lXH.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.lXv.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.lXv.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.lXD.setText((CharSequence) null);
            this.eGI.setText((CharSequence) null);
            this.lTi.setVisibility(8);
            if (!this.fzv) {
                c(postData.bnx());
                if (z) {
                    this.lTi.setVisibility(0);
                    ao.setViewTextColor(this.lTi, R.color.CAM_X0302);
                }
            }
            this.lXE.setText(com.baidu.tbadk.core.util.at.getFormatTime(postData.getTime()));
            String format = String.format(this.lXw.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dLm()));
            if (pVar.bkV() != null && pVar.bkV().bmg()) {
                this.lXD.setText((CharSequence) null);
            } else {
                this.lXD.setText(format);
            }
            postData.bnx().getUserTbVipInfoData();
            boolean a2 = a(this.lXF, postData.dLo());
            if (StringUtils.isNull(postData.dLt()) && !a2 && postData.bHn() != null) {
                this.alm.setVisibility(0);
                this.alm.setTag(postData.bHn());
                return;
            }
            this.alm.setVisibility(8);
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
                this.eGI.setText(dY(metaData.getSealPrefix(), str));
            } else {
                this.eGI.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.lXB != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.lXB.setVisibility(8);
                } else {
                    this.lXB.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.eEt = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.lXB.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ao.setViewTextColor(this.eGI, R.color.cp_cont_r);
            } else {
                ao.setViewTextColor(this.eGI, R.color.CAM_X0108);
            }
            this.lXA.setVisibility(0);
            this.lXA.setUserId(metaData.getUserId());
            this.lXA.setUserName(metaData.getUserName());
            this.lXA.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.lXA, metaData);
            this.lXA.startLoad(metaData.getAvater(), 28, false);
            this.lXz.setTag(R.id.tag_user_id, metaData.getUserId());
            this.lXz.setTag(R.id.tag_user_name, metaData.getUserName());
            this.lXz.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bHf() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bHf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.q(next.bHm());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.lH(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dTE());
                        continue;
                    case 17:
                        String str = next.bHq().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.q("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.bHu()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bHm() == null || tbRichTextData.bHm().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bHm());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a2 = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.lXw.getPageContext().getString(R.string.refresh_view_button_text), this.eFA));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.lXw.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.lXx, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a2);
        }
        this.gwr.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.kKo.bBY();
        ao.setBackgroundColor(this.mNoDataView, R.color.CAM_X0201);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.lXw.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void CH(int i) {
        b(NoDataViewFactory.d.dX(null, this.lXw.getResources().getString(R.string.refresh_view_title_text)));
        this.lXV.setVisibility(8);
    }

    public void HW(String str) {
        b(NoDataViewFactory.d.dX(str, this.lXw.getPageContext().getString(R.string.refresh_view_title_text)));
        this.lXV.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.gwr.setVisibility(0);
            this.lXV.setVisibility(0);
            this.lXu.setOnTouchListener(null);
        }
    }

    public void h(View.OnClickListener onClickListener) {
        this.eFA = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String userId;
        boolean z5;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            if (i != 0) {
                if (i != 3) {
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                String userId2 = postData.bnx().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z2 = false;
                }
            } else {
                z = false;
                z2 = false;
            }
            if (this.lWb != null && this.lWb.bkV() != null && this.lWb.bkV().bnx() != null && postData.bnx() != null) {
                String userId3 = this.lWb.bkV().bnx().getUserId();
                String userId4 = postData.bnx().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z = true;
                    } else {
                        z3 = true;
                        z4 = false;
                        z = true;
                    }
                    userId = postData.bnx().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z3 = true;
                        z = true;
                    }
                    int i2 = postData.dLm() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.bnx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnx().getPortrait());
                            z5 = true;
                        } else {
                            z5 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z5 = false;
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z5 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.bnx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.bnx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnx().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.bnx() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnx().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnx().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnx().getName_show());
                        }
                        if (this.lWb.bkV() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.lWb.bkV().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z) {
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
            z3 = false;
            z4 = false;
            userId = postData.bnx().getUserId();
            if (userId != null) {
                z3 = true;
                z = true;
            }
            if (postData.dLm() != 1) {
            }
            if (!z2) {
            }
            if (!z) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z4) {
            }
            if (!z) {
            }
        }
    }

    public void vQ(boolean z) {
        if (this.lWT != null && this.lWT.dnf() != null) {
            if (z) {
                this.lWT.dnf().setText(R.string.remove_mark);
            } else {
                this.lWT.dnf().setText(R.string.mark);
            }
        }
    }

    public View dqs() {
        return this.lXO;
    }

    public void onChangeSkinType(int i) {
        this.lXw.getLayoutMode().setNightMode(i == 1);
        this.lXw.getLayoutMode().onModeChanged(this.lXu);
        this.lXw.getLayoutMode().onModeChanged(this.lXv);
        ao.setBackgroundColor(this.lXu, R.color.CAM_X0201);
        ao.setBackgroundColor(this.lXx, R.color.CAM_X0201);
        this.mNavigationBar.onChangeSkinType(this.lXw.getPageContext(), i);
        WebPManager.a(this.eFv, R.drawable.icon_pure_topbar_close44, R.color.CAM_X0105, WebPManager.ResourceStateType.NORMAL_PRESS);
        if (this.lXy != null) {
            ao.setViewTextColor(this.lXy, R.color.goto_see_subject_color);
        }
        this.fJE.onChangeSkinType(this.lXw.getPageContext(), i);
        this.lXw.getLayoutMode().onModeChanged(this.lXO);
        ao.setViewTextColor(this.lXF, R.color.CAM_X0105);
        this.lXF.setLinkTextColor(ao.getColor(R.color.CAM_X0304));
        if (this.kKo != null && this.kKo.bAP() != null) {
            this.kKo.bAP().onChangeSkinType(i);
        }
        this.lXJ.changeSkin(i);
        this.alm.btU();
        ao.setViewTextColor(this.jvO, R.color.CAM_X0110);
        ao.setViewTextColor(this.lTi, R.color.CAM_X0302);
        ao.setViewTextColor(this.eGI, R.color.CAM_X0108);
        this.jvO.setAlpha(0.95f);
        if (this.lXK != null) {
            com.baidu.tbadk.r.a.a(this.lXw.getPageContext(), this.lXK);
        }
        if (this.lYa != null) {
            this.lYa.notifyDataSetChanged();
        }
        this.lXw.getLayoutMode().onModeChanged(this.lXM);
        ao.setBackgroundColor(this.lQy, R.color.CAM_X0203);
        this.lQB.setBorderColor(ao.getColor(R.color.CAM_X0401));
        this.lQA.setBackgroundDrawable(ao.aO(l.getDimens(this.lXw, R.dimen.tbds47), ao.getColor(R.color.CAM_X0209)));
    }

    public void dqt() {
        this.mProgress.setVisibility(0);
    }

    public void dqu() {
        this.gwr.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lXJ.endLoadData();
    }

    public void cyg() {
        this.gwr.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.lXJ.cyg();
    }

    public boolean dqv() {
        return this.lXu.dqv();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.lYa.c(onLongClickListener);
    }

    public View dqw() {
        return this.lXv;
    }

    public TextView cHl() {
        return this.jvO;
    }

    public ImageView dqx() {
        return this.lXW;
    }

    public ImageView dqy() {
        return this.lXX;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void FW(int i) {
    }

    public View dqz() {
        return this.lXy;
    }

    public View dqA() {
        return this.lXG;
    }

    public MorePopupWindow dqB() {
        return this.lXL;
    }

    public void showLoadingDialog() {
        if (this.ixW == null) {
            this.ixW = new com.baidu.tbadk.core.view.a(this.lXw.getPageContext());
        }
        this.ixW.setDialogVisiable(true);
    }

    public void cjr() {
        if (this.ixW != null) {
            this.ixW.setDialogVisiable(false);
        }
    }

    public TextView dqC() {
        return this.lXF;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.lYa.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.lYa != null) {
            this.lYa.notifyDataSetChanged();
        }
    }

    public aa dqD() {
        return this.lWT;
    }

    public void cJE() {
    }

    public void cJF() {
    }

    public void cHM() {
        if (this.lXu != null) {
            this.lXu.onDestroy();
        }
        if (this.kKo != null) {
            this.kKo.onDestory();
        }
    }

    public void dqE() {
        if (this.lXw.isPaused()) {
        }
    }

    public View dqF() {
        return this.lXz;
    }

    private SpannableStringBuilder dY(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.lXw.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int dqG() {
        if (this.kKo == null || this.kKo.bAP() == null) {
            return 0;
        }
        return this.kKo.bAP().getHeight();
    }

    public int dqH() {
        if (this.lXP == null) {
            return 0;
        }
        return this.lXP.getHeight();
    }

    public void dqI() {
        if (this.jvO != null && this.kKo != null) {
            if (this.kKo.bCd()) {
                this.jvO.setText(R.string.draft_to_send);
            } else {
                this.jvO.setText(this.lXw.dnZ());
            }
        }
    }

    public void va(boolean z) {
        if (this.lQB != null) {
            this.lQB.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    public void setListPullRefreshListener(f.c cVar) {
        this.fhg = cVar;
        if (this.lQe != null) {
            this.lQe.setListPullRefreshListener(cVar);
        }
    }
}
