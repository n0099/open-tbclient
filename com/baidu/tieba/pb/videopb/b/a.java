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
    public static int lwn = 3;
    public static int lwo = 0;
    public static int lwp = 3;
    public static int lwq = 4;
    public static int lwr = 5;
    public static int lws = 6;
    private e eLc;
    private com.baidu.tbadk.core.message.a eLs;
    private bd eqG;
    private List<CustomBlueCheckRadioButton> hUy;
    private com.baidu.tieba.NEGFeedBack.e jhM;
    public VideoPbFragment lHP;
    private String ljN;
    private com.baidu.tieba.pb.pb.report.a lnN;
    private i lnU;
    private k lnV;
    public BdUniqueId lom;
    private com.baidu.adp.widget.ImageView.a lop;
    private String loq;
    private TbRichTextMemeInfo lor;
    private PbFragment.b lwW;
    private Object mExtra;
    private PermissionJudgePolicy mPermissionJudgement;
    private Runnable runnable;
    private i lvF = null;
    private com.baidu.tbadk.core.dialog.a lvx = null;
    private Dialog lvy = null;
    private Dialog lvz = null;
    private View lvA = null;
    private LinearLayout lvB = null;
    private TextView lvC = null;
    private TextView lvD = null;
    private String lvE = null;
    private ScrollView lvI = null;
    private CompoundButton.OnCheckedChangeListener hUz = null;
    private i lvw = null;
    private com.baidu.tbadk.core.view.a hYx = null;
    private com.baidu.tbadk.core.dialog.b lnr = null;
    private AlertDialog lBv = null;
    private aj lBw = null;
    PostData jER = null;
    private boolean llm = d.bfv();
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
            if (a.this.lHP == null || !a.this.lHP.isAdded()) {
                return true;
            }
            SparseArray sparseArray2 = null;
            try {
                sparseArray2 = (SparseArray) view.getTag();
            } catch (ClassCastException e) {
                e.printStackTrace();
            }
            if (sparseArray2 == null) {
                if (a.this.df(view)) {
                    if (view instanceof TbImageView) {
                        a.this.lop = ((TbImageView) view).getBdImage();
                        a.this.loq = ((TbImageView) view).getUrl();
                        if (a.this.lop == null || TextUtils.isEmpty(a.this.loq)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.lor = null;
                        } else {
                            a.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        }
                    } else if (view instanceof GifView) {
                        if (((GifView) view).getBdImage() != null) {
                            a.this.lop = ((GifView) view).getBdImage();
                            if (!TextUtils.isEmpty(((GifView) view).getBdImage().getUrl())) {
                                a.this.loq = ((GifView) view).getBdImage().getUrl();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                a.this.lor = null;
                            } else {
                                a.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            }
                        } else {
                            return true;
                        }
                    } else if ((view instanceof TbMemeImageView) && ((TbMemeImageView) view).getBdImage() != null) {
                        a.this.lop = ((TbMemeImageView) view).getBdImage();
                        if (!TextUtils.isEmpty(((TbMemeImageView) view).getBdImage().getUrl())) {
                            a.this.loq = ((TbMemeImageView) view).getBdImage().getUrl();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) == null || !(view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            a.this.lor = null;
                        } else {
                            a.this.lor = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
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
                        a.this.a(a.this.lpf, a.this.lop.isGif());
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
            a.this.jER = (PostData) sparseArray2.get(R.id.tag_clip_board);
            if (a.this.jER == null || a.this.lHP.don() == null) {
                return true;
            }
            if (!a.this.lHP.don().bfV() || a.this.jER.getId() == null || !a.this.jER.getId().equals(a.this.lHP.dgX().bki())) {
                z = false;
            } else {
                z = true;
            }
            boolean z3 = a.this.lHP.dgX().getPbData() != null && a.this.lHP.dgX().getPbData().dgl();
            if (a.this.lnV == null) {
                a.this.lnV = new k(a.this.lHP.getContext());
                a.this.lnV.a(a.this.loR);
            }
            ArrayList arrayList = new ArrayList();
            if (view != null && sparseArray2 != null) {
                boolean z4 = a.this.df(view) && !z3;
                boolean z5 = (!a.this.df(view) || a.this.lop == null || a.this.lop.isGif()) ? false : true;
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
                    arrayList.add(new g(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), a.this.lnV));
                }
                if (z5) {
                    arrayList.add(new g(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), a.this.lnV));
                }
                if (!z4 && !z5) {
                    g gVar3 = new g(3, TbadkCoreApplication.getInst().getString(R.string.copy), a.this.lnV);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_clip_board, a.this.jER);
                    gVar3.mTextView.setTag(sparseArray3);
                    arrayList.add(gVar3);
                }
                if (!z2 && !z3) {
                    if (z) {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), a.this.lnV);
                    } else {
                        gVar2 = new g(4, TbadkCoreApplication.getInst().getString(R.string.mark), a.this.lnV);
                    }
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_clip_board, a.this.jER);
                    sparseArray4.put(R.id.tag_is_subpb, false);
                    gVar2.mTextView.setTag(sparseArray4);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin() && !a.this.llm) {
                    if (!z8 && z7) {
                        g gVar4 = new g(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), a.this.lnV);
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
                        if ((a.this.ua(z6) && TbadkCoreApplication.isLogin()) && !z3) {
                            g gVar5 = new g(5, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.lnV);
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
                            gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.lnV);
                            gVar6.mTextView.setTag(sparseArray6);
                        } else {
                            sparseArray6.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), a.this.lnV);
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
                            if (a.this.lHP.dgX().getPbData().dfX() == 1002 && !z6) {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.report_text), a.this.lnV);
                            } else {
                                gVar6 = new g(6, TbadkCoreApplication.getInst().getString(R.string.delete), a.this.lnV);
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
                a.this.lnV.bk(arrayList);
                a.this.lnU = new i(a.this.lHP.getPageContext(), a.this.lnV);
                a.this.lnU.PJ();
                TiebaStatic.log(new aq("c13272").dR("tid", a.this.lHP.dgX().diV()).dR("fid", a.this.lHP.dgX().getForumId()).dR("uid", a.this.lHP.dgX().getPbData().dfI().bka().getUserId()).dR("post_id", a.this.lHP.dgX().bxA()).aj("obj_source", z2 ? 2 : 1));
            }
            return true;
        }
    };
    private k.c loR = new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.17
        @Override // com.baidu.tbadk.core.dialog.k.c
        public void a(k kVar, int i, View view) {
            SparseArray sparseArray;
            int i2;
            if (a.this.lnU != null) {
                a.this.lnU.dismiss();
            }
            switch (i) {
                case 1:
                    if (a.this.lop != null && !TextUtils.isEmpty(a.this.loq)) {
                        if (a.this.lor == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.loq));
                        } else {
                            d.a aVar = new d.a();
                            aVar.url = a.this.loq;
                            aVar.pkgId = a.this.lor.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lor.memeInfo.pck_id;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                        }
                        a.this.lop = null;
                        a.this.loq = null;
                        return;
                    }
                    return;
                case 2:
                    if (a.this.lop != null && !TextUtils.isEmpty(a.this.loq)) {
                        if (a.this.mPermissionJudgement == null) {
                            a.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        a.this.mPermissionJudgement.clearRequestPermissionList();
                        a.this.mPermissionJudgement.appendRequestPermission(a.this.lHP.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lHP.getPageContext().getPageActivity())) {
                            if (a.this.eqG == null) {
                                a.this.eqG = new bd(a.this.lHP.getPageContext());
                            }
                            a.this.eqG.j(a.this.loq, a.this.lop.getImageByte());
                            a.this.lop = null;
                            a.this.loq = null;
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    if (a.this.jER != null) {
                        a.this.jER.fT(a.this.lHP.getPageContext().getPageActivity());
                        a.this.jER = null;
                        return;
                    }
                    return;
                case 4:
                    TiebaStatic.log(new aq("c11739").aj("obj_locate", 2));
                    if (a.this.lHP.checkUpIsLogin()) {
                        a.this.de(view);
                        if (a.this.lHP.dgX().getPbData().dfI() != null && a.this.lHP.dgX().getPbData().dfI().bka() != null && a.this.lHP.dgX().getPbData().dfI().bka().getUserId() != null && a.this.lHP.don() != null) {
                            int h = a.this.h(a.this.lHP.dgX().getPbData());
                            bw dfI = a.this.lHP.dgX().getPbData().dfI();
                            if (dfI.biI()) {
                                i2 = 2;
                            } else if (dfI.biJ()) {
                                i2 = 3;
                            } else if (dfI.blV()) {
                                i2 = 4;
                            } else {
                                i2 = dfI.blW() ? 5 : 1;
                            }
                            TiebaStatic.log(new aq("c12526").dR("tid", a.this.lHP.dgX().diV()).aj("obj_locate", 2).dR("obj_id", a.this.lHP.dgX().getPbData().dfI().bka().getUserId()).aj("obj_type", a.this.lHP.don().bfV() ? 0 : 1).aj("obj_source", h).aj("obj_param1", i2));
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (!j.isNetWorkAvailable()) {
                        a.this.lHP.showToast(R.string.network_not_available);
                        return;
                    }
                    Object tag = view.getTag();
                    if (tag instanceof String) {
                        TiebaStatic.log(new aq("c13079"));
                        a.this.Pj((String) tag);
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
                        a.this.lHP.showToast(R.string.network_not_available);
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
                            a.this.dk(view);
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
                    if (bg.checkUpIsLogin(a.this.lHP.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                        PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
                        if (postData.blR() != null) {
                            a.this.d(postData.blR());
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
    private final b.InterfaceC0564b lpf = new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.videopb.b.a.21
        @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
        public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
            if (bVar != null) {
                bVar.dismiss();
            }
            if (a.this.lop != null && !TextUtils.isEmpty(a.this.loq)) {
                if (i == 0) {
                    if (a.this.lor == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, a.this.loq));
                    } else {
                        d.a aVar = new d.a();
                        aVar.url = a.this.loq;
                        aVar.pkgId = a.this.lor.memeInfo.pck_id.intValue() < 0 ? "" : "" + a.this.lor.memeInfo.pck_id;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.EMOTION_USER_COLLECT, aVar));
                    }
                } else if (i == 1) {
                    if (a.this.mPermissionJudgement == null) {
                        a.this.mPermissionJudgement = new PermissionJudgePolicy();
                    }
                    a.this.mPermissionJudgement.clearRequestPermissionList();
                    a.this.mPermissionJudgement.appendRequestPermission(a.this.lHP.getPageContext().getPageActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                    if (!a.this.mPermissionJudgement.startRequestPermission(a.this.lHP.getPageContext().getPageActivity())) {
                        if (a.this.eqG == null) {
                            a.this.eqG = new bd(a.this.lHP.getPageContext());
                        }
                        a.this.eqG.j(a.this.loq, a.this.lop.getImageByte());
                    } else {
                        return;
                    }
                }
                a.this.lop = null;
                a.this.loq = null;
            }
        }
    };

    public void dhY() {
        f pbData;
        bw dfI;
        boolean z = true;
        if (this.lHP != null && this.lHP.dgX() != null && this.lHP.dgX().getPbData() != null && (dfI = (pbData = this.lHP.dgX().getPbData()).dfI()) != null && dfI.bka() != null) {
            this.lHP.dkG();
            boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), dfI.bka().getUserId());
            ak akVar = new ak();
            int dfX = this.lHP.dgX().getPbData().dfX();
            if (dfX == 1 || dfX == 3) {
                akVar.ltn = true;
                akVar.ltm = true;
                akVar.ltt = dfI.bjV() == 1;
                akVar.lts = dfI.bjW() == 1;
            } else {
                akVar.ltn = false;
                akVar.ltm = false;
            }
            if (dfX == 1002 && !equals) {
                akVar.ltu = true;
            }
            akVar.ltk = ub(equals);
            akVar.lto = dhZ();
            akVar.ltl = uc(equals);
            akVar.Fc = this.lHP.dgX().diX();
            akVar.lth = true;
            akVar.ltg = ua(equals);
            akVar.ltq = TbadkCoreApplication.getInst().getSkinType() == 1;
            akVar.ltp = true;
            akVar.isHostOnly = this.lHP.dgX().getHostMode();
            akVar.ltj = true;
            if (dfI.bks() == null) {
                akVar.lti = true;
            } else {
                akVar.lti = false;
            }
            if (pbData.dgl()) {
                akVar.lth = false;
                akVar.ltj = false;
                akVar.lti = false;
                akVar.ltm = false;
                akVar.ltn = false;
            }
            if (!TbSingleton.getInstance().mShowCallFans || !equals || pbData.dgl()) {
                z = false;
            }
            akVar.ltv = z;
            a(akVar);
        }
    }

    private boolean ub(boolean z) {
        boolean z2;
        ab abVar;
        if (this.lHP == null || this.lHP.dgX() == null || this.lHP.dgX().getPbData() == null) {
            return false;
        }
        f pbData = this.lHP.dgX().getPbData();
        bw dfI = pbData.dfI();
        if (dfI != null) {
            if (dfI.biI() || dfI.biJ()) {
                return false;
            }
            if (dfI.blV() || dfI.blW()) {
                return z;
            }
        }
        if (z) {
            return true;
        }
        if (pbData.getForum() == null || !pbData.getForum().isBlockBawuDelete) {
            if (pbData.dfX() != 0) {
                return pbData.dfX() != 3;
            }
            List<bs> dgf = pbData.dgf();
            if (y.getCount(dgf) > 0) {
                for (bs bsVar : dgf) {
                    if (bsVar != null && (abVar = bsVar.exk) != null && abVar.euW && !abVar.euX && (abVar.type == 1 || abVar.type == 2)) {
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

    private boolean uc(boolean z) {
        if (z || this.lHP == null || this.lHP.dgX() == null || this.lHP.dgX().getPbData() == null) {
            return false;
        }
        return ((this.lHP.dgX().getPbData().getForum() != null && this.lHP.dgX().getPbData().getForum().isBlockBawuDelete) || this.lHP.dgX().getPbData().dfX() == 0 || this.lHP.dgX().getPbData().dfX() == 3) ? false : true;
    }

    private boolean dhZ() {
        if (this.lHP == null || this.lHP.dgX() == null || !this.lHP.dgX().diX()) {
            return false;
        }
        return this.lHP.dgX().getPageData() == null || this.lHP.dgX().getPageData().biR() != 0;
    }

    public void a(ak akVar) {
        if (!this.lHP.getBaseFragmentActivity().isProgressBarShown()) {
            this.lBw = new aj(this.lHP, this.lHP.aFf);
            this.lBv = new AlertDialog.Builder(this.lHP.getContext(), R.style.DialogTheme).create();
            this.lBv.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.f.g.showDialog(this.lBv, this.lHP.getFragmentActivity());
            Window window = this.lBv.getWindow();
            window.setWindowAnimations(R.style.share_dialog_style);
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setContentView(this.lBw.getView());
            this.lBw.uq(akVar == null ? false : akVar.ltg);
            this.lBw.ur(akVar == null ? false : akVar.ltk);
            this.lBw.us(akVar == null ? false : akVar.lto);
            this.lBw.uu(akVar == null ? false : akVar.ltl);
            this.lBw.uv(akVar == null ? true : akVar.lti);
            if (akVar == null) {
                this.lBw.ao(false, false);
                this.lBw.ap(false, false);
            } else {
                this.lBw.ao(akVar.ltm, akVar.ltt);
                this.lBw.ap(akVar.ltn, akVar.lts);
            }
            boolean z = akVar == null ? false : akVar.Fc;
            boolean z2 = akVar == null ? false : akVar.isHostOnly;
            boolean z3 = akVar == null ? false : akVar.ltj;
            boolean z4 = akVar == null ? false : akVar.lth;
            boolean z5 = akVar == null ? false : akVar.ltq;
            boolean z6 = akVar == null ? false : akVar.ltp;
            this.lBw.an(z3, z2);
            this.lBw.aq(z4, z);
            this.lBw.ar(z6, z5);
            if (akVar != null) {
                this.lBw.ltd = akVar.ltu;
                if (akVar.ltu) {
                    this.lBw.dki().setText(R.string.report_text);
                    this.lBw.uu(false);
                }
            }
            this.lBw.ut(akVar != null ? akVar.ltv : false);
            if (!TbSingleton.getInstance().mCanCallFans && this.lHP.dgX() != null && this.lHP.dgX().getPbData() != null && this.lHP.dgX().getPbData().getThreadId() != null && this.lHP.dgX().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                this.lBw.dkl().setText(R.string.have_called_fans_short);
            }
            dmD();
        }
    }

    private void dmD() {
        if (this.lBw != null) {
            this.lBw.dkp();
        }
    }

    public void aXc() {
        if (this.runnable == null) {
            this.runnable = new Runnable() { // from class: com.baidu.tieba.pb.videopb.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.lBv != null) {
                        com.baidu.adp.lib.f.g.dismissDialog(a.this.lBv, a.this.lHP.getPageContext().getPageActivity());
                    }
                }
            };
        }
        com.baidu.adp.lib.f.e.mY().postDelayed(this.runnable, 100L);
    }

    public void dmE() {
        if (this.lBv != null) {
            com.baidu.adp.lib.f.g.dismissDialog(this.lBv, this.lHP.getPageContext().getPageActivity());
        }
    }

    public aj dmF() {
        return this.lBw;
    }

    public a(VideoPbFragment videoPbFragment) {
        this.lHP = videoPbFragment;
        this.lom = videoPbFragment.getUniqueId();
        this.lnN = new com.baidu.tieba.pb.pb.report.a(this.lHP.getContext());
        this.lnN.w(this.lHP.getUniqueId());
        this.lwW = new PbFragment.b() { // from class: com.baidu.tieba.pb.videopb.b.a.16
            @Override // com.baidu.tieba.pb.pb.main.PbFragment.b
            public void callback(Object obj) {
                if (!j.isNetWorkAvailable()) {
                    a.this.lHP.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                String valueOf = String.valueOf(a.this.lHP.dgX().getPbData().getUserData().getUserId());
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
                a.this.lHP.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(a.this.lHP.getPageContext().getPageActivity(), a.this.lHP.dgX().getPbData().getForum().getId(), a.this.lHP.dgX().getPbData().getForum().getName(), a.this.lHP.dgX().getPbData().dfI().getId(), valueOf, str, str3, str2, str4)));
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(View view) {
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
            if (postData.getId() != null && postData.getId().equals(this.lHP.dgX().bki())) {
                z = true;
            }
            MarkData o = this.lHP.dgX().o(postData);
            if (this.lHP.dgX().getPbData() != null && this.lHP.dgX().getPbData().dgl() && (I = this.lHP.I(this.lHP.dgX().getPbData())) != null) {
                o = this.lHP.dgX().o(I);
            }
            if (o != null) {
                this.lHP.dlf();
                if (this.lHP.don() != null) {
                    this.lHP.don().a(o);
                    if (!z) {
                        this.lHP.don().bfX();
                    } else {
                        this.lHP.don().bfW();
                    }
                }
            }
        }
    }

    public int h(f fVar) {
        if (fVar != null && fVar.dfI() != null) {
            if (fVar.dfI().getThreadType() == 0) {
                return 1;
            }
            if (fVar.dfI().getThreadType() == 54) {
                return 2;
            }
            if (fVar.dfI().getThreadType() == 40) {
                return 3;
            }
            return 4;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ua(boolean z) {
        if (this.lHP.dgX() == null || this.lHP.dgX().getPbData() == null) {
            return false;
        }
        return ((this.lHP.dgX().getPbData().dfX() != 0) || this.lHP.dgX().getPbData().dfI() == null || this.lHP.dgX().getPbData().dfI().bka() == null || TextUtils.equals(this.lHP.dgX().getPbData().dfI().bka().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
    }

    public void Pj(String str) {
        if (this.lHP.dgX() != null && this.lHP.dgX().getPbData() != null && this.lHP.dgX().getPbData().dgl()) {
            String format = String.format(TbConfig.URL_BJH_REPORT, this.lHP.dgX().diV(), str);
            bw dfI = this.lHP.dgX().getPbData().dfI();
            if (dfI.biI()) {
                format = format + "&channelid=33833";
            } else if (dfI.blU()) {
                format = format + "&channelid=33842";
            } else if (dfI.biJ()) {
                format = format + "&channelid=33840";
            }
            Pk(format);
            return;
        }
        this.lnN.PK(str);
    }

    private void Pk(String str) {
        TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.lHP.getContext(), "", str, true);
        tbWebViewActivityConfig.setFixTitle(true);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
    }

    public void a(final boolean z, final SparseArray<Object> sparseArray) {
        if ((sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            if (this.lnU != null && this.lnU.isShowing()) {
                this.lnU.dismiss();
                this.lnU = null;
            }
            final String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            final String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                k kVar = new k(this.lHP.getBaseFragmentActivity());
                kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.18
                    @Override // com.baidu.tbadk.core.dialog.k.c
                    public void a(k kVar2, int i, View view) {
                        if (a.this.lnU != null) {
                            a.this.lnU.dismiss();
                        }
                        if (i == 0) {
                            a.this.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        } else if (i == 1) {
                            String str3 = (String) sparseArray.get(R.id.tag_user_mute_mute_username);
                            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_HANDLE_CLICK);
                            userMuteAddAndDelCustomMessage.setData(z, str2, str3, (String) sparseArray.get(R.id.tag_user_mute_thread_id), (String) sparseArray.get(R.id.tag_user_mute_post_id), 1, str, a.this.lom);
                            userMuteAddAndDelCustomMessage.setTag(a.this.lom);
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
                kVar.bk(arrayList);
                this.lnU = new i(this.lHP.getPageContext(), kVar);
                this.lnU.PJ();
            }
        }
    }

    public void diu() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lHP.getPageContext().getPageActivity());
        aVar.Ba(this.lHP.getResources().getString(R.string.mute_is_super_member_function));
        aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.19
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                TiebaStatic.log("c10025");
                aVar2.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) a.this.lHP.getFragmentActivity(), 2, true, 4);
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
        aVar.b(this.lHP.getPageContext()).bmC();
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
        sparseArray.put(lwo, Integer.valueOf(lwp));
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
        this.lvx = new com.baidu.tbadk.core.dialog.a(this.lHP.getActivity());
        if (StringUtils.isNull(str2)) {
            this.lvx.om(i3);
        } else {
            this.lvx.setOnlyMessageShowCenter(false);
            this.lvx.Ba(str2);
        }
        this.lvx.setYesButtonTag(sparseArray);
        this.lvx.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.22
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                a.this.lHP.a(aVar, (JSONArray) null);
            }
        });
        this.lvx.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.2
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                aVar.dismiss();
            }
        });
        this.lvx.iM(true);
        this.lvx.b(this.lHP.getPageContext());
        if (z) {
            this.lvx.bmC();
        } else {
            a(this.lvx, i);
        }
    }

    private void a(final com.baidu.tbadk.core.dialog.a aVar, int i) {
        String str;
        if (this.lHP != null && aVar != null) {
            if (this.jhM == null && this.lHP.getView() != null) {
                this.jhM = new com.baidu.tieba.NEGFeedBack.e(this.lHP.getPageContext(), this.lHP.getView());
            }
            AntiData cuM = cuM();
            SparseArray<String> sparseArray = new SparseArray<>();
            if (cuM != null && cuM.getDelThreadInfoList() != null) {
                List<DeleteThreadInfo> delThreadInfoList = cuM.getDelThreadInfoList();
                for (int i2 = 0; i2 < delThreadInfoList.size(); i2++) {
                    if (!TextUtils.isEmpty(delThreadInfoList.get(i2).text_info)) {
                        sparseArray.put(delThreadInfoList.get(i2).text_id, delThreadInfoList.get(i2).text_info);
                    }
                }
            }
            ar arVar = new ar();
            arVar.setFeedBackReasonMap(sparseArray);
            this.jhM.setDefaultReasonArray(new String[]{this.lHP.getString(R.string.delete_thread_reason_1), this.lHP.getString(R.string.delete_thread_reason_2), this.lHP.getString(R.string.delete_thread_reason_3), this.lHP.getString(R.string.delete_thread_reason_4), this.lHP.getString(R.string.delete_thread_reason_5)});
            this.jhM.setData(arVar);
            if (i == 1 || i == 2) {
                str = "4";
            } else {
                str = "3";
            }
            this.jhM.EG(str);
            this.jhM.a(new e.b() { // from class: com.baidu.tieba.pb.videopb.b.a.3
                @Override // com.baidu.tieba.NEGFeedBack.e.b
                public void W(JSONArray jSONArray) {
                    a.this.lHP.a(aVar, jSONArray);
                }
            });
        }
    }

    public AntiData cuM() {
        if (this.lHP.dgX() == null || this.lHP.dgX().getPbData() == null) {
            return null;
        }
        return this.lHP.dgX().getPbData().getAnti();
    }

    public void dk(View view) {
        SparseArray<Object> sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null) {
            a(sparseArray, false);
        }
    }

    public void a(SparseArray<Object> sparseArray, final boolean z) {
        g gVar;
        g gVar2;
        k kVar = new k(this.lHP.getContext());
        kVar.setTitleText(this.lHP.getString(R.string.bar_manager));
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.4
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lvw.dismiss();
                SparseArray<Object> sparseArray2 = (SparseArray) view.getTag();
                if (sparseArray2 != null) {
                    switch (i) {
                        case 0:
                            a.this.a(((Integer) sparseArray2.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray2.get(R.id.tag_del_post_id), ((Integer) sparseArray2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray2.get(R.id.tag_del_post_is_self)).booleanValue());
                            return;
                        case 1:
                            if (a.this.lwW != null) {
                                a.this.lwW.callback(new Object[]{sparseArray2.get(R.id.tag_manage_user_identity), sparseArray2.get(R.id.tag_forbid_user_name), sparseArray2.get(R.id.tag_forbid_user_post_id), sparseArray2.get(R.id.tag_forbid_user_name_show), sparseArray2.get(R.id.tag_forbid_user_portrait)});
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
                gVar2 = new g(0, this.lHP.getString(R.string.delete_post), kVar);
            } else {
                gVar2 = new g(0, this.lHP.getString(R.string.delete), kVar);
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
            g gVar3 = new g(1, this.lHP.getString(R.string.forbidden_person), kVar);
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
                gVar = new g(2, this.lHP.getString(R.string.un_mute), kVar);
            } else {
                gVar = new g(2, this.lHP.getString(R.string.mute), kVar);
            }
            gVar.mTextView.setTag(sparseArray4);
            arrayList.add(gVar);
        }
        kVar.bk(arrayList);
        if (this.lvw == null) {
            this.lvw = new i(this.lHP.getPageContext(), kVar);
        } else {
            this.lvw.a(kVar);
        }
        this.lvw.PJ();
    }

    public void dhR() {
        if (this.lnr == null) {
            this.lnr = new com.baidu.tbadk.core.dialog.b(this.lHP.getPageContext().getPageActivity());
            this.lnr.a(new String[]{this.lHP.getPageContext().getString(R.string.call_phone), this.lHP.getPageContext().getString(R.string.sms_phone), this.lHP.getPageContext().getString(R.string.search_in_baidu)}, new b.InterfaceC0564b() { // from class: com.baidu.tieba.pb.videopb.b.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    if (i == 0) {
                        TiebaStatic.eventStat(a.this.lHP.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                        a.this.ljN = a.this.ljN.trim();
                        UtilHelper.callPhone(a.this.lHP.getPageContext().getPageActivity(), a.this.ljN);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lHP.dgX().diV(), a.this.ljN, "1").start();
                        bVar.dismiss();
                    } else if (i == 1) {
                        TiebaStatic.eventStat(a.this.lHP.getPageContext().getPageActivity(), "pb_phone_sms", LoginConstants.SMS_LOGIN);
                        a.this.ljN = a.this.ljN.trim();
                        UtilHelper.smsPhone(a.this.lHP.getPageContext().getPageActivity(), a.this.ljN);
                        new com.baidu.tieba.pb.pb.main.b(a.this.lHP.dgX().diV(), a.this.ljN, "2").start();
                        bVar.dismiss();
                    } else if (i == 2) {
                        a.this.ljN = a.this.ljN.trim();
                        UtilHelper.startBaiDuBar(a.this.lHP.getPageContext().getPageActivity(), a.this.ljN);
                        bVar.dismiss();
                    }
                }
            }).os(b.a.BOTTOM_TO_TOP).ot(17).d(this.lHP.getPageContext());
        }
    }

    public void dq(final View view) {
        String[] strArr;
        int i = 0;
        if (this.lHP != null && this.lHP.dgX() != null) {
            final i iVar = new i(this.lHP.getPageContext());
            if (this.lHP.dgX().getPbData().lgX == null || this.lHP.dgX().getPbData().lgX.size() <= 0) {
                strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
            } else {
                String[] strArr2 = new String[this.lHP.dgX().getPbData().lgX.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= this.lHP.dgX().getPbData().lgX.size()) {
                        break;
                    }
                    strArr2[i2] = this.lHP.dgX().getPbData().lgX.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
                    i = i2 + 1;
                }
                strArr = strArr2;
            }
            iVar.a(null, strArr, new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.6
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i3, View view2) {
                    int i4 = 2;
                    iVar.dismiss();
                    if (a.this.lHP.dgX().getSortType() == 1 && i3 == 1) {
                        i4 = 0;
                    } else if (a.this.lHP.dgX().getSortType() == 2 && i3 == 0) {
                        i4 = 1;
                    } else if (a.this.lHP.dgX().getSortType() != 3 || i3 == 2) {
                        i4 = (i3 != 2 || a.this.lHP.dgX().getSortType() == 3) ? 0 : 3;
                    }
                    TiebaStatic.log("c12097");
                    TiebaStatic.log(new aq("c12097").aj("obj_source", view.getId() != R.id.pb_sort ? 1 : 0).aj("obj_type", i4));
                    if (a.this.lHP.dgX().getPbData().lgX != null && a.this.lHP.dgX().getPbData().lgX.size() > i3) {
                        i3 = a.this.lHP.dgX().getPbData().lgX.get(i3).sort_type.intValue();
                    }
                    boolean FN = a.this.lHP.dgX().FN(i3);
                    view.setTag(Integer.valueOf(a.this.lHP.dgX().djo()));
                    if (FN) {
                        a.this.lHP.setIsLoading(true);
                    }
                }
            });
            iVar.PJ();
        }
    }

    public void b(final MetaData metaData) {
        if (metaData != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lHP.getActivity());
            aVar.AZ(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
            aVar.setTitleShowCenter(true);
            aVar.Ba(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
            aVar.setMessageShowCenter(true);
            aVar.iM(false);
            aVar.b(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dR("obj_id", metaData.getUserId()).aj("obj_locate", 2));
                    aVar2.dismiss();
                }
            });
            aVar.a(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.8
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    TiebaStatic.log(new aq("c12528").dR("obj_id", metaData.getUserId()).aj("obj_locate", 1));
                    aVar2.dismiss();
                    if (a.this.lHP.doy() != null) {
                        a.this.lHP.doy().a(metaData.hadConcerned() ? false : true, metaData.getPortrait(), metaData.getUserId(), metaData.isGod(), "6", a.this.lHP.getPageContext().getUniqueId(), a.this.lHP.dgX().getForumId(), "0");
                    }
                }
            });
            aVar.b(this.lHP.getPageContext()).bmC();
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
        userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.lom);
        userMuteAddAndDelCustomMessage.setTag(this.lom);
        a(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
    }

    public void DF(String str) {
        if (str == null) {
            str = "";
        }
        if (this.lHP != null && this.lHP.getPageContext() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lHP.getPageContext().getPageActivity());
            aVar.Ba(str);
            aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.pb.videopb.b.a.9
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.b(this.lHP.getPageContext()).bmC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, final UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        if (z) {
            showLoadingDialog();
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            return;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.lHP.getBaseFragmentActivity());
        if (at.isEmpty(str)) {
            aVar.Ba(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
        } else {
            aVar.Ba(str);
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
        aVar.b(this.lHP.getPageContext()).bmC();
    }

    public void showLoadingDialog() {
        if (this.hYx == null) {
            this.hYx = new com.baidu.tbadk.core.view.a(this.lHP.getPageContext());
        }
        this.hYx.setDialogVisiable(true);
    }

    public void ceD() {
        if (this.hYx != null) {
            this.hYx.setDialogVisiable(false);
        }
    }

    public void f(SparseArray<Object> sparseArray) {
        PostData postData;
        boolean z;
        String str;
        g gVar;
        if (this.lHP != null && this.lHP.dgX() != null && sparseArray != null && (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) != null) {
            if (this.lnV == null) {
                this.lnV = new k(this.lHP.getContext());
                this.lnV.a(this.loR);
            }
            ArrayList arrayList = new ArrayList();
            boolean z2 = this.lHP.dgX().getPbData() != null && this.lHP.dgX().getPbData().dgl();
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
                if (postData.blR() != null) {
                    g gVar2 = new g(8, (postData.blR().hasAgree && postData.blB() == 5) ? this.lHP.getString(R.string.action_cancel_dislike) : this.lHP.getString(R.string.action_dislike), this.lnV);
                    SparseArray sparseArray2 = new SparseArray();
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    gVar2.mTextView.setTag(sparseArray2);
                    arrayList.add(gVar2);
                }
                if (TbadkCoreApplication.isLogin()) {
                    if (!z4 && z3) {
                        g gVar3 = new g(5, this.lHP.getString(R.string.mute_option), this.lnV);
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
                        if ((ua(z) && TbadkCoreApplication.isLogin()) && !z2) {
                            g gVar4 = new g(5, this.lHP.getString(R.string.report_text), this.lnV);
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
                            gVar5 = new g(6, this.lHP.getString(R.string.delete), this.lnV);
                            gVar5.mTextView.setTag(sparseArray4);
                        } else {
                            sparseArray4.put(R.id.tag_should_delete_visible, false);
                        }
                        gVar = new g(7, this.lHP.getString(R.string.bar_manager), this.lnV);
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
                            if (this.lHP.dgX().getPbData().dfX() == 1002 && !z) {
                                gVar5 = new g(6, this.lHP.getString(R.string.report_text), this.lnV);
                            } else {
                                gVar5 = new g(6, this.lHP.getString(R.string.delete), this.lnV);
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
                this.lnV.bk(arrayList);
                this.lnU = new i(this.lHP.getPageContext(), this.lnV);
                this.lnU.PJ();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(AgreeData agreeData) {
        int i = 1;
        if (agreeData != null) {
            if (this.eLs == null) {
                this.eLs = new com.baidu.tbadk.core.message.a();
            }
            if (this.eLc == null) {
                this.eLc = new com.baidu.tieba.tbadkCore.data.e();
                this.eLc.uniqueId = this.lHP.getUniqueId();
            }
            c cVar = new c();
            cVar.etA = 5;
            cVar.etG = 8;
            cVar.etF = 2;
            if (this.lHP != null && this.lHP.dgX() != null) {
                cVar.etE = this.lHP.dgX().djF();
            }
            if (cVar != null) {
                cVar.type = 2;
            }
            if (agreeData.hasAgree) {
                if (agreeData.agreeType == 5) {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = false;
                    if (cVar != null) {
                        cVar.etH = 0;
                    }
                } else {
                    agreeData.agreeType = 5;
                    agreeData.hasAgree = true;
                    agreeData.agreeNum--;
                    if (cVar != null) {
                        cVar.etH = 1;
                        i = 0;
                    }
                }
                this.eLs.a(agreeData, i, this.lHP.getUniqueId(), false);
                this.eLs.a(agreeData, this.eLc);
                if (this.lHP == null && this.lHP.dgX() != null && this.lHP.dgX().getPbData() != null) {
                    this.eLs.a(this.lHP.diC(), cVar, agreeData, this.lHP.dgX().getPbData().dfI());
                    return;
                }
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            if (cVar != null) {
                cVar.etH = 1;
            }
            i = 0;
            this.eLs.a(agreeData, i, this.lHP.getUniqueId(), false);
            this.eLs.a(agreeData, this.eLc);
            if (this.lHP == null) {
            }
        }
    }

    public void a(final b.InterfaceC0564b interfaceC0564b, boolean z) {
        if (this.lvF != null) {
            this.lvF.dismiss();
            this.lvF = null;
        }
        k kVar = new k(this.lHP.getContext());
        ArrayList arrayList = new ArrayList();
        if (this.lHP.dgX().getPbData() != null && this.lHP.dgX().getPbData().dfI() != null && !this.lHP.dgX().getPbData().dfI().isBjh()) {
            arrayList.add(new g(0, this.lHP.getPageContext().getString(R.string.save_to_emotion), kVar));
        }
        if (!z) {
            arrayList.add(new g(1, this.lHP.getPageContext().getString(R.string.save_to_local), kVar));
        }
        kVar.bk(arrayList);
        kVar.a(new k.c() { // from class: com.baidu.tieba.pb.videopb.b.a.13
            @Override // com.baidu.tbadk.core.dialog.k.c
            public void a(k kVar2, int i, View view) {
                a.this.lvF.dismiss();
                interfaceC0564b.a(null, i, view);
            }
        });
        this.lvF = new i(this.lHP.getPageContext(), kVar);
        this.lvF.PJ();
    }

    public void bc(ArrayList<com.baidu.tbadk.core.data.aj> arrayList) {
        if (this.lvA == null) {
            this.lvA = LayoutInflater.from(this.lHP.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
        }
        this.lHP.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.lvA);
        if (this.lvz == null) {
            this.lvz = new Dialog(this.lHP.getPageContext().getPageActivity(), R.style.common_alert_dialog);
            this.lvz.setCanceledOnTouchOutside(true);
            this.lvz.setCancelable(true);
            this.lvI = (ScrollView) this.lvA.findViewById(R.id.good_scroll);
            this.lvz.setContentView(this.lvA);
            WindowManager.LayoutParams attributes = this.lvz.getWindow().getAttributes();
            attributes.width = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds540);
            this.lvz.getWindow().setAttributes(attributes);
            this.hUz = new CompoundButton.OnCheckedChangeListener() { // from class: com.baidu.tieba.pb.videopb.b.a.14
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        a.this.lvE = (String) compoundButton.getTag();
                        if (a.this.hUy != null) {
                            for (CustomBlueCheckRadioButton customBlueCheckRadioButton : a.this.hUy) {
                                String str = (String) customBlueCheckRadioButton.getTag();
                                if (str != null && a.this.lvE != null && !str.equals(a.this.lvE)) {
                                    customBlueCheckRadioButton.setChecked(false);
                                }
                            }
                        }
                    }
                }
            };
            this.lvB = (LinearLayout) this.lvA.findViewById(R.id.good_class_group);
            this.lvD = (TextView) this.lvA.findViewById(R.id.dialog_button_cancel);
            this.lvD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.b.a.15
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (a.this.lvz instanceof Dialog) {
                        com.baidu.adp.lib.f.g.b(a.this.lvz, a.this.lHP.getPageContext());
                    }
                }
            });
            this.lvC = (TextView) this.lvA.findViewById(R.id.dialog_button_ok);
            this.lvC.setOnClickListener(this.lHP.doo());
        }
        this.lvB.removeAllViews();
        this.hUy = new ArrayList();
        CustomBlueCheckRadioButton fT = fT("0", this.lHP.getPageContext().getString(R.string.thread_good_class));
        this.hUy.add(fT);
        fT.setChecked(true);
        this.lvB.addView(fT);
        if (arrayList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                com.baidu.tbadk.core.data.aj ajVar = arrayList.get(i2);
                if (ajVar != null && !TextUtils.isEmpty(ajVar.bio()) && ajVar.bip() > 0) {
                    CustomBlueCheckRadioButton fT2 = fT(String.valueOf(ajVar.bip()), ajVar.bio());
                    this.hUy.add(fT2);
                    View view = new View(this.lHP.getPageContext().getPageActivity());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds1));
                    ap.setBackgroundColor(view, R.color.cp_bg_line_c);
                    view.setLayoutParams(layoutParams);
                    this.lvB.addView(view);
                    this.lvB.addView(fT2);
                }
                i = i2 + 1;
            }
            ViewGroup.LayoutParams layoutParams2 = this.lvI.getLayoutParams();
            switch (arrayList.size()) {
                case 0:
                case 1:
                    layoutParams2.height = l.dip2px(this.lHP.getPageContext().getPageActivity(), 120.0f);
                    break;
                case 2:
                    layoutParams2.height = l.dip2px(this.lHP.getPageContext().getPageActivity(), 186.0f);
                    break;
                default:
                    layoutParams2.height = l.dip2px(this.lHP.getPageContext().getPageActivity(), 220.0f);
                    break;
            }
            this.lvI.setLayoutParams(layoutParams2);
            this.lvI.removeAllViews();
            if (this.lvB != null && this.lvB.getParent() == null) {
                this.lvI.addView(this.lvB);
            }
        }
        com.baidu.adp.lib.f.g.a(this.lvz, this.lHP.getPageContext());
    }

    private CustomBlueCheckRadioButton fT(String str, String str2) {
        Activity pageActivity = this.lHP.getPageContext().getPageActivity();
        CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, l.getDimens(pageActivity, R.dimen.ds100));
        customBlueCheckRadioButton.setOnCheckedChangeListener(this.hUz);
        customBlueCheckRadioButton.setTag(str);
        customBlueCheckRadioButton.setText(str2);
        customBlueCheckRadioButton.setLayoutParams(layoutParams);
        return customBlueCheckRadioButton;
    }

    public boolean df(View view) {
        return (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView);
    }

    public void c(SparseArray<Object> sparseArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        showLoadingDialog();
        UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REQUEST);
        userMuteCheckCustomMessage.userIdF = com.baidu.adp.lib.f.b.toLong(currentAccount, 0L);
        userMuteCheckCustomMessage.userIdT = com.baidu.adp.lib.f.b.toLong((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
        userMuteCheckCustomMessage.mId = this.lom;
        userMuteCheckCustomMessage.setTag(this.lom);
        this.mExtra = sparseArray;
        MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
    }

    public void dlA() {
        if (this.lvx != null) {
            this.lvx.dismiss();
        }
        if (this.lvy != null) {
            com.baidu.adp.lib.f.g.b(this.lvy, this.lHP.getPageContext());
        }
        if (this.lvz != null) {
            com.baidu.adp.lib.f.g.b(this.lvz, this.lHP.getPageContext());
        }
        if (this.lvw != null) {
            this.lvw.dismiss();
        }
    }

    public void dpf() {
        if (this.lnU != null) {
            this.lnU.dismiss();
        }
    }

    public void dlz() {
        aXc();
        this.lHP.dkG();
        if (this.lnU != null) {
            this.lnU.dismiss();
        }
        dlA();
    }

    public void dly() {
        aXc();
        this.lHP.dkG();
        if (this.lnU != null) {
            this.lnU.dismiss();
        }
        this.lHP.cwk();
        dlA();
    }

    public Object getExtra() {
        return this.mExtra;
    }

    public View.OnLongClickListener doq() {
        return this.mOnLongClickListener;
    }

    public com.baidu.tbadk.core.dialog.b dpg() {
        return this.lnr;
    }

    public void setPhoneNumber(String str) {
        this.ljN = str;
    }

    public String dle() {
        return this.lvE;
    }

    public View dld() {
        if (this.lvA != null) {
            return this.lvA.findViewById(R.id.dialog_button_ok);
        }
        return null;
    }
}
