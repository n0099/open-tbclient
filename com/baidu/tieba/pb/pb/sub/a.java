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
import com.baidu.tieba.pb.data.m;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.z;
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
/* loaded from: classes7.dex */
public class a implements d, KeyboardEventLayout.a {
    private static final int iTx = TbadkCoreApplication.getInst().getListItemRule().getMaxCache();
    private View.OnClickListener ain;
    private BdTypeListView efW;
    private com.baidu.tbadk.core.view.a fNy;
    private TextView gBJ;
    private com.baidu.tieba.NEGFeedBack.e gOh;
    private View gbS;
    private NoNetworkView ghZ;
    private m iSh;
    private View iTA;
    private NewSubPbActivity iTB;
    private RelativeLayout iTC;
    private View iTG;
    private ThreadSkinView iTN;
    private e iTO;
    private View iTP;
    private View iTR;
    private View iTT;
    private BlankView iTU;
    private com.baidu.tbadk.core.dialog.b iTW;
    private ArrayList<PostData> iTZ;
    private SubPbModel iTd;
    private z iTg;
    private SubPbView iTy;
    private LinearLayout iTz;
    private RelativeLayout iUa;
    private ImageView iUb;
    private ImageView iUc;
    private c iUf;
    private ArrayList<com.baidu.adp.widget.ListView.m> iUg;
    private int iUh;
    private boolean iUi;
    private int iUj;
    private int mIndex;
    private ProgressBar mProgress;
    private int mTop;
    private NoDataView mNoDataView = null;
    private View.OnClickListener cGV = null;
    private NavigationBar mNavigationBar = null;
    private View mBack = null;
    private TextView iTD = null;
    private LinearLayout iTE = null;
    private HeadImageView iTF = null;
    private ClickableHeaderImageView iPH = null;
    private TextView bXF = null;
    private ImageView iTH = null;
    private TextView iPA = null;
    private TextView iTI = null;
    private TextView iTJ = null;
    private EllipsizeRichTextView iTK = null;
    private TbImageView iTL = null;
    private PlayVoiceBntNew Nw = null;
    private TextView iTM = null;
    private MorePopupWindow iTQ = null;
    private com.baidu.tbadk.core.dialog.b iTS = null;
    private Dialog iTV = null;
    private com.baidu.tbadk.core.dialog.a iML = null;
    private boolean mIsFromCDN = true;
    private NewSubPbActivity.a iTX = null;
    private NewSubPbActivity.a iTY = null;
    private h hNH = null;
    private int dKh = 0;
    private int iUd = 2;
    private int iUe = 0;
    private boolean dsP = true;
    private com.baidu.tieba.pb.a.c dmA = new com.baidu.tieba.pb.a.c(new c.a() { // from class: com.baidu.tieba.pb.pb.sub.a.6
        @Override // com.baidu.tieba.pb.a.c.a
        public boolean onDoubleTap(View view, MotionEvent motionEvent) {
            a.this.lO(false);
            a.this.lO(true);
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
    protected AdapterView.OnItemLongClickListener iUk = new AdapterView.OnItemLongClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.3
        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            PostData postData = (PostData) v.getItem(a.this.iTZ, i);
            if (view != null && view.getTag() != null) {
                if (a.this.iTg == null) {
                    a.this.iTg = new z(a.this.iTB.getPageContext(), a.this.ain);
                }
                a.this.iTg.showDialog();
                SparseArray<Object> sparseArray = null;
                try {
                    sparseArray = (SparseArray) view.getTag();
                } catch (ClassCastException e) {
                    e.printStackTrace();
                }
                if (sparseArray == null) {
                    return true;
                }
                boolean z = a.this.pI(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false) && TbadkCoreApplication.isLogin();
                a.this.iTg.a(sparseArray, a.this.iTd.cje(), z);
                if (z) {
                    a.this.iTg.cne().setVisibility(0);
                    a.this.iTg.cne().setTag(postData.getId());
                } else {
                    a.this.iTg.cne().setVisibility(8);
                }
                a.this.iTg.cnc().setVisibility(8);
            }
            return false;
        }
    };
    protected AdapterView.OnItemClickListener iUl = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.4
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (a.this.iTB != null && bc.checkUpIsLogin(a.this.iTB.getPageContext().getPageActivity())) {
                if ((a.this.iTB.hNy == null || a.this.iTd == null || a.this.iTd.bBu() == null || a.this.iTB.hNy.kb(a.this.iTd.bBu().replyPrivateFlag)) && a.this.iTd != null && a.this.hNH != null) {
                    a.this.cpX();
                    if (view != null && (view.getTag() instanceof b.a)) {
                        a.this.cpZ();
                        a.this.iTd.cqy();
                        return;
                    }
                    SparseArray sparseArray = (SparseArray) view.getTag();
                    if (sparseArray != null) {
                        String str = (String) sparseArray.get(R.id.tag_photo_username);
                        String str2 = (String) sparseArray.get(R.id.tag_photo_userid);
                        if (str != null) {
                            a.this.hNH.setReplyId(str2);
                            a.this.hNH.vb(str);
                        }
                    }
                    a.this.cpY();
                }
            }
        }
    };

    public a(NewSubPbActivity newSubPbActivity, View.OnClickListener onClickListener) {
        this.iTy = null;
        this.iTA = null;
        this.efW = null;
        this.iTB = null;
        this.ghZ = null;
        this.iTC = null;
        this.iTG = null;
        this.iTO = null;
        this.iTT = null;
        this.ain = null;
        this.mProgress = null;
        this.gBJ = null;
        this.iUa = null;
        this.iUb = null;
        this.iUc = null;
        this.iTB = newSubPbActivity;
        this.ain = onClickListener;
        this.iTy = (SubPbView) LayoutInflater.from(this.iTB.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_layout, (ViewGroup) null);
        this.iTA = LayoutInflater.from(this.iTB.getPageContext().getPageActivity()).inflate(R.layout.new_sub_pb_head, (ViewGroup) null);
        this.iTz = (LinearLayout) this.iTy.findViewById(R.id.navigation_bar_group);
        this.iUa = (RelativeLayout) this.iTy.findViewById(R.id.subpb_editor_tool_comment);
        this.gBJ = (TextView) this.iTy.findViewById(R.id.subpb_editor_tool_comment_reply_text);
        this.gBJ.setOnClickListener(this.ain);
        this.iUb = (ImageView) this.iTy.findViewById(R.id.subpb_editor_tool_more_img);
        this.iUc = (ImageView) this.iTy.findViewById(R.id.subpb_editor_tool_emotion_img);
        this.iUc.setOnClickListener(this.ain);
        this.iUb.setOnClickListener(this.ain);
        this.ghZ = (NoNetworkView) this.iTy.findViewById(R.id.view_no_network);
        bGF();
        bdQ();
        this.iTC = (RelativeLayout) this.iTy.findViewById(R.id.sub_pb_body_layout);
        this.efW = (BdTypeListView) this.iTy.findViewById(R.id.new_sub_pb_list);
        this.iTN = (ThreadSkinView) LayoutInflater.from(this.iTB.getPageContext().getPageActivity()).inflate(R.layout.thread_skin_layout, (ViewGroup) null);
        this.efW.addHeaderView(this.iTN);
        this.efW.addHeaderView(this.iTA);
        this.gbS = new TextView(newSubPbActivity.getActivity());
        this.gbS.setLayoutParams(new AbsListView.LayoutParams(-1, 20));
        this.efW.addHeaderView(this.gbS, 0);
        this.iTy.setTopView(this.gbS);
        this.iTy.setNavigationView(this.iTz);
        this.iTy.setListView(this.efW);
        this.iTy.setContentView(this.iTC);
        this.iTy.setSubPbInitListener(this);
        this.iTO = new e(this.iTB.getPageContext());
        this.iTO.setLineGone();
        this.iTT = this.iTO.getView();
        this.efW.setNextPage(this.iTO);
        this.iTO.setOnClickListener(this.ain);
        this.efW.setOnItemClickListener(this.iUl);
        this.efW.setOnItemLongClickListener(this.iUk);
        this.efW.setOnTouchListener(this.dmA);
        this.mProgress = (ProgressBar) this.iTy.findViewById(R.id.progress);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (this.iTA != null) {
            this.iTA.setVisibility(4);
        }
        this.iTG = com.baidu.tbadk.ala.b.awm().u(this.iTB.getActivity(), 4);
        if (this.iTG != null) {
            this.iTG.setVisibility(8);
            this.iTE.addView(this.iTG, 3);
        }
        this.iUf = new c(this.iTB, this.efW);
        this.iUf.setFromCDN(this.mIsFromCDN);
        this.iUf.x(this.ain);
        this.iUf.vi();
    }

    public ListView getListView() {
        return this.efW;
    }

    public void bdQ() {
        this.iTE = (LinearLayout) this.iTA.findViewById(R.id.subpb_head_user_info_root);
        this.iTE.setOnClickListener(this.ain);
        this.iTF = (HeadImageView) this.iTA.findViewById(R.id.photo);
        this.iTF.setRadius(l.getDimens(this.iTB.getActivity(), R.dimen.ds30));
        this.iTF.setClickable(false);
        this.iPH = (ClickableHeaderImageView) this.iTA.findViewById(R.id.god_user_photo);
        this.iPH.setGodIconMargin(0);
        this.iPH.setGodIconWidth(R.dimen.ds24);
        this.iPH.setRadius(l.getDimens(this.iTB.getActivity(), R.dimen.ds30));
        this.iPH.setClickable(false);
        this.bXF = (TextView) this.iTA.findViewById(R.id.user_name);
        this.iTH = (ImageView) this.iTA.findViewById(R.id.user_rank);
        this.iTH.setVisibility(8);
        this.iPA = (TextView) this.iTA.findViewById(R.id.floor_owner);
        this.iTD = (TextView) this.iTA.findViewById(R.id.see_subject);
        this.iTD.setOnClickListener(this.ain);
        this.iTI = (TextView) this.iTA.findViewById(R.id.floor);
        this.iTJ = (TextView) this.iTA.findViewById(R.id.time);
        this.iTK = (EllipsizeRichTextView) this.iTA.findViewById(R.id.content_text);
        this.iTK.setOnClickListener(this.ain);
        am.setViewTextColor(this.iTK, (int) R.color.cp_cont_b);
        this.iTK.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        this.iTK.setLineSpacing(0.0f, 1.25f);
        this.iTL = (TbImageView) this.iTA.findViewById(R.id.sub_pb_image);
        this.iTL.setOnClickListener(this.ain);
        this.iTM = (TextView) this.iTA.findViewById(R.id.advert);
        this.Nw = (PlayVoiceBntNew) this.iTA.findViewById(R.id.voice_btn);
        this.iTA.setOnTouchListener(this.dmA);
        this.iTA.setOnClickListener(this.ain);
    }

    public void a(b.a aVar, boolean z) {
        if (this.iTW != null) {
            this.iTW.dismiss();
            this.iTW = null;
        }
        this.iTW = new com.baidu.tbadk.core.dialog.b(this.iTB.getPageContext().getPageActivity());
        if (z) {
            this.iTW.a(new String[]{this.iTB.getPageContext().getString(R.string.save_to_emotion)}, aVar);
        } else {
            this.iTW.a(new String[]{this.iTB.getPageContext().getString(R.string.save_to_emotion), this.iTB.getPageContext().getString(R.string.save_to_local)}, aVar);
        }
        this.iTW.d(this.iTB.getPageContext());
        this.iTW.aCq();
    }

    public void cF(View view) {
        this.iTP = view;
    }

    public void bGF() {
        int dimens = l.getDimens(this.iTB.getPageContext().getPageActivity(), R.dimen.ds88);
        int dimens2 = l.getDimens(this.iTB.getPageContext().getPageActivity(), R.dimen.ds2);
        this.mNavigationBar = (NavigationBar) this.iTy.findViewById(R.id.view_navigation_bar);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iTU != null) {
                    a.this.iTy.onFinish();
                } else {
                    a.this.iTB.finish();
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

    public void cB(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        if (this.iTV == null) {
            this.iTV = new Dialog(this.iTB.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.iTV.setCanceledOnTouchOutside(true);
            this.iTV.setCancelable(true);
            this.iTR = LayoutInflater.from(this.iTB.getPageContext().getPageActivity()).inflate(R.layout.forum_manage_dialog, (ViewGroup) null);
            this.iTB.getLayoutMode().onModeChanged(this.iTR);
            this.iTV.setContentView(this.iTR);
            WindowManager.LayoutParams attributes = this.iTV.getWindow().getAttributes();
            attributes.width = (int) (l.getEquipmentWidth(this.iTB.getPageContext().getPageActivity()) * 0.9d);
            this.iTV.getWindow().setAttributes(attributes);
        }
        TextView textView = (TextView) this.iTV.findViewById(R.id.del_post_btn);
        TextView textView2 = (TextView) this.iTV.findViewById(R.id.forbid_user_btn);
        TextView textView3 = (TextView) this.iTV.findViewById(R.id.disable_reply_btn);
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
                    if (a.this.iTV != null && (a.this.iTV instanceof Dialog)) {
                        g.b(a.this.iTV, a.this.iTB.getPageContext());
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
                    if (a.this.iTV != null && (a.this.iTV instanceof Dialog)) {
                        g.b(a.this.iTV, a.this.iTB.getPageContext());
                    }
                    SparseArray sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null && a.this.iTX != null) {
                        a.this.iTX.callback(new Object[]{sparseArray4.get(R.id.tag_manage_user_identity), sparseArray4.get(R.id.tag_forbid_user_name), sparseArray4.get(R.id.tag_forbid_user_post_id), sparseArray4.get(R.id.tag_forbid_user_name_show), sparseArray4.get(R.id.tag_forbid_user_portrait)});
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
                    if (a.this.iTV != null && (a.this.iTV instanceof Dialog)) {
                        g.b(a.this.iTV, a.this.iTB.getPageContext());
                    }
                    SparseArray<Object> sparseArray5 = (SparseArray) view.getTag();
                    if (sparseArray5 != null) {
                        a.this.iTB.a(z, (String) sparseArray5.get(R.id.tag_user_mute_mute_userid), sparseArray5);
                    }
                }
            });
        }
        g.a(this.iTV, this.iTB.getPageContext());
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
        this.iML = new com.baidu.tbadk.core.dialog.a(this.iTB.getPageContext().getPageActivity());
        this.iML.jF(i3);
        this.iML.setYesButtonTag(sparseArray);
        this.iML.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                if (a.this.iTY != null) {
                    a.this.iTY.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type)});
                }
                aVar.dismiss();
            }
        });
        this.iML.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.pb.sub.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.iML.fz(true);
        this.iML.b(this.iTB.getPageContext());
        if (z) {
            this.iML.aCp();
        } else {
            d(sparseArray);
        }
    }

    private void d(final SparseArray<Object> sparseArray) {
        AntiData bBu;
        if (this.iTB != null && sparseArray != null && this.iTA != null) {
            if (this.gOh == null) {
                this.gOh = new com.baidu.tieba.NEGFeedBack.e(this.iTB.getPageContext(), this.iTA);
            }
            SparseArray<String> sparseArray2 = new SparseArray<>();
            if (this.iTd != null && (bBu = this.iTd.bBu()) != null && bBu.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = bBu.getDelThreadInfoList();
                for (int i = 0; i < delThreadInfoList.size(); i++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i).text_info)) {
                        sparseArray2.put(delThreadInfoList.get(i).text_id, delThreadInfoList.get(i).text_info);
                    }
                }
            }
            al alVar = new al();
            alVar.setFeedBackReasonMap(sparseArray2);
            this.gOh.setDefaultReasonArray(new String[]{this.iTB.getString(R.string.delete_thread_reason_1), this.iTB.getString(R.string.delete_thread_reason_2), this.iTB.getString(R.string.delete_thread_reason_3), this.iTB.getString(R.string.delete_thread_reason_4), this.iTB.getString(R.string.delete_thread_reason_5)});
            this.gOh.setData(alVar);
            this.gOh.vS("4");
            this.gOh.a(new e.b() { // from class: com.baidu.tieba.pb.pb.sub.a.12
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void S(JSONArray jSONArray) {
                    String O = aq.O(jSONArray);
                    if (a.this.iTY != null) {
                        a.this.iTY.callback(new Object[]{sparseArray.get(R.id.tag_del_post_id), sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_del_post_is_self), sparseArray.get(R.id.tag_del_post_type), O});
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lO(final boolean z) {
        if (this.efW != null) {
            if (!z) {
                this.efW.setEnabled(z);
            } else {
                this.efW.postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.sub.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.efW.setEnabled(z);
                    }
                }, 10L);
            }
        }
    }

    public void a(NewSubPbActivity.a aVar) {
        this.iTX = aVar;
    }

    public void b(NewSubPbActivity.a aVar) {
        this.iTY = aVar;
    }

    public void a(int i, boolean z, String str, boolean z2) {
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (z && z2) {
            this.iTB.showToast(this.iTB.getResources().getString(R.string.delete_success));
        } else if (str != null && z2) {
            this.iTB.showToast(str);
        }
    }

    public void i(h hVar) {
        if (hVar != null && hVar.aLV() != null) {
            this.hNH = hVar;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            this.iTC.addView(hVar.aLV(), layoutParams);
            this.hNH.a(new v.a() { // from class: com.baidu.tieba.pb.pb.sub.a.2
                @Override // com.baidu.tieba.tbadkCore.v.a
                public void a(WriteData writeData) {
                    a.this.cqs();
                }
            });
        }
    }

    public void cpX() {
        if (this.efW != null) {
            this.iUe = this.efW.getLastVisiblePosition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pI(boolean z) {
        if (this.iTd == null || this.iTd.cqv() == null) {
            return false;
        }
        if (this.iTd.cje() != 0) {
            return false;
        }
        return (this.iSh == null || this.iSh.axQ() == null || this.iSh.axQ().azX() == null || !TextUtils.equals(this.iSh.axQ().azX().getUserId(), TbadkCoreApplication.getCurrentAccount())) && !z;
    }

    public void cpY() {
        if (this.iTd != null) {
            if ((!cqc() && this.iTT != null && this.iTT.isShown()) || com.baidu.tbadk.core.util.v.isEmpty(this.iTZ)) {
                this.iTd.qL(false);
            } else {
                this.iTd.qL(true);
            }
        }
    }

    public void a(SubPbModel subPbModel) {
        this.iTd = subPbModel;
    }

    public void qI(boolean z) {
        if (this.iTd != null && this.iTd.cpV() && !z) {
            this.mNavigationBar.setIsClose(true);
            this.mNavigationBar.setIsCorner(true);
            this.mNavigationBar.isShowBottomLine(true);
            this.mNavigationBar.setBottomLineHeight(3);
            this.mNavigationBar.setStatusBarVisibility(8);
            this.iTU = new BlankView(this.iTB.getPageContext().getPageActivity());
            this.iTz.addView(this.iTU, 0, new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160)));
            this.iTU.setVisibility(0);
            this.iTU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.pb.sub.a.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.iTB.finish();
                }
            });
            this.iTy.setBlankView(this.iTU);
        }
    }

    public void cpZ() {
        b(this.iTB);
        this.efW.setNextPage(this.iTO);
    }

    public void s(PostData postData) {
        int i;
        if (postData != null) {
            postData.sJ(true);
            PostData postData2 = new PostData();
            postData2.setPostType(52);
            if (!cqc() && this.iTT != null && this.iTT.isShown()) {
                i = (this.iUe - this.iUd) - 1;
            } else {
                i = this.iUe - this.iUd;
            }
            int count = com.baidu.tbadk.core.util.v.getCount(this.iTZ);
            if (i > count) {
                i = count;
            }
            ArrayList arrayList = new ArrayList(com.baidu.tbadk.core.util.v.subList(this.iTZ, 0, i));
            com.baidu.tbadk.core.util.v.add(arrayList, postData2);
            com.baidu.tbadk.core.util.v.add(arrayList, postData);
            this.efW.smoothScrollToPosition(this.iUe + 2);
            this.efW.setNextPage(null);
        }
    }

    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.efW.setOnScrollListener(onScrollListener);
    }

    public void b(BdListView.e eVar) {
        this.efW.setOnSrollToBottomListener(eVar);
    }

    public View getRootView() {
        return this.iTy;
    }

    public void coF() {
        if (this.iTQ != null) {
            g.dismissPopupWindow(this.iTQ, this.iTB.getPageContext().getPageActivity());
        }
        if (this.iTS != null) {
            this.iTS.dismiss();
        }
        if (this.iML != null) {
            this.iML.dismiss();
        }
        if (this.iTV != null) {
            g.b(this.iTV, this.iTB.getPageContext());
        }
        if (this.mProgress != null) {
            this.mProgress.setVisibility(8);
        }
        if (this.iTg != null) {
            this.iTg.dismiss();
        }
    }

    public void cqa() {
        this.efW.setNextPage(this.iTO);
        this.iTO.startLoadData();
    }

    public void setIsFromPb(boolean z) {
        this.dsP = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v57, resolved type: com.baidu.tieba.pb.pb.sub.NewSubPbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    public void a(m mVar, int i, boolean z) {
        if (mVar != null) {
            this.iUh = i;
            this.iUi = z;
            if (this.dsP && this.iTA != null) {
                this.iTA.setVisibility(8);
                this.efW.removeHeaderView(this.iTA);
                this.iUd = 1;
            }
            this.iSh = mVar;
            if (this.iTA != null) {
                this.iTA.setVisibility(0);
            }
            if (mVar.axQ() != null && mVar.axQ().aBV()) {
                this.iTD.setText(R.string.view_original);
            } else {
                this.iTD.setText(R.string.view_subject);
            }
            if (mVar.cjF() != null) {
                this.dKh = mVar.cjF().cJz();
                if (this.dKh > 0) {
                    this.mNavigationBar.setCenterTextTitle(String.format(this.iTB.getResources().getString(R.string.subpb_floor_reply), Integer.valueOf(this.dKh)));
                    if (this.iTB != null) {
                        this.gBJ.setText(this.iTB.cnT());
                    }
                } else {
                    this.mNavigationBar.setCenterTextTitle(this.iTB.getResources().getString(R.string.local_floor_reply));
                }
                String str = this.iTB.cpV() ? "PB" : null;
                if (mVar.cjF().aAs() != null) {
                    this.iTN.setData(this.iTB.getPageContext(), mVar.cjF().aAs(), com.baidu.tieba.tbadkCore.d.a.d("PB", "c0132", mVar.aMO().getId(), mVar.aMO().getName(), mVar.axQ().getId(), str));
                } else {
                    this.iTN.setData(null, null, null);
                }
            }
            if (mVar.hasMore()) {
                this.iTO.startLoadData();
                this.iUf.setHasMoreData(true);
            } else {
                this.iTO.endLoadData();
                this.iUf.setHasMoreData(false);
            }
            this.iTZ = mVar.cjJ();
            this.iUj = 0;
            this.mIndex = 0;
            this.mTop = 0;
            if (this.iTZ != null && this.iTZ.size() > iTx) {
                this.iUj = this.iTZ.size() - iTx;
                zi(this.iUj);
                this.mIndex = this.efW.getFirstVisiblePosition() - this.iUj;
                View childAt = this.efW.getChildAt(0);
                this.mTop = childAt == null ? 0 : childAt.getTop();
            }
            this.iUg = new ArrayList<>();
            this.iUg.addAll(this.iTZ);
            if (com.baidu.tbadk.core.util.v.isEmpty(this.iTZ)) {
                this.efW.setNextPage(null);
                if (this.dsP) {
                    this.iUg.add(0, new com.baidu.tieba.pb.pb.sub.b.a());
                }
            } else {
                this.efW.setNextPage(this.iTO);
            }
            com.baidu.tieba.pb.pb.sub.b.b bVar = new com.baidu.tieba.pb.pb.sub.b.b();
            bVar.setReplyNum(mVar.getTotalCount());
            this.iUg.add(0, bVar);
            if (this.dsP) {
                this.iUg.add(0, mVar.cjF());
            }
            if (!this.dsP || this.iTy.cqN()) {
                this.iTy.setSubPbInitListener(null);
                this.iUf.b(this.iSh.axQ(), this.iUg);
                a(this.iSh, this.iSh.cjF(), this.iSh.bVR(), this.iSh.aww(), this.iUh, this.iUi);
                if (this.iUj > 0) {
                    this.efW.setSelectionFromTop(this.mIndex, this.mTop);
                }
            }
        }
    }

    @Override // com.baidu.tieba.pb.pb.sub.d
    public void cqb() {
        if (this.iSh != null && this.iSh.axQ() != null && this.iUg != null) {
            this.iTy.setSubPbInitListener(null);
            this.iUf.b(this.iSh.axQ(), this.iUg);
            a(this.iSh, this.iSh.cjF(), this.iSh.bVR(), this.iSh.aww(), this.iUh, this.iUi);
            if (this.iUj > 0) {
                this.efW.setSelectionFromTop(this.mIndex, this.mTop);
            }
        }
    }

    private void zi(int i) {
        if (this.iTZ != null) {
            if (this.iTZ.size() <= i) {
                this.iTZ.clear();
            }
            int i2 = 0;
            Iterator<PostData> it = this.iTZ.iterator();
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

    public boolean cqc() {
        return this.iUf.ZK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(m mVar, PostData postData, boolean z, boolean z2, int i, boolean z3) {
        if (postData != null && !this.dsP) {
            if (!StringUtils.isNull(postData.cJG())) {
                this.iTL.setVisibility(0);
                this.iTL.startLoad(postData.cJG(), 10, true);
            } else {
                this.iTL.setVisibility(8);
            }
            i cJI = postData.cJI();
            if (cJI != null && cJI.keZ) {
                this.iTM.setVisibility(0);
            } else {
                this.iTM.setVisibility(8);
            }
            SparseArray<Object> sparseArray = (SparseArray) this.iTA.getTag();
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                this.iTA.setTag(sparseArray);
            }
            sparseArray.clear();
            sparseArray.put(R.id.tag_clip_board, postData);
            sparseArray.put(R.id.tag_is_subpb, false);
            a(postData, i, sparseArray);
            this.iTI.setText((CharSequence) null);
            this.bXF.setText((CharSequence) null);
            this.iPA.setVisibility(8);
            if (!this.dsP) {
                c(postData.azX());
                if (z) {
                    this.iPA.setVisibility(0);
                    am.setViewTextColor(this.iPA, (int) R.color.cp_link_tip_a);
                }
            }
            this.iTJ.setText(aq.getFormatTime(postData.getTime()));
            String format = String.format(this.iTB.getPageContext().getString(R.string.is_floor), Integer.valueOf(postData.cJz()));
            if (mVar.axQ() != null && mVar.axQ().aBV()) {
                this.iTI.setText((CharSequence) null);
            } else {
                this.iTI.setText(format);
            }
            postData.azX().getUserTbVipInfoData();
            boolean a = a(this.iTK, postData.cJB());
            if (StringUtils.isNull(postData.cJG()) && !a && postData.aRH() != null) {
                this.Nw.setVisibility(0);
                this.Nw.setTag(postData.aRH());
                return;
            }
            this.Nw.setVisibility(8);
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
                this.bXF.setText(cs(metaData.getSealPrefix(), str));
            } else {
                this.bXF.setText(str);
            }
            if (metaData.getAlaUserData() != null && this.iTG != null) {
                if (metaData.getAlaUserData().anchor_live == 0) {
                    this.iTG.setVisibility(8);
                } else {
                    this.iTG.setVisibility(0);
                    com.baidu.tbadk.ala.a aVar = new com.baidu.tbadk.ala.a();
                    aVar.cFM = metaData.getAlaUserData();
                    aVar.type = 4;
                    this.iTG.setTag(aVar);
                }
            }
            if (metaData.isBigV()) {
                this.iPH.setVisibility(0);
                this.iTF.setVisibility(8);
                this.iPH.setUserId(metaData.getUserId());
                this.iPH.setUserName(metaData.getUserName());
                this.iPH.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.bXF, (int) R.color.cp_cont_r);
            } else {
                this.iPH.setVisibility(8);
                this.iTF.setVisibility(0);
                this.iTF.setUserId(metaData.getUserId());
                this.iTF.setUserName(metaData.getUserName());
                this.iTF.setDefaultResource(R.drawable.transparent_bg);
                this.iTF.setDefaultErrorResource(R.drawable.icon_default_avatar100);
                this.iTF.startLoad(metaData.getAvater(), 28, false);
                am.setViewTextColor(this.bXF, (int) R.color.cp_cont_c);
            }
            this.iTE.setTag(R.id.tag_user_id, metaData.getUserId());
            this.iTE.setTag(R.id.tag_user_name, metaData.getUserName());
            this.iTE.setTag(R.id.tag_virtual_user_url, metaData.getVirtualUserUrl());
        }
    }

    private boolean a(TextView textView, TbRichText tbRichText) {
        if (textView == null || tbRichText == null || tbRichText.aRz() == null) {
            return false;
        }
        TbRichTextData tbRichTextData = new TbRichTextData(1);
        Iterator<TbRichTextData> it = tbRichText.aRz().iterator();
        while (it.hasNext()) {
            TbRichTextData next = it.next();
            if (next != null) {
                switch (next.getType()) {
                    case 1:
                        tbRichTextData.j(next.aRG());
                        continue;
                    case 2:
                    case 18:
                        tbRichTextData.hf(true);
                        textView.setMovementMethod(com.baidu.tieba.view.c.cRX());
                        continue;
                    case 17:
                        String str = next.aRK().mGifInfo.mSharpText;
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
        if (!tbRichTextData.aRP()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        try {
            if (tbRichTextData.aRG() == null || tbRichTextData.aRG().length() <= 0) {
                return false;
            }
            textView.setText(tbRichTextData.aRG());
            return true;
        } catch (Exception e) {
            textView.setText("");
            return false;
        }
    }

    private void b(NoDataViewFactory.d dVar) {
        NoDataViewFactory.b a = NoDataViewFactory.b.a(new NoDataViewFactory.a(this.iTB.getPageContext().getString(R.string.refresh_view_button_text), this.cGV));
        if (this.mNoDataView == null) {
            Activity pageActivity = this.iTB.getPageContext().getPageActivity();
            this.mNoDataView = NoDataViewFactory.a(pageActivity, this.iTC, NoDataViewFactory.c.a(NoDataViewFactory.ImgType.NETERROR, l.getDimens(pageActivity, R.dimen.ds250)), dVar, a);
        }
        this.efW.setVisibility(8);
        this.mProgress.setVisibility(8);
        this.hNH.aMU();
        am.setBackgroundColor(this.mNoDataView, R.color.cp_bg_line_d);
        this.mNoDataView.setClickable(true);
        this.mNoDataView.setTextOption(dVar);
        this.mNoDataView.onChangeSkinType(this.iTB.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        this.mNoDataView.setVisibility(0);
    }

    public void wi(int i) {
        b(NoDataViewFactory.d.cr(null, this.iTB.getResources().getString(R.string.refresh_view_title_text)));
        this.iUa.setVisibility(8);
    }

    public void zw(String str) {
        b(NoDataViewFactory.d.cr(str, this.iTB.getPageContext().getString(R.string.refresh_view_title_text)));
        this.iUa.setVisibility(8);
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
            this.efW.setVisibility(0);
            this.iUa.setVisibility(0);
            this.iTy.setOnTouchListener(null);
        }
    }

    public void f(View.OnClickListener onClickListener) {
        this.cGV = onClickListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0295  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PostData postData, int i, SparseArray<Object> sparseArray) {
        boolean z;
        boolean z2;
        boolean z3;
        String userId;
        boolean z4;
        boolean z5;
        if (postData != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            boolean z6 = false;
            boolean z7 = false;
            if (i != 0) {
                if (i != 3) {
                    z6 = true;
                    z7 = true;
                }
                String userId2 = postData.azX().getUserId();
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z6 = false;
                }
            }
            if (this.iSh != null && this.iSh.axQ() != null && this.iSh.axQ().azX() != null && postData.azX() != null) {
                String userId3 = this.iSh.axQ().azX().getUserId();
                String userId4 = postData.azX().getUserId();
                if (!StringUtils.isNull(userId3) && userId3.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z2 = true;
                    if (StringUtils.isNull(userId4) || !userId4.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z = true;
                        z3 = false;
                    } else {
                        z = false;
                        z3 = true;
                    }
                    userId = postData.azX().getUserId();
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z2 = true;
                        z3 = true;
                    }
                    int i2 = 1;
                    if (postData.cJz() == 1) {
                        i2 = 0;
                    }
                    if (ap.o(postData)) {
                        z4 = z6;
                    } else {
                        z2 = false;
                        z = false;
                        z4 = false;
                    }
                    if (!z4) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                        if (postData.azX() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.azX().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.azX().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.azX().getPortrait());
                        }
                    } else {
                        z5 = false;
                        sparseArray.put(R.id.tag_forbid_user_name, "");
                        sparseArray.put(R.id.tag_forbid_user_name_show, "");
                        sparseArray.put(R.id.tag_forbid_user_portrait, "");
                    }
                    if (!z2) {
                        z5 = true;
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        sparseArray.put(R.id.tag_del_post_is_self, true);
                        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
                        sparseArray.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray.put(R.id.tag_del_post_is_self, false);
                        sparseArray.put(R.id.tag_del_post_type, 0);
                        sparseArray.put(R.id.tag_del_post_id, "");
                    }
                    sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
                    sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
                    if (!z4) {
                        sparseArray.put(R.id.tag_should_manage_visible, true);
                        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i));
                        if (postData.azX() != null) {
                            sparseArray.put(R.id.tag_forbid_user_name, postData.azX().getUserName());
                            sparseArray.put(R.id.tag_forbid_user_name_show, postData.azX().getName_show());
                            sparseArray.put(R.id.tag_forbid_user_portrait, postData.azX().getPortrait());
                        }
                    } else {
                        sparseArray.put(R.id.tag_should_manage_visible, false);
                    }
                    if (!z) {
                        sparseArray.put(R.id.tag_user_mute_visible, true);
                        sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                        if (postData.azX() != null) {
                            sparseArray.put(R.id.tag_user_mute_mute_userid, postData.azX().getUserId());
                            sparseArray.put(R.id.tag_user_mute_mute_username, postData.azX().getUserName());
                            sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.azX().getName_show());
                        }
                        if (this.iSh.axQ() != null) {
                            sparseArray.put(R.id.tag_user_mute_thread_id, this.iSh.axQ().getId());
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
            z2 = z7;
            z3 = false;
            userId = postData.azX().getUserId();
            if (userId != null) {
                z2 = true;
                z3 = true;
            }
            int i22 = 1;
            if (postData.cJz() == 1) {
            }
            if (ap.o(postData)) {
            }
            if (!z4) {
            }
            if (!z2) {
            }
            sparseArray.put(R.id.tag_should_manage_visible, Boolean.valueOf(z5));
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            if (!z4) {
            }
            if (!z) {
            }
            if (!z2) {
            }
        }
    }

    public void qJ(boolean z) {
        if (this.iTg != null && this.iTg.cnc() != null) {
            if (z) {
                this.iTg.cnc().setText(R.string.remove_mark);
            } else {
                this.iTg.cnc().setText(R.string.mark);
            }
        }
    }

    public View cqd() {
        return this.iTT;
    }

    public void onChangeSkinType(int i) {
        am.setBackgroundColor(this.iTy, R.color.cp_mask_b_alpha66);
        am.setBackgroundColor(this.iTC, R.color.cp_bg_line_d);
        this.iTB.getLayoutMode().setNightMode(i == 1);
        this.iTB.getLayoutMode().onModeChanged(this.iTy);
        this.iTB.getLayoutMode().onModeChanged(this.iTA);
        this.mNavigationBar.onChangeSkinType(this.iTB.getPageContext(), i);
        if (this.iTD != null) {
            am.setViewTextColor(this.iTD, (int) R.color.goto_see_subject_color);
        }
        this.ghZ.onChangeSkinType(this.iTB.getPageContext(), i);
        this.iTB.getLayoutMode().onModeChanged(this.iTT);
        am.setViewTextColor(this.iTK, (int) R.color.cp_cont_b);
        this.iTK.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
        if (this.hNH != null && this.hNH.aLV() != null) {
            this.hNH.aLV().onChangeSkinType(i);
        }
        this.iTO.changeSkin(i);
        this.Nw.bFO();
        am.setViewTextColor(this.gBJ, (int) R.color.cp_cont_e);
        am.setViewTextColor(this.iPA, (int) R.color.cp_link_tip_a);
        am.setViewTextColor(this.bXF, (int) R.color.cp_cont_c);
        this.gBJ.setAlpha(0.95f);
        if (this.iTP != null) {
            com.baidu.tbadk.q.a.a(this.iTB.getPageContext(), this.iTP);
        }
        if (this.iUf != null) {
            this.iUf.notifyDataSetChanged();
        }
        this.iTB.getLayoutMode().onModeChanged(this.iTR);
    }

    public void cqe() {
        this.mProgress.setVisibility(0);
    }

    public void cqf() {
        this.efW.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iTO.endLoadData();
    }

    public void bzy() {
        this.efW.setVisibility(0);
        this.mProgress.setVisibility(8);
        this.iTO.bzy();
    }

    public boolean cqg() {
        return this.iTy.cqg();
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.iUf.setLongClickListener(onLongClickListener);
    }

    public View cqh() {
        return this.iTA;
    }

    public TextView bGK() {
        return this.gBJ;
    }

    public ImageView cqi() {
        return this.iUb;
    }

    public ImageView cqj() {
        return this.iUc;
    }

    @Override // com.baidu.tieba.pb.view.KeyboardEventLayout.a
    public void zj(int i) {
    }

    public View cqk() {
        return this.iTD;
    }

    public View cql() {
        return this.iTL;
    }

    public MorePopupWindow cqm() {
        return this.iTQ;
    }

    public void showLoadingDialog() {
        if (this.fNy == null) {
            this.fNy = new com.baidu.tbadk.core.view.a(this.iTB.getPageContext());
        }
        this.fNy.setDialogVisiable(true);
    }

    public void boJ() {
        if (this.fNy != null) {
            this.fNy.setDialogVisiable(false);
        }
    }

    public TextView cqn() {
        return this.iTK;
    }

    public void setOnImageClickListener(TbRichTextView.i iVar) {
        this.iUf.setOnImageClickListener(iVar);
    }

    public void notifyDataSetChanged() {
        if (this.iUf != null) {
            this.iUf.notifyDataSetChanged();
        }
    }

    public z cqo() {
        return this.iTg;
    }

    public void bIL() {
    }

    public void bIM() {
    }

    public void ags() {
        this.iTy.onDestroy();
    }

    public void cqp() {
        if (this.iTB.isPaused()) {
        }
    }

    public View cqq() {
        return this.iTE;
    }

    private SpannableStringBuilder cs(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (str2 != null && str != null) {
            arrayList.add(new l.a(str, R.drawable.pic_smalldot_title));
            return com.baidu.tieba.card.l.a((Context) this.iTB.getActivity(), str2, (ArrayList<l.a>) arrayList, true);
        }
        return spannableStringBuilder;
    }

    public int getNavigationBarHeight() {
        if (this.mNavigationBar == null) {
            return 0;
        }
        return this.mNavigationBar.getHeight();
    }

    public int cqr() {
        if (this.hNH == null || this.hNH.aLV() == null) {
            return 0;
        }
        return this.hNH.aLV().getHeight();
    }

    public void cqs() {
        if (this.gBJ != null && this.hNH != null) {
            if (this.hNH.aMZ()) {
                this.gBJ.setText(R.string.draft_to_send);
            } else {
                this.gBJ.setText(this.iTB.cnT());
            }
        }
    }
}
