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
    private static final int kCu = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aMH;
    private LinearLayout eJA;
    private NoNetworkView eJz;
    private BdTypeListView frv;
    private TextView hXh;
    private com.baidu.tbadk.core.view.a hdc;
    private View huZ;
    private e ikW;
    private SubPbModel kBT;
    private ah kBW;
    private p kBe;
    private View kCC;
    private ThreadSkinView kCJ;
    private d kCK;
    private View kCL;
    private View kCN;
    private View kCP;
    private BlankView kCQ;
    private com.baidu.tbadk.core.dialog.b kCS;
    private ArrayList<PostData> kCV;
    private RelativeLayout kCW;
    private ImageView kCX;
    private ImageView kCY;
    private SubPbView kCv;
    private View kCw;
    private NewSubPbActivity kCx;
    private RelativeLayout kCy;
    private c kDb;
    private View kvK;
    private LinearLayout kvM;
    private HeadImageView kvN;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dJA = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView kCz = null;
    private LinearLayout kCA = null;
    private HeadImageView kCB = null;
    private TextView dKI = null;
    private ImageView kCD = null;
    private TextView kys = null;
    private TextView kCE = null;
    private TextView kCF = null;
    private EllipsizeRichTextView kCG = null;
    private TbImageView kCH = null;
    private PlayVoiceBntNew aio = null;
    private TextView kCI = null;
    private MorePopupWindow kCM = null;
    private com.baidu.tbadk.core.dialog.b kCO = null;
    private Dialog kCR = null;
    private com.baidu.tbadk.core.dialog.a kvv = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a kCT = null;
    private NewSubPbActivity.a kCU = null;
    private h jqF = null;
    private int eUh = 0;
    private int kCZ = 2;
    private int kDa = 0;
    private boolean eAv = true;
    private boolean klG = com.baidu.tbadk.a.d.aRO();
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
    protected AdapterView.OnItemLongClickListener kDc = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            SparseArray<Object> sparseArray;
            boolean z = true;
            PostData postData = (PostData) x.getItem(a.this.kCV, i);
            if (view != null && view.getTag() != null) {
                if (a.this.kBW == null) {
                    a.this.kBW = new ah(a.this.kCx.getPageContext(), a.this.aMH);
                }
                a.this.kBW.showDialog();
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
                ah ahVar = a.this.kBW;
                int cKM = a.this.kBT.cKM();
                if (!a.this.klG || postData2 == null || !postData2.lOa) {
                    z = false;
                }
                ahVar.a(sparseArray, cKM, z2, z);
                if (z2) {
                    a.this.kBW.cOM().setVisibility(0);
                    a.this.kBW.cOM().setTag(postData.getId());
                } else {
                    a.this.kBW.cOM().setVisibility(8);
                }
                a.this.kBW.cOK().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener kDd = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.kCx != null && bf.checkUpIsLogin(a.this.kCx.getPageContext().getPageActivity())) {
                if ((a.this.kCx.jqz == null || a.this.kBT == null || a.this.kBT.cax() == null || a.this.kCx.jqz.lJ(a.this.kBT.cax().replyPrivateFlag)) && a.this.kBT != null && a.this.jqF != null) {
                    a.this.cRJ();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cRL();
                        a.this.kBT.cSk();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.jqF.setReplyId(str2);
                            a.this.jqF.zP(str);
                        }
                    }
                    a.this.cRK();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.kCv = null;
        this.kCw = null;
        this.frv = null;
        this.kCx = null;
        this.eJz = null;
        this.kCy = null;
        this.kCC = null;
        this.kCK = null;
        this.kCP = null;
        this.aMH = null;
        this.mProgress = null;
        this.hXh = null;
        this.kCW = null;
        this.kCX = null;
        this.kCY = null;
        this.kCx = newSubPbActivity;
        this.aMH = onClickListener;
        this.kCv = (SubPbView) LayoutInflater.from(this.kCx.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.kCw = LayoutInflater.from(this.kCx.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.eJA = (LinearLayout) this.kCv.findViewById(R.id.navigation_bar_group);
        this.kCW = (RelativeLayout) this.kCv.findViewById(R.id.subpb_editor_tool_comment);
        this.hXh = (TextView) this.kCv.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hXh.setOnClickListener(this.aMH);
        this.kCX = (ImageView) this.kCv.findViewById(R.id.subpb_editor_tool_more_img);
        this.kCY = (ImageView) this.kCv.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.kCY.setOnClickListener(this.aMH);
        this.kCX.setOnClickListener(this.aMH);
        this.eJz = (NoNetworkView) this.kCv.findViewById(R.id.view_no_network);
        cgj();
        bBA();
        this.kCy = (RelativeLayout) this.kCv.findViewById(R.id.sub_pb_body_layout);
        this.frv = (BdTypeListView) this.kCv.findViewById(R.id.new_sub_pb_list);
        this.kCJ = (ThreadSkinView) LayoutInflater.from(this.kCx.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.frv.addHeaderView(this.kCJ);
        this.frv.addHeaderView(this.kCw);
        this.huZ = new TextView(newSubPbActivity.getActivity());
        this.huZ.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.frv.addHeaderView(this.huZ, 0);
        this.kCv.setTopView(this.huZ);
        this.kCv.setNavigationView(this.eJA);
        this.kCv.setListView(this.frv);
        this.kCv.setContentView(this.kCy);
        this.kCK = new d(this.kCx.getPageContext());
        this.kCK.setLineGone();
        this.kCP = this.kCK.getView();
        this.frv.setNextPage(this.kCK);
        this.kCK.setOnClickListener(this.aMH);
        this.frv.setOnItemClickListener(this.kDd);
        this.frv.setOnItemLongClickListener(this.kDc);
        this.frv.setOnTouchListener(this.euG);
        this.mProgress = (ProgressBar) this.kCv.findViewById(R.id.progress);
        this.kvK = this.kCv.findViewById(R.id.view_comment_top_line);
        this.kvM = (LinearLayout) this.kCv.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kvN = (HeadImageView) this.kCv.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kvN.setVisibility(0);
        this.kvN.setIsRound(true);
        this.kvN.setBorderWidth(l.getDimens(this.kCx, R.dimen.tbds1));
        this.kvN.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.kvN.setPlaceHolder(1);
        this.kvN.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kvN.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.kCw != null) {
            this.kCw.setVisibility(4);
        }
        this.kCC = com.baidu.tbadk.ala.b.aSa().p(this.kCx.getActivity(), 4);
        if (this.kCC != null) {
            this.kCC.setVisibility(8);
            this.kCA.addView(this.kCC, 3);
        }
        this.kDb = new c(this.kCx, this.frv);
        this.kDb.setFromCDN(this.mIsFromCDN);
        this.kDb.z(this.aMH);
        this.kDb.DS();
    }

    public ListView getListView() {
        return this.frv;
    }

    public void bBA() {
        this.kCA = (LinearLayout) this.kCw.findViewById(R.id.subpb_head_user_info_root);
        this.kCA.setOnClickListener(this.aMH);
        this.kCB = (HeadImageView) this.kCw.findViewById(R.id.photo);
        this.kCB.setRadius(l.getDimens(this.kCx.getActivity(), R.dimen.tbds45));
        this.kCB.setClickable(false);
        this.dKI = (TextView) this.kCw.findViewById(R.id.user_name);
        this.kCD = (ImageView) this.kCw.findViewById(R.id.user_rank);
        this.kCD.setVisibility(8);
        this.kys = (TextView) this.kCw.findViewById(R.id.floor_owner);
        this.kCz = (TextView) this.kCw.findViewById(R.id.see_subject);
        this.kCz.setOnClickListener(this.aMH);
        this.kCE = (TextView) this.kCw.findViewById(R.id.floor);
        this.kCF = (TextView) this.kCw.findViewById(R.id.time);
        this.kCG = (EllipsizeRichTextView) this.kCw.findViewById(R.id.content_text);
        this.kCG.setOnClickListener(this.aMH);
        ao.setViewTextColor(this.kCG, R.color.cp_cont_b);
        this.kCG.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        this.kCG.setLineSpacing(0.0f, 1.25f);
        this.kCH = (TbImageView) this.kCw.findViewById(R.id.sub_pb_image);
        this.kCH.setOnClickListener(this.aMH);
        this.kCI = (TextView) this.kCw.findViewById(R.id.advert);
        this.aio = (PlayVoiceBntNew) this.kCw.findViewById(R.id.voice_btn);
        this.kCw.setOnTouchListener(this.euG);
        this.kCw.setOnClickListener(this.aMH);
    }

    public void a(b.InterfaceC0492b interfaceC0492b, boolean z) {
        if (this.kCS != null) {
            this.kCS.dismiss();
            this.kCS = null;
        }
        this.kCS = new com.baidu.tbadk.core.dialog.b(this.kCx.getPageContext().getPageActivity());
        if (z) {
            this.kCS.a(new String[]{this.kCx.getPageContext().getString(R.string.save_to_emotion)}, interfaceC0492b);
        } else {
            this.kCS.a(new String[]{this.kCx.getPageContext().getString(R.string.save_to_emotion), this.kCx.getPageContext().getString(R.string.save_to_local)}, interfaceC0492b);
        }
        this.kCS.d(this.kCx.getPageContext());
        this.kCS.aYN();
    }

    public void cU(View view) {
        this.kCL = view;
    }

    public void cgj() {
        int dimens = l.getDimens(this.kCx.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.kCx.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.kCv.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kCQ != null) {
                    a.this.kCv.onFinish();
                } else {
                    a.this.kCx.finish();
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
        if (this.kCR == null) {
            this.kCR = new Dialog(this.kCx.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kCR.setCanceledOnTouchOutside(true);
            this.kCR.setCancelable(true);
            this.kCN = LayoutInflater.from(this.kCx.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.kCx.getLayoutMode().onModeChanged(this.kCN);
            this.kCR.setContentView(this.kCN);
            WindowManager.LayoutParams attributes = this.kCR.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.kCx.getPageContext().getPageActivity()) * 0.9d);
            this.kCR.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.kCR.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.kCR.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.kCR.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.kCR != null && (a.this.kCR instanceof Dialog)) {
                        g.b(a.this.kCR, a.this.kCx.getPageContext());
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
                    if (a.this.kCR != null && (a.this.kCR instanceof Dialog)) {
                        g.b(a.this.kCR, a.this.kCx.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.kCT != null) {
                        a.this.kCT.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.kCR != null && (a.this.kCR instanceof Dialog)) {
                        g.b(a.this.kCR, a.this.kCx.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.kCx.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.kCR, this.kCx.getPageContext());
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
        this.kvv = new com.baidu.tbadk.core.dialog.a(this.kCx.getPageContext().getPageActivity());
        this.kvv.ln(i3);
        this.kvv.setYesButtonTag(sparseArray);
        this.kvv.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.kCU != null) {
                    a.this.kCU.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.kvv.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.kvv.hJ(true);
        this.kvv.b(this.kCx.getPageContext());
        if (z) {
            this.kvv.aYL();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData cax;
        if (this.kCx != null && sparseArray != null && this.kCw != null) {
            if (this.ikW == null) {
                this.ikW = new e(this.kCx.getPageContext(), this.kCw);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.kBT != null && (cax = this.kBT.cax()) != null && cax.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cax.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            aq aqVar = new aq();
            aqVar.setFeedBackReasonMap(sparseArray2);
            this.ikW.setDefaultReasonArray(new String[]{this.kCx.getString(R.string.delete_thread_reason_1), this.kCx.getString(R.string.delete_thread_reason_2), this.kCx.getString(R.string.delete_thread_reason_3), this.kCx.getString(R.string.delete_thread_reason_4), this.kCx.getString(R.string.delete_thread_reason_5)});
            this.ikW.setData(aqVar);
            this.ikW.AK("4");
            this.ikW.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void U(JSONArray jSONArray) {
                    String P = as.P(jSONArray);
                    if (a.this.kCU != null) {
                        a.this.kCU.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), P});
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
        this.kCT = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.kCU = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.kCx.showToast(this.kCx.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.kCx.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.biJ() != null) {
            this.jqF = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.kCy.addView(hVar.biJ(), layoutParams);
            this.jqF.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cSe();
                }
            });
        }
    }

    public void cRJ() {
        if (this.frv != null) {
            this.kDa = this.frv.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sm(boolean z) {
        if (this.kBT == null || this.kBT.cSh() == null) {
            return false;
        }
        if (this.kBT.cKM() != 0) {
            return false;
        }
        return (this.kBe == null || this.kBe.aTN() == null || this.kBe.aTN().aWl() == null || !TextUtils.equals(this.kBe.aTN().aWl().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cRK() {
        if (this.kBT != null) {
            if ((!cRN() && this.kCP != null && this.kCP.isShown()) || x.isEmpty(this.kCV)) {
                this.kBT.tp(false);
            } else {
                this.kBT.tp(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.kBT = subPbModel;
    }

    public void tm(boolean z) {
        if (this.kBT != null && this.kBT.cRH() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.kCQ = new BlankView(this.kCx.getPageContext().getPageActivity());
            this.eJA.addView(this.kCQ, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.kCQ.setVisibility(0);
            this.kCQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.kCx.finish();
                }
            });
            this.kCv.setBlankView(this.kCQ);
        }
    }

    public void cRL() {
        b(this.kCx);
        this.frv.setNextPage(this.kCK);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.vm(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cRN() && this.kCP != null && this.kCP.isShown()) {
                i = (this.kDa - this.kCZ) - 1;
            } else {
                i = this.kDa - this.kCZ;
            }
            int count = x.getCount(this.kCV);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(x.subList(this.kCV, 0, i));
            x.add(arrayList, postData2);
            x.add(arrayList, postData);
            this.frv.smoothScrollToPosition(this.kDa + 2);
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
        return this.kCv;
    }

    public void cQo() {
        if (this.kCM != null) {
            g.dismissPopupWindow(this.kCM, this.kCx.getPageContext().getPageActivity());
        }
        if (this.kCO != null) {
            this.kCO.dismiss();
        }
        if (this.kvv != null) {
            this.kvv.dismiss();
        }
        if (this.kCR != null) {
            g.b(this.kCR, this.kCx.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.kBW != null) {
            this.kBW.dismiss();
        }
    }

    public void cRM() {
        this.frv.setNextPage(this.kCK);
        this.kCK.startLoadData();
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
            if (this.eAv && this.kCw != null) {
                this.kCw.setVisibility(8);
                this.frv.removeHeaderView(this.kCw);
                this.kCZ = 1;
            }
            this.kBe = pVar;
            if (this.kBe.cLt() != null) {
                this.kBe.cLt().lOa = true;
            }
            if (this.kCw != null) {
                this.kCw.setVisibility(0);
            }
            if (pVar.aTN() != null && pVar.aTN().aUV()) {
                this.kCz.setText(R.string.view_original);
            } else {
                this.kCz.setText(R.string.view_subject);
            }
            if (pVar.cLt() != null) {
                this.eUh = pVar.cLt().dli();
                if (this.eUh > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.kCx.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eUh)));
                    if (this.kCx != null) {
                        this.hXh.setText(this.kCx.cPC());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.kCx.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.kCx.cRH() ? "PB" : null;
                if (pVar.cLt().aWH() != null) {
                    this.kCJ.setData(this.kCx.getPageContext(), pVar.cLt().aWH(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", pVar.bjG().getId(), pVar.bjG().getName(), pVar.aTN().getId(), str));
                } else {
                    this.kCJ.setData(null, null, null);
                }
            }
            if (pVar.hasMore()) {
                this.kCK.startLoadData();
                this.kDb.setHasMoreData(true);
            } else {
                this.kCK.endLoadData();
                this.kDb.setHasMoreData(false);
            }
            this.kCV = pVar.cLx();
            if (this.kCV == null || this.kCV.size() <= kCu) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.kCV.size() - kCu;
                Cm(size);
                int firstVisiblePosition = this.frv.getFirstVisiblePosition() - size;
                View childAt = this.frv.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kCV);
            if (x.isEmpty(this.kCV)) {
                this.frv.setNextPage(null);
                if (this.eAv) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.frv.setNextPage(this.kCK);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(pVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.eAv) {
                arrayList.add(0, pVar.cLt());
            }
            this.kDb.a(this.kBe.aTN(), arrayList);
            a(pVar, pVar.cLt(), pVar.cwL(), pVar.aSj(), i, z);
            if (i4 > 0) {
                this.frv.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void Cm(int i) {
        if (this.kCV != null) {
            if (this.kCV.size() <= i) {
                this.kCV.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.kCV.iterator();
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
        return this.kDb.aqL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(p pVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.eAv) {
            if (!StringUtils.isNull(postData.dlp())) {
                this.kCH.setVisibility(0);
                this.kCH.startLoad(postData.dlp(), 10, true);
            } else {
                this.kCH.setVisibility(8);
            }
            i dlr = postData.dlr();
            if (dlr != null && dlr.lML) {
                this.kCI.setVisibility(0);
            } else {
                this.kCI.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.kCw.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.kCw.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.kCE.setText((CharSequence) null);
            this.dKI.setText((CharSequence) null);
            this.kys.setVisibility(8);
            if (!this.eAv) {
                c(postData.aWl());
                if (z) {
                    this.kys.setVisibility(0);
                    ao.setViewTextColor(this.kys, R.color.cp_link_tip_a);
                }
            }
            this.kCF.setText(as.getFormatTime(postData.getTime()));
            String format = String.format(this.kCx.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.dli()));
            if (pVar.aTN() != null && pVar.aTN().aUV()) {
                this.kCE.setText((CharSequence) null);
            } else {
                this.kCE.setText(format);
            }
            postData.aWl().getUserTbVipInfoData();
            boolean a = a(this.kCG, postData.dlk());
            if (StringUtils.isNull(postData.dlp()) && !a && postData.boR() != null) {
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
            if (metaData.getAlaUserData() != null && this.kCC != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.kCC.setVisibility(8);
                } else {
                    this.kCC.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dIq = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.kCC.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_r);
            } else {
                ao.setViewTextColor(this.dKI, R.color.cp_cont_c);
            }
            this.kCB.setVisibility(0);
            this.kCB.setUserId(metaData.getUserId());
            this.kCB.setUserName(metaData.getUserName());
            this.kCB.setDefaultResource(R.drawable.transparent_bg);
            UtilHelper.showHeadImageViewBigV(this.kCB, metaData);
            this.kCB.startLoad(metaData.getAvater(), 28, false);
            this.kCA.setTag(R.id.tag_user_id, metaData.getUserId());
            this.kCA.setTag(R.id.tag_user_name, metaData.getUserName());
            this.kCA.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
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
                        textView.setMovementMethod(com.baidu.tieba.view.c.dtE());
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
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.kCx.getPageContext().getString(R.string.refresh_view_button_text), this.dJA));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.kCx.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.kCy, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.frv.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.jqF.bjM();
        ao.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.kCx.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void yK(int i) {
        b(NoDataViewFactory.d.m31do(null, this.kCx.getResources().getString(R.string.refresh_view_title_text)));
        this.kCW.setVisibility(8);
    }

    public void Et(String str) {
        b(NoDataViewFactory.d.m31do(str, this.kCx.getPageContext().getString(R.string.refresh_view_title_text)));
        this.kCW.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.frv.setVisibility(0);
            this.kCW.setVisibility(0);
            this.kCv.setOnTouchListener(null);
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
            if (this.kBe != null && this.kBe.aTN() != null && this.kBe.aTN().aWl() != null && postData.aWl() != null) {
                String userId3 = this.kBe.aTN().aWl().getUserId();
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
                    int i2 = postData.dli() != 1 ? 0 : 1;
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
                        if (this.kBe.aTN() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.kBe.aTN().getId());
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
            if (postData.dli() != 1) {
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
        if (this.kBW != null && this.kBW.cOK() != null) {
            if (z) {
                this.kBW.cOK().setText(R.string.remove_mark);
            } else {
                this.kBW.cOK().setText(R.string.mark);
            }
        }
    }

    public View cRO() {
        return this.kCP;
    }

    public void onChangeSkinType(int i) {
        ao.setBackgroundColor(this.kCv, R.color.cp_mask_b_alpha66);
        ao.setBackgroundColor(this.kCy, R.color.cp_bg_line_d);
        this.kCx.getLayoutMode().setNightMode(i == 1);
        this.kCx.getLayoutMode().onModeChanged(this.kCv);
        this.kCx.getLayoutMode().onModeChanged(this.kCw);
        this.mNavigationBar.onChangeSkinType(this.kCx.getPageContext(), i);
        if (this.kCz != null) {
            ao.setViewTextColor(this.kCz, R.color.goto_see_subject_color);
        }
        this.eJz.onChangeSkinType(this.kCx.getPageContext(), i);
        this.kCx.getLayoutMode().onModeChanged(this.kCP);
        ao.setViewTextColor(this.kCG, R.color.cp_cont_b);
        this.kCG.setLinkTextColor(ao.getColor(R.color.cp_link_tip_c));
        if (this.jqF != null && this.jqF.biJ() != null) {
            this.jqF.biJ().onChangeSkinType(i);
        }
        this.kCK.changeSkin(i);
        this.aio.changeSkin();
        ao.setViewTextColor(this.hXh, R.color.cp_cont_e);
        ao.setViewTextColor(this.kys, R.color.cp_link_tip_a);
        ao.setViewTextColor(this.dKI, R.color.cp_cont_c);
        this.hXh.setAlpha(0.95f);
        if (this.kCL != null) {
            com.baidu.tbadk.r.a.a(this.kCx.getPageContext(), this.kCL);
        }
        if (this.kDb != null) {
            this.kDb.notifyDataSetChanged();
        }
        this.kCx.getLayoutMode().onModeChanged(this.kCN);
        ao.setBackgroundResource(this.kvK, R.drawable.bottom_shadow);
        this.kvN.setBorderColor(ao.getColor(R.color.cp_border_a));
        this.kvM.setBackgroundDrawable(ao.aH(l.getDimens(this.kCx, R.dimen.tbds47), ao.getColor(R.color.cp_bg_line_j)));
    }

    public void cRP() {
        this.mProgress.setVisibility(0);
    }

    public void cRQ() {
        this.frv.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kCK.endLoadData();
    }

    public void bYv() {
        this.frv.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.kCK.bYv();
    }

    public boolean cRR() {
        return this.kCv.cRR();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kDb.c(onLongClickListener);
    }

    public View cRS() {
        return this.kCw;
    }

    public TextView cgo() {
        return this.hXh;
    }

    public ImageView cRT() {
        return this.kCX;
    }

    public ImageView cRU() {
        return this.kCY;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void Cn(int i) {
    }

    public View cRV() {
        return this.kCz;
    }

    public View cRW() {
        return this.kCH;
    }

    public MorePopupWindow cRX() {
        return this.kCM;
    }

    public void showLoadingDialog() {
        if (this.hdc == null) {
            this.hdc = new com.baidu.tbadk.core.view.a(this.kCx.getPageContext());
        }
        this.hdc.setDialogVisiable(true);
    }

    public void bMt() {
        if (this.hdc != null) {
            this.hdc.setDialogVisiable(false);
        }
    }

    public TextView cRY() {
        return this.kCG;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kDb.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.kDb != null) {
            this.kDb.notifyDataSetChanged();
        }
    }

    public ah cRZ() {
        return this.kBW;
    }

    public void ciz() {
    }

    public void ciA() {
    }

    public void cgL() {
        this.kCv.onDestroy();
    }

    public void cSa() {
        if (this.kCx.isPaused()) {
        }
    }

    public View cSb() {
        return this.kCA;
    }

    private SpannableStringBuilder dp(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.kCx.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
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
        if (this.jqF == null || this.jqF.biJ() == null) {
            return 0;
        }
        return this.jqF.biJ().getHeight();
    }

    public int cSd() {
        if (this.kCQ == null) {
            return 0;
        }
        return this.kCQ.getHeight();
    }

    public void cSe() {
        if (this.hXh != null && this.jqF != null) {
            if (this.jqF.bjR()) {
                this.hXh.setText(R.string.draft_to_send);
            } else {
                this.hXh.setText(this.kCx.cPC());
            }
        }
    }

    public void sz(boolean z) {
        if (this.kvN != null) {
            this.kvN.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }
}
