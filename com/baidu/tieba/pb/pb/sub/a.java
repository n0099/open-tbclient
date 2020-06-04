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
import com.baidu.tbadk.core.data.ak;
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
import com.baidu.tieba.pb.data.n;
import com.baidu.tieba.pb.pb.main.ad;
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
    private static final int jZH = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener aIH;
    private BdTypeListView fbb;
    private com.baidu.tbadk.core.view.a gKA;
    private TextView hDY;
    private e hRk;
    private View hdc;
    private NoNetworkView hji;
    private n jYm;
    private SubPbView jZI;
    private LinearLayout jZJ;
    private View jZK;
    private NewSubPbActivity jZL;
    private RelativeLayout jZM;
    private View jZQ;
    private ThreadSkinView jZX;
    private d jZY;
    private View jZZ;
    private SubPbModel jZl;
    private ad jZo;
    private View kab;
    private View kad;
    private BlankView kae;
    private com.baidu.tbadk.core.dialog.b kag;
    private ArrayList<PostData> kaj;
    private RelativeLayout kak;
    private ImageView kal;
    private ImageView kam;
    private c kap;
    private ProgressBar mProgress;
    private NoDataView mNoDataView = null;
    private View.OnClickListener dyx = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView jZN = null;
    private LinearLayout jZO = null;
    private HeadImageView jZP = null;
    private ClickableHeaderImageView jVJ = null;
    private TextView dXU = null;
    private ImageView jZR = null;
    private TextView jVC = null;
    private TextView jZS = null;
    private TextView jZT = null;
    private EllipsizeRichTextView jZU = null;
    private TbImageView jZV = null;
    private PlayVoiceBntNew ahm = null;
    private TextView jZW = null;
    private MorePopupWindow kaa = null;
    private com.baidu.tbadk.core.dialog.b kac = null;
    private Dialog kaf = null;
    private com.baidu.tbadk.core.dialog.a jSG = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a kah = null;
    private NewSubPbActivity.a kai = null;
    private h iQN = null;
    private int eDC = 0;
    private int kan = 2;
    private int kao = 0;
    private boolean elr = true;
    private com.baidu.tieba.pb.a.c efF = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.nv(false);
            a.this.nv(true);
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
    protected AdapterView.OnItemLongClickListener kaq = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.kaj, i);
            if (view != null && view.getTag() != null) {
                if (a.this.jZo == null) {
                    a.this.jZo = new ad(a.this.jZL.getPageContext(), a.this.aIH);
                }
                a.this.jZo.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.ru(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.jZo.a(sparseArray, a.this.jZl.cCN(), z);
                if (z) {
                    a.this.jZo.cGK().setVisibility(0);
                    a.this.jZo.cGK().setTag(postData.getId());
                } else {
                    a.this.jZo.cGK().setVisibility(8);
                }
                a.this.jZo.cGI().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener kar = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.jZL != null && bc.checkUpIsLogin(a.this.jZL.getPageContext().getPageActivity())) {
                if ((a.this.jZL.iQC == null || a.this.jZl == null || a.this.jZl.bUc() == null || a.this.jZL.iQC.lb(a.this.jZl.bUc().replyPrivateFlag)) && a.this.jZl != null && a.this.iQN != null) {
                    a.this.cJE();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cJG();
                        a.this.jZl.cKf();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.iQN.setReplyId(str2);
                            a.this.iQN.yq(str);
                        }
                    }
                    a.this.cJF();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.jZI = null;
        this.jZK = null;
        this.fbb = null;
        this.jZL = null;
        this.hji = null;
        this.jZM = null;
        this.jZQ = null;
        this.jZY = null;
        this.kad = null;
        this.aIH = null;
        this.mProgress = null;
        this.hDY = null;
        this.kak = null;
        this.kal = null;
        this.kam = null;
        this.jZL = newSubPbActivity;
        this.aIH = onClickListener;
        this.jZI = (SubPbView) LayoutInflater.from(this.jZL.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.jZK = LayoutInflater.from(this.jZL.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.jZJ = (LinearLayout) this.jZI.findViewById(R.id.navigation_bar_group);
        this.kak = (RelativeLayout) this.jZI.findViewById(R.id.subpb_editor_tool_comment);
        this.hDY = (TextView) this.jZI.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.hDY.setOnClickListener(this.aIH);
        this.kal = (ImageView) this.jZI.findViewById(R.id.subpb_editor_tool_more_img);
        this.kam = (ImageView) this.jZI.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.kam.setOnClickListener(this.aIH);
        this.kal.setOnClickListener(this.aIH);
        this.hji = (NoNetworkView) this.jZI.findViewById(R.id.view_no_network);
        bZx();
        bvq();
        this.jZM = (RelativeLayout) this.jZI.findViewById(R.id.sub_pb_body_layout);
        this.fbb = (BdTypeListView) this.jZI.findViewById(R.id.new_sub_pb_list);
        this.jZX = (ThreadSkinView) LayoutInflater.from(this.jZL.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.fbb.addHeaderView(this.jZX);
        this.fbb.addHeaderView(this.jZK);
        this.hdc = new TextView(newSubPbActivity.getActivity());
        this.hdc.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.fbb.addHeaderView(this.hdc, 0);
        this.jZI.setTopView(this.hdc);
        this.jZI.setNavigationView(this.jZJ);
        this.jZI.setListView(this.fbb);
        this.jZI.setContentView(this.jZM);
        this.jZY = new d(this.jZL.getPageContext());
        this.jZY.setLineGone();
        this.kad = this.jZY.getView();
        this.fbb.setNextPage(this.jZY);
        this.jZY.setOnClickListener(this.aIH);
        this.fbb.setOnItemClickListener(this.kar);
        this.fbb.setOnItemLongClickListener(this.kaq);
        this.fbb.setOnTouchListener(this.efF);
        this.mProgress = (ProgressBar) this.jZI.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.jZK != null) {
            this.jZK.setVisibility(4);
        }
        this.jZQ = com.baidu.tbadk.ala.b.aMC().p(this.jZL.getActivity(), 4);
        if (this.jZQ != null) {
            this.jZQ.setVisibility(8);
            this.jZO.addView(this.jZQ, 3);
        }
        this.kap = new c(this.jZL, this.fbb);
        this.kap.setFromCDN(this.mIsFromCDN);
        this.kap.y(this.aIH);
        this.kap.CY();
    }

    public ListView getListView() {
        return this.fbb;
    }

    public void bvq() {
        this.jZO = (LinearLayout) this.jZK.findViewById(R.id.subpb_head_user_info_root);
        this.jZO.setOnClickListener(this.aIH);
        this.jZP = (HeadImageView) this.jZK.findViewById(R.id.photo);
        this.jZP.setRadius(l.getDimens(this.jZL.getActivity(), R.dimen.ds30));
        this.jZP.setClickable(false);
        this.jVJ = (ClickableHeaderImageView) this.jZK.findViewById(R.id.god_user_photo);
        this.jVJ.setGodIconMargin(0);
        this.jVJ.setGodIconWidth(R.dimen.ds24);
        this.jVJ.setRadius(l.getDimens(this.jZL.getActivity(), R.dimen.ds30));
        this.jVJ.setClickable(false);
        this.dXU = (TextView) this.jZK.findViewById(R.id.user_name);
        this.jZR = (ImageView) this.jZK.findViewById(R.id.user_rank);
        this.jZR.setVisibility(8);
        this.jVC = (TextView) this.jZK.findViewById(R.id.floor_owner);
        this.jZN = (TextView) this.jZK.findViewById(R.id.see_subject);
        this.jZN.setOnClickListener(this.aIH);
        this.jZS = (TextView) this.jZK.findViewById(R.id.floor);
        this.jZT = (TextView) this.jZK.findViewById(R.id.time);
        this.jZU = (EllipsizeRichTextView) this.jZK.findViewById(R.id.content_text);
        this.jZU.setOnClickListener(this.aIH);
        am.setViewTextColor(this.jZU, (int) R.color.cp_cont_b);
        this.jZU.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.jZU.setLineSpacing(0.0f, 1.25f);
        this.jZV = (TbImageView) this.jZK.findViewById(R.id.sub_pb_image);
        this.jZV.setOnClickListener(this.aIH);
        this.jZW = (TextView) this.jZK.findViewById(R.id.advert);
        this.ahm = (PlayVoiceBntNew) this.jZK.findViewById(R.id.voice_btn);
        this.jZK.setOnTouchListener(this.efF);
        this.jZK.setOnClickListener(this.aIH);
    }

    public void a(b.a aVar, boolean z) {
        if (this.kag != null) {
            this.kag.dismiss();
            this.kag = null;
        }
        this.kag = new com.baidu.tbadk.core.dialog.b(this.jZL.getPageContext().getPageActivity());
        if (z) {
            this.kag.a(new String[]{this.jZL.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.kag.a(new String[]{this.jZL.getPageContext().getString(R.string.save_to_emotion), this.jZL.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.kag.d(this.jZL.getPageContext());
        this.kag.aSU();
    }

    public void cN(View view) {
        this.jZZ = view;
    }

    public void bZx() {
        int dimens = l.getDimens(this.jZL.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.jZL.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.jZI.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.kae != null) {
                    a.this.jZI.onFinish();
                } else {
                    a.this.jZL.finish();
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
        if (this.kaf == null) {
            this.kaf = new Dialog(this.jZL.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.kaf.setCanceledOnTouchOutside(true);
            this.kaf.setCancelable(true);
            this.kab = LayoutInflater.from(this.jZL.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.jZL.getLayoutMode().onModeChanged(this.kab);
            this.kaf.setContentView(this.kab);
            WindowManager.LayoutParams attributes = this.kaf.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.jZL.getPageContext().getPageActivity()) * 0.9d);
            this.kaf.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.kaf.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.kaf.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.kaf.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.kaf != null && (a.this.kaf instanceof Dialog)) {
                        g.b(a.this.kaf, a.this.jZL.getPageContext());
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
                    if (a.this.kaf != null && (a.this.kaf instanceof Dialog)) {
                        g.b(a.this.kaf, a.this.jZL.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.kah != null) {
                        a.this.kah.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.kaf != null && (a.this.kaf instanceof Dialog)) {
                        g.b(a.this.kaf, a.this.jZL.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.jZL.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.kaf, this.jZL.getPageContext());
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
        this.jSG = new com.baidu.tbadk.core.dialog.a(this.jZL.getPageContext().getPageActivity());
        this.jSG.kF(i3);
        this.jSG.setYesButtonTag(sparseArray);
        this.jSG.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.kai != null) {
                    a.this.kai.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.jSG.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.jSG.gW(true);
        this.jSG.b(this.jZL.getPageContext());
        if (z) {
            this.jSG.aST();
        } else {
            e(sparseArray);
        }
    }

    private void e(final SparseArray<Object> sparseArray) {
        AntiData bUc;
        if (this.jZL != null && sparseArray != null && this.jZK != null) {
            if (this.hRk == null) {
                this.hRk = new e(this.jZL.getPageContext(), this.jZK);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.jZl != null && (bUc = this.jZl.bUc()) != null && bUc.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bUc.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            ak akVar = new ak();
            akVar.setFeedBackReasonMap(sparseArray2);
            this.hRk.setDefaultReasonArray(new String[]{this.jZL.getString(R.string.delete_thread_reason_1), this.jZL.getString(R.string.delete_thread_reason_2), this.jZL.getString(R.string.delete_thread_reason_3), this.jZL.getString(R.string.delete_thread_reason_4), this.jZL.getString(R.string.delete_thread_reason_5)});
            this.hRk.setData(akVar);
            this.hRk.zj("4");
            this.hRk.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.kai != null) {
                        a.this.kai.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nv(final boolean z) {
        if (this.fbb != null) {
            if (!z) {
                this.fbb.setEnabled(z);
            } else {
                this.fbb.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.fbb.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.kah = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.kai = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.jZL.showToast(this.jZL.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.jZL.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.bcX() != null) {
            this.iQN = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.jZM.addView(hVar.bcX(), layoutParams);
            this.iQN.a(new w.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    a.this.cJZ();
                }
            });
        }
    }

    public void cJE() {
        if (this.fbb != null) {
            this.kao = this.fbb.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ru(boolean z) {
        if (this.jZl == null || this.jZl.cKc() == null) {
            return false;
        }
        if (this.jZl.cCN() != 0) {
            return false;
        }
        return (this.jYm == null || this.jYm.aOi() == null || this.jYm.aOi().aQx() == null || !TextUtils.equals(this.jYm.aOi().aQx().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cJF() {
        if (this.jZl != null) {
            if ((!cJI() && this.kad != null && this.kad.isShown()) || v.isEmpty(this.kaj)) {
                this.jZl.sv(false);
            } else {
                this.jZl.sv(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.jZl = subPbModel;
    }

    public void ss(boolean z) {
        if (this.jZl != null && this.jZl.cJC() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.kae = new BlankView(this.jZL.getPageContext().getPageActivity());
            this.jZJ.addView(this.kae, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.kae.setVisibility(0);
            this.kae.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.jZL.finish();
                }
            });
            this.jZI.setBlankView(this.kae);
        }
    }

    public void cJG() {
        b(this.jZL);
        this.fbb.setNextPage(this.jZY);
    }

    public void u(PostData postData) {
        int i;
        if (postData != null) {
            postData.ut(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cJI() && this.kad != null && this.kad.isShown()) {
                i = (this.kao - this.kan) - 1;
            } else {
                i = this.kao - this.kan;
            }
            int count = v.getCount(this.kaj);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(v.subList(this.kaj, 0, i));
            v.add(arrayList, postData2);
            v.add(arrayList, postData);
            this.fbb.smoothScrollToPosition(this.kao + 2);
            this.fbb.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.fbb.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.fbb.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.jZI;
    }

    public void cIk() {
        if (this.kaa != null) {
            g.dismissPopupWindow(this.kaa, this.jZL.getPageContext().getPageActivity());
        }
        if (this.kac != null) {
            this.kac.dismiss();
        }
        if (this.jSG != null) {
            this.jSG.dismiss();
        }
        if (this.kaf != null) {
            g.b(this.kaf, this.jZL.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.jZo != null) {
            this.jZo.dismiss();
        }
    }

    public void cJH() {
        this.fbb.setNextPage(this.jZY);
        this.jZY.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.elr = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v37, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(n nVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (nVar != null) {
            if (this.elr && this.jZK != null) {
                this.jZK.setVisibility(8);
                this.fbb.removeHeaderView(this.jZK);
                this.kan = 1;
            }
            this.jYm = nVar;
            if (this.jYm.cDs() != null) {
                this.jYm.cDs().lmS = true;
            }
            if (this.jZK != null) {
                this.jZK.setVisibility(0);
            }
            if (nVar.aOi() != null && nVar.aOi().aSx()) {
                this.jZN.setText(R.string.view_original);
            } else {
                this.jZN.setText(R.string.view_subject);
            }
            if (nVar.cDs() != null) {
                this.eDC = nVar.cDs().ddJ();
                if (this.eDC > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.jZL.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.eDC)));
                    if (this.jZL != null) {
                        this.hDY.setText(this.jZL.cHy());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.jZL.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.jZL.cJC() ? "PB" : null;
                if (nVar.cDs().aQU() != null) {
                    this.jZX.setData(this.jZL.getPageContext(), nVar.cDs().aQU(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", nVar.bdQ().getId(), nVar.bdQ().getName(), nVar.aOi().getId(), str));
                } else {
                    this.jZX.setData(null, null, null);
                }
            }
            if (nVar.hasMore()) {
                this.jZY.startLoadData();
                this.kap.setHasMoreData(true);
            } else {
                this.jZY.endLoadData();
                this.kap.setHasMoreData(false);
            }
            this.kaj = nVar.cDw();
            if (this.kaj == null || this.kaj.size() <= jZH) {
                i2 = 0;
                i3 = 0;
                i4 = 0;
            } else {
                int size = this.kaj.size() - jZH;
                AK(size);
                int firstVisiblePosition = this.fbb.getFirstVisiblePosition() - size;
                View childAt = this.fbb.getChildAt(0);
                i2 = childAt == null ? 0 : childAt.getTop();
                i3 = firstVisiblePosition;
                i4 = size;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.kaj);
            if (v.isEmpty(this.kaj)) {
                this.fbb.setNextPage(null);
                if (this.elr) {
                    arrayList.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.fbb.setNextPage(this.jZY);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(nVar.getTotalCount());
            arrayList.add(0, bVar);
            if (this.elr) {
                arrayList.add(0, nVar.cDs());
            }
            this.kap.b(this.jYm.aOi(), arrayList);
            a(nVar, nVar.cDs(), nVar.coT(), nVar.aML(), i, z);
            if (i4 > 0) {
                this.fbb.setSelectionFromTop(i3, i2);
            }
        }
    }

    private void AK(int i) {
        if (this.kaj != null) {
            if (this.kaj.size() <= i) {
                this.kaj.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.kaj.iterator();
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

    public boolean cJI() {
        return this.kap.anV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(n nVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.elr) {
            if (!StringUtils.isNull(postData.ddQ())) {
                this.jZV.setVisibility(0);
                this.jZV.startLoad(postData.ddQ(), 10, true);
            } else {
                this.jZV.setVisibility(8);
            }
            i ddS = postData.ddS();
            if (ddS != null && ddS.llz) {
                this.jZW.setVisibility(0);
            } else {
                this.jZW.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.jZK.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.jZK.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.jZS.setText((CharSequence) null);
            this.dXU.setText((CharSequence) null);
            this.jVC.setVisibility(8);
            if (!this.elr) {
                c(postData.aQx());
                if (z) {
                    this.jVC.setVisibility(0);
                    am.setViewTextColor(this.jVC, (int) R.color.cp_link_tip_a);
                }
            }
            this.jZT.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.jZL.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.ddJ()));
            if (nVar.aOi() != null && nVar.aOi().aSx()) {
                this.jZS.setText((CharSequence) null);
            } else {
                this.jZS.setText(format);
            }
            postData.aQx().getUserTbVipInfoData();
            boolean a = a(this.jZU, postData.ddL());
            if (StringUtils.isNull(postData.ddQ()) && !a && postData.biA() != null) {
                this.ahm.setVisibility(0);
                this.ahm.setTag(postData.biA());
                return;
            }
            this.ahm.setVisibility(8);
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
                this.dXU.setText(dk(metaData.getSealPrefix(), str));
            } else {
                this.dXU.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.jZQ != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.jZQ.setVisibility(8);
                } else {
                    this.jZQ.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.dxn = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.jZQ.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.jVJ.setVisibility(0);
                this.jZP.setVisibility(8);
                this.jVJ.setUserId(metaData.getUserId());
                this.jVJ.setUserName(metaData.getUserName());
                this.jVJ.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_r);
            } else {
                this.jVJ.setVisibility(8);
                this.jZP.setVisibility(0);
                this.jZP.setUserId(metaData.getUserId());
                this.jZP.setUserName(metaData.getUserName());
                this.jZP.setDefaultResource(R.drawable.transparent_bg);
                this.jZP.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.jZP.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.dXU, (int) R.color.cp_cont_c);
            }
            this.jZO.setTag(R.id.tag_user_id, metaData.getUserId());
            this.jZO.setTag(R.id.tag_user_name, metaData.getUserName());
            this.jZO.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.bis() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.bis().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.biz());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.iI(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.dmf());
                        continue;
                    case 17:
                        String str = next.biD().mGifInfo.mSharpText;
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
        if (!tbRichTextData.biH()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.biz() == null || tbRichTextData.biz().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.biz());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.jZL.getPageContext().getString(R.string.refresh_view_button_text), this.dyx));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.jZL.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.jZM, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.fbb.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.iQN.bdW();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.jZL.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void xC(int i) {
        b(NoDataViewFactory.d.dj(null, this.jZL.getResources().getString(R.string.refresh_view_title_text)));
        this.kak.setVisibility(8);
    }

    public void Dh(String str) {
        b(NoDataViewFactory.d.dj(str, this.jZL.getPageContext().getString(R.string.refresh_view_title_text)));
        this.kak.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.fbb.setVisibility(0);
            this.kak.setVisibility(0);
            this.jZI.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.dyx = onClickListener;
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
                String userId2 = postData.aQx().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z5 = false;
                }
            }
            if (this.jYm != null && this.jYm.aOi() != null && this.jYm.aOi().aQx() != null && postData.aQx() != null) {
                String userId3 = this.jYm.aOi().aQx().getUserId();
                String userId4 = postData.aQx().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.aQx().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    if (postData.ddJ() == 1) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (!z5) {
                        z4 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
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
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.aQx().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.aQx().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.aQx() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.aQx().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.aQx().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.aQx().getName_show());
                        }
                        if (this.jYm.aOi() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.jYm.aOi().getId());
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
            userId = postData.aQx().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            if (postData.ddJ() == 1) {
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

    public void st(boolean z) {
        if (this.jZo != null && this.jZo.cGI() != null) {
            if (z) {
                this.jZo.cGI().setText(R.string.remove_mark);
            } else {
                this.jZo.cGI().setText(R.string.mark);
            }
        }
    }

    public View cJJ() {
        return this.kad;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.jZI, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.jZM, R.color.cp_bg_line_d);
        this.jZL.getLayoutMode().setNightMode(i == 1);
        this.jZL.getLayoutMode().onModeChanged(this.jZI);
        this.jZL.getLayoutMode().onModeChanged(this.jZK);
        this.mNavigationBar.onChangeSkinType(this.jZL.getPageContext(), i);
        if (this.jZN != null) {
            am.setViewTextColor(this.jZN, (int) R.color.goto_see_subject_color);
        }
        this.hji.onChangeSkinType(this.jZL.getPageContext(), i);
        this.jZL.getLayoutMode().onModeChanged(this.kad);
        am.setViewTextColor(this.jZU, (int) R.color.cp_cont_b);
        this.jZU.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.iQN != null && this.iQN.bcX() != null) {
            this.iQN.bcX().onChangeSkinType(i);
        }
        this.jZY.changeSkin(i);
        this.ahm.crv();
        am.setViewTextColor(this.hDY, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.jVC, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.dXU, (int) R.color.cp_cont_c);
        this.hDY.setAlpha(0.95f);
        if (this.jZZ != null) {
            com.baidu.tbadk.q.a.a(this.jZL.getPageContext(), this.jZZ);
        }
        if (this.kap != null) {
            this.kap.notifyDataSetChanged();
        }
        this.jZL.getLayoutMode().onModeChanged(this.kab);
    }

    public void cJK() {
        this.mProgress.setVisibility(0);
    }

    public void cJL() {
        this.fbb.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jZY.endLoadData();
    }

    public void bSf() {
        this.fbb.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.jZY.bSf();
    }

    public boolean cJM() {
        return this.jZI.cJM();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.kap.c(onLongClickListener);
    }

    public View cJN() {
        return this.jZK;
    }

    public TextView bZC() {
        return this.hDY;
    }

    public ImageView cJO() {
        return this.kal;
    }

    public ImageView cJP() {
        return this.kam;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void AL(int i) {
    }

    public View cJQ() {
        return this.jZN;
    }

    public View cJR() {
        return this.jZV;
    }

    public MorePopupWindow cJS() {
        return this.kaa;
    }

    public void showLoadingDialog() {
        if (this.gKA == null) {
            this.gKA = new com.baidu.tbadk.core.view.a(this.jZL.getPageContext());
        }
        this.gKA.setDialogVisiable(true);
    }

    public void bGh() {
        if (this.gKA != null) {
            this.gKA.setDialogVisiable(false);
        }
    }

    public TextView cJT() {
        return this.jZU;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.kap.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.kap != null) {
            this.kap.notifyDataSetChanged();
        }
    }

    public ad cJU() {
        return this.jZo;
    }

    public void cbH() {
    }

    public void cbI() {
    }

    public void bZX() {
        this.jZI.onDestroy();
    }

    public void cJV() {
        if (this.jZL.isPaused()) {
        }
    }

    public View cJW() {
        return this.jZO;
    }

    private SpannableStringBuilder dk(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new m.a(str, R.drawable.pic_smalldot_title));
            return m.a((Context) this.jZL.getActivity(), str2, (ArrayList<m.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cJX() {
        if (this.iQN == null || this.iQN.bcX() == null) {
            return 0;
        }
        return this.iQN.bcX().getHeight();
    }

    public int cJY() {
        if (this.kae == null) {
            return 0;
        }
        return this.kae.getHeight();
    }

    public void cJZ() {
        if (this.hDY != null && this.iQN != null) {
            if (this.iQN.beb()) {
                this.hDY.setText(R.string.draft_to_send);
            } else {
                this.hDY.setText(this.jZL.cHy());
            }
        }
    }
}
