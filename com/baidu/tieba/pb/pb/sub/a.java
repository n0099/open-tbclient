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
import com.baidu.tbadk.core.data.aq;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.h;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.card.m;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.a.c;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.ah;
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
/* loaded from: classes16.dex */
public class a implements KeyboardEventLayout.a {
    private static final int kCs = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aMH;
    private LinearLayout eJA;
    private NoNetworkView eJz;
    private BdTypeListView frv;
    private TextView hXf;
    private com.baidu.tbadk.core.view.a hdc;
    private View huZ;
    private e ikU;
    private SubPbModel kBR;
    private ah kBU;
    private p kBc;
    private View kCA;
    private ThreadSkinView kCH;
    private d kCI;
    private View kCJ;
    private View kCL;
    private View kCN;
    private BlankView kCO;
    private com.baidu.tbadk.core.dialog.b kCQ;
    private ArrayList<PostData> kCT;
    private RelativeLayout kCU;
    private ImageView kCV;
    private ImageView kCW;
    private c kCZ;
    private SubPbView kCt;
    private View kCu;
    private NewSubPbActivity kCv;
    private RelativeLayout kCw;
    private View kvI;
    private LinearLayout kvK;
    private HeadImageView kvL;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dJA = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kCx = null;
    private LinearLayout kCy = null;
    private HeadImageView kCz = null;
    private TextView dKI = null;
    private ImageView kCB = null;
    private TextView kyq = null;
    private TextView kCC = null;
    private TextView kCD = null;
    private EllipsizeRichTextView kCE = null;
    private TbImageView kCF = null;
    private PlayVoiceBntNew aio = null;
    private TextView kCG = null;
    private MorePopupWindow kCK = null;
    private com.baidu.tbadk.core.dialog.b kCM = null;
    private Dialog kCP = null;
    private com.baidu.tbadk.core.dialog.a kvt = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a kCR = null;
    private NewSubPbActivity.a kCS = null;
    private h jqD = null;
    private int eUh = 0;
    private int kCX = 2;
    private int kCY = 0;
    private boolean eAv = true;
    private boolean klE = com.baidu.tbadk.a.d.aRO();
    private com.baidu.tieba.pb.a.c euG = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.om(false);
            a.this.om(true);
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
    protected AdapterView.OnItemLongClickListener kDa = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) x.getItem(a.this.kCT, i);
            if (view != null && view.getTag() != null) {
                if (a.this.kBU == null) {
                    a.this.kBU = new ah(a.this.kCv.getPageContext(), a.this.aMH);
                }
                a.this.kBU.showDialog();
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
                boolean z2 = a.this.sm(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                ah ahVar = a.this.kBU;
                int cKM = a.this.kBR.cKM();
                if (!a.this.klE || postData2 == null || !postData2.lNY) {
                    z = false;
                }
                ahVar.a(sparseArray, cKM, z2, z);
                if (z2) {
                    a.this.kBU.cOM().setVisibility(0);
                    a.this.kBU.cOM().setTag(postData.getId());
                } else {
                    a.this.kBU.cOM().setVisibility(8);
                }
                a.this.kBU.cOK().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener kDb = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.kCv != null && bf.checkUpIsLogin(a.this.kCv.getPageContext().getPageActivity())) {
                if ((a.this.kCv.jqx == null || a.this.kBR == null || a.this.kBR.cax() == null || a.this.kCv.jqx.lJ(a.this.kBR.cax().replyPrivateFlag)) && a.this.kBR != null && a.this.jqD != null) {
                    a.this.cRJ();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cRL();
                        a.this.kBR.cSk();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.jqD.setReplyId(str2);
                            a.this.jqD.zP(str);
                        }
                    }
                    a.this.cRK();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.kCt = null;
        this.kCu = null;
        this.frv = null;
        this.kCv = null;
        this.eJz = null;
        this.kCw = null;
        this.kCA = null;
        this.kCI = null;
        this.kCN = null;
        this.aMH = null;
        this.mProgress = null;
        this.hXf = null;
        this.kCU = null;
        this.kCV = null;
        this.kCW = null;
        this.kCv = newSubPbActivity;
        this.aMH = onClickListener;
        this.kCt = (SubPbView) LayoutInflater.from(this.kCv.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.kCu = LayoutInflater.from(this.kCv.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.eJA = (LinearLayout) this.kCt.findViewById(R.id.navigation_bar_group);
        this.kCU = (RelativeLayout) this.kCt.findViewById(R.id.subpb_editor_tool_comment);
        this.hXf = (TextView) this.kCt.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hXf.setOnClickListener(this.aMH);
        this.kCV = (ImageView) this.kCt.findViewById(R.id.subpb_editor_tool_more_img);
        this.kCW = (ImageView) this.kCt.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.kCW.setOnClickListener(this.aMH);
        this.kCV.setOnClickListener(this.aMH);
        this.eJz = (NoNetworkView) this.kCt.findViewById(R.id.view_no_network);
        cgj();
        bBA();
        this.kCw = (RelativeLayout) this.kCt.findViewById(R.id.sub_pb_body_layout);
        this.frv = (BdTypeListView) this.kCt.findViewById(R.id.new_sub_pb_list);
        this.kCH = (ThreadSkinView) LayoutInflater.from(this.kCv.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.frv.addHeaderView(this.kCH);
        this.frv.addHeaderView(this.kCu);
        this.huZ = new TextView(newSubPbActivity.getActivity());
        this.huZ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.frv.addHeaderView(this.huZ, 0);
        this.kCt.setTopView(this.huZ);
        this.kCt.setNavigationView(this.eJA);
        this.kCt.setListView(this.frv);
        this.kCt.setContentView(this.kCw);
        this.kCI = new d(this.kCv.getPageContext());
        this.kCI.setLineGone();
        this.kCN = this.kCI.getView();
        this.frv.setNextPage(this.kCI);
        this.kCI.setOnClickListener(this.aMH);
        this.frv.setOnItemClickListener(this.kDb);
        this.frv.setOnItemLongClickListener(this.kDa);
        this.frv.setOnTouchListener(this.euG);
        this.mProgress = (ProgressBar) this.kCt.findViewById(R.id.progress);
        this.kvI = this.kCt.findViewById(R.id.view_comment_top_line);
        this.kvK = (LinearLayout) this.kCt.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kvL = (HeadImageView) this.kCt.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kvL.setVisibility(0);
        this.kvL.setIsRound(true);
        this.kvL.setBorderWidth(l.getDimens(this.kCv, R.dimen.tbds1));
        this.kvL.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.kvL.setPlaceHolder(1);
        this.kvL.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kvL.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kCu != null) {
            this.kCu.setVisibility(4);
        }
        this.kCA = com.baidu.tbadk.ala.b.aSa().p(this.kCv.getActivity(), 4);
        if (this.kCA != null) {
            this.kCA.setVisibility(8);
            this.kCy.addView(this.kCA, 3);
        }
        this.kCZ = new c(this.kCv, this.frv);
        this.kCZ.setFromCDN(this.mIsFromCDN);
        this.kCZ.z(this.aMH);
        this.kCZ.DS();
    }

    public ListView getListView() {
        return this.frv;
    }

    public void bBA() {
        this.kCy = (LinearLayout) this.kCu.findViewById(R.id.subpb_head_user_info_root);
        this.kCy.setOnClickListener(this.aMH);
        this.kCz = (HeadImageView) this.kCu.findViewById(R.id.photo);
        this.kCz.setRadius(l.getDimens(this.kCv.getActivity(), R.dimen.tbds45));
        this.kCz.setClickable(false);
        this.dKI = (TextView) this.kCu.findViewById(R.id.user_name);
        this.kCB = (ImageView) this.kCu.findViewById(R.id.user_rank);
        this.kCB.setVisibility(8);
        this.kyq = (TextView) this.kCu.findViewById(R.id.floor_owner);
        this.kCx = (TextView) this.kCu.findViewById(R.id.see_subject);
        this.kCx.setOnClickListener(this.aMH);
        this.kCC = (TextView) this.kCu.findViewById(R.id.floor);
        this.kCD = (TextView) this.kCu.findViewById(R.id.time);
        this.kCE = (EllipsizeRichTextView) this.kCu.findViewById(R.id.content_text);
        this.kCE.setOnClickListener(this.aMH);
        ao.setViewTextColor(this.kCE, R.color.cp_cont_b);
        this.kCE.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        this.kCE.setLineSpacing(0.0f, 1.25f);
        this.kCF = (TbImageView) this.kCu.findViewById(R.id.sub_pb_image);
        this.kCF.setOnClickListener(this.aMH);
        this.kCG = (TextView) this.kCu.findViewById(R.id.advert);
        this.aio = (PlayVoiceBntNew) this.kCu.findViewById(R.id.voice_btn);
        this.kCu.setOnTouchListener(this.euG);
        this.kCu.setOnClickListener(this.aMH);
    }

    public void a(b.InterfaceC0492b interfaceC0492b, boolean z) {
        if (this.kCQ != null) {
            this.kCQ.dismiss();
            this.kCQ = null;
        }
        this.kCQ = new com.baidu.tbadk.core.dialog.b(this.kCv.getPageContext().getPageActivity());
        if (z) {
            this.kCQ.a(new String[]{this.kCv.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0492b);
        } else {
            this.kCQ.a(new String[]{this.kCv.getPageContext().getString(R.string.save_to_emotion), this.kCv.getPageContext().getString(R.string.save_to_local)}, interfaceC0492b);
        }
        this.kCQ.d(this.kCv.getPageContext());
        this.kCQ.aYN();
    }

    public void cU(View view) {
        this.kCJ = view;
    }

    public void cgj() {
        int dimens = l.getDimens(this.kCv.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.kCv.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.kCt.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kCO != null) {
                    a.this.kCt.onFinish();
                } else {
                    a.this.kCv.finish();
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

    public void cP(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.kCP == null) {
            this.kCP = new Dialog(this.kCv.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kCP.setCanceledOnTouchOutside(true);
            this.kCP.setCancelable(true);
            this.kCL = LayoutInflater.from(this.kCv.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.kCv.getLayoutMode().onModeChanged(this.kCL);
            this.kCP.setContentView(this.kCL);
            WindowManager.LayoutParams attributes = this.kCP.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.kCv.getPageContext().getPageActivity()) * 0.9d);
            this.kCP.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.kCP.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.kCP.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.kCP.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.kCP != null && (a.this.kCP instanceof Dialog)) {
                        g.b(a.this.kCP, a.this.kCv.getPageContext());
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
                    if (a.this.kCP != null && (a.this.kCP instanceof Dialog)) {
                        g.b(a.this.kCP, a.this.kCv.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.kCR != null) {
                        a.this.kCR.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.kCP != null && (a.this.kCP instanceof Dialog)) {
                        g.b(a.this.kCP, a.this.kCv.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.kCv.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.kCP, this.kCv.getPageContext());
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
        this.kvt = new com.baidu.tbadk.core.dialog.a(this.kCv.getPageContext().getPageActivity());
        this.kvt.ln(i3);
        this.kvt.setYesButtonTag(sparseArray);
        this.kvt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.kCS != null) {
                    a.this.kCS.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.kvt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kvt.hJ(true);
        this.kvt.b(this.kCv.getPageContext());
        if (z) {
            this.kvt.aYL();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cax;
        if (this.kCv != null && sparseArray != null && this.kCu != null) {
            if (this.ikU == null) {
                this.ikU = new e(this.kCv.getPageContext(), this.kCu);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.kBR != null && (cax = this.kBR.cax()) != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aq aqVar = new aq();
            aqVar.setFeedBackReasonMap(sparseArray2);
            this.ikU.setDefaultReasonArray(new String[]{this.kCv.getString(R.string.delete_thread_reason_1), this.kCv.getString(R.string.delete_thread_reason_2), this.kCv.getString(R.string.delete_thread_reason_3), this.kCv.getString(R.string.delete_thread_reason_4), this.kCv.getString(R.string.delete_thread_reason_5)});
            this.ikU.setData(aqVar);
            this.ikU.AK("4");
            this.ikU.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void U(JSONArray jSONArray) {
                    String P = as.P(jSONArray);
                    if (a.this.kCS != null) {
                        a.this.kCS.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), P});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void om(final boolean z) {
        if (this.frv != null) {
            if (!z) {
                this.frv.setEnabled(z);
            } else {
                this.frv.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.frv.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.kCR = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.kCS = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.kCv.showToast(this.kCv.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.kCv.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.biJ() != null) {
            this.jqD = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.kCw.addView(hVar.biJ(), layoutParams);
            this.jqD.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cSe();
                }
            });
        }
    }

    public void cRJ() {
        if (this.frv != null) {
            this.kCY = this.frv.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sm(boolean z) {
        if (this.kBR == null || this.kBR.cSh() == null) {
            return false;
        }
        if (this.kBR.cKM() != 0) {
            return false;
        }
        return (this.kBc == null || this.kBc.aTN() == null || this.kBc.aTN().aWl() == null || !TextUtils.equals(this.kBc.aTN().aWl().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cRK() {
        if (this.kBR != null) {
            if ((!cRN() && this.kCN != null && this.kCN.isShown()) || x.isEmpty(this.kCT)) {
                this.kBR.tp(false);
            } else {
                this.kBR.tp(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.kBR = subPbModel;
    }

    public void tm(boolean z) {
        if (this.kBR != null && this.kBR.cRH() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.kCO = new BlankView(this.kCv.getPageContext().getPageActivity());
            this.eJA.addView(this.kCO, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.kCO.setVisibility(0);
            this.kCO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kCv.finish();
                }
            });
            this.kCt.setBlankView(this.kCO);
        }
    }

    public void cRL() {
        b(this.kCv);
        this.frv.setNextPage(this.kCI);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.vm(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cRN() && this.kCN != null && this.kCN.isShown()) {
                i = (this.kCY - this.kCX) - 1;
            } else {
                i = this.kCY - this.kCX;
            }
            int count = x.getCount(this.kCT);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(x.subList(this.kCT, 0, i));
            x.add(arrayList, postData2);
            x.add(arrayList, postData);
            this.frv.smoothScrollToPosition(this.kCY + 2);
            this.frv.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.frv.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.frv.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.kCt;
    }

    public void cQo() {
        if (this.kCK != null) {
            g.dismissPopupWindow(this.kCK, this.kCv.getPageContext().getPageActivity());
        }
        if (this.kCM != null) {
            this.kCM.dismiss();
        }
        if (this.kvt != null) {
            this.kvt.dismiss();
        }
        if (this.kCP != null) {
            g.b(this.kCP, this.kCv.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.kBU != null) {
            this.kBU.dismiss();
        }
    }

    public void cRM() {
        this.frv.setNextPage(this.kCI);
        this.kCI.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.eAv = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(p pVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (pVar != null) {
            if (this.eAv && this.kCu != null) {
                this.kCu.setVisibility(8);
                this.frv.removeHeaderView(this.kCu);
                this.kCX = 1;
            }
            this.kBc = pVar;
            if (this.kBc.cLt() != null) {
                this.kBc.cLt().lNY = true;
            }
            if (this.kCu != null) {
                this.kCu.setVisibility(0);
            }
            if (pVar.aTN() != null && pVar.aTN().aUV()) {
                this.kCx.setText(R.string.view_original);
            } else {
                this.kCx.setText(R.string.view_subject);
            }
            if (pVar.cLt() != null) {
                this.eUh = pVar.cLt().dlh();
                if (this.eUh > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.kCv.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eUh)));
                    if (this.kCv != null) {
                        this.hXf.setText(this.kCv.cPC());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.kCv.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.kCv.cRH() ? "PB" : null;
                if (pVar.cLt().aWH() != null) {
                    this.kCH.setData(this.kCv.getPageContext(), pVar.cLt().aWH(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", pVar.bjG().getId(), pVar.bjG().getName(), pVar.aTN().getId(), str));
                } else {
                    this.kCH.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.kCI.startLoadData();
                this.kCZ.setHasMoreData(true);
            } else {
                this.kCI.endLoadData();
                this.kCZ.setHasMoreData(false);
            }
            this.kCT = pVar.cLx();
            if (this.kCT == null || this.kCT.size() <= kCs) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.kCT.size() - kCs;
                Cm(size);
                int firstVisiblePosition = this.frv.getFirstVisiblePosition() - size;
                View childAt = this.frv.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kCT);
            if (x.isEmpty(this.kCT)) {
                this.frv.setNextPage(null);
                if (this.eAv) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.frv.setNextPage(this.kCI);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eAv) {
                arrayList.add(0, pVar.cLt());
            }
            this.kCZ.a(this.kBc.aTN(), arrayList);
            a(pVar, pVar.cLt(), pVar.cwL(), pVar.aSj(), i, z);
            if (i4 > 0) {
                this.frv.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void Cm(int i) {
        if (this.kCT != null) {
            if (this.kCT.size() <= i) {
                this.kCT.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.kCT.iterator();
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

    public boolean cRN() {
        return this.kCZ.aqL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eAv) {
            if (!StringUtils.isNull(postData.dlo())) {
                this.kCF.setVisibility(0);
                this.kCF.startLoad(postData.dlo(), 10, true);
            } else {
                this.kCF.setVisibility(8);
            }
            i dlq = postData.dlq();
            if (dlq != null && dlq.lMJ) {
                this.kCG.setVisibility(0);
            } else {
                this.kCG.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.kCu.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.kCu.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.kCC.setText((CharSequence) null);
            this.dKI.setText((CharSequence) null);
            this.kyq.setVisibility(8);
            if (!this.eAv) {
                c(postData.aWl());
                if (z) {
                    this.kyq.setVisibility(0);
                    ao.setViewTextColor(this.kyq, R.color.cp_link_tip_a);
                }
            }
            this.kCD.setText(as.getFormatTime(postData.getTime()));
            String format = String.format(this.kCv.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dlh()));
            if (pVar.aTN() != null && pVar.aTN().aUV()) {
                this.kCC.setText((CharSequence) null);
            } else {
                this.kCC.setText(format);
            }
            postData.aWl().getUserTbVipInfoData();
            boolean a = a(this.kCE, postData.dlj());
            if (StringUtils.isNull(postData.dlo()) && !a && postData.boR() != null) {
                this.aio.setVisibility(0);
                this.aio.setTag(postData.boR());
                return;
            }
            this.aio.setVisibility(8);
        }
    }

    private void c(MetaData metaData) {
        String str;
        if (metaData != null) {
            String name_show = metaData.getName_show();
            if ((!StringUtils.isNull(metaData.getSealPrefix()) ? k.byteLength(metaData.getSealPrefix()) + 2 : 0) + ae.getTextLength(name_show) > 14) {
                str = ae.subString(name_show, 0, 14);
                if (str.length() != name_show.length()) {
                    str = str + StringHelper.STRING_MORE;
                }
            } else {
                str = name_show;
            }
            if (!StringUtils.isNull(metaData.getSealPrefix())) {
                this.dKI.setText(dp(metaData.getSealPrefix(), str));
            } else {
                this.dKI.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.kCA != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.kCA.setVisibility(8);
                } else {
                    this.kCA.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dIq = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.kCA.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_r);
            } else {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_c);
            }
            this.kCz.setVisibility(0);
            this.kCz.setUserId(metaData.getUserId());
            this.kCz.setUserName(metaData.getUserName());
            this.kCz.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.kCz, metaData);
            this.kCz.startLoad(metaData.getAvater(), 28, false);
            this.kCy.setTag(R.id.tag_user_id, metaData.getUserId());
            this.kCy.setTag(R.id.tag_user_name, metaData.getUserName());
            this.kCy.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.boJ() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.boJ().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.n(next.boQ());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.jz(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dtD());
                        continue;
                    case 17:
                        String str = next.boU().mGifInfo.mSharpText;
                        if (str == null) {
                            continue;
                        } else if (str.startsWith("#(") && str.endsWith(")")) {
                            tbRichTextData.n("[" + str.substring(2, str.length() - 1) + "]");
                            break;
                        }
                        break;
                }
            }
        }
        if (!tbRichTextData.boZ()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.boQ() == null || tbRichTextData.boQ().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.boQ());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.kCv.getPageContext().getString(R.string.refresh_view_button_text), this.dJA));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.kCv.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.kCw, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.frv.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.jqD.bjM();
        ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.kCv.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void yK(int i) {
        b(NoDataViewFactory.d.m31do(null, this.kCv.getResources().getString(R.string.refresh_view_title_text)));
        this.kCU.setVisibility(8);
    }

    public void Et(String str) {
        b(NoDataViewFactory.d.m31do(str, this.kCv.getPageContext().getString(R.string.refresh_view_title_text)));
        this.kCU.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.frv.setVisibility(0);
            this.kCU.setVisibility(0);
            this.kCt.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dJA = onClickListener;
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
        boolean z5;
        String userId;
        boolean z6;
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
                String userId2 = postData.aWl().getUserId();
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
            if (this.kBc != null && this.kBc.aTN() != null && this.kBc.aTN().aWl() != null && postData.aWl() != null) {
                String userId3 = this.kBc.aTN().aWl().getUserId();
                String userId4 = postData.aWl().getUserId();
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
                    userId = postData.aWl().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z5 = true;
                        z4 = true;
                    }
                    int i2 = postData.dlh() != 1 ? 0 : 1;
                    if (!z2) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aWl() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aWl().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aWl().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aWl().getPortrait());
                            z6 = true;
                        } else {
                            z6 = true;
                        }
                    } else {
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                        z6 = false;
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        z6 = true;
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z2) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.aWl() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aWl().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aWl().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aWl().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z3) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aWl() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aWl().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aWl().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aWl().getName_show());
                        }
                        if (this.kBc.aTN() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kBc.aTN().getId());
                        }
                        sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_delete_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                        return;
                    }
                    sparseArray.put(R.id.tag_should_delete_visible, false);
                    return;
                }
            }
            z3 = false;
            z4 = z;
            z5 = false;
            userId = postData.aWl().getUserId();
            if (userId != null) {
                z5 = true;
                z4 = true;
            }
            if (postData.dlh() != 1) {
            }
            if (!z2) {
            }
            if (!z4) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z6));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z2) {
            }
            if (!z3) {
            }
            if (!z4) {
            }
        }
    }

    public void tn(boolean z) {
        if (this.kBU != null && this.kBU.cOK() != null) {
            if (z) {
                this.kBU.cOK().setText(R.string.remove_mark);
            } else {
                this.kBU.cOK().setText(R.string.mark);
            }
        }
    }

    public View cRO() {
        return this.kCN;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.kCt, R.color.cp_mask_b_alpha66);
        ao.setBackgroundColor(this.kCw, R.color.cp_bg_line_d);
        this.kCv.getLayoutMode().setNightMode(i == 1);
        this.kCv.getLayoutMode().onModeChanged(this.kCt);
        this.kCv.getLayoutMode().onModeChanged(this.kCu);
        this.mNavigationBar.onChangeSkinType(this.kCv.getPageContext(), i);
        if (this.kCx != null) {
            ao.setViewTextColor(this.kCx, R.color.goto_see_subject_color);
        }
        this.eJz.onChangeSkinType(this.kCv.getPageContext(), i);
        this.kCv.getLayoutMode().onModeChanged(this.kCN);
        ao.setViewTextColor(this.kCE, R.color.cp_cont_b);
        this.kCE.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        if (this.jqD != null && this.jqD.biJ() != null) {
            this.jqD.biJ().onChangeSkinType(i);
        }
        this.kCI.changeSkin(i);
        this.aio.changeSkin();
        ao.setViewTextColor(this.hXf, R.color.cp_cont_e);
        ao.setViewTextColor(this.kyq, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.dKI, R.color.cp_cont_c);
        this.hXf.setAlpha(0.95f);
        if (this.kCJ != null) {
            com.baidu.tbadk.r.a.a(this.kCv.getPageContext(), this.kCJ);
        }
        if (this.kCZ != null) {
            this.kCZ.notifyDataSetChanged();
        }
        this.kCv.getLayoutMode().onModeChanged(this.kCL);
        ao.setBackgroundResource(this.kvI, R.drawable.bottom_shadow);
        this.kvL.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.kvK.setBackgroundDrawable(ao.aH(l.getDimens(this.kCv, R.dimen.tbds47), ao.getColor(R.color.cp_bg_line_j)));
    }

    public void cRP() {
        this.mProgress.setVisibility(0);
    }

    public void cRQ() {
        this.frv.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kCI.endLoadData();
    }

    public void bYv() {
        this.frv.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kCI.bYv();
    }

    public boolean cRR() {
        return this.kCt.cRR();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kCZ.c(onLongClickListener);
    }

    public View cRS() {
        return this.kCu;
    }

    public TextView cgo() {
        return this.hXf;
    }

    public ImageView cRT() {
        return this.kCV;
    }

    public ImageView cRU() {
        return this.kCW;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Cn(int i) {
    }

    public View cRV() {
        return this.kCx;
    }

    public View cRW() {
        return this.kCF;
    }

    public MorePopupWindow cRX() {
        return this.kCK;
    }

    public void showLoadingDialog() {
        if (this.hdc == null) {
            this.hdc = new com.baidu.tbadk.core.view.a(this.kCv.getPageContext());
        }
        this.hdc.setDialogVisiable(true);
    }

    public void bMt() {
        if (this.hdc != null) {
            this.hdc.setDialogVisiable(false);
        }
    }

    public TextView cRY() {
        return this.kCE;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kCZ.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.kCZ != null) {
            this.kCZ.notifyDataSetChanged();
        }
    }

    public ah cRZ() {
        return this.kBU;
    }

    public void ciz() {
    }

    public void ciA() {
    }

    public void cgL() {
        this.kCt.onDestroy();
    }

    public void cSa() {
        if (this.kCv.isPaused()) {
        }
    }

    public View cSb() {
        return this.kCy;
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.kCv.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cSc() {
        if (this.jqD == null || this.jqD.biJ() == null) {
            return 0;
        }
        return this.jqD.biJ().getHeight();
    }

    public int cSd() {
        if (this.kCO == null) {
            return 0;
        }
        return this.kCO.getHeight();
    }

    public void cSe() {
        if (this.hXf != null && this.jqD != null) {
            if (this.jqD.bjR()) {
                this.hXf.setText(R.string.draft_to_send);
            } else {
                this.hXf.setText(this.kCv.cPC());
            }
        }
    }

    public void sz(boolean z) {
        if (this.kvL != null) {
            this.kvL.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }
}
