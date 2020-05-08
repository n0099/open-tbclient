package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.arch.lifecycle.q;
import android.arch.lifecycle.y;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.media.ExifInterface;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.aa;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.ah;
import com.baidu.tieba.pb.pb.main.ap;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.s;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoFragment;
import com.baidu.tieba.pb.videopb.fragment.ReplyFragment;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteAddResponseMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.tieba.usermute.response.UserMuteDelResponseMessage;
import java.io.Serializable;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.UserMuteCheck.DataRes;
/* loaded from: classes9.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout Wc;
    private EditorTools Zd;
    private ImageView aeb;
    private CustomViewPager dxC;
    public View efZ;
    private com.baidu.adp.lib.d.b<ImageView> emM;
    private com.baidu.adp.lib.d.b<GifView> emN;
    private com.baidu.adp.lib.d.b<TextView> epE;
    private com.baidu.adp.lib.d.b<View> epF;
    private com.baidu.adp.lib.d.b<LinearLayout> epG;
    private com.baidu.adp.lib.d.b<RelativeLayout> epH;
    private ImageView fjF;
    private VoiceManager gYv;
    private com.baidu.tieba.frs.profession.permission.c hcb;
    private com.baidu.tieba.f.b hcw;
    public aj iBh;
    private ImageView jAA;
    private com.baidu.tieba.pb.view.c jAB;
    private TextView jAC;
    private int jAE;
    private int jAF;
    private View jAf;
    private View jAw;
    private ImageView jAy;
    private ImageView jAz;
    private s jBc;
    private String jBt;
    public View jFP;
    private TBSpecificationBtn jKA;
    private TbImageView jKB;
    private ValueAnimator jKC;
    private ValueAnimator jKD;
    public com.baidu.tieba.pb.videopb.b.a jKE;
    private float jKI;
    private float jKJ;
    private boolean jKK;
    private ObjectAnimator jKO;
    private ObjectAnimator jKP;
    private NewPagerSlidingTabBaseStrip jKn;
    private VideoPbFragmentAdapter jKo;
    private View jKp;
    private View jKq;
    private VideoContainerLayout jKr;
    private com.baidu.tieba.pb.videopb.videoView.a jKs;
    private f jKt;
    private View jKu;
    private View jKv;
    private TextView jKx;
    private TextView jKy;
    private ImageView jKz;
    private com.baidu.tieba.pb.videopb.c.a jok;
    private PbFakeFloorModel jsW;
    private PbActivity jsZ;
    public ap jtF;
    private g jtN;
    private com.baidu.tbadk.editortools.pb.e jtO;
    private com.baidu.tieba.frs.profession.permission.c jtQ;
    private EmotionImageData jtR;
    private com.baidu.tbadk.core.view.d jtV;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jtq;
    int jtt;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int jKk = 0;
    public static int jKl = 1;
    public static int jAU = 3;
    public static int jAV = 0;
    public static int jAW = 3;
    public static int jAX = 4;
    public static int jAY = 5;
    public static int jAZ = 6;
    private static final int hQJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int jKm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a juL = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bP(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cwo();
            } else {
                com.baidu.tieba.pb.a.b.cwn();
            }
        }
    };
    private long jtg = 0;
    View.OnClickListener jKw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.jok != null) {
                TiebaStatic.log(new an("c13590").cI("obj_id", VideoPbFragment.this.jok.getTitle()).cI("obj_name", VideoPbFragment.this.jok.cEI()).af("obj_type", 2).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("tid", VideoPbFragment.this.cwA().getPbData().getThreadId()));
                String link = VideoPbFragment.this.jok.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aOV().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                        return;
                    }
                    Uri parse = Uri.parse(link);
                    if (parse != null) {
                        UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                    }
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a jtz = null;
    private com.baidu.tbadk.coreExtra.model.a dzH = null;
    private ForumManageModel gqg = null;
    private boolean jtk = false;
    private View jAx = null;
    private TextView hSo = null;
    private boolean jAt = false;
    private String dYC = null;
    private boolean jtC = false;
    private boolean jtD = false;
    private boolean jtE = false;
    private boolean jtm = false;
    int[] jts = new int[2];
    private int jtu = -1;
    private int jtv = Integer.MIN_VALUE;
    private int jub = 0;
    private int jKG = Integer.MIN_VALUE;
    private boolean aXb = false;
    private final PbModel.a juA = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mA;
            VideoPbFragment.this.cAG();
            VideoPbFragment.this.chj();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.rB(false);
            if (z && eVar != null) {
                bj cvr = eVar.cvr();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.G(eVar);
                com.baidu.tieba.pb.videopb.c.a cvR = eVar.cvR();
                if (cvR != null) {
                    VideoPbFragment.this.a(cvR);
                }
                VideoPbFragment.this.H(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.jtz != null) {
                    VideoPbFragment.this.jtz.gk(eVar.aGX());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dYC = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dYC) && VideoPbFragment.this.jtO != null && VideoPbFragment.this.jtO.aWN() != null && (mA = VideoPbFragment.this.jtO.aWN().mA(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dYC)) {
                        ((View) mA).setOnClickListener(VideoPbFragment.this.dZn);
                    }
                }
                if (VideoPbFragment.this.iBh != null && cvr != null && cvr.aKC() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cvr.aKC());
                    VideoPbFragment.this.iBh.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cwA().cyx());
                        jSONObject.put("fid", VideoPbFragment.this.cwA().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    k kVar = new k();
                    kVar.setOpType("2");
                    kVar.start();
                }
                if (VideoPbFragment.this.cDS() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                            arrayList = VideoPbFragment.this.cwA().getPbData().cvt();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cWo() == 1)) {
                            if (VideoPbFragment.this.cDS().cyb()) {
                                VideoPbFragment.this.cDS().HO(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.cDS().HO(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.cDS().HN(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.cDS().HN("");
                    }
                    VideoPbFragment.this.cDS().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.cVo().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0425a juC = new a.InterfaceC0425a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0425a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cAG();
            if (z && VideoPbFragment.this.cwA() != null) {
                if (VideoPbFragment.this.jtz != null) {
                    VideoPbFragment.this.jtz.gk(z2);
                }
                VideoPbFragment.this.cwA().rh(z2);
                if (VideoPbFragment.this.cwA().aGX()) {
                    VideoPbFragment.this.cxM();
                } else if (VideoPbFragment.this.cDS() != null) {
                    VideoPbFragment.this.cDS().cED();
                }
                if (z2) {
                    if (VideoPbFragment.this.jtz != null) {
                        if (VideoPbFragment.this.jtz.aHa() != null && VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.cwA().getPbData().cvr() != null && VideoPbFragment.this.cwA().getPbData().cvr().aKC() != null) {
                            MarkData aHa = VideoPbFragment.this.jtz.aHa();
                            MetaData aKC = VideoPbFragment.this.cwA().getPbData().cvr().aKC();
                            if (aHa != null && aKC != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aKC.getUserId()) && !aKC.hadConcerned()) {
                                    VideoPbFragment.this.jKE.b(aKC);
                                } else {
                                    VideoPbFragment.this.showToast(R.string.add_mark_on_pb);
                                }
                            } else {
                                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.add_mark));
                            }
                        } else {
                            return;
                        }
                    }
                    VideoPbFragment.this.cxJ();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dYG = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXk() {
            if (VideoPbFragment.this.jtF == null || VideoPbFragment.this.jtF.cBw() == null || !VideoPbFragment.this.jtF.cBw().deR()) {
                return !VideoPbFragment.this.zw(aj.dzC);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jtF.cBw().deT());
            if (VideoPbFragment.this.jtO != null && (VideoPbFragment.this.jtO.aXA() || VideoPbFragment.this.jtO.aXB())) {
                VideoPbFragment.this.jtO.a(false, VideoPbFragment.this.jtF.cBz());
            }
            VideoPbFragment.this.jtF.rG(true);
            return true;
        }
    };
    private final CustomMessageListener jui = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cwA() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.jtO != null) {
                    VideoPbFragment.this.rz(VideoPbFragment.this.jtO.aXt());
                }
                VideoPbFragment.this.cAj();
                VideoPbFragment.this.jKE.cAX();
            }
        }
    };
    private CustomMessageListener jul = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((com.baidu.tieba.pb.data.l) eVar.getData());
                        return;
                    case 1:
                        VideoPbFragment.this.a((ForumManageModel.b) eVar.getData(), false);
                        return;
                    case 2:
                        if (eVar.getData() == null) {
                            VideoPbFragment.this.a(false, (MarkData) null);
                            return;
                        } else {
                            VideoPbFragment.this.a(true, (MarkData) eVar.getData());
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    };
    private final CustomMessageListener gZH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.aXb) {
                VideoPbFragment.this.cyd();
            }
        }
    };
    private CustomMessageListener juB = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cxD();
            }
        }
    };
    private CustomMessageListener juw = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.jKE != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jKE.jtW) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.jKE.bzS();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.jKE.getExtra();
                DataRes dataRes = aVar.lgI;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (aq.isEmpty(str)) {
                        sparseArray.put(R.id.tag_user_mute_msg, "确定禁言？");
                    } else {
                        sparseArray.put(R.id.tag_user_mute_msg, str);
                    }
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    z = z2;
                } else {
                    sparseArray.put(R.id.tag_user_mute_visible, false);
                }
                int intValue = ((Integer) sparseArray.get(R.id.tag_from)).intValue();
                if (intValue == 0) {
                    VideoPbFragment.this.jKE.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.jKE.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener juu = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.jKE != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jKE.jtW) {
                VideoPbFragment.this.jKE.bzS();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cwA().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cvE().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jtV.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.jKE.wI(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.jKE.cya();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.jtV.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener juv = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.jKE != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jKE.jtW) {
                VideoPbFragment.this.jKE.bzS();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jtV.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.jtV.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b jtT = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXk() {
            if (VideoPbFragment.this.jtF == null || VideoPbFragment.this.jtF.cBx() == null || !VideoPbFragment.this.jtF.cBx().deR()) {
                return !VideoPbFragment.this.zw(aj.dzD);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jtF.cBx().deT());
            if (VideoPbFragment.this.jBc != null && VideoPbFragment.this.jBc.cxm() != null && VideoPbFragment.this.jBc.cxm().aXB()) {
                VideoPbFragment.this.jBc.cxm().a(VideoPbFragment.this.jtF.cBz());
            }
            VideoPbFragment.this.jtF.rH(true);
            return true;
        }
    };
    private final NewWriteModel.d dYM = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                    anVar.cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId());
                }
                anVar.cI("tid", VideoPbFragment.this.cwA().cyx());
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bOR();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cwA() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cwA().HI(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cDS() != null) {
                        VideoPbFragment.this.jub = VideoPbFragment.this.cDS().cAI();
                        VideoPbFragment.this.jKG = VideoPbFragment.this.cDS().cEG();
                        VideoPbFragment.this.cwA().cy(VideoPbFragment.this.jub, VideoPbFragment.this.jKG);
                    }
                }
                if (VideoPbFragment.this.dxC != null) {
                    VideoPbFragment.this.dxC.setCurrentItem(VideoPbFragment.jKl);
                }
                VideoPbFragment.this.jKE.cAX();
                VideoPbFragment.this.jtF.cBv();
                if (VideoPbFragment.this.jtO != null) {
                    VideoPbFragment.this.rz(VideoPbFragment.this.jtO.aXt());
                }
                VideoPbFragment.this.cAf();
                VideoPbFragment.this.rB(true);
                VideoPbFragment.this.cwA().cyR();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cDS() != null) {
                            VideoPbFragment.this.cDS().cED();
                        }
                    } else if (VideoPbFragment.this.cwA().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cwA().getPbData();
                        if (pbData != null && pbData.cvr() != null && pbData.cvr().aKC() != null && (userId = pbData.cvr().aKC().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cwA().cyI()) {
                            VideoPbFragment.this.cAE();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cwA().cyI()) {
                        VideoPbFragment.this.cAE();
                    }
                    VideoPbFragment.this.cxC();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.jtO.aXA() || VideoPbFragment.this.jtO.aXB()) {
                    VideoPbFragment.this.jtO.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jtF.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.iBh != null) {
                    VideoPbFragment.this.iBh.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener dZn = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dYC);
        }
    };
    private CustomMessageListener juk = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.jtO != null) {
                    VideoPbFragment.this.rz(VideoPbFragment.this.jtO.aXt());
                }
                VideoPbFragment.this.rB(false);
            }
        }
    };
    private int jKH = 0;
    private boolean jKL = true;
    private View.OnTouchListener jKM = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.jKH == 1) {
                if (!VideoPbFragment.this.jKL) {
                    VideoPbFragment.this.cDW();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cyh(), VideoPbFragment.this.cyh().getRootView());
                    VideoPbFragment.this.jKL = true;
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(VideoPbFragment.this.jKN);
                    com.baidu.adp.lib.f.e.lb().postDelayed(VideoPbFragment.this.jKN, 3000L);
                }
            } else if (VideoPbFragment.this.jKH == 2 && (VideoPbFragment.this.jKL || VideoPbFragment.this.cDY())) {
                VideoPbFragment.this.cDX();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cyh(), VideoPbFragment.this.cyh().getRootView());
                VideoPbFragment.this.jKL = false;
                if (VideoPbFragment.this.jKs != null) {
                    VideoPbFragment.this.jKs.sc(false);
                }
            }
            VideoPbFragment.this.jKH = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener hiQ = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.jKH = 0;
            VideoPbFragment.this.jKI = 0.0f;
            VideoPbFragment.this.jKJ = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.jKI += f;
            VideoPbFragment.this.jKJ += f2;
            if (VideoPbFragment.this.jKH == 0 && !VideoPbFragment.this.jKK && VideoPbFragment.this.jKs != null && !VideoPbFragment.this.jKs.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.jKJ) <= Math.abs(VideoPbFragment.this.jKI) || VideoPbFragment.this.jKJ > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.jKJ) > Math.abs(VideoPbFragment.this.jKI) && VideoPbFragment.this.jKJ > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.jKH = 2;
                    }
                } else {
                    VideoPbFragment.this.jKH = 1;
                }
            }
            return true;
        }
    };
    private Runnable jKN = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.jKL && !VideoPbFragment.this.cDY()) {
                VideoPbFragment.this.cDX();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cyh(), VideoPbFragment.this.cyh().getRootView());
                VideoPbFragment.this.jKL = false;
            }
        }
    };
    private final com.baidu.adp.base.d gql = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cwA() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gqg.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gqg.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cwA().cyR();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.jHG != 1002 || bVar.fqL) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.OL, dVar.kVg, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gqg.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gqg.getLoadDataMode(), gVar.OL, gVar.kVg, false);
                    VideoPbFragment.this.jKE.aO(gVar.kVj);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener dSb = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hcw.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d juy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                    anVar.cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cwA() != null) {
                    anVar.cI("tid", VideoPbFragment.this.cwA().cyx());
                }
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.jtF != null) {
                    VideoPbFragment.this.jtF.cBu();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.iBh != null) {
                    VideoPbFragment.this.iBh.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jtF != null) {
                if (VideoPbFragment.this.jBc != null && VideoPbFragment.this.jBc.cxm() != null && VideoPbFragment.this.jBc.cxm().aXB()) {
                    VideoPbFragment.this.jBc.cxm().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jtF.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dYF = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aXl() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aOQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean w;
            int i2 = 3;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cI("tid", VideoPbFragment.this.cwA().cyx());
                    anVar.cI("fid", VideoPbFragment.this.cwA().getForumId());
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.af("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.jtk) {
                        VideoPbFragment.this.jtk = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.jsW != null && postData.aKC() != null && postData.cWo() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.jBc != null) {
                                    VideoPbFragment.this.jBc.cxi();
                                }
                                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                lVar.a(VideoPbFragment.this.cwA().getPbData().getForum());
                                lVar.setThreadData(VideoPbFragment.this.cwA().getPbData().cvr());
                                lVar.f(postData);
                                VideoPbFragment.this.jsW.d(lVar);
                                VideoPbFragment.this.jsW.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aKC().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cwA().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.jtO != null) {
                                    VideoPbFragment.this.rz(VideoPbFragment.this.jtO.aXt());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cDS() != null && VideoPbFragment.this.cDS().cAT() != null && view == VideoPbFragment.this.cDS().cAT()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cwA().rf(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cDS().cAF();
                    }
                } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czF()) {
                    VideoPbFragment.this.jKE.aAi();
                } else if (VideoPbFragment.this.jKE != null && ((VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czG()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.jKE.cAX();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bOR();
                        VideoPbFragment.this.cAE();
                        if (view.getId() == R.id.owner_reply) {
                            w = VideoPbFragment.this.cwA().w(true, VideoPbFragment.this.cxQ());
                        } else {
                            w = view.getId() == R.id.all_reply ? VideoPbFragment.this.cwA().w(false, VideoPbFragment.this.cxQ()) : VideoPbFragment.this.cwA().HF(VideoPbFragment.this.cxQ());
                        }
                        view.setTag(Boolean.valueOf(w));
                        if (w) {
                            VideoPbFragment.this.chk();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.efZ) {
                    if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId());
                            anVar2.cI("tid", VideoPbFragment.this.cwA().cyx());
                            anVar2.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.jsZ, VideoPbFragment.this.efZ);
                        VideoPbFragment.this.jsZ.finish();
                    }
                } else if (view == VideoPbFragment.this.jFP && VideoPbFragment.this.jKE != null) {
                    if (VideoPbFragment.this.cwA() == null || VideoPbFragment.this.cwA().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cvt = VideoPbFragment.this.cwA().getPbData().cvt();
                    if ((cvt == null || cvt.size() <= 0) && VideoPbFragment.this.cwA().cyy()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", VideoPbFragment.this.cwA().getForumId()));
                    VideoPbFragment.this.jKE.cxE();
                } else if (VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czK()) {
                    if (VideoPbFragment.this.cwA() != null) {
                        VideoPbFragment.this.jKE.cAX();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.bOR();
                            VideoPbFragment.this.cAE();
                            VideoPbFragment.this.cwA().zA(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czG()) {
                    VideoPbFragment.this.jKE.aAi();
                } else if (VideoPbFragment.this.jKE != null && ((VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czM()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.jKE.cAX();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bOR();
                            VideoPbFragment.this.cAE();
                            VideoPbFragment.this.jKE.cO(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cwA().cyP()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czE()) {
                    if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.cwA().getPbData().cvr() != null) {
                        VideoPbFragment.this.jKE.aAi();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.jKE.HA(VideoPbFragment.this.cwA().getPbData().cvr().aKS());
                    }
                } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czN()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        am.v(true, false);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).af("obj_type", 0).af("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new an(TbadkCoreStatisticKey.SET_NIGHT_MODE).af("obj_type", 1).af("obj_source", 1));
                    }
                    VideoPbFragment.this.jKE.cCa();
                } else if (VideoPbFragment.this.jKE != null && (view == VideoPbFragment.this.jKE.cAC() || (VideoPbFragment.this.jKE.cCb() != null && (view == VideoPbFragment.this.jKE.cCb().czJ() || view == VideoPbFragment.this.jKE.cCb().czH())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cwA() != null || VideoPbFragment.this.cwA().getPbData() != null) {
                        if ((VideoPbFragment.this.cwA().getPbData().cvD() == 1 || VideoPbFragment.this.cwA().getPbData().cvD() == 3) && !VideoPbFragment.this.gqg.cXc()) {
                            VideoPbFragment.this.jKE.cAX();
                            if (VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czH()) {
                                if (VideoPbFragment.this.cwA().getPbData().cvr().aKx() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czJ()) {
                                i = VideoPbFragment.this.cwA().getPbData().cvr().aKy() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.jKE.cAC() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cwA().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cwA().getPbData().cvr().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gqg.b(id, name, id2, i, VideoPbFragment.this.jKE.cAD());
                        }
                    }
                } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czL()) {
                    if (VideoPbFragment.this.cwA() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.jKE.cAX();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cwA().getPbData(), VideoPbFragment.this.cwA().cyy(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cwA().getPbData().getForum().getId(), VideoPbFragment.this.cwA().getPbData().getForum().getName(), VideoPbFragment.this.cwA().getPbData().cvr().getId(), String.valueOf(VideoPbFragment.this.cwA().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.jKE.cCb() != null && view == VideoPbFragment.this.jKE.cCb().czI()) {
                    if (VideoPbFragment.this.cwA() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cwA().getPbData(), VideoPbFragment.this.cwA().cyy(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.jKE.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.jKE.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.jKE.aAi();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cI("tid", VideoPbFragment.this.cwA().cyx());
                        anVar3.cI("fid", VideoPbFragment.this.cwA().getForumId());
                        anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.af("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").af("obj_locate", 3).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                        if (VideoPbFragment.this.jKE != null) {
                            VideoPbFragment.this.jKE.cAX();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cWA() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.kTq != null) {
                                an aON = postData2.kTq.aON();
                                aON.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aON.af("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aON.af("obj_locate", 8);
                                }
                                TiebaStatic.log(aON);
                            }
                            String cyx = VideoPbFragment.this.cwA().cyx();
                            String id3 = postData2.getId();
                            int cvD = VideoPbFragment.this.cwA().getPbData() != null ? VideoPbFragment.this.cwA().getPbData().cvD() : 0;
                            VideoPbFragment.this.bOR();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cDS() != null && VideoPbFragment.this.cDS().cEF() != null) {
                                PbActivity.a HD = VideoPbFragment.this.cDS().cEF().HD(id3);
                                if (postData2 != null && VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && HD != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyx, id3, "pb", true, null, false, null, cvD, postData2.cCY(), VideoPbFragment.this.cwA().getPbData().getAnti(), false, postData2.aKC().getIconInfo()).addBigImageData(HD.jql, HD.jqm, HD.jqn, HD.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.cwA().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.cwA().cyF());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.cwA().czg());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.cwA().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.cwA() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cI("tid", VideoPbFragment.this.cwA().cyx());
                        anVar4.cI("fid", VideoPbFragment.this.cwA().getForumId());
                        anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.af("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.kTq != null) {
                                    an aON2 = postData3.kTq.aON();
                                    aON2.delete("obj_locate");
                                    aON2.af("obj_locate", 8);
                                    TiebaStatic.log(aON2);
                                }
                                if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.jsW != null && postData3.aKC() != null && postData3.cWo() != 1) {
                                    if (VideoPbFragment.this.jBc != null) {
                                        VideoPbFragment.this.jBc.cxi();
                                    }
                                    com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                    lVar2.a(VideoPbFragment.this.cwA().getPbData().getForum());
                                    lVar2.setThreadData(VideoPbFragment.this.cwA().getPbData().cvr());
                                    lVar2.f(postData3);
                                    VideoPbFragment.this.jsW.d(lVar2);
                                    VideoPbFragment.this.jsW.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aKC().getUserId(), "");
                                    if (VideoPbFragment.this.jtO != null) {
                                        VideoPbFragment.this.rz(VideoPbFragment.this.jtO.aXt());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.jKE != null && VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cDS() != null) {
                        VideoPbFragment.this.jKE.cAX();
                        if (VideoPbFragment.this.zx(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cwA() != null) {
                            VideoPbFragment.this.cxL();
                            if (VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.cwA().getPbData().cvr() != null && VideoPbFragment.this.cwA().getPbData().cvr().aKC() != null) {
                                TiebaStatic.log(new an("c13402").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()).af("obj_locate", 3).cI("uid", VideoPbFragment.this.cwA().getPbData().cvr().aKC().getUserId()));
                            }
                            if (VideoPbFragment.this.cwA().getPbData().cvr() != null && VideoPbFragment.this.cwA().getPbData().cvr().aKC() != null && VideoPbFragment.this.cwA().getPbData().cvr().aKC().getUserId() != null && VideoPbFragment.this.jtz != null) {
                                int g = VideoPbFragment.this.jKE.g(VideoPbFragment.this.cwA().getPbData());
                                bj cvr = VideoPbFragment.this.cwA().getPbData().cvr();
                                if (cvr.aJr()) {
                                    i2 = 2;
                                } else if (!cvr.aJs()) {
                                    if (cvr.aMw()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cvr.aMx() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cI("tid", VideoPbFragment.this.cwA().cyx()).af("obj_locate", 1).cI("obj_id", VideoPbFragment.this.cwA().getPbData().cvr().aKC().getUserId()).af("obj_type", VideoPbFragment.this.jtz.aGX() ? 0 : 1).af("obj_source", g).af("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.sa(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.jKE != null && VideoPbFragment.this.dxC != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.cwA().getPbData().cvr() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.cwA().getPbData().cvr().aKt() != 0) {
                            int currentItem = VideoPbFragment.this.dxC.getCurrentItem();
                            if (currentItem == VideoPbFragment.jKk) {
                                VideoPbFragment.this.dxC.setCurrentItem(VideoPbFragment.jKl);
                            } else if (currentItem == VideoPbFragment.jKl) {
                                if (VideoPbFragment.this.cDS() != null && VideoPbFragment.this.bRu() != null) {
                                    an cI = new an("c13403").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bRu = VideoPbFragment.this.bRu();
                                    boolean canScrollVertically = bRu.canScrollVertically(1);
                                    boolean canScrollVertically2 = bRu.canScrollVertically(-1);
                                    if (VideoPbFragment.this.Wc != null) {
                                        VideoPbFragment.this.Wc.setExpanded(false, true);
                                    }
                                    if (bRu.getLayoutManager() != null && (bRu.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bRu.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.jtu != -1 || VideoPbFragment.this.jtv != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.jtu > 3 || (VideoPbFragment.this.jtu == 3 && VideoPbFragment.this.jtv < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jtu, VideoPbFragment.this.jtv + equipmentHeight);
                                                    bRu.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.jtu >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jtu, VideoPbFragment.this.jtv + (equipmentHeight / 2));
                                                    bRu.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.jtu == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jtu, VideoPbFragment.this.jtv + (equipmentHeight / 4));
                                                    bRu.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bRu.smoothScrollBy(0, -VideoPbFragment.this.jtv);
                                                }
                                                cI.af("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bRu.getFirstVisiblePosition();
                                            View childAt = bRu.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.jtu = firstVisiblePosition;
                                            VideoPbFragment.this.jtv = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bRu.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bRu.smoothScrollToPosition(0);
                                            } else {
                                                bRu.smoothScrollToPosition(0);
                                            }
                                            cI.af("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cI);
                                        TiebaStatic.log(new an("c12942").af("obj_type", 1).af("obj_locate", 4).cI("tid", VideoPbFragment.this.cwA().cyx()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.cwA().getPbData().cvr() != null && VideoPbFragment.this.cwA().getPbData().cvr().aKC() != null) {
                                TiebaStatic.log(new an("c13402").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()).af("obj_locate", 2).cI("uid", VideoPbFragment.this.cwA().getPbData().cvr().aKC().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.sb(false);
                        VideoPbFragment.this.cxy();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.jub >= 0) {
                        if (VideoPbFragment.this.cwA() != null) {
                            VideoPbFragment.this.cwA().czh();
                        }
                        if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cDS() != null && VideoPbFragment.this.cDS().cEE() != null) {
                            VideoPbFragment.this.cDS().cEE().setData(VideoPbFragment.this.cwA().getPbData());
                        }
                        VideoPbFragment.this.jub = 0;
                        VideoPbFragment.this.jKG = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cDS() != null) {
                            VideoPbFragment.this.cDS().cB(VideoPbFragment.this.cwA().czk(), VideoPbFragment.this.cwA().czl());
                            VideoPbFragment.this.cwA().cy(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cwA() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cI("tid", VideoPbFragment.this.cwA().cyx());
                        anVar5.cI("fid", VideoPbFragment.this.cwA().getForumId());
                        anVar5.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.af("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aNT().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cAj();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cAj();
                }
            }
        }
    };
    private View.OnClickListener jqQ = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.jKE != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.jKE.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.jKE.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.jKE.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.jKE.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a jKF = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cxJ() {
        if (cwA() != null && cwA().getPbData() != null && cwA().getPbData().cvr() != null) {
            bj cvr = cwA().getPbData().cvr();
            cvr.mRecomAbTag = cwA().czr();
            cvr.mRecomWeight = cwA().czp();
            cvr.mRecomSource = cwA().czq();
            cvr.mRecomExtra = cwA().czs();
            if (cvr.getFid() == 0) {
                cvr.setFid(com.baidu.adp.lib.f.b.toLong(cwA().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvr, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxC() {
        if (cwA() != null && cwA().getPbData() != null && cwA().getPbData().cvr() != null) {
            bj cvr = cwA().getPbData().cvr();
            cvr.mRecomAbTag = cwA().czr();
            cvr.mRecomWeight = cwA().czp();
            cvr.mRecomSource = cwA().czq();
            cvr.mRecomExtra = cwA().czs();
            if (cvr.getFid() == 0) {
                cvr.setFid(com.baidu.adp.lib.f.b.toLong(cwA().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvr, "c13563");
            if (a2 != null) {
                a2.af("reply_type", 1);
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (aq.isEmpty(str)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.neterror);
            }
            showToast(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ForumManageModel.b bVar, boolean z) {
        boolean z2;
        int i = 0;
        if (bVar != null) {
            String string = !TextUtils.isEmpty(bVar.kVg) ? bVar.kVg : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.ui(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.gE(true);
                aVar.b(getPageContext());
                aVar.aMS();
            } else {
                a(0, bVar.OL, bVar.kVg, z);
            }
            if (bVar.OL) {
                if (bVar.gFD == 1) {
                    ArrayList<PostData> cvt = cwA().getPbData().cvt();
                    int size = cvt.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cvt.get(i).getId())) {
                            i++;
                        } else {
                            cvt.remove(i);
                            break;
                        }
                    }
                    cwA().getPbData().cvr().jQ(cwA().getPbData().cvr().aKt() - 1);
                    if (cDS() != null) {
                        cDS().cED();
                    }
                } else if (bVar.gFD == 0) {
                    cxK();
                } else if (bVar.gFD == 2) {
                    ArrayList<PostData> cvt2 = cwA().getPbData().cvt();
                    int size2 = cvt2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cvt2.get(i2).cWl().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cvt2.get(i2).cWl().get(i3).getId())) {
                                i3++;
                            } else {
                                cvt2.get(i2).cWl().remove(i3);
                                cvt2.get(i2).cWn();
                                z2 = true;
                                break;
                            }
                        }
                        cvt2.get(i2).KO(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cDS() != null) {
                        cDS().cED();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cwA().getPbData().cvC().joP;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cWl().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cWl().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cWl().remove(i2);
                    list.get(i).cWn();
                    z = true;
                    break;
                }
            }
            list.get(i).KO(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cDS() != null) {
            cDS().cED();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cwA() != null && cwA().getPbData() != null && cwA().getPbData().cvr() != null) {
            a(this.gqg.getLoadDataMode(), gVar.OL, gVar.kVg, false);
            if (gVar.OL) {
                this.jtC = true;
                if (i == 2 || i == 3) {
                    this.jtD = true;
                    this.jtE = false;
                } else if (i == 4 || i == 5) {
                    this.jtD = false;
                    this.jtE = true;
                }
                if (i == 2) {
                    cwA().getPbData().cvr().jT(1);
                    cwA().setIsGood(1);
                } else if (i == 3) {
                    cwA().getPbData().cvr().jT(0);
                    cwA().setIsGood(0);
                } else if (i == 4) {
                    cwA().getPbData().cvr().jS(1);
                    cwA().zz(1);
                } else if (i == 5) {
                    cwA().getPbData().cvr().jS(0);
                    cwA().zz(0);
                }
            }
            if (cwA().getPbData().cvr() != null && cDT() != null) {
                cDT().cEA();
            }
        }
    }

    private void cxK() {
        if (cwA().cyz() || cwA().cyB()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cwA().cyx());
            PbActivity pbActivity = this.jsZ;
            PbActivity pbActivity2 = this.jsZ;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cwA().cyx()));
        if (cxN()) {
            this.jsZ.finish();
        }
    }

    private boolean cxN() {
        if (cwA() == null) {
            return true;
        }
        if (cwA().getPbData() == null || !cwA().getPbData().cvP()) {
            if (cwA().aGX()) {
                final MarkData cyQ = cwA().cyQ();
                if (cyQ == null || !cwA().getIsFromMark() || bRu() == null) {
                    return true;
                }
                final MarkData zG = cwA().zG(bRu().getFirstVisiblePosition());
                if (zG == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cyQ);
                    this.jsZ.setResult(-1, intent);
                    return true;
                } else if (zG.getPostId() == null || zG.getPostId().equals(cyQ.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cyQ);
                    this.jsZ.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.ui(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.jtz != null) {
                                if (VideoPbFragment.this.jtz.aGX()) {
                                    VideoPbFragment.this.jtz.aGY();
                                    VideoPbFragment.this.jtz.gk(false);
                                }
                                VideoPbFragment.this.jtz.a(zG);
                                VideoPbFragment.this.jtz.gk(true);
                                VideoPbFragment.this.jtz.aGZ();
                            }
                            cyQ.setPostId(zG.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyQ);
                            VideoPbFragment.this.jsZ.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cwN();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyQ);
                            VideoPbFragment.this.jsZ.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cwN();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aMS();
                    return false;
                }
            } else if (cwA().getPbData() == null || cwA().getPbData().cvt() == null || cwA().getPbData().cvt().size() <= 0 || !cwA().getIsFromMark()) {
                return true;
            } else {
                this.jsZ.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwN() {
        this.jsZ.cwN();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void sa(boolean z) {
        com.baidu.tieba.pb.data.e pbData;
        int i;
        if (cwA() != null && this.jKE != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cwA().getPbData()) != null) {
                bj cvr = pbData.cvr();
                if (cvr != null && cvr.aKC() != null) {
                    TiebaStatic.log(new an("c13402").cI("tid", cwA().cyx()).cI("fid", pbData.getForumId()).af("obj_locate", 4).cI("uid", cvr.aKC().getUserId()));
                }
                if (cvr != null) {
                    if (cvr.aJr()) {
                        i = 2;
                    } else if (cvr.aJs()) {
                        i = 3;
                    } else if (cvr.aMw()) {
                        i = 4;
                    } else if (cvr.aMx()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cI("tid", cwA().cyx());
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cI("fid", cwA().getForumId());
                    if (!z) {
                        anVar.af("obj_locate", 6);
                    } else {
                        anVar.af("obj_locate", 5);
                    }
                    anVar.af("obj_name", i);
                    anVar.af("obj_type", 2);
                    if (cvr != null) {
                        if (cvr.aJr()) {
                            anVar.af("obj_type", 10);
                        } else if (cvr.aJs()) {
                            anVar.af("obj_type", 9);
                        } else if (cvr.aMx()) {
                            anVar.af("obj_type", 8);
                        } else if (cvr.aMw()) {
                            anVar.af("obj_type", 7);
                        } else if (cvr.isShareThread) {
                            anVar.af("obj_type", 6);
                        } else if (cvr.threadType == 0) {
                            anVar.af("obj_type", 1);
                        } else if (cvr.threadType == 40) {
                            anVar.af("obj_type", 2);
                        } else if (cvr.threadType == 49) {
                            anVar.af("obj_type", 3);
                        } else if (cvr.threadType == 54) {
                            anVar.af("obj_type", 4);
                        } else {
                            anVar.af("obj_type", 5);
                        }
                    }
                    if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    TiebaStatic.log(anVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (cwA().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cvt = pbData.cvt();
                        if ((cvt == null || cvt.size() <= 0) && cwA().cyy()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.jKE.cAX();
                        bOR();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), cvr)) {
                            if (this.jAB != null) {
                                this.jAB.setEnable(false);
                                t(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                zy(z ? 2 : 1);
                                return;
                            }
                            this.jKE.showLoadingDialog();
                            cwA().czb().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cI("tid", cwA().cyx());
                anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cI("fid", cwA().getForumId());
                if (!z) {
                }
                anVar2.af("obj_name", i);
                anVar2.af("obj_type", 2);
                if (cvr != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cDy() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        G(eVar.cEe());
        H(eVar.cEe());
        if (cwA() != null && cwA().getPbData() != null) {
            boolean isFromMark = cwA().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = cwA().getPbData();
            if (isFromMark) {
                PostData F = F(pbData);
                if (pbData.aGW() != null && !pbData.aGW().equals(F.getId()) && this.dxC != null) {
                    this.dxC.setCurrentItem(jKl);
                }
            }
        }
        eVar.cEf().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aKT() != null) {
                    if (VideoPbFragment.this.jKs.getVideoUrl() == null || !VideoPbFragment.this.jKs.getVideoUrl().equals(bjVar.aKT().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.jKs.getVideoUrl())) {
                            VideoPbFragment.this.jtm = true;
                            VideoPbFragment.this.dxC.setCurrentItem(VideoPbFragment.jKk);
                        }
                        if (VideoPbFragment.this.jKt == null || !VideoPbFragment.this.jKt.isPlaying()) {
                            VideoPbFragment.this.cDz();
                            VideoPbFragment.this.aN(bjVar);
                        }
                        VideoPbFragment.this.cDA();
                        if (VideoPbFragment.this.jKt.cEs()) {
                            VideoPbFragment.this.jKt.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.jKs.getVideoUrl(), bjVar.aKT().video_url);
                        VideoPbFragment.this.jKs.setData(bjVar);
                        VideoPbFragment.this.jKs.sj(VideoPbFragment.this.dxC.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.jKs.startPlay();
                            VideoPbFragment.this.jKs.cEW();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.jKs.setData(bjVar);
                }
            }
        });
        eVar.cEo().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dxC.setCurrentItem(num.intValue());
            }
        });
        eVar.cEj().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.jKs.aS(bjVar);
            }
        });
        eVar.cEk().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.jKs.aT(bjVar);
            }
        });
        eVar.cEl().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cDL();
            }
        });
        eVar.cEm().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDz() {
        ViewGroup.LayoutParams layoutParams = this.jKv.getLayoutParams();
        layoutParams.height = 0;
        this.jKv.setLayoutParams(layoutParams);
        this.jKv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDA() {
        if (this.jKt == null) {
            this.jKt = new f(getBaseFragmentActivity(), this.jKr);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cyh()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.jKr.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.jKt.c(eVar.cEg(), rect);
            if (this.jKt.cEs()) {
                this.jKt.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cEh() || VideoPbFragment.this.cwA().getTabIndex() == VideoPbFragment.jKl) {
                            VideoPbFragment.this.dxC.setCurrentItem(VideoPbFragment.jKl);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cEh() || VideoPbFragment.this.cwA().getTabIndex() == VideoPbFragment.jKl) {
                            VideoPbFragment.this.dxC.setCurrentItem(VideoPbFragment.jKl);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cEh() || cwA().getTabIndex() == jKl) {
                this.dxC.setCurrentItem(jKl);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.jKK && (this.jKL || cDY())) {
            cDX();
            UtilHelper.hideStatusBar(cyh(), cyh().getRootView());
            this.jKL = false;
            if (this.jKs != null) {
                this.jKs.sc(false);
            }
        }
        if (i == 4) {
            return this.jKs.onBackPress();
        }
        if (i == 24) {
            return this.jKs.cES();
        }
        if (i == 25) {
            return this.jKs.cET();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aN(bj bjVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        CoordinatorLayout.LayoutParams layoutParams3;
        Rect czt;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.aKT() != null) {
            int intValue = bjVar.aKT().video_width.intValue();
            int intValue2 = bjVar.aKT().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (cwA() != null || (czt = cwA().czt()) == null) ? ceil : czt.height();
                i = 0;
                layoutParams = this.jKr.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.jKr.setLayoutParams(layoutParams);
                this.jKr.setMaxHeight(ceil);
                this.jKr.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.jKr.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.jKn.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, jKm);
                } else {
                    layoutParams2.height = jKm;
                }
                this.jKn.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.Wc.getLayoutParams();
                int i2 = ceil + jKm;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.Wc.setLayoutParams(layoutParams3);
                if (i == 0 && (this.Wc.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.Wc.getLayoutParams()).getBehavior();
                    if (behavior instanceof VideoZoomBehavior) {
                        ((VideoZoomBehavior) behavior).setTopAndBottomOffset(-i);
                        return;
                    }
                    return;
                }
            }
        }
        d = 1.7777777777777777d;
        if (d > 1.7777777777777777d) {
        }
        if (d >= equipmentHeight) {
        }
        int ceil2 = (int) Math.ceil(equipmentWidth / equipmentHeight);
        if (cwA() != null) {
        }
        i = 0;
        layoutParams = this.jKr.getLayoutParams();
        if (layoutParams != null) {
        }
        this.jKr.setLayoutParams(layoutParams);
        this.jKr.setMaxHeight(ceil2);
        this.jKr.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.jKr.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.jKn.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.jKn.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.Wc.getLayoutParams();
        int i22 = ceil2 + jKm;
        if (layoutParams3 != null) {
        }
        this.Wc.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jtg = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.jtV = new com.baidu.tbadk.core.view.d();
        this.jtV.toastTime = 1000L;
        if (this.jKE != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.jKE.jtW;
            userMuteAddAndDelCustomMessage.setTag(this.jKE.jtW);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.jKE.jtW;
            userMuteCheckCustomMessage.setTag(this.jKE.jtW);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.cVo().w(getUniqueId());
    }

    private void initData() {
        this.jtz = com.baidu.tbadk.baseEditMark.a.a(this.jsZ);
        if (this.jtz != null) {
            this.jtz.a(this.juC);
        }
        this.gqg = new ForumManageModel(this.jsZ);
        this.gqg.setLoadDataCallBack(this.gql);
        this.dzH = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jKE = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.jtN = new g();
        d(this.jtN);
        this.jtO = (com.baidu.tbadk.editortools.pb.e) this.jtN.dw(getActivity());
        this.jtO.a(this.jsZ.getPageContext());
        this.jtO.a(this.dYM);
        this.jtO.a(this.dYF);
        this.jtO.a(this.jsZ.getPageContext(), bundle);
        this.jtO.aWN().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jtO.aWN().hA(true);
        qU(true);
        this.jtO.a(cwA().cyM(), cwA().cyx(), cwA().czd());
        registerListener(this.jul);
        registerListener(this.juB);
        registerListener(this.juk);
        registerListener(this.jui);
        registerListener(this.gZH);
        if (!cwA().cyD()) {
            this.jtO.wD(cwA().cyx());
        }
        if (cwA().cze()) {
            this.jtO.wB(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.jtO.wB(cAl());
        }
        this.jtF = new ap();
        if (this.jtO.aXm() != null) {
            this.jtF.d(this.jtO.aXm().getInputView());
        }
        this.jtO.a(this.dYG);
        this.iBh = new aj(getPageContext());
        this.iBh.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z) {
                    if (i == aj.dzC) {
                        VideoPbFragment.this.jtO.a((String) null, (WriteData) null);
                    } else if (i == aj.dzD && VideoPbFragment.this.jBc != null && VideoPbFragment.this.jBc.cxm() != null) {
                        VideoPbFragment.this.jBc.cxm().aXI();
                    } else if (i == aj.dzE) {
                        VideoPbFragment.this.c(VideoPbFragment.this.jtR);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.hcw = new com.baidu.tieba.f.b(getActivity());
        this.hcw.a(juL);
        this.jKK = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        blD();
        this.Wc = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.jKp = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.jKr = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.jKs = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.jKr);
        this.jKs.setUniqueId(getUniqueId());
        this.jKs.ad(this);
        this.jKs.cP(cyh().getRootView());
        this.jKs.cQ(this.jKu);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.jKn = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.jKv = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dxC = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.jKq = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.jKq.setOnClickListener(this.aOQ);
        cDC();
        cDB();
        cDD();
        this.jKo = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.dxC.setAdapter(this.jKo);
        this.jKn.setViewPager(this.dxC);
        this.jKn.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.cDS() != null) {
                        VideoPbFragment.this.cDS().si(false);
                    }
                    if (VideoPbFragment.this.cDT() != null) {
                        VideoPbFragment.this.cDT().si(true);
                        VideoPbFragment.this.Ae(VideoPbFragment.this.cDT().cEC() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cEl() != null && eVar.cEl().getValue() != null && eVar.cEl().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.jKs.sj(z);
                    VideoPbFragment.this.cAj();
                    if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cDT() != null) {
                        VideoPbFragment.this.cDT().si(false);
                    }
                    if (VideoPbFragment.this.cDS() != null) {
                        VideoPbFragment.this.cDS().si(true);
                        int cEC = VideoPbFragment.this.cDS().cEC();
                        int cEH = VideoPbFragment.this.cDS().cEH();
                        if (cEC != 0) {
                            VideoPbFragment.this.Ae(8);
                            VideoPbFragment.this.cDS().Ae(0);
                        } else if (cEH != 0) {
                            VideoPbFragment.this.cDS().Ae(8);
                            VideoPbFragment.this.Ae(0);
                        } else {
                            VideoPbFragment.this.cDS().Ae(8);
                            VideoPbFragment.this.Ae(8);
                        }
                    }
                    VideoPbFragment.this.jKs.sj(false);
                    VideoPbFragment.this.Wc.setExpanded(false, true);
                    if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.jKo.Ag(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jAf = this.rootView.findViewById(R.id.viewstub_progress);
        cDE();
        cDF();
        if (!this.jKK && this.jKL) {
            cDX();
            UtilHelper.hideStatusBar(cyh(), cyh().getRootView());
            this.jKL = false;
        }
    }

    private void cDB() {
        this.jKx = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.jKB = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.jKy = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.jKz = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.jKA = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.jKB.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jKB.setConrers(15);
        this.jKA.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.jKz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.cDN();
            }
        });
        this.jKA.setOnClickListener(this.jKw);
        this.jKv.setOnClickListener(this.jKw);
    }

    private void cDC() {
        this.jKn.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.jKn.setContainerLayoutParams(layoutParams);
        this.jKn.setRectPaintColor(R.color.cp_link_tip_a);
        this.jKn.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.jKn.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.jKn.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.jKn.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.jKn.setExpandedTabLayoutParams(layoutParams2);
    }

    public void sb(boolean z) {
        if (this.Wc != null) {
            this.Wc.setExpanded(z);
        }
    }

    private void cDD() {
        this.jAw = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.jAx = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.jAE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jAF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hSo = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hSo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.sb(false);
                VideoPbFragment.this.cxy();
                if (VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null && VideoPbFragment.this.cwA().getPbData().cvr() != null && VideoPbFragment.this.cwA().getPbData().cvr().aKC() != null) {
                    TiebaStatic.log(new an("c13402").cI("tid", VideoPbFragment.this.cwA().cyx()).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()).af("obj_locate", 1).cI("uid", VideoPbFragment.this.cwA().getPbData().cvr().aKC().getUserId()));
                }
            }
        });
        this.jAy = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jAy.setOnClickListener(this.aOQ);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jAz = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.jAz.setOnClickListener(this.aOQ);
        if (booleanExtra) {
            this.jAz.setVisibility(8);
        } else {
            this.jAz.setVisibility(0);
        }
        this.jAA = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.jAA.setOnClickListener(this.aOQ);
        this.jAB = new com.baidu.tieba.pb.view.c(this.jAA);
        this.jAB.cFg();
        this.jAC = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        rB(false);
    }

    private void blD() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bOS();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.jKu = this.rootView.findViewById(R.id.status_bar_background);
        if (this.jKK) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cyh());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.jKu.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cyh());
            this.jKu.setLayoutParams(layoutParams2);
            this.jKu.setVisibility(0);
        }
        this.efZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aOQ);
        this.fjF = (ImageView) this.efZ.findViewById(R.id.widget_navi_back_button);
        SvgManager.aOR().a(this.fjF, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jFP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aOQ);
        this.aeb = (ImageView) this.jFP.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jFP.setLayoutParams(layoutParams3);
        SvgManager.aOR().a(this.aeb, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jFP.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.hiQ);
        this.mNavigationBar.setOnTouchListener(this.jKM);
    }

    public void cDE() {
        setEditorTools(this.jtO.aWN());
    }

    private void cDF() {
        this.jsW = new PbFakeFloorModel(getPageContext());
        this.jBc = new s(getPageContext(), this.jsW, this.rootView);
        this.jBc.a(this.juy);
        this.jsW.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                VideoPbFragment.this.jsW.q(postData);
                if (VideoPbFragment.this.cDS() != null) {
                    VideoPbFragment.this.cDS().cED();
                }
                VideoPbFragment.this.jBc.cxi();
                VideoPbFragment.this.Zd.aVq();
                VideoPbFragment.this.rB(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jsZ = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cwA() != null) {
            cwA().au(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.aXb = true;
        getVoiceManager().onPause(getPageContext());
        this.jKs.nV(true);
        if (cwA() != null && !cwA().cyD()) {
            this.jtO.wC(cwA().cyx());
        }
        com.baidu.tbadk.BdToken.c.aFN().aFS();
        MessageManager.getInstance().unRegisterListener(this.juu);
        MessageManager.getInstance().unRegisterListener(this.juv);
        MessageManager.getInstance().unRegisterListener(this.juw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aXb = false;
        getVoiceManager().onResume(getPageContext());
        this.jKs.nV(false);
        cyd();
        registerListener(this.juu);
        registerListener(this.juv);
        registerListener(this.juw);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jKo != null && this.dxC != null) {
            this.jKo.Ag(z ? this.dxC.getCurrentItem() : -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cVo().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.jAB != null) {
            this.jAB.onDestroy();
        }
        if (this.gqg != null) {
            this.gqg.cancelLoadData();
        }
        if (this.jKs != null) {
            this.jKs.onDestroy();
        }
        if (this.jtq != null) {
            this.jtq.cancelLoadData();
        }
        if (this.iBh != null) {
            this.iBh.onDestroy();
        }
        if (cwA() != null) {
            cwA().cancelLoadData();
            cwA().destory();
            if (cwA().cza() != null) {
                cwA().cza().onDestroy();
            }
        }
        if (this.jtO != null) {
            this.jtO.onDestroy();
        }
        this.jtV = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jsZ);
        this.jKn.onChangeSkinType();
        am.setBackgroundColor(this.jKn, R.color.cp_bg_line_h);
        this.jtF.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.jKt == null || !this.jKt.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.jKu, R.color.cp_mask_b_alpha66);
        if (this.Zd != null) {
            this.Zd.onChangeSkinType(i);
        }
        if (this.jBc != null) {
            this.jBc.onChangeSkinType(i);
        }
        if (this.hSo != null) {
            am.setViewTextColor(this.hSo, (int) R.color.cp_cont_d);
            this.hSo.setBackgroundDrawable(am.aB(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.jAz != null && cwA() != null) {
            if (cwA().aGX()) {
                SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.jAy != null) {
            SvgManager.aOR().a(this.jAy, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cwA() != null) {
            t(cwA().getPbData());
        }
        am.setViewTextColor(this.jAC, (int) R.color.cp_cont_b);
        if (this.jAw != null) {
            am.setBackgroundResource(this.jAw, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.jAx, R.color.cp_bg_line_h);
        if (cDS() != null) {
            cDS().onChangeSkinType(i);
        }
        if (cDT() != null) {
            cDT().onChangeSkinType(i);
        }
        if (this.jKp != null) {
            am.setBackgroundResource(this.jKp, R.drawable.personalize_tab_shadow);
        }
        if (this.jKv != null) {
            am.setBackgroundColor(this.jKv, R.color.cp_bg_line_g);
        }
        if (this.jKz != null) {
            SvgManager.aOR().a(this.jKz, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jKx != null) {
            am.setViewTextColor(this.jKx, (int) R.color.cp_cont_b);
        }
        if (this.jKy != null) {
            am.setViewTextColor(this.jKy, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYv == null) {
            this.gYv = VoiceManager.instance();
        }
        return this.gYv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOR() {
        if (this.gYv != null) {
            this.gYv.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cyf() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cyg() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cwA() {
        return this.jsZ.cwA();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cyh() {
        return this.jsZ;
    }

    public com.baidu.tbadk.baseEditMark.a cDG() {
        return this.jtz;
    }

    public View.OnClickListener cDH() {
        return this.aOQ;
    }

    public View.OnClickListener cDI() {
        return this.jqQ;
    }

    public View.OnLongClickListener cDJ() {
        return this.jKE.cDJ();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.HS(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder("#4%2&@#907$12#@96476)w7we9e~@$%&&");
                    spannableStringBuilder2.setSpan(new com.baidu.tbadk.widget.d(drawable), 0, "#4%2&@#907$12#@96476)w7we9e~@$%&&".length(), 33);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
                    spannableStringBuilder.setSpan(objArr[i], spannableStringBuilder.getSpanStart(objArr[i]), spannableStringBuilder.length(), 18);
                    SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder("\n\r");
                    spannableStringBuilder3.setSpan(new AbsoluteSizeSpan(1), 0, spannableStringBuilder3.length(), 18);
                    spannableStringBuilder.append((CharSequence) spannableStringBuilder3);
                    return;
                }
            }
        }
    }

    public BdTypeRecyclerView bRu() {
        Iterator<BaseFragment> it = this.jKo.cEc().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void qU(boolean z) {
        this.jtO.hE(z);
        this.jtO.hF(z);
        this.jtO.hG(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.jKE != null) {
            if (z) {
                this.jKE.cAX();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.jKE.cAY();
            } else {
                this.jKE.cAX();
            }
        }
    }

    public boolean zw(int i) {
        if (this.iBh == null || cwA() == null || cwA().getPbData() == null || cwA().getPbData().getAnti() == null) {
            return true;
        }
        return this.iBh.aA(cwA().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cxA() {
        if ((cwA() != null && cwA().getPbData().cvP()) || this.iBh == null || cwA() == null || cwA().getPbData() == null || cwA().getPbData().getAnti() == null) {
            return true;
        }
        return this.iBh.kz(cwA().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cwA() != null) {
            gVar.setForumName(cwA().cwr());
            if (cwA().getPbData() != null && cwA().getPbData().getForum() != null) {
                gVar.a(cwA().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cwA());
        }
    }

    public void cAz() {
        if (this.Zd != null) {
            this.Zd.display();
            if (this.jtO != null) {
                this.jtO.aXq();
            }
            cBh();
        }
    }

    private boolean cxx() {
        PbModel cwA = cwA();
        if (cwA == null || cwA.getPbData() == null) {
            return false;
        }
        bj cvr = cwA.getPbData().cvr();
        cwA.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cvr);
    }

    public void cxy() {
        if (checkUpIsLogin() && cwA() != null && cwA().getPbData() != null && cwA().getPbData().getForum() != null && !cxx()) {
            if (cwA().getPbData().cvP()) {
                cao();
                return;
            }
            if (this.hcb == null) {
                this.hcb = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hcb.ut(0);
                this.hcb.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mF(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void u(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mG(boolean z) {
                        if (z) {
                            VideoPbFragment.this.cao();
                        }
                    }
                });
            }
            this.hcb.E(cwA().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cwA().cyx(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.jtO.onActivityResult(i, i2, intent);
        if (this.jtq != null) {
            this.jtq.onActivityResult(i, i2, intent);
        }
        if (this.jBc != null) {
            this.jBc.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cxL();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cMR().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.jtR = emotionImageData;
                        if (zw(aj.dzE)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (cyh() != null) {
            if (this.jKL && !TbSingleton.getInstance().isNotchScreen(cyh()) && !TbSingleton.getInstance().isCutoutScreen(cyh())) {
                cDX();
                UtilHelper.hideStatusBar(cyh(), cyh().getRootView());
                this.jKL = false;
            }
            this.jKF.jKY = z;
            cDK();
            cDL();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jsZ;
        if (i == 0) {
            cAf();
            if (this.jBc != null) {
                this.jBc.cxi();
            }
            rB(false);
        }
        cAj();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(PbFullScreenEditorActivityConfig.EDITOR_DATA);
            if (serializableExtra instanceof PbEditorData) {
                PbEditorData pbEditorData = (PbEditorData) serializableExtra;
                WriteData writeData = new WriteData();
                writeData.setContent(pbEditorData.getContent());
                writeData.setSubPbReplyPrefix(pbEditorData.getSubPbReplyPrefix());
                writeData.setWriteImagesInfo(pbEditorData.getWriteImagesInfo());
                switch (pbEditorData.getEditorType()) {
                    case 0:
                        this.jtO.resetData();
                        this.jtO.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jtO.b(writeData);
                        com.baidu.tbadk.editortools.l mD = this.jtO.aWN().mD(6);
                        if (mD != null && mD.dWM != null) {
                            mD.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jsZ;
                        if (i == -1) {
                            this.jtO.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jBc != null && this.jBc.cxm() != null) {
                            com.baidu.tbadk.editortools.pb.h cxm = this.jBc.cxm();
                            cxm.setThreadData(cwA().getPbData().cvr());
                            cxm.b(writeData);
                            cxm.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mD2 = cxm.aWN().mD(6);
                            if (mD2 != null && mD2.dWM != null) {
                                mD2.dWM.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jsZ;
                            if (i == -1) {
                                cxm.aXI();
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AntiData antiData, PostWriteCallBackData postWriteCallBackData) {
        if (antiData != null && postWriteCallBackData != null) {
            if (AntiHelper.c(antiData) || AntiHelper.d(antiData) || AntiHelper.e(antiData) || AntiHelper.f(antiData)) {
                if (cwA() != null && !cwA().cyD()) {
                    antiData.setBlock_forum_name(cwA().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cwA().getPbData().getForum().getId());
                    antiData.setUser_name(cwA().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cwA().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), postWriteCallBackData.getPreMsg(), postWriteCallBackData.getColorMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bq(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).af("obj_locate", at.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).af("obj_locate", at.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new an(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).af("obj_locate", at.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.jKE != null) {
                this.jKE.wI(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cyj() {
        if (cwA() != null && this.jsZ != null) {
            if (this.jtO == null || !this.jtO.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.jtO = (com.baidu.tbadk.editortools.pb.e) dVar.dw(getContext());
                this.jtO.a(this.jsZ.getPageContext());
                this.jtO.a(this.dYM);
                this.jtO.a(this.dYF);
                this.jtO.a(this.jsZ.getPageContext(), this.jsZ.getIntent() == null ? null : this.jsZ.getIntent().getExtras());
                this.jtO.aWN().hA(true);
                setEditorTools(this.jtO.aWN());
                if (!cwA().cyD()) {
                    this.jtO.wD(cwA().cyx());
                }
                if (cwA().cze()) {
                    this.jtO.wB(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.jtO.wB(cAl());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Zd = editorTools;
        this.Zd.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Zd.getParent() == null) {
            this.rootView.addView(this.Zd, layoutParams);
        }
        this.Zd.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Zd.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRV() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRV() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.jtO.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.jtO.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cAf();
        this.jtO.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.Zd != null && VideoPbFragment.this.Zd.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.jtF != null && VideoPbFragment.this.jtF.cBw() != null) {
                    if (!VideoPbFragment.this.jtF.cBw().deS()) {
                        VideoPbFragment.this.jtF.rG(false);
                    }
                    VideoPbFragment.this.jtF.cBw().uO(false);
                }
            }
        });
    }

    public void cao() {
        if (!checkUpIsLogin()) {
            if (cwA() != null) {
                TiebaStatic.log(new an("c10517").af("obj_locate", 2).cI("fid", cwA().getForumId()));
            }
        } else if (cxA()) {
            if (this.jtO != null && (this.jtO.aXA() || this.jtO.aXB())) {
                this.jtO.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Zd != null) {
                cAz();
                this.jKF.jKX = false;
                if (this.Zd.mD(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.Zd.mD(2).dWM, false, null);
                }
            }
            cBh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cxx() && cxA()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jts);
                this.jtt = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cwA() != null && cwA().getPbData() != null && cwA().getPbData().cvP()) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.jsZ.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bRu().smoothScrollBy(0, (VideoPbFragment.this.jts[1] + VideoPbFragment.this.jtt) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jBc != null) {
                            VideoPbFragment.this.jtO.aWN().setVisibility(8);
                            VideoPbFragment.this.jBc.g(str, str2, VideoPbFragment.this.cAl(), (VideoPbFragment.this.cwA() == null || VideoPbFragment.this.cwA().getPbData() == null || VideoPbFragment.this.cwA().getPbData().cvr() == null || !VideoPbFragment.this.cwA().getPbData().cvr().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxm = VideoPbFragment.this.jBc.cxm();
                            if (cxm != null && VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                                cxm.a(VideoPbFragment.this.cwA().getPbData().getAnti());
                                cxm.setThreadData(VideoPbFragment.this.cwA().getPbData().cvr());
                            }
                            if (VideoPbFragment.this.jtF.cBy() == null && VideoPbFragment.this.jBc.cxm().aXQ() != null) {
                                VideoPbFragment.this.jBc.cxm().aXQ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jtF != null && VideoPbFragment.this.jtF.cBx() != null) {
                                            if (!VideoPbFragment.this.jtF.cBx().deS()) {
                                                VideoPbFragment.this.jtF.rH(false);
                                            }
                                            VideoPbFragment.this.jtF.cBx().uO(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jtF.e(VideoPbFragment.this.jBc.cxm().aXQ().getInputView());
                                VideoPbFragment.this.jBc.cxm().a(VideoPbFragment.this.jtT);
                            }
                        }
                        VideoPbFragment.this.cBh();
                    }
                }, 0L);
                return;
            }
            if (this.jtQ == null) {
                this.jtQ = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jtQ.ut(1);
                this.jtQ.a(new AnonymousClass43(str, str2));
            }
            if (cwA() != null && cwA().getPbData() != null && cwA().getPbData().getForum() != null) {
                this.jtQ.E(cwA().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cwA().cyx(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$43  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements c.a {
        final /* synthetic */ String juX;
        final /* synthetic */ String juY;

        AnonymousClass43(String str, String str2) {
            this.juX = str;
            this.juY = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mF(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void u(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mG(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bRu().smoothScrollBy(0, (VideoPbFragment.this.jts[1] + VideoPbFragment.this.jtt) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jBc != null) {
                            VideoPbFragment.this.jtO.aWN().setVisibility(8);
                            VideoPbFragment.this.jBc.g(AnonymousClass43.this.juX, AnonymousClass43.this.juY, VideoPbFragment.this.cAl(), (VideoPbFragment.this.cwA() == null || VideoPbFragment.this.cwA().getPbData() == null || VideoPbFragment.this.cwA().getPbData().cvr() == null || !VideoPbFragment.this.cwA().getPbData().cvr().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxm = VideoPbFragment.this.jBc.cxm();
                            if (cxm != null && VideoPbFragment.this.cwA() != null && VideoPbFragment.this.cwA().getPbData() != null) {
                                cxm.a(VideoPbFragment.this.cwA().getPbData().getAnti());
                                cxm.setThreadData(VideoPbFragment.this.cwA().getPbData().cvr());
                            }
                            if (VideoPbFragment.this.jtF.cBy() == null && VideoPbFragment.this.jBc.cxm().aXQ() != null) {
                                VideoPbFragment.this.jBc.cxm().aXQ().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jtF != null && VideoPbFragment.this.jtF.cBx() != null) {
                                            if (!VideoPbFragment.this.jtF.cBx().deS()) {
                                                VideoPbFragment.this.jtF.rH(false);
                                            }
                                            VideoPbFragment.this.jtF.cBx().uO(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jtF.e(VideoPbFragment.this.jBc.cxm().aXQ().getInputView());
                                VideoPbFragment.this.jBc.cxm().a(VideoPbFragment.this.jtT);
                            }
                        }
                        VideoPbFragment.this.cBh();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.e eVar, boolean z, int i) {
        PostData F;
        w wVar;
        StringBuilder sb = null;
        if (eVar != null && (F = F(eVar)) != null) {
            String userId = F.aKC().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvD()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (F.aKC() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, F.aKC().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, F.aKC().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, F.aKC().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, F.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvD()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cvK = eVar.cvK();
                if (v.getCount(cvK) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cvK) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.dqn) != null && wVar.doh && !wVar.doi && (wVar.type == 1 || wVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bfVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
                        }
                    }
                }
                if (sb != null && !StringUtils.isNull(sb.toString())) {
                    sparseArray.put(R.id.tag_del_multi_forum, String.format(TbadkCoreApplication.getInst().getString(R.string.del_multi_forum_default_txt), sb.toString().substring(0, sb.length() - 1)));
                }
            }
            return sparseArray;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxL() {
        MarkData zG;
        if (cwA() != null && cwA().getPbData() != null && cDS() != null && this.jtz != null) {
            if (cwA().getPbData() != null && cwA().getPbData().cvP()) {
                zG = cwA().zG(0);
            } else if (this.dxC != null && this.dxC.getCurrentItem() == jKk) {
                zG = cwA().l(F(cwA().getPbData()));
            } else {
                zG = cwA().zG(cDS().cAJ());
            }
            if (zG != null) {
                if (!zG.isApp() || (zG = cwA().zG(cDS().cAJ() + 1)) != null) {
                    cAE();
                    this.jtz.a(zG);
                    if (!this.jtz.aGX()) {
                        this.jtz.aGZ();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jtz.aGY();
                    TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zx(int i) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, i)));
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(EmotionImageData emotionImageData) {
        if (emotionImageData != null) {
            if (this.jtq == null) {
                this.jtq = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jsZ);
                this.jtq.b(this.dYF);
                this.jtq.c(this.dYM);
            }
            this.jtq.a(emotionImageData, cwA(), cwA().getPbData());
        }
    }

    public PostData F(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cvB() != null) {
            return eVar.cvB();
        }
        if (!v.isEmpty(eVar.cvt())) {
            Iterator<PostData> it = eVar.cvt().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cWo() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cvy();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aKC() != null && postData.aKC().getUserTbVipInfoData() != null && postData.aKC().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aKC().getGodUserData().setIntro(postData.aKC().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvr() == null || eVar.cvr().aKC() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKC = eVar.cvr().aKC();
        String userId = aKC.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvr().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKC;
        }
        postData.Di(1);
        postData.setId(eVar.cvr().aKS());
        postData.setTitle(eVar.cvr().getTitle());
        postData.setTime(eVar.cvr().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxQ() {
        ArrayList<PostData> cvt;
        int count;
        int i;
        if (cwA() == null || cwA().getPbData() == null || cwA().getPbData().cvt() == null || (count = v.getCount((cvt = cwA().getPbData().cvt()))) == 0) {
            return "";
        }
        if (cwA().cyO()) {
            Iterator<PostData> it = cvt.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cWo() == 1) {
                    return next.getId();
                }
            }
        }
        if (bRu() == null) {
            i = 0;
        } else {
            i = cDS().cAI();
        }
        PostData postData = (PostData) v.getItem(cvt, i);
        if (postData == null || postData.aKC() == null) {
            return "";
        }
        if (cwA().HG(postData.aKC().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(cvt, i2);
            if (postData2 == null || postData2.aKC() == null || postData2.aKC().getUserId() == null) {
                break;
            } else if (cwA().HG(postData2.aKC().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(cvt, i3);
            if (postData3 == null || postData3.aKC() == null || postData3.aKC().getUserId() == null) {
                return "";
            }
            if (cwA().HG(postData3.aKC().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxM() {
        if (cwA() != null) {
            com.baidu.tieba.pb.data.e pbData = cwA().getPbData();
            cwA().rh(true);
            if (this.jtz != null) {
                pbData.Ht(this.jtz.aGW());
            }
            if (cDS() != null) {
                cDS().cED();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cwA() != null) {
            cAG();
            cwA().rh(z);
            if (this.jtz != null) {
                this.jtz.gk(z);
                if (markData != null) {
                    this.jtz.a(markData);
                }
            }
            if (cwA().aGX()) {
                cxM();
            } else if (cDS() != null) {
                cDS().cED();
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (cwA() != null && cwA().getPbData() != null && lVar.cwe() != null) {
            String id = lVar.cwe().getId();
            ArrayList<PostData> cvt = cwA().getPbData().cvt();
            int i = 0;
            while (true) {
                if (i >= cvt.size()) {
                    break;
                }
                PostData postData = cvt.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cwi = lVar.cwi();
                    postData.Dh(lVar.getTotalCount());
                    if (postData.cWl() != null && cwi != null) {
                        Iterator<PostData> it = cwi.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aKC() != null && (metaData = postData.getUserMap().get(next.aKC().getUserId())) != null) {
                                next.a(metaData);
                                next.tW(true);
                                next.a(getPageContext(), cwA().HG(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cwi.size() != postData.cWl().size();
                        postData.cWl().clear();
                        postData.cWl().addAll(cwi);
                        z = z2;
                    }
                    if (postData.cWh() != null) {
                        postData.cWi();
                    }
                }
            }
            if (!cwA().getIsFromMark() && z && cDS() != null) {
                cDS().cED();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxD() {
        if (cwA() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Kd(cwA().getForumId()) && cwA().getPbData() != null && cwA().getPbData().getForum() != null) {
            if (cwA().getPbData().getForum().isLike() == 1) {
                cwA().czc().eI(cwA().getForumId(), cwA().cyx());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bj cvr = eVar.cvr();
            if (cvr != null && cvr.aMy()) {
                cyj();
            } else {
                d(this.jtN);
            }
            if (this.jtO != null) {
                rz(this.jtO.aXt());
                this.jtO.a(eVar.getAnti());
                this.jtO.a(eVar.getForum(), eVar.getUserData());
                this.jtO.setThreadData(cvr);
                if (cwA() != null) {
                    this.jtO.a(cwA().cyM(), cwA().cyx(), cwA().czd());
                }
                if (cvr != null) {
                    this.jtO.hH(cvr.aLW());
                }
            }
        }
    }

    public void cAj() {
        reset();
        cAf();
        this.jBc.cxi();
        rB(false);
    }

    private void reset() {
        if (this.jtO != null && this.Zd != null) {
            com.baidu.tbadk.editortools.pb.a.aXj().setStatus(0);
            this.jtO.aXD();
            this.jtO.aWX();
            if (this.jtO.getWriteImagesInfo() != null) {
                this.jtO.getWriteImagesInfo().setMaxImagesAllowed(this.jtO.isBJH ? 1 : 9);
            }
            this.jtO.mJ(SendView.ALL);
            this.jtO.mK(SendView.ALL);
            com.baidu.tbadk.editortools.g mA = this.Zd.mA(23);
            com.baidu.tbadk.editortools.g mA2 = this.Zd.mA(2);
            com.baidu.tbadk.editortools.g mA3 = this.Zd.mA(5);
            if (mA2 != null) {
                mA2.display();
            }
            if (mA3 != null) {
                mA3.display();
            }
            if (mA != null) {
                mA.hide();
            }
            this.Zd.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvr() != null) {
            t(eVar);
            if (eVar.aGX()) {
                SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aOR().a(this.jAz, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jAC.setText(zO(eVar.cvr().aKt()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cvr()));
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cvr())) {
            if (this.jAB != null) {
                this.jAB.setEnable(false);
                this.jAB.onDestroy();
            }
            SvgManager.aOR().a(this.jAA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jAB == null || !this.jAB.isEnable()) {
            SvgManager.aOR().a(this.jAA, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String zO(int i) {
        if (i == 0) {
            return getString(R.string.pb_comment_red_dot_no_reply);
        }
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setRoundingMode(RoundingMode.HALF_UP);
        if (i > 9990000) {
            return "· · ·";
        }
        if (i >= 1000000) {
            numberFormat.setMaximumFractionDigits(0);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else if (i >= 10000) {
            numberFormat.setMaximumFractionDigits(1);
            return numberFormat.format(i / 10000.0f) + ExifInterface.LONGITUDE_WEST;
        } else {
            return "" + i;
        }
    }

    public void rB(boolean z) {
        if (this.jAx != null) {
            rz(this.jtO.aXt());
            if (this.jAt) {
                rq(z);
            } else {
                rr(z);
            }
            cDK();
            cDL();
        }
    }

    public void cBh() {
        if (this.jAx != null) {
            this.jAw.setVisibility(8);
            this.jAx.setVisibility(8);
            this.jKF.jKX = false;
            cDK();
            cDL();
        }
    }

    private void cDK() {
        if (this.jKs != null) {
            if (this.jKF.cEb()) {
                this.jKs.ta(false);
            } else {
                this.jKs.ta(this.jKs.brI() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDL() {
        if (this.jKs != null && this.dxC != null) {
            if (this.dxC.getCurrentItem() != 0) {
                this.jKs.sj(false);
            } else if (this.jKF.cEb()) {
                this.jKs.sj(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.jKs.sj(eVar.cEl() == null || eVar.cEl().getValue() == null || eVar.cEl().getValue().booleanValue());
                }
            }
        }
    }

    private void zy(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cyh(), cxB(), i);
    }

    private int cxB() {
        if (cwA() == null || cwA().getPbData() == null || cwA().getPbData().cvr() == null) {
            return -1;
        }
        return cwA().getPbData().cvr().aLm();
    }

    public void rz(boolean z) {
        this.jAt = z;
    }

    public void rq(boolean z) {
        if (this.jAx != null && this.hSo != null) {
            this.hSo.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAx.startAnimation(alphaAnimation);
            }
            this.jAw.setVisibility(0);
            this.jAx.setVisibility(0);
            this.jKF.jKX = true;
        }
    }

    public void rr(boolean z) {
        if (this.jAx != null && this.hSo != null) {
            this.hSo.setText(cAl());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAx.startAnimation(alphaAnimation);
            }
            this.jAw.setVisibility(0);
            this.jAx.setVisibility(0);
            this.jKF.jKX = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.jok = aVar;
            this.jKx.setText(aVar.getTitle());
            this.jKy.setText(aVar.cEI());
            String cEJ = aVar.cEJ();
            TBSpecificationBtn tBSpecificationBtn = this.jKA;
            if (TextUtils.isEmpty(cEJ)) {
                cEJ = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cEJ);
            this.jKB.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cI("obj_id", VideoPbFragment.this.jok.getTitle()).cI("obj_name", VideoPbFragment.this.jok.cEI()).af("obj_type", 2).cI("fid", VideoPbFragment.this.cwA().getPbData().getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("tid", VideoPbFragment.this.cwA().getPbData().getThreadId()));
                    VideoPbFragment.this.cDM();
                }
            }, aVar.cEK().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDM() {
        ViewGroup.LayoutParams layoutParams = this.jKv.getLayoutParams();
        if (layoutParams != null) {
            if (this.jKC == null || !this.jKC.isRunning()) {
                this.jKv.setAlpha(0.0f);
                this.jKv.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDN() {
        if (this.jKv.getLayoutParams() != null) {
            if (this.jKC == null || !this.jKC.isRunning()) {
                cDO();
            }
        }
    }

    private void cDO() {
        final ViewGroup.LayoutParams layoutParams = this.jKv.getLayoutParams();
        if (layoutParams != null) {
            if (this.jKD == null || !this.jKD.isRunning()) {
                this.jKD = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jKD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.jKv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.jKD.setDuration(200L);
                this.jKD.start();
                this.jKD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.e(layoutParams);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Wc.getLayoutParams();
        final int i = layoutParams2.height;
        this.jKC = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jKC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hQJ);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hQJ);
                VideoPbFragment.this.jKv.setLayoutParams(layoutParams);
                VideoPbFragment.this.Wc.setLayoutParams(layoutParams2);
            }
        });
        this.jKC.setDuration(300L);
        this.jKC.start();
        this.jKC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.jKv.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.Wc.getLayoutParams();
        final int i = layoutParams2.height;
        this.jKC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jKC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hQJ);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.jKv.setLayoutParams(layoutParams);
                VideoPbFragment.this.Wc.setLayoutParams(layoutParams2);
            }
        });
        this.jKC.setDuration(300L);
        this.jKC.start();
        this.jKC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cDP();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDP() {
        this.jKC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jKC.setDuration(300L);
        this.jKC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.jKv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.jKC.start();
    }

    public String cAl() {
        if (!aq.isEmpty(this.jBt)) {
            return this.jBt;
        }
        this.jBt = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.am.cAa());
        return this.jBt;
    }

    public void cAG() {
        hideProgressBar();
        if (cDS() != null) {
            cDS().endLoadData();
            cDS().cAH();
        }
    }

    public boolean cB(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.aIc().isShowImages()) {
                    return HC(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cwA() == null || cwA().getPbData() == null) {
                        return true;
                    }
                    if (this.jBc != null) {
                        this.jBc.cxi();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(cwA().getPbData().getForum());
                    lVar.setThreadData(cwA().getPbData().cvr());
                    lVar.f(postData);
                    this.jsW.d(lVar);
                    this.jsW.setPostId(postData.getId());
                    b(view, postData.aKC().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jtO != null) {
                        rz(this.jtO.aXt());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cDQ() {
        if (this.jtO != null) {
            rz(this.jtO.aXt());
        }
        cAj();
        this.jKE.cAX();
    }

    private boolean HC(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("bubble_link", "");
            if (StringUtils.isNull(string)) {
                return false;
            }
            TiebaStatic.log("c10051");
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(BubbleGroupActivityConfig.class)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BubbleGroupActivityConfig(getPageContext().getPageActivity())));
                return true;
            }
            com.baidu.tbadk.browser.a.startWebActivity(getPageContext().getPageActivity(), getResources().getString(R.string.editor_privilege), string + "?props_id=" + str, true, true, true);
            return true;
        }
        return false;
    }

    public void chk() {
        if (this.jAf != null) {
            this.jAf.setVisibility(0);
        }
    }

    public void chj() {
        if (this.jAf != null) {
            this.jAf.setVisibility(8);
        }
    }

    public void Ae(int i) {
        if (this.jKp != null) {
            this.jKp.setVisibility(i);
        }
    }

    public void cAE() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cxG() {
        return this.juA;
    }

    public void cAf() {
        if (this.Zd != null) {
            this.Zd.hide();
        }
    }

    public void bOS() {
        if (this.jsZ.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jsZ.getCurrentFocus());
        }
    }

    public void H(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvr() != null) {
            String valueOf = String.valueOf(eVar.cvr().aKt());
            if (eVar.cvr().aKt() == 0) {
                valueOf = "";
            }
            this.jKn.xz(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.jKo.cEc()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cwA() != null && cwA().getPbData() != null && cwA().getPbData().cvr() != null && cwA().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(jAV)).intValue();
                if (intValue == jAW) {
                    if (!this.gqg.cXc()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gqg.KT(aq.P(jSONArray));
                        }
                        this.gqg.a(cwA().getPbData().getForum().getId(), cwA().getPbData().getForum().getName(), cwA().getPbData().cvr().getId(), str, intValue3, intValue2, booleanValue, cwA().getPbData().cvr().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == jAX || intValue == jAZ) {
                    if (cwA().cyZ() != null) {
                        cwA().cyZ().zr(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == jAX) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bcM() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcN() {
        if (this.emM == null) {
            this.emM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bcZ */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.aIc().isShowImages();
                    foreDrawableImageView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        foreDrawableImageView.setAdjustViewBounds(false);
                        foreDrawableImageView.setInterceptOnClick(false);
                    } else {
                        foreDrawableImageView.setDefaultResource(R.drawable.icon_click);
                        foreDrawableImageView.setAdjustViewBounds(true);
                        foreDrawableImageView.setInterceptOnClick(true);
                    }
                    return foreDrawableImageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: a */
                public void destroyObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: b */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (i.aIc().isShowImages()) {
                            tbImageView.setAdjustViewBounds(false);
                            tbImageView.setInterceptOnClick(false);
                        } else {
                            tbImageView.setDefaultResource(R.drawable.icon_click);
                            tbImageView.setAdjustViewBounds(true);
                            tbImageView.setInterceptOnClick(true);
                        }
                    }
                    return imageView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public ImageView passivateObject(ImageView imageView) {
                    imageView.setBackgroundDrawable(null);
                    imageView.setImageDrawable(null);
                    imageView.setTag(null);
                    imageView.setOnClickListener(null);
                    if (imageView instanceof ForeDrawableImageView) {
                        ForeDrawableImageView foreDrawableImageView = (ForeDrawableImageView) imageView;
                        ((ForeDrawableImageView) imageView).stopLoading();
                        foreDrawableImageView.setForegroundDrawable(0);
                        foreDrawableImageView.setDefaultBgResource(R.color.common_color_10220);
                        foreDrawableImageView.reset();
                    }
                    return imageView;
                }
            }, 8, 0);
        }
        return this.emM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcO() {
        if (this.epE == null) {
            this.epE = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.epE;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcP() {
        if (this.emN == null) {
            this.emN = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJu */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.aIc().isShowImages();
                    gifView.setDefaultBg(am.getDrawable(R.color.common_color_10220));
                    if (isShowImages) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: g */
                public void destroyObject(GifView gifView) {
                    gifView.setBackgroundDrawable(null);
                    gifView.setImageDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    gifView.onDestroy();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: h */
                public GifView activateObject(GifView gifView) {
                    gifView.setTag(null);
                    if (i.aIc().isShowImages()) {
                        gifView.setAdjustViewBounds(false);
                        gifView.setInterceptOnClick(false);
                    } else {
                        gifView.setDefaultResource(R.drawable.icon_click);
                        gifView.setAdjustViewBounds(true);
                        gifView.setInterceptOnClick(true);
                    }
                    return gifView;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: i */
                public GifView passivateObject(GifView gifView) {
                    gifView.release();
                    gifView.onDestroy();
                    gifView.setImageDrawable(null);
                    gifView.aYi();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.emN;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcQ() {
        if (this.epF == null) {
            this.epF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyk */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cE */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cF */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).cXw();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cG */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.epF;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcR() {
        if (this.epG == null) {
            this.epG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cym */
                public LinearLayout makeObject() {
                    LinearLayout linearLayout = new LinearLayout(VideoPbFragment.this.getPageContext().getPageActivity());
                    linearLayout.setId(R.id.pb_text_voice_layout);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setGravity(16);
                    linearLayout.setBaselineAligned(true);
                    linearLayout.setOrientation(1);
                    linearLayout.setLayoutParams(layoutParams);
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: c */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: d */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.epG;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcS() {
        this.epH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyl */
            public RelativeLayout makeObject() {
                return new RelativeLayout(VideoPbFragment.this.getPageContext().getPageActivity());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: c */
            public void destroyObject(RelativeLayout relativeLayout) {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: d */
            public RelativeLayout activateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: e */
            public RelativeLayout passivateObject(RelativeLayout relativeLayout) {
                return relativeLayout;
            }
        }, 10, 0);
        return this.epH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ak(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jtk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (as.HS(str) && cwA() != null && cwA().cyx() != null) {
            TiebaStatic.log(new an("c11664").af("obj_param1", 1).cI("post_id", cwA().cyx()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                jVar.mLink = str;
                jVar.type = 3;
                jVar.dVP = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
            }
        } else {
            as.cBA().d(getPageContext(), str);
        }
        this.jtk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void al(Context context, String str) {
        as.cBA().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jtk = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void am(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void an(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void t(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.jKE.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cEv = this.jKE.cEv();
            if (cEv == null) {
                this.jKE.cxw();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cEv.getItemView(1).setVisibility(8);
            } else {
                cEv.getItemView(1).setVisibility(0);
            }
            cEv.aMT();
            this.jtk = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ao(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aOV().b(getPageContext(), new String[]{str});
            this.jtk = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cDR() {
        return this.dzH;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener baB() {
        return this.dSb;
    }

    public ReplyFragment cDS() {
        if (this.jKo == null || !(this.jKo.Af(jKl) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.jKo.Af(jKl);
    }

    public DetailInfoFragment cDT() {
        if (this.jKo == null || !(this.jKo.Af(jKk) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.jKo.Af(jKk);
    }

    public boolean cwq() {
        PbModel cwA = this.jsZ.cwA();
        if (cwA == null) {
            return false;
        }
        return cwA.cwq();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cvA;
        PbModel cwA = this.jsZ.cwA();
        if (cwA != null && cwA.getPbData() != null && !cwA.getPbData().cvP()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cwA.getPbData().cvr().getId();
            if (cwA.isShareThread() && cwA.getPbData().cvr().dtt != null) {
                historyMessage.threadName = cwA.getPbData().cvr().dtt.showText;
            } else {
                historyMessage.threadName = cwA.getPbData().cvr().getTitle();
            }
            if (cwA.isShareThread() && !cwq()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cwA.getPbData().getForum().getName();
            }
            ArrayList<PostData> cvt = cwA.getPbData().cvt();
            int cAI = cDS() != null ? cDS().cAI() : 0;
            if (cvt != null && cAI >= 0 && cAI < cvt.size()) {
                historyMessage.postID = cvt.get(cAI).getId();
            }
            historyMessage.isHostOnly = cwA.getHostMode();
            historyMessage.isSquence = cwA.cyy();
            historyMessage.isShareThread = cwA.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jtO != null) {
            this.jtO.onDestroy();
        }
        if (cwA != null && (cwA.cyz() || cwA.cyB())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cwA.cyx());
            if (this.jtC) {
                if (this.jtE) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cwA.bHI());
                }
                if (this.jtD) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cwA.getIsGood());
                }
            }
            if (cwA.getPbData() != null && System.currentTimeMillis() - this.jtg >= 40000 && (cvA = cwA.getPbData().cvA()) != null && !v.isEmpty(cvA.getDataList())) {
                intent.putExtra("guess_like_data", cvA);
            }
            PbActivity pbActivity = this.jsZ;
            PbActivity pbActivity2 = this.jsZ;
            pbActivity.setResult(-1, intent);
        }
        if (cxN()) {
            if (cwA != null) {
                com.baidu.tieba.pb.data.e pbData = cwA.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.jtm) {
                        if (this.jKr != null) {
                            Rect rect = new Rect();
                            this.jKr.getGlobalVisibleRect(rect);
                            ah.czP().h(rect);
                        }
                        ah.czP().zK(this.dxC.getCurrentItem());
                        BdTypeRecyclerView bRu = bRu();
                        Parcelable parcelable = null;
                        if (bRu != null) {
                            parcelable = bRu.onSaveInstanceState();
                        }
                        ah.czP().a(cwA.cyG(), parcelable, cwA.cyy(), cwA.getHostMode(), false);
                    }
                }
            } else {
                ah.czP().reset();
            }
            cwN();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.jKs != null && !this.jKs.brI()) {
            if ((this.jKs.isFullScreen() && configuration.orientation == 1) || (!this.jKs.isFullScreen() && configuration.orientation == 2)) {
                this.jKs.sk(false);
            }
        }
    }

    public boolean cDU() {
        if (this.jKs == null) {
            return false;
        }
        return this.jKs.brI();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.cVo().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean jKX;
        public boolean jKY;

        private a() {
            this.jKY = true;
        }

        public boolean cEb() {
            return (this.jKX && this.jKY) ? false : true;
        }
    }

    public void cDV() {
        this.jtu = -1;
        this.jtv = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyd() {
        if (cwA() != null && !aq.isEmpty(cwA().cyx())) {
            com.baidu.tbadk.BdToken.c.aFN().o(com.baidu.tbadk.BdToken.b.dgd, com.baidu.adp.lib.f.b.toLong(cwA().cyx(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.jKq.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDW() {
        if (this.jKO == null) {
            this.jKO = ObjectAnimator.ofFloat(this.jKu, "alpha", 0.0f, 1.0f);
            this.jKO.setDuration(200L);
        }
        this.jKO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDX() {
        if (this.jKP == null) {
            this.jKP = ObjectAnimator.ofFloat(this.jKu, "alpha", 1.0f, 0.0f);
            this.jKP.setDuration(200L);
        }
        this.jKP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cDY() {
        return this.jKs != null && this.jKs.cDZ();
    }

    public boolean cDZ() {
        return this.jKL;
    }

    public void sc(boolean z) {
        this.jKL = z;
    }
}
