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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.baseEditMark.a;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.AttentionHostData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.h;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.i;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.p;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.as;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.pb.pb.main.bb;
import com.baidu.tieba.pb.pb.main.v;
import com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel;
import com.baidu.tieba.pb.videopb.fragment.DetailInfoAndReplyFragment;
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
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.SortSwitchButton;
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
/* loaded from: classes21.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, i, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout XP;
    private EditorTools aaS;
    private ImageView agA;
    public View eXg;
    private CustomViewPager ekP;
    private com.baidu.adp.lib.d.b<ImageView> ffj;
    private com.baidu.adp.lib.d.b<GifView> ffk;
    private com.baidu.adp.lib.d.b<TextView> fiD;
    private com.baidu.adp.lib.d.b<View> fiE;
    private com.baidu.adp.lib.d.b<LinearLayout> fiF;
    private com.baidu.adp.lib.d.b<RelativeLayout> fiG;
    private ImageView gds;
    private VoiceManager hZU;
    private com.baidu.tieba.callfans.a hrE;
    private com.baidu.tieba.f.b ieU;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    public am jOf;
    public bb jSk;
    private com.baidu.tieba.pb.videopb.c.a kFX;
    private PbActivity kLA;
    private com.baidu.tieba.pb.pb.main.emotion.model.a kLS;
    int kLV;
    private PbFakeFloorModel kLv;
    private g kMq;
    private com.baidu.tbadk.editortools.pb.e kMr;
    private com.baidu.tieba.frs.profession.permission.c kMt;
    private EmotionImageData kMu;
    private com.baidu.tbadk.core.view.c kMy;
    private View kTF;
    private View kTW;
    private LinearLayout kTY;
    private HeadImageView kTZ;
    private v kUF;
    private String kUW;
    private ImageView kUa;
    private ImageView kUb;
    private ImageView kUc;
    private com.baidu.tieba.pb.view.c kUd;
    private TextView kUe;
    private TextView kUf;
    private int kUh;
    private int kUi;
    public View kZB;
    private float leC;
    private float leD;
    private boolean leE;
    private ObjectAnimator leI;
    private ObjectAnimator leJ;
    private NewPagerSlidingTabBaseStrip lef;
    private VideoPbFragmentAdapter leg;
    private View leh;
    private View lei;
    private VideoContainerLayout lej;
    private com.baidu.tieba.pb.videopb.videoView.a lek;
    private f lel;
    private View lem;
    private View leo;
    private TextView leq;
    private TextView ler;
    private ImageView les;
    private TBSpecificationBtn let;
    private TbImageView leu;
    private View lev;
    private ValueAnimator lew;
    private ValueAnimator lex;
    public com.baidu.tieba.pb.videopb.b.a ley;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private RelativeLayout rootView;
    public static int leb = 0;
    public static int lec = 1;
    public static int led = 0;
    public static int kUx = 3;
    public static int kUy = 0;
    public static int kUz = 3;
    public static int kUA = 4;
    public static int kUB = 5;
    public static int kUC = 6;
    private static final int iZb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int lee = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a kNr = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void cr(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.cZV();
            } else {
                com.baidu.tieba.pb.a.b.cZU();
            }
        }
    };
    private long kLH = 0;
    private boolean kLO = false;
    View.OnClickListener lep = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.kFX == null || VideoPbFragment.this.kFX.diJ()) {
                if (VideoPbFragment.this.kFX != null) {
                    if (VideoPbFragment.this.kFX.isChushou) {
                        VideoPbFragment.this.eq(VideoPbFragment.this.kFX.thirdRoomId, VideoPbFragment.this.kFX.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.kFX.diK();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().getForum() != null) {
                        TiebaStatic.log(new aq("c13713").dF("fid", VideoPbFragment.this.dah().getPbData().getForum().getId()).dF("fname", VideoPbFragment.this.dah().getPbData().getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", VideoPbFragment.this.dah().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kFX.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new aq("c13590").dF("obj_id", VideoPbFragment.this.kFX.getTitle()).dF("obj_name", VideoPbFragment.this.kFX.diG()).ai("obj_type", 2).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", VideoPbFragment.this.dah().getPbData().getThreadId()));
            String link = VideoPbFragment.this.kFX.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    be.bkp().b(VideoPbFragment.this.getPageContext(), new String[]{link});
                    return;
                }
                Uri parse = Uri.parse(link);
                if (parse != null) {
                    UtilHelper.dealOneScheme(VideoPbFragment.this.getActivity(), parse.toString());
                }
            }
        }
    };
    private boolean mIsLoading = false;
    private com.baidu.tbadk.baseEditMark.a kMd = null;
    private com.baidu.tbadk.coreExtra.model.a emW = null;
    private ForumManageModel hrC = null;
    private boolean kLL = false;
    private View kTX = null;
    private TextView jcG = null;
    private boolean kTT = false;
    private String ePo = null;
    private boolean kMg = false;
    private boolean kMh = false;
    private boolean kMi = false;
    private boolean kLN = false;
    int[] kLU = new int[2];
    private int kLW = -1;
    private int kLX = Integer.MIN_VALUE;
    private int kME = 0;
    private int leA = Integer.MIN_VALUE;
    private boolean bsQ = false;
    private boolean kJC = com.baidu.tbadk.a.d.baU();
    private final PbModel.a kNh = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
            h qo;
            VideoPbFragment.this.der();
            VideoPbFragment.this.cKc();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.tL(false);
            if (z && fVar != null) {
                bw cYR = fVar.cYR();
                ((e) y.b(VideoPbFragment.this.getActivity()).l(e.class)).c(fVar, i2);
                VideoPbFragment.this.J(fVar);
                com.baidu.tieba.pb.videopb.c.a cZw = fVar.cZw();
                if (cZw != null && !cZw.lgB) {
                    VideoPbFragment.this.a(cZw);
                }
                VideoPbFragment.this.K(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.kMd != null) {
                    VideoPbFragment.this.kMd.hy(fVar.bbu());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.ePo = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.ePo) && VideoPbFragment.this.kMr != null && VideoPbFragment.this.kMr.bsv() != null && (qo = VideoPbFragment.this.kMr.bsv().qo(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.ePo)) {
                        ((View) qo).setOnClickListener(VideoPbFragment.this.eQa);
                    }
                }
                if (VideoPbFragment.this.jOf != null && cYR != null && cYR.bfy() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(cYR.bfy());
                    VideoPbFragment.this.jOf.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dah().dcf());
                        jSONObject.put("fid", VideoPbFragment.this.dah().getForumId());
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
                if ((!com.baidu.tbadk.a.d.baW() || VideoPbFragment.this.dhK() != null) && VideoPbFragment.this.dhI() != null) {
                    if (com.baidu.tbadk.a.d.baW()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dah().getPbData().cYT();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dAD() == 1)) {
                                if (VideoPbFragment.this.dhK().dbF()) {
                                    VideoPbFragment.this.dhK().Ok(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dhK().Ok(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dhK().Oj(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dhK().Oj("");
                        }
                        VideoPbFragment.this.dhK().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dah().getPbData().cYT();
                            }
                            if (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 0 || (com.baidu.tbadk.core.util.y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dAD() == 1)) {
                                if (VideoPbFragment.this.dhI().dbF()) {
                                    VideoPbFragment.this.dhI().Ok(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.dhI().Ok(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.dhI().Oj(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.dhI().Oj("");
                        }
                        VideoPbFragment.this.dhI().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dzC().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(com.baidu.tieba.pb.data.f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0530a kNj = new a.InterfaceC0530a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0530a
        public void c(boolean z, boolean z2, String str) {
            VideoPbFragment.this.der();
            if (z && VideoPbFragment.this.dah() != null) {
                if (VideoPbFragment.this.kMd != null) {
                    VideoPbFragment.this.kMd.hy(z2);
                }
                VideoPbFragment.this.dah().tq(z2);
                if (VideoPbFragment.this.dah().bbu()) {
                    VideoPbFragment.this.dbq();
                } else if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null) {
                    VideoPbFragment.this.dhK().dit();
                } else if (VideoPbFragment.this.dhI() != null) {
                    VideoPbFragment.this.dhI().dit();
                }
                if (z2) {
                    if (VideoPbFragment.this.kMd != null) {
                        if (VideoPbFragment.this.kMd.bbx() != null && VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().cYR() != null && VideoPbFragment.this.dah().getPbData().cYR().bfy() != null) {
                            MarkData bbx = VideoPbFragment.this.kMd.bbx();
                            MetaData bfy = VideoPbFragment.this.dah().getPbData().cYR().bfy();
                            if (bbx != null && bfy != null) {
                                if (!at.equals(TbadkCoreApplication.getCurrentAccount(), bfy.getUserId()) && !bfy.hadConcerned()) {
                                    VideoPbFragment.this.ley.b(bfy);
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
                    VideoPbFragment.this.dbn();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b ePs = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bsZ() {
            if (VideoPbFragment.this.jSk == null || VideoPbFragment.this.jSk.dfj() == null || !VideoPbFragment.this.jSk.dfj().dJz()) {
                return !VideoPbFragment.this.ED(am.emR);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jSk.dfj().dJB());
            if (VideoPbFragment.this.kMr != null && (VideoPbFragment.this.kMr.btq() || VideoPbFragment.this.kMr.btr())) {
                VideoPbFragment.this.kMr.a(false, VideoPbFragment.this.jSk.dfm());
            }
            VideoPbFragment.this.jSk.tR(true);
            return true;
        }
    };
    private final CustomMessageListener kML = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dah() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.kMr != null) {
                    VideoPbFragment.this.tJ(VideoPbFragment.this.kMr.btj());
                }
                VideoPbFragment.this.ddU();
                VideoPbFragment.this.ley.deI();
            }
        }
    };
    private CustomMessageListener kMO = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((p) eVar.getData());
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
    private final CustomMessageListener ibw = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.bsQ) {
                VideoPbFragment.this.dbI();
            }
        }
    };
    private CustomMessageListener kNi = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dbh();
            }
        }
    };
    private CustomMessageListener kNa = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.ley != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.ley.kMz) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.ley.bXZ();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.ley.getExtra();
                DataRes dataRes = aVar.mDo;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (at.isEmpty(str)) {
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
                    VideoPbFragment.this.ley.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.ley.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener kMY = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ley != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.ley.kMz) {
                VideoPbFragment.this.ley.bXZ();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dah().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.cZh().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kMy.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.ley.CA(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.ley.dbE();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (at.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.kMy.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener kMZ = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.ley != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.ley.kMz) {
                VideoPbFragment.this.ley.bXZ();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.kMy.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (at.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.kMy.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b kMw = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bsZ() {
            if (VideoPbFragment.this.jSk == null || VideoPbFragment.this.jSk.dfk() == null || !VideoPbFragment.this.jSk.dfk().dJz()) {
                return !VideoPbFragment.this.ED(am.emS);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.jSk.dfk().dJB());
            if (VideoPbFragment.this.kUF != null && VideoPbFragment.this.kUF.daR() != null && VideoPbFragment.this.kUF.daR().btr()) {
                VideoPbFragment.this.kUF.daR().a(VideoPbFragment.this.jSk.dfm());
            }
            VideoPbFragment.this.jSk.tS(true);
            return true;
        }
    };
    private final NewWriteModel.d ePy = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                    aqVar.dF("fid", VideoPbFragment.this.dah().getPbData().getForumId());
                }
                aqVar.dF("tid", VideoPbFragment.this.dah().dcf());
                aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            VideoPbFragment.this.cpE();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dah() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dah().Oe(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null) {
                        VideoPbFragment.this.kME = VideoPbFragment.this.dhK().det();
                        VideoPbFragment.this.leA = VideoPbFragment.this.dhK().diw();
                        VideoPbFragment.this.dah().cX(VideoPbFragment.this.kME, VideoPbFragment.this.leA);
                    } else if (VideoPbFragment.this.dhI() != null) {
                        VideoPbFragment.this.kME = VideoPbFragment.this.dhI().det();
                        VideoPbFragment.this.leA = VideoPbFragment.this.dhI().diw();
                        VideoPbFragment.this.dah().cX(VideoPbFragment.this.kME, VideoPbFragment.this.leA);
                    }
                }
                if (VideoPbFragment.this.ekP != null) {
                    if (com.baidu.tbadk.a.d.baW()) {
                        VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.led);
                    } else {
                        VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.lec);
                    }
                }
                VideoPbFragment.this.ley.deI();
                VideoPbFragment.this.jSk.dfi();
                if (VideoPbFragment.this.kMr != null) {
                    VideoPbFragment.this.tJ(VideoPbFragment.this.kMr.btj());
                }
                VideoPbFragment.this.ddQ();
                VideoPbFragment.this.tL(true);
                VideoPbFragment.this.dah().dcA();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null) {
                                VideoPbFragment.this.dhK().dit();
                            } else if (VideoPbFragment.this.dhI() != null) {
                                VideoPbFragment.this.dhI().dit();
                            }
                        }
                    } else if (VideoPbFragment.this.dah().getHostMode()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dah().getPbData();
                        if (pbData != null && pbData.cYR() != null && pbData.cYR().bfy() != null && (userId = pbData.cYR().bfy().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dah().dcr()) {
                            VideoPbFragment.this.dep();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dah().dcr()) {
                        VideoPbFragment.this.dep();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.tb(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.kMr.btq() || VideoPbFragment.this.kMr.btr()) {
                    VideoPbFragment.this.kMr.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.jSk.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.jOf != null) {
                    VideoPbFragment.this.jOf.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zV(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zV(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bia();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener eQa = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.ePo);
        }
    };
    private CustomMessageListener kMN = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.kMr != null) {
                    VideoPbFragment.this.tJ(VideoPbFragment.this.kMr.btj());
                }
                VideoPbFragment.this.tL(false);
            }
        }
    };
    private int leB = 0;
    private boolean leF = true;
    private View.OnTouchListener leG = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.leB == 1) {
                if (!VideoPbFragment.this.leF) {
                    VideoPbFragment.this.dhN();
                    UtilHelper.showStatusBar(VideoPbFragment.this.dbM(), VideoPbFragment.this.dbM().getRootView());
                    VideoPbFragment.this.leF = true;
                    com.baidu.adp.lib.f.e.mX().removeCallbacks(VideoPbFragment.this.leH);
                    com.baidu.adp.lib.f.e.mX().postDelayed(VideoPbFragment.this.leH, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.leB == 2 && (VideoPbFragment.this.leF || VideoPbFragment.this.dhP())) {
                VideoPbFragment.this.dhO();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dbM(), VideoPbFragment.this.dbM().getRootView());
                VideoPbFragment.this.leF = false;
                if (VideoPbFragment.this.lek != null) {
                    VideoPbFragment.this.lek.un(false);
                }
            }
            VideoPbFragment.this.leB = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener imc = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.leB = 0;
            VideoPbFragment.this.leC = 0.0f;
            VideoPbFragment.this.leD = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.leC += f;
            VideoPbFragment.this.leD += f2;
            if (VideoPbFragment.this.leB == 0 && !VideoPbFragment.this.leE && VideoPbFragment.this.lek != null && !VideoPbFragment.this.lek.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.leD) <= Math.abs(VideoPbFragment.this.leC) || VideoPbFragment.this.leD > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.leD) > Math.abs(VideoPbFragment.this.leC) && VideoPbFragment.this.leD > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.leB = 2;
                    }
                } else {
                    VideoPbFragment.this.leB = 1;
                }
            }
            return true;
        }
    };
    private Runnable leH = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.leF && !VideoPbFragment.this.dhP()) {
                VideoPbFragment.this.dhO();
                UtilHelper.hideStatusBar(VideoPbFragment.this.dbM(), VideoPbFragment.this.dbM().getRootView());
                VideoPbFragment.this.leF = false;
            }
        }
    };
    private final com.baidu.adp.base.d hrJ = new com.baidu.adp.base.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.d
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dah() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.hrC.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.hrC.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dah().dcA();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.lby != 1002 || bVar.gkE) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.Qx, dVar.mro, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.hrC.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.hrC.getLoadDataMode(), gVar.Qx, gVar.mro, false);
                    VideoPbFragment.this.ley.aZ(gVar.mrr);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener eYy = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.ieU.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d kNf = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                aq aqVar = new aq("c13268");
                aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                    aqVar.dF("fid", VideoPbFragment.this.dah().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dah() != null) {
                    aqVar.dF("tid", VideoPbFragment.this.dah().dcf());
                }
                aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(aqVar);
            }
            if (z) {
                if (VideoPbFragment.this.jSk != null) {
                    VideoPbFragment.this.jSk.dfh();
                }
                if (postWriteCallBackData != null && postWriteCallBackData.getIconStampData() != null) {
                    com.baidu.tbadk.coreExtra.c.b.a(VideoPbFragment.this.getPageContext(), postWriteCallBackData);
                    return;
                }
                return;
            }
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
            }
            if (i == 238010) {
                if (VideoPbFragment.this.jOf != null) {
                    VideoPbFragment.this.jOf.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.c(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (at.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.zV(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.zV(postWriteCallBackData.getErrorString());
                }
                aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.1
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                    }
                });
                aVar.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16.2
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        aVar2.dismiss();
                        VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(VideoPbFragment.this.getActivity(), 0, 26, 2)));
                        TiebaStatic.log(new aq("c13746").ai("obj_locate", 1).ai("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bia();
                TiebaStatic.log(new aq("c13745").ai("obj_locate", 1).ai("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.jSk != null) {
                if (VideoPbFragment.this.kUF != null && VideoPbFragment.this.kUF.daR() != null && VideoPbFragment.this.kUF.daR().btr()) {
                    VideoPbFragment.this.kUF.daR().a(postWriteCallBackData);
                }
                VideoPbFragment.this.jSk.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c ePr = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bta() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public View.OnClickListener aBS = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v149, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean z;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    aq aqVar = new aq("c13398");
                    aqVar.dF("tid", VideoPbFragment.this.dah().dcf());
                    aqVar.dF("fid", VideoPbFragment.this.dah().getForumId());
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.ai("obj_locate", 1);
                    TiebaStatic.log(aqVar);
                    if (VideoPbFragment.this.kLL) {
                        VideoPbFragment.this.kLL = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.kLv != null && postData.bfy() != null && postData.dAD() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.kUF != null) {
                                    VideoPbFragment.this.kUF.daN();
                                }
                                p pVar = new p();
                                pVar.a(VideoPbFragment.this.dah().getPbData().getForum());
                                pVar.setThreadData(VideoPbFragment.this.dah().getPbData().cYR());
                                pVar.g(postData);
                                VideoPbFragment.this.kLv.d(pVar);
                                VideoPbFragment.this.kLv.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bfy().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dah().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.kMr != null) {
                                    VideoPbFragment.this.tJ(VideoPbFragment.this.kMr.btj());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.dhI() != null && VideoPbFragment.this.dhI().deE() != null && view == VideoPbFragment.this.dhI().deE()) || ((com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null && VideoPbFragment.this.dhK().deE() != null && view == VideoPbFragment.this.dhK().deE()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dah().to(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.baW()) {
                            VideoPbFragment.this.dhK().deq();
                        } else {
                            VideoPbFragment.this.dhI().deq();
                        }
                    }
                } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddp()) {
                    VideoPbFragment.this.ley.aSz();
                } else if ((VideoPbFragment.this.ley != null && ((VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddq()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.ley.deI();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cpE();
                        VideoPbFragment.this.dep();
                        if (view.getId() == R.id.owner_reply) {
                            z = VideoPbFragment.this.dah().z(true, VideoPbFragment.this.dbu());
                        } else {
                            z = view.getId() == R.id.all_reply ? VideoPbFragment.this.dah().z(false, VideoPbFragment.this.dbu()) : VideoPbFragment.this.dah().Ob(VideoPbFragment.this.dbu());
                        }
                        view.setTag(Boolean.valueOf(z));
                        if (z) {
                            VideoPbFragment.this.cKd();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.eXg) {
                    if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                        if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            aq aqVar2 = new aq("c13266");
                            aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar2.dF("fid", VideoPbFragment.this.dah().getPbData().getForumId());
                            aqVar2.dF("tid", VideoPbFragment.this.dah().dcf());
                            aqVar2.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(aqVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.kLA, VideoPbFragment.this.eXg);
                        VideoPbFragment.this.kLA.finish();
                    }
                } else if (view == VideoPbFragment.this.kZB && VideoPbFragment.this.ley != null) {
                    if (VideoPbFragment.this.dah() == null || VideoPbFragment.this.dah().getPbData() == null) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    ArrayList<PostData> cYT = VideoPbFragment.this.dah().getPbData().cYT();
                    if ((cYT == null || cYT.size() <= 0) && VideoPbFragment.this.dah().dch()) {
                        l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    }
                    TiebaStatic.log(new aq("c12378").dF("tid", VideoPbFragment.this.dah().dcf()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("fid", VideoPbFragment.this.dah().getForumId()));
                    VideoPbFragment.this.ley.dbi();
                } else if (VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddu()) {
                    if (VideoPbFragment.this.dah() != null) {
                        VideoPbFragment.this.ley.deI();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cpE();
                            VideoPbFragment.this.dep();
                            VideoPbFragment.this.dah().EJ(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddq()) {
                    VideoPbFragment.this.ley.aSz();
                } else if (VideoPbFragment.this.ley != null && ((VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddx()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.ley.deI();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cpE();
                            VideoPbFragment.this.dep();
                            VideoPbFragment.this.ley.di(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dah().dcy()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddo()) {
                    if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().cYR() != null) {
                        VideoPbFragment.this.ley.aSz();
                        TiebaStatic.log(new aq("c13062"));
                        VideoPbFragment.this.ley.NW(VideoPbFragment.this.dah().getPbData().cYR().bfP());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.ley != null) {
                        VideoPbFragment.this.ley.f(sparseArray);
                    }
                } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddy()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.C(true, false);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).ai("obj_type", 0).ai("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.cp_bg_line_d_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new aq(TbadkCoreStatisticKey.SET_NIGHT_MODE).ai("obj_type", 1).ai("obj_source", 1));
                    }
                    VideoPbFragment.this.ley.dfO();
                } else if (VideoPbFragment.this.ley != null && (view == VideoPbFragment.this.ley.den() || (VideoPbFragment.this.ley.dfP() != null && (view == VideoPbFragment.this.ley.dfP().ddt() || view == VideoPbFragment.this.ley.dfP().ddr())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.dah() != null || VideoPbFragment.this.dah().getPbData() != null) {
                        if ((VideoPbFragment.this.dah().getPbData().cZg() == 1 || VideoPbFragment.this.dah().getPbData().cZg() == 3) && !VideoPbFragment.this.hrC.dBo()) {
                            VideoPbFragment.this.ley.deI();
                            if (VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddr()) {
                                if (VideoPbFragment.this.dah().getPbData().cYR().bft() == 1) {
                                    i2 = 5;
                                } else {
                                    i2 = 4;
                                }
                            } else if (VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddt()) {
                                if (VideoPbFragment.this.dah().getPbData().cYR().bfu() != 1) {
                                    i2 = 6;
                                }
                            } else {
                                i2 = view == VideoPbFragment.this.ley.den() ? 2 : 0;
                            }
                            ForumData forum = VideoPbFragment.this.dah().getPbData().getForum();
                            String name = forum.getName();
                            String id = forum.getId();
                            String id2 = VideoPbFragment.this.dah().getPbData().cYR().getId();
                            VideoPbFragment.this.showProgressBar();
                            VideoPbFragment.this.hrC.b(id, name, id2, i2, VideoPbFragment.this.ley.deo());
                        }
                    }
                } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddw()) {
                    if (VideoPbFragment.this.dah() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.ley.deI();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.dah().getPbData(), VideoPbFragment.this.dah().dch(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dah().getPbData().getForum().getId(), VideoPbFragment.this.dah().getPbData().getForum().getName(), VideoPbFragment.this.dah().getPbData().cYR().getId(), String.valueOf(VideoPbFragment.this.dah().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().dds()) {
                    if (VideoPbFragment.this.dah() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dah().getPbData(), VideoPbFragment.this.dah().dch(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.ley.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.ley.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.ley.aSz();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        aq aqVar3 = new aq("c13398");
                        aqVar3.dF("tid", VideoPbFragment.this.dah().dcf());
                        aqVar3.dF("fid", VideoPbFragment.this.dah().getForumId());
                        aqVar3.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar3.ai("obj_locate", 4);
                        TiebaStatic.log(aqVar3);
                    }
                    if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new aq("c10517").ai("obj_locate", 3).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                        if (VideoPbFragment.this.ley != null) {
                            VideoPbFragment.this.ley.deI();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dAP() == 1) {
                                TiebaStatic.log(new aq("c12630"));
                            }
                            if (postData2.mpw != null) {
                                aq bkh = postData2.mpw.bkh();
                                bkh.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bkh.ai("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bkh.ai("obj_locate", 8);
                                }
                                TiebaStatic.log(bkh);
                            }
                            VideoPbFragment.this.cpE();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dah() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            aq aqVar4 = new aq("c13398");
                            aqVar4.dF("tid", VideoPbFragment.this.dah().dcf());
                            aqVar4.dF("fid", VideoPbFragment.this.dah().getForumId());
                            aqVar4.dF("uid", TbadkCoreApplication.getCurrentAccount());
                            aqVar4.ai("obj_locate", 6);
                            TiebaStatic.log(aqVar4);
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.mpw != null) {
                                    aq bkh2 = postData4.mpw.bkh();
                                    bkh2.delete("obj_locate");
                                    bkh2.ai("obj_locate", 8);
                                    TiebaStatic.log(bkh2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new aq("c13700").dF("tid", VideoPbFragment.this.dah().dcg()).dF("fid", VideoPbFragment.this.dah().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).dF("post_id", postData4.getId()).ai("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.kLv != null && postData4.bfy() != null && postData4.dAD() != 1) {
                                    if (VideoPbFragment.this.kUF != null) {
                                        VideoPbFragment.this.kUF.daN();
                                    }
                                    if ((VideoPbFragment.this.kJC || com.baidu.tbadk.a.d.baK()) && postData4.dAA() != null && postData4.dAA().size() != 0) {
                                        if (com.baidu.tbadk.a.d.baL()) {
                                            VideoPbFragment.this.a(postData4, (PostData) null, false, false);
                                            return;
                                        } else {
                                            VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                            return;
                                        }
                                    }
                                    p pVar2 = new p();
                                    pVar2.a(VideoPbFragment.this.dah().getPbData().getForum());
                                    pVar2.setThreadData(VideoPbFragment.this.dah().getPbData().cYR());
                                    pVar2.g(postData4);
                                    VideoPbFragment.this.kLv.d(pVar2);
                                    VideoPbFragment.this.kLv.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bfy().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.kMr != null) {
                                        VideoPbFragment.this.tJ(VideoPbFragment.this.kMr.btj());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.ley != null && VideoPbFragment.this.dah() != null) {
                        if (com.baidu.tbadk.a.d.baW() || VideoPbFragment.this.dhI() != null) {
                            if (!com.baidu.tbadk.a.d.baW() || VideoPbFragment.this.dhK() != null) {
                                VideoPbFragment.this.ley.deI();
                                if (VideoPbFragment.this.EE(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dah() != null) {
                                    VideoPbFragment.this.dbp();
                                    if (VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().cYR() != null && VideoPbFragment.this.dah().getPbData().cYR().bfy() != null) {
                                        TiebaStatic.log(new aq("c13402").dF("tid", VideoPbFragment.this.dah().dcf()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).ai("obj_locate", 3).dF("uid", VideoPbFragment.this.dah().getPbData().cYR().bfy().getUserId()));
                                    }
                                    if (VideoPbFragment.this.dah().getPbData().cYR() != null && VideoPbFragment.this.dah().getPbData().cYR().bfy() != null && VideoPbFragment.this.dah().getPbData().cYR().bfy().getUserId() != null && VideoPbFragment.this.kMd != null) {
                                        int h = VideoPbFragment.this.ley.h(VideoPbFragment.this.dah().getPbData());
                                        bw cYR = VideoPbFragment.this.dah().getPbData().cYR();
                                        if (!cYR.beg()) {
                                            if (cYR.beh()) {
                                                i = 3;
                                            } else if (cYR.bht()) {
                                                i = 4;
                                            } else {
                                                i = cYR.bhu() ? 5 : 1;
                                            }
                                        }
                                        TiebaStatic.log(new aq("c12526").dF("tid", VideoPbFragment.this.dah().dcf()).ai("obj_locate", 1).dF("obj_id", VideoPbFragment.this.dah().getPbData().cYR().bfy().getUserId()).ai("obj_type", VideoPbFragment.this.kMd.bbu() ? 0 : 1).ai("obj_source", h).ai("obj_param1", i));
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.ul(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.ley != null && VideoPbFragment.this.ekP != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().cYR() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        com.baidu.tieba.pb.data.f pbData = VideoPbFragment.this.dah().getPbData();
                        if (pbData.cYR().bfp() != 0) {
                            int currentItem = VideoPbFragment.this.ekP.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.baW() && currentItem == VideoPbFragment.leb) {
                                VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.lec);
                            } else if (com.baidu.tbadk.a.d.baW() || currentItem == VideoPbFragment.lec) {
                                if (!com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhI() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.baW() || VideoPbFragment.this.dhK() != null) && VideoPbFragment.this.csy() != null) {
                                    aq dF = new aq("c13403").dF("tid", VideoPbFragment.this.dah().dcf()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).dF("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView csy = VideoPbFragment.this.csy();
                                    if (csy != null) {
                                        boolean canScrollVertically = csy.canScrollVertically(1);
                                        boolean canScrollVertically2 = csy.canScrollVertically(-1);
                                        if (VideoPbFragment.this.XP != null) {
                                            VideoPbFragment.this.XP.setExpanded(false, true);
                                        }
                                        if (csy.getLayoutManager() != null && (csy.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) csy.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.kLW != -1 || VideoPbFragment.this.kLX != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.kLW > 3 || (VideoPbFragment.this.kLW == 3 && VideoPbFragment.this.kLX < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kLW, VideoPbFragment.this.kLX + equipmentHeight);
                                                        csy.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.kLW >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kLW, VideoPbFragment.this.kLX + (equipmentHeight / 2));
                                                        csy.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.kLW == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.kLW, VideoPbFragment.this.kLX + (equipmentHeight / 4));
                                                        csy.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        csy.smoothScrollBy(0, -VideoPbFragment.this.kLX);
                                                    }
                                                    dF.ai("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = csy.getFirstVisiblePosition();
                                                View childAt = csy.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.kLW = firstVisiblePosition;
                                                VideoPbFragment.this.kLX = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && csy.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    csy.smoothScrollToPosition(0);
                                                } else {
                                                    csy.smoothScrollToPosition(0);
                                                }
                                                dF.ai("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dF);
                                            TiebaStatic.log(new aq("c12942").ai("obj_type", 1).ai("obj_locate", 4).dF("tid", VideoPbFragment.this.dah().dcf()).dF("nid", pbData.cYR().getNid()));
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            }
                            if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().cYR() != null && VideoPbFragment.this.dah().getPbData().cYR().bfy() != null) {
                                TiebaStatic.log(new aq("c13402").dF("tid", VideoPbFragment.this.dah().dcf()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).ai("obj_locate", 2).dF("uid", VideoPbFragment.this.dah().getPbData().cYR().bfy().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.um(false);
                        VideoPbFragment.this.dbd();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.kME >= 0) {
                        if (VideoPbFragment.this.dah() != null) {
                            VideoPbFragment.this.dah().dcQ();
                        }
                        if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null && VideoPbFragment.this.dhK().dir() != null) {
                            VideoPbFragment.this.dhK().dir().setData(VideoPbFragment.this.dah().getPbData());
                        } else if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dhI() != null && VideoPbFragment.this.dhI().dir() != null) {
                            VideoPbFragment.this.dhI().dir().setData(VideoPbFragment.this.dah().getPbData());
                        }
                        VideoPbFragment.this.kME = 0;
                        VideoPbFragment.this.leA = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dah() != null && VideoPbFragment.this.dhK() != null) {
                            VideoPbFragment.this.dhK().da(VideoPbFragment.this.dah().dcT(), VideoPbFragment.this.dah().dcU());
                            VideoPbFragment.this.dah().cX(0, 0);
                        } else if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dhI() != null) {
                            VideoPbFragment.this.dhI().da(VideoPbFragment.this.dah().dcT(), VideoPbFragment.this.dah().dcU());
                            VideoPbFragment.this.dah().cX(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dah() != null) {
                        aq aqVar5 = new aq("c13398");
                        aqVar5.dF("tid", VideoPbFragment.this.dah().dcf());
                        aqVar5.dF("fid", VideoPbFragment.this.dah().getForumId());
                        aqVar5.dF("uid", TbadkCoreApplication.getCurrentAccount());
                        aqVar5.ai("obj_locate", 2);
                        TiebaStatic.log(aqVar5);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bg.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.bjf().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.ddU();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.ddU();
                } else if (VideoPbFragment.this.ley.dfP() != null && view == VideoPbFragment.this.ley.dfP().ddv()) {
                    VideoPbFragment.this.ley.deI();
                    if (VideoPbFragment.this.dah() != null) {
                        VideoPbFragment.this.hrE.setThreadId(VideoPbFragment.this.dah().dcf());
                    }
                    if (VideoPbFragment.this.dah() == null || !VideoPbFragment.this.dah().isPrivacy()) {
                        VideoPbFragment.this.hrE.ceJ();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().getThreadId() != null && VideoPbFragment.this.dah().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                            VideoPbFragment.this.hrE.j(3, i3, VideoPbFragment.this.dah().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dah().getPbData() != null) {
                        VideoPbFragment.this.hrE.j(3, 3, VideoPbFragment.this.dah().getPbData().getThreadId());
                    }
                }
            }
        }
    };
    private View.OnClickListener kIU = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.ley != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.ley.c(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.ley.dc(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.ley.c(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.ley.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jpv = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    public SortSwitchButton.a kNd = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean yk(int i) {
            if (VideoPbFragment.this.ley != null) {
                VideoPbFragment.this.ley.deI();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dah() == null || VideoPbFragment.this.dah().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cpE();
                VideoPbFragment.this.dep();
                if (VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().kFn != null && VideoPbFragment.this.dah().getPbData().kFn.size() > i) {
                    int intValue = VideoPbFragment.this.dah().getPbData().kFn.get(i).sort_type.intValue();
                    TiebaStatic.log(new aq("c13699").dF("tid", VideoPbFragment.this.dah().dcg()).dF("fid", VideoPbFragment.this.dah().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()).ai("obj_type", EH(intValue)));
                    if (VideoPbFragment.this.dah().EO(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int EH(int i) {
            if (i == 2) {
                return 1;
            }
            if (i == 0) {
                return 2;
            }
            if (i == 1) {
                return 3;
            }
            return 0;
        }
    };
    private a lez = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dbn() {
        if (dah() != null && dah().getPbData() != null && dah().getPbData().cYR() != null) {
            bw cYR = dah().getPbData().cYR();
            cYR.mRecomAbTag = dah().dda();
            cYR.mRecomWeight = dah().dcY();
            cYR.mRecomSource = dah().dcZ();
            cYR.mRecomExtra = dah().ddb();
            if (cYR.getFid() == 0) {
                cYR.setFid(com.baidu.adp.lib.f.b.toLong(dah().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cYR, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tb(boolean z) {
        if (dah() != null && dah().getPbData() != null && dah().getPbData().cYR() != null) {
            bw cYR = dah().getPbData().cYR();
            cYR.mRecomAbTag = dah().dda();
            cYR.mRecomWeight = dah().dcY();
            cYR.mRecomSource = dah().dcZ();
            cYR.mRecomExtra = dah().ddb();
            if (cYR.getFid() == 0) {
                cYR.setFid(com.baidu.adp.lib.f.b.toLong(dah().getForumId(), 0L));
            }
            aq a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), cYR, "c13563");
            TbPageTag en = com.baidu.tbadk.pageInfo.c.en(getContext());
            if (a2 != null && en != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(en.locatePage)) {
                a2.dF("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dF("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.ai("reply_type", 1);
                if (z) {
                    a2.ai("obj_type", 2);
                } else {
                    a2.ai("obj_type", 1);
                }
                TiebaStatic.log(a2);
            }
        }
    }

    public void a(int i, boolean z, String str, boolean z2) {
        hideProgressBar();
        if (z && z2) {
            showToast(getPageContext().getString(R.string.success));
        } else if (z2) {
            if (at.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.mro) ? bVar.mro : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.zV(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.id(true);
                aVar.b(getPageContext());
                aVar.bia();
            } else {
                a(0, bVar.Qx, bVar.mro, z);
            }
            if (bVar.Qx) {
                if (bVar.hGO == 1) {
                    ArrayList<PostData> cYT = dah().getPbData().cYT();
                    int size = cYT.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(cYT.get(i).getId())) {
                            i++;
                        } else {
                            cYT.remove(i);
                            break;
                        }
                    }
                    dah().getPbData().cYR().nr(dah().getPbData().cYR().bfp() - 1);
                    if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
                        dhK().dit();
                    } else if (dhI() != null) {
                        dhI().dit();
                    }
                } else if (bVar.hGO == 0) {
                    dbo();
                } else if (bVar.hGO == 2) {
                    ArrayList<PostData> cYT2 = dah().getPbData().cYT();
                    int size2 = cYT2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= cYT2.get(i2).dAA().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(cYT2.get(i2).dAA().get(i3).getId())) {
                                i3++;
                            } else {
                                cYT2.get(i2).dAA().remove(i3);
                                cYT2.get(i2).dAC();
                                z2 = true;
                                break;
                            }
                        }
                        cYT2.get(i2).Rn(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
                            dhK().dit();
                        } else if (dhI() != null) {
                            dhI().dit();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dah().getPbData().cZf().kGS;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dAA().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dAA().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dAA().remove(i2);
                    list.get(i).dAC();
                    z = true;
                    break;
                }
            }
            list.get(i).Rn(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
                dhK().dit();
            } else if (dhI() != null) {
                dhI().dit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        if (gVar != null && dah() != null && dah().getPbData() != null && dah().getPbData().cYR() != null) {
            a(this.hrC.getLoadDataMode(), gVar.Qx, gVar.mro, false);
            if (gVar.Qx) {
                this.kMg = true;
                if (i == 2 || i == 3) {
                    this.kMh = true;
                    this.kMi = false;
                } else if (i == 4 || i == 5) {
                    this.kMh = false;
                    this.kMi = true;
                }
                if (i == 2) {
                    dah().getPbData().cYR().nu(1);
                    dah().setIsGood(1);
                } else if (i == 3) {
                    dah().getPbData().cYR().nu(0);
                    dah().setIsGood(0);
                } else if (i == 4) {
                    dah().getPbData().cYR().nt(1);
                    dah().EI(1);
                } else if (i == 5) {
                    dah().getPbData().cYR().nt(0);
                    dah().EI(0);
                }
            }
            if (dah().getPbData().cYR() != null && dhJ() != null) {
                dhJ().diD();
            }
        }
    }

    private void dbo() {
        if (dah().dci() || dah().dck()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dah().dcf());
            PbActivity pbActivity = this.kLA;
            PbActivity pbActivity2 = this.kLA;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dah().dcf()));
        if (dbr()) {
            this.kLA.finish();
        }
    }

    private boolean dbr() {
        if (dah() == null) {
            return true;
        }
        if (dah().getPbData() == null || !dah().getPbData().cZu()) {
            if (dah().bbu()) {
                final MarkData dcz = dah().dcz();
                if (dcz == null || !dah().getIsFromMark() || csy() == null) {
                    return true;
                }
                final MarkData EP = dah().EP(csy().getFirstVisiblePosition());
                if (EP == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dcz);
                    this.kLA.setResult(-1, intent);
                    return true;
                } else if (EP.getPostId() == null || EP.getPostId().equals(dcz.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dcz);
                    this.kLA.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.zV(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.kMd != null) {
                                if (VideoPbFragment.this.kMd.bbu()) {
                                    VideoPbFragment.this.kMd.bbv();
                                    VideoPbFragment.this.kMd.hy(false);
                                }
                                VideoPbFragment.this.kMd.a(EP);
                                VideoPbFragment.this.kMd.hy(true);
                                VideoPbFragment.this.kMd.bbw();
                            }
                            dcz.setPostId(EP.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dcz);
                            VideoPbFragment.this.kLA.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dau();
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dcz);
                            VideoPbFragment.this.kLA.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dau();
                        }
                    });
                    aVar.c(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bia();
                    return false;
                }
            } else if (dah().getPbData() == null || dah().getPbData().cYT() == null || dah().getPbData().cYT().size() <= 0 || !dah().getIsFromMark()) {
                return true;
            } else {
                this.kLA.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dau() {
        this.kLA.dau();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void ul(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dah() != null && this.ley != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dah().getPbData()) != null) {
                bw cYR = pbData.cYR();
                if (cYR != null && cYR.bfy() != null) {
                    TiebaStatic.log(new aq("c13402").dF("tid", dah().dcf()).dF("fid", pbData.getForumId()).ai("obj_locate", 4).dF("uid", cYR.bfy().getUserId()));
                }
                if (cYR != null) {
                    if (cYR.beg()) {
                        i = 2;
                    } else if (cYR.beh()) {
                        i = 3;
                    } else if (cYR.bht()) {
                        i = 4;
                    } else if (cYR.bhu()) {
                        i = 5;
                    }
                    aq aqVar = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    aqVar.dF("tid", dah().dcf());
                    aqVar.dF("uid", TbadkCoreApplication.getCurrentAccount());
                    aqVar.dF("fid", dah().getForumId());
                    if (!z) {
                        aqVar.ai("obj_locate", 6);
                    } else {
                        aqVar.ai("obj_locate", 5);
                    }
                    aqVar.ai("obj_name", i);
                    aqVar.ai("obj_type", 2);
                    if (cYR != null) {
                        if (cYR.beg()) {
                            aqVar.ai("obj_type", 10);
                        } else if (cYR.beh()) {
                            aqVar.ai("obj_type", 9);
                        } else if (cYR.bhu()) {
                            aqVar.ai("obj_type", 8);
                        } else if (cYR.bht()) {
                            aqVar.ai("obj_type", 7);
                        } else if (cYR.isShareThread) {
                            aqVar.ai("obj_type", 6);
                        } else if (cYR.threadType == 0) {
                            aqVar.ai("obj_type", 1);
                        } else if (cYR.threadType == 40) {
                            aqVar.ai("obj_type", 2);
                        } else if (cYR.threadType == 49) {
                            aqVar.ai("obj_type", 3);
                        } else if (cYR.threadType == 54) {
                            aqVar.ai("obj_type", 4);
                        } else {
                            aqVar.ai("obj_type", 5);
                        }
                        aqVar.dF("nid", cYR.getNid());
                        aqVar.ai(IntentConfig.CARD_TYPE, cYR.bhx());
                        aqVar.dF(IntentConfig.RECOM_SOURCE, cYR.mRecomSource);
                        aqVar.dF("ab_tag", cYR.mRecomAbTag);
                        aqVar.dF("weight", cYR.mRecomWeight);
                        aqVar.dF("extra", cYR.mRecomExtra);
                        aqVar.dF("nid", cYR.getNid());
                        if (cYR.getBaijiahaoData() != null && !at.isEmpty(cYR.getBaijiahaoData().oriUgcVid)) {
                            aqVar.dF("obj_param6", cYR.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        aqVar.dF("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (dbM() != null) {
                        com.baidu.tbadk.pageInfo.c.b(dbM(), aqVar);
                    }
                    TiebaStatic.log(aqVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dah().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> cYT = pbData.cYT();
                        if ((cYT == null || cYT.size() <= 0) && dah().dch()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.ley.deI();
                        cpE();
                        TiebaStatic.log(new aq("c11939"));
                        if (!AntiHelper.d(getContext(), cYR)) {
                            if (this.kUd != null) {
                                this.kUd.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                EF(z ? 2 : 1);
                                return;
                            }
                            this.ley.showLoadingDialog();
                            dah().dcK().A(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                aq aqVar2 = new aq(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                aqVar2.dF("tid", dah().dcf());
                aqVar2.dF("uid", TbadkCoreApplication.getCurrentAccount());
                aqVar2.dF("fid", dah().getForumId());
                if (!z) {
                }
                aqVar2.ai("obj_name", i);
                aqVar2.ai("obj_type", 2);
                if (cYR != null) {
                }
                if (!at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (dbM() != null) {
                }
                TiebaStatic.log(aqVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dhp() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        e eVar = (e) y.b(getActivity()).l(e.class);
        J(eVar.dhV());
        K(eVar.dhV());
        if (dah() != null && dah().getPbData() != null) {
            boolean isFromMark = dah().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dah().getPbData();
            if (isFromMark) {
                PostData I = I(pbData);
                if (pbData.bbt() != null && !pbData.bbt().equals(I.getId()) && this.ekP != null) {
                    if (com.baidu.tbadk.a.d.baW()) {
                        this.ekP.setCurrentItem(led);
                    } else {
                        this.ekP.setCurrentItem(lec);
                    }
                }
            }
        }
        eVar.dhW().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                BdTypeRecyclerView csy;
                if (bwVar != null && bwVar.bfQ() != null) {
                    if (VideoPbFragment.this.lek.getVideoUrl() == null || !VideoPbFragment.this.lek.getVideoUrl().equals(bwVar.bfQ().video_url)) {
                        if (!at.isEmpty(VideoPbFragment.this.lek.getVideoUrl())) {
                            VideoPbFragment.this.kLN = true;
                            if (com.baidu.tbadk.a.d.baW()) {
                                VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.led);
                            } else {
                                VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.leb);
                            }
                            if (com.baidu.tbadk.a.d.baW() && (csy = VideoPbFragment.this.csy()) != null) {
                                csy.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.lel == null || !VideoPbFragment.this.lel.isPlaying()) {
                            VideoPbFragment.this.dhq();
                            VideoPbFragment.this.aN(bwVar);
                        }
                        VideoPbFragment.this.dhr();
                        if (VideoPbFragment.this.lel.dij()) {
                            VideoPbFragment.this.lel.start();
                        }
                        boolean z = !at.equals(VideoPbFragment.this.lek.getVideoUrl(), bwVar.bfQ().video_url);
                        VideoPbFragment.this.lek.setData(bwVar);
                        if (com.baidu.tbadk.a.d.baW()) {
                            VideoPbFragment.this.lek.uu(false);
                        } else {
                            VideoPbFragment.this.lek.uu(VideoPbFragment.this.ekP.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.lek.startPlay();
                            VideoPbFragment.this.lek.diV();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.lek.setData(bwVar);
                }
            }
        });
        eVar.dif().observe(this, new q<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.ekP.setCurrentItem(num.intValue());
            }
        });
        eVar.dia().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.lek.aS(bwVar);
            }
        });
        eVar.dib().observe(this, new q<bw>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: aO */
            public void onChanged(@Nullable bw bwVar) {
                VideoPbFragment.this.lek.aT(bwVar);
            }
        });
        eVar.dic().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dhB();
            }
        });
        eVar.did().observe(this, new q<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.arch.lifecycle.q
            /* renamed from: q */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhq() {
        ViewGroup.LayoutParams layoutParams = this.leo.getLayoutParams();
        layoutParams.height = 0;
        this.leo.setLayoutParams(layoutParams);
        this.leo.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhr() {
        if (this.lel == null) {
            this.lel = new f(getBaseFragmentActivity(), this.lej);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(dbM()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.lej.getOriginHeight() + statusBarHeight);
            final e eVar = (e) y.b(getActivity()).l(e.class);
            this.lel.b(eVar.dhX(), rect);
            if (this.lel.dij()) {
                this.lel.a(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.baW()) {
                            if (eVar.dhY() || VideoPbFragment.this.dah().getTabIndex() == VideoPbFragment.led) {
                                VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.led);
                            }
                        } else if (eVar.dhY() || VideoPbFragment.this.dah().getTabIndex() == VideoPbFragment.lec) {
                            VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.lec);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.baW()) {
                            if (eVar.dhY() || VideoPbFragment.this.dah().getTabIndex() == VideoPbFragment.led) {
                                VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.led);
                            }
                        } else if (eVar.dhY() || VideoPbFragment.this.dah().getTabIndex() == VideoPbFragment.lec) {
                            VideoPbFragment.this.ekP.setCurrentItem(VideoPbFragment.lec);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.baW()) {
                if (eVar.dhY() || dah().getTabIndex() == led) {
                    this.ekP.setCurrentItem(led);
                }
            } else if (eVar.dhY() || dah().getTabIndex() == lec) {
                this.ekP.setCurrentItem(lec);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.leE && (this.leF || dhP())) {
            dhO();
            UtilHelper.hideStatusBar(dbM(), dbM().getRootView());
            this.leF = false;
            if (this.lek != null) {
                this.lek.un(false);
            }
        }
        if (i == 4) {
            return this.lek.doh();
        }
        if (i == 24) {
            return this.lek.diS();
        }
        if (i == 25) {
            return this.lek.diT();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void aN(bw bwVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect ddc;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (bwVar != null && bwVar.bfQ() != null) {
            int intValue = bwVar.bfQ().video_width.intValue();
            int intValue2 = bwVar.bfQ().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dah() != null || (ddc = dah().ddc()) == null) ? ceil : ddc.height();
                i = 0;
                layoutParams = this.lej.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.lej.setLayoutParams(layoutParams);
                this.lej.setMaxHeight(ceil);
                this.lej.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.lej.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.baW()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.lef.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, lee);
                    } else {
                        layoutParams3.height = lee;
                    }
                    this.lef.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.XP.getLayoutParams();
                if (!com.baidu.tbadk.a.d.baW()) {
                    ceil += lee;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.XP.setLayoutParams(layoutParams2);
                if (i == 0 && (this.XP.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.XP.getLayoutParams()).getBehavior();
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
        if (dah() != null) {
        }
        i = 0;
        layoutParams = this.lej.getLayoutParams();
        if (layoutParams != null) {
        }
        this.lej.setLayoutParams(layoutParams);
        this.lej.setMaxHeight(ceil2);
        this.lej.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.lej.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.baW()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.XP.getLayoutParams();
        if (!com.baidu.tbadk.a.d.baW()) {
        }
        if (layoutParams2 != null) {
        }
        this.XP.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.kLH = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        ar(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.kMy = new com.baidu.tbadk.core.view.c();
        this.kMy.toastTime = 1000L;
        if (this.ley != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.ley.kMz;
            userMuteAddAndDelCustomMessage.setTag(this.ley.kMz);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.ley.kMz;
            userMuteCheckCustomMessage.setTag(this.ley.kMz);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.hrE = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dzC().z(getUniqueId());
    }

    private void initData() {
        this.kMd = com.baidu.tbadk.baseEditMark.a.a(this.kLA);
        if (this.kMd != null) {
            this.kMd.a(this.kNj);
        }
        this.hrC = new ForumManageModel(this.kLA);
        this.hrC.setLoadDataCallBack(this.hrJ);
        this.emW = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.ley = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void ar(Bundle bundle) {
        this.kMq = new g();
        d(this.kMq);
        this.kMr = (com.baidu.tbadk.editortools.pb.e) this.kMq.eb(getActivity());
        this.kMr.a(this.kLA.getPageContext());
        this.kMr.a(this.ePy);
        this.kMr.a(this.ePr);
        this.kMr.setFrom(1);
        this.kMr.a(this.kLA.getPageContext(), bundle);
        this.kMr.bsv().c(new com.baidu.tbadk.editortools.k(getActivity()));
        this.kMr.bsv().jh(true);
        ta(true);
        this.kMr.a(dah().dcv(), dah().dcf(), dah().dcM());
        registerListener(this.kMO);
        registerListener(this.kNi);
        registerListener(this.kMN);
        registerListener(this.kML);
        registerListener(this.ibw);
        if (!dah().dcm()) {
            this.kMr.Cv(dah().dcf());
        }
        if (dah().dcN()) {
            this.kMr.Ct(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.kMr.Ct(ddW());
        }
        this.jSk = new bb();
        if (this.kMr.btb() != null) {
            this.jSk.e(this.kMr.btb().getInputView());
        }
        this.kMr.a(this.ePs);
        this.jOf = new am(getPageContext());
        this.jOf.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == am.emR) {
                        VideoPbFragment.this.kMr.a((String) null, (WriteData) null);
                    } else if (i == am.emS && VideoPbFragment.this.kUF != null && VideoPbFragment.this.kUF.daR() != null) {
                        VideoPbFragment.this.kUF.daR().btz();
                    } else if (i == am.emT) {
                        VideoPbFragment.this.c(VideoPbFragment.this.kMu);
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
        this.ieU = new com.baidu.tieba.f.b(getActivity());
        this.ieU.a(kNr);
        this.leE = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bvT();
        this.XP = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.leh = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.lej = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.lek = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.lej);
        this.lek.setStageType("2002");
        this.lek.setUniqueId(getUniqueId());
        this.lek.af(this);
        this.lek.dj(dbM().getRootView());
        this.lek.dk(this.lem);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.lef = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.leo = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.ekP = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.lei = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lei.setOnClickListener(this.aBS);
        dht();
        dhs();
        dhu();
        this.leg = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.ekP.setAdapter(this.leg);
        this.lef.setViewPager(this.ekP);
        this.lef.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null) {
                        VideoPbFragment.this.dhK().ut(false);
                    } else if (VideoPbFragment.this.dhI() != null) {
                        VideoPbFragment.this.dhI().ut(false);
                    }
                    if (VideoPbFragment.this.dhJ() != null) {
                        VideoPbFragment.this.dhJ().ut(true);
                        VideoPbFragment.this.Fo(VideoPbFragment.this.dhJ().dix() != 0 ? 0 : 8);
                    }
                    e eVar = (e) y.b(VideoPbFragment.this.getActivity()).l(e.class);
                    if (eVar.dic() != null && eVar.dic().getValue() != null && eVar.dic().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.lek.uu(z);
                    VideoPbFragment.this.ddU();
                    if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                        TiebaStatic.log(new aq("c13592").dF("tid", VideoPbFragment.this.dah().dcf()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dhJ() != null) {
                        VideoPbFragment.this.dhJ().ut(false);
                    }
                    if (com.baidu.tbadk.a.d.baW() && VideoPbFragment.this.dhK() != null) {
                        VideoPbFragment.this.dhK().ut(true);
                        int dix = VideoPbFragment.this.dhK().dix();
                        int diy = VideoPbFragment.this.dhK().diy();
                        if (dix != 0) {
                            VideoPbFragment.this.Fo(8);
                            VideoPbFragment.this.dhK().Fo(0);
                        } else if (diy != 0) {
                            VideoPbFragment.this.dhK().Fo(8);
                            VideoPbFragment.this.Fo(0);
                        } else {
                            VideoPbFragment.this.dhK().Fo(8);
                            VideoPbFragment.this.Fo(8);
                        }
                    } else if (VideoPbFragment.this.dhI() != null) {
                        VideoPbFragment.this.dhI().ut(true);
                        int dix2 = VideoPbFragment.this.dhI().dix();
                        int diy2 = VideoPbFragment.this.dhI().diy();
                        if (dix2 != 0) {
                            VideoPbFragment.this.Fo(8);
                            VideoPbFragment.this.dhI().Fo(0);
                        } else if (diy2 != 0) {
                            VideoPbFragment.this.dhI().Fo(8);
                            VideoPbFragment.this.Fo(0);
                        } else {
                            VideoPbFragment.this.dhI().Fo(8);
                            VideoPbFragment.this.Fo(8);
                        }
                    }
                    VideoPbFragment.this.lek.uu(false);
                    VideoPbFragment.this.XP.setExpanded(false, true);
                    if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                        TiebaStatic.log(new aq("c13593").dF("tid", VideoPbFragment.this.dah().dcf()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.leg.Fq(i);
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.kTF = this.rootView.findViewById(R.id.viewstub_progress);
        dhv();
        bMd();
        if (!this.leE && this.leF) {
            dhO();
            UtilHelper.hideStatusBar(dbM(), dbM().getRootView());
            this.leF = false;
        }
        if (com.baidu.tbadk.a.d.baW()) {
            this.lef.getLayoutParams().height = 0;
        }
    }

    private void dhs() {
        this.leq = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.leu = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.ler = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.les = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.let = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.lev = this.rootView.findViewById(R.id.ala_live_point);
        this.leu.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.leu.setConrers(15);
        this.let.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.les.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.kFX == null || VideoPbFragment.this.kFX.diJ()) {
                    if (VideoPbFragment.this.kFX != null) {
                        TiebaStatic.log(new aq("c13608").dF("tid", VideoPbFragment.this.dah().getPbData().getThreadId()));
                        VideoPbFragment.this.kFX.lgB = true;
                    }
                } else {
                    TiebaStatic.log(new aq("c13591"));
                }
                VideoPbFragment.this.dhD();
            }
        });
        this.let.setOnClickListener(this.lep);
        this.leo.setOnClickListener(this.lep);
    }

    private void dht() {
        this.lef.setDefaultSelectorColorResourceId(R.color.cp_cont_b);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.lef.setContainerLayoutParams(layoutParams);
        this.lef.setRectPaintColor(R.color.cp_link_tip_a);
        this.lef.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.lef.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.lef.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.lef.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.lef.setExpandedTabLayoutParams(layoutParams2);
    }

    public void um(boolean z) {
        if (this.XP != null) {
            this.XP.setExpanded(z);
        }
    }

    private void dhu() {
        this.kTW = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.kTX = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.kUh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.kUi = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.kTZ = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.kTZ.setVisibility(0);
        this.kTZ.setIsRound(true);
        this.kTZ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.kTZ.setBorderColor(ap.getColor(R.color.cp_border_a));
        this.kTZ.setPlaceHolder(1);
        this.kTZ.setDefaultResource(R.color.cp_bg_line_e);
        if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.kTZ.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
        }
        this.jcG = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.kTY = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.kTY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.um(false);
                VideoPbFragment.this.dbd();
                if (VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().cYR() != null && VideoPbFragment.this.dah().getPbData().cYR().bfy() != null) {
                    TiebaStatic.log(new aq("c13701").dF("tid", VideoPbFragment.this.dah().dcg()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).u("uid", TbadkCoreApplication.getCurrentAccountId()));
                    TiebaStatic.log(new aq("c13402").dF("tid", VideoPbFragment.this.dah().dcf()).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).ai("obj_locate", 1).dF("uid", VideoPbFragment.this.dah().getPbData().cYR().bfy().getUserId()));
                }
            }
        });
        this.kUa = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.kUa.setOnClickListener(this.aBS);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.kUb = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.kUb.setOnClickListener(this.aBS);
        if (booleanExtra) {
            this.kUb.setVisibility(8);
        } else {
            this.kUb.setVisibility(0);
        }
        this.kUc = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.kUc.setOnClickListener(this.aBS);
        this.kUd = new com.baidu.tieba.pb.view.c(this.kUc);
        this.kUd.dje();
        this.kUe = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.kUe.setVisibility(0);
        tL(false);
    }

    private void bvT() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cpF();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.lem = this.rootView.findViewById(R.id.status_bar_background);
        if (this.leE) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(dbM());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.lem.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(dbM());
            this.lem.setLayoutParams(layoutParams2);
            this.lem.setVisibility(0);
        }
        this.eXg = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aBS);
        this.gds = (ImageView) this.eXg.findViewById(R.id.widget_navi_back_button);
        SvgManager.bkl().a(this.gds, R.drawable.icon_pure_topbar_return44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kZB = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aBS);
        this.agA = (ImageView) this.kZB.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.kZB.setLayoutParams(layoutParams3);
        SvgManager.bkl().a(this.agA, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.kZB.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.imc);
        this.mNavigationBar.setOnTouchListener(this.leG);
    }

    public void dhv() {
        setEditorTools(this.kMr.bsv());
    }

    private void bMd() {
        this.kLv = new PbFakeFloorModel(getPageContext());
        this.kUF = new v(getPageContext(), this.kLv, this.rootView);
        this.kUF.T(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.ddU();
            }
        });
        this.kUF.a(this.kNf);
        this.kLv.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.kLv.t(postData);
                if (com.baidu.tbadk.a.d.baW() || VideoPbFragment.this.dhK() != null) {
                    VideoPbFragment.this.dhK().dit();
                } else if (VideoPbFragment.this.dhI() != null) {
                    VideoPbFragment.this.dhI().dit();
                }
                VideoPbFragment.this.kUF.daN();
                VideoPbFragment.this.aaS.bqS();
                VideoPbFragment.this.tL(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a NZ;
        String dcf = dah().dcf();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dah().getPbData() != null) {
            i = dah().getPbData().cZg();
        }
        if (dhI() != null && dhI().div() != null) {
            NZ = dhI().div().NZ(id);
        } else if (dhK() != null && dhK().div() != null) {
            NZ = dhK().div().NZ(id);
        } else {
            return;
        }
        if (postData != null && dah() != null && dah().getPbData() != null && NZ != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(dcf, id, "pb", true, null, false, str, i, postData.dgO(), dah().getPbData().getAnti(), false, postData.bfy().getIconInfo()).addBigImageData(NZ.kIp, NZ.dXc, NZ.dXa, NZ.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dah().getForumId());
            addBigImageData.setBjhData(dah().dco());
            addBigImageData.setKeyPageStartFrom(dah().dcP());
            addBigImageData.setFromFrsForumId(dah().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.kLA = (PbActivity) context;
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dah() != null) {
            dah().aC(bundle);
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
        this.bsQ = true;
        getVoiceManager().onPause(getPageContext());
        this.lek.pX(true);
        if (dah() != null && !dah().dcm()) {
            this.kMr.Cu(dah().dcf());
        }
        com.baidu.tbadk.BdToken.c.aZe().aZp();
        MessageManager.getInstance().unRegisterListener(this.kMY);
        MessageManager.getInstance().unRegisterListener(this.kMZ);
        MessageManager.getInstance().unRegisterListener(this.kNa);
        MessageManager.getInstance().unRegisterListener(this.jpv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.bsQ = false;
        getVoiceManager().onResume(getPageContext());
        this.lek.pX(false);
        dbI();
        registerListener(this.kMY);
        registerListener(this.kMZ);
        registerListener(this.kNa);
        registerListener(this.jpv);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.leg != null && this.ekP != null) {
            this.leg.Fq(z ? this.ekP.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        if (this.kTZ != null) {
            this.kTZ.startLoad(TbadkCoreApplication.getCurrentAccountInfo() != null ? TbadkCoreApplication.getCurrentAccountInfo().getAvatar() : null, 12, false);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dzC().A(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.kUd != null) {
            this.kUd.onDestroy();
        }
        if (this.hrC != null) {
            this.hrC.cancelLoadData();
        }
        if (this.lek != null) {
            this.lek.onDestroy();
        }
        if (this.kLS != null) {
            this.kLS.cancelLoadData();
        }
        if (this.jOf != null) {
            this.jOf.onDestroy();
        }
        if (dah() != null) {
            dah().cancelLoadData();
            dah().destory();
            if (dah().dcJ() != null) {
                dah().dcJ().onDestroy();
            }
        }
        if (this.kMr != null) {
            this.kMr.onDestroy();
        }
        this.kMy = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.kLA);
        this.lef.onChangeSkinType();
        ap.setBackgroundColor(this.lef, R.color.cp_bg_line_h);
        this.jSk.onChangeSkinType();
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        if (this.lel == null || !this.lel.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.cp_bg_line_d);
        }
        ap.setBackgroundColor(this.mStatusBar, R.color.cp_mask_b);
        ap.setBackgroundColor(this.lem, R.color.cp_mask_b_alpha66);
        if (this.aaS != null) {
            this.aaS.onChangeSkinType(i);
        }
        if (this.kUF != null) {
            this.kUF.onChangeSkinType(i);
        }
        if (this.jcG != null) {
            ap.setViewTextColor(this.jcG, R.color.cp_cont_d);
        }
        if (this.kTZ != null) {
            this.kTZ.setBorderColor(ap.getColor(R.color.cp_border_a));
        }
        if (this.kTY != null) {
            this.kTY.setBackgroundDrawable(ap.aO(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.cp_bg_line_j)));
        }
        if (this.kUb != null && dah() != null) {
            if (dah().bbu()) {
                SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
        }
        if (this.kUa != null) {
            SvgManager.bkl().a(this.kUa, R.drawable.icon_pure_pb_bottom_comment24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (dah() != null) {
            x(dah().getPbData());
        }
        if (this.kUe != null) {
            ap.c(this.kUe, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.cp_bg_line_h, R.color.cp_bg_line_h);
            ap.setViewTextColor(this.kUe, R.color.cp_cont_j);
        }
        if (this.kUf != null) {
            ap.setViewTextColor(this.kUf, R.color.cp_cont_b);
        }
        if (this.kTW != null) {
            ap.setBackgroundResource(this.kTW, R.drawable.bottom_shadow);
        }
        ap.setBackgroundColor(this.kTX, R.color.cp_bg_line_h);
        if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
            dhK().onChangeSkinType(i);
        } else if (dhI() != null) {
            dhI().onChangeSkinType(i);
        }
        if (dhJ() != null) {
            dhJ().onChangeSkinType(i);
        }
        if (this.leh != null) {
            ap.setBackgroundResource(this.leh, R.drawable.personalize_tab_shadow);
        }
        if (this.leo != null) {
            ap.setBackgroundColor(this.leo, R.color.cp_bg_line_g);
        }
        if (this.les != null) {
            SvgManager.bkl().a(this.les, R.drawable.icon_pure_close16_n_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        if (this.leq != null) {
            ap.setViewTextColor(this.leq, R.color.cp_cont_b);
        }
        if (this.ler != null) {
            ap.setViewTextColor(this.ler, R.color.cp_cont_d);
        }
        if (this.lev != null) {
            this.lev.setBackgroundDrawable(ap.aO(l.getDimens(this.lev.getContext(), R.dimen.tbds32), ap.getColor(R.color.cp_other_c)));
        }
        cpE();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hZU == null) {
            this.hZU = VoiceManager.instance();
        }
        return this.hZU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cpE() {
        if (this.hZU != null) {
            this.hZU.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment dbK() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dbL() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dah() {
        return this.kLA.dah();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity dbM() {
        return this.kLA;
    }

    public com.baidu.tbadk.baseEditMark.a dhw() {
        return this.kMd;
    }

    public View.OnClickListener dhx() {
        return this.aBS;
    }

    public View.OnClickListener dhy() {
        return this.kIU;
    }

    public View.OnLongClickListener dhz() {
        return this.ley.dhz();
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.be.Oo(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView csy() {
        Iterator<BaseFragment> it = this.leg.dhT().iterator();
        while (it.hasNext()) {
            BaseFragment next = it.next();
            if (next instanceof DetailInfoAndReplyFragment) {
                return ((DetailInfoAndReplyFragment) next).getListView();
            }
            if (next instanceof ReplyFragment) {
                return ((ReplyFragment) next).getListView();
            }
        }
        return null;
    }

    private void ta(boolean z) {
        this.kMr.jo(z);
        this.kMr.jp(z);
        this.kMr.jq(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.ley != null) {
            if (z) {
                this.ley.deI();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.ley.deJ();
            } else {
                this.ley.deI();
            }
        }
    }

    public boolean ED(int i) {
        if (this.jOf == null || dah() == null || dah().getPbData() == null || dah().getPbData().getAnti() == null) {
            return true;
        }
        return this.jOf.aN(dah().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dbf() {
        if ((dah() != null && dah().getPbData().cZu()) || this.jOf == null || dah() == null || dah().getPbData() == null || dah().getPbData().getAnti() == null) {
            return true;
        }
        return this.jOf.ob(dah().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dah() != null) {
            gVar.setForumName(dah().cZY());
            if (dah().getPbData() != null && dah().getPbData().getForum() != null) {
                gVar.a(dah().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dah());
        }
    }

    public void dek() {
        if (this.aaS != null) {
            this.aaS.display();
            if (this.kMr != null) {
                this.kMr.btg();
            }
            deS();
        }
    }

    public com.baidu.tbadk.editortools.pb.e daS() {
        return this.kMr;
    }

    private boolean dbc() {
        PbModel dah = dah();
        if (dah == null || dah.getPbData() == null) {
            return false;
        }
        bw cYR = dah.getPbData().cYR();
        dah.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), cYR);
    }

    public void dbd() {
        if (checkUpIsLogin() && dah() != null && dah().getPbData() != null && dah().getPbData().getForum() != null && !dbc()) {
            if (dah().getPbData().cZu()) {
                cCL();
                return;
            }
            if (this.ieu == null) {
                this.ieu = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.ieu.yQ(0);
                this.ieu.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void oC(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void z(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void oD(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.kMr != null && VideoPbFragment.this.kMr.bsv() != null) {
                                VideoPbFragment.this.kMr.bsv().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cCL();
                        }
                    }
                });
            }
            this.ieu.D(dah().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dah().dcf(), 0L));
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.kMr.onActivityResult(i, i2, intent);
        if (this.kLS != null) {
            this.kLS.onActivityResult(i, i2, intent);
        }
        if (this.kUF != null) {
            this.kUF.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dbp();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dqz().F(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.kMu = emotionImageData;
                        if (ED(am.emT)) {
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
        if (dbM() != null) {
            if (this.leF && !TbSingleton.getInstance().isNotchScreen(dbM()) && !TbSingleton.getInstance().isCutoutScreen(dbM())) {
                dhO();
                UtilHelper.hideStatusBar(dbM(), dbM().getRootView());
                this.leF = false;
            }
            this.lez.leU = z;
            dhA();
            dhB();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.kLA;
        if (i == 0) {
            ddQ();
            if (this.kUF != null) {
                this.kUF.daN();
            }
            tL(false);
        }
        ddU();
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
                        this.kMr.resetData();
                        this.kMr.setVoiceModel(pbEditorData.getVoiceModel());
                        this.kMr.b(writeData);
                        m qr = this.kMr.bsv().qr(6);
                        if (qr != null && qr.eMS != null) {
                            qr.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.kLA;
                        if (i == -1) {
                            this.kMr.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.kUF != null && this.kUF.daR() != null) {
                            com.baidu.tbadk.editortools.pb.h daR = this.kUF.daR();
                            daR.setThreadData(dah().getPbData().cYR());
                            daR.b(writeData);
                            daR.setVoiceModel(pbEditorData.getVoiceModel());
                            m qr2 = daR.bsv().qr(6);
                            if (qr2 != null && qr2.eMS != null) {
                                qr2.eMS.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.kLA;
                            if (i == -1) {
                                daR.btz();
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
                if (dah() != null && !dah().dcm()) {
                    antiData.setBlock_forum_name(dah().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dah().getPbData().getForum().getId());
                    antiData.setUser_name(dah().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dah().getPbData().getUserData().getUserId());
                }
                AntiHelper.a(getPageContext().getPageActivity(), antiData, AntiHelper.OperationType.REPLY, PageType.PB);
                return;
            }
            String errorString = postWriteCallBackData.getErrorString();
            String preMsg = postWriteCallBackData.getPreMsg();
            String colorMsg = postWriteCallBackData.getColorMsg();
            if (postWriteCallBackData.getIconStampData() != null) {
                com.baidu.tbadk.coreExtra.c.b.a(getPageContext(), postWriteCallBackData);
            } else {
                com.baidu.tieba.tbadkCore.writeModel.c.g(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bC(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).ai("obj_locate", ax.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new aq(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).ai("obj_locate", ax.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.ley != null) {
                this.ley.CA(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dbO() {
        if (dah() != null && this.kLA != null) {
            if (this.kMr == null || !this.kMr.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.kMr = (com.baidu.tbadk.editortools.pb.e) dVar.eb(getContext());
                this.kMr.a(this.kLA.getPageContext());
                this.kMr.a(this.ePy);
                this.kMr.a(this.ePr);
                this.kMr.a(this.kLA.getPageContext(), this.kLA.getIntent() == null ? null : this.kLA.getIntent().getExtras());
                this.kMr.bsv().jh(true);
                setEditorTools(this.kMr.bsv());
                if (!dah().dcm()) {
                    this.kMr.Cv(dah().dcf());
                }
                if (dah().dcN()) {
                    this.kMr.Ct(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.kMr.Ct(ddW());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.aaS = editorTools;
        this.aaS.setId(R.id.pb_editor);
        this.aaS.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.ddU();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.aaS.getParent() == null) {
            this.rootView.addView(this.aaS, layoutParams);
        }
        this.aaS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.aaS.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bnJ() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bnJ() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.kMr.c((u) aVar.data);
                            VideoPbFragment.this.kMr.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        ddQ();
        this.kMr.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.aaS != null && VideoPbFragment.this.aaS.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.jSk != null && VideoPbFragment.this.jSk.dfj() != null) {
                    if (!VideoPbFragment.this.jSk.dfj().dJA()) {
                        VideoPbFragment.this.jSk.tR(false);
                    }
                    VideoPbFragment.this.jSk.dfj().xj(false);
                }
            }
        });
    }

    public void cCL() {
        if (!checkUpIsLogin()) {
            if (dah() != null) {
                TiebaStatic.log(new aq("c10517").ai("obj_locate", 2).dF("fid", dah().getForumId()));
            }
        } else if (dbf()) {
            if (this.kMr != null && (this.kMr.btq() || this.kMr.btr())) {
                this.kMr.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.aaS != null) {
                dek();
                this.lez.leT = false;
                if (this.aaS.qr(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.aaS.qr(2).eMS, false, null);
                }
            }
            deS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dbc() && dbf()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.kLU);
                this.kLV = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.kUF != null && postData != null) {
                String str3 = "";
                if (postData.dAF() != null) {
                    str3 = postData.dAF().toString();
                }
                this.kUF.NT(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bfy().getName_show(), str3));
            }
            if (dah() != null && dah().getPbData() != null && dah().getPbData().cZu()) {
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.kLA.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.kLU[1] + VideoPbFragment.this.kLV) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.csy() != null) {
                            VideoPbFragment.this.csy().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kUF != null) {
                            VideoPbFragment.this.kMr.bsv().setVisibility(8);
                            VideoPbFragment.this.kUF.h(str, str2, VideoPbFragment.this.ddW(), (VideoPbFragment.this.dah() == null || VideoPbFragment.this.dah().getPbData() == null || VideoPbFragment.this.dah().getPbData().cYR() == null || !VideoPbFragment.this.dah().getPbData().cYR().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h daR = VideoPbFragment.this.kUF.daR();
                            if (daR != null && VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                                daR.a(VideoPbFragment.this.dah().getPbData().getAnti());
                                daR.setThreadData(VideoPbFragment.this.dah().getPbData().cYR());
                            }
                            if (VideoPbFragment.this.jSk.dfl() == null && VideoPbFragment.this.kUF.daR().btH() != null) {
                                VideoPbFragment.this.kUF.daR().btH().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jSk != null && VideoPbFragment.this.jSk.dfk() != null) {
                                            if (!VideoPbFragment.this.jSk.dfk().dJA()) {
                                                VideoPbFragment.this.jSk.tS(false);
                                            }
                                            VideoPbFragment.this.jSk.dfk().xj(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jSk.f(VideoPbFragment.this.kUF.daR().btH().getInputView());
                                VideoPbFragment.this.kUF.daR().a(VideoPbFragment.this.kMw);
                            }
                        }
                        VideoPbFragment.this.deS();
                    }
                }, 0L);
                return;
            }
            if (this.kMt == null) {
                this.kMt = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.kMt.yQ(1);
                this.kMt.a(new AnonymousClass48(str, str2));
            }
            if (dah() != null && dah().getPbData() != null && dah().getPbData().getForum() != null) {
                this.kMt.D(dah().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dah().dcf(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$48  reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass48 implements c.a {
        final /* synthetic */ String kNB;
        final /* synthetic */ String kNC;

        AnonymousClass48(String str, String str2) {
            this.kNB = str;
            this.kNC = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oD(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.kLU[1] + VideoPbFragment.this.kLV) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.csy() != null) {
                            VideoPbFragment.this.csy().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.kUF != null) {
                            VideoPbFragment.this.kMr.bsv().setVisibility(8);
                            VideoPbFragment.this.kUF.h(AnonymousClass48.this.kNB, AnonymousClass48.this.kNC, VideoPbFragment.this.ddW(), (VideoPbFragment.this.dah() == null || VideoPbFragment.this.dah().getPbData() == null || VideoPbFragment.this.dah().getPbData().cYR() == null || !VideoPbFragment.this.dah().getPbData().cYR().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h daR = VideoPbFragment.this.kUF.daR();
                            if (daR != null && VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null) {
                                daR.a(VideoPbFragment.this.dah().getPbData().getAnti());
                                daR.setThreadData(VideoPbFragment.this.dah().getPbData().cYR());
                            }
                            if (VideoPbFragment.this.jSk.dfl() == null && VideoPbFragment.this.kUF.daR().btH() != null) {
                                VideoPbFragment.this.kUF.daR().btH().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.jSk != null && VideoPbFragment.this.jSk.dfk() != null) {
                                            if (!VideoPbFragment.this.jSk.dfk().dJA()) {
                                                VideoPbFragment.this.jSk.tS(false);
                                            }
                                            VideoPbFragment.this.jSk.dfk().xj(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.jSk.f(VideoPbFragment.this.kUF.daR().btH().getInputView());
                                VideoPbFragment.this.kUF.daR().a(VideoPbFragment.this.kMw);
                            }
                        }
                        VideoPbFragment.this.deS();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData I;
        ab abVar;
        StringBuilder sb = null;
        if (fVar != null && (I = I(fVar)) != null) {
            String userId = I.bfy().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cZg()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (I.bfy() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, I.bfy().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, I.bfy().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, I.bfy().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, I.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, I.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.cZg()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bs> cZo = fVar.cZo();
                if (com.baidu.tbadk.core.util.y.getCount(cZo) > 0) {
                    sb = new StringBuilder();
                    for (bs bsVar : cZo) {
                        if (bsVar != null && !StringUtils.isNull(bsVar.getForumName()) && (abVar = bsVar.ecI) != null && abVar.eau && !abVar.eav && (abVar.type == 1 || abVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bsVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dbp() {
        MarkData EP;
        if (dah() != null && dah().getPbData() != null) {
            if (com.baidu.tbadk.a.d.baW() || dhI() != null) {
                if ((!com.baidu.tbadk.a.d.baW() || dhK() != null) && this.kMd != null) {
                    if (dah().getPbData() != null && dah().getPbData().cZu()) {
                        EP = dah().EP(0);
                    } else if (this.ekP != null && this.ekP.getCurrentItem() == leb) {
                        EP = dah().o(I(dah().getPbData()));
                    } else if (com.baidu.tbadk.a.d.baW()) {
                        EP = dah().EP(dhK().deu());
                    } else {
                        EP = dah().EP(dhI().deu());
                    }
                    if (EP != null) {
                        if (!EP.isApp() || (EP = dah().EP(dhI().deu() + 1)) != null) {
                            dep();
                            this.kMd.a(EP);
                            if (!this.kMd.bbu()) {
                                this.kMd.bbw();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.kMd.bbv();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean EE(int i) {
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
            if (this.kLS == null) {
                this.kLS = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.kLA);
                this.kLS.b(this.ePr);
                this.kLS.c(this.ePy);
            }
            this.kLS.a(emotionImageData, dah(), dah().getPbData());
        }
    }

    public PostData I(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.cZe() != null) {
            return fVar.cZe();
        }
        if (!com.baidu.tbadk.core.util.y.isEmpty(fVar.cYT())) {
            Iterator<PostData> it = fVar.cYT().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dAD() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.cZa();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bfy() != null && postData.bfy().getUserTbVipInfoData() != null && postData.bfy().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bfy().getGodUserData().setIntro(postData.bfy().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.cYR() == null || fVar.cYR().bfy() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bfy = fVar.cYR().bfy();
        String userId = bfy.getUserId();
        HashMap<String, MetaData> userMap = fVar.cYR().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bfy;
        }
        postData.Is(1);
        postData.setId(fVar.cYR().bfP());
        postData.setTitle(fVar.cYR().getTitle());
        postData.setTime(fVar.cYR().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dbu() {
        ArrayList<PostData> cYT;
        int count;
        int i;
        if (dah() == null || dah().getPbData() == null || dah().getPbData().cYT() == null || (count = com.baidu.tbadk.core.util.y.getCount((cYT = dah().getPbData().cYT()))) == 0) {
            return "";
        }
        if (dah().dcx()) {
            Iterator<PostData> it = cYT.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dAD() == 1) {
                    return next.getId();
                }
            }
        }
        if (csy() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.baW()) {
            i = dhK().det();
        } else {
            i = dhI().det();
        }
        PostData postData = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, i);
        if (postData == null || postData.bfy() == null) {
            return "";
        }
        if (dah().Oc(postData.bfy().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, i2);
            if (postData2 == null || postData2.bfy() == null || postData2.bfy().getUserId() == null) {
                break;
            } else if (dah().Oc(postData2.bfy().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) com.baidu.tbadk.core.util.y.getItem(cYT, i3);
            if (postData3 == null || postData3.bfy() == null || postData3.bfy().getUserId() == null) {
                return "";
            }
            if (dah().Oc(postData3.bfy().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbq() {
        if (dah() != null) {
            com.baidu.tieba.pb.data.f pbData = dah().getPbData();
            dah().tq(true);
            if (this.kMd != null) {
                pbData.NN(this.kMd.bbt());
            }
            if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
                dhK().dit();
            } else if (dhI() != null) {
                dhI().dit();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dah() != null) {
            der();
            dah().tq(z);
            if (this.kMd != null) {
                this.kMd.hy(z);
                if (markData != null) {
                    this.kMd.a(markData);
                }
            }
            if (dah().bbu()) {
                dbq();
            } else if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
                dhK().dit();
            } else if (dhI() != null) {
                dhI().dit();
            }
        }
    }

    public void b(p pVar) {
        boolean z;
        MetaData metaData;
        if (dah() != null && dah().getPbData() != null && pVar.cZH() != null) {
            String id = pVar.cZH().getId();
            ArrayList<PostData> cYT = dah().getPbData().cYT();
            int i = 0;
            while (true) {
                if (i >= cYT.size()) {
                    z = true;
                    break;
                }
                PostData postData = cYT.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> cZP = pVar.cZP();
                    postData.Ir(pVar.getTotalCount());
                    if (postData.dAA() == null || cZP == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = cZP.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bfy() != null && (metaData = postData.getUserMap().get(next.bfy().getUserId())) != null) {
                                next.a(metaData);
                                next.wn(true);
                                next.a(getPageContext(), dah().Oc(metaData.getUserId()));
                            }
                        }
                        z = cZP.size() != postData.dAA().size();
                        if (postData.dAA() != null && postData.dAA().size() < 2) {
                            postData.dAA().clear();
                            postData.dAA().addAll(cZP);
                        }
                    }
                    if (postData.dAw() != null) {
                        postData.dAx();
                    }
                }
            }
            if (!dah().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
                    dhK().dit();
                } else if (dhI() != null) {
                    dhI().dit();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbh() {
        if (dah() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.Qx(dah().getForumId()) && dah().getPbData() != null && dah().getPbData().getForum() != null) {
            if (dah().getPbData().getForum().isLike() == 1) {
                dah().dcL().fW(dah().getForumId(), dah().dcf());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            bw cYR = fVar.cYR();
            if (cYR != null && cYR.bei()) {
                dbO();
            } else {
                d(this.kMq);
            }
            if (this.kMr != null) {
                tJ(this.kMr.btj());
                this.kMr.a(fVar.getAnti());
                this.kMr.a(fVar.getForum(), fVar.getUserData());
                this.kMr.setThreadData(cYR);
                if (dah() != null) {
                    this.kMr.a(dah().dcv(), dah().dcf(), dah().dcM());
                }
                if (cYR != null) {
                    this.kMr.jr(cYR.bgV());
                }
            }
        }
    }

    public void ddU() {
        reset();
        ddQ();
        this.kUF.daN();
        tL(false);
    }

    private void reset() {
        if (this.kMr != null && this.aaS != null) {
            com.baidu.tbadk.editortools.pb.a.bsY().setStatus(0);
            this.kMr.btt();
            this.kMr.bsI();
            if (this.kMr.getWriteImagesInfo() != null) {
                this.kMr.getWriteImagesInfo().setMaxImagesAllowed(this.kMr.isBJH ? 1 : 9);
            }
            this.kMr.qB(SendView.ALL);
            this.kMr.qC(SendView.ALL);
            h qo = this.aaS.qo(23);
            h qo2 = this.aaS.qo(2);
            h qo3 = this.aaS.qo(5);
            if (qo2 != null) {
                qo2.display();
            }
            if (qo3 != null) {
                qo3.display();
            }
            if (qo != null) {
                qo.hide();
            }
            this.aaS.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            x(fVar);
            this.kUb.setVisibility(fVar.cZu() ? 8 : 0);
            if (fVar.bbu()) {
                SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collected24_svg, R.color.cp_link_tip_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            } else {
                SvgManager.bkl().a(this.kUb, R.drawable.icon_pure_pb_bottom_collect24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            String EX = EX(fVar.cYR().bfp());
            if (this.kUe != null) {
                this.kUe.setText(EX);
            }
            if (this.kUf != null) {
                this.kUf.setText(EX);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.cYR()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.aZ(fVar.cYR())) {
            if (this.kUd != null) {
                this.kUd.setEnable(false);
                this.kUd.onDestroy();
            }
            SvgManager.bkl().a(this.kUc, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_e, SvgManager.SvgResourceStateType.NORMAL);
        } else if (this.kUd == null || !this.kUd.isEnable()) {
            SvgManager.bkl().a(this.kUc, R.drawable.icon_pure_pb_bottom_share24_svg, R.color.cp_cont_j, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    private String EX(int i) {
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

    public void tL(boolean z) {
        if (this.kTX != null) {
            tJ(this.kMr.btj());
            if (this.kTT) {
                tA(z);
            } else {
                tB(z);
            }
            dhA();
            dhB();
        }
    }

    public void deS() {
        if (this.kTX != null) {
            this.kTW.setVisibility(8);
            this.kTX.setVisibility(8);
            this.lez.leT = false;
            dhA();
            dhB();
        }
    }

    private void dhA() {
        if (this.lek != null) {
            if (this.lez.dhS()) {
                this.lek.vm(false);
            } else {
                this.lek.vm(this.lek.bOo() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhB() {
        if (this.lek != null && this.ekP != null) {
            if (com.baidu.tbadk.a.d.baW()) {
                this.lek.uu(false);
            } else if (this.ekP.getCurrentItem() != 0) {
                this.lek.uu(false);
            } else if (this.lez.dhS()) {
                this.lek.uu(false);
            } else {
                e eVar = (e) y.b(getActivity()).l(e.class);
                if (eVar != null) {
                    this.lek.uu(eVar.dic() == null || eVar.dic().getValue() == null || eVar.dic().getValue().booleanValue());
                }
            }
        }
    }

    private void EF(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(dbM(), dbg(), i);
    }

    private int dbg() {
        if (dah() == null || dah().getPbData() == null || dah().getPbData().cYR() == null) {
            return -1;
        }
        return dah().getPbData().cYR().bgl();
    }

    public void tJ(boolean z) {
        this.kTT = z;
    }

    public void tA(boolean z) {
        if (this.kTX != null && this.jcG != null) {
            this.jcG.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kTX.startAnimation(alphaAnimation);
            }
            this.kTW.setVisibility(0);
            this.kTX.setVisibility(0);
            this.lez.leT = true;
        }
    }

    public void tB(boolean z) {
        if (this.kTX != null && this.jcG != null) {
            this.jcG.setText(ddW());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.kTX.startAnimation(alphaAnimation);
            }
            this.kTW.setVisibility(0);
            this.kTX.setVisibility(0);
            this.lez.leT = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.kFX == null) {
            this.kFX = aVar;
            this.leq.setText(aVar.getTitle());
            this.ler.setText(aVar.diG());
            String diH = aVar.diH();
            TBSpecificationBtn tBSpecificationBtn = this.let;
            if (TextUtils.isEmpty(diH)) {
                diH = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(diH);
            this.leu.startLoad(aVar.getImage(), 10, false);
            this.lev.setVisibility(aVar.diJ() ? 0 : 8);
            com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.kFX == null || VideoPbFragment.this.kFX.diJ()) {
                        if (VideoPbFragment.this.kFX != null && VideoPbFragment.this.dah() != null && VideoPbFragment.this.dah().getPbData() != null && VideoPbFragment.this.dah().getPbData().getForum() != null) {
                            TiebaStatic.log(new aq("c13712").dF("fid", VideoPbFragment.this.dah().getPbData().getForum().getId()).dF("fname", VideoPbFragment.this.dah().getPbData().getForum().getName()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", VideoPbFragment.this.dah().getPbData().getThreadId()).u("obj_param1", VideoPbFragment.this.kFX.userId));
                        }
                    } else {
                        TiebaStatic.log(new aq("c13608").dF("obj_id", VideoPbFragment.this.kFX.getTitle()).dF("obj_name", VideoPbFragment.this.kFX.diG()).ai("obj_type", 2).dF("fid", VideoPbFragment.this.dah().getPbData().getForumId()).dF("uid", TbadkCoreApplication.getCurrentAccount()).dF("tid", VideoPbFragment.this.dah().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.dhC();
                }
            }, aVar.diI().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhC() {
        ViewGroup.LayoutParams layoutParams = this.leo.getLayoutParams();
        if (layoutParams != null) {
            if (this.lew == null || !this.lew.isRunning()) {
                this.leo.setAlpha(0.0f);
                this.leo.setVisibility(0);
                e(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhD() {
        if (this.leo.getLayoutParams() != null) {
            if (this.lew == null || !this.lew.isRunning()) {
                dhE();
            }
        }
    }

    private void dhE() {
        final ViewGroup.LayoutParams layoutParams = this.leo.getLayoutParams();
        if (layoutParams != null) {
            if (this.lex == null || !this.lex.isRunning()) {
                this.lex = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.lex.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.leo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.lex.setDuration(200L);
                this.lex.start();
                this.lex.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.d(layoutParams);
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
    public void d(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.XP.getLayoutParams();
        final int i = layoutParams2.height;
        this.lew = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lew.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iZb);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.iZb);
                VideoPbFragment.this.leo.setLayoutParams(layoutParams);
                VideoPbFragment.this.XP.setLayoutParams(layoutParams2);
            }
        });
        this.lew.setDuration(300L);
        this.lew.start();
        this.lew.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.leo.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void e(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.XP.getLayoutParams();
        final int i = layoutParams2.height;
        this.lew = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lew.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.iZb);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.leo.setLayoutParams(layoutParams);
                VideoPbFragment.this.XP.setLayoutParams(layoutParams2);
            }
        });
        this.lew.setDuration(300L);
        this.lew.start();
        this.lew.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dhF();
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
    public void dhF() {
        this.lew = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lew.setDuration(300L);
        this.lew.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.leo.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.lew.start();
    }

    public String ddW() {
        if (!at.isEmpty(this.kUW)) {
            return this.kUW;
        }
        this.kUW = TbadkCoreApplication.getInst().getResources().getString(ay.ddL());
        return this.kUW;
    }

    public void der() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.baW() && dhK() != null) {
            dhK().endLoadData();
            dhK().des();
        } else if (dhI() != null) {
            dhI().endLoadData();
            dhI().des();
        }
    }

    public boolean cV(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bcG().isShowImages()) {
                    return NY(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dah() == null || dah().getPbData() == null) {
                        return true;
                    }
                    if (this.kUF != null) {
                        this.kUF.daN();
                    }
                    p pVar = new p();
                    pVar.a(dah().getPbData().getForum());
                    pVar.setThreadData(dah().getPbData().cYR());
                    pVar.g(postData);
                    this.kLv.d(pVar);
                    this.kLv.setPostId(postData.getId());
                    a(view, postData.bfy().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.kMr != null) {
                        tJ(this.kMr.btj());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void dhG() {
        if (this.kMr != null) {
            tJ(this.kMr.btj());
        }
        ddU();
        this.ley.deI();
    }

    private boolean NY(String str) {
        if (!StringUtils.isNull(str) && bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("bubble_link", "");
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

    public void cKd() {
        if (this.kTF != null) {
            this.kTF.setVisibility(0);
        }
    }

    public void cKc() {
        if (this.kTF != null) {
            this.kTF.setVisibility(8);
        }
    }

    public void Fo(int i) {
        if (this.leh != null) {
            this.leh.setVisibility(i);
        }
    }

    public void dep() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dbk() {
        return this.kNh;
    }

    public void ddQ() {
        if (this.aaS != null) {
            this.aaS.hide();
        }
    }

    public void cpF() {
        if (this.kLA.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.kLA.getCurrentFocus());
        }
    }

    public void K(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.cYR() != null) {
            String valueOf = String.valueOf(fVar.cYR().bfp());
            if (fVar.cYR().bfp() == 0) {
                valueOf = "";
            }
            this.lef.Ds(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.leg.dhT()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dah() != null && dah().getPbData() != null && dah().getPbData().cYR() != null && dah().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(kUy)).intValue();
                if (intValue == kUz) {
                    if (!this.hrC.dBo()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.hrC.Rp(at.R(jSONArray));
                        }
                        this.hrC.a(dah().getPbData().getForum().getId(), dah().getPbData().getForum().getName(), dah().getPbData().cYR().getId(), str, intValue3, intValue2, booleanValue, dah().getPbData().cYR().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == kUA || intValue == kUC) {
                    if (dah().dcI() != null) {
                        dah().dcI().Ez(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == kUA) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eq(String str, String str2) {
        be.bkp().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public int bzr() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<ImageView> bzs() {
        if (this.ffj == null) {
            this.ffj = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bzE */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bcG().isShowImages();
                    foreDrawableImageView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                        if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
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
        return this.ffj;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<TextView> bzt() {
        if (this.fiD == null) {
            this.fiD = TbRichTextView.A(getPageContext().getPageActivity(), 8);
        }
        return this.fiD;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<GifView> bzu() {
        if (this.ffk == null) {
            this.ffk = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cjO */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bcG().isShowImages();
                    gifView.setDefaultBg(ap.getDrawable(R.color.common_color_10220));
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
                    if (com.baidu.tbadk.core.k.bcG().isShowImages()) {
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
                    gifView.btZ();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.ffk;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<View> bzv() {
        if (this.fiE == null) {
            this.fiE = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dbP */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cY */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cZ */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).bQr();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: da */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fiE;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<LinearLayout> bzw() {
        if (this.fiF == null) {
            this.fiF = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dbR */
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
                /* renamed from: d */
                public void destroyObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: e */
                public LinearLayout activateObject(LinearLayout linearLayout) {
                    return linearLayout;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: f */
                public LinearLayout passivateObject(LinearLayout linearLayout) {
                    linearLayout.removeAllViews();
                    return linearLayout;
                }
            }, 15, 0);
        }
        return this.fiF;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public com.baidu.adp.lib.d.b<RelativeLayout> bzx() {
        this.fiG = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dbQ */
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
        return this.fiG;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void at(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.kLL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void f(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.be.Oo(str) && dah() != null && dah().dcf() != null) {
            TiebaStatic.log(new aq("c11664").ai("obj_param1", 1).dF("post_id", dah().dcf()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.l lVar = new com.baidu.tbadk.data.l();
                lVar.mLink = str;
                lVar.type = 3;
                lVar.eLR = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, lVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.be.dfn().f(getPageContext(), str);
        }
        this.kLL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void au(Context context, String str) {
        com.baidu.tieba.pb.pb.main.be.dfn().f(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.kLL = true;
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void av(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void aw(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void r(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.ley.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dip = this.ley.dip();
            if (dip == null) {
                this.ley.dbb();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dip.getItemView(1).setVisibility(8);
            } else {
                dip.getItemView(1).setVisibility(0);
            }
            dip.bic();
            this.kLL = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.i
    public void ax(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.bkp().b(getPageContext(), new String[]{str});
            this.kLL = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a dhH() {
        return this.emW;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bwR() {
        return this.eYy;
    }

    public ReplyFragment dhI() {
        if (this.leg == null || !(this.leg.Fp(lec) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.leg.Fp(lec);
    }

    public DetailInfoFragment dhJ() {
        if (this.leg == null || !(this.leg.Fp(leb) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.leg.Fp(leb);
    }

    public DetailInfoAndReplyFragment dhK() {
        if (this.leg == null || !(this.leg.Fp(led) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.leg.Fp(led);
    }

    public boolean cZX() {
        PbModel dah = this.kLA.dah();
        if (dah == null) {
            return false;
        }
        return dah.cZX();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData cZd;
        PbModel dah = this.kLA.dah();
        if (dah != null && dah.getPbData() != null && !dah.getPbData().cZu()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dah.getPbData().cYR().getId();
            if (dah.isShareThread() && dah.getPbData().cYR().efS != null) {
                historyMessage.threadName = dah.getPbData().cYR().efS.showText;
            } else {
                historyMessage.threadName = dah.getPbData().cYR().getTitle();
            }
            if (dah.isShareThread() && !cZX()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dah.getPbData().getForum().getName();
            }
            ArrayList<PostData> cYT = dah.getPbData().cYT();
            int det = dhI() != null ? dhI().det() : 0;
            if (cYT != null && det >= 0 && det < cYT.size()) {
                historyMessage.postID = cYT.get(det).getId();
            }
            historyMessage.isHostOnly = dah.getHostMode();
            historyMessage.isSquence = dah.dch();
            historyMessage.isShareThread = dah.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.kMr != null) {
            this.kMr.onDestroy();
        }
        if (dah != null && (dah.dci() || dah.dck())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dah.dcf());
            if (this.kMg) {
                if (this.kMi) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dah.chY());
                }
                if (this.kMh) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dah.getIsGood());
                }
            }
            if (dah.getPbData() != null && System.currentTimeMillis() - this.kLH >= 40000 && (cZd = dah.getPbData().cZd()) != null && !com.baidu.tbadk.core.util.y.isEmpty(cZd.getDataList())) {
                intent.putExtra("guess_like_data", cZd);
            }
            PbActivity pbActivity = this.kLA;
            PbActivity pbActivity2 = this.kLA;
            pbActivity.setResult(-1, intent);
        }
        if (dbr()) {
            if (dah != null) {
                com.baidu.tieba.pb.data.f pbData = dah.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.kLN) {
                        if (this.lej != null) {
                            Rect rect = new Rect();
                            this.lej.getGlobalVisibleRect(rect);
                            as.ddA().h(rect);
                        }
                        as.ddA().ET(this.ekP.getCurrentItem());
                        BdTypeRecyclerView csy = csy();
                        Parcelable parcelable = null;
                        if (csy != null) {
                            parcelable = csy.onSaveInstanceState();
                        }
                        as.ddA().a(dah.dcp(), parcelable, dah.dch(), dah.getHostMode(), false);
                    }
                }
            } else {
                as.ddA().reset();
            }
            dau();
        }
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.lek != null && !this.lek.bOo()) {
            if ((this.lek.isFullScreen() && configuration.orientation == 1) || (!this.lek.isFullScreen() && configuration.orientation == 2)) {
                this.lek.uv(false);
            }
        }
    }

    public boolean dhL() {
        if (this.lek == null) {
            return false;
        }
        return this.lek.bOo();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dzC().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public class a {
        public boolean leT;
        public boolean leU;

        private a() {
            this.leU = true;
        }

        public boolean dhS() {
            return (this.leT && this.leU) ? false : true;
        }
    }

    public void dhM() {
        this.kLW = -1;
        this.kLX = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dbI() {
        if (dah() != null && !at.isEmpty(dah().dcf())) {
            com.baidu.tbadk.BdToken.c.aZe().p(com.baidu.tbadk.BdToken.b.dPM, com.baidu.adp.lib.f.b.toLong(dah().dcf(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.lei.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhN() {
        if (this.leI == null) {
            this.leI = ObjectAnimator.ofFloat(this.lem, "alpha", 0.0f, 1.0f);
            this.leI.setDuration(200L);
        }
        this.leI.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dhO() {
        if (this.leJ == null) {
            this.leJ = ObjectAnimator.ofFloat(this.lem, "alpha", 1.0f, 0.0f);
            this.leJ.setDuration(200L);
        }
        this.leJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dhP() {
        return this.lek != null && this.lek.dhQ();
    }

    public boolean dhQ() {
        return this.leF;
    }

    public void un(boolean z) {
        this.leF = z;
    }

    public void th(boolean z) {
        this.kLO = z;
    }

    public boolean dbG() {
        return this.kLO;
    }
}
