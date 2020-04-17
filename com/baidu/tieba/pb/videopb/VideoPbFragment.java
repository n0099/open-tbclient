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
    private AppBarLayout VZ;
    private EditorTools Za;
    private ImageView adY;
    private CustomViewPager dxy;
    public View efU;
    private com.baidu.adp.lib.d.b<ImageView> emH;
    private com.baidu.adp.lib.d.b<GifView> emI;
    private com.baidu.adp.lib.d.b<View> epA;
    private com.baidu.adp.lib.d.b<LinearLayout> epB;
    private com.baidu.adp.lib.d.b<RelativeLayout> epC;
    private com.baidu.adp.lib.d.b<TextView> epz;
    private ImageView fjA;
    private VoiceManager gYp;
    private com.baidu.tieba.frs.profession.permission.c hbV;
    private com.baidu.tieba.f.b hcq;
    public aj iBb;
    private int jAA;
    private int jAB;
    private s jAY;
    private View jAb;
    private View jAs;
    private ImageView jAu;
    private ImageView jAv;
    private ImageView jAw;
    private com.baidu.tieba.pb.view.c jAx;
    private TextView jAy;
    private String jBp;
    public View jFL;
    public com.baidu.tieba.pb.videopb.b.a jKA;
    private float jKE;
    private float jKF;
    private boolean jKG;
    private ObjectAnimator jKK;
    private ObjectAnimator jKL;
    private NewPagerSlidingTabBaseStrip jKj;
    private VideoPbFragmentAdapter jKk;
    private View jKl;
    private View jKm;
    private VideoContainerLayout jKn;
    private com.baidu.tieba.pb.videopb.videoView.a jKo;
    private f jKp;
    private View jKq;
    private View jKr;
    private TextView jKt;
    private TextView jKu;
    private ImageView jKv;
    private TBSpecificationBtn jKw;
    private TbImageView jKx;
    private ValueAnimator jKy;
    private ValueAnimator jKz;
    private com.baidu.tieba.pb.videopb.c.a jog;
    private PbFakeFloorModel jsS;
    private PbActivity jsV;
    public ap jtB;
    private g jtJ;
    private com.baidu.tbadk.editortools.pb.e jtK;
    private com.baidu.tieba.frs.profession.permission.c jtM;
    private EmotionImageData jtN;
    private com.baidu.tbadk.core.view.d jtR;
    private com.baidu.tieba.pb.pb.main.emotion.model.a jtm;
    int jtp;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int jKg = 0;
    public static int jKh = 1;
    public static int jAQ = 3;
    public static int jAR = 0;
    public static int jAS = 3;
    public static int jAT = 4;
    public static int jAU = 5;
    public static int jAV = 6;
    private static final int hQD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int jKi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a juH = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void bP(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cwr();
            } else {
                com.baidu.tieba.pb.a.b.cwq();
            }
        }
    };
    private long jtc = 0;
    View.OnClickListener jKs = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.jog != null) {
                TiebaStatic.log(new an("c13590").cI("obj_id", VideoPbFragment.this.jog.getTitle()).cI("obj_name", VideoPbFragment.this.jog.cEL()).af("obj_type", 2).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("tid", VideoPbFragment.this.cwD().getPbData().getThreadId()));
                String link = VideoPbFragment.this.jog.getLink();
                if (!TextUtils.isEmpty(link)) {
                    if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                        ba.aOY().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a jtv = null;
    private com.baidu.tbadk.coreExtra.model.a dzD = null;
    private ForumManageModel gqa = null;
    private boolean jtg = false;
    private View jAt = null;
    private TextView hSi = null;
    private boolean jAp = false;
    private String dYx = null;
    private boolean jty = false;
    private boolean jtz = false;
    private boolean jtA = false;
    private boolean jti = false;
    int[] jto = new int[2];
    private int jtq = -1;
    private int jtr = Integer.MIN_VALUE;
    private int jtX = 0;
    private int jKC = Integer.MIN_VALUE;
    private boolean aWW = false;
    private final PbModel.a juw = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
            com.baidu.tbadk.editortools.g mA;
            VideoPbFragment.this.cAJ();
            VideoPbFragment.this.chl();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.rB(false);
            if (z && eVar != null) {
                bj cvu = eVar.cvu();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(eVar, i2);
                VideoPbFragment.this.G(eVar);
                com.baidu.tieba.pb.videopb.c.a cvU = eVar.cvU();
                if (cvU != null) {
                    VideoPbFragment.this.a(cvU);
                }
                VideoPbFragment.this.H(eVar);
                VideoPbFragment.this.c(z, i, i2, i3, eVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(eVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(eVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.jtv != null) {
                    VideoPbFragment.this.jtv.gk(eVar.aGZ());
                }
                AntiData anti = eVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.dYx = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.dYx) && VideoPbFragment.this.jtK != null && VideoPbFragment.this.jtK.aWP() != null && (mA = VideoPbFragment.this.jtK.aWP().mA(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.dYx)) {
                        ((View) mA).setOnClickListener(VideoPbFragment.this.dZi);
                    }
                }
                if (VideoPbFragment.this.iBb != null && cvu != null && cvu.aKE() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cvu.aKE());
                    VideoPbFragment.this.iBb.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.cwD().cyA());
                        jSONObject.put("fid", VideoPbFragment.this.cwD().getForumId());
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
                if (VideoPbFragment.this.cDV() != null) {
                    if (i != -1) {
                        ArrayList<PostData> arrayList = null;
                        if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                            arrayList = VideoPbFragment.this.cwD().getPbData().cvw();
                        }
                        if (v.getCount(arrayList) == 0 || (v.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).cWr() == 1)) {
                            if (VideoPbFragment.this.cDV().cye()) {
                                VideoPbFragment.this.cDV().HL(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                            } else {
                                VideoPbFragment.this.cDV().HL(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                            }
                        } else {
                            VideoPbFragment.this.cDV().HK(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                        }
                    } else {
                        VideoPbFragment.this.cDV().HK("");
                    }
                    VideoPbFragment.this.cDV().endLoadData();
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.cVr().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.e eVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0404a juy = new a.InterfaceC0404a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0404a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.cAJ();
            if (z && VideoPbFragment.this.cwD() != null) {
                if (VideoPbFragment.this.jtv != null) {
                    VideoPbFragment.this.jtv.gk(z2);
                }
                VideoPbFragment.this.cwD().rh(z2);
                if (VideoPbFragment.this.cwD().aGZ()) {
                    VideoPbFragment.this.cxP();
                } else if (VideoPbFragment.this.cDV() != null) {
                    VideoPbFragment.this.cDV().cEG();
                }
                if (z2) {
                    if (VideoPbFragment.this.jtv != null) {
                        if (VideoPbFragment.this.jtv.aHc() != null && VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.cwD().getPbData().cvu() != null && VideoPbFragment.this.cwD().getPbData().cvu().aKE() != null) {
                            MarkData aHc = VideoPbFragment.this.jtv.aHc();
                            MetaData aKE = VideoPbFragment.this.cwD().getPbData().cvu().aKE();
                            if (aHc != null && aKE != null) {
                                if (!aq.equals(TbadkCoreApplication.getCurrentAccount(), aKE.getUserId()) && !aKE.hadConcerned()) {
                                    VideoPbFragment.this.jKA.b(aKE);
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
                    VideoPbFragment.this.cxM();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b dYB = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXm() {
            if (VideoPbFragment.this.jtB == null || VideoPbFragment.this.jtB.cBz() == null || !VideoPbFragment.this.jtB.cBz().deU()) {
                return !VideoPbFragment.this.zw(aj.dzy);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jtB.cBz().deW());
            if (VideoPbFragment.this.jtK != null && (VideoPbFragment.this.jtK.aXC() || VideoPbFragment.this.jtK.aXD())) {
                VideoPbFragment.this.jtK.a(false, VideoPbFragment.this.jtB.cBC());
            }
            VideoPbFragment.this.jtB.rG(true);
            return true;
        }
    };
    private final CustomMessageListener jue = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.cwD() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.jtK != null) {
                    VideoPbFragment.this.rz(VideoPbFragment.this.jtK.aXv());
                }
                VideoPbFragment.this.cAm();
                VideoPbFragment.this.jKA.cBa();
            }
        }
    };
    private CustomMessageListener juh = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
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
    private final CustomMessageListener gZB = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.aWW) {
                VideoPbFragment.this.cyg();
            }
        }
    };
    private CustomMessageListener jux = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.cxG();
            }
        }
    };
    private CustomMessageListener jus = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.jKA != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jKA.jtS) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.jKA.bzU();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.jKA.getExtra();
                DataRes dataRes = aVar.lgE;
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
                    VideoPbFragment.this.jKA.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.jKA.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener juq = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.jKA != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jKA.jtS) {
                VideoPbFragment.this.jKA.bzU();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cwD().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cvH().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jtR.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.jKA.wF(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.jKA.cyd();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (aq.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.jtR.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener jur = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.jKA != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.jKA.jtS) {
                VideoPbFragment.this.jKA.bzU();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.jtR.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (aq.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.jtR.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b jtP = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean aXm() {
            if (VideoPbFragment.this.jtB == null || VideoPbFragment.this.jtB.cBA() == null || !VideoPbFragment.this.jtB.cBA().deU()) {
                return !VideoPbFragment.this.zw(aj.dzz);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jtB.cBA().deW());
            if (VideoPbFragment.this.jAY != null && VideoPbFragment.this.jAY.cxp() != null && VideoPbFragment.this.jAY.cxp().aXD()) {
                VideoPbFragment.this.jAY.cxp().a(VideoPbFragment.this.jtB.cBC());
            }
            VideoPbFragment.this.jtB.rH(true);
            return true;
        }
    };
    private final NewWriteModel.d dYH = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            String userId;
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                    anVar.cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId());
                }
                anVar.cI("tid", VideoPbFragment.this.cwD().cyA());
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            VideoPbFragment.this.bOT();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.cwD() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.cwD().HF(postWriteCallBackData.getPostId());
                    if (VideoPbFragment.this.cDV() != null) {
                        VideoPbFragment.this.jtX = VideoPbFragment.this.cDV().cAL();
                        VideoPbFragment.this.jKC = VideoPbFragment.this.cDV().cEJ();
                        VideoPbFragment.this.cwD().cy(VideoPbFragment.this.jtX, VideoPbFragment.this.jKC);
                    }
                }
                if (VideoPbFragment.this.dxy != null) {
                    VideoPbFragment.this.dxy.setCurrentItem(VideoPbFragment.jKh);
                }
                VideoPbFragment.this.jKA.cBa();
                VideoPbFragment.this.jtB.cBy();
                if (VideoPbFragment.this.jtK != null) {
                    VideoPbFragment.this.rz(VideoPbFragment.this.jtK.aXv());
                }
                VideoPbFragment.this.cAi();
                VideoPbFragment.this.rB(true);
                VideoPbFragment.this.cwD().cyU();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null && VideoPbFragment.this.cDV() != null) {
                            VideoPbFragment.this.cDV().cEG();
                        }
                    } else if (VideoPbFragment.this.cwD().getHostMode()) {
                        com.baidu.tieba.pb.data.e pbData = VideoPbFragment.this.cwD().getPbData();
                        if (pbData != null && pbData.cvu() != null && pbData.cvu().aKE() != null && (userId = pbData.cvu().aKE().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.cwD().cyL()) {
                            VideoPbFragment.this.cAH();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.cwD().cyL()) {
                        VideoPbFragment.this.cAH();
                    }
                    VideoPbFragment.this.cxF();
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.jtK.aXC() || VideoPbFragment.this.jtK.aXD()) {
                    VideoPbFragment.this.jtK.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jtB.f(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.iBb != null) {
                    VideoPbFragment.this.iBb.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (aaVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener dZi = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.dYx);
        }
    };
    private CustomMessageListener jug = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.jtK != null) {
                    VideoPbFragment.this.rz(VideoPbFragment.this.jtK.aXv());
                }
                VideoPbFragment.this.rB(false);
            }
        }
    };
    private int jKD = 0;
    private boolean jKH = true;
    private View.OnTouchListener jKI = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.jKD == 1) {
                if (!VideoPbFragment.this.jKH) {
                    VideoPbFragment.this.cDZ();
                    UtilHelper.showStatusBar(VideoPbFragment.this.cyk(), VideoPbFragment.this.cyk().getRootView());
                    VideoPbFragment.this.jKH = true;
                    com.baidu.adp.lib.f.e.lb().removeCallbacks(VideoPbFragment.this.jKJ);
                    com.baidu.adp.lib.f.e.lb().postDelayed(VideoPbFragment.this.jKJ, 3000L);
                }
            } else if (VideoPbFragment.this.jKD == 2 && (VideoPbFragment.this.jKH || VideoPbFragment.this.cEb())) {
                VideoPbFragment.this.cEa();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cyk(), VideoPbFragment.this.cyk().getRootView());
                VideoPbFragment.this.jKH = false;
                if (VideoPbFragment.this.jKo != null) {
                    VideoPbFragment.this.jKo.sc(false);
                }
            }
            VideoPbFragment.this.jKD = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener hiK = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.jKD = 0;
            VideoPbFragment.this.jKE = 0.0f;
            VideoPbFragment.this.jKF = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.jKE += f;
            VideoPbFragment.this.jKF += f2;
            if (VideoPbFragment.this.jKD == 0 && !VideoPbFragment.this.jKG && VideoPbFragment.this.jKo != null && !VideoPbFragment.this.jKo.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.jKF) <= Math.abs(VideoPbFragment.this.jKE) || VideoPbFragment.this.jKF > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.jKF) > Math.abs(VideoPbFragment.this.jKE) && VideoPbFragment.this.jKF > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.jKD = 2;
                    }
                } else {
                    VideoPbFragment.this.jKD = 1;
                }
            }
            return true;
        }
    };
    private Runnable jKJ = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.jKH && !VideoPbFragment.this.cEb()) {
                VideoPbFragment.this.cEa();
                UtilHelper.hideStatusBar(VideoPbFragment.this.cyk(), VideoPbFragment.this.cyk().getRootView());
                VideoPbFragment.this.jKH = false;
            }
        }
    };
    private final com.baidu.adp.base.d gqf = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.cwD() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gqa.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gqa.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.cwD().cyU();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.jHC != 1002 || bVar.fqG) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.OG, dVar.kVc, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gqa.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gqa.getLoadDataMode(), gVar.OG, gVar.kVc, false);
                    VideoPbFragment.this.jKA.aO(gVar.kVf);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener dRW = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.hcq.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d juu = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, aa aaVar, WriteData writeData, AntiData antiData) {
            if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                an anVar = new an("c13268");
                anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                    anVar.cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId());
                }
                if (VideoPbFragment.this.cwD() != null) {
                    anVar.cI("tid", VideoPbFragment.this.cwD().cyA());
                }
                anVar.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(anVar);
            }
            if (z) {
                if (VideoPbFragment.this.jtB != null) {
                    VideoPbFragment.this.jtB.cBx();
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.iBb != null) {
                    VideoPbFragment.this.iBb.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jtB != null) {
                if (VideoPbFragment.this.jAY != null && VideoPbFragment.this.jAY.cxp() != null && VideoPbFragment.this.jAY.cxp().aXD()) {
                    VideoPbFragment.this.jAY.cxp().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jtB.g(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c dYA = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void aXn() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aOK = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i;
            boolean w;
            int i2 = 3;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    an anVar = new an("c13398");
                    anVar.cI("tid", VideoPbFragment.this.cwD().cyA());
                    anVar.cI("fid", VideoPbFragment.this.cwD().getForumId());
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.af("obj_locate", 1);
                    TiebaStatic.log(anVar);
                    if (VideoPbFragment.this.jtg) {
                        VideoPbFragment.this.jtg = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.jsS != null && postData.aKE() != null && postData.cWr() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.jAY != null) {
                                    VideoPbFragment.this.jAY.cxl();
                                }
                                com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                                lVar.a(VideoPbFragment.this.cwD().getPbData().getForum());
                                lVar.setThreadData(VideoPbFragment.this.cwD().getPbData().cvu());
                                lVar.f(postData);
                                VideoPbFragment.this.jsS.d(lVar);
                                VideoPbFragment.this.jsS.setPostId(postData.getId());
                                VideoPbFragment.this.b(view, postData.aKE().getUserId(), "");
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.cwD().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.jtK != null) {
                                    VideoPbFragment.this.rz(VideoPbFragment.this.jtK.aXv());
                                }
                            }
                        }
                    }
                } else if (VideoPbFragment.this.cDV() != null && VideoPbFragment.this.cDV().cAW() != null && view == VideoPbFragment.this.cDV().cAW()) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.cwD().rf(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        VideoPbFragment.this.cDV().cAI();
                    }
                } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czI()) {
                    VideoPbFragment.this.jKA.aAi();
                } else if (VideoPbFragment.this.jKA != null && ((VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czJ()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.jKA.cBa();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.bOT();
                        VideoPbFragment.this.cAH();
                        if (view.getId() == R.id.owner_reply) {
                            w = VideoPbFragment.this.cwD().w(true, VideoPbFragment.this.cxT());
                        } else {
                            w = view.getId() == R.id.all_reply ? VideoPbFragment.this.cwD().w(false, VideoPbFragment.this.cxT()) : VideoPbFragment.this.cwD().HC(VideoPbFragment.this.cxT());
                        }
                        view.setTag(Boolean.valueOf(w));
                        if (w) {
                            VideoPbFragment.this.chm();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.efU) {
                    if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                        if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            an anVar2 = new an("c13266");
                            anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                            anVar2.cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId());
                            anVar2.cI("tid", VideoPbFragment.this.cwD().cyA());
                            anVar2.cI("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(anVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.jsV, VideoPbFragment.this.efU);
                        VideoPbFragment.this.jsV.finish();
                    }
                } else if (view == VideoPbFragment.this.jFL && VideoPbFragment.this.jKA != null) {
                    if (VideoPbFragment.this.cwD() == null || VideoPbFragment.this.cwD().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cvw = VideoPbFragment.this.cwD().getPbData().cvw();
                    if ((cvw == null || cvw.size() <= 0) && VideoPbFragment.this.cwD().cyB()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new an("c12378").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("fid", VideoPbFragment.this.cwD().getForumId()));
                    VideoPbFragment.this.jKA.cxH();
                } else if (VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czN()) {
                    if (VideoPbFragment.this.cwD() != null) {
                        VideoPbFragment.this.jKA.cBa();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.bOT();
                            VideoPbFragment.this.cAH();
                            VideoPbFragment.this.cwD().zA(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czJ()) {
                    VideoPbFragment.this.jKA.aAi();
                } else if (VideoPbFragment.this.jKA != null && ((VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czP()) || view.getId() == R.id.pb_sort_type)) {
                    VideoPbFragment.this.jKA.cBa();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.bOT();
                            VideoPbFragment.this.cAH();
                            VideoPbFragment.this.jKA.cO(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.cwD().cyS()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czH()) {
                    if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.cwD().getPbData().cvu() != null) {
                        VideoPbFragment.this.jKA.aAi();
                        TiebaStatic.log(new an("c13062"));
                        VideoPbFragment.this.jKA.Hx(VideoPbFragment.this.cwD().getPbData().cvu().aKU());
                    }
                } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czQ()) {
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
                    VideoPbFragment.this.jKA.cCd();
                } else if (VideoPbFragment.this.jKA != null && (view == VideoPbFragment.this.jKA.cAF() || (VideoPbFragment.this.jKA.cCe() != null && (view == VideoPbFragment.this.jKA.cCe().czM() || view == VideoPbFragment.this.jKA.cCe().czK())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.cwD() != null || VideoPbFragment.this.cwD().getPbData() != null) {
                        if ((VideoPbFragment.this.cwD().getPbData().cvG() == 1 || VideoPbFragment.this.cwD().getPbData().cvG() == 3) && !VideoPbFragment.this.gqa.cXf()) {
                            VideoPbFragment.this.jKA.cBa();
                            if (VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czK()) {
                                if (VideoPbFragment.this.cwD().getPbData().cvu().aKz() == 1) {
                                    i = 5;
                                } else {
                                    i = 4;
                                }
                            } else if (VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czM()) {
                                i = VideoPbFragment.this.cwD().getPbData().cvu().aKA() == 1 ? 3 : 6;
                            } else {
                                i = view == VideoPbFragment.this.jKA.cAF() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.cwD().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.cwD().getPbData().cvu().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.gqa.b(id, name, id2, i, VideoPbFragment.this.jKA.cAG());
                        }
                    }
                } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czO()) {
                    if (VideoPbFragment.this.cwD() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.jKA.cBa();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.cwD().getPbData(), VideoPbFragment.this.cwD().cyB(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.cwD().getPbData().getForum().getId(), VideoPbFragment.this.cwD().getPbData().getForum().getName(), VideoPbFragment.this.cwD().getPbData().cvu().getId(), String.valueOf(VideoPbFragment.this.cwD().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.jKA.cCe() != null && view == VideoPbFragment.this.jKA.cCe().czL()) {
                    if (VideoPbFragment.this.cwD() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.cwD().getPbData(), VideoPbFragment.this.cwD().cyB(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.jKA.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.jKA.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.jKA.aAi();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        an anVar3 = new an("c13398");
                        anVar3.cI("tid", VideoPbFragment.this.cwD().cyA());
                        anVar3.cI("fid", VideoPbFragment.this.cwD().getForumId());
                        anVar3.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar3.af("obj_locate", 4);
                        TiebaStatic.log(anVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new an("c10517").af("obj_locate", 3).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                        if (VideoPbFragment.this.jKA != null) {
                            VideoPbFragment.this.jKA.cBa();
                        }
                        PostData postData2 = (PostData) ((SparseArray) view.getTag()).get(R.id.tag_load_sub_data);
                        if (postData2 != null) {
                            if (postData2.cWD() == 1) {
                                TiebaStatic.log(new an("c12630"));
                            }
                            if (postData2.kTm != null) {
                                an aOQ = postData2.kTm.aOQ();
                                aOQ.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    aOQ.af("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    aOQ.af("obj_locate", 8);
                                }
                                TiebaStatic.log(aOQ);
                            }
                            String cyA = VideoPbFragment.this.cwD().cyA();
                            String id3 = postData2.getId();
                            int cvG = VideoPbFragment.this.cwD().getPbData() != null ? VideoPbFragment.this.cwD().getPbData().cvG() : 0;
                            VideoPbFragment.this.bOT();
                            TiebaStatic.log("c11742");
                            if (VideoPbFragment.this.cDV() != null && VideoPbFragment.this.cDV().cEI() != null) {
                                PbActivity.a HA = VideoPbFragment.this.cDV().cEI().HA(id3);
                                if (postData2 != null && VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && HA != null) {
                                    SubPbActivityConfig addBigImageData = new SubPbActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity()).createSubPbActivityConfig(cyA, id3, "pb", true, null, false, null, cvG, postData2.cDb(), VideoPbFragment.this.cwD().getPbData().getAnti(), false, postData2.aKE().getIconInfo()).addBigImageData(HA.jqh, HA.jqi, HA.jqj, HA.index);
                                    addBigImageData.setKeyFromForumId(VideoPbFragment.this.cwD().getForumId());
                                    addBigImageData.setBjhData(VideoPbFragment.this.cwD().cyI());
                                    addBigImageData.setKeyPageStartFrom(VideoPbFragment.this.cwD().czj());
                                    addBigImageData.setFromFrsForumId(VideoPbFragment.this.cwD().getFromForumId());
                                    VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply) {
                    if (VideoPbFragment.this.cwD() != null) {
                        an anVar4 = new an("c13398");
                        anVar4.cI("tid", VideoPbFragment.this.cwD().cyA());
                        anVar4.cI("fid", VideoPbFragment.this.cwD().getForumId());
                        anVar4.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar4.af("obj_locate", 6);
                        TiebaStatic.log(anVar4);
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray = (SparseArray) view.getTag();
                            if (sparseArray.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData3 = (PostData) sparseArray.get(R.id.tag_load_sub_data);
                                if (postData3.kTm != null) {
                                    an aOQ2 = postData3.kTm.aOQ();
                                    aOQ2.delete("obj_locate");
                                    aOQ2.af("obj_locate", 8);
                                    TiebaStatic.log(aOQ2);
                                }
                                if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.jsS != null && postData3.aKE() != null && postData3.cWr() != 1) {
                                    if (VideoPbFragment.this.jAY != null) {
                                        VideoPbFragment.this.jAY.cxl();
                                    }
                                    com.baidu.tieba.pb.data.l lVar2 = new com.baidu.tieba.pb.data.l();
                                    lVar2.a(VideoPbFragment.this.cwD().getPbData().getForum());
                                    lVar2.setThreadData(VideoPbFragment.this.cwD().getPbData().cvu());
                                    lVar2.f(postData3);
                                    VideoPbFragment.this.jsS.d(lVar2);
                                    VideoPbFragment.this.jsS.setPostId(postData3.getId());
                                    VideoPbFragment.this.b(view, postData3.aKE().getUserId(), "");
                                    if (VideoPbFragment.this.jtK != null) {
                                        VideoPbFragment.this.rz(VideoPbFragment.this.jtK.aXv());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.jKA != null && VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cDV() != null) {
                        VideoPbFragment.this.jKA.cBa();
                        if (VideoPbFragment.this.zx(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.cwD() != null) {
                            VideoPbFragment.this.cxO();
                            if (VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.cwD().getPbData().cvu() != null && VideoPbFragment.this.cwD().getPbData().cvu().aKE() != null) {
                                TiebaStatic.log(new an("c13402").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()).af("obj_locate", 3).cI("uid", VideoPbFragment.this.cwD().getPbData().cvu().aKE().getUserId()));
                            }
                            if (VideoPbFragment.this.cwD().getPbData().cvu() != null && VideoPbFragment.this.cwD().getPbData().cvu().aKE() != null && VideoPbFragment.this.cwD().getPbData().cvu().aKE().getUserId() != null && VideoPbFragment.this.jtv != null) {
                                int g = VideoPbFragment.this.jKA.g(VideoPbFragment.this.cwD().getPbData());
                                bj cvu = VideoPbFragment.this.cwD().getPbData().cvu();
                                if (cvu.aJt()) {
                                    i2 = 2;
                                } else if (!cvu.aJu()) {
                                    if (cvu.aMy()) {
                                        i2 = 4;
                                    } else {
                                        i2 = cvu.aMz() ? 5 : 1;
                                    }
                                }
                                TiebaStatic.log(new an("c12526").cI("tid", VideoPbFragment.this.cwD().cyA()).af("obj_locate", 1).cI("obj_id", VideoPbFragment.this.cwD().getPbData().cvu().aKE().getUserId()).af("obj_type", VideoPbFragment.this.jtv.aGZ() ? 0 : 1).af("obj_source", g).af("obj_param1", i2));
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.sa(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.jKA != null && VideoPbFragment.this.dxy != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.cwD().getPbData().cvu() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        if (VideoPbFragment.this.cwD().getPbData().cvu().aKv() != 0) {
                            int currentItem = VideoPbFragment.this.dxy.getCurrentItem();
                            if (currentItem == VideoPbFragment.jKg) {
                                VideoPbFragment.this.dxy.setCurrentItem(VideoPbFragment.jKh);
                            } else if (currentItem == VideoPbFragment.jKh) {
                                if (VideoPbFragment.this.cDV() != null && VideoPbFragment.this.bRw() != null) {
                                    an cI = new an("c13403").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView bRw = VideoPbFragment.this.bRw();
                                    boolean canScrollVertically = bRw.canScrollVertically(1);
                                    boolean canScrollVertically2 = bRw.canScrollVertically(-1);
                                    if (VideoPbFragment.this.VZ != null) {
                                        VideoPbFragment.this.VZ.setExpanded(false, true);
                                    }
                                    if (bRw.getLayoutManager() != null && (bRw.getLayoutManager() instanceof LinearLayoutManager)) {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) bRw.getLayoutManager();
                                        if (!canScrollVertically2 && canScrollVertically) {
                                            if (VideoPbFragment.this.jtq != -1 || VideoPbFragment.this.jtr != Integer.MIN_VALUE) {
                                                if (VideoPbFragment.this.jtq > 3 || (VideoPbFragment.this.jtq == 3 && VideoPbFragment.this.jtr < (-equipmentHeight))) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jtq, VideoPbFragment.this.jtr + equipmentHeight);
                                                    bRw.smoothScrollBy(0, equipmentHeight);
                                                } else if (VideoPbFragment.this.jtq >= 2) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jtq, VideoPbFragment.this.jtr + (equipmentHeight / 2));
                                                    bRw.smoothScrollBy(0, equipmentHeight / 2);
                                                } else if (VideoPbFragment.this.jtq == 1) {
                                                    linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.jtq, VideoPbFragment.this.jtr + (equipmentHeight / 4));
                                                    bRw.smoothScrollBy(0, equipmentHeight / 4);
                                                } else {
                                                    bRw.smoothScrollBy(0, -VideoPbFragment.this.jtr);
                                                }
                                                cI.af("obj_locate", 2);
                                            } else {
                                                return;
                                            }
                                        } else {
                                            int firstVisiblePosition = bRw.getFirstVisiblePosition();
                                            View childAt = bRw.getChildAt(0);
                                            int top2 = childAt == null ? 0 : childAt.getTop();
                                            VideoPbFragment.this.jtq = firstVisiblePosition;
                                            VideoPbFragment.this.jtr = top2;
                                            if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top2 < (-equipmentHeight) && bRw.getCount() >= 6)) {
                                                linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                bRw.smoothScrollToPosition(0);
                                            } else {
                                                bRw.smoothScrollToPosition(0);
                                            }
                                            cI.af("obj_locate", 1);
                                        }
                                        TiebaStatic.log(cI);
                                        TiebaStatic.log(new an("c12942").af("obj_type", 1).af("obj_locate", 4).cI("tid", VideoPbFragment.this.cwD().cyA()));
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.cwD().getPbData().cvu() != null && VideoPbFragment.this.cwD().getPbData().cvu().aKE() != null) {
                                TiebaStatic.log(new an("c13402").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()).af("obj_locate", 2).cI("uid", VideoPbFragment.this.cwD().getPbData().cvu().aKE().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.sb(false);
                        VideoPbFragment.this.cxB();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.jtX >= 0) {
                        if (VideoPbFragment.this.cwD() != null) {
                            VideoPbFragment.this.cwD().czk();
                        }
                        if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cDV() != null && VideoPbFragment.this.cDV().cEH() != null) {
                            VideoPbFragment.this.cDV().cEH().setData(VideoPbFragment.this.cwD().getPbData());
                        }
                        VideoPbFragment.this.jtX = 0;
                        VideoPbFragment.this.jKC = Integer.MIN_VALUE;
                        if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cDV() != null) {
                            VideoPbFragment.this.cDV().cB(VideoPbFragment.this.cwD().czn(), VideoPbFragment.this.cwD().czo());
                            VideoPbFragment.this.cwD().cy(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.cwD() != null) {
                        an anVar5 = new an("c13398");
                        anVar5.cI("tid", VideoPbFragment.this.cwD().cyA());
                        anVar5.cI("fid", VideoPbFragment.this.cwD().getForumId());
                        anVar5.cI("uid", TbadkCoreApplication.getCurrentAccount());
                        anVar5.af("obj_locate", 2);
                        TiebaStatic.log(anVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bc.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.aNV().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.cAm();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.cAm();
                }
            }
        }
    };
    private View.OnClickListener jqM = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.jKA != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.jKA.b(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.jKA.cI(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.jKA.b(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.jKA.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private a jKB = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void cxM() {
        if (cwD() != null && cwD().getPbData() != null && cwD().getPbData().cvu() != null) {
            bj cvu = cwD().getPbData().cvu();
            cvu.mRecomAbTag = cwD().czu();
            cvu.mRecomWeight = cwD().czs();
            cvu.mRecomSource = cwD().czt();
            cvu.mRecomExtra = cwD().czv();
            if (cvu.getFid() == 0) {
                cvu.setFid(com.baidu.adp.lib.f.b.toLong(cwD().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvu, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxF() {
        if (cwD() != null && cwD().getPbData() != null && cwD().getPbData().cvu() != null) {
            bj cvu = cwD().getPbData().cvu();
            cvu.mRecomAbTag = cwD().czu();
            cvu.mRecomWeight = cwD().czs();
            cvu.mRecomSource = cwD().czt();
            cvu.mRecomExtra = cwD().czv();
            if (cvu.getFid() == 0) {
                cvu.setFid(com.baidu.adp.lib.f.b.toLong(cwD().getForumId(), 0L));
            }
            an a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cvu, "c13563");
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
            String string = !TextUtils.isEmpty(bVar.kVc) ? bVar.kVc : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.uf(string);
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
                aVar.aMU();
            } else {
                a(0, bVar.OG, bVar.kVc, z);
            }
            if (bVar.OG) {
                if (bVar.gFx == 1) {
                    ArrayList<PostData> cvw = cwD().getPbData().cvw();
                    int size = cvw.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cvw.get(i).getId())) {
                            i++;
                        } else {
                            cvw.remove(i);
                            break;
                        }
                    }
                    cwD().getPbData().cvu().jQ(cwD().getPbData().cvu().aKv() - 1);
                    if (cDV() != null) {
                        cDV().cEG();
                    }
                } else if (bVar.gFx == 0) {
                    cxN();
                } else if (bVar.gFx == 2) {
                    ArrayList<PostData> cvw2 = cwD().getPbData().cvw();
                    int size2 = cvw2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cvw2.get(i2).cWo().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cvw2.get(i2).cWo().get(i3).getId())) {
                                i3++;
                            } else {
                                cvw2.get(i2).cWo().remove(i3);
                                cvw2.get(i2).cWq();
                                z2 = true;
                                break;
                            }
                        }
                        cvw2.get(i2).KL(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3 && cDV() != null) {
                        cDV().cEG();
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = cwD().getPbData().cvF().joL;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).cWo().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).cWo().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).cWo().remove(i2);
                    list.get(i).cWq();
                    z = true;
                    break;
                }
            }
            list.get(i).KL(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2 && cDV() != null) {
            cDV().cEG();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && cwD() != null && cwD().getPbData() != null && cwD().getPbData().cvu() != null) {
            a(this.gqa.getLoadDataMode(), gVar.OG, gVar.kVc, false);
            if (gVar.OG) {
                this.jty = true;
                if (i == 2 || i == 3) {
                    this.jtz = true;
                    this.jtA = false;
                } else if (i == 4 || i == 5) {
                    this.jtz = false;
                    this.jtA = true;
                }
                if (i == 2) {
                    cwD().getPbData().cvu().jT(1);
                    cwD().setIsGood(1);
                } else if (i == 3) {
                    cwD().getPbData().cvu().jT(0);
                    cwD().setIsGood(0);
                } else if (i == 4) {
                    cwD().getPbData().cvu().jS(1);
                    cwD().zz(1);
                } else if (i == 5) {
                    cwD().getPbData().cvu().jS(0);
                    cwD().zz(0);
                }
            }
            if (cwD().getPbData().cvu() != null && cDW() != null) {
                cDW().cED();
            }
        }
    }

    private void cxN() {
        if (cwD().cyC() || cwD().cyE()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", cwD().cyA());
            PbActivity pbActivity = this.jsV;
            PbActivity pbActivity2 = this.jsV;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, cwD().cyA()));
        if (cxQ()) {
            this.jsV.finish();
        }
    }

    private boolean cxQ() {
        if (cwD() == null) {
            return true;
        }
        if (cwD().getPbData() == null || !cwD().getPbData().cvS()) {
            if (cwD().aGZ()) {
                final MarkData cyT = cwD().cyT();
                if (cyT == null || !cwD().getIsFromMark() || bRw() == null) {
                    return true;
                }
                final MarkData zG = cwD().zG(bRw().getFirstVisiblePosition());
                if (zG == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", cyT);
                    this.jsV.setResult(-1, intent);
                    return true;
                } else if (zG.getPostId() == null || zG.getPostId().equals(cyT.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", cyT);
                    this.jsV.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.uf(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.jtv != null) {
                                if (VideoPbFragment.this.jtv.aGZ()) {
                                    VideoPbFragment.this.jtv.aHa();
                                    VideoPbFragment.this.jtv.gk(false);
                                }
                                VideoPbFragment.this.jtv.a(zG);
                                VideoPbFragment.this.jtv.gk(true);
                                VideoPbFragment.this.jtv.aHb();
                            }
                            cyT.setPostId(zG.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyT);
                            VideoPbFragment.this.jsV.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cwQ();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", cyT);
                            VideoPbFragment.this.jsV.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.cwQ();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.aMU();
                    return false;
                }
            } else if (cwD().getPbData() == null || cwD().getPbData().cvw() == null || cwD().getPbData().cvw().size() <= 0 || !cwD().getIsFromMark()) {
                return true;
            } else {
                this.jsV.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwQ() {
        this.jsV.cwQ();
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
        if (cwD() != null && this.jKA != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = cwD().getPbData()) != null) {
                bj cvu = pbData.cvu();
                if (cvu != null && cvu.aKE() != null) {
                    TiebaStatic.log(new an("c13402").cI("tid", cwD().cyA()).cI("fid", pbData.getForumId()).af("obj_locate", 4).cI("uid", cvu.aKE().getUserId()));
                }
                if (cvu != null) {
                    if (cvu.aJt()) {
                        i = 2;
                    } else if (cvu.aJu()) {
                        i = 3;
                    } else if (cvu.aMy()) {
                        i = 4;
                    } else if (cvu.aMz()) {
                        i = 5;
                    }
                    an anVar = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    anVar.cI("tid", cwD().cyA());
                    anVar.cI("uid", TbadkCoreApplication.getCurrentAccount());
                    anVar.cI("fid", cwD().getForumId());
                    if (!z) {
                        anVar.af("obj_locate", 6);
                    } else {
                        anVar.af("obj_locate", 5);
                    }
                    anVar.af("obj_name", i);
                    anVar.af("obj_type", 2);
                    if (cvu != null) {
                        if (cvu.aJt()) {
                            anVar.af("obj_type", 10);
                        } else if (cvu.aJu()) {
                            anVar.af("obj_type", 9);
                        } else if (cvu.aMz()) {
                            anVar.af("obj_type", 8);
                        } else if (cvu.aMy()) {
                            anVar.af("obj_type", 7);
                        } else if (cvu.isShareThread) {
                            anVar.af("obj_type", 6);
                        } else if (cvu.threadType == 0) {
                            anVar.af("obj_type", 1);
                        } else if (cvu.threadType == 40) {
                            anVar.af("obj_type", 2);
                        } else if (cvu.threadType == 49) {
                            anVar.af("obj_type", 3);
                        } else if (cvu.threadType == 54) {
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
                    } else if (cwD().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cvw = pbData.cvw();
                        if ((cvw == null || cvw.size() <= 0) && cwD().cyB()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.jKA.cBa();
                        bOT();
                        TiebaStatic.log(new an("c11939"));
                        if (!AntiHelper.d(getContext(), cvu)) {
                            if (this.jAx != null) {
                                this.jAx.setEnable(false);
                                t(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                zy(z ? 2 : 1);
                                return;
                            }
                            this.jKA.showLoadingDialog();
                            cwD().cze().y(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                an anVar2 = new an(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                anVar2.cI("tid", cwD().cyA());
                anVar2.cI("uid", TbadkCoreApplication.getCurrentAccount());
                anVar2.cI("fid", cwD().getForumId());
                if (!z) {
                }
                anVar2.af("obj_name", i);
                anVar2.af("obj_type", 2);
                if (cvu != null) {
                }
                if (!aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                TiebaStatic.log(anVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment cDB() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        G(eVar.cEh());
        H(eVar.cEh());
        if (cwD() != null && cwD().getPbData() != null) {
            boolean isFromMark = cwD().getIsFromMark();
            com.baidu.tieba.pb.data.e pbData = cwD().getPbData();
            if (isFromMark) {
                PostData F = F(pbData);
                if (pbData.aGY() != null && !pbData.aGY().equals(F.getId()) && this.dxy != null) {
                    this.dxy.setCurrentItem(jKh);
                }
            }
        }
        eVar.cEi().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bj bjVar) {
                if (bjVar != null && bjVar.aKV() != null) {
                    if (VideoPbFragment.this.jKo.getVideoUrl() == null || !VideoPbFragment.this.jKo.getVideoUrl().equals(bjVar.aKV().video_url)) {
                        if (!aq.isEmpty(VideoPbFragment.this.jKo.getVideoUrl())) {
                            VideoPbFragment.this.jti = true;
                            VideoPbFragment.this.dxy.setCurrentItem(VideoPbFragment.jKg);
                        }
                        if (VideoPbFragment.this.jKp == null || !VideoPbFragment.this.jKp.isPlaying()) {
                            VideoPbFragment.this.cDC();
                            VideoPbFragment.this.aN(bjVar);
                        }
                        VideoPbFragment.this.cDD();
                        if (VideoPbFragment.this.jKp.cEv()) {
                            VideoPbFragment.this.jKp.start();
                        }
                        boolean z = !aq.equals(VideoPbFragment.this.jKo.getVideoUrl(), bjVar.aKV().video_url);
                        VideoPbFragment.this.jKo.setData(bjVar);
                        VideoPbFragment.this.jKo.sj(VideoPbFragment.this.dxy.getCurrentItem() == 0);
                        if (z) {
                            VideoPbFragment.this.jKo.startPlay();
                            VideoPbFragment.this.jKo.cEZ();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.jKo.setData(bjVar);
                }
            }
        });
        eVar.cEr().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: p */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.dxy.setCurrentItem(num.intValue());
            }
        });
        eVar.cEm().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.jKo.aS(bjVar);
            }
        });
        eVar.cEn().observe(this, new q<bj>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bj bjVar) {
                VideoPbFragment.this.jKo.aT(bjVar);
            }
        });
        eVar.cEo().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.cDO();
            }
        });
        eVar.cEp().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: l */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDC() {
        ViewGroup.LayoutParams layoutParams = this.jKr.getLayoutParams();
        layoutParams.height = 0;
        this.jKr.setLayoutParams(layoutParams);
        this.jKr.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDD() {
        if (this.jKp == null) {
            this.jKp = new f(getBaseFragmentActivity(), this.jKn);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(cyk()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.jKn.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.jKp.c(eVar.cEj(), rect);
            if (this.jKp.cEv()) {
                this.jKp.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (eVar.cEk() || VideoPbFragment.this.cwD().getTabIndex() == VideoPbFragment.jKh) {
                            VideoPbFragment.this.dxy.setCurrentItem(VideoPbFragment.jKh);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (eVar.cEk() || VideoPbFragment.this.cwD().getTabIndex() == VideoPbFragment.jKh) {
                            VideoPbFragment.this.dxy.setCurrentItem(VideoPbFragment.jKh);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (eVar.cEk() || cwD().getTabIndex() == jKh) {
                this.dxy.setCurrentItem(jKh);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.jKG && (this.jKH || cEb())) {
            cEa();
            UtilHelper.hideStatusBar(cyk(), cyk().getRootView());
            this.jKH = false;
            if (this.jKo != null) {
                this.jKo.sc(false);
            }
        }
        if (i == 4) {
            return this.jKo.onBackPress();
        }
        if (i == 24) {
            return this.jKo.cEV();
        }
        if (i == 25) {
            return this.jKo.cEW();
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
        Rect czw;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bjVar != null && bjVar.aKV() != null) {
            int intValue = bjVar.aKV().video_width.intValue();
            int intValue2 = bjVar.aKV().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (cwD() != null || (czw = cwD().czw()) == null) ? ceil : czw.height();
                i = 0;
                layoutParams = this.jKn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.jKn.setLayoutParams(layoutParams);
                this.jKn.setMaxHeight(ceil);
                this.jKn.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.jKn.setOriginHeight(height);
                layoutParams2 = (RelativeLayout.LayoutParams) this.jKj.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(-1, jKi);
                } else {
                    layoutParams2.height = jKi;
                }
                this.jKj.setLayoutParams(layoutParams2);
                layoutParams3 = (CoordinatorLayout.LayoutParams) this.VZ.getLayoutParams();
                int i2 = ceil + jKi;
                if (layoutParams3 != null) {
                    layoutParams3 = new CoordinatorLayout.LayoutParams(-1, i2);
                } else {
                    layoutParams3.height = i2;
                }
                this.VZ.setLayoutParams(layoutParams3);
                if (i == 0 && (this.VZ.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.VZ.getLayoutParams()).getBehavior();
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
        if (cwD() != null) {
        }
        i = 0;
        layoutParams = this.jKn.getLayoutParams();
        if (layoutParams != null) {
        }
        this.jKn.setLayoutParams(layoutParams);
        this.jKn.setMaxHeight(ceil2);
        this.jKn.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.jKn.setOriginHeight(height);
        layoutParams2 = (RelativeLayout.LayoutParams) this.jKj.getLayoutParams();
        if (layoutParams2 != null) {
        }
        this.jKj.setLayoutParams(layoutParams2);
        layoutParams3 = (CoordinatorLayout.LayoutParams) this.VZ.getLayoutParams();
        int i22 = ceil2 + jKi;
        if (layoutParams3 != null) {
        }
        this.VZ.setLayoutParams(layoutParams3);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.jtc = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ak(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.jtR = new com.baidu.tbadk.core.view.d();
        this.jtR.toastTime = 1000L;
        if (this.jKA != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.jKA.jtS;
            userMuteAddAndDelCustomMessage.setTag(this.jKA.jtS);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.jKA.jtS;
            userMuteCheckCustomMessage.setTag(this.jKA.jtS);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        com.baidu.tieba.s.c.cVr().w(getUniqueId());
    }

    private void initData() {
        this.jtv = com.baidu.tbadk.baseEditMark.a.a(this.jsV);
        if (this.jtv != null) {
            this.jtv.a(this.juy);
        }
        this.gqa = new ForumManageModel(this.jsV);
        this.gqa.setLoadDataCallBack(this.gqf);
        this.dzD = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.jKA = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ak(Bundle bundle) {
        this.jtJ = new g();
        d(this.jtJ);
        this.jtK = (com.baidu.tbadk.editortools.pb.e) this.jtJ.dI(getActivity());
        this.jtK.a(this.jsV.getPageContext());
        this.jtK.a(this.dYH);
        this.jtK.a(this.dYA);
        this.jtK.a(this.jsV.getPageContext(), bundle);
        this.jtK.aWP().c(new com.baidu.tbadk.editortools.j(getActivity()));
        this.jtK.aWP().hA(true);
        qU(true);
        this.jtK.a(cwD().cyP(), cwD().cyA(), cwD().czg());
        registerListener(this.juh);
        registerListener(this.jux);
        registerListener(this.jug);
        registerListener(this.jue);
        registerListener(this.gZB);
        if (!cwD().cyG()) {
            this.jtK.wA(cwD().cyA());
        }
        if (cwD().czh()) {
            this.jtK.wy(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.jtK.wy(cAo());
        }
        this.jtB = new ap();
        if (this.jtK.aXo() != null) {
            this.jtB.d(this.jtK.aXo().getInputView());
        }
        this.jtK.a(this.dYB);
        this.iBb = new aj(getPageContext());
        this.iBb.a(new aj.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
            @Override // com.baidu.tbadk.core.util.aj.a
            public void m(boolean z, int i) {
                if (z) {
                    if (i == aj.dzy) {
                        VideoPbFragment.this.jtK.a((String) null, (WriteData) null);
                    } else if (i == aj.dzz && VideoPbFragment.this.jAY != null && VideoPbFragment.this.jAY.cxp() != null) {
                        VideoPbFragment.this.jAY.cxp().aXK();
                    } else if (i == aj.dzA) {
                        VideoPbFragment.this.c(VideoPbFragment.this.jtN);
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
        this.hcq = new com.baidu.tieba.f.b(getActivity());
        this.hcq.a(juH);
        this.jKG = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        blF();
        this.VZ = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.jKl = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.jKn = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.jKo = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.jKn);
        this.jKo.setUniqueId(getUniqueId());
        this.jKo.ad(this);
        this.jKo.cP(cyk().getRootView());
        this.jKo.cQ(this.jKq);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.jKj = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.jKr = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.dxy = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.jKm = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.jKm.setOnClickListener(this.aOK);
        cDF();
        cDE();
        cDG();
        this.jKk = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.dxy.setAdapter(this.jKk);
        this.jKj.setViewPager(this.dxy);
        this.jKj.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (VideoPbFragment.this.cDV() != null) {
                        VideoPbFragment.this.cDV().si(false);
                    }
                    if (VideoPbFragment.this.cDW() != null) {
                        VideoPbFragment.this.cDW().si(true);
                        VideoPbFragment.this.Ae(VideoPbFragment.this.cDW().cEF() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.cEo() != null && eVar.cEo().getValue() != null && eVar.cEo().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.jKo.sj(z);
                    VideoPbFragment.this.cAm();
                    if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                        TiebaStatic.log(new an("c13592").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.cDW() != null) {
                        VideoPbFragment.this.cDW().si(false);
                    }
                    if (VideoPbFragment.this.cDV() != null) {
                        VideoPbFragment.this.cDV().si(true);
                        int cEF = VideoPbFragment.this.cDV().cEF();
                        int cEK = VideoPbFragment.this.cDV().cEK();
                        if (cEF != 0) {
                            VideoPbFragment.this.Ae(8);
                            VideoPbFragment.this.cDV().Ae(0);
                        } else if (cEK != 0) {
                            VideoPbFragment.this.cDV().Ae(8);
                            VideoPbFragment.this.Ae(0);
                        } else {
                            VideoPbFragment.this.cDV().Ae(8);
                            VideoPbFragment.this.Ae(8);
                        }
                    }
                    VideoPbFragment.this.jKo.sj(false);
                    VideoPbFragment.this.VZ.setExpanded(false, true);
                    if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                        TiebaStatic.log(new an("c13593").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.jKk.Ag(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.jAb = this.rootView.findViewById(R.id.viewstub_progress);
        cDH();
        cDI();
        if (!this.jKG && this.jKH) {
            cEa();
            UtilHelper.hideStatusBar(cyk(), cyk().getRootView());
            this.jKH = false;
        }
    }

    private void cDE() {
        this.jKt = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.jKx = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.jKu = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.jKv = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.jKw = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.jKx.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.jKx.setConrers(15);
        this.jKw.setConfig(new com.baidu.tbadk.core.view.commonBtn.d());
        this.jKv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TiebaStatic.log(new an("c13591"));
                VideoPbFragment.this.cDQ();
            }
        });
        this.jKw.setOnClickListener(this.jKs);
        this.jKr.setOnClickListener(this.jKs);
    }

    private void cDF() {
        this.jKj.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.jKj.setContainerLayoutParams(layoutParams);
        this.jKj.setRectPaintColor(R.color.cp_link_tip_a);
        this.jKj.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.jKj.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.jKj.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.jKj.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.jKj.setExpandedTabLayoutParams(layoutParams2);
    }

    public void sb(boolean z) {
        if (this.VZ != null) {
            this.VZ.setExpanded(z);
        }
    }

    private void cDG() {
        this.jAs = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.jAt = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.jAA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.jAB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.hSi = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.hSi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.sb(false);
                VideoPbFragment.this.cxB();
                if (VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null && VideoPbFragment.this.cwD().getPbData().cvu() != null && VideoPbFragment.this.cwD().getPbData().cvu().aKE() != null) {
                    TiebaStatic.log(new an("c13402").cI("tid", VideoPbFragment.this.cwD().cyA()).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()).af("obj_locate", 1).cI("uid", VideoPbFragment.this.cwD().getPbData().cvu().aKE().getUserId()));
                }
            }
        });
        this.jAu = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.jAu.setOnClickListener(this.aOK);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.jAv = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.jAv.setOnClickListener(this.aOK);
        if (booleanExtra) {
            this.jAv.setVisibility(8);
        } else {
            this.jAv.setVisibility(0);
        }
        this.jAw = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.jAw.setOnClickListener(this.aOK);
        this.jAx = new com.baidu.tieba.pb.view.c(this.jAw);
        this.jAx.cFj();
        this.jAy = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        rB(false);
    }

    private void blF() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.bOU();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.jKq = this.rootView.findViewById(R.id.status_bar_background);
        if (this.jKG) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(cyk());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.jKq.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(cyk());
            this.jKq.setLayoutParams(layoutParams2);
            this.jKq.setVisibility(0);
        }
        this.efU = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aOK);
        this.fjA = (ImageView) this.efU.findViewById(R.id.widget_navi_back_button);
        SvgManager.aOU().a(this.fjA, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jFL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aOK);
        this.adY = (ImageView) this.jFL.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jFL.setLayoutParams(layoutParams3);
        SvgManager.aOU().a(this.adY, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jFL.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.hiK);
        this.mNavigationBar.setOnTouchListener(this.jKI);
    }

    public void cDH() {
        setEditorTools(this.jtK.aWP());
    }

    private void cDI() {
        this.jsS = new PbFakeFloorModel(getPageContext());
        this.jAY = new s(getPageContext(), this.jsS, this.rootView);
        this.jAY.a(this.juu);
        this.jsS.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void p(PostData postData) {
                VideoPbFragment.this.jsS.q(postData);
                if (VideoPbFragment.this.cDV() != null) {
                    VideoPbFragment.this.cDV().cEG();
                }
                VideoPbFragment.this.jAY.cxl();
                VideoPbFragment.this.Za.aVs();
                VideoPbFragment.this.rB(false);
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.jsV = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (cwD() != null) {
            cwD().au(bundle);
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
        this.aWW = true;
        getVoiceManager().onPause(getPageContext());
        this.jKo.nV(true);
        if (cwD() != null && !cwD().cyG()) {
            this.jtK.wz(cwD().cyA());
        }
        com.baidu.tbadk.BdToken.c.aFN().aFS();
        MessageManager.getInstance().unRegisterListener(this.juq);
        MessageManager.getInstance().unRegisterListener(this.jur);
        MessageManager.getInstance().unRegisterListener(this.jus);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.aWW = false;
        getVoiceManager().onResume(getPageContext());
        this.jKo.nV(false);
        cyg();
        registerListener(this.juq);
        registerListener(this.jur);
        registerListener(this.jus);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.jKk != null && this.dxy != null) {
            this.jKk.Ag(z ? this.dxy.getCurrentItem() : -1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.cVr().x(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.jAx != null) {
            this.jAx.onDestroy();
        }
        if (this.gqa != null) {
            this.gqa.cancelLoadData();
        }
        if (this.jKo != null) {
            this.jKo.onDestroy();
        }
        if (this.jtm != null) {
            this.jtm.cancelLoadData();
        }
        if (this.iBb != null) {
            this.iBb.onDestroy();
        }
        if (cwD() != null) {
            cwD().cancelLoadData();
            cwD().destory();
            if (cwD().czd() != null) {
                cwD().czd().onDestroy();
            }
        }
        if (this.jtK != null) {
            this.jtK.onDestroy();
        }
        this.jtR = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.jsV);
        this.jKj.onChangeSkinType();
        am.setBackgroundColor(this.jKj, R.color.cp_bg_line_h);
        this.jtB.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.jKp == null || !this.jKp.isPlaying()) {
            am.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        am.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        am.setBackgroundColor(this.jKq, R.color.cp_mask_b_alpha66);
        if (this.Za != null) {
            this.Za.onChangeSkinType(i);
        }
        if (this.jAY != null) {
            this.jAY.onChangeSkinType(i);
        }
        if (this.hSi != null) {
            am.setViewTextColor(this.hSi, (int) R.color.cp_cont_d);
            this.hSi.setBackgroundDrawable(am.aB(l.getDimens(getContext(), R.dimen.tbds47), am.getColor(R.color.cp_bg_line_j)));
        }
        if (this.jAv != null && cwD() != null) {
            if (cwD().aGZ()) {
                SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.jAu != null) {
            SvgManager.aOU().a(this.jAu, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (cwD() != null) {
            t(cwD().getPbData());
        }
        am.setViewTextColor(this.jAy, (int) R.color.cp_cont_b);
        if (this.jAs != null) {
            am.setBackgroundResource(this.jAs, R.drawable.bottom_shadow);
        }
        am.setBackgroundColor(this.jAt, R.color.cp_bg_line_h);
        if (cDV() != null) {
            cDV().onChangeSkinType(i);
        }
        if (cDW() != null) {
            cDW().onChangeSkinType(i);
        }
        if (this.jKl != null) {
            am.setBackgroundResource(this.jKl, R.drawable.personalize_tab_shadow);
        }
        if (this.jKr != null) {
            am.setBackgroundColor(this.jKr, R.color.cp_bg_line_g);
        }
        if (this.jKv != null) {
            SvgManager.aOU().a(this.jKv, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.jKt != null) {
            am.setViewTextColor(this.jKt, (int) R.color.cp_cont_b);
        }
        if (this.jKu != null) {
            am.setViewTextColor(this.jKu, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gYp == null) {
            this.gYp = VoiceManager.instance();
        }
        return this.gYp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOT() {
        if (this.gYp != null) {
            this.gYp.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment cyi() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment cyj() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel cwD() {
        return this.jsV.cwD();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity cyk() {
        return this.jsV;
    }

    public com.baidu.tbadk.baseEditMark.a cDJ() {
        return this.jtv;
    }

    public View.OnClickListener cDK() {
        return this.aOK;
    }

    public View.OnClickListener cDL() {
        return this.jqM;
    }

    public View.OnLongClickListener cDM() {
        return this.jKA.cDM();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (as.HP(objArr[i].getLink()) && (drawable = am.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView bRw() {
        Iterator<BaseFragment> it = this.jKk.cEf().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void qU(boolean z) {
        this.jtK.hE(z);
        this.jtK.hF(z);
        this.jtK.hG(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.jKA != null) {
            if (z) {
                this.jKA.cBa();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.jKA.cBb();
            } else {
                this.jKA.cBa();
            }
        }
    }

    public boolean zw(int i) {
        if (this.iBb == null || cwD() == null || cwD().getPbData() == null || cwD().getPbData().getAnti() == null) {
            return true;
        }
        return this.iBb.aA(cwD().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean cxD() {
        if ((cwD() != null && cwD().getPbData().cvS()) || this.iBb == null || cwD() == null || cwD().getPbData() == null || cwD().getPbData().getAnti() == null) {
            return true;
        }
        return this.iBb.kz(cwD().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && cwD() != null) {
            gVar.setForumName(cwD().cwu());
            if (cwD().getPbData() != null && cwD().getPbData().getForum() != null) {
                gVar.a(cwD().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(cwD());
        }
    }

    public void cAC() {
        if (this.Za != null) {
            this.Za.display();
            if (this.jtK != null) {
                this.jtK.aXs();
            }
            cBk();
        }
    }

    private boolean cxA() {
        PbModel cwD = cwD();
        if (cwD == null || cwD.getPbData() == null) {
            return false;
        }
        bj cvu = cwD.getPbData().cvu();
        cwD.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cvu);
    }

    public void cxB() {
        if (checkUpIsLogin() && cwD() != null && cwD().getPbData() != null && cwD().getPbData().getForum() != null && !cxA()) {
            if (cwD().getPbData().cvS()) {
                caq();
                return;
            }
            if (this.hbV == null) {
                this.hbV = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.hbV.ut(0);
                this.hbV.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mF(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void u(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void mG(boolean z) {
                        if (z) {
                            VideoPbFragment.this.caq();
                        }
                    }
                });
            }
            this.hbV.E(cwD().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cwD().cyA(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.jtK.onActivityResult(i, i2, intent);
        if (this.jtm != null) {
            this.jtm.onActivityResult(i, i2, intent);
        }
        if (this.jAY != null) {
            this.jAY.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    cxO();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.cMU().D(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.jtN = emotionImageData;
                        if (zw(aj.dzA)) {
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
        if (cyk() != null) {
            if (this.jKH && !TbSingleton.getInstance().isNotchScreen(cyk()) && !TbSingleton.getInstance().isCutoutScreen(cyk())) {
                cEa();
                UtilHelper.hideStatusBar(cyk(), cyk().getRootView());
                this.jKH = false;
            }
            this.jKB.jKU = z;
            cDN();
            cDO();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.jsV;
        if (i == 0) {
            cAi();
            if (this.jAY != null) {
                this.jAY.cxl();
            }
            rB(false);
        }
        cAm();
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
                        this.jtK.resetData();
                        this.jtK.setVoiceModel(pbEditorData.getVoiceModel());
                        this.jtK.b(writeData);
                        com.baidu.tbadk.editortools.l mD = this.jtK.aWP().mD(6);
                        if (mD != null && mD.dWH != null) {
                            mD.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.jsV;
                        if (i == -1) {
                            this.jtK.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.jAY != null && this.jAY.cxp() != null) {
                            com.baidu.tbadk.editortools.pb.h cxp = this.jAY.cxp();
                            cxp.setThreadData(cwD().getPbData().cvu());
                            cxp.b(writeData);
                            cxp.setVoiceModel(pbEditorData.getVoiceModel());
                            com.baidu.tbadk.editortools.l mD2 = cxp.aWP().mD(6);
                            if (mD2 != null && mD2.dWH != null) {
                                mD2.dWH.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.jsV;
                            if (i == -1) {
                                cxp.aXK();
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
                if (cwD() != null && !cwD().cyG()) {
                    antiData.setBlock_forum_name(cwD().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(cwD().getPbData().getForum().getId());
                    antiData.setUser_name(cwD().getPbData().getUserData().getUserName());
                    antiData.setUser_id(cwD().getPbData().getUserData().getUserId());
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
            if (this.jKA != null) {
                this.jKA.wF(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void cym() {
        if (cwD() != null && this.jsV != null) {
            if (this.jtK == null || !this.jtK.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.jtK = (com.baidu.tbadk.editortools.pb.e) dVar.dI(getContext());
                this.jtK.a(this.jsV.getPageContext());
                this.jtK.a(this.dYH);
                this.jtK.a(this.dYA);
                this.jtK.a(this.jsV.getPageContext(), this.jsV.getIntent() == null ? null : this.jsV.getIntent().getExtras());
                this.jtK.aWP().hA(true);
                setEditorTools(this.jtK.aWP());
                if (!cwD().cyG()) {
                    this.jtK.wA(cwD().cyA());
                }
                if (cwD().czh()) {
                    this.jtK.wy(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.jtK.wy(cAo());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.Za = editorTools;
        this.Za.setId(R.id.pb_editor);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.Za.getParent() == null) {
            this.rootView.addView(this.Za, layoutParams);
        }
        this.Za.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.Za.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof com.baidu.tbadk.coreExtra.data.q) {
                    if (((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRY() == EmotionGroupType.BIG_EMOTION || ((com.baidu.tbadk.coreExtra.data.q) aVar.data).aRY() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.jtK.c((com.baidu.tbadk.coreExtra.data.q) aVar.data);
                            VideoPbFragment.this.jtK.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        cAi();
        this.jtK.b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.Za != null && VideoPbFragment.this.Za.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.jtB != null && VideoPbFragment.this.jtB.cBz() != null) {
                    if (!VideoPbFragment.this.jtB.cBz().deV()) {
                        VideoPbFragment.this.jtB.rG(false);
                    }
                    VideoPbFragment.this.jtB.cBz().uO(false);
                }
            }
        });
    }

    public void caq() {
        if (!checkUpIsLogin()) {
            if (cwD() != null) {
                TiebaStatic.log(new an("c10517").af("obj_locate", 2).cI("fid", cwD().getForumId()));
            }
        } else if (cxD()) {
            if (this.jtK != null && (this.jtK.aXC() || this.jtK.aXD())) {
                this.jtK.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.Za != null) {
                cAC();
                this.jKB.jKT = false;
                if (this.Za.mD(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.Za.mD(2).dWH, false, null);
                }
            }
            cBk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(View view, final String str, final String str2) {
        if (view != null && str != null && str2 != null && !cxA() && cxD()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.jto);
                this.jtp = ((View) view.getParent()).getMeasuredHeight();
            }
            if (cwD() != null && cwD().getPbData() != null && cwD().getPbData().cvS()) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.jsV.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        VideoPbFragment.this.bRw().smoothScrollBy(0, (VideoPbFragment.this.jto[1] + VideoPbFragment.this.jtp) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jAY != null) {
                            VideoPbFragment.this.jtK.aWP().setVisibility(8);
                            VideoPbFragment.this.jAY.g(str, str2, VideoPbFragment.this.cAo(), (VideoPbFragment.this.cwD() == null || VideoPbFragment.this.cwD().getPbData() == null || VideoPbFragment.this.cwD().getPbData().cvu() == null || !VideoPbFragment.this.cwD().getPbData().cvu().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxp = VideoPbFragment.this.jAY.cxp();
                            if (cxp != null && VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                                cxp.a(VideoPbFragment.this.cwD().getPbData().getAnti());
                                cxp.setThreadData(VideoPbFragment.this.cwD().getPbData().cvu());
                            }
                            if (VideoPbFragment.this.jtB.cBB() == null && VideoPbFragment.this.jAY.cxp().aXS() != null) {
                                VideoPbFragment.this.jAY.cxp().aXS().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jtB != null && VideoPbFragment.this.jtB.cBA() != null) {
                                            if (!VideoPbFragment.this.jtB.cBA().deV()) {
                                                VideoPbFragment.this.jtB.rH(false);
                                            }
                                            VideoPbFragment.this.jtB.cBA().uO(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jtB.e(VideoPbFragment.this.jAY.cxp().aXS().getInputView());
                                VideoPbFragment.this.jAY.cxp().a(VideoPbFragment.this.jtP);
                            }
                        }
                        VideoPbFragment.this.cBk();
                    }
                }, 0L);
                return;
            }
            if (this.jtM == null) {
                this.jtM = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jtM.ut(1);
                this.jtM.a(new AnonymousClass43(str, str2));
            }
            if (cwD() != null && cwD().getPbData() != null && cwD().getPbData().getForum() != null) {
                this.jtM.E(cwD().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(cwD().cyA(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$43  reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass43 implements c.a {
        final /* synthetic */ String juT;
        final /* synthetic */ String juU;

        AnonymousClass43(String str, String str2) {
            this.juT = str;
            this.juU = str2;
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
                        VideoPbFragment.this.bRw().smoothScrollBy(0, (VideoPbFragment.this.jto[1] + VideoPbFragment.this.jtp) - (equipmentHeight - dimens));
                        if (VideoPbFragment.this.jAY != null) {
                            VideoPbFragment.this.jtK.aWP().setVisibility(8);
                            VideoPbFragment.this.jAY.g(AnonymousClass43.this.juT, AnonymousClass43.this.juU, VideoPbFragment.this.cAo(), (VideoPbFragment.this.cwD() == null || VideoPbFragment.this.cwD().getPbData() == null || VideoPbFragment.this.cwD().getPbData().cvu() == null || !VideoPbFragment.this.cwD().getPbData().cvu().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h cxp = VideoPbFragment.this.jAY.cxp();
                            if (cxp != null && VideoPbFragment.this.cwD() != null && VideoPbFragment.this.cwD().getPbData() != null) {
                                cxp.a(VideoPbFragment.this.cwD().getPbData().getAnti());
                                cxp.setThreadData(VideoPbFragment.this.cwD().getPbData().cvu());
                            }
                            if (VideoPbFragment.this.jtB.cBB() == null && VideoPbFragment.this.jAY.cxp().aXS() != null) {
                                VideoPbFragment.this.jAY.cxp().aXS().c(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jtB != null && VideoPbFragment.this.jtB.cBA() != null) {
                                            if (!VideoPbFragment.this.jtB.cBA().deV()) {
                                                VideoPbFragment.this.jtB.rH(false);
                                            }
                                            VideoPbFragment.this.jtB.cBA().uO(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jtB.e(VideoPbFragment.this.jAY.cxp().aXS().getInputView());
                                VideoPbFragment.this.jAY.cxp().a(VideoPbFragment.this.jtP);
                            }
                        }
                        VideoPbFragment.this.cBk();
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
            String userId = F.aKE().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvG()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (F.aKE() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, F.aKE().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, F.aKE().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, F.aKE().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, F.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, F.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(eVar.cvG()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bf> cvN = eVar.cvN();
                if (v.getCount(cvN) > 0) {
                    sb = new StringBuilder();
                    for (bf bfVar : cvN) {
                        if (bfVar != null && !StringUtils.isNull(bfVar.getForumName()) && (wVar = bfVar.dqj) != null && wVar.dod && !wVar.doe && (wVar.type == 1 || wVar.type == 2)) {
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
    public void cxO() {
        MarkData zG;
        if (cwD() != null && cwD().getPbData() != null && cDV() != null && this.jtv != null) {
            if (cwD().getPbData() != null && cwD().getPbData().cvS()) {
                zG = cwD().zG(0);
            } else if (this.dxy != null && this.dxy.getCurrentItem() == jKg) {
                zG = cwD().l(F(cwD().getPbData()));
            } else {
                zG = cwD().zG(cDV().cAM());
            }
            if (zG != null) {
                if (!zG.isApp() || (zG = cwD().zG(cDV().cAM() + 1)) != null) {
                    cAH();
                    this.jtv.a(zG);
                    if (!this.jtv.aGZ()) {
                        this.jtv.aHb();
                        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                        return;
                    }
                    this.jtv.aHa();
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
            if (this.jtm == null) {
                this.jtm = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.jsV);
                this.jtm.b(this.dYA);
                this.jtm.c(this.dYH);
            }
            this.jtm.a(emotionImageData, cwD(), cwD().getPbData());
        }
    }

    public PostData F(com.baidu.tieba.pb.data.e eVar) {
        PostData postData;
        if (eVar == null) {
            return null;
        }
        if (eVar.cvE() != null) {
            return eVar.cvE();
        }
        if (!v.isEmpty(eVar.cvw())) {
            Iterator<PostData> it = eVar.cvw().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.cWr() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = eVar.cvB();
        }
        if (postData == null) {
            postData = a(eVar);
        }
        if (postData != null && postData.aKE() != null && postData.aKE().getUserTbVipInfoData() != null && postData.aKE().getUserTbVipInfoData().getvipIntro() != null) {
            postData.aKE().getGodUserData().setIntro(postData.aKE().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.e eVar) {
        MetaData metaData;
        if (eVar == null || eVar.cvu() == null || eVar.cvu().aKE() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData aKE = eVar.cvu().aKE();
        String userId = aKE.getUserId();
        HashMap<String, MetaData> userMap = eVar.cvu().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = aKE;
        }
        postData.Di(1);
        postData.setId(eVar.cvu().aKU());
        postData.setTitle(eVar.cvu().getTitle());
        postData.setTime(eVar.cvu().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String cxT() {
        ArrayList<PostData> cvw;
        int count;
        int i;
        if (cwD() == null || cwD().getPbData() == null || cwD().getPbData().cvw() == null || (count = v.getCount((cvw = cwD().getPbData().cvw()))) == 0) {
            return "";
        }
        if (cwD().cyR()) {
            Iterator<PostData> it = cvw.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.cWr() == 1) {
                    return next.getId();
                }
            }
        }
        if (bRw() == null) {
            i = 0;
        } else {
            i = cDV().cAL();
        }
        PostData postData = (PostData) v.getItem(cvw, i);
        if (postData == null || postData.aKE() == null) {
            return "";
        }
        if (cwD().HD(postData.aKE().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) v.getItem(cvw, i2);
            if (postData2 == null || postData2.aKE() == null || postData2.aKE().getUserId() == null) {
                break;
            } else if (cwD().HD(postData2.aKE().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) v.getItem(cvw, i3);
            if (postData3 == null || postData3.aKE() == null || postData3.aKE().getUserId() == null) {
                return "";
            }
            if (cwD().HD(postData3.aKE().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxP() {
        if (cwD() != null) {
            com.baidu.tieba.pb.data.e pbData = cwD().getPbData();
            cwD().rh(true);
            if (this.jtv != null) {
                pbData.Hq(this.jtv.aGY());
            }
            if (cDV() != null) {
                cDV().cEG();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (cwD() != null) {
            cAJ();
            cwD().rh(z);
            if (this.jtv != null) {
                this.jtv.gk(z);
                if (markData != null) {
                    this.jtv.a(markData);
                }
            }
            if (cwD().aGZ()) {
                cxP();
            } else if (cDV() != null) {
                cDV().cEG();
            }
        }
    }

    public void b(com.baidu.tieba.pb.data.l lVar) {
        MetaData metaData;
        boolean z = true;
        if (cwD() != null && cwD().getPbData() != null && lVar.cwh() != null) {
            String id = lVar.cwh().getId();
            ArrayList<PostData> cvw = cwD().getPbData().cvw();
            int i = 0;
            while (true) {
                if (i >= cvw.size()) {
                    break;
                }
                PostData postData = cvw.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cwl = lVar.cwl();
                    postData.Dh(lVar.getTotalCount());
                    if (postData.cWo() != null && cwl != null) {
                        Iterator<PostData> it = cwl.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.aKE() != null && (metaData = postData.getUserMap().get(next.aKE().getUserId())) != null) {
                                next.a(metaData);
                                next.tW(true);
                                next.a(getPageContext(), cwD().HD(metaData.getUserId()));
                            }
                        }
                        boolean z2 = cwl.size() != postData.cWo().size();
                        postData.cWo().clear();
                        postData.cWo().addAll(cwl);
                        z = z2;
                    }
                    if (postData.cWk() != null) {
                        postData.cWl();
                    }
                }
            }
            if (!cwD().getIsFromMark() && z && cDV() != null) {
                cDV().cEG();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxG() {
        if (cwD() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Ka(cwD().getForumId()) && cwD().getPbData() != null && cwD().getPbData().getForum() != null) {
            if (cwD().getPbData().getForum().isLike() == 1) {
                cwD().czf().eI(cwD().getForumId(), cwD().cyA());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null) {
            bj cvu = eVar.cvu();
            if (cvu != null && cvu.aMA()) {
                cym();
            } else {
                d(this.jtJ);
            }
            if (this.jtK != null) {
                rz(this.jtK.aXv());
                this.jtK.a(eVar.getAnti());
                this.jtK.a(eVar.getForum(), eVar.getUserData());
                this.jtK.setThreadData(cvu);
                if (cwD() != null) {
                    this.jtK.a(cwD().cyP(), cwD().cyA(), cwD().czg());
                }
                if (cvu != null) {
                    this.jtK.hH(cvu.aLY());
                }
            }
        }
    }

    public void cAm() {
        reset();
        cAi();
        this.jAY.cxl();
        rB(false);
    }

    private void reset() {
        if (this.jtK != null && this.Za != null) {
            com.baidu.tbadk.editortools.pb.a.aXl().setStatus(0);
            this.jtK.aXF();
            this.jtK.aWZ();
            if (this.jtK.getWriteImagesInfo() != null) {
                this.jtK.getWriteImagesInfo().setMaxImagesAllowed(this.jtK.isBJH ? 1 : 9);
            }
            this.jtK.mJ(SendView.ALL);
            this.jtK.mK(SendView.ALL);
            com.baidu.tbadk.editortools.g mA = this.Za.mA(23);
            com.baidu.tbadk.editortools.g mA2 = this.Za.mA(2);
            com.baidu.tbadk.editortools.g mA3 = this.Za.mA(5);
            if (mA2 != null) {
                mA2.display();
            }
            if (mA3 != null) {
                mA3.display();
            }
            if (mA != null) {
                mA.hide();
            }
            this.Za.invalidate();
        }
    }

    public void q(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            t(eVar);
            if (eVar.aGZ()) {
                SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.aOU().a(this.jAv, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            this.jAy.setText(zO(eVar.cvu().aKv()));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, eVar.cvu()));
        }
    }

    public void t(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && AntiHelper.ba(eVar.cvu())) {
            if (this.jAx != null) {
                this.jAx.setEnable(false);
                this.jAx.onDestroy();
            }
            SvgManager.aOU().a(this.jAw, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.jAx == null || !this.jAx.isEnable()) {
            SvgManager.aOU().a(this.jAw, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        if (this.jAt != null) {
            rz(this.jtK.aXv());
            if (this.jAp) {
                rq(z);
            } else {
                rr(z);
            }
            cDN();
            cDO();
        }
    }

    public void cBk() {
        if (this.jAt != null) {
            this.jAs.setVisibility(8);
            this.jAt.setVisibility(8);
            this.jKB.jKT = false;
            cDN();
            cDO();
        }
    }

    private void cDN() {
        if (this.jKo != null) {
            if (this.jKB.cEe()) {
                this.jKo.ta(false);
            } else {
                this.jKo.ta(this.jKo.brK() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDO() {
        if (this.jKo != null && this.dxy != null) {
            if (this.dxy.getCurrentItem() != 0) {
                this.jKo.sj(false);
            } else if (this.jKB.cEe()) {
                this.jKo.sj(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.jKo.sj(eVar.cEo() == null || eVar.cEo().getValue() == null || eVar.cEo().getValue().booleanValue());
                }
            }
        }
    }

    private void zy(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(cyk(), cxE(), i);
    }

    private int cxE() {
        if (cwD() == null || cwD().getPbData() == null || cwD().getPbData().cvu() == null) {
            return -1;
        }
        return cwD().getPbData().cvu().aLo();
    }

    public void rz(boolean z) {
        this.jAp = z;
    }

    public void rq(boolean z) {
        if (this.jAt != null && this.hSi != null) {
            this.hSi.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAt.startAnimation(alphaAnimation);
            }
            this.jAs.setVisibility(0);
            this.jAt.setVisibility(0);
            this.jKB.jKT = true;
        }
    }

    public void rr(boolean z) {
        if (this.jAt != null && this.hSi != null) {
            this.hSi.setText(cAo());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.jAt.startAnimation(alphaAnimation);
            }
            this.jAs.setVisibility(0);
            this.jAt.setVisibility(0);
            this.jKB.jKT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null) {
            this.jog = aVar;
            this.jKt.setText(aVar.getTitle());
            this.jKu.setText(aVar.cEL());
            String cEM = aVar.cEM();
            TBSpecificationBtn tBSpecificationBtn = this.jKw;
            if (TextUtils.isEmpty(cEM)) {
                cEM = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(cEM);
            this.jKx.startLoad(aVar.getImage(), 10, false);
            com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
                @Override // java.lang.Runnable
                public void run() {
                    TiebaStatic.log(new an("c13608").cI("obj_id", VideoPbFragment.this.jog.getTitle()).cI("obj_name", VideoPbFragment.this.jog.cEL()).af("obj_type", 2).cI("fid", VideoPbFragment.this.cwD().getPbData().getForumId()).cI("uid", TbadkCoreApplication.getCurrentAccount()).cI("tid", VideoPbFragment.this.cwD().getPbData().getThreadId()));
                    VideoPbFragment.this.cDP();
                }
            }, aVar.cEN().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDP() {
        ViewGroup.LayoutParams layoutParams = this.jKr.getLayoutParams();
        if (layoutParams != null) {
            if (this.jKy == null || !this.jKy.isRunning()) {
                this.jKr.setAlpha(0.0f);
                this.jKr.setVisibility(0);
                f(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDQ() {
        if (this.jKr.getLayoutParams() != null) {
            if (this.jKy == null || !this.jKy.isRunning()) {
                cDR();
            }
        }
    }

    private void cDR() {
        final ViewGroup.LayoutParams layoutParams = this.jKr.getLayoutParams();
        if (layoutParams != null) {
            if (this.jKz == null || !this.jKz.isRunning()) {
                this.jKz = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.jKz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.jKr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.jKz.setDuration(200L);
                this.jKz.start();
                this.jKz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
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
        final ViewGroup.LayoutParams layoutParams2 = this.VZ.getLayoutParams();
        final int i = layoutParams2.height;
        this.jKy = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hQD);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.hQD);
                VideoPbFragment.this.jKr.setLayoutParams(layoutParams);
                VideoPbFragment.this.VZ.setLayoutParams(layoutParams2);
            }
        });
        this.jKy.setDuration(300L);
        this.jKy.start();
        this.jKy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.jKr.setVisibility(8);
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
        final ViewGroup.LayoutParams layoutParams2 = this.VZ.getLayoutParams();
        final int i = layoutParams2.height;
        this.jKy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.hQD);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.jKr.setLayoutParams(layoutParams);
                VideoPbFragment.this.VZ.setLayoutParams(layoutParams2);
            }
        });
        this.jKy.setDuration(300L);
        this.jKy.start();
        this.jKy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.cDS();
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
    public void cDS() {
        this.jKy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jKy.setDuration(300L);
        this.jKy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.jKr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.jKy.start();
    }

    public String cAo() {
        if (!aq.isEmpty(this.jBp)) {
            return this.jBp;
        }
        this.jBp = TbadkCoreApplication.getInst().getResources().getString(com.baidu.tieba.pb.pb.main.am.cAd());
        return this.jBp;
    }

    public void cAJ() {
        hideProgressBar();
        if (cDV() != null) {
            cDV().endLoadData();
            cDV().cAK();
        }
    }

    public boolean cB(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && i.aIe().isShowImages()) {
                    return Hz(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (cwD() == null || cwD().getPbData() == null) {
                        return true;
                    }
                    if (this.jAY != null) {
                        this.jAY.cxl();
                    }
                    com.baidu.tieba.pb.data.l lVar = new com.baidu.tieba.pb.data.l();
                    lVar.a(cwD().getPbData().getForum());
                    lVar.setThreadData(cwD().getPbData().cvu());
                    lVar.f(postData);
                    this.jsS.d(lVar);
                    this.jsS.setPostId(postData.getId());
                    b(view, postData.aKE().getUserId(), "");
                    TiebaStatic.log("c11743");
                    if (this.jtK != null) {
                        rz(this.jtK.aXv());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void cDT() {
        if (this.jtK != null) {
            rz(this.jtK.aXv());
        }
        cAm();
        this.jKA.cBa();
    }

    private boolean Hz(String str) {
        if (!StringUtils.isNull(str) && bc.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("bubble_link", "");
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

    public void chm() {
        if (this.jAb != null) {
            this.jAb.setVisibility(0);
        }
    }

    public void chl() {
        if (this.jAb != null) {
            this.jAb.setVisibility(8);
        }
    }

    public void Ae(int i) {
        if (this.jKl != null) {
            this.jKl.setVisibility(i);
        }
    }

    public void cAH() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a cxJ() {
        return this.juw;
    }

    public void cAi() {
        if (this.Za != null) {
            this.Za.hide();
        }
    }

    public void bOU() {
        if (this.jsV.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.jsV.getCurrentFocus());
        }
    }

    public void H(com.baidu.tieba.pb.data.e eVar) {
        if (eVar != null && eVar.cvu() != null) {
            String valueOf = String.valueOf(eVar.cvu().aKv());
            if (eVar.cvu().aKv() == 0) {
                valueOf = "";
            }
            this.jKj.xw(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
        for (BaseFragment baseFragment : this.jKk.cEf()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, eVar, str, i4);
            }
        }
        b(z, i, i2, i3, eVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (cwD() != null && cwD().getPbData() != null && cwD().getPbData().cvu() != null && cwD().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(jAR)).intValue();
                if (intValue == jAS) {
                    if (!this.gqa.cXf()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gqa.KQ(aq.P(jSONArray));
                        }
                        this.gqa.a(cwD().getPbData().getForum().getId(), cwD().getPbData().getForum().getName(), cwD().getPbData().cvu().getId(), str, intValue3, intValue2, booleanValue, cwD().getPbData().cvu().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == jAT || intValue == jAV) {
                    if (cwD().czc() != null) {
                        cwD().czc().zr(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == jAT) {
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
    public int bcO() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bcP() {
        if (this.emH == null) {
            this.emH = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bdb */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.aIe().isShowImages();
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
                        if (i.aIe().isShowImages()) {
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
        return this.emH;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bcQ() {
        if (this.epz == null) {
            this.epz = TbRichTextView.u(getPageContext().getPageActivity(), 8);
        }
        return this.epz;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bcR() {
        if (this.emI == null) {
            this.emI = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bJw */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = i.aIe().isShowImages();
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
                    if (i.aIe().isShowImages()) {
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
                    gifView.aYk();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.emI;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bcS() {
        if (this.epA == null) {
            this.epA = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyn */
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
                    ((PlayVoiceBntNew) view).cXz();
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
        return this.epA;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bcT() {
        if (this.epB == null) {
            this.epB = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cyp */
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
        return this.epB;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bcU() {
        this.epC = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: cyo */
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
        return this.epC;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aw(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.jtg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void e(Context context, String str, boolean z) {
        if (as.HP(str) && cwD() != null && cwD().cyA() != null) {
            TiebaStatic.log(new an("c11664").af("obj_param1", 1).cI("post_id", cwD().cyA()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.j jVar = new com.baidu.tbadk.data.j();
                jVar.mLink = str;
                jVar.type = 3;
                jVar.dVK = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, jVar));
            }
        } else {
            as.cBD().d(getPageContext(), str);
        }
        this.jtg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ax(Context context, String str) {
        as.cBD().d(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.jtg = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void ay(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void az(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.jKA.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b cEy = this.jKA.cEy();
            if (cEy == null) {
                this.jKA.cxz();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                cEy.getItemView(1).setVisibility(8);
            } else {
                cEy.getItemView(1).setVisibility(0);
            }
            cEy.aMV();
            this.jtg = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aA(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            ba.aOY().b(getPageContext(), new String[]{str});
            this.jtg = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.e eVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a cDU() {
        return this.dzD;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener baD() {
        return this.dRW;
    }

    public ReplyFragment cDV() {
        if (this.jKk == null || !(this.jKk.Af(jKh) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.jKk.Af(jKh);
    }

    public DetailInfoFragment cDW() {
        if (this.jKk == null || !(this.jKk.Af(jKg) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.jKk.Af(jKg);
    }

    public boolean cwt() {
        PbModel cwD = this.jsV.cwD();
        if (cwD == null) {
            return false;
        }
        return cwD.cwt();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cvD;
        PbModel cwD = this.jsV.cwD();
        if (cwD != null && cwD.getPbData() != null && !cwD.getPbData().cvS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = cwD.getPbData().cvu().getId();
            if (cwD.isShareThread() && cwD.getPbData().cvu().dto != null) {
                historyMessage.threadName = cwD.getPbData().cvu().dto.showText;
            } else {
                historyMessage.threadName = cwD.getPbData().cvu().getTitle();
            }
            if (cwD.isShareThread() && !cwt()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = cwD.getPbData().getForum().getName();
            }
            ArrayList<PostData> cvw = cwD.getPbData().cvw();
            int cAL = cDV() != null ? cDV().cAL() : 0;
            if (cvw != null && cAL >= 0 && cAL < cvw.size()) {
                historyMessage.postID = cvw.get(cAL).getId();
            }
            historyMessage.isHostOnly = cwD.getHostMode();
            historyMessage.isSquence = cwD.cyB();
            historyMessage.isShareThread = cwD.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.jtK != null) {
            this.jtK.onDestroy();
        }
        if (cwD != null && (cwD.cyC() || cwD.cyE())) {
            Intent intent = new Intent();
            intent.putExtra("tid", cwD.cyA());
            if (this.jty) {
                if (this.jtA) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", cwD.bHK());
                }
                if (this.jtz) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", cwD.getIsGood());
                }
            }
            if (cwD.getPbData() != null && System.currentTimeMillis() - this.jtc >= 40000 && (cvD = cwD.getPbData().cvD()) != null && !v.isEmpty(cvD.getDataList())) {
                intent.putExtra("guess_like_data", cvD);
            }
            PbActivity pbActivity = this.jsV;
            PbActivity pbActivity2 = this.jsV;
            pbActivity.setResult(-1, intent);
        }
        if (cxQ()) {
            if (cwD != null) {
                com.baidu.tieba.pb.data.e pbData = cwD.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.jti) {
                        if (this.jKn != null) {
                            Rect rect = new Rect();
                            this.jKn.getGlobalVisibleRect(rect);
                            ah.czS().h(rect);
                        }
                        ah.czS().zK(this.dxy.getCurrentItem());
                        BdTypeRecyclerView bRw = bRw();
                        Parcelable parcelable = null;
                        if (bRw != null) {
                            parcelable = bRw.onSaveInstanceState();
                        }
                        ah.czS().a(cwD.cyJ(), parcelable, cwD.cyB(), cwD.getHostMode(), false);
                    }
                }
            } else {
                ah.czS().reset();
            }
            cwQ();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.jKo != null && !this.jKo.brK()) {
            if ((this.jKo.isFullScreen() && configuration.orientation == 1) || (!this.jKo.isFullScreen() && configuration.orientation == 2)) {
                this.jKo.sk(false);
            }
        }
    }

    public boolean cDX() {
        if (this.jKo == null) {
            return false;
        }
        return this.jKo.brK();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.cVr().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a {
        public boolean jKT;
        public boolean jKU;

        private a() {
            this.jKU = true;
        }

        public boolean cEe() {
            return (this.jKT && this.jKU) ? false : true;
        }
    }

    public void cDY() {
        this.jtq = -1;
        this.jtr = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cyg() {
        if (cwD() != null && !aq.isEmpty(cwD().cyA())) {
            com.baidu.tbadk.BdToken.c.aFN().o(com.baidu.tbadk.BdToken.b.dfY, com.baidu.adp.lib.f.b.toLong(cwD().cyA(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.jKm.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDZ() {
        if (this.jKK == null) {
            this.jKK = ObjectAnimator.ofFloat(this.jKq, "alpha", 0.0f, 1.0f);
            this.jKK.setDuration(200L);
        }
        this.jKK.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEa() {
        if (this.jKL == null) {
            this.jKL = ObjectAnimator.ofFloat(this.jKq, "alpha", 1.0f, 0.0f);
            this.jKL.setDuration(200L);
        }
        this.jKL.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean cEb() {
        return this.jKo != null && this.jKo.cEc();
    }

    public boolean cEc() {
        return this.jKH;
    }

    public void sc(boolean z) {
        this.jKH = z;
    }
}
