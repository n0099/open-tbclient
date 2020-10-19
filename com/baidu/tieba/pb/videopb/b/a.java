package com.baidu.tieba.pb.videopb.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.account.contants.LoginConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.a.d;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.c;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.imageManager.d;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.NEGFeedBack.e;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ak;
import com.baidu.tieba.pb.pb.main.bd;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.e;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
/* loaded from: classes22.dex */
public class a {
    public static int ljK = 3;
    public static int ljL = 0;
    public static int ljM = 3;
    public static int ljN = 4;
    public static int ljO = 5;
    public static int ljP = 6;
    private e eCG;
    private com.baidu.tbadk.core.message.a eCW;
    private bd eii;
    private List<CustomBlueCheckRadioButton> hIb;
    private com.baidu.tieba.NEGFeedBack.e iVq;
    private String kXo;
    public BdUniqueId lbL;
    private com.baidu.adp.widget.ImageView.a lbN;
    private String lbO;
    private TbRichTextMemeInfo lbP;
    private com.baidu.tieba.pb.pb.report.a lbo;
    private i lbv;
    private k lbw;
    private PbFragment.b lkt;
    public VideoPbFragment lvr;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i ljc = null;
    private com.baidu.tbadk.core.dialog.a liU = null;
    private Dialog liV = null;
    private Dialog liW = null;
    private View liX = null;
    private LinearLayout liY = null;
    private TextView liZ = null;
    private TextView lja = null;
    private String ljb = null;
    private ScrollView ljf = null;
    private CompoundButton.OnCheckedChangeListener hIc = null;
    private i liT = null;
    private com.baidu.tbadk.core.view.a hMa = null;
    private com.baidu.tbadk.core.dialog.b laS = null;
    private AlertDialog loW = null;
    private aj loX = null;
    PostData jsr = null;
    private boolean kYN = d.bdC();
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.12
        /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x01f5  */
        @Override // android.view.View.OnLongClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onLongClick(View view) {
            boolean z;
            boolean z2;
            g gVar;
            g gVar2;
            SparseArray sparseArray;
            if (a.this.lvr == null || !a.this.lvr.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.db(view)) {
                    if (view instanceof TbImageView) {
                        a.this.lbN = ((TbImageView) view).getBdImage();
                        a.this.lbO = ((TbImageView) view).getUrl();
                        if (a.this.lbN == null || TextUtils.isEmpty(a.this.lbO)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.lbP = null;
                        } else {
                            a.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.lbN = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.lbO = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.lbP = null;
                            } else {
                                a.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.lbN = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.lbO = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.lbP = null;
                        } else {
                            a.this.lbP = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e2) {
                            e2.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    } else if (!(view.getParent().getParent() instanceof TbRichTextView)) {
                        a.this.a(a.this.lcC, a.this.lbN.isGif());
                    } else {
                        try {
                            sparseArray = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                            sparseArray = sparseArray2;
                        }
                    }
                    if (sparseArray != null) {
                        return true;
                    }
                    sparseArray2 = sparseArray;
                }
                sparseArray = sparseArray2;
                if (sparseArray != null) {
                }
            }
            a.this.jsr = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.jsr == null || a.this.lvr.dlf() == null) {
                return true;
            }
            if (!a.this.lvr.dlf().bec() || a.this.jsr.getId() == null || !a.this.jsr.getId().equals(a.this.lvr.ddQ().bip())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.lvr.ddQ().getPbData() != null && a.this.lvr.ddQ().getPbData().ddd();
            if (a.this.lbw == null) {
                a.this.lbw = new k(a.this.lvr.getContext());
                a.this.lbw.a(a.this.lco);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.db(view) && !z3;
                boolean z5 = (!a.this.db(view) || a.this.lbN == null || a.this.lbN.isGif()) ? false : true;
                boolean z6 = false;
                boolean z7 = false;
                boolean z8 = false;
                boolean z9 = false;
                boolean z10 = false;
                String str = null;
                if (!(sparseArray2.get(R.id.tag_is_subpb) instanceof Boolean)) {
                    z2 = false;
                } else {
                    z2 = ((Boolean) sparseArray2.get(R.id.tag_is_subpb)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_del_post_is_self) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z7 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z8 = ((Boolean) sparseArray2.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z9 = ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z10 = ((Boolean) sparseArray2.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (sparseArray2.get(R.id.tag_forbid_user_post_id) instanceof String) {
                    str = (String) sparseArray2.get(R.id.tag_forbid_user_post_id);
                }
                if (z4) {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.lbw));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.lbw));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.lbw);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.jsr);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.lbw);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.lbw);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.jsr);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.kYN) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.lbw);
                        SparseArray sparseArray5 = new SparseArray();
                        sparseArray5.put(R.id.tag_user_mute_visible, true);
                        sparseArray5.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                        sparseArray5.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                        sparseArray5.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                        sparseArray5.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray5.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                        sparseArray5.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                        sparseArray5.put(R.id.tag_del_post_is_self, sparseArray2.get(R.id.tag_del_post_is_self));
                        sparseArray5.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                        sparseArray5.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                        sparseArray5.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        gVar4.mTextView.setTag(sparseArray5);
                        arrayList.add(gVar4);
                    } else {
                        if ((a.this.tJ(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.lbw);
                            gVar5.mTextView.setTag(str);
                            arrayList.add(gVar5);
                        }
                    }
                    g gVar6 = null;
                    if (z8) {
                        SparseArray sparseArray6 = new SparseArray();
                        sparseArray6.put(R.id.tag_should_manage_visible, true);
                        sparseArray6.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                        sparseArray6.put(R.id.tag_forbid_user_name, sparseArray2.get(R.id.tag_forbid_user_name));
                        sparseArray6.put(R.id.tag_forbid_user_name_show, sparseArray2.get(R.id.tag_forbid_user_name_show));
                        sparseArray6.put(R.id.tag_forbid_user_portrait, sparseArray2.get(R.id.tag_forbid_user_portrait));
                        sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                        if (z9) {
                            sparseArray6.put(R.id.tag_user_mute_visible, true);
                            sparseArray6.put(R.id.tag_is_mem, sparseArray2.get(R.id.tag_is_mem));
                            sparseArray6.put(R.id.tag_user_mute_mute_userid, sparseArray2.get(R.id.tag_user_mute_mute_userid));
                            sparseArray6.put(R.id.tag_user_mute_mute_username, sparseArray2.get(R.id.tag_user_mute_mute_username));
                            sparseArray6.put(R.id.tag_user_mute_mute_nameshow, sparseArray2.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray6.put(R.id.tag_user_mute_post_id, sparseArray2.get(R.id.tag_user_mute_post_id));
                            sparseArray6.put(R.id.tag_user_mute_thread_id, sparseArray2.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray6.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z10) {
                            sparseArray6.put(R.id.tag_should_delete_visible, true);
                            sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray6.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray6.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.lbw);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.lbw);
                        gVar.mTextView.setTag(sparseArray6);
                    } else {
                        if (z10) {
                            SparseArray sparseArray7 = new SparseArray();
                            sparseArray7.put(R.id.tag_should_manage_visible, false);
                            sparseArray7.put(R.id.tag_user_mute_visible, false);
                            sparseArray7.put(R.id.tag_should_delete_visible, true);
                            sparseArray7.put(R.id.tag_manage_user_identity, sparseArray2.get(R.id.tag_manage_user_identity));
                            sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(z6));
                            sparseArray7.put(R.id.tag_del_post_id, sparseArray2.get(R.id.tag_del_post_id));
                            sparseArray7.put(R.id.tag_del_post_type, sparseArray2.get(R.id.tag_del_post_type));
                            if (a.this.lvr.ddQ().getPbData().dcP() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.lbw);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.lbw);
                            }
                            gVar6.mTextView.setTag(sparseArray7);
                        }
                        gVar = null;
                    }
                    if (gVar6 != null) {
                        arrayList.add(gVar6);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                a.this.lbw.ba(arrayList);
                a.this.lbv = new i(a.this.lvr.getPageContext(), a.this.lbw);
                a.this.lbv.Pd();
                TiebaStatic.log(new aq("c13272").dK("tid", a.this.lvr.ddQ().dfO()).dK("fid", a.this.lvr.ddQ().getForumId()).dK("uid", a.this.lvr.ddQ().getPbData().dcA().bih().getUserId()).dK("post_id", a.this.lvr.ddQ().bvH()).aj("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c lco = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lbv != null) {
                a.this.lbv.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.lbN != null && !TextUtils.isEmpty(a.this.lbO)) {
                        if (a.this.lbP == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lbO));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.lbO;
                            aVar.pkgId = a.this.lbP.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lbP.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lbN = null;
                        a.this.lbO = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lbN != null && !TextUtils.isEmpty(a.this.lbO)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.lvr.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lvr.getPageContext().getPageActivity())) {
                            if (a.this.eii == null) {
                                a.this.eii = new bd(a.this.lvr.getPageContext());
                            }
                            a.this.eii.j(a.this.lbO, a.this.lbN.getImageByte());
                            a.this.lbN = null;
                            a.this.lbO = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.jsr != null) {
                        a.this.jsr.fS(a.this.lvr.getPageContext().getPageActivity());
                        a.this.jsr = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").aj("obj_locate", 2));
                    if (a.this.lvr.checkUpIsLogin()) {
                        a.this.da(view);
                        if (a.this.lvr.ddQ().getPbData().dcA() != null && a.this.lvr.ddQ().getPbData().dcA().bih() != null && a.this.lvr.ddQ().getPbData().dcA().bih().getUserId() != null && a.this.lvr.dlf() != null) {
                            int h = a.this.h(a.this.lvr.ddQ().getPbData());
                            bw dcA = a.this.lvr.ddQ().getPbData().dcA();
                            if (dcA.bgP()) {
                                i2 = 2;
                            } else if (dcA.bgQ()) {
                                i2 = 3;
                            } else if (dcA.bkc()) {
                                i2 = 4;
                            } else {
                                i2 = dcA.bkd() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dK("tid", a.this.lvr.ddQ().dfO()).aj("obj_locate", 2).dK("obj_id", a.this.lvr.ddQ().getPbData().dcA().bih().getUserId()).aj("obj_type", a.this.lvr.dlf().bec() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lvr.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.OL((String) tag);
                        return;
                    } else if (tag instanceof SparseArray) {
                        TiebaStatic.log(new aq("c11739").aj("obj_locate", 4));
                        SparseArray<Object> sparseArray2 = (SparseArray) tag;
                        if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                            sparseArray2.put(R.id.tag_from, 0);
                            sparseArray2.put(R.id.tag_check_mute_from, 2);
                            a.this.c(sparseArray2);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 6:
                    SparseArray sparseArray3 = (SparseArray) view.getTag();
                    if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                        a.this.a(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    }
                    return;
                case 7:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lvr.showToast(R.string.network_not_available);
                        return;
                    }
                    SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                    if (sparseArray4 != null) {
                        boolean booleanValue = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue2 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (booleanValue) {
                            if (booleanValue3) {
                                sparseArray4.put(R.id.tag_from, 1);
                                sparseArray4.put(R.id.tag_check_mute_from, 2);
                                a.this.c(sparseArray4);
                                return;
                            }
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            a.this.dg(view);
                            return;
                        } else if (booleanValue2) {
                            a.this.a(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        } else {
                            return;
                        }
                    }
                    return;
                case 8:
                    if (bg.checkUpIsLogin(a.this.lvr.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.bjY() != null) {
                            a.this.d(postData.bjY());
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private final b.InterfaceC0550b lcC = new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lbN != null && !TextUtils.isEmpty(a.this.lbO)) {
                if (i == 0) {
                    if (a.this.lbP == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.lbO));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.lbO;
                        aVar.pkgId = a.this.lbP.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lbP.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.lvr.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lvr.getPageContext().getPageActivity())) {
                        if (a.this.eii == null) {
                            a.this.eii = new bd(a.this.lvr.getPageContext());
                        }
                        a.this.eii.j(a.this.lbO, a.this.lbN.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lbN = null;
                a.this.lbO = null;
            }
        }
    };

    public void deR() {
        f pbData;
        bw dcA;
        boolean z = true;
        if (this.lvr != null && this.lvr.ddQ() != null && this.lvr.ddQ().getPbData() != null && (dcA = (pbData = this.lvr.ddQ().getPbData()).dcA()) != null && dcA.bih() != null) {
            this.lvr.dhz();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dcA.bih().getUserId());
            ak akVar = new ak();
            int dcP = this.lvr.ddQ().getPbData().dcP();
            if (dcP == 1 || dcP == 3) {
                akVar.lgL = true;
                akVar.lgK = true;
                akVar.lgQ = dcA.bic() == 1;
                akVar.lgP = dcA.bid() == 1;
            } else {
                akVar.lgL = false;
                akVar.lgK = false;
            }
            if (dcP == 1002 && !equals) {
                akVar.lgR = true;
            }
            akVar.lgI = tK(equals);
            akVar.lgM = deS();
            akVar.lgJ = tL(equals);
            akVar.Fc = this.lvr.ddQ().dfQ();
            akVar.lgF = true;
            akVar.lgE = tJ(equals);
            akVar.lgO = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.lgN = true;
            akVar.isHostOnly = this.lvr.ddQ().getHostMode();
            akVar.lgH = true;
            if (dcA.biz() == null) {
                akVar.lgG = true;
            } else {
                akVar.lgG = false;
            }
            if (pbData.ddd()) {
                akVar.lgF = false;
                akVar.lgH = false;
                akVar.lgG = false;
                akVar.lgK = false;
                akVar.lgL = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.ddd()) {
                z = false;
            }
            akVar.lgS = z;
            a(akVar);
        }
    }

    private boolean tK(boolean z) {
        boolean z2;
        ab abVar;
        if (this.lvr == null || this.lvr.ddQ() == null || this.lvr.ddQ().getPbData() == null) {
            return false;
        }
        f pbData = this.lvr.ddQ().getPbData();
        bw dcA = pbData.dcA();
        if (dcA != null) {
            if (dcA.bgP() || dcA.bgQ()) {
                return false;
            }
            if (dcA.bkc() || dcA.bkd()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.dcP() != 0) {
                return pbData.dcP() != 3;
            }
            List<bs> dcX = pbData.dcX();
            if (y.getCount(dcX) > 0) {
                for (bs bsVar : dcX) {
                    if (bsVar != null && (abVar = bsVar.eoN) != null && abVar.emw && !abVar.emx && (abVar.type == 1 || abVar.type == 2)) {
                        z2 = true;
                        break;
                    }
                }
            }
            z2 = false;
            return z2;
        }
        return false;
    }

    private boolean tL(boolean z) {
        if (z || this.lvr == null || this.lvr.ddQ() == null || this.lvr.ddQ().getPbData() == null) {
            return false;
        }
        return ((this.lvr.ddQ().getPbData().getForum() != null && this.lvr.ddQ().getPbData().getForum().isBlockBawuDelete) || this.lvr.ddQ().getPbData().dcP() == 0 || this.lvr.ddQ().getPbData().dcP() == 3) ? false : true;
    }

    private boolean deS() {
        if (this.lvr == null || this.lvr.ddQ() == null || !this.lvr.ddQ().dfQ()) {
            return false;
        }
        return this.lvr.ddQ().getPageData() == null || this.lvr.ddQ().getPageData().bgY() != 0;
    }

    public void a(ak akVar) {
        if (!this.lvr.getBaseFragmentActivity().isProgressBarShown()) {
            this.loX = new aj(this.lvr, this.lvr.aEX);
            this.loW = new AlertDialog.Builder(this.lvr.getContext(), R.style.DialogTheme).create();
            this.loW.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.loW, this.lvr.getFragmentActivity());
            Window window = this.loW.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.loX.getView());
            this.loX.tZ(akVar == null ? false : akVar.lgE);
            this.loX.ua(akVar == null ? false : akVar.lgI);
            this.loX.ub(akVar == null ? false : akVar.lgM);
            this.loX.ud(akVar == null ? false : akVar.lgJ);
            this.loX.ue(akVar == null ? true : akVar.lgG);
            if (akVar == null) {
                this.loX.al(false, false);
                this.loX.am(false, false);
            } else {
                this.loX.al(akVar.lgK, akVar.lgQ);
                this.loX.am(akVar.lgL, akVar.lgP);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.lgH;
            boolean z4 = akVar == null ? false : akVar.lgF;
            boolean z5 = akVar == null ? false : akVar.lgO;
            boolean z6 = akVar == null ? false : akVar.lgN;
            this.loX.ak(z3, z2);
            this.loX.an(z4, z);
            this.loX.ao(z6, z5);
            if (akVar != null) {
                this.loX.lgB = akVar.lgR;
                if (akVar.lgR) {
                    this.loX.dhb().setText(R.string.report_text);
                    this.loX.ud(false);
                }
            }
            this.loX.uc(akVar != null ? akVar.lgS : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lvr.ddQ() != null && this.lvr.ddQ().getPbData() != null && this.lvr.ddQ().getPbData().getThreadId() != null && this.lvr.ddQ().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.loX.dhe().setText(R.string.have_called_fans_short);
            }
            djw();
        }
    }

    private void djw() {
        if (this.loX != null) {
            this.loX.dhi();
        }
    }

    public void aVi() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.loW != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.loW, a.this.lvr.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mY().postDelayed(this.runnable, 100L);
    }

    public void djx() {
        if (this.loW != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.loW, this.lvr.getPageContext().getPageActivity());
        }
    }

    public aj djy() {
        return this.loX;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.lvr = videoPbFragment;
        this.lbL = videoPbFragment.getUniqueId();
        this.lbo = new com.baidu.tieba.pb.pb.report.a(this.lvr.getContext());
        this.lbo.w(this.lvr.getUniqueId());
        this.lkt = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.lvr.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.lvr.ddQ().getPbData().getUserData().getUserId());
                String str = "";
                if (objArr.length > 1) {
                    str = String.valueOf(objArr[1]);
                }
                String str2 = "";
                if (objArr.length > 2) {
                    str2 = String.valueOf(objArr[2]);
                }
                String str3 = "";
                if (objArr.length > 3) {
                    str3 = String.valueOf(objArr[3]);
                }
                String str4 = "";
                if (objArr.length > 4) {
                    str4 = String.valueOf(objArr[4]);
                }
                a.this.lvr.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.lvr.getPageContext().getPageActivity(), a.this.lvr.ddQ().getPbData().getForum().getId(), a.this.lvr.ddQ().getPbData().getForum().getName(), a.this.lvr.ddQ().getPbData().dcA().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(View view) {
        SparseArray sparseArray;
        PostData postData;
        try {
            sparseArray = (SparseArray) view.getTag();
        } catch (ClassCastException e) {
            e.printStackTrace();
            sparseArray = null;
        }
        if (sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            n(postData);
        }
    }

    protected void n(PostData postData) {
        PostData I;
        if (postData != null) {
            boolean z = false;
            if (postData.getId() != null && postData.getId().equals(this.lvr.ddQ().bip())) {
                z = true;
            }
            MarkData o = this.lvr.ddQ().o(postData);
            if (this.lvr.ddQ().getPbData() != null && this.lvr.ddQ().getPbData().ddd() && (I = this.lvr.I(this.lvr.ddQ().getPbData())) != null) {
                o = this.lvr.ddQ().o(I);
            }
            if (o != null) {
                this.lvr.dhY();
                if (this.lvr.dlf() != null) {
                    this.lvr.dlf().a(o);
                    if (!z) {
                        this.lvr.dlf().bee();
                    } else {
                        this.lvr.dlf().bed();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.dcA() != null) {
            if (fVar.dcA().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dcA().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dcA().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean tJ(boolean z) {
        if (this.lvr.ddQ() == null || this.lvr.ddQ().getPbData() == null) {
            return false;
        }
        return ((this.lvr.ddQ().getPbData().dcP() != 0) || this.lvr.ddQ().getPbData().dcA() == null || this.lvr.ddQ().getPbData().dcA().bih() == null || TextUtils.equals(this.lvr.ddQ().getPbData().dcA().bih().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void OL(String str) {
        if (this.lvr.ddQ() != null && this.lvr.ddQ().getPbData() != null && this.lvr.ddQ().getPbData().ddd()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lvr.ddQ().dfO(), str);
            bw dcA = this.lvr.ddQ().getPbData().dcA();
            if (dcA.bgP()) {
                format = format + "&channelid=33833";
            } else if (dcA.bkb()) {
                format = format + "&channelid=33842";
            } else if (dcA.bgQ()) {
                format = format + "&channelid=33840";
            }
            OM(format);
            return;
        }
        this.lbo.Pm(str);
    }

    private void OM(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.lvr.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lbv != null && this.lbv.isShowing()) {
                this.lbv.dismiss();
                this.lbv = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.lvr.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lbv != null) {
                            a.this.lbv.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lbL);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lbL);
                            a.this.a(z, userMuteAddAndDelCustomMessage, str, str3, (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        }
                    }
                });
                ArrayList arrayList = new ArrayList();
                int i = -1;
                if (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer) {
                    i = ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue();
                }
                if (i == 1) {
                    arrayList.add(new g(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), kVar));
                }
                if (z) {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), kVar));
                } else {
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), kVar));
                }
                kVar.ba(arrayList);
                this.lbv = new i(this.lvr.getPageContext(), kVar);
                this.lbv.Pd();
            }
        }
    }

    public void dfn() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lvr.getPageContext().getPageActivity());
        aVar.AH(this.lvr.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.lvr.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, memberPayActivityConfig));
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.20
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lvr.getPageContext()).bkJ();
    }

    public void a(int i, String str, int i2, boolean z) {
        a(i, str, i2, z, (String) null);
    }

    public void a(int i, String str, int i2, boolean z, String str2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_del_post_id, str);
        sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i));
        sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i2));
        sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
        sparseArray.put(ljL, Integer.valueOf(ljM));
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
        this.liU = new com.baidu.tbadk.core.dialog.a(this.lvr.getActivity());
        if (StringUtils.isNull(str2)) {
            this.liU.ob(i3);
        } else {
            this.liU.setOnlyMessageShowCenter(false);
            this.liU.AH(str2);
        }
        this.liU.setYesButtonTag(sparseArray);
        this.liU.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.lvr.a(aVar, (JSONArray) null);
            }
        });
        this.liU.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.liU.iz(true);
        this.liU.b(this.lvr.getPageContext());
        if (z) {
            this.liU.bkJ();
        } else {
            a(this.liU, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lvr != null && aVar != null) {
            if (this.iVq == null && this.lvr.getView() != null) {
                this.iVq = new com.baidu.tieba.NEGFeedBack.e(this.lvr.getPageContext(), this.lvr.getView());
            }
            AntiData crF = crF();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (crF != null && crF.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = crF.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.iVq.setDefaultReasonArray(new String[]{this.lvr.getString(R.string.delete_thread_reason_1), this.lvr.getString(R.string.delete_thread_reason_2), this.lvr.getString(R.string.delete_thread_reason_3), this.lvr.getString(R.string.delete_thread_reason_4), this.lvr.getString(R.string.delete_thread_reason_5)});
            this.iVq.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.iVq.En(str);
            this.iVq.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.lvr.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData crF() {
        if (this.lvr.ddQ() == null || this.lvr.ddQ().getPbData() == null) {
            return null;
        }
        return this.lvr.ddQ().getPbData().getAnti();
    }

    public void dg(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.lvr.getContext());
        kVar.setTitleText(this.lvr.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.liT.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.lkt != null) {
                                a.this.lkt.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
                                return;
                            }
                            return;
                        case 2:
                            a.this.a(z, (String) sparseArray2.get(R.id.tag_user_mute_mute_userid), sparseArray2);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
        ArrayList arrayList = new ArrayList();
        int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
        if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
            if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                gVar2 = new g(0, this.lvr.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.lvr.getString(R.string.delete), kVar);
            }
            SparseArray sparseArray2 = new SparseArray();
            sparseArray2.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
            sparseArray2.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
            sparseArray2.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
            sparseArray2.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            gVar2.mTextView.setTag(sparseArray2);
            arrayList.add(gVar2);
        }
        if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
            SparseArray sparseArray3 = new SparseArray();
            sparseArray3.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
            sparseArray3.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
            sparseArray3.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
            sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
            sparseArray3.put(R.id.tag_forbid_user_post_id, sparseArray.get(R.id.tag_forbid_user_post_id));
            g gVar3 = new g(1, this.lvr.getString(R.string.forbidden_person), kVar);
            gVar3.mTextView.setTag(sparseArray3);
            arrayList.add(gVar3);
        }
        if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
            SparseArray sparseArray4 = new SparseArray();
            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
            sparseArray4.put(R.id.tag_user_mute_msg, sparseArray.get(R.id.tag_user_mute_msg));
            if (z) {
                gVar = new g(2, this.lvr.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.lvr.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.ba(arrayList);
        if (this.liT == null) {
            this.liT = new i(this.lvr.getPageContext(), kVar);
        } else {
            this.liT.a(kVar);
        }
        this.liT.Pd();
    }

    public void deK() {
        if (this.laS == null) {
            this.laS = new com.baidu.tbadk.core.dialog.b(this.lvr.getPageContext().getPageActivity());
            this.laS.a(new String[]{this.lvr.getPageContext().getString(R.string.call_phone), this.lvr.getPageContext().getString(R.string.sms_phone), this.lvr.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0550b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.lvr.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.kXo = a.this.kXo.trim();
                        UtilHelper.callPhone(a.this.lvr.getPageContext().getPageActivity(), a.this.kXo);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lvr.ddQ().dfO(), a.this.kXo, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.lvr.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.kXo = a.this.kXo.trim();
                        UtilHelper.smsPhone(a.this.lvr.getPageContext().getPageActivity(), a.this.kXo);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lvr.ddQ().dfO(), a.this.kXo, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.kXo = a.this.kXo.trim();
                        UtilHelper.startBaiDuBar(a.this.lvr.getPageContext().getPageActivity(), a.this.kXo);
                        bVar.dismiss();
                    }
                }
            }).oh(b.a.BOTTOM_TO_TOP).oi(17).d(this.lvr.getPageContext());
        }
    }

    public void dm(final View view) {
        String[] strArr;
        int i = 0;
        if (this.lvr != null && this.lvr.ddQ() != null) {
            final i iVar = new i(this.lvr.getPageContext());
            if (this.lvr.ddQ().getPbData().kUy == null || this.lvr.ddQ().getPbData().kUy.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.lvr.ddQ().getPbData().kUy.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lvr.ddQ().getPbData().kUy.size()) {
                        break;
                    }
                    strArr2[i2] = this.lvr.ddQ().getPbData().kUy.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.lvr.ddQ().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.lvr.ddQ().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.lvr.ddQ().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.lvr.ddQ().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").aj("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).aj("obj_type", i4));
                    if (a.this.lvr.ddQ().getPbData().kUy != null && a.this.lvr.ddQ().getPbData().kUy.size() > i3) {
                        i3 = a.this.lvr.ddQ().getPbData().kUy.get(i3).sort_type.intValue();
                    }
                    boolean Fu = a.this.lvr.ddQ().Fu(i3);
                    view.setTag(Integer.valueOf(a.this.lvr.ddQ().dgh()));
                    if (Fu) {
                        a.this.lvr.setIsLoading(true);
                    }
                }
            });
            iVar.Pd();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lvr.getActivity());
            aVar.AG(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.AH(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iz(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dK("obj_id", metaData.getUserId()).aj("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dK("obj_id", metaData.getUserId()).aj("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.lvr.dlq() != null) {
                        a.this.lvr.dlq().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.lvr.getPageContext().getUniqueId(), a.this.lvr.ddQ().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.lvr.getPageContext()).bkJ();
            TiebaStatic.log(new aq("c12527"));
        }
    }

    public void a(boolean z, String str, SparseArray<Object> sparseArray) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String) {
            str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
        }
        if (sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String) {
            str3 = (String) sparseArray.get(R.id.tag_user_mute_thread_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_post_id) instanceof String) {
            str4 = (String) sparseArray.get(R.id.tag_user_mute_post_id);
        }
        if (sparseArray.get(R.id.tag_user_mute_msg) instanceof String) {
            str5 = (String) sparseArray.get(R.id.tag_user_mute_msg);
        }
        if (sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String) {
            str6 = (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow);
        }
        UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lbL);
        userMuteAddAndDelCustomMessage.setTag(this.lbL);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void Dm(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lvr != null && this.lvr.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lvr.getPageContext().getPageActivity());
            aVar.AH(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lvr.getPageContext()).bkJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lvr.getBaseFragmentActivity());
        if (at.isEmpty(str)) {
            aVar.AH(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.AH(str);
        }
        aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.10
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                a.this.showLoadingDialog();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                aVar2.dismiss();
            }
        });
        aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.11
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.lvr.getPageContext()).bkJ();
    }

    public void showLoadingDialog() {
        if (this.hMa == null) {
            this.hMa = new com.baidu.tbadk.core.view.a(this.lvr.getPageContext());
        }
        this.hMa.setDialogVisiable(true);
    }

    public void cbz() {
        if (this.hMa != null) {
            this.hMa.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.lvr != null && this.lvr.ddQ() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lbw == null) {
                this.lbw = new k(this.lvr.getContext());
                this.lbw.a(this.lco);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.lvr.ddQ().getPbData() != null && this.lvr.ddQ().getPbData().ddd();
            if (sparseArray != null) {
                boolean z3 = false;
                boolean z4 = false;
                boolean z5 = false;
                boolean z6 = false;
                if (!(sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                    z = false;
                } else {
                    z = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z3 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean) {
                    z4 = ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) {
                    z5 = ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue();
                }
                if (sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean) {
                    z6 = ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue();
                }
                if (!(sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String)) {
                    str = null;
                } else {
                    str = (String) sparseArray.get(R.id.tag_forbid_user_post_id);
                }
                if (postData.bjY() != null) {
                    g gVar2 = new g(8, (postData.bjY().hasAgree && postData.bjI() == 5) ? this.lvr.getString(R.string.action_cancel_dislike) : this.lvr.getString(R.string.action_dislike), this.lbw);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.lvr.getString(R.string.mute_option), this.lbw);
                        SparseArray sparseArray3 = new SparseArray();
                        sparseArray3.put(R.id.tag_user_mute_visible, true);
                        sparseArray3.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                        sparseArray3.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                        sparseArray3.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                        sparseArray3.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                        sparseArray3.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                        sparseArray3.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        sparseArray3.put(R.id.tag_del_post_is_self, sparseArray.get(R.id.tag_del_post_is_self));
                        sparseArray3.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                        sparseArray3.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                        sparseArray3.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        gVar3.mTextView.setTag(sparseArray3);
                        arrayList.add(gVar3);
                    } else {
                        if ((tJ(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.lvr.getString(R.string.report_text), this.lbw);
                            gVar4.mTextView.setTag(str);
                            arrayList.add(gVar4);
                        }
                    }
                    g gVar5 = null;
                    if (z4) {
                        SparseArray sparseArray4 = new SparseArray();
                        sparseArray4.put(R.id.tag_should_manage_visible, true);
                        sparseArray4.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                        sparseArray4.put(R.id.tag_forbid_user_name, sparseArray.get(R.id.tag_forbid_user_name));
                        sparseArray4.put(R.id.tag_forbid_user_name_show, sparseArray.get(R.id.tag_forbid_user_name_show));
                        sparseArray4.put(R.id.tag_forbid_user_portrait, sparseArray.get(R.id.tag_forbid_user_portrait));
                        sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                        if (z5) {
                            sparseArray4.put(R.id.tag_user_mute_visible, true);
                            sparseArray4.put(R.id.tag_is_mem, sparseArray.get(R.id.tag_is_mem));
                            sparseArray4.put(R.id.tag_user_mute_mute_userid, sparseArray.get(R.id.tag_user_mute_mute_userid));
                            sparseArray4.put(R.id.tag_user_mute_mute_username, sparseArray.get(R.id.tag_user_mute_mute_username));
                            sparseArray4.put(R.id.tag_user_mute_mute_nameshow, sparseArray.get(R.id.tag_user_mute_mute_nameshow));
                            sparseArray4.put(R.id.tag_user_mute_post_id, sparseArray.get(R.id.tag_user_mute_post_id));
                            sparseArray4.put(R.id.tag_user_mute_thread_id, sparseArray.get(R.id.tag_user_mute_thread_id));
                        } else {
                            sparseArray4.put(R.id.tag_user_mute_visible, false);
                        }
                        if (z6) {
                            sparseArray4.put(R.id.tag_should_delete_visible, true);
                            sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray4.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray4.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            gVar5 = new g(6, this.lvr.getString(R.string.delete), this.lbw);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.lvr.getString(R.string.bar_manager), this.lbw);
                        gVar.mTextView.setTag(sparseArray4);
                    } else {
                        if (z6) {
                            SparseArray sparseArray5 = new SparseArray();
                            sparseArray5.put(R.id.tag_should_manage_visible, false);
                            sparseArray5.put(R.id.tag_user_mute_visible, false);
                            sparseArray5.put(R.id.tag_should_delete_visible, true);
                            sparseArray5.put(R.id.tag_manage_user_identity, sparseArray.get(R.id.tag_manage_user_identity));
                            sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
                            sparseArray5.put(R.id.tag_del_post_id, sparseArray.get(R.id.tag_del_post_id));
                            sparseArray5.put(R.id.tag_del_post_type, sparseArray.get(R.id.tag_del_post_type));
                            if (this.lvr.ddQ().getPbData().dcP() == 1002 && !z) {
                                gVar5 = new g(6, this.lvr.getString(R.string.report_text), this.lbw);
                            } else {
                                gVar5 = new g(6, this.lvr.getString(R.string.delete), this.lbw);
                            }
                            gVar5.mTextView.setTag(sparseArray5);
                        }
                        gVar = null;
                    }
                    if (gVar5 != null) {
                        arrayList.add(gVar5);
                    }
                    if (gVar != null) {
                        arrayList.add(gVar);
                    }
                }
                this.lbw.ba(arrayList);
                this.lbv = new i(this.lvr.getPageContext(), this.lbw);
                this.lbv.Pd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eCW == null) {
                this.eCW = new com.baidu.tbadk.core.message.a();
            }
            if (this.eCG == null) {
                this.eCG = new com.baidu.tieba.tbadkCore.data.e();
                this.eCG.uniqueId = this.lvr.getUniqueId();
            }
            c cVar = new c();
            cVar.ela = 5;
            cVar.elg = 8;
            cVar.elf = 2;
            if (this.lvr != null && this.lvr.ddQ() != null) {
                cVar.ele = this.lvr.ddQ().dgy();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.elh = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.elh = 1;
                        i = 0;
                    }
                }
                this.eCW.a(agreeData, i, this.lvr.getUniqueId(), false);
                this.eCW.a(agreeData, this.eCG);
                if (this.lvr == null && this.lvr.ddQ() != null && this.lvr.ddQ().getPbData() != null) {
                    this.eCW.a(this.lvr.dfv(), cVar, agreeData, this.lvr.ddQ().getPbData().dcA());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.elh = 1;
            }
            i = 0;
            this.eCW.a(agreeData, i, this.lvr.getUniqueId(), false);
            this.eCW.a(agreeData, this.eCG);
            if (this.lvr == null) {
            }
        }
    }

    public void a(final b.InterfaceC0550b interfaceC0550b, boolean z) {
        if (this.ljc != null) {
            this.ljc.dismiss();
            this.ljc = null;
        }
        k kVar = new k(this.lvr.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lvr.ddQ().getPbData() != null && this.lvr.ddQ().getPbData().dcA() != null && !this.lvr.ddQ().getPbData().dcA().isBjh()) {
            arrayList.add(new g(0, this.lvr.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.lvr.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.ba(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.ljc.dismiss();
                interfaceC0550b.a(null, i, view);
            }
        });
        this.ljc = new i(this.lvr.getPageContext(), kVar);
        this.ljc.Pd();
    }

    public void aZ(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.liX == null) {
            this.liX = LayoutInflater.from(this.lvr.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lvr.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.liX);
        if (this.liW == null) {
            this.liW = new Dialog(this.lvr.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.liW.setCanceledOnTouchOutside(true);
            this.liW.setCancelable(true);
            this.ljf = (ScrollView) this.liX.findViewById(R.id.good_scroll);
            this.liW.setContentView(this.liX);
            WindowManager.LayoutParams attributes = this.liW.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.liW.getWindow().setAttributes(attributes);
            this.hIc = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.ljb = (String) compoundButton.getTag();
                        if (a.this.hIb != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.hIb) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.ljb != null && !str.equals(a.this.ljb)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.liY = (LinearLayout) this.liX.findViewById(R.id.good_class_group);
            this.lja = (TextView) this.liX.findViewById(R.id.dialog_button_cancel);
            this.lja.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.liW instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.liW, a.this.lvr.getPageContext());
                    }
                }
            });
            this.liZ = (TextView) this.liX.findViewById(R.id.dialog_button_ok);
            this.liZ.setOnClickListener(this.lvr.dlg());
        }
        this.liY.removeAllViews();
        this.hIb = new ArrayList();
        CustomBlueCheckRadioButton fO = fO("0", this.lvr.getPageContext().getString(R.string.thread_good_class));
        this.hIb.add(fO);
        fO.setChecked(true);
        this.liY.addView(fO);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bgv()) && ajVar.bgw() > 0) {
                    CustomBlueCheckRadioButton fO2 = fO(String.valueOf(ajVar.bgw()), ajVar.bgv());
                    this.hIb.add(fO2);
                    View view = new View(this.lvr.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.liY.addView(view);
                    this.liY.addView(fO2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.ljf.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.lvr.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.lvr.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.lvr.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.ljf.setLayoutParams(layoutParams2);
            this.ljf.removeAllViews();
            if (this.liY != null && this.liY.getParent() == null) {
                this.ljf.addView(this.liY);
            }
        }
        com.baidu.adp.lib.f.g.a(this.liW, this.lvr.getPageContext());
    }

    private CustomBlueCheckRadioButton fO(String str, String str2) {
        Activity pageActivity = this.lvr.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hIc);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean db(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lbL;
        userMuteCheckCustomMessage.setTag(this.lbL);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dit() {
        if (this.liU != null) {
            this.liU.dismiss();
        }
        if (this.liV != null) {
            com.baidu.adp.lib.f.g.b(this.liV, this.lvr.getPageContext());
        }
        if (this.liW != null) {
            com.baidu.adp.lib.f.g.b(this.liW, this.lvr.getPageContext());
        }
        if (this.liT != null) {
            this.liT.dismiss();
        }
    }

    public void dlX() {
        if (this.lbv != null) {
            this.lbv.dismiss();
        }
    }

    public void dis() {
        aVi();
        this.lvr.dhz();
        if (this.lbv != null) {
            this.lbv.dismiss();
        }
        dit();
    }

    public void dir() {
        aVi();
        this.lvr.dhz();
        if (this.lbv != null) {
            this.lbv.dismiss();
        }
        this.lvr.ctd();
        dit();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener dli() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dlY() {
        return this.laS;
    }

    public void setPhoneNumber(String str) {
        this.kXo = str;
    }

    public String dhX() {
        return this.ljb;
    }

    public View dhW() {
        if (this.liX != null) {
            return this.liX.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
