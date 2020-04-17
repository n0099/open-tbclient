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
    private static final int jGO = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aDc;
    private BdTypeListView eOe;
    private View gNZ;
    private NoNetworkView gUf;
    private com.baidu.tbadk.core.view.a gvy;
    private e hBE;
    private TextView hor;
    private l jFB;
    private SubPbView jGP;
    private LinearLayout jGQ;
    private View jGR;
    private NewSubPbActivity jGS;
    private RelativeLayout jGT;
    private View jGX;
    private SubPbModel jGu;
    private w jGx;
    private ThreadSkinView jHe;
    private d jHf;
    private View jHg;
    private View jHi;
    private View jHk;
    private BlankView jHl;
    private com.baidu.tbadk.core.dialog.b jHn;
    private ArrayList<PostData> jHq;
    private RelativeLayout jHr;
    private ImageView jHs;
    private ImageView jHt;
    private c jHw;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dkt = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView jGU = null;
    private LinearLayout jGV = null;
    private HeadImageView jGW = null;
    private ClickableHeaderImageView jDa = null;
    private TextView cAX = null;
    private ImageView jGY = null;
    private TextView jCT = null;
    private TextView jGZ = null;
    private TextView jHa = null;
    private EllipsizeRichTextView jHb = null;
    private TbImageView jHc = null;
    private PlayVoiceBntNew agG = null;
    private TextView jHd = null;
    private MorePopupWindow jHh = null;
    private com.baidu.tbadk.core.dialog.b jHj = null;
    private Dialog jHm = null;
    private com.baidu.tbadk.core.dialog.a jAd = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a jHo = null;
    private NewSubPbActivity.a jHp = null;
    private h iBk = null;
    private int eoL = 0;
    private int jHu = 2;
    private int jHv = 0;
    private boolean dXd = true;
    private com.baidu.tieba.pb.a.c dRh = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.na(false);
            a.this.na(true);
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
    protected AdapterView.OnItemLongClickListener jHx = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.jHq, i);
            if (view != null && view.getTag() != null) {
                if (a.this.jGx == null) {
                    a.this.jGx = new w(a.this.jGS.getPageContext(), a.this.aDc);
                }
                a.this.jGx.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.qV(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.jGx.a(sparseArray, a.this.jGu.cvG(), z);
                if (z) {
                    a.this.jGx.czA().setVisibility(0);
                    a.this.jGx.czA().setTag(postData.getId());
                } else {
                    a.this.jGx.czA().setVisibility(8);
                }
                a.this.jGx.czy().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener jHy = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.jGS != null && bc.checkUpIsLogin(a.this.jGS.getPageContext().getPageActivity())) {
                if ((a.this.jGS.iBb == null || a.this.jGu == null || a.this.jGu.bNG() == null || a.this.jGS.iBb.kz(a.this.jGu.bNG().replyPrivateFlag)) && a.this.jGu != null && a.this.iBk != null) {
                    a.this.cCt();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cCv();
                        a.this.jGu.cCT();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.iBk.setReplyId(str2);
                            a.this.iBk.wH(str);
                        }
                    }
                    a.this.cCu();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.jGP = null;
        this.jGR = null;
        this.eOe = null;
        this.jGS = null;
        this.gUf = null;
        this.jGT = null;
        this.jGX = null;
        this.jHf = null;
        this.jHk = null;
        this.aDc = null;
        this.mProgress = null;
        this.hor = null;
        this.jHr = null;
        this.jHs = null;
        this.jHt = null;
        this.jGS = newSubPbActivity;
        this.aDc = onClickListener;
        this.jGP = (SubPbView) LayoutInflater.from(this.jGS.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.jGR = LayoutInflater.from(this.jGS.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.jGQ = (LinearLayout) this.jGP.findViewById(R.id.navigation_bar_group);
        this.jHr = (RelativeLayout) this.jGP.findViewById(R.id.subpb_editor_tool_comment);
        this.hor = (TextView) this.jGP.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hor.setOnClickListener(this.aDc);
        this.jHs = (ImageView) this.jGP.findViewById(R.id.subpb_editor_tool_more_img);
        this.jHt = (ImageView) this.jGP.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.jHt.setOnClickListener(this.aDc);
        this.jHs.setOnClickListener(this.aDc);
        this.gUf = (NoNetworkView) this.jGP.findViewById(R.id.view_no_network);
        bSV();
        bpz();
        this.jGT = (RelativeLayout) this.jGP.findViewById(R.id.sub_pb_body_layout);
        this.eOe = (BdTypeListView) this.jGP.findViewById(R.id.new_sub_pb_list);
        this.jHe = (ThreadSkinView) LayoutInflater.from(this.jGS.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.eOe.addHeaderView(this.jHe);
        this.eOe.addHeaderView(this.jGR);
        this.gNZ = new TextView(newSubPbActivity.getActivity());
        this.gNZ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.eOe.addHeaderView(this.gNZ, 0);
        this.jGP.setTopView(this.gNZ);
        this.jGP.setNavigationView(this.jGQ);
        this.jGP.setListView(this.eOe);
        this.jGP.setContentView(this.jGT);
        this.jHf = new d(this.jGS.getPageContext());
        this.jHf.setLineGone();
        this.jHk = this.jHf.getView();
        this.eOe.setNextPage(this.jHf);
        this.jHf.setOnClickListener(this.aDc);
        this.eOe.setOnItemClickListener(this.jHy);
        this.eOe.setOnItemLongClickListener(this.jHx);
        this.eOe.setOnTouchListener(this.dRh);
        this.mProgress = (ProgressBar) this.jGP.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jGR != null) {
            this.jGR.setVisibility(4);
        }
        this.jGX = com.baidu.tbadk.ala.b.aGP().p(this.jGS.getActivity(), 4);
        if (this.jGX != null) {
            this.jGX.setVisibility(8);
            this.jGV.addView(this.jGX, 3);
        }
        this.jHw = new c(this.jGS, this.eOe);
        this.jHw.setFromCDN(this.mIsFromCDN);
        this.jHw.z(this.aDc);
        this.jHw.BC();
    }

    public ListView getListView() {
        return this.eOe;
    }

    public void bpz() {
        this.jGV = (LinearLayout) this.jGR.findViewById(R.id.subpb_head_user_info_root);
        this.jGV.setOnClickListener(this.aDc);
        this.jGW = (HeadImageView) this.jGR.findViewById(R.id.photo);
        this.jGW.setRadius(com.baidu.adp.lib.util.l.getDimens(this.jGS.getActivity(), R.dimen.ds30));
        this.jGW.setClickable(false);
        this.jDa = (ClickableHeaderImageView) this.jGR.findViewById(R.id.god_user_photo);
        this.jDa.setGodIconMargin(0);
        this.jDa.setGodIconWidth(R.dimen.ds24);
        this.jDa.setRadius(com.baidu.adp.lib.util.l.getDimens(this.jGS.getActivity(), R.dimen.ds30));
        this.jDa.setClickable(false);
        this.cAX = (TextView) this.jGR.findViewById(R.id.user_name);
        this.jGY = (ImageView) this.jGR.findViewById(R.id.user_rank);
        this.jGY.setVisibility(8);
        this.jCT = (TextView) this.jGR.findViewById(R.id.floor_owner);
        this.jGU = (TextView) this.jGR.findViewById(R.id.see_subject);
        this.jGU.setOnClickListener(this.aDc);
        this.jGZ = (TextView) this.jGR.findViewById(R.id.floor);
        this.jHa = (TextView) this.jGR.findViewById(R.id.time);
        this.jHb = (EllipsizeRichTextView) this.jGR.findViewById(R.id.content_text);
        this.jHb.setOnClickListener(this.aDc);
        am.setViewTextColor(this.jHb, (int) R.color.cp_cont_b);
        this.jHb.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.jHb.setLineSpacing(0.0f, 1.25f);
        this.jHc = (TbImageView) this.jGR.findViewById(R.id.sub_pb_image);
        this.jHc.setOnClickListener(this.aDc);
        this.jHd = (TextView) this.jGR.findViewById(R.id.advert);
        this.agG = (PlayVoiceBntNew) this.jGR.findViewById(R.id.voice_btn);
        this.jGR.setOnTouchListener(this.dRh);
        this.jGR.setOnClickListener(this.aDc);
    }

    public void a(b.a aVar, boolean z) {
        if (this.jHn != null) {
            this.jHn.dismiss();
            this.jHn = null;
        }
        this.jHn = new com.baidu.tbadk.core.dialog.b(this.jGS.getPageContext().getPageActivity());
        if (z) {
            this.jHn.a(new String[]{this.jGS.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.jHn.a(new String[]{this.jGS.getPageContext().getString(R.string.save_to_emotion), this.jGS.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.jHn.d(this.jGS.getPageContext());
        this.jHn.aMV();
    }

    public void cM(View view) {
        this.jHg = view;
    }

    public void bSV() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jGS.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.jGS.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.jGP.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jHl != null) {
                    a.this.jGP.onFinish();
                } else {
                    a.this.jGS.finish();
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

    public void cI(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.jHm == null) {
            this.jHm = new Dialog(this.jGS.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jHm.setCanceledOnTouchOutside(true);
            this.jHm.setCancelable(true);
            this.jHi = LayoutInflater.from(this.jGS.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.jGS.getLayoutMode().onModeChanged(this.jHi);
            this.jHm.setContentView(this.jHi);
            WindowManager.LayoutParams attributes = this.jHm.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.jGS.getPageContext().getPageActivity()) * 0.9d);
            this.jHm.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.jHm.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.jHm.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.jHm.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.jHm != null && (a.this.jHm instanceof Dialog)) {
                        g.b(a.this.jHm, a.this.jGS.getPageContext());
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
                    if (a.this.jHm != null && (a.this.jHm instanceof Dialog)) {
                        g.b(a.this.jHm, a.this.jGS.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.jHo != null) {
                        a.this.jHo.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.jHm != null && (a.this.jHm instanceof Dialog)) {
                        g.b(a.this.jHm, a.this.jGS.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.jGS.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.jHm, this.jGS.getPageContext());
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
        this.jAd = new com.baidu.tbadk.core.dialog.a(this.jGS.getPageContext().getPageActivity());
        this.jAd.kd(i3);
        this.jAd.setYesButtonTag(sparseArray);
        this.jAd.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.jHp != null) {
                    a.this.jHp.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.jAd.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jAd.gE(true);
        this.jAd.b(this.jGS.getPageContext());
        if (z) {
            this.jAd.aMU();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bNG;
        if (this.jGS != null && sparseArray != null && this.jGR != null) {
            if (this.hBE == null) {
                this.hBE = new e(this.jGS.getPageContext(), this.jGR);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.jGu != null && (bNG = this.jGu.bNG()) != null && bNG.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNG.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.hBE.setDefaultReasonArray(new String[]{this.jGS.getString(R.string.delete_thread_reason_1), this.jGS.getString(R.string.delete_thread_reason_2), this.jGS.getString(R.string.delete_thread_reason_3), this.jGS.getString(R.string.delete_thread_reason_4), this.jGS.getString(R.string.delete_thread_reason_5)});
            this.hBE.setData(alVar);
            this.hBE.xA("4");
            this.hBE.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    String P = aq.P(jSONArray);
                    if (a.this.jHp != null) {
                        a.this.jHp.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), P});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.eOe != null) {
            if (!z) {
                this.eOe.setEnabled(z);
            } else {
                this.eOe.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eOe.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.jHo = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.jHp = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.jGS.showToast(this.jGS.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.jGS.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aWP() != null) {
            this.iBk = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.jGT.addView(hVar.aWP(), layoutParams);
            this.iBk.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cCN();
                }
            });
        }
    }

    public void cCt() {
        if (this.eOe != null) {
            this.jHv = this.eOe.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jGu == null || this.jGu.cCQ() == null) {
            return false;
        }
        if (this.jGu.cvG() != 0) {
            return false;
        }
        return (this.jFB == null || this.jFB.aIw() == null || this.jFB.aIw().aKE() == null || !TextUtils.equals(this.jFB.aIw().aKE().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cCu() {
        if (this.jGu != null) {
            if ((!cCx() && this.jHk != null && this.jHk.isShown()) || v.isEmpty(this.jHq)) {
                this.jGu.rX(false);
            } else {
                this.jGu.rX(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.jGu = subPbModel;
    }

    public void rU(boolean z) {
        if (this.jGu != null && this.jGu.cCr() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.jHl = new BlankView(this.jGS.getPageContext().getPageActivity());
            this.jGQ.addView(this.jHl, 0, new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.jHl.setVisibility(0);
            this.jHl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jGS.finish();
                }
            });
            this.jGP.setBlankView(this.jHl);
        }
    }

    public void cCv() {
        b(this.jGS);
        this.eOe.setNextPage(this.jHf);
    }

    public void r(PostData postData) {
        int i;
        if (postData != null) {
            postData.tV(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cCx() && this.jHk != null && this.jHk.isShown()) {
                i = (this.jHv - this.jHu) - 1;
            } else {
                i = this.jHv - this.jHu;
            }
            int count = v.getCount(this.jHq);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.jHq, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.eOe.smoothScrollToPosition(this.jHv + 2);
            this.eOe.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eOe.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.eOe.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.jGP;
    }

    public void cBa() {
        if (this.jHh != null) {
            g.dismissPopupWindow(this.jHh, this.jGS.getPageContext().getPageActivity());
        }
        if (this.jHj != null) {
            this.jHj.dismiss();
        }
        if (this.jAd != null) {
            this.jAd.dismiss();
        }
        if (this.jHm != null) {
            g.b(this.jHm, this.jGS.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.jGx != null) {
            this.jGx.dismiss();
        }
    }

    public void cCw() {
        this.eOe.setNextPage(this.jHf);
        this.jHf.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dXd = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (lVar != null) {
            if (this.dXd && this.jGR != null) {
                this.jGR.setVisibility(8);
                this.eOe.removeHeaderView(this.jGR);
                this.jHu = 1;
            }
            this.jFB = lVar;
            if (this.jGR != null) {
                this.jGR.setVisibility(0);
            }
            if (lVar.aIw() != null && lVar.aIw().aMA()) {
                this.jGU.setText(R.string.view_original);
            } else {
                this.jGU.setText(R.string.view_subject);
            }
            if (lVar.cwh() != null) {
                this.eoL = lVar.cwh().cWr();
                if (this.eoL > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.jGS.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eoL)));
                    if (this.jGS != null) {
                        this.hor.setText(this.jGS.cAo());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.jGS.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.jGS.cCr() ? "PB" : null;
                if (lVar.cwh().aKZ() != null) {
                    this.jHe.setData(this.jGS.getPageContext(), lVar.cwh().aKZ(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aXI().getId(), lVar.aXI().getName(), lVar.aIw().getId(), str));
                } else {
                    this.jHe.setData(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.jHf.startLoadData();
                this.jHw.setHasMoreData(true);
            } else {
                this.jHf.endLoadData();
                this.jHw.setHasMoreData(false);
            }
            this.jHq = lVar.cwl();
            if (this.jHq == null || this.jHq.size() <= jGO) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.jHq.size() - jGO;
                zX(size);
                int firstVisiblePosition = this.eOe.getFirstVisiblePosition() - size;
                View childAt = this.eOe.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jHq);
            if (v.isEmpty(this.jHq)) {
                this.eOe.setNextPage(null);
                if (this.dXd) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.eOe.setNextPage(this.jHf);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(lVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dXd) {
                arrayList.add(0, lVar.cwh());
            }
            this.jHw.b(this.jFB.aIw(), arrayList);
            a(lVar, lVar.cwh(), lVar.cio(), lVar.aGZ(), i, z);
            if (i4 > 0) {
                this.eOe.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void zX(int i) {
        if (this.jHq != null) {
            if (this.jHq.size() <= i) {
                this.jHq.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.jHq.iterator();
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

    public boolean cCx() {
        return this.jHw.aki();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dXd) {
            if (!StringUtils.isNull(postData.cWy())) {
                this.jHc.setVisibility(0);
                this.jHc.startLoad(postData.cWy(), 10, true);
            } else {
                this.jHc.setVisibility(8);
            }
            i cWA = postData.cWA();
            if (cWA != null && cWA.kRW) {
                this.jHd.setVisibility(0);
            } else {
                this.jHd.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.jGR.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.jGR.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.jGZ.setText((CharSequence) null);
            this.cAX.setText((CharSequence) null);
            this.jCT.setVisibility(8);
            if (!this.dXd) {
                c(postData.aKE());
                if (z) {
                    this.jCT.setVisibility(0);
                    am.setViewTextColor(this.jCT, (int) R.color.cp_link_tip_a);
                }
            }
            this.jHa.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.jGS.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cWr()));
            if (lVar.aIw() != null && lVar.aIw().aMA()) {
                this.jGZ.setText((CharSequence) null);
            } else {
                this.jGZ.setText(format);
            }
            postData.aKE().getUserTbVipInfoData();
            boolean a = a(this.jHb, postData.cWt());
            if (StringUtils.isNull(postData.cWy()) && !a && postData.bcp() != null) {
                this.agG.setVisibility(0);
                this.agG.setTag(postData.bcp());
                return;
            }
            this.agG.setVisibility(8);
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
                this.cAX.setText(cL(metaData.getSealPrefix(), str));
            } else {
                this.cAX.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.jGX != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.jGX.setVisibility(8);
                } else {
                    this.jGX.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.djj = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.jGX.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.jDa.setVisibility(0);
                this.jGW.setVisibility(8);
                this.jDa.setUserId(metaData.getUserId());
                this.jDa.setUserName(metaData.getUserName());
                this.jDa.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cAX, (int) R.color.cp_cont_r);
            } else {
                this.jDa.setVisibility(8);
                this.jGW.setVisibility(0);
                this.jGW.setUserId(metaData.getUserId());
                this.jGW.setUserName(metaData.getUserName());
                this.jGW.setDefaultResource(R.drawable.transparent_bg);
                this.jGW.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jGW.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cAX, (int) R.color.cp_cont_c);
            }
            this.jGV.setTag(R.id.tag_user_id, metaData.getUserId());
            this.jGV.setTag(R.id.tag_user_name, metaData.getUserName());
            this.jGV.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bch() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bch().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.bco());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.il(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.deD());
                        continue;
                    case 17:
                        String str = next.bcs().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bcw()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bco() == null || tbRichTextData.bco().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bco());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jGS.getPageContext().getString(R.string.refresh_view_button_text), this.dkt));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.jGS.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.jGT, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.eOe.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.iBk.aXO();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.jGS.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wU(int i) {
        b(NoDataViewFactory.d.cK(null, this.jGS.getResources().getString(R.string.refresh_view_title_text)));
        this.jHr.setVisibility(8);
    }

    public void Bv(String str) {
        b(NoDataViewFactory.d.cK(str, this.jGS.getPageContext().getString(R.string.refresh_view_title_text)));
        this.jHr.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eOe.setVisibility(0);
            this.jHr.setVisibility(0);
            this.jGP.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkt = onClickListener;
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
                String userId2 = postData.aKE().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.jFB != null && this.jFB.aIw() != null && this.jFB.aIw().aKE() != null && postData.aKE() != null) {
                String userId3 = this.jFB.aIw().aKE().getUserId();
                String userId4 = postData.aKE().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aKE().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.cWr() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aKE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aKE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKE().getPortrait());
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
                        if (postData.aKE() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aKE().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKE().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKE().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aKE() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKE().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKE().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKE().getName_show());
                        }
                        if (this.jFB.aIw() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jFB.aIw().getId());
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
            userId = postData.aKE().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.cWr() == 1) {
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

    public void rV(boolean z) {
        if (this.jGx != null && this.jGx.czy() != null) {
            if (z) {
                this.jGx.czy().setText(R.string.remove_mark);
            } else {
                this.jGx.czy().setText(R.string.mark);
            }
        }
    }

    public View cCy() {
        return this.jHk;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.jGP, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.jGT, R.color.cp_bg_line_d);
        this.jGS.getLayoutMode().setNightMode(i == 1);
        this.jGS.getLayoutMode().onModeChanged(this.jGP);
        this.jGS.getLayoutMode().onModeChanged(this.jGR);
        this.mNavigationBar.onChangeSkinType(this.jGS.getPageContext(), i);
        if (this.jGU != null) {
            am.setViewTextColor(this.jGU, (int) R.color.goto_see_subject_color);
        }
        this.gUf.onChangeSkinType(this.jGS.getPageContext(), i);
        this.jGS.getLayoutMode().onModeChanged(this.jHk);
        am.setViewTextColor(this.jHb, (int) R.color.cp_cont_b);
        this.jHb.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.iBk != null && this.iBk.aWP() != null) {
            this.iBk.aWP().onChangeSkinType(i);
        }
        this.jHf.changeSkin(i);
        this.agG.ckO();
        am.setViewTextColor(this.hor, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.jCT, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.cAX, (int) R.color.cp_cont_c);
        this.hor.setAlpha(0.95f);
        if (this.jHg != null) {
            com.baidu.tbadk.q.a.a(this.jGS.getPageContext(), this.jHg);
        }
        if (this.jHw != null) {
            this.jHw.notifyDataSetChanged();
        }
        this.jGS.getLayoutMode().onModeChanged(this.jHi);
    }

    public void cCz() {
        this.mProgress.setVisibility(0);
    }

    public void cCA() {
        this.eOe.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jHf.endLoadData();
    }

    public void bLJ() {
        this.eOe.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jHf.bLJ();
    }

    public boolean cCB() {
        return this.jGP.cCB();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.jHw.c(onLongClickListener);
    }

    public View cCC() {
        return this.jGR;
    }

    public TextView bTa() {
        return this.hor;
    }

    public ImageView cCD() {
        return this.jHs;
    }

    public ImageView cCE() {
        return this.jHt;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zY(int i) {
    }

    public View cCF() {
        return this.jGU;
    }

    public View cCG() {
        return this.jHc;
    }

    public MorePopupWindow cCH() {
        return this.jHh;
    }

    public void showLoadingDialog() {
        if (this.gvy == null) {
            this.gvy = new com.baidu.tbadk.core.view.a(this.jGS.getPageContext());
        }
        this.gvy.setDialogVisiable(true);
    }

    public void bzU() {
        if (this.gvy != null) {
            this.gvy.setDialogVisiable(false);
        }
    }

    public TextView cCI() {
        return this.jHb;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jHw.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.jHw != null) {
            this.jHw.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.pb.pb.main.w cCJ() {
        return this.jGx;
    }

    public void bVd() {
    }

    public void bVe() {
    }

    public void aqT() {
        this.jGP.onDestroy();
    }

    public void cCK() {
        if (this.jGS.isPaused()) {
        }
    }

    public View cCL() {
        return this.jGV;
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.jGS.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cCM() {
        if (this.iBk == null || this.iBk.aWP() == null) {
            return 0;
        }
        return this.iBk.aWP().getHeight();
    }

    public void cCN() {
        if (this.hor != null && this.iBk != null) {
            if (this.iBk.aXT()) {
                this.hor.setText(R.string.draft_to_send);
            } else {
                this.hor.setText(this.jGS.cAo());
            }
        }
    }
}
