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
    private static final int jGS = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aDi;
    private BdTypeListView eOj;
    private View gOf;
    private NoNetworkView gUl;
    private com.baidu.tbadk.core.view.a gvE;
    private e hBK;
    private TextView hox;
    private l jFF;
    private w jGB;
    private SubPbView jGT;
    private LinearLayout jGU;
    private View jGV;
    private NewSubPbActivity jGW;
    private RelativeLayout jGX;
    private SubPbModel jGy;
    private c jHA;
    private View jHb;
    private ThreadSkinView jHi;
    private d jHj;
    private View jHk;
    private View jHm;
    private View jHo;
    private BlankView jHp;
    private com.baidu.tbadk.core.dialog.b jHr;
    private ArrayList<PostData> jHu;
    private RelativeLayout jHv;
    private ImageView jHw;
    private ImageView jHx;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dkx = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView jGY = null;
    private LinearLayout jGZ = null;
    private HeadImageView jHa = null;
    private ClickableHeaderImageView jDe = null;
    private TextView cBd = null;
    private ImageView jHc = null;
    private TextView jCX = null;
    private TextView jHd = null;
    private TextView jHe = null;
    private EllipsizeRichTextView jHf = null;
    private TbImageView jHg = null;
    private PlayVoiceBntNew agJ = null;
    private TextView jHh = null;
    private MorePopupWindow jHl = null;
    private com.baidu.tbadk.core.dialog.b jHn = null;
    private Dialog jHq = null;
    private com.baidu.tbadk.core.dialog.a jAh = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a jHs = null;
    private NewSubPbActivity.a jHt = null;
    private h iBq = null;
    private int eoQ = 0;
    private int jHy = 2;
    private int jHz = 0;
    private boolean dXi = true;
    private com.baidu.tieba.pb.a.c dRm = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
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
    protected AdapterView.OnItemLongClickListener jHB = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.jHu, i);
            if (view != null && view.getTag() != null) {
                if (a.this.jGB == null) {
                    a.this.jGB = new w(a.this.jGW.getPageContext(), a.this.aDi);
                }
                a.this.jGB.showDialog();
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
                a.this.jGB.a(sparseArray, a.this.jGy.cvE(), z);
                if (z) {
                    a.this.jGB.czy().setVisibility(0);
                    a.this.jGB.czy().setTag(postData.getId());
                } else {
                    a.this.jGB.czy().setVisibility(8);
                }
                a.this.jGB.czw().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener jHC = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.jGW != null && bc.checkUpIsLogin(a.this.jGW.getPageContext().getPageActivity())) {
                if ((a.this.jGW.iBh == null || a.this.jGy == null || a.this.jGy.bNF() == null || a.this.jGW.iBh.kz(a.this.jGy.bNF().replyPrivateFlag)) && a.this.jGy != null && a.this.iBq != null) {
                    a.this.cCr();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cCt();
                        a.this.jGy.cCR();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.iBq.setReplyId(str2);
                            a.this.iBq.wK(str);
                        }
                    }
                    a.this.cCs();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.jGT = null;
        this.jGV = null;
        this.eOj = null;
        this.jGW = null;
        this.gUl = null;
        this.jGX = null;
        this.jHb = null;
        this.jHj = null;
        this.jHo = null;
        this.aDi = null;
        this.mProgress = null;
        this.hox = null;
        this.jHv = null;
        this.jHw = null;
        this.jHx = null;
        this.jGW = newSubPbActivity;
        this.aDi = onClickListener;
        this.jGT = (SubPbView) LayoutInflater.from(this.jGW.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.jGV = LayoutInflater.from(this.jGW.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.jGU = (LinearLayout) this.jGT.findViewById(R.id.navigation_bar_group);
        this.jHv = (RelativeLayout) this.jGT.findViewById(R.id.subpb_editor_tool_comment);
        this.hox = (TextView) this.jGT.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hox.setOnClickListener(this.aDi);
        this.jHw = (ImageView) this.jGT.findViewById(R.id.subpb_editor_tool_more_img);
        this.jHx = (ImageView) this.jGT.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.jHx.setOnClickListener(this.aDi);
        this.jHw.setOnClickListener(this.aDi);
        this.gUl = (NoNetworkView) this.jGT.findViewById(R.id.view_no_network);
        bSU();
        bpx();
        this.jGX = (RelativeLayout) this.jGT.findViewById(R.id.sub_pb_body_layout);
        this.eOj = (BdTypeListView) this.jGT.findViewById(R.id.new_sub_pb_list);
        this.jHi = (ThreadSkinView) LayoutInflater.from(this.jGW.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.eOj.addHeaderView(this.jHi);
        this.eOj.addHeaderView(this.jGV);
        this.gOf = new TextView(newSubPbActivity.getActivity());
        this.gOf.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.eOj.addHeaderView(this.gOf, 0);
        this.jGT.setTopView(this.gOf);
        this.jGT.setNavigationView(this.jGU);
        this.jGT.setListView(this.eOj);
        this.jGT.setContentView(this.jGX);
        this.jHj = new d(this.jGW.getPageContext());
        this.jHj.setLineGone();
        this.jHo = this.jHj.getView();
        this.eOj.setNextPage(this.jHj);
        this.jHj.setOnClickListener(this.aDi);
        this.eOj.setOnItemClickListener(this.jHC);
        this.eOj.setOnItemLongClickListener(this.jHB);
        this.eOj.setOnTouchListener(this.dRm);
        this.mProgress = (ProgressBar) this.jGT.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jGV != null) {
            this.jGV.setVisibility(4);
        }
        this.jHb = com.baidu.tbadk.ala.b.aGN().p(this.jGW.getActivity(), 4);
        if (this.jHb != null) {
            this.jHb.setVisibility(8);
            this.jGZ.addView(this.jHb, 3);
        }
        this.jHA = new c(this.jGW, this.eOj);
        this.jHA.setFromCDN(this.mIsFromCDN);
        this.jHA.z(this.aDi);
        this.jHA.BB();
    }

    public ListView getListView() {
        return this.eOj;
    }

    public void bpx() {
        this.jGZ = (LinearLayout) this.jGV.findViewById(R.id.subpb_head_user_info_root);
        this.jGZ.setOnClickListener(this.aDi);
        this.jHa = (HeadImageView) this.jGV.findViewById(R.id.photo);
        this.jHa.setRadius(com.baidu.adp.lib.util.l.getDimens(this.jGW.getActivity(), R.dimen.ds30));
        this.jHa.setClickable(false);
        this.jDe = (ClickableHeaderImageView) this.jGV.findViewById(R.id.god_user_photo);
        this.jDe.setGodIconMargin(0);
        this.jDe.setGodIconWidth(R.dimen.ds24);
        this.jDe.setRadius(com.baidu.adp.lib.util.l.getDimens(this.jGW.getActivity(), R.dimen.ds30));
        this.jDe.setClickable(false);
        this.cBd = (TextView) this.jGV.findViewById(R.id.user_name);
        this.jHc = (ImageView) this.jGV.findViewById(R.id.user_rank);
        this.jHc.setVisibility(8);
        this.jCX = (TextView) this.jGV.findViewById(R.id.floor_owner);
        this.jGY = (TextView) this.jGV.findViewById(R.id.see_subject);
        this.jGY.setOnClickListener(this.aDi);
        this.jHd = (TextView) this.jGV.findViewById(R.id.floor);
        this.jHe = (TextView) this.jGV.findViewById(R.id.time);
        this.jHf = (EllipsizeRichTextView) this.jGV.findViewById(R.id.content_text);
        this.jHf.setOnClickListener(this.aDi);
        am.setViewTextColor(this.jHf, (int) R.color.cp_cont_b);
        this.jHf.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.jHf.setLineSpacing(0.0f, 1.25f);
        this.jHg = (TbImageView) this.jGV.findViewById(R.id.sub_pb_image);
        this.jHg.setOnClickListener(this.aDi);
        this.jHh = (TextView) this.jGV.findViewById(R.id.advert);
        this.agJ = (PlayVoiceBntNew) this.jGV.findViewById(R.id.voice_btn);
        this.jGV.setOnTouchListener(this.dRm);
        this.jGV.setOnClickListener(this.aDi);
    }

    public void a(b.a aVar, boolean z) {
        if (this.jHr != null) {
            this.jHr.dismiss();
            this.jHr = null;
        }
        this.jHr = new com.baidu.tbadk.core.dialog.b(this.jGW.getPageContext().getPageActivity());
        if (z) {
            this.jHr.a(new String[]{this.jGW.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.jHr.a(new String[]{this.jGW.getPageContext().getString(R.string.save_to_emotion), this.jGW.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.jHr.d(this.jGW.getPageContext());
        this.jHr.aMT();
    }

    public void cM(View view) {
        this.jHk = view;
    }

    public void bSU() {
        int dimens = com.baidu.adp.lib.util.l.getDimens(this.jGW.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(this.jGW.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.jGT.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jHp != null) {
                    a.this.jGT.onFinish();
                } else {
                    a.this.jGW.finish();
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
        if (this.jHq == null) {
            this.jHq = new Dialog(this.jGW.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.jHq.setCanceledOnTouchOutside(true);
            this.jHq.setCancelable(true);
            this.jHm = LayoutInflater.from(this.jGW.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.jGW.getLayoutMode().onModeChanged(this.jHm);
            this.jHq.setContentView(this.jHm);
            WindowManager.LayoutParams attributes = this.jHq.getWindow().getAttributes();
            attributes.width = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(this.jGW.getPageContext().getPageActivity()) * 0.9d);
            this.jHq.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.jHq.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.jHq.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.jHq.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.jHq != null && (a.this.jHq instanceof Dialog)) {
                        g.b(a.this.jHq, a.this.jGW.getPageContext());
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
                    if (a.this.jHq != null && (a.this.jHq instanceof Dialog)) {
                        g.b(a.this.jHq, a.this.jGW.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.jHs != null) {
                        a.this.jHs.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.jHq != null && (a.this.jHq instanceof Dialog)) {
                        g.b(a.this.jHq, a.this.jGW.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.jGW.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.jHq, this.jGW.getPageContext());
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
        this.jAh = new com.baidu.tbadk.core.dialog.a(this.jGW.getPageContext().getPageActivity());
        this.jAh.kd(i3);
        this.jAh.setYesButtonTag(sparseArray);
        this.jAh.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.jHt != null) {
                    a.this.jHt.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.jAh.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jAh.gE(true);
        this.jAh.b(this.jGW.getPageContext());
        if (z) {
            this.jAh.aMS();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bNF;
        if (this.jGW != null && sparseArray != null && this.jGV != null) {
            if (this.hBK == null) {
                this.hBK = new e(this.jGW.getPageContext(), this.jGV);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.jGy != null && (bNF = this.jGy.bNF()) != null && bNF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bNF.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.hBK.setDefaultReasonArray(new String[]{this.jGW.getString(R.string.delete_thread_reason_1), this.jGW.getString(R.string.delete_thread_reason_2), this.jGW.getString(R.string.delete_thread_reason_3), this.jGW.getString(R.string.delete_thread_reason_4), this.jGW.getString(R.string.delete_thread_reason_5)});
            this.hBK.setData(alVar);
            this.hBK.xD("4");
            this.hBK.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void T(JSONArray jSONArray) {
                    String P = aq.P(jSONArray);
                    if (a.this.jHt != null) {
                        a.this.jHt.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), P});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void na(final boolean z) {
        if (this.eOj != null) {
            if (!z) {
                this.eOj.setEnabled(z);
            } else {
                this.eOj.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.eOj.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.jHs = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.jHt = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.jGW.showToast(this.jGW.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.jGW.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aWN() != null) {
            this.iBq = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.jGX.addView(hVar.aWN(), layoutParams);
            this.iBq.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cCL();
                }
            });
        }
    }

    public void cCr() {
        if (this.eOj != null) {
            this.jHz = this.eOj.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qV(boolean z) {
        if (this.jGy == null || this.jGy.cCO() == null) {
            return false;
        }
        if (this.jGy.cvE() != 0) {
            return false;
        }
        return (this.jFF == null || this.jFF.aIu() == null || this.jFF.aIu().aKC() == null || !TextUtils.equals(this.jFF.aIu().aKC().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cCs() {
        if (this.jGy != null) {
            if ((!cCv() && this.jHo != null && this.jHo.isShown()) || v.isEmpty(this.jHu)) {
                this.jGy.rX(false);
            } else {
                this.jGy.rX(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.jGy = subPbModel;
    }

    public void rU(boolean z) {
        if (this.jGy != null && this.jGy.cCp() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.jHp = new BlankView(this.jGW.getPageContext().getPageActivity());
            this.jGU.addView(this.jHp, 0, new LinearLayout.LayoutParams(-1, com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.jHp.setVisibility(0);
            this.jHp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jGW.finish();
                }
            });
            this.jGT.setBlankView(this.jHp);
        }
    }

    public void cCt() {
        b(this.jGW);
        this.eOj.setNextPage(this.jHj);
    }

    public void r(PostData postData) {
        int i;
        if (postData != null) {
            postData.tV(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cCv() && this.jHo != null && this.jHo.isShown()) {
                i = (this.jHz - this.jHy) - 1;
            } else {
                i = this.jHz - this.jHy;
            }
            int count = v.getCount(this.jHu);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.jHu, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.eOj.smoothScrollToPosition(this.jHz + 2);
            this.eOj.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.eOj.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.eOj.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.jGT;
    }

    public void cAY() {
        if (this.jHl != null) {
            g.dismissPopupWindow(this.jHl, this.jGW.getPageContext().getPageActivity());
        }
        if (this.jHn != null) {
            this.jHn.dismiss();
        }
        if (this.jAh != null) {
            this.jAh.dismiss();
        }
        if (this.jHq != null) {
            g.b(this.jHq, this.jGW.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.jGB != null) {
            this.jGB.dismiss();
        }
    }

    public void cCu() {
        this.eOj.setNextPage(this.jHj);
        this.jHj.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dXi = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v35, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(l lVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (lVar != null) {
            if (this.dXi && this.jGV != null) {
                this.jGV.setVisibility(8);
                this.eOj.removeHeaderView(this.jGV);
                this.jHy = 1;
            }
            this.jFF = lVar;
            if (this.jGV != null) {
                this.jGV.setVisibility(0);
            }
            if (lVar.aIu() != null && lVar.aIu().aMy()) {
                this.jGY.setText(R.string.view_original);
            } else {
                this.jGY.setText(R.string.view_subject);
            }
            if (lVar.cwf() != null) {
                this.eoQ = lVar.cwf().cWp();
                if (this.eoQ > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.jGW.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eoQ)));
                    if (this.jGW != null) {
                        this.hox.setText(this.jGW.cAm());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.jGW.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.jGW.cCp() ? "PB" : null;
                if (lVar.cwf().aKX() != null) {
                    this.jHi.setData(this.jGW.getPageContext(), lVar.cwf().aKX(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", lVar.aXG().getId(), lVar.aXG().getName(), lVar.aIu().getId(), str));
                } else {
                    this.jHi.setData(null, null, null);
                }
            }
            if (lVar.hasMore()) {
                this.jHj.startLoadData();
                this.jHA.setHasMoreData(true);
            } else {
                this.jHj.endLoadData();
                this.jHA.setHasMoreData(false);
            }
            this.jHu = lVar.cwj();
            if (this.jHu == null || this.jHu.size() <= jGS) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.jHu.size() - jGS;
                zX(size);
                int firstVisiblePosition = this.eOj.getFirstVisiblePosition() - size;
                View childAt = this.eOj.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.jHu);
            if (v.isEmpty(this.jHu)) {
                this.eOj.setNextPage(null);
                if (this.dXi) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.eOj.setNextPage(this.jHj);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(lVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.dXi) {
                arrayList.add(0, lVar.cwf());
            }
            this.jHA.b(this.jFF.aIu(), arrayList);
            a(lVar, lVar.cwf(), lVar.cin(), lVar.aGX(), i, z);
            if (i4 > 0) {
                this.eOj.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void zX(int i) {
        if (this.jHu != null) {
            if (this.jHu.size() <= i) {
                this.jHu.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.jHu.iterator();
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

    public boolean cCv() {
        return this.jHA.akh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(l lVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dXi) {
            if (!StringUtils.isNull(postData.cWw())) {
                this.jHg.setVisibility(0);
                this.jHg.startLoad(postData.cWw(), 10, true);
            } else {
                this.jHg.setVisibility(8);
            }
            i cWy = postData.cWy();
            if (cWy != null && cWy.kSa) {
                this.jHh.setVisibility(0);
            } else {
                this.jHh.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.jGV.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.jGV.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.jHd.setText((CharSequence) null);
            this.cBd.setText((CharSequence) null);
            this.jCX.setVisibility(8);
            if (!this.dXi) {
                c(postData.aKC());
                if (z) {
                    this.jCX.setVisibility(0);
                    am.setViewTextColor(this.jCX, (int) R.color.cp_link_tip_a);
                }
            }
            this.jHe.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.jGW.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cWp()));
            if (lVar.aIu() != null && lVar.aIu().aMy()) {
                this.jHd.setText((CharSequence) null);
            } else {
                this.jHd.setText(format);
            }
            postData.aKC().getUserTbVipInfoData();
            boolean a = a(this.jHf, postData.cWr());
            if (StringUtils.isNull(postData.cWw()) && !a && postData.bcn() != null) {
                this.agJ.setVisibility(0);
                this.agJ.setTag(postData.bcn());
                return;
            }
            this.agJ.setVisibility(8);
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
                this.cBd.setText(cL(metaData.getSealPrefix(), str));
            } else {
                this.cBd.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.jHb != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.jHb.setVisibility(8);
                } else {
                    this.jHb.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.djn = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.jHb.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.jDe.setVisibility(0);
                this.jHa.setVisibility(8);
                this.jDe.setUserId(metaData.getUserId());
                this.jDe.setUserName(metaData.getUserName());
                this.jDe.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cBd, (int) R.color.cp_cont_r);
            } else {
                this.jDe.setVisibility(8);
                this.jHa.setVisibility(0);
                this.jHa.setUserId(metaData.getUserId());
                this.jHa.setUserName(metaData.getUserName());
                this.jHa.setDefaultResource(R.drawable.transparent_bg);
                this.jHa.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jHa.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.cBd, (int) R.color.cp_cont_c);
            }
            this.jGZ.setTag(R.id.tag_user_id, metaData.getUserId());
            this.jGZ.setTag(R.id.tag_user_name, metaData.getUserName());
            this.jGZ.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bcf() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bcf().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.bcm());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.il(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.deB());
                        continue;
                    case 17:
                        String str = next.bcq().mGifInfo.mSharpText;
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
        if (!tbRichTextData.bcu()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.bcm() == null || tbRichTextData.bcm().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.bcm());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jGW.getPageContext().getString(R.string.refresh_view_button_text), this.dkx));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.jGW.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.jGX, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, com.baidu.adp.lib.util.l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.eOj.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.iBq.aXM();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.jGW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wU(int i) {
        b(NoDataViewFactory.d.cK(null, this.jGW.getResources().getString(R.string.refresh_view_title_text)));
        this.jHv.setVisibility(8);
    }

    public void By(String str) {
        b(NoDataViewFactory.d.cK(str, this.jGW.getPageContext().getString(R.string.refresh_view_title_text)));
        this.jHv.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.eOj.setVisibility(0);
            this.jHv.setVisibility(0);
            this.jGT.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dkx = onClickListener;
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
                String userId2 = postData.aKC().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.jFF != null && this.jFF.aIu() != null && this.jFF.aIu().aKC() != null && postData.aKC() != null) {
                String userId3 = this.jFF.aIu().aKC().getUserId();
                String userId4 = postData.aKC().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aKC().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.cWp() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aKC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aKC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKC().getPortrait());
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
                        if (postData.aKC() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aKC().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aKC().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aKC().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aKC() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aKC().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aKC().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aKC().getName_show());
                        }
                        if (this.jFF.aIu() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jFF.aIu().getId());
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
            userId = postData.aKC().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.cWp() == 1) {
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
        if (this.jGB != null && this.jGB.czw() != null) {
            if (z) {
                this.jGB.czw().setText(R.string.remove_mark);
            } else {
                this.jGB.czw().setText(R.string.mark);
            }
        }
    }

    public View cCw() {
        return this.jHo;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.jGT, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.jGX, R.color.cp_bg_line_d);
        this.jGW.getLayoutMode().setNightMode(i == 1);
        this.jGW.getLayoutMode().onModeChanged(this.jGT);
        this.jGW.getLayoutMode().onModeChanged(this.jGV);
        this.mNavigationBar.onChangeSkinType(this.jGW.getPageContext(), i);
        if (this.jGY != null) {
            am.setViewTextColor(this.jGY, (int) R.color.goto_see_subject_color);
        }
        this.gUl.onChangeSkinType(this.jGW.getPageContext(), i);
        this.jGW.getLayoutMode().onModeChanged(this.jHo);
        am.setViewTextColor(this.jHf, (int) R.color.cp_cont_b);
        this.jHf.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.iBq != null && this.iBq.aWN() != null) {
            this.iBq.aWN().onChangeSkinType(i);
        }
        this.jHj.changeSkin(i);
        this.agJ.ckN();
        am.setViewTextColor(this.hox, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.jCX, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.cBd, (int) R.color.cp_cont_c);
        this.hox.setAlpha(0.95f);
        if (this.jHk != null) {
            com.baidu.tbadk.q.a.a(this.jGW.getPageContext(), this.jHk);
        }
        if (this.jHA != null) {
            this.jHA.notifyDataSetChanged();
        }
        this.jGW.getLayoutMode().onModeChanged(this.jHm);
    }

    public void cCx() {
        this.mProgress.setVisibility(0);
    }

    public void cCy() {
        this.eOj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jHj.endLoadData();
    }

    public void bLI() {
        this.eOj.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jHj.bLI();
    }

    public boolean cCz() {
        return this.jGT.cCz();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.jHA.c(onLongClickListener);
    }

    public View cCA() {
        return this.jGV;
    }

    public TextView bSZ() {
        return this.hox;
    }

    public ImageView cCB() {
        return this.jHw;
    }

    public ImageView cCC() {
        return this.jHx;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zY(int i) {
    }

    public View cCD() {
        return this.jGY;
    }

    public View cCE() {
        return this.jHg;
    }

    public MorePopupWindow cCF() {
        return this.jHl;
    }

    public void showLoadingDialog() {
        if (this.gvE == null) {
            this.gvE = new com.baidu.tbadk.core.view.a(this.jGW.getPageContext());
        }
        this.gvE.setDialogVisiable(true);
    }

    public void bzS() {
        if (this.gvE != null) {
            this.gvE.setDialogVisiable(false);
        }
    }

    public TextView cCG() {
        return this.jHf;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.jHA.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.jHA != null) {
            this.jHA.notifyDataSetChanged();
        }
    }

    public com.baidu.tieba.pb.pb.main.w cCH() {
        return this.jGB;
    }

    public void bVc() {
    }

    public void bVd() {
    }

    public void aqS() {
        this.jGT.onDestroy();
    }

    public void cCI() {
        if (this.jGW.isPaused()) {
        }
    }

    public View cCJ() {
        return this.jGZ;
    }

    private SpannableStringBuilder cL(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.jGW.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cCK() {
        if (this.iBq == null || this.iBq.aWN() == null) {
            return 0;
        }
        return this.iBq.aWN().getHeight();
    }

    public void cCL() {
        if (this.hox != null && this.iBq != null) {
            if (this.iBq.aXR()) {
                this.hox.setText(R.string.draft_to_send);
            } else {
                this.hox.setText(this.jGW.cAm());
            }
        }
    }
}
