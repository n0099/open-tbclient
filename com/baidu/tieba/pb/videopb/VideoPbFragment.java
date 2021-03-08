package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
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
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ah;
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.m;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.g;
import com.baidu.tbadk.editortools.sendtool.SendView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.switchs.PbReplySwitch;
import com.baidu.tbadk.switchs.ShareSwitch;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tbadk.util.PageType;
import com.baidu.tbadk.widget.CustomViewPager;
import com.baidu.tbadk.widget.ForeDrawableImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbListTextView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.richText.f;
import com.baidu.tbadk.widget.richText.h;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.f.b;
import com.baidu.tieba.face.data.EmotionImageData;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.data.f;
import com.baidu.tieba.pb.data.q;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.pb.main.aj;
import com.baidu.tieba.pb.pb.main.ao;
import com.baidu.tieba.pb.pb.main.ar;
import com.baidu.tieba.pb.pb.main.r;
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
import com.google.android.material.appbar.AppBarLayout;
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
/* loaded from: classes2.dex */
public class VideoPbFragment extends BaseFragment implements VoiceManager.c, TbRichTextView.c, h, com.baidu.tieba.pb.videopb.a, b {
    private AppBarLayout abf;
    private EditorTools ael;
    private ImageView aiV;
    public View fNw;
    private com.baidu.adp.lib.d.b<ImageView> fVL;
    private com.baidu.adp.lib.d.b<GifView> fVM;
    private com.baidu.adp.lib.d.b<TextView> fZb;
    private com.baidu.adp.lib.d.b<View> fZc;
    private com.baidu.adp.lib.d.b<LinearLayout> fZd;
    private com.baidu.adp.lib.d.b<RelativeLayout> fZe;
    private CustomViewPager faC;
    private ImageView gZZ;
    private com.baidu.tieba.callfans.a izJ;
    private VoiceManager jie;
    private com.baidu.tieba.frs.profession.permission.c jmA;
    private com.baidu.tieba.f.b jna;
    public View jyL;
    public am kUB;
    public ar kYE;
    private com.baidu.tieba.pb.videopb.c.a lMY;
    private MaskView lSi;
    private com.baidu.tieba.pb.pb.main.emotion.model.a lTD;
    private View lTF;
    private View lTG;
    private View lTH;
    int lTJ;
    private PbFakeFloorModel lTf;
    private PbActivity lTk;
    private g lUf;
    private com.baidu.tbadk.editortools.pb.e lUg;
    private com.baidu.tieba.frs.profession.permission.c lUi;
    private EmotionImageData lUj;
    private com.baidu.tbadk.core.view.c lUn;
    private GestureDetector mGestureDetector;
    public NavigationBar mNavigationBar;
    private PermissionJudgePolicy mPermissionJudgePolicy;
    private View mStatusBar;
    private View mbO;
    private LinearLayout mbQ;
    private HeadImageView mbR;
    private ImageView mbS;
    private ImageView mbT;
    private ImageView mbU;
    private com.baidu.tieba.pb.view.d mbV;
    private TextView mbW;
    private TextView mbX;
    private int mbZ;
    private View mbw;
    private String mcP;
    private int mca;
    private r mcx;
    private TBSpecificationBtn mmA;
    private TbImageView mmB;
    private View mmC;
    private ValueAnimator mmD;
    private ValueAnimator mmE;
    public com.baidu.tieba.pb.videopb.b.a mmF;
    private float mmJ;
    private float mmK;
    private boolean mmL;
    private ObjectAnimator mmP;
    private ObjectAnimator mmQ;
    private NewPagerSlidingTabBaseStrip mmn;
    private VideoPbFragmentAdapter mmo;
    private View mmp;
    private View mmq;
    private VideoContainerLayout mmr;
    private com.baidu.tieba.pb.videopb.videoView.a mms;
    private e mmt;
    private View mmu;
    private View mmv;
    private TextView mmx;
    private TextView mmy;
    private ImageView mmz;
    private RelativeLayout rootView;
    public static int mmj = 0;
    public static int mmk = 1;
    public static int mml = 0;
    public static int mcp = 3;
    public static int mcq = 0;
    public static int mcr = 3;
    public static int mcs = 4;
    public static int mct = 5;
    public static int mcu = 6;
    private static final int kog = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds146);
    private static final int mmm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds114);
    private static final b.a lVg = new b.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.14
        @Override // com.baidu.tieba.f.b.a
        public void dd(boolean z) {
            if (z) {
                com.baidu.tieba.pb.a.b.dmw();
            } else {
                com.baidu.tieba.pb.a.b.dmv();
            }
        }
    };
    private long lTs = 0;
    private boolean lTz = false;
    View.OnClickListener mmw = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (VideoPbFragment.this.lMY == null || VideoPbFragment.this.lMY.dvx()) {
                if (VideoPbFragment.this.lMY != null) {
                    if (VideoPbFragment.this.lMY.isChushou) {
                        VideoPbFragment.this.eI(VideoPbFragment.this.lMY.thirdRoomId, VideoPbFragment.this.lMY.thirdLiveType);
                    } else {
                        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                        alaLiveInfoCoreData.liveID = VideoPbFragment.this.lMY.dvy();
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(VideoPbFragment.this.getContext(), alaLiveInfoCoreData, AlaLiveRoomActivityConfig.FROM_TYPE_VIDEO_PB_RECOMMEND, null, false, "")));
                    }
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().getForum() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13713").dR("fid", VideoPbFragment.this.dmG().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dmG().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmG().getPbData().getThreadId()).v("obj_param1", VideoPbFragment.this.lMY.userId));
                        return;
                    }
                    return;
                }
                return;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13590").dR("obj_id", VideoPbFragment.this.lMY.getTitle()).dR("obj_name", VideoPbFragment.this.lMY.dvu()).aq("obj_type", 2).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmG().getPbData().getThreadId()));
            String link = VideoPbFragment.this.lMY.getLink();
            if (!TextUtils.isEmpty(link)) {
                if (URLUtil.isHttpUrl(link) || URLUtil.isHttpsUrl(link)) {
                    bf.bsY().b(VideoPbFragment.this.getPageContext(), new String[]{link});
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
    private com.baidu.tbadk.baseEditMark.a lTS = null;
    private com.baidu.tbadk.coreExtra.model.a fce = null;
    private ForumManageModel gfY = null;
    private boolean lTw = false;
    private View mbP = null;
    private TextView krw = null;
    private boolean mbL = false;
    private String fFk = null;
    private boolean lTV = false;
    private boolean lTW = false;
    private boolean lTX = false;
    private boolean lTy = false;
    int[] lTI = new int[2];
    private int lTK = -1;
    private int lTL = Integer.MIN_VALUE;
    private int lUt = 0;
    private int mmH = Integer.MIN_VALUE;
    private boolean isPaused = false;
    private boolean lTP = com.baidu.tbadk.a.d.bja();
    private final PbModel.a lUW = new PbModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.12
        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(boolean z, int i, int i2, int i3, f fVar, String str, int i4) {
            com.baidu.tbadk.editortools.h qS;
            VideoPbFragment.this.drc();
            VideoPbFragment.this.dqX();
            if (VideoPbFragment.this.mIsLoading) {
                VideoPbFragment.this.mIsLoading = false;
            }
            VideoPbFragment.this.vK(false);
            if (z && fVar != null) {
                cb dlp = fVar.dlp();
                ((VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class)).c(fVar, i2);
                VideoPbFragment.this.M(fVar);
                com.baidu.tieba.pb.videopb.c.a dlU = fVar.dlU();
                if (dlU != null && !dlU.moJ) {
                    VideoPbFragment.this.a(dlU);
                }
                VideoPbFragment.this.N(fVar);
                VideoPbFragment.this.c(z, i, i2, i3, fVar, str, i4);
                TbadkCoreApplication.getInst().setDefaultBubble(fVar.getUserData().getBimg_url());
                TbadkCoreApplication.getInst().setDefaultBubbleEndTime(fVar.getUserData().getBimg_end_time());
                if (VideoPbFragment.this.lTS != null) {
                    VideoPbFragment.this.lTS.ja(fVar.bkb());
                }
                AntiData anti = fVar.getAnti();
                if (anti != null) {
                    VideoPbFragment.this.fFk = anti.getVoice_message();
                    if (!StringUtils.isNull(VideoPbFragment.this.fFk) && VideoPbFragment.this.lUg != null && VideoPbFragment.this.lUg.bBk() != null && (qS = VideoPbFragment.this.lUg.bBk().qS(6)) != null && !TextUtils.isEmpty(VideoPbFragment.this.fFk)) {
                        ((View) qS).setOnClickListener(VideoPbFragment.this.fFW);
                    }
                }
                if (VideoPbFragment.this.kUB != null && dlp != null && dlp.bnS() != null) {
                    AttentionHostData attentionHostData = new AttentionHostData();
                    attentionHostData.parserWithMetaData(dlp.bnS());
                    VideoPbFragment.this.kUB.a(attentionHostData);
                }
            } else {
                if (i == 4 || i == 350008) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("tid", VideoPbFragment.this.dmG().doJ());
                        jSONObject.put("fid", VideoPbFragment.this.dmG().getForumId());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_THREAD_NOT_EXIST_WHEN_ENTER_PB, jSONObject));
                }
                if (i != 0) {
                    com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                    lVar.setOpType("2");
                    lVar.start();
                }
                if ((!com.baidu.tbadk.a.d.bjc() || VideoPbFragment.this.duy() != null) && VideoPbFragment.this.duw() != null) {
                    if (com.baidu.tbadk.a.d.bjc()) {
                        if (i != -1) {
                            ArrayList<PostData> arrayList = null;
                            if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                                arrayList = VideoPbFragment.this.dmG().getPbData().dlr();
                            }
                            if (y.getCount(arrayList) == 0 || (y.getCount(arrayList) == 1 && arrayList.get(0) != null && arrayList.get(0).dNO() == 1)) {
                                if (VideoPbFragment.this.duy().doj()) {
                                    VideoPbFragment.this.duy().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.duy().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.duy().PN(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.duy().PN("");
                        }
                        VideoPbFragment.this.duy().endLoadData();
                    } else {
                        if (i != -1) {
                            ArrayList<PostData> arrayList2 = null;
                            if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                                arrayList2 = VideoPbFragment.this.dmG().getPbData().dlr();
                            }
                            if (y.getCount(arrayList2) == 0 || (y.getCount(arrayList2) == 1 && arrayList2.get(0) != null && arrayList2.get(0).dNO() == 1)) {
                                if (VideoPbFragment.this.duw().doj()) {
                                    VideoPbFragment.this.duw().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_host_reply));
                                } else {
                                    VideoPbFragment.this.duw().PO(VideoPbFragment.this.getResources().getString(R.string.pb_no_replay));
                                }
                            } else {
                                VideoPbFragment.this.duw().PN(VideoPbFragment.this.getResources().getString(R.string.list_no_more_new));
                            }
                        } else {
                            VideoPbFragment.this.duw().PN("");
                        }
                        VideoPbFragment.this.duw().endLoadData();
                    }
                } else {
                    return;
                }
            }
            com.baidu.tieba.s.c.dMH().b(VideoPbFragment.this.getUniqueId(), false);
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void e(f fVar) {
        }

        @Override // com.baidu.tieba.pb.pb.main.PbModel.a
        public void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j) {
        }
    };
    private final a.InterfaceC0560a lUY = new a.InterfaceC0560a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.23
        @Override // com.baidu.tbadk.baseEditMark.a.InterfaceC0560a
        public void e(boolean z, boolean z2, String str) {
            VideoPbFragment.this.drc();
            if (z && VideoPbFragment.this.dmG() != null) {
                if (VideoPbFragment.this.lTS != null) {
                    VideoPbFragment.this.lTS.ja(z2);
                }
                VideoPbFragment.this.dmG().vo(z2);
                if (VideoPbFragment.this.dmG().bkb()) {
                    VideoPbFragment.this.dnU();
                } else if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null) {
                    VideoPbFragment.this.duy().dvh();
                } else if (VideoPbFragment.this.duw() != null) {
                    VideoPbFragment.this.duw().dvh();
                }
                if (z2) {
                    if (VideoPbFragment.this.lTS != null) {
                        if (VideoPbFragment.this.lTS.bke() != null && VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().dlp() != null && VideoPbFragment.this.dmG().getPbData().dlp().bnS() != null) {
                            MarkData bke = VideoPbFragment.this.lTS.bke();
                            MetaData bnS = VideoPbFragment.this.dmG().getPbData().dlp().bnS();
                            if (bke != null && bnS != null) {
                                if (!au.equals(TbadkCoreApplication.getCurrentAccount(), bnS.getUserId()) && !bnS.hadConcerned()) {
                                    VideoPbFragment.this.mmF.b(bnS);
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
                    VideoPbFragment.this.dnR();
                    return;
                }
                VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.remove_mark));
                return;
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.getPageContext().getString(R.string.update_mark_failed));
        }
    };
    private com.baidu.tbadk.editortools.pb.b fFo = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.34
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBO() {
            if (VideoPbFragment.this.kYE == null || VideoPbFragment.this.kYE.drV() == null || !VideoPbFragment.this.kYE.drV().dWF()) {
                return !VideoPbFragment.this.FL(am.fbZ);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kYE.drV().dWH());
            if (VideoPbFragment.this.lUg != null && (VideoPbFragment.this.lUg.bCf() || VideoPbFragment.this.lUg.bCg())) {
                VideoPbFragment.this.lUg.a(false, VideoPbFragment.this.kYE.drY());
            }
            VideoPbFragment.this.kYE.vQ(true);
            return true;
        }
    };
    private final CustomMessageListener lUA = new CustomMessageListener(CmdConfigCustom.PB_RESET_EDITOR_TOOL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.45
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.dmG() != null && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Boolean) && !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                if (VideoPbFragment.this.lUg != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lUg.bBY());
                }
                VideoPbFragment.this.dqB();
                VideoPbFragment.this.mmF.drt();
            }
        }
    };
    private CustomMessageListener lUD = new CustomMessageListener(CmdConfigCustom.UPDATE_PB_SUBPB_CMD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.56
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                com.baidu.tieba.pb.e eVar = (com.baidu.tieba.pb.e) customResponsedMessage.getData();
                switch (eVar.getType()) {
                    case 0:
                        VideoPbFragment.this.b((q) eVar.getData());
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
    private final CustomMessageListener jjH = new CustomMessageListener(2921391) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.64
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (!VideoPbFragment.this.isPaused) {
                VideoPbFragment.this.dom();
            }
        }
    };
    private CustomMessageListener lUX = new CustomMessageListener(CmdConfigCustom.CMD_WX_SHARE_SUCCESS) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.65
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if ((customResponsedMessage instanceof CustomResponsedMessage) && ((Boolean) customResponsedMessage.getData()).booleanValue()) {
                VideoPbFragment.this.dnL();
            }
        }
    };
    private CustomMessageListener lUP = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_CHECK_RESPONSE) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.66
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            boolean z = false;
            if (VideoPbFragment.this.mmF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.usermute.a) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mmF.lUo) {
                com.baidu.tieba.usermute.a aVar = (com.baidu.tieba.usermute.a) customResponsedMessage.getData();
                VideoPbFragment.this.mmF.ckD();
                SparseArray<Object> sparseArray = (SparseArray) VideoPbFragment.this.mmF.getExtra();
                DataRes dataRes = aVar.nME;
                if (aVar.error == 0 && dataRes != null) {
                    int i = com.baidu.adp.lib.f.b.toInt(dataRes.is_mute, 0);
                    String str = dataRes.mute_confirm;
                    boolean z2 = i == 1;
                    if (au.isEmpty(str)) {
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
                    VideoPbFragment.this.mmF.a(z, sparseArray);
                } else if (intValue == 1) {
                    VideoPbFragment.this.mmF.a(sparseArray, z);
                }
            }
        }
    };
    private CustomMessageListener lUN = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_ADD) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mmF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteAddResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mmF.lUo) {
                VideoPbFragment.this.mmF.ckD();
                UserMuteAddResponseMessage userMuteAddResponseMessage = (UserMuteAddResponseMessage) customResponsedMessage.getData();
                String str = (String) userMuteAddResponseMessage.getOrginalMessage().getExtra();
                f pbData = VideoPbFragment.this.dmG().getPbData();
                if (pbData != null) {
                    MuteUser muteUser = new MuteUser();
                    muteUser.setUserId(str);
                    pbData.dlF().add(muteUser);
                }
                if (userMuteAddResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lUn.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.mute_success));
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 220017) {
                    String errorString = userMuteAddResponseMessage.getErrorString();
                    if (TextUtils.isEmpty(errorString)) {
                        errorString = VideoPbFragment.this.getResources().getString(R.string.mute_error_beyond_limit);
                    }
                    VideoPbFragment.this.mmF.Dh(errorString);
                } else if (userMuteAddResponseMessage.getMuteErrorCode() == 1990043) {
                    VideoPbFragment.this.mmF.doi();
                } else {
                    String errorString2 = userMuteAddResponseMessage.getErrorString();
                    if (au.isEmpty(errorString2)) {
                        errorString2 = VideoPbFragment.this.getResources().getString(R.string.mute_fail);
                    }
                    VideoPbFragment.this.lUn.showFailToast(errorString2);
                }
            }
        }
    };
    private CustomMessageListener lUO = new CustomMessageListener(CmdConfigCustom.CMD_USER_MUTE_DEL) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (VideoPbFragment.this.mmF != null && customResponsedMessage != null && (customResponsedMessage.getData() instanceof UserMuteDelResponseMessage) && customResponsedMessage.getOrginalMessage().getTag() == VideoPbFragment.this.mmF.lUo) {
                VideoPbFragment.this.mmF.ckD();
                UserMuteDelResponseMessage userMuteDelResponseMessage = (UserMuteDelResponseMessage) customResponsedMessage.getData();
                if (userMuteDelResponseMessage.getMuteErrorCode() == 0) {
                    VideoPbFragment.this.lUn.showSuccessToast(VideoPbFragment.this.getResources().getString(R.string.un_mute_success));
                    return;
                }
                String muteMessage = userMuteDelResponseMessage.getMuteMessage();
                if (au.isEmpty(muteMessage)) {
                    muteMessage = VideoPbFragment.this.getResources().getString(R.string.un_mute_fail);
                }
                VideoPbFragment.this.lUn.showFailToast(muteMessage);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.b lUl = new com.baidu.tbadk.editortools.pb.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.4
        @Override // com.baidu.tbadk.editortools.pb.b
        public boolean bBO() {
            if (VideoPbFragment.this.kYE == null || VideoPbFragment.this.kYE.drW() == null || !VideoPbFragment.this.kYE.drW().dWF()) {
                return !VideoPbFragment.this.FL(am.fca);
            }
            VideoPbFragment.this.showToast(VideoPbFragment.this.kYE.drW().dWH());
            if (VideoPbFragment.this.mcx != null && VideoPbFragment.this.mcx.dnv() != null && VideoPbFragment.this.mcx.dnv().bCg()) {
                VideoPbFragment.this.mcx.dnv().a(VideoPbFragment.this.kYE.drY());
            }
            VideoPbFragment.this.kYE.vR(true);
            return true;
        }
    };
    private final NewWriteModel.d fFv = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.5
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            String userId;
            boolean z2 = true;
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId());
                }
                arVar.dR("tid", VideoPbFragment.this.dmG().doJ());
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            VideoPbFragment.this.cDh();
            VideoPbFragment.this.b(z, postWriteCallBackData);
            String str = "";
            int i = -1;
            if (postWriteCallBackData != null) {
                i = postWriteCallBackData.getErrorCode();
                str = postWriteCallBackData.getErrorString();
            }
            if (z) {
                if (PbReplySwitch.getInOn() && VideoPbFragment.this.dmG() != null && postWriteCallBackData != null && !StringUtils.isNull(postWriteCallBackData.getPostId())) {
                    VideoPbFragment.this.dmG().PI(postWriteCallBackData.getPostId());
                    if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null) {
                        VideoPbFragment.this.lUt = VideoPbFragment.this.duy().dre();
                        VideoPbFragment.this.mmH = VideoPbFragment.this.duy().dvk();
                        VideoPbFragment.this.dmG().da(VideoPbFragment.this.lUt, VideoPbFragment.this.mmH);
                    } else if (VideoPbFragment.this.duw() != null) {
                        VideoPbFragment.this.lUt = VideoPbFragment.this.duw().dre();
                        VideoPbFragment.this.mmH = VideoPbFragment.this.duw().dvk();
                        VideoPbFragment.this.dmG().da(VideoPbFragment.this.lUt, VideoPbFragment.this.mmH);
                    }
                }
                if (VideoPbFragment.this.faC != null) {
                    if (com.baidu.tbadk.a.d.bjc()) {
                        VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mml);
                    } else {
                        VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mmk);
                    }
                }
                VideoPbFragment.this.mmF.drt();
                VideoPbFragment.this.kYE.drU();
                if (VideoPbFragment.this.lUg != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lUg.bBY());
                }
                VideoPbFragment.this.dqx();
                VideoPbFragment.this.vK(true);
                VideoPbFragment.this.dmG().dpf();
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_ON_DUI_SEND_SUCCESS_OR_CANCEL));
                VideoPbFragment.this.a(antiData, postWriteCallBackData);
                if (writeData != null) {
                    String floor = writeData.getFloor();
                    if (writeData != null && writeData.getType() == 2) {
                        if (floor != null) {
                            if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null) {
                                VideoPbFragment.this.duy().dvh();
                            } else if (VideoPbFragment.this.duw() != null) {
                                VideoPbFragment.this.duw().dvh();
                            }
                        }
                    } else if (VideoPbFragment.this.dmG().getHostMode()) {
                        f pbData = VideoPbFragment.this.dmG().getPbData();
                        if (pbData != null && pbData.dlp() != null && pbData.dlp().bnS() != null && (userId = pbData.dlp().bnS().getUserId()) != null && userId.equals(TbadkCoreApplication.getCurrentAccount()) && !PbReplySwitch.getInOn() && VideoPbFragment.this.dmG().doW()) {
                            VideoPbFragment.this.dra();
                        }
                    } else if (!PbReplySwitch.getInOn() && VideoPbFragment.this.dmG().doW()) {
                        VideoPbFragment.this.dra();
                    }
                    VideoPbFragment videoPbFragment = VideoPbFragment.this;
                    if (writeData == null || writeData.getType() != 2) {
                        z2 = false;
                    }
                    videoPbFragment.uZ(z2);
                }
            } else if (i == 220015) {
                VideoPbFragment.this.showToast(str);
                if (VideoPbFragment.this.lUg.bCf() || VideoPbFragment.this.lUg.bCg()) {
                    VideoPbFragment.this.lUg.a(false, postWriteCallBackData);
                }
                VideoPbFragment.this.kYE.h(postWriteCallBackData);
            } else if (i == 238010) {
                if (VideoPbFragment.this.kUB != null) {
                    VideoPbFragment.this.kUB.a(postWriteCallBackData.getReplyPrivacyTip());
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AB(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AB(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").aq("obj_locate", 1).aq("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqz();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").aq("obj_locate", 1).aq("obj_type", 2));
            } else if (ahVar == null && i != 227001) {
                VideoPbFragment.this.a(i, antiData, str);
            }
        }
    };
    private View.OnClickListener fFW = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.6
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            VideoPbFragment.this.showToast(VideoPbFragment.this.fFk);
        }
    };
    private CustomMessageListener lUC = new CustomMessageListener(CmdConfigCustom.PB_LOAD_DRAFT) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                if (VideoPbFragment.this.lUg != null) {
                    VideoPbFragment.this.vI(VideoPbFragment.this.lUg.bBY());
                }
                VideoPbFragment.this.vK(false);
            }
        }
    };
    private int mmI = 0;
    private boolean mmM = true;
    private View.OnTouchListener mmN = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.8
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                return VideoPbFragment.this.mGestureDetector != null && VideoPbFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
            if (VideoPbFragment.this.mmI == 1) {
                if (!VideoPbFragment.this.mmM) {
                    VideoPbFragment.this.duA();
                    UtilHelper.showStatusBar(VideoPbFragment.this.doq(), VideoPbFragment.this.doq().getRootView());
                    VideoPbFragment.this.mmM = true;
                    com.baidu.adp.lib.f.e.mA().removeCallbacks(VideoPbFragment.this.mmO);
                    com.baidu.adp.lib.f.e.mA().postDelayed(VideoPbFragment.this.mmO, IMConnection.RETRY_DELAY_TIMES);
                }
            } else if (VideoPbFragment.this.mmI == 2 && (VideoPbFragment.this.mmM || VideoPbFragment.this.duC())) {
                VideoPbFragment.this.duB();
                UtilHelper.hideStatusBar(VideoPbFragment.this.doq(), VideoPbFragment.this.doq().getRootView());
                VideoPbFragment.this.mmM = false;
                if (VideoPbFragment.this.mms != null) {
                    VideoPbFragment.this.mms.wo(false);
                }
            }
            VideoPbFragment.this.mmI = 0;
            return true;
        }
    };
    private GestureDetector.SimpleOnGestureListener juw = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.9
        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            VideoPbFragment.this.mmI = 0;
            VideoPbFragment.this.mmJ = 0.0f;
            VideoPbFragment.this.mmK = 0.0f;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            VideoPbFragment.this.mmJ += f;
            VideoPbFragment.this.mmK += f2;
            if (VideoPbFragment.this.mmI == 0 && !VideoPbFragment.this.mmL && VideoPbFragment.this.mms != null && !VideoPbFragment.this.mms.isFullScreen()) {
                int height = VideoPbFragment.this.mNavigationBar.getHeight();
                if (motionEvent.getY() < 0.0f || Math.abs(VideoPbFragment.this.mmK) <= Math.abs(VideoPbFragment.this.mmJ) || VideoPbFragment.this.mmK > (-height) / 5) {
                    if (Math.abs(VideoPbFragment.this.mmK) > Math.abs(VideoPbFragment.this.mmJ) && VideoPbFragment.this.mmK > 0.0f && f2 > 0.0f) {
                        VideoPbFragment.this.mmI = 2;
                    }
                } else {
                    VideoPbFragment.this.mmI = 1;
                }
            }
            return true;
        }
    };
    private Runnable mmO = new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.10
        @Override // java.lang.Runnable
        public void run() {
            if (VideoPbFragment.this.mmM && !VideoPbFragment.this.duC()) {
                VideoPbFragment.this.duB();
                UtilHelper.hideStatusBar(VideoPbFragment.this.doq(), VideoPbFragment.this.doq().getRootView());
                VideoPbFragment.this.mmM = false;
            }
        }
    };
    private final com.baidu.adp.base.e izO = new com.baidu.adp.base.e() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.11
        @Override // com.baidu.adp.base.e
        public void callback(Object obj) {
            boolean z = false;
            if (obj == null || VideoPbFragment.this.dmG() == null) {
                VideoPbFragment.this.a(VideoPbFragment.this.gfY.getLoadDataMode(), false, (String) null, false);
                return;
            }
            switch (VideoPbFragment.this.gfY.getLoadDataMode()) {
                case 0:
                    VideoPbFragment.this.dmG().dpf();
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar.mjE != 1002 || bVar.hmO) {
                        z = true;
                    }
                    VideoPbFragment.this.a(bVar, z);
                    return;
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    VideoPbFragment.this.a(1, dVar.mSuccess, dVar.nCc, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    VideoPbFragment.this.a(VideoPbFragment.this.gfY.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    VideoPbFragment.this.a(VideoPbFragment.this.gfY.getLoadDataMode(), gVar.mSuccess, gVar.nCc, false);
                    VideoPbFragment.this.mmF.aZ(gVar.nCf);
                    return;
                default:
                    return;
            }
        }
    };
    private View.OnTouchListener bUt = new View.OnTouchListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.13
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            VideoPbFragment.this.jna.onTouchEvent(motionEvent);
            return false;
        }
    };
    public NewWriteModel.d lUU = new NewWriteModel.d() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.16
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ah ahVar, WriteData writeData, AntiData antiData) {
            if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13268");
                arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                    arVar.dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId());
                }
                if (VideoPbFragment.this.dmG() != null) {
                    arVar.dR("tid", VideoPbFragment.this.dmG().doJ());
                }
                arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                TiebaStatic.log(arVar);
            }
            if (z) {
                if (VideoPbFragment.this.kYE != null) {
                    VideoPbFragment.this.kYE.drT();
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
                if (VideoPbFragment.this.kUB != null) {
                    VideoPbFragment.this.kUB.a(postWriteCallBackData.getReplyPrivacyTip());
                    return;
                }
                return;
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isErrorLinkCountExceedLimit()) {
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getActivity().getString(R.string.current_links_too_much_please_modify_and_publish), null).show();
                } else {
                    DefaultNavigationBarCoverTip.d(VideoPbFragment.this.getActivity(), postWriteCallBackData.getErrorString(), null).show();
                }
            } else if (postWriteCallBackData != null && postWriteCallBackData.isErrorShowApplyMemberDialog()) {
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(VideoPbFragment.this.getActivity());
                if (au.isEmpty(postWriteCallBackData.getErrorString())) {
                    aVar.AB(VideoPbFragment.this.getActivity().getString(R.string.open_member_and_add_more_links));
                } else {
                    aVar.AB(postWriteCallBackData.getErrorString());
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
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13746").aq("obj_locate", 1).aq("obj_type", 2));
                    }
                });
                aVar.b(VideoPbFragment.this.getPageContext()).bqz();
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13745").aq("obj_locate", 1).aq("obj_type", 2));
            }
            if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError() && VideoPbFragment.this.kYE != null) {
                if (VideoPbFragment.this.mcx != null && VideoPbFragment.this.mcx.dnv() != null && VideoPbFragment.this.mcx.dnv().bCg()) {
                    VideoPbFragment.this.mcx.dnv().a(postWriteCallBackData);
                }
                VideoPbFragment.this.kYE.i(postWriteCallBackData);
            }
        }
    };
    private com.baidu.tbadk.editortools.pb.c fFn = new com.baidu.tbadk.editortools.pb.c() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.20
        @Override // com.baidu.tbadk.editortools.pb.c
        public void bBP() {
            VideoPbFragment.this.showProgressBar();
        }
    };
    public final View.OnClickListener aFH = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.21
        /* JADX DEBUG: Multi-variable search result rejected for r1v164, resolved type: com.baidu.tieba.pb.videopb.b.a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray sparseArray;
            boolean J;
            int i = 2;
            int i2 = 3;
            int i3 = 1;
            if (view != null && VideoPbFragment.this.isAdded()) {
                if ((view instanceof TbListTextView) && (view.getParent() instanceof TbRichTextView)) {
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13398");
                    arVar.dR("tid", VideoPbFragment.this.dmG().doJ());
                    arVar.dR("fid", VideoPbFragment.this.dmG().getForumId());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.aq("obj_locate", 1);
                    TiebaStatic.log(arVar);
                    if (VideoPbFragment.this.lTw) {
                        VideoPbFragment.this.lTw = false;
                        return;
                    }
                    TbRichTextView tbRichTextView = (TbRichTextView) view.getParent();
                    if (tbRichTextView.getTag() instanceof SparseArray) {
                        Object obj = ((SparseArray) tbRichTextView.getTag()).get(R.id.tag_clip_board);
                        if (obj instanceof PostData) {
                            PostData postData = (PostData) obj;
                            if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.lTf != null && postData.bnS() != null && postData.dNO() != 1 && VideoPbFragment.this.checkUpIsLogin()) {
                                if (VideoPbFragment.this.mcx != null) {
                                    VideoPbFragment.this.mcx.dnq();
                                }
                                q qVar = new q();
                                qVar.a(VideoPbFragment.this.dmG().getPbData().getForum());
                                qVar.setThreadData(VideoPbFragment.this.dmG().getPbData().dlp());
                                qVar.g(postData);
                                VideoPbFragment.this.lTf.d(qVar);
                                VideoPbFragment.this.lTf.setPostId(postData.getId());
                                VideoPbFragment.this.a(view, postData.bnS().getUserId(), "", postData);
                                TiebaStatic.log("c11743");
                                com.baidu.tieba.pb.c.a.a(VideoPbFragment.this.dmG().getPbData(), postData, postData.locate, 8, 1);
                                if (VideoPbFragment.this.lUg != null) {
                                    VideoPbFragment.this.vI(VideoPbFragment.this.lUg.bBY());
                                }
                            }
                        }
                    }
                } else if ((VideoPbFragment.this.duw() != null && VideoPbFragment.this.duw().drp() != null && view == VideoPbFragment.this.duw().drp()) || ((com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null && VideoPbFragment.this.duy().drp() != null && view == VideoPbFragment.this.duy().drp()) || view.getId() == R.id.pb_more)) {
                    if (!VideoPbFragment.this.mIsLoading && VideoPbFragment.this.dmG().vm(true)) {
                        VideoPbFragment.this.mIsLoading = true;
                        if (com.baidu.tbadk.a.d.bjc()) {
                            VideoPbFragment.this.duy().drb();
                        } else {
                            VideoPbFragment.this.duw().drb();
                        }
                    }
                } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpV()) {
                    VideoPbFragment.this.mmF.baP();
                } else if ((VideoPbFragment.this.mmF != null && ((VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpW()) || view.getId() == R.id.owner_reply || view.getId() == R.id.all_reply)) || view.getId() == R.id.floor_owner_reply || view.getId() == R.id.reply_title) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                        view.setTag(Boolean.FALSE);
                        return;
                    }
                    VideoPbFragment.this.mmF.drt();
                    if (!VideoPbFragment.this.mIsLoading) {
                        VideoPbFragment.this.cDh();
                        VideoPbFragment.this.dra();
                        if (view.getId() == R.id.owner_reply) {
                            J = VideoPbFragment.this.dmG().J(true, VideoPbFragment.this.dnY());
                        } else {
                            J = view.getId() == R.id.all_reply ? VideoPbFragment.this.dmG().J(false, VideoPbFragment.this.dnY()) : VideoPbFragment.this.dmG().PF(VideoPbFragment.this.dnY());
                        }
                        view.setTag(Boolean.valueOf(J));
                        if (J) {
                            VideoPbFragment.this.dqW();
                            VideoPbFragment.this.mIsLoading = true;
                        }
                        TiebaStatic.eventStat(VideoPbFragment.this.getPageContext().getPageActivity(), "pb_set_host", "pbclick", 1, new Object[0]);
                        return;
                    }
                    view.setTag(Boolean.FALSE);
                } else if (view == VideoPbFragment.this.fNw) {
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                        if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                            com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar("c13266");
                            arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar2.dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId());
                            arVar2.dR("tid", VideoPbFragment.this.dmG().doJ());
                            arVar2.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                            TiebaStatic.log(arVar2);
                            TbadkCoreApplication.getInst().setTaskId("");
                        }
                        l.hideSoftKeyPad(VideoPbFragment.this.lTk, VideoPbFragment.this.fNw);
                        VideoPbFragment.this.lTk.finish();
                    }
                } else if (view == VideoPbFragment.this.jyL && VideoPbFragment.this.mmF != null) {
                    if (!com.baidu.tbadk.util.l.isFastDoubleClick()) {
                        if (VideoPbFragment.this.dmG() == null || VideoPbFragment.this.dmG().getPbData() == null) {
                            l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        ArrayList<PostData> dlr = VideoPbFragment.this.dmG().getPbData().dlr();
                        if ((dlr == null || dlr.size() <= 0) && VideoPbFragment.this.dmG().doL()) {
                            l.showToast(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12378").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("fid", VideoPbFragment.this.dmG().getForumId()));
                        VideoPbFragment.this.mmF.dnM();
                    }
                } else if (VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dqa()) {
                    if (VideoPbFragment.this.dmG() != null) {
                        VideoPbFragment.this.mmF.drt();
                        if (j.isNetWorkAvailable()) {
                            VideoPbFragment.this.cDh();
                            VideoPbFragment.this.dra();
                            VideoPbFragment.this.dmG().FS(1);
                            return;
                        }
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    }
                } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpW()) {
                    VideoPbFragment.this.mmF.baP();
                } else if (VideoPbFragment.this.mmF != null && ((VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dqd()) || view.getId() == R.id.pb_sort_type || view.getId() == R.id.pb_sort)) {
                    VideoPbFragment.this.mmF.drt();
                    if (j.isNetWorkAvailable()) {
                        if (!VideoPbFragment.this.mIsLoading) {
                            VideoPbFragment.this.cDh();
                            VideoPbFragment.this.dra();
                            VideoPbFragment.this.mmF.dS(view);
                            return;
                        }
                        view.setTag(Integer.valueOf(VideoPbFragment.this.dmG().dpd()));
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.network_not_available);
                } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpU()) {
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().dlp() != null) {
                        VideoPbFragment.this.mmF.baP();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13062"));
                        VideoPbFragment.this.mmF.PA(VideoPbFragment.this.dmG().getPbData().dlp().boi());
                    }
                } else if (view.getId() == R.id.pb_floor_feedback) {
                    try {
                        sparseArray = (SparseArray) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        sparseArray = null;
                    }
                    if (VideoPbFragment.this.mmF != null) {
                        VideoPbFragment.this.mmF.g(sparseArray);
                    }
                } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dqe()) {
                    int skinType = TbadkCoreApplication.getInst().getSkinType();
                    if (skinType == 1) {
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        ap.B(true, false);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).aq("obj_type", 0).aq("obj_source", 1));
                    } else if (skinType == 0 || skinType == 4) {
                        UtilHelper.showSkinChangeAnimation(VideoPbFragment.this.getActivity());
                        VideoPbFragment.this.onChangeSkinType(skinType);
                        UtilHelper.setNavigationBarBackground(VideoPbFragment.this.getActivity(), VideoPbFragment.this.getResources().getColor(R.color.CAM_X0201_1));
                        TbadkCoreApplication.getInst().setSkinType(1);
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.SET_NIGHT_MODE).aq("obj_type", 1).aq("obj_source", 1));
                    }
                    VideoPbFragment.this.mmF.dsA();
                } else if (VideoPbFragment.this.mmF != null && (view == VideoPbFragment.this.mmF.dqY() || (VideoPbFragment.this.mmF.dsB() != null && (view == VideoPbFragment.this.mmF.dsB().dpZ() || view == VideoPbFragment.this.mmF.dsB().dpX())))) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if ((VideoPbFragment.this.dmG() != null || VideoPbFragment.this.dmG().getPbData() != null) && !VideoPbFragment.this.gfY.dOJ()) {
                        VideoPbFragment.this.mmF.drt();
                        if (VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpX()) {
                            if (VideoPbFragment.this.dmG().getPbData().dlp().bnN() == 1) {
                                i2 = 5;
                            } else {
                                i2 = 4;
                            }
                        } else if (VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpZ()) {
                            if (VideoPbFragment.this.dmG().getPbData().dlp().bnO() != 1) {
                                i2 = 6;
                            }
                        } else {
                            i2 = view == VideoPbFragment.this.mmF.dqY() ? 2 : 0;
                        }
                        ForumData forum = VideoPbFragment.this.dmG().getPbData().getForum();
                        String name = forum.getName();
                        String id = forum.getId();
                        String id2 = VideoPbFragment.this.dmG().getPbData().dlp().getId();
                        VideoPbFragment.this.showProgressBar();
                        VideoPbFragment.this.gfY.c(id, name, id2, i2, VideoPbFragment.this.mmF.dqZ());
                    }
                } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dqc()) {
                    if (VideoPbFragment.this.dmG() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        VideoPbFragment.this.mmF.drt();
                        SparseArray<Object> b = VideoPbFragment.this.b(VideoPbFragment.this.dmG().getPbData(), VideoPbFragment.this.dmG().doL(), 1);
                        if (b != null) {
                            VideoPbFragment.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForbidActivityConfig(VideoPbFragment.this.getPageContext().getPageActivity(), VideoPbFragment.this.dmG().getPbData().getForum().getId(), VideoPbFragment.this.dmG().getPbData().getForum().getName(), VideoPbFragment.this.dmG().getPbData().dlp().getId(), String.valueOf(VideoPbFragment.this.dmG().getPbData().getUserData().getUserId()), (String) b.get(R.id.tag_forbid_user_name), (String) b.get(R.id.tag_forbid_user_name_show), (String) b.get(R.id.tag_forbid_user_post_id), (String) b.get(R.id.tag_forbid_user_portrait))));
                        }
                    }
                } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dpY()) {
                    if (VideoPbFragment.this.dmG() != null) {
                        if (!j.isNetWorkAvailable()) {
                            VideoPbFragment.this.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> b2 = VideoPbFragment.this.b(VideoPbFragment.this.dmG().getPbData(), VideoPbFragment.this.dmG().doL(), 1);
                        if (b2 != null) {
                            if (StringUtils.isNull((String) b2.get(R.id.tag_del_multi_forum))) {
                                VideoPbFragment.this.mmF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue());
                            } else {
                                VideoPbFragment.this.mmF.a(((Integer) b2.get(R.id.tag_del_post_type)).intValue(), (String) b2.get(R.id.tag_del_post_id), ((Integer) b2.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) b2.get(R.id.tag_del_post_is_self)).booleanValue(), (String) b2.get(R.id.tag_del_multi_forum));
                            }
                        }
                        VideoPbFragment.this.mmF.baP();
                    }
                } else if (view.getId() == R.id.sub_pb_more || view.getId() == R.id.sub_pb_item || view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.new_sub_pb_list_richText || view.getId() == R.id.pb_post_reply_count) {
                    if (view.getId() == R.id.new_sub_pb_list_richText) {
                        com.baidu.tbadk.core.util.ar arVar3 = new com.baidu.tbadk.core.util.ar("c13398");
                        arVar3.dR("tid", VideoPbFragment.this.dmG().doJ());
                        arVar3.dR("fid", VideoPbFragment.this.dmG().getForumId());
                        arVar3.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar3.aq("obj_locate", 4);
                        TiebaStatic.log(arVar3);
                    }
                    if ((view.getId() == R.id.pb_floor_reply_more || view.getId() == R.id.pb_post_reply_count) && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_chakanhuifu"))) {
                        VideoPbFragment.this.lTF = view;
                    } else if (!VideoPbFragment.this.checkUpIsLogin()) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").aq("obj_locate", 3).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()));
                    } else if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                        if (VideoPbFragment.this.mmF != null) {
                            VideoPbFragment.this.mmF.drt();
                        }
                        SparseArray sparseArray2 = (SparseArray) view.getTag();
                        PostData postData2 = (PostData) sparseArray2.get(R.id.tag_load_sub_data);
                        PostData postData3 = (PostData) sparseArray2.get(R.id.tag_load_sub_reply_data);
                        if (postData2 != null) {
                            if (postData2.dOa() == 1) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12630"));
                            }
                            if (postData2.nzY != null) {
                                com.baidu.tbadk.core.util.ar bsQ = postData2.nzY.bsQ();
                                bsQ.delete("obj_locate");
                                if (view.getId() == R.id.new_sub_pb_list_richText) {
                                    bsQ.aq("obj_locate", 6);
                                } else if (view.getId() == R.id.pb_floor_reply_more) {
                                    bsQ.aq("obj_locate", 8);
                                }
                                TiebaStatic.log(bsQ);
                            }
                            VideoPbFragment.this.cDh();
                            TiebaStatic.log("c11742");
                            if (postData3 != null) {
                                VideoPbFragment.this.a(postData2, postData3, false, true);
                            } else {
                                VideoPbFragment.this.a(postData2, (PostData) null, false, false);
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_post_reply || view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                    if (VideoPbFragment.this.dmG() != null) {
                        if (view.getId() == R.id.pb_post_reply) {
                            com.baidu.tbadk.core.util.ar arVar4 = new com.baidu.tbadk.core.util.ar("c13398");
                            arVar4.dR("tid", VideoPbFragment.this.dmG().doJ());
                            arVar4.dR("fid", VideoPbFragment.this.dmG().getForumId());
                            arVar4.dR("uid", TbadkCoreApplication.getCurrentAccount());
                            arVar4.aq("obj_locate", 6);
                            TiebaStatic.log(arVar4);
                        }
                        if (view.getId() == R.id.post_info_commont_img) {
                            if (!com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                                VideoPbFragment.this.lTG = view;
                                return;
                            }
                        } else if (view.getId() == R.id.pb_post_reply && !com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huifu_louzhonglou"))) {
                            VideoPbFragment.this.lTG = view;
                            return;
                        }
                        if (VideoPbFragment.this.checkUpIsLogin() && (view.getTag() instanceof SparseArray)) {
                            SparseArray sparseArray3 = (SparseArray) view.getTag();
                            if (sparseArray3.get(R.id.tag_load_sub_data) instanceof PostData) {
                                PostData postData4 = (PostData) sparseArray3.get(R.id.tag_load_sub_data);
                                if (view.getId() == R.id.pb_post_reply && postData4.nzY != null) {
                                    com.baidu.tbadk.core.util.ar bsQ2 = postData4.nzY.bsQ();
                                    bsQ2.delete("obj_locate");
                                    bsQ2.aq("obj_locate", 8);
                                    TiebaStatic.log(bsQ2);
                                } else if (view.getId() == R.id.post_info_commont_img || view.getId() == R.id.pb_floor_comment_container) {
                                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13700").dR("tid", VideoPbFragment.this.dmG().doK()).dR("fid", VideoPbFragment.this.dmG().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).dR("post_id", postData4.getId()).aq("obj_source", 1).aq("obj_type", 3));
                                }
                                if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.lTf != null && postData4.bnS() != null && postData4.dNO() != 1) {
                                    if (VideoPbFragment.this.mcx != null) {
                                        VideoPbFragment.this.mcx.dnq();
                                    }
                                    if (VideoPbFragment.this.lTP && postData4.dNL() != null && postData4.dNL().size() != 0) {
                                        VideoPbFragment.this.a(postData4, (PostData) null, true, false);
                                        return;
                                    }
                                    q qVar2 = new q();
                                    qVar2.a(VideoPbFragment.this.dmG().getPbData().getForum());
                                    qVar2.setThreadData(VideoPbFragment.this.dmG().getPbData().dlp());
                                    qVar2.g(postData4);
                                    VideoPbFragment.this.lTf.d(qVar2);
                                    VideoPbFragment.this.lTf.setPostId(postData4.getId());
                                    VideoPbFragment.this.a(view, postData4.bnS().getUserId(), "", postData4);
                                    if (VideoPbFragment.this.lUg != null) {
                                        VideoPbFragment.this.vI(VideoPbFragment.this.lUg.bBY());
                                    }
                                }
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_collection) {
                    if (!j.isNetWorkAvailable()) {
                        VideoPbFragment.this.showToast(R.string.network_not_available);
                    } else if (VideoPbFragment.this.mmF != null && VideoPbFragment.this.dmG() != null) {
                        if (com.baidu.tbadk.a.d.bjc() || VideoPbFragment.this.duw() != null) {
                            if (!com.baidu.tbadk.a.d.bjc() || VideoPbFragment.this.duy() != null) {
                                VideoPbFragment.this.mmF.drt();
                                if (view.getId() != R.id.pb_editor_tool_collection || com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_shoucang"))) {
                                    if (VideoPbFragment.this.FN(RequestResponseCode.REQUEST_LOGIN_PB_MARK) && VideoPbFragment.this.dmG() != null) {
                                        VideoPbFragment.this.dnT();
                                        if (VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().dlp() != null && VideoPbFragment.this.dmG().getPbData().dlp().bnS() != null) {
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).aq("obj_locate", 3).dR("uid", VideoPbFragment.this.dmG().getPbData().dlp().bnS().getUserId()));
                                        }
                                        if (VideoPbFragment.this.dmG().getPbData().dlp() != null && VideoPbFragment.this.dmG().getPbData().dlp().bnS() != null && VideoPbFragment.this.dmG().getPbData().dlp().bnS().getUserId() != null && VideoPbFragment.this.lTS != null) {
                                            int h = VideoPbFragment.this.mmF.h(VideoPbFragment.this.dmG().getPbData());
                                            cb dlp = VideoPbFragment.this.dmG().getPbData().dlp();
                                            if (!dlp.bmz()) {
                                                if (dlp.bmA()) {
                                                    i = 3;
                                                } else if (dlp.bpP()) {
                                                    i = 4;
                                                } else {
                                                    i = dlp.bpQ() ? 5 : 1;
                                                }
                                            }
                                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c12526").dR("tid", VideoPbFragment.this.dmG().doJ()).aq("obj_locate", 1).dR("obj_id", VideoPbFragment.this.dmG().getPbData().dlp().bnS().getUserId()).aq("obj_type", VideoPbFragment.this.lTS.bkb() ? 0 : 1).aq("obj_source", h).aq("obj_param1", i));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                                VideoPbFragment.this.lTH = view;
                            }
                        }
                    }
                } else if (view.getId() == R.id.pb_editor_tool_share) {
                    VideoPbFragment.this.wl(true);
                } else if (view.getId() == R.id.pb_editor_tool_comment_icon) {
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.mmF != null && VideoPbFragment.this.faC != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().dlp() != null && VideoPbFragment.this.checkUpIsLogin()) {
                        f pbData = VideoPbFragment.this.dmG().getPbData();
                        if (pbData.dlp().bnJ() != 0) {
                            int currentItem = VideoPbFragment.this.faC.getCurrentItem();
                            if (!com.baidu.tbadk.a.d.bjc() && currentItem == VideoPbFragment.mmj) {
                                VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mmk);
                            } else if (com.baidu.tbadk.a.d.bjc() || currentItem == VideoPbFragment.mmk) {
                                if (!com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duw() == null) {
                                    return;
                                }
                                if ((!com.baidu.tbadk.a.d.bjc() || VideoPbFragment.this.duy() != null) && VideoPbFragment.this.cGb() != null) {
                                    com.baidu.tbadk.core.util.ar dR = new com.baidu.tbadk.core.util.ar("c13403").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount());
                                    int equipmentHeight = (int) (l.getEquipmentHeight(VideoPbFragment.this.getContext()) * 0.6d);
                                    BdTypeRecyclerView cGb = VideoPbFragment.this.cGb();
                                    if (cGb != null) {
                                        boolean canScrollVertically = cGb.canScrollVertically(1);
                                        boolean canScrollVertically2 = cGb.canScrollVertically(-1);
                                        if (VideoPbFragment.this.abf != null) {
                                            VideoPbFragment.this.abf.setExpanded(false, true);
                                        }
                                        if (cGb.getLayoutManager() != null && (cGb.getLayoutManager() instanceof LinearLayoutManager)) {
                                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) cGb.getLayoutManager();
                                            if (!canScrollVertically2 && canScrollVertically) {
                                                if (VideoPbFragment.this.lTK != -1 || VideoPbFragment.this.lTL != Integer.MIN_VALUE) {
                                                    if (VideoPbFragment.this.lTK > 3 || (VideoPbFragment.this.lTK == 3 && VideoPbFragment.this.lTL < (-equipmentHeight))) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lTK, VideoPbFragment.this.lTL + equipmentHeight);
                                                        cGb.smoothScrollBy(0, equipmentHeight);
                                                    } else if (VideoPbFragment.this.lTK >= 2) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lTK, VideoPbFragment.this.lTL + (equipmentHeight / 2));
                                                        cGb.smoothScrollBy(0, equipmentHeight / 2);
                                                    } else if (VideoPbFragment.this.lTK == 1) {
                                                        linearLayoutManager.scrollToPositionWithOffset(VideoPbFragment.this.lTK, VideoPbFragment.this.lTL + (equipmentHeight / 4));
                                                        cGb.smoothScrollBy(0, equipmentHeight / 4);
                                                    } else {
                                                        cGb.smoothScrollBy(0, -VideoPbFragment.this.lTL);
                                                    }
                                                    dR.aq("obj_locate", 2);
                                                } else {
                                                    return;
                                                }
                                            } else {
                                                int firstVisiblePosition = cGb.getFirstVisiblePosition();
                                                View childAt = cGb.getChildAt(0);
                                                int top = childAt == null ? 0 : childAt.getTop();
                                                VideoPbFragment.this.lTK = firstVisiblePosition;
                                                VideoPbFragment.this.lTL = top;
                                                if (firstVisiblePosition > 6 || (firstVisiblePosition == 6 && top < (-equipmentHeight) && cGb.getCount() >= 6)) {
                                                    linearLayoutManager.scrollToPositionWithOffset(6, 0);
                                                    cGb.smoothScrollToPosition(0);
                                                } else {
                                                    cGb.smoothScrollToPosition(0);
                                                }
                                                dR.aq("obj_locate", 1);
                                            }
                                            TiebaStatic.log(dR);
                                            com.baidu.tbadk.pageExtra.c bR = com.baidu.tbadk.pageExtra.d.bR(view);
                                            com.baidu.tbadk.core.util.ar arVar5 = new com.baidu.tbadk.core.util.ar("c12942");
                                            arVar5.aq("obj_type", 1);
                                            arVar5.aq("obj_locate", 4);
                                            arVar5.dR("tid", VideoPbFragment.this.dmG().doJ());
                                            arVar5.dR(IntentConfig.NID, pbData.dlp().bmq());
                                            if (bR != null) {
                                                arVar5.dR("obj_cur_page", bR.getCurrentPageKey());
                                            }
                                            if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                                                arVar5.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
                                            }
                                            TiebaStatic.log(arVar5);
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
                            if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().dlp() != null && VideoPbFragment.this.dmG().getPbData().dlp().bnS() != null) {
                                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).aq("obj_locate", 2).dR("uid", VideoPbFragment.this.dmG().getPbData().dlp().bnS().getUserId()));
                                return;
                            }
                            return;
                        }
                        VideoPbFragment.this.wm(false);
                        VideoPbFragment.this.dnH();
                    }
                } else if (view.getId() == R.id.tv_pb_reply_more) {
                    if (VideoPbFragment.this.lUt >= 0) {
                        if (VideoPbFragment.this.dmG() != null) {
                            VideoPbFragment.this.dmG().dpv();
                        }
                        if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null && VideoPbFragment.this.duy().dvf() != null) {
                            VideoPbFragment.this.duy().dvf().setData(VideoPbFragment.this.dmG().getPbData());
                        } else if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.duw() != null && VideoPbFragment.this.duw().dvf() != null) {
                            VideoPbFragment.this.duw().dvf().setData(VideoPbFragment.this.dmG().getPbData());
                        }
                        VideoPbFragment.this.lUt = 0;
                        VideoPbFragment.this.mmH = Integer.MIN_VALUE;
                        if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.dmG() != null && VideoPbFragment.this.duy() != null) {
                            VideoPbFragment.this.duy().dd(VideoPbFragment.this.dmG().dpy(), VideoPbFragment.this.dmG().dpz());
                            VideoPbFragment.this.dmG().da(0, 0);
                        } else if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.duw() != null) {
                            VideoPbFragment.this.duw().dd(VideoPbFragment.this.dmG().dpy(), VideoPbFragment.this.dmG().dpz());
                            VideoPbFragment.this.dmG().da(0, 0);
                        }
                    }
                } else if ((view instanceof PlayVoiceBntNew) && (view.getParent() instanceof TbRichTextView)) {
                    if (VideoPbFragment.this.dmG() != null) {
                        com.baidu.tbadk.core.util.ar arVar6 = new com.baidu.tbadk.core.util.ar("c13398");
                        arVar6.dR("tid", VideoPbFragment.this.dmG().doJ());
                        arVar6.dR("fid", VideoPbFragment.this.dmG().getForumId());
                        arVar6.dR("uid", TbadkCoreApplication.getCurrentAccount());
                        arVar6.aq("obj_locate", 2);
                        TiebaStatic.log(arVar6);
                    }
                } else if (view.getId() == R.id.pb_item_tail_content) {
                    if (bh.checkUpIsLogin(VideoPbFragment.this.getPageContext().getPageActivity())) {
                        String string = TbadkCoreApplication.getInst().getString(R.string.tail_web_view_title);
                        String string2 = com.baidu.tbadk.core.sharedPref.b.brR().getString("tail_link", "");
                        if (!StringUtils.isNull(string2)) {
                            TiebaStatic.log("c10056");
                            com.baidu.tbadk.browser.a.startWebActivity(view.getContext(), string, string2, true, true, true);
                        }
                        VideoPbFragment.this.dqB();
                    }
                } else if (view.getId() == R.id.keyboard_background_shadow) {
                    VideoPbFragment.this.dqB();
                } else if (VideoPbFragment.this.mmF.dsB() != null && view == VideoPbFragment.this.mmF.dsB().dqb()) {
                    VideoPbFragment.this.mmF.drt();
                    if (VideoPbFragment.this.dmG() != null) {
                        VideoPbFragment.this.izJ.setThreadId(VideoPbFragment.this.dmG().doJ());
                    }
                    if (VideoPbFragment.this.dmG() == null || !VideoPbFragment.this.dmG().isPrivacy()) {
                        VideoPbFragment.this.izJ.csc();
                        if (!TbSingleton.getInstance().mCanCallFans && VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().getThreadId() != null && VideoPbFragment.this.dmG().getPbData().getThreadId().equals(TbSingleton.getInstance().mCallFansTid)) {
                            i3 = 2;
                        }
                        if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                            VideoPbFragment.this.izJ.k(3, i3, VideoPbFragment.this.dmG().getPbData().getThreadId());
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.showToast(R.string.privacy_thread_can_not_use_call_fans);
                    if (VideoPbFragment.this.dmG().getPbData() != null) {
                        VideoPbFragment.this.izJ.k(3, 3, VideoPbFragment.this.dmG().getPbData().getThreadId());
                    }
                } else if (view.getId() == R.id.pb_floor_right_top_feedback || view.getId() == R.id.pb_post_op_more) {
                    com.baidu.tbadk.core.util.ar arVar7 = new com.baidu.tbadk.core.util.ar("c13398");
                    arVar7.dR("tid", VideoPbFragment.this.dmG().doJ());
                    arVar7.dR("fid", VideoPbFragment.this.dmG().getForumId());
                    arVar7.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar7.aq("obj_locate", 7);
                    TiebaStatic.log(arVar7);
                    VideoPbFragment.this.mmF.wu(false);
                    VideoPbFragment.this.mmF.dun().onLongClick(view);
                }
            }
        }
    };
    private View.OnClickListener lQu = new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.22
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SparseArray<Object> sparseArray = (SparseArray) view.getTag();
            if (sparseArray != null) {
                boolean booleanValue = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
                boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
                boolean booleanValue3 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
                if (VideoPbFragment.this.mmF != null) {
                    if (booleanValue) {
                        if (booleanValue2) {
                            sparseArray.put(R.id.tag_from, 1);
                            VideoPbFragment.this.mmF.d(sparseArray);
                            return;
                        }
                        VideoPbFragment.this.mmF.dL(view);
                    } else if (booleanValue2) {
                        sparseArray.put(R.id.tag_from, 0);
                        sparseArray.put(R.id.tag_check_mute_from, 1);
                        VideoPbFragment.this.mmF.d(sparseArray);
                    } else if (booleanValue3) {
                        VideoPbFragment.this.mmF.a(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                    }
                }
            }
        }
    };
    private CustomMessageListener jwA = new CustomMessageListener(CmdConfigCustom.CMD_RICHTEXT_INTENTSPAN_CLICK) { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.24
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                com.baidu.tbadk.widget.richText.f.a(VideoPbFragment.this.getPageContext(), VideoPbFragment.this, aVar.type, aVar.url, aVar.subType);
            }
        }
    };
    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.40
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            VideoPbFragment.this.mmF.wu(true);
            return VideoPbFragment.this.mmF.dun().onLongClick(view);
        }
    };
    public SortSwitchButton.a lUS = new SortSwitchButton.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.41
        @Override // com.baidu.tieba.view.SortSwitchButton.a
        public boolean zq(int i) {
            if (VideoPbFragment.this.mmF != null) {
                VideoPbFragment.this.mmF.drt();
            }
            if (!j.isNetWorkAvailable()) {
                VideoPbFragment.this.showToast(R.string.network_not_available);
                return false;
            } else if (VideoPbFragment.this.dmG() == null || VideoPbFragment.this.dmG().isLoading) {
                return false;
            } else {
                VideoPbFragment.this.cDh();
                VideoPbFragment.this.dra();
                if (VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().lMo != null && VideoPbFragment.this.dmG().getPbData().lMo.size() > i) {
                    int intValue = VideoPbFragment.this.dmG().getPbData().lMo.get(i).sort_type.intValue();
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13699").dR("tid", VideoPbFragment.this.dmG().doK()).dR("fid", VideoPbFragment.this.dmG().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()).aq("obj_type", FQ(intValue)));
                    if (VideoPbFragment.this.dmG().FX(intValue)) {
                        VideoPbFragment.this.mIsLoading = true;
                    }
                }
                return true;
            }
        }

        private int FQ(int i) {
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
    private a mmG = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public void dnR() {
        if (dmG() != null && dmG().getPbData() != null && dmG().getPbData().dlp() != null) {
            cb dlp = dmG().getPbData().dlp();
            dlp.mRecomAbTag = dmG().dpF();
            dlp.mRecomWeight = dmG().dpD();
            dlp.mRecomSource = dmG().dpE();
            dlp.mRecomExtra = dmG().dpG();
            dlp.eVF = dmG().doR();
            if (dlp.getFid() == 0) {
                dlp.setFid(com.baidu.adp.lib.f.b.toLong(dmG().getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlp, "c13562");
            if (a2 != null) {
                TiebaStatic.log(a2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(boolean z) {
        if (dmG() != null && dmG().getPbData() != null && dmG().getPbData().dlp() != null) {
            cb dlp = dmG().getPbData().dlp();
            dlp.mRecomAbTag = dmG().dpF();
            dlp.mRecomWeight = dmG().dpD();
            dlp.mRecomSource = dmG().dpE();
            dlp.mRecomExtra = dmG().dpG();
            if (dlp.getFid() == 0) {
                dlp.setFid(com.baidu.adp.lib.f.b.toLong(dmG().getForumId(), 0L));
            }
            com.baidu.tbadk.core.util.ar a2 = com.baidu.tbadk.pageInfo.c.a(getContext(), dlp, "c13563");
            TbPageTag fs = com.baidu.tbadk.pageInfo.c.fs(getContext());
            if (a2 != null && fs != null && PageStayDurationConstants.PageName.VIDEO_LIST.equals(fs.locatePage)) {
                a2.dR("obj_cur_page", PageStayDurationConstants.PageName.PB);
                a2.dR("obj_pre_page", PageStayDurationConstants.PageName.VIDEO_LIST);
            }
            if (a2 != null) {
                a2.aq("reply_type", 1);
                if (z) {
                    a2.aq("obj_type", 2);
                } else {
                    a2.aq("obj_type", 1);
                }
                com.baidu.tbadk.pageExtra.c fp = com.baidu.tbadk.pageExtra.d.fp(getContext());
                if (fp != null) {
                    a2.dR("obj_cur_page", fp.getCurrentPageKey());
                }
                if (com.baidu.tbadk.pageExtra.d.bDP() != null) {
                    a2.dR("obj_pre_page", com.baidu.tbadk.pageExtra.d.bDP());
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
            if (au.isEmpty(str)) {
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
            String string = !TextUtils.isEmpty(bVar.nCc) ? bVar.nCc : getString(R.string.delete_fail);
            if (bVar.mErrCode == 1211066) {
                hideProgressBar();
                com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
                aVar.AB(string);
                aVar.a(R.string.dialog_known, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.15
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
                aVar.jF(true);
                aVar.b(getPageContext());
                aVar.bqz();
            } else {
                a(0, bVar.mSuccess, bVar.nCc, z);
            }
            if (bVar.mSuccess) {
                if (bVar.iPc == 1) {
                    ArrayList<PostData> dlr = dmG().getPbData().dlr();
                    int size = dlr.size();
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (!bVar.mPostId.equals(dlr.get(i).getId())) {
                            i++;
                        } else {
                            dlr.remove(i);
                            break;
                        }
                    }
                    dmG().getPbData().dlp().nl(dmG().getPbData().dlp().bnJ() - 1);
                    if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
                        duy().dvh();
                    } else if (duw() != null) {
                        duw().dvh();
                    }
                } else if (bVar.iPc == 0) {
                    dnS();
                } else if (bVar.iPc == 2) {
                    ArrayList<PostData> dlr2 = dmG().getPbData().dlr();
                    int size2 = dlr2.size();
                    int i2 = 0;
                    boolean z3 = false;
                    while (i2 < size2 && !z3) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= dlr2.get(i2).dNL().size()) {
                                z2 = z3;
                                break;
                            } else if (!bVar.mPostId.equals(dlr2.get(i2).dNL().get(i3).getId())) {
                                i3++;
                            } else {
                                dlr2.get(i2).dNL().remove(i3);
                                dlr2.get(i2).dNN();
                                z2 = true;
                                break;
                            }
                        }
                        dlr2.get(i2).Tx(bVar.mPostId);
                        i2++;
                        z3 = z2;
                    }
                    if (z3) {
                        if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
                            duy().dvh();
                        } else if (duw() != null) {
                            duw().dvh();
                        }
                    }
                    a(bVar);
                }
            }
        }
    }

    public void a(ForumManageModel.b bVar) {
        boolean z;
        List<PostData> list = dmG().getPbData().dlD().lNY;
        int size = list.size();
        int i = 0;
        boolean z2 = false;
        while (i < size) {
            int i2 = 0;
            while (true) {
                if (i2 >= list.get(i).dNL().size()) {
                    z = z2;
                    break;
                } else if (!bVar.mPostId.equals(list.get(i).dNL().get(i2).getId())) {
                    i2++;
                } else {
                    list.get(i).dNL().remove(i2);
                    list.get(i).dNN();
                    z = true;
                    break;
                }
            }
            list.get(i).Tx(bVar.mPostId);
            i++;
            z2 = z;
        }
        if (z2) {
            if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
                duy().dvh();
            } else if (duw() != null) {
                duw().dvh();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForumManageModel.g gVar) {
        String string;
        if (gVar != null && dmG() != null && dmG().getPbData() != null && dmG().getPbData().dlp() != null) {
            a(this.gfY.getLoadDataMode(), gVar.mSuccess, gVar.nCc, false);
            if (gVar.mSuccess) {
                this.lTV = true;
                if (i == 2 || i == 3) {
                    this.lTW = true;
                    this.lTX = false;
                } else if (i == 4 || i == 5) {
                    this.lTW = false;
                    this.lTX = true;
                }
                if (i == 2) {
                    dmG().getPbData().dlp().no(1);
                    dmG().setIsGood(1);
                } else if (i == 3) {
                    dmG().getPbData().dlp().no(0);
                    dmG().setIsGood(0);
                } else if (i == 4) {
                    dmG().getPbData().dlp().nn(1);
                    dmG().FR(1);
                } else if (i == 5) {
                    dmG().getPbData().dlp().nn(0);
                    dmG().FR(0);
                }
            } else {
                if (gVar != null && !TextUtils.isEmpty(gVar.nCc)) {
                    string = gVar.nCc;
                } else {
                    string = getString(R.string.operation_failed);
                }
                l.showToast(getPageContext().getPageActivity(), string);
            }
            if (dmG().getPbData().dlp() != null && dux() != null) {
                dux().dvr();
            }
        }
    }

    private void dnS() {
        if (dmG().doM() || dmG().doO()) {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.putExtra("tid", dmG().doJ());
            PbActivity pbActivity = this.lTk;
            PbActivity pbActivity2 = this.lTk;
            pbActivity.setResult(-1, intent);
        }
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.PB_DELETE_THREAD, dmG().doJ()));
        if (dnV()) {
            this.lTk.finish();
        }
    }

    private boolean dnV() {
        if (dmG() == null) {
            return true;
        }
        if (dmG().getPbData() == null || !dmG().getPbData().dlS()) {
            if (dmG().bkb()) {
                final MarkData dpe = dmG().dpe();
                if (dpe == null || !dmG().getIsFromMark() || cGb() == null) {
                    return true;
                }
                final MarkData FY = dmG().FY(cGb().getFirstVisiblePosition());
                if (FY == null) {
                    Intent intent = new Intent();
                    intent.putExtra("mark", dpe);
                    this.lTk.setResult(-1, intent);
                    return true;
                } else if (FY.getPostId() == null || FY.getPostId().equals(dpe.getPostId())) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("mark", dpe);
                    this.lTk.setResult(-1, intent2);
                    return true;
                } else {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getBaseFragmentActivity());
                    aVar.AB(getPageContext().getString(R.string.alert_update_mark));
                    aVar.a(R.string.confirm, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.17
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            if (VideoPbFragment.this.lTS != null) {
                                if (VideoPbFragment.this.lTS.bkb()) {
                                    VideoPbFragment.this.lTS.bkc();
                                    VideoPbFragment.this.lTS.ja(false);
                                }
                                VideoPbFragment.this.lTS.a(FY);
                                VideoPbFragment.this.lTS.ja(true);
                                VideoPbFragment.this.lTS.bkd();
                            }
                            dpe.setPostId(FY.getPostId());
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dpe);
                            VideoPbFragment.this.lTk.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dmU();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, true));
                        }
                    });
                    aVar.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.18
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar2.dismiss();
                            Intent intent3 = new Intent();
                            intent3.putExtra("mark", dpe);
                            VideoPbFragment.this.lTk.setResult(-1, intent3);
                            aVar.dismiss();
                            VideoPbFragment.this.dmU();
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921531, false));
                        }
                    });
                    aVar.d(new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.19
                        @Override // android.content.DialogInterface.OnCancelListener
                        public void onCancel(DialogInterface dialogInterface) {
                            dialogInterface.dismiss();
                        }
                    });
                    aVar.b(getBaseFragmentActivity().getPageContext());
                    aVar.bqz();
                    return false;
                }
            } else if (dmG().getPbData() == null || dmG().getPbData().dlr() == null || dmG().getPbData().dlr().size() <= 0 || !dmG().getIsFromMark()) {
                return true;
            } else {
                this.lTk.setResult(1);
                return true;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmU() {
        this.lTk.dmU();
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
    public void wl(boolean z) {
        com.baidu.tieba.pb.data.f pbData;
        int i;
        if (dmG() != null && this.mmF != null) {
            if ((ShareSwitch.isOn() || checkUpIsLogin()) && (pbData = dmG().getPbData()) != null) {
                cb dlp = pbData.dlp();
                if (dlp != null && dlp.bnS() != null) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", dmG().doJ()).dR("fid", pbData.getForumId()).aq("obj_locate", 4).dR("uid", dlp.bnS().getUserId()));
                }
                if (dlp != null) {
                    if (dlp.bmz()) {
                        i = 2;
                    } else if (dlp.bmA()) {
                        i = 3;
                    } else if (dlp.bpP()) {
                        i = 4;
                    } else if (dlp.bpQ()) {
                        i = 5;
                    }
                    com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    arVar.dR("tid", dmG().doJ());
                    arVar.dR("uid", TbadkCoreApplication.getCurrentAccount());
                    arVar.dR("fid", dmG().getForumId());
                    if (!z) {
                        arVar.aq("obj_locate", 6);
                    } else {
                        arVar.aq("obj_locate", 5);
                    }
                    arVar.aq("obj_name", i);
                    arVar.aq("obj_type", 2);
                    if (dlp != null) {
                        if (dlp.bmz()) {
                            arVar.aq("obj_type", 10);
                        } else if (dlp.bmA()) {
                            arVar.aq("obj_type", 9);
                        } else if (dlp.bpQ()) {
                            arVar.aq("obj_type", 8);
                        } else if (dlp.bpP()) {
                            arVar.aq("obj_type", 7);
                        } else if (dlp.isShareThread) {
                            arVar.aq("obj_type", 6);
                        } else if (dlp.threadType == 0) {
                            arVar.aq("obj_type", 1);
                        } else if (dlp.threadType == 40) {
                            arVar.aq("obj_type", 2);
                        } else if (dlp.threadType == 49) {
                            arVar.aq("obj_type", 3);
                        } else if (dlp.threadType == 54) {
                            arVar.aq("obj_type", 4);
                        } else {
                            arVar.aq("obj_type", 5);
                        }
                        arVar.dR(IntentConfig.NID, dlp.bmq());
                        arVar.aq(IntentConfig.CARD_TYPE, dlp.bpT());
                        arVar.dR(IntentConfig.RECOM_SOURCE, dlp.mRecomSource);
                        arVar.dR("ab_tag", dlp.mRecomAbTag);
                        arVar.dR("weight", dlp.mRecomWeight);
                        arVar.dR("extra", dlp.mRecomExtra);
                        arVar.dR(IntentConfig.NID, dlp.bmq());
                        if (dlp.getBaijiahaoData() != null && !au.isEmpty(dlp.getBaijiahaoData().oriUgcVid)) {
                            arVar.dR("obj_param6", dlp.getBaijiahaoData().oriUgcVid);
                        }
                    }
                    if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                        arVar.dR("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    }
                    if (doq() != null) {
                        com.baidu.tbadk.pageInfo.c.b(doq(), arVar);
                    }
                    TiebaStatic.log(arVar);
                    if (l.isNetOk()) {
                        showToast(R.string.neterror);
                        return;
                    } else if (dmG().getPbData() == null) {
                        l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                        return;
                    } else {
                        ArrayList<PostData> dlr = pbData.dlr();
                        if ((dlr == null || dlr.size() <= 0) && dmG().doL()) {
                            l.showToast(getPageContext().getPageActivity(), getPageContext().getString(R.string.pb_no_data_tips));
                            return;
                        }
                        this.mmF.drt();
                        cDh();
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11939"));
                        if (!AntiHelper.d(getContext(), dlp)) {
                            if (this.mbV != null) {
                                this.mbV.setEnable(false);
                                x(pbData);
                            }
                            if (ShareSwitch.isOn()) {
                                FO(z ? 2 : 1);
                                return;
                            }
                            this.mmF.showLoadingDialog();
                            dmG().dpp().z(CheckRealNameModel.TYPE_PB_SHARE, 6);
                            return;
                        }
                        return;
                    }
                }
                i = 1;
                com.baidu.tbadk.core.util.ar arVar2 = new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                arVar2.dR("tid", dmG().doJ());
                arVar2.dR("uid", TbadkCoreApplication.getCurrentAccount());
                arVar2.dR("fid", dmG().getForumId());
                if (!z) {
                }
                arVar2.aq("obj_name", i);
                arVar2.aq("obj_type", 2);
                if (dlp != null) {
                }
                if (!au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
                }
                if (doq() != null) {
                }
                TiebaStatic.log(arVar2);
                if (l.isNetOk()) {
                }
            }
        }
    }

    public static VideoPbFragment dud() {
        return new VideoPbFragment();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getBaseFragmentActivity().hideLoadingView(getBaseFragmentActivity().findViewById(R.id.container));
        VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
        M(videoPbViewModel.duI());
        N(videoPbViewModel.duI());
        if (dmG() != null && dmG().getPbData() != null) {
            boolean isFromMark = dmG().getIsFromMark();
            com.baidu.tieba.pb.data.f pbData = dmG().getPbData();
            if (isFromMark) {
                PostData L = L(pbData);
                if (pbData.bka() != null && !pbData.bka().equals(L.getId()) && this.faC != null) {
                    if (com.baidu.tbadk.a.d.bjc()) {
                        this.faC.setCurrentItem(mml);
                    } else {
                        this.faC.setCurrentItem(mmk);
                    }
                }
            }
        }
        videoPbViewModel.duJ().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.25
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                BdTypeRecyclerView cGb;
                if (cbVar != null && cbVar.boj() != null) {
                    if (VideoPbFragment.this.mms.getVideoUrl() == null || !VideoPbFragment.this.mms.getVideoUrl().equals(cbVar.boj().video_url)) {
                        if (!au.isEmpty(VideoPbFragment.this.mms.getVideoUrl())) {
                            VideoPbFragment.this.lTy = true;
                            if (com.baidu.tbadk.a.d.bjc()) {
                                VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mml);
                            } else {
                                VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mmj);
                            }
                            if (com.baidu.tbadk.a.d.bjc() && (cGb = VideoPbFragment.this.cGb()) != null) {
                                cGb.scrollToPosition(0);
                            }
                        }
                        if (VideoPbFragment.this.mmt == null || !VideoPbFragment.this.mmt.isPlaying()) {
                            VideoPbFragment.this.due();
                            VideoPbFragment.this.aR(cbVar);
                        }
                        VideoPbFragment.this.duf();
                        if (VideoPbFragment.this.mmt.duV()) {
                            VideoPbFragment.this.mmt.start();
                        }
                        boolean z = !au.equals(VideoPbFragment.this.mms.getVideoUrl(), cbVar.boj().video_url);
                        VideoPbFragment.this.mms.setData(cbVar);
                        if (com.baidu.tbadk.a.d.bjc()) {
                            VideoPbFragment.this.mms.ww(false);
                        } else {
                            VideoPbFragment.this.mms.ww(VideoPbFragment.this.faC.getCurrentItem() == 0);
                        }
                        if (z) {
                            VideoPbFragment.this.mms.startPlay();
                            VideoPbFragment.this.mms.dvI();
                            return;
                        }
                        return;
                    }
                    VideoPbFragment.this.mms.setData(cbVar);
                }
            }
        });
        videoPbViewModel.duR().observe(this, new Observer<Integer>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.26
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Integer num) {
                VideoPbFragment.this.faC.setCurrentItem(num.intValue());
            }
        });
        videoPbViewModel.duN().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.27
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                VideoPbFragment.this.mms.aW(cbVar);
            }
        });
        videoPbViewModel.duO().observe(this, new Observer<cb>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.28
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: aS */
            public void onChanged(@Nullable cb cbVar) {
                VideoPbFragment.this.mms.aX(cbVar);
            }
        });
        videoPbViewModel.duP().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.29
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.dup();
            }
        });
        videoPbViewModel.duQ().observe(this, new Observer<Boolean>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.30
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            /* renamed from: r */
            public void onChanged(@Nullable Boolean bool) {
                VideoPbFragment.this.mNavigationBar.setVisibility(bool.booleanValue() ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void due() {
        ViewGroup.LayoutParams layoutParams = this.mmv.getLayoutParams();
        layoutParams.height = 0;
        this.mmv.setLayoutParams(layoutParams);
        this.mmv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duf() {
        if (this.mmt == null) {
            this.mmt = new e(getBaseFragmentActivity(), this.mmr);
            int statusBarHeight = (TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity())) ? l.getStatusBarHeight(doq()) : 0;
            Rect rect = new Rect(0, statusBarHeight, l.getEquipmentWidth(getContext()), this.mmr.getOriginHeight() + statusBarHeight);
            final VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
            this.mmt.b(videoPbViewModel.duK(), rect);
            if (this.mmt.duV()) {
                this.mmt.c(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.31
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (com.baidu.tbadk.a.d.bjc()) {
                            if (videoPbViewModel.duL() || VideoPbFragment.this.dmG().dpI() == VideoPbFragment.mml) {
                                VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mml);
                            }
                        } else if (videoPbViewModel.duL() || VideoPbFragment.this.dmG().dpI() == VideoPbFragment.mmk) {
                            VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mmk);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        if (com.baidu.tbadk.a.d.bjc()) {
                            if (videoPbViewModel.duL() || VideoPbFragment.this.dmG().dpI() == VideoPbFragment.mml) {
                                VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mml);
                            }
                        } else if (videoPbViewModel.duL() || VideoPbFragment.this.dmG().dpI() == VideoPbFragment.mmk) {
                            VideoPbFragment.this.faC.setCurrentItem(VideoPbFragment.mmk);
                        }
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }
                });
            } else if (com.baidu.tbadk.a.d.bjc()) {
                if (videoPbViewModel.duL() || dmG().dpI() == mml) {
                    this.faC.setCurrentItem(mml);
                }
            } else if (videoPbViewModel.duL() || dmG().dpI() == mmk) {
                this.faC.setCurrentItem(mmk);
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!this.mmL && (this.mmM || duC())) {
            duB();
            UtilHelper.hideStatusBar(doq(), doq().getRootView());
            this.mmM = false;
            if (this.mms != null) {
                this.mms.wo(false);
            }
        }
        if (i == 4) {
            return this.mms.dAP();
        }
        if (i == 24) {
            return this.mms.dvF();
        }
        if (i == 25) {
            return this.mms.dvG();
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
    public void aR(cb cbVar) {
        double d;
        int i;
        ViewGroup.LayoutParams layoutParams;
        CoordinatorLayout.LayoutParams layoutParams2;
        Rect dpH;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        double equipmentHeight = (2.0d * equipmentWidth) / l.getEquipmentHeight(getContext());
        if (cbVar != null && cbVar.boj() != null) {
            int intValue = cbVar.boj().video_width.intValue();
            int intValue2 = cbVar.boj().video_height.intValue();
            if (intValue2 > 0) {
                d = (intValue * 1.0f) / intValue2;
                if (d > 1.7777777777777777d) {
                    d = 1.7777777777777777d;
                }
                if (d >= equipmentHeight) {
                    equipmentHeight = d;
                }
                int ceil = (int) Math.ceil(equipmentWidth / equipmentHeight);
                int height = (dmG() != null || (dpH = dmG().dpH()) == null) ? ceil : dpH.height();
                i = 0;
                layoutParams = this.mmr.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams = new ViewGroup.LayoutParams(-1, height);
                } else {
                    i = layoutParams.height - height;
                    layoutParams.height = height;
                }
                this.mmr.setLayoutParams(layoutParams);
                this.mmr.setMaxHeight(ceil);
                this.mmr.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
                this.mmr.setOriginHeight(height);
                if (!com.baidu.tbadk.a.d.bjc()) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.mmn.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(-1, mmm);
                    } else {
                        layoutParams3.height = mmm;
                    }
                    this.mmn.setLayoutParams(layoutParams3);
                }
                layoutParams2 = (CoordinatorLayout.LayoutParams) this.abf.getLayoutParams();
                if (!com.baidu.tbadk.a.d.bjc()) {
                    ceil += mmm;
                }
                if (layoutParams2 != null) {
                    layoutParams2 = new CoordinatorLayout.LayoutParams(-1, ceil);
                } else {
                    layoutParams2.height = ceil;
                }
                this.abf.setLayoutParams(layoutParams2);
                if (i == 0 && (this.abf.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                    CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.abf.getLayoutParams()).getBehavior();
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
        if (dmG() != null) {
        }
        i = 0;
        layoutParams = this.mmr.getLayoutParams();
        if (layoutParams != null) {
        }
        this.mmr.setLayoutParams(layoutParams);
        this.mmr.setMaxHeight(ceil2);
        this.mmr.setMinHeight((int) Math.ceil(equipmentWidth / 1.7777777777777777d));
        this.mmr.setOriginHeight(height);
        if (!com.baidu.tbadk.a.d.bjc()) {
        }
        layoutParams2 = (CoordinatorLayout.LayoutParams) this.abf.getLayoutParams();
        if (!com.baidu.tbadk.a.d.bjc()) {
        }
        if (layoutParams2 != null) {
        }
        this.abf.setLayoutParams(layoutParams2);
        if (i == 0) {
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.lTs = System.currentTimeMillis();
        super.onCreate(bundle);
        this.needLogStayDuration = false;
        initData();
        at(bundle);
        getVoiceManager().onCreate(getPageContext());
        this.lUn = new com.baidu.tbadk.core.view.c();
        this.lUn.toastTime = 1000L;
        if (this.mmF != null) {
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(CmdConfigCustom.CMD_USER_MUTE_ADD_DEL_REGISTER_LISTENER);
            userMuteAddAndDelCustomMessage.from = 1;
            userMuteAddAndDelCustomMessage.mId = this.mmF.lUo;
            userMuteAddAndDelCustomMessage.setTag(this.mmF.lUo);
            MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(CmdConfigCustom.CMD_USER_MUTE_CHECK_REGISTER_LISTENER);
            userMuteCheckCustomMessage.mId = this.mmF.lUo;
            userMuteCheckCustomMessage.setTag(this.mmF.lUo);
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
        this.izJ = new com.baidu.tieba.callfans.a(getPageContext());
        com.baidu.tieba.s.c.dMH().B(getUniqueId());
    }

    private void initData() {
        this.lTS = com.baidu.tbadk.baseEditMark.a.a(this.lTk);
        if (this.lTS != null) {
            this.lTS.a(this.lUY);
        }
        this.gfY = new ForumManageModel(this.lTk);
        this.gfY.setLoadDataCallBack(this.izO);
        this.fce = new com.baidu.tbadk.coreExtra.model.a(getPageContext());
        this.mmF = new com.baidu.tieba.pb.videopb.b.a(this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void at(Bundle bundle) {
        this.lUf = new g();
        d(this.lUf);
        this.lUg = (com.baidu.tbadk.editortools.pb.e) this.lUf.ff(getActivity());
        this.lUg.a(this.lTk.getPageContext());
        this.lUg.a(this.fFv);
        this.lUg.a(this.fFn);
        this.lUg.setFrom(1);
        this.lUg.a(this.lTk.getPageContext(), bundle);
        this.lUg.bBk().c(new k(getActivity()));
        this.lUg.bBk().kN(true);
        uY(true);
        this.lUg.a(dmG().dpa(), dmG().doJ(), dmG().dpr());
        registerListener(this.lUD);
        registerListener(this.lUX);
        registerListener(this.lUC);
        registerListener(this.lUA);
        registerListener(this.jjH);
        if (!dmG().doR()) {
            this.lUg.Dc(dmG().doJ());
        }
        if (dmG().dps()) {
            this.lUg.Da(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
        } else {
            this.lUg.Da(dqD());
        }
        this.kYE = new ar();
        if (this.lUg.bBQ() != null) {
            this.kYE.f(this.lUg.bBQ().getInputView());
        }
        this.lUg.a(this.fFo);
        this.kUB = new am(getPageContext());
        this.kUB.a(new am.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.32
            @Override // com.baidu.tbadk.core.util.am.a
            public void q(boolean z, int i) {
                if (z) {
                    if (i == am.fbZ) {
                        VideoPbFragment.this.lUg.a((String) null, (WriteData) null);
                    } else if (i == am.fca && VideoPbFragment.this.mcx != null && VideoPbFragment.this.mcx.dnv() != null) {
                        VideoPbFragment.this.mcx.dnv().bCp();
                    } else if (i == am.fcb) {
                        VideoPbFragment.this.c(VideoPbFragment.this.lUj);
                    }
                }
            }
        });
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.rootView = (RelativeLayout) layoutInflater.inflate(R.layout.video_pb_fragment, viewGroup, false);
        initUI();
        return this.rootView;
    }

    private void initUI() {
        this.jna = new com.baidu.tieba.f.b(getActivity());
        this.jna.a(lVg);
        this.mmL = TbSingleton.getInstance().isNotchScreen(getActivity()) || TbSingleton.getInstance().isCutoutScreen(getActivity());
        bEP();
        this.abf = (AppBarLayout) this.rootView.findViewById(R.id.appbar_layout);
        this.mmp = this.rootView.findViewById(R.id.pb_video_pager_shadow);
        this.mmr = (VideoContainerLayout) this.rootView.findViewById(R.id.pb_video_container);
        this.mms = new com.baidu.tieba.pb.videopb.videoView.a(getContext(), this.mmr);
        this.mms.setStageType("2002");
        this.mms.setUniqueId(getUniqueId());
        this.mms.af(this);
        this.mms.dT(doq().getRootView());
        this.mms.dU(this.mmu);
        ((RelativeLayout) this.rootView.findViewById(R.id.scroll_container)).setMinimumHeight(((int) Math.ceil((l.getEquipmentWidth(getContext()) * 9) / 16.0d)) + getResources().getDimensionPixelOffset(R.dimen.tbds118));
        this.mmn = (NewPagerSlidingTabBaseStrip) this.rootView.findViewById(R.id.pb_video_tab_strip);
        this.mmv = this.rootView.findViewById(R.id.pb_video_mount_layout);
        this.faC = (CustomViewPager) this.rootView.findViewById(R.id.pb_video_view_pager);
        this.mmq = this.rootView.findViewById(R.id.keyboard_background_shadow);
        this.lSi = (MaskView) this.rootView.findViewById(R.id.mask_view);
        this.mmq.setOnClickListener(this.aFH);
        duh();
        dug();
        dui();
        this.mmo = new VideoPbFragmentAdapter(getBaseFragmentActivity().getSupportFragmentManager(), this);
        this.faC.setAdapter(this.mmo);
        this.mmn.setViewPager(this.faC);
        this.mmn.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.33
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                boolean z = false;
                if (i == 0) {
                    if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null) {
                        VideoPbFragment.this.duy().wv(false);
                    } else if (VideoPbFragment.this.duw() != null) {
                        VideoPbFragment.this.duw().wv(false);
                    }
                    if (VideoPbFragment.this.dux() != null) {
                        VideoPbFragment.this.dux().wv(true);
                        VideoPbFragment.this.Gy(VideoPbFragment.this.dux().dvl() != 0 ? 0 : 8);
                    }
                    VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(VideoPbFragment.this.getActivity()).get(VideoPbViewModel.class);
                    if (videoPbViewModel.duP() != null && videoPbViewModel.duP().getValue() != null && videoPbViewModel.duP().getValue().booleanValue()) {
                        z = true;
                    }
                    VideoPbFragment.this.mms.ww(z);
                    VideoPbFragment.this.dqB();
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13592").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()));
                    }
                } else {
                    if (VideoPbFragment.this.dux() != null) {
                        VideoPbFragment.this.dux().wv(false);
                    }
                    if (com.baidu.tbadk.a.d.bjc() && VideoPbFragment.this.duy() != null) {
                        VideoPbFragment.this.duy().wv(true);
                        int dvl = VideoPbFragment.this.duy().dvl();
                        int dvm = VideoPbFragment.this.duy().dvm();
                        if (dvl != 0) {
                            VideoPbFragment.this.Gy(8);
                            VideoPbFragment.this.duy().Gy(0);
                        } else if (dvm != 0) {
                            VideoPbFragment.this.duy().Gy(8);
                            VideoPbFragment.this.Gy(0);
                        } else {
                            VideoPbFragment.this.duy().Gy(8);
                            VideoPbFragment.this.Gy(8);
                        }
                    } else if (VideoPbFragment.this.duw() != null) {
                        VideoPbFragment.this.duw().wv(true);
                        int dvl2 = VideoPbFragment.this.duw().dvl();
                        int dvm2 = VideoPbFragment.this.duw().dvm();
                        if (dvl2 != 0) {
                            VideoPbFragment.this.Gy(8);
                            VideoPbFragment.this.duw().Gy(0);
                        } else if (dvm2 != 0) {
                            VideoPbFragment.this.duw().Gy(8);
                            VideoPbFragment.this.Gy(0);
                        } else {
                            VideoPbFragment.this.duw().Gy(8);
                            VideoPbFragment.this.Gy(8);
                        }
                    }
                    VideoPbFragment.this.mms.ww(false);
                    VideoPbFragment.this.abf.setExpanded(false, true);
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13593").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()));
                    }
                }
                VideoPbFragment.this.mmo.GA(i);
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }
        });
        this.mbw = this.rootView.findViewById(R.id.viewstub_progress);
        duj();
        bWA();
        if (!this.mmL && this.mmM) {
            duB();
            UtilHelper.hideStatusBar(doq(), doq().getRootView());
            this.mmM = false;
        }
        if (com.baidu.tbadk.a.d.bjc()) {
            this.mmn.getLayoutParams().height = 0;
        }
    }

    private void dug() {
        this.mmx = (TextView) this.rootView.findViewById(R.id.pb_video_mount_title);
        this.mmB = (TbImageView) this.rootView.findViewById(R.id.pb_video_mount_pic);
        this.mmy = (TextView) this.rootView.findViewById(R.id.pb_video_mount_desc);
        this.mmz = (ImageView) this.rootView.findViewById(R.id.pb_video_mount_close);
        this.mmA = (TBSpecificationBtn) this.rootView.findViewById(R.id.pb_video_mount_link);
        this.mmC = this.rootView.findViewById(R.id.ala_live_point);
        this.mmB.setRadius(l.getDimens(getContext(), R.dimen.tbds10));
        this.mmB.setConrers(15);
        this.mmA.setConfig(new com.baidu.tbadk.core.view.commonBtn.c());
        this.mmz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.35
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (VideoPbFragment.this.lMY == null || VideoPbFragment.this.lMY.dvx()) {
                    if (VideoPbFragment.this.lMY != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13608").dR("tid", VideoPbFragment.this.dmG().getPbData().getThreadId()));
                        VideoPbFragment.this.lMY.moJ = true;
                    }
                } else {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13591"));
                }
                VideoPbFragment.this.dur();
            }
        });
        this.mmA.setOnClickListener(this.mmw);
        this.mmv.setOnClickListener(this.mmw);
    }

    private void duh() {
        this.mmn.setDefaultSelectorColorResourceId(R.color.CAM_X0105);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.leftMargin = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4);
        this.mmn.setContainerLayoutParams(layoutParams);
        this.mmn.setRectPaintColor(R.color.CAM_X0302);
        this.mmn.a(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10), l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds46), true, true);
        this.mmn.setIndicatorOffset(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds64));
        this.mmn.setIndicatorOvershot(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds8));
        this.mmn.setIndicatorMarginBottom(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds0));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds170), -1);
        layoutParams2.gravity = 16;
        this.mmn.setExpandedTabLayoutParams(layoutParams2);
    }

    public void wm(boolean z) {
        if (this.abf != null) {
            this.abf.setExpanded(z);
        }
    }

    private void dui() {
        this.mbO = this.rootView.findViewById(R.id.video_view_comment_top_line);
        this.mbP = this.rootView.findViewById(R.id.pb_editor_tool_comment);
        this.mbZ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds120);
        this.mca = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds242);
        this.mbR = (HeadImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_user_image);
        this.mbR.setVisibility(0);
        this.mbR.setIsRound(true);
        this.mbR.setBorderWidth(l.getDimens(getContext(), R.dimen.L_X01));
        this.mbR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        this.mbR.setPlaceHolder(0);
        dqH();
        this.krw = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_reply_text);
        this.mbQ = (LinearLayout) this.rootView.findViewById(R.id.pb_editer_tool_comment_layout);
        this.mbQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.36
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tbadk.core.util.h.a(new com.baidu.tbadk.core.data.ar(VideoPbFragment.this.getActivity(), "pb_huitie"))) {
                    VideoPbFragment.this.wm(false);
                    VideoPbFragment.this.dnH();
                    if (VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().dlp() != null && VideoPbFragment.this.dmG().getPbData().dlp().bnS() != null) {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13701").dR("tid", VideoPbFragment.this.dmG().doK()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).v("uid", TbadkCoreApplication.getCurrentAccountId()));
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13402").dR("tid", VideoPbFragment.this.dmG().doJ()).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).aq("obj_locate", 1).dR("uid", VideoPbFragment.this.dmG().getPbData().dlp().bnS().getUserId()));
                    }
                }
            }
        });
        this.mbS = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_comment_icon);
        this.mbS.setOnClickListener(this.aFH);
        boolean booleanExtra = getBaseFragmentActivity().getIntent().getBooleanExtra("key_is_from_dynamic", false);
        this.mbT = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_collection);
        this.mbT.setOnClickListener(this.aFH);
        if (booleanExtra) {
            this.mbT.setVisibility(8);
        } else {
            this.mbT.setVisibility(0);
        }
        this.mbU = (ImageView) this.rootView.findViewById(R.id.pb_editor_tool_share);
        this.mbU.setOnClickListener(this.aFH);
        this.mbV = new com.baidu.tieba.pb.view.d(this.mbU);
        this.mbV.dvN();
        this.mbW = (TextView) this.rootView.findViewById(R.id.pb_editor_tool_comment_red_dot);
        this.mbW.setVisibility(0);
        vK(false);
    }

    public void wn(boolean z) {
        DetailInfoAndReplyFragment duy = duy();
        if (duy != null && duy.dvf() != null && duy.dvf().dvb() != null && duy.dvf().dva() != null) {
            duy.dvf().dvb().uT(z);
            duy.dvf().dva().vS(z);
        }
        if (this.lSi != null) {
            this.lSi.setVisibility(z ? 0 : 8);
        }
    }

    private void dqH() {
        if (this.mbR != null && TbadkCoreApplication.getCurrentAccountInfo() != null) {
            this.mbR.setImageResource(0);
            this.mbR.startLoad(TbadkCoreApplication.getCurrentAccountInfo().getAvatar(), 12, false);
            return;
        }
        this.mbR.setImageResource(R.drawable.transparent_bg);
    }

    private void bEP() {
        this.mNavigationBar = (NavigationBar) this.rootView.findViewById(R.id.video_pb_navigation_bar);
        this.mNavigationBar.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.37
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.cDi();
            }
        });
        this.mNavigationBar.hideBottomLine();
        this.mNavigationBar.getTopCoverBgView().setBackgroundResource(R.drawable.bg_pb_header_gradient_top);
        this.mNavigationBar.getTopCoverBgView().setVisibility(0);
        this.mStatusBar = this.rootView.findViewById(R.id.statebar);
        this.mmu = this.rootView.findViewById(R.id.status_bar_background);
        if (this.mmL) {
            ViewGroup.LayoutParams layoutParams = this.mStatusBar.getLayoutParams();
            layoutParams.height = l.getStatusBarHeight(doq());
            this.mStatusBar.setLayoutParams(layoutParams);
            this.mStatusBar.setVisibility(0);
        } else {
            ViewGroup.LayoutParams layoutParams2 = this.mmu.getLayoutParams();
            layoutParams2.height = l.getStatusBarHeight(doq());
            this.mmu.setLayoutParams(layoutParams2);
            this.mmu.setVisibility(0);
        }
        this.fNw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.aFH);
        this.gZZ = (ImageView) this.fNw.findViewById(R.id.widget_navi_back_button);
        SvgManager.bsU().a(this.gZZ, R.drawable.ic_icon_pure_topbar_return40_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jyL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.nb_item_floor_more, this.aFH);
        this.aiV = (ImageView) this.jyL.findViewById(R.id.navigationBarBtnMore);
        int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds132);
        int dimens2 = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(dimens, dimens);
        layoutParams3.rightMargin = dimens2;
        this.jyL.setLayoutParams(layoutParams3);
        SvgManager.bsU().a(this.aiV, R.drawable.icon_pure_topbar_more44_svg, R.color.white_alpha100, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.jyL.setVisibility(TbadkCoreApplication.isLogin() ? 0 : 8);
        this.mGestureDetector = new GestureDetector(getContext(), this.juw);
        this.mNavigationBar.setOnTouchListener(this.mmN);
    }

    public void duj() {
        setEditorTools(this.lUg.bBk());
    }

    private void bWA() {
        this.lTf = new PbFakeFloorModel(getPageContext());
        this.mcx = new r(getPageContext(), this.lTf, this.rootView);
        this.mcx.W(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.38
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dqB();
            }
        });
        this.mcx.a(this.lUU);
        this.lTf.a(new PbFakeFloorModel.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.39
            @Override // com.baidu.tieba.pb.pb.main.view.PbFakeFloorModel.a
            public void s(PostData postData) {
                VideoPbFragment.this.lTf.u(postData);
                if (com.baidu.tbadk.a.d.bjc() || VideoPbFragment.this.duy() != null) {
                    VideoPbFragment.this.duy().dvh();
                } else if (VideoPbFragment.this.duw() != null) {
                    VideoPbFragment.this.duw().dvh();
                }
                VideoPbFragment.this.mcx.dnq();
                VideoPbFragment.this.ael.bzG();
                VideoPbFragment.this.vK(false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PostData postData, PostData postData2, boolean z, boolean z2) {
        PbActivity.a PD;
        PostData L;
        String doJ = dmG().doJ();
        String id = postData.getId();
        String str = "";
        if (postData2 != null) {
            str = postData2.getId();
        }
        int i = 0;
        if (dmG().getPbData() != null) {
            i = dmG().getPbData().dlE();
        }
        if (duw() != null && duw().dvj() != null) {
            PD = duw().dvj().PD(id);
        } else if (duy() != null && duy().dvj() != null) {
            PD = duy().dvj().PD(id);
        } else {
            return;
        }
        if (postData != null && dmG() != null && dmG().getPbData() != null && PD != null) {
            SubPbActivityConfig addBigImageData = new SubPbActivityConfig(getPageContext().getPageActivity()).createSubPbActivityConfig(doJ, id, "pb", true, null, false, str, i, postData.dtB(), dmG().getPbData().getAnti(), false, postData.bnS().getIconInfo()).addBigImageData(PD.lPM, PD.eLn, PD.eLl, PD.index);
            if (z2) {
                addBigImageData.setHighLightPostId(str);
                addBigImageData.setKeyIsUseSpid(true);
            }
            addBigImageData.setKeyFromForumId(dmG().getForumId());
            addBigImageData.setBjhData(dmG().doT());
            addBigImageData.setKeyPageStartFrom(dmG().dpu());
            addBigImageData.setFromFrsForumId(dmG().getFromForumId());
            addBigImageData.setIsOpenEditor(z);
            if (dmG().getPbData().dlY() != null) {
                addBigImageData.setHasForumRule(dmG().getPbData().dlY().has_forum_rule.intValue());
            }
            if (dmG().getPbData().getUserData() != null) {
                addBigImageData.setIsManager(dmG().getPbData().getUserData().getIs_manager());
            }
            if (dmG().getPbData().getForum().getDeletedReasonInfo() != null) {
                addBigImageData.setDeletedReasonInfoIsGrayCaleForum(dmG().getPbData().getForum().getDeletedReasonInfo().is_grays_cale_forum.intValue());
                addBigImageData.setDeletedReasonInfoIsIsBoomGrow(dmG().getPbData().getForum().getDeletedReasonInfo().is_boomgrow.intValue());
            }
            if (dmG().getPbData().getForum() != null) {
                addBigImageData.setForumHeadUrl(dmG().getPbData().getForum().getImage_url());
                addBigImageData.setUserLevel(dmG().getPbData().getForum().getUser_level());
            }
            if (dmG() != null && (L = L(dmG().getPbData())) != null) {
                addBigImageData.setMainPostMaskVisibly(L.nzP || postData.nzP);
            }
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, addBigImageData));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.lTk = (PbActivity) context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (dmG() != null) {
            dmG().aD(bundle);
        }
        if (getPageContext() != null && getPageContext().getPageActivity() != null) {
            getVoiceManager().onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getVoiceManager().onStart(getPageContext());
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.isPaused = true;
        getVoiceManager().onPause(getPageContext());
        this.mms.sp(true);
        if (dmG() != null && !dmG().doR()) {
            this.lUg.Db(dmG().doJ());
        }
        com.baidu.tbadk.BdToken.c.bhp().bhA();
        MessageManager.getInstance().unRegisterListener(this.lUN);
        MessageManager.getInstance().unRegisterListener(this.lUO);
        MessageManager.getInstance().unRegisterListener(this.lUP);
        MessageManager.getInstance().unRegisterListener(this.jwA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.isPaused = false;
        getVoiceManager().onResume(getPageContext());
        this.mms.sp(false);
        dom();
        registerListener(this.lUN);
        registerListener(this.lUO);
        registerListener(this.lUP);
        registerListener(this.jwA);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.mmo != null && this.faC != null) {
            this.mmo.GA(z ? this.faC.getCurrentItem() : -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onUserChanged(boolean z) {
        super.onUserChanged(z);
        dqH();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        getVoiceManager().onStop(getPageContext());
        com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.s.c.dMH().C(getUniqueId());
        getVoiceManager().onDestory(getPageContext());
        if (this.mbV != null) {
            this.mbV.onDestroy();
        }
        if (this.gfY != null) {
            this.gfY.cancelLoadData();
        }
        if (this.mms != null) {
            this.mms.onDestroy();
        }
        if (this.lTD != null) {
            this.lTD.cancelLoadData();
        }
        if (this.kUB != null) {
            this.kUB.onDestroy();
        }
        if (dmG() != null) {
            dmG().cancelLoadData();
            dmG().destory();
            if (dmG().dpo() != null) {
                dmG().dpo().onDestroy();
            }
        }
        if (this.lUg != null) {
            this.lUg.onDestroy();
        }
        this.lUn = null;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        UtilHelper.changeStatusBarIconAndTextColor(true, this.lTk);
        getBaseFragmentActivity().getLayoutMode().setNightMode(i == 1);
        getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        ap.setBackgroundColor(this.mStatusBar, R.color.CAM_X0611);
        ap.setBackgroundColor(this.mmu, R.color.CAM_X0608);
        ap.setBackgroundColor(this.mmn, R.color.CAM_X0207);
        if (this.mmn != null) {
            this.mmn.onChangeSkinType();
        }
        if (this.kYE != null) {
            this.kYE.onChangeSkinType();
        }
        if (this.mmt == null || !this.mmt.isPlaying()) {
            ap.setBackgroundColor(this.rootView, R.color.CAM_X0201);
        }
        if (this.ael != null) {
            this.ael.onChangeSkinType(i);
        }
        if (this.mcx != null) {
            this.mcx.onChangeSkinType(i);
        }
        if (this.mbR != null) {
            this.mbR.setBorderColor(ap.getColor(R.color.CAM_X0401));
        }
        if (this.mbQ != null) {
            this.mbQ.setBackgroundDrawable(ap.aL(l.getDimens(getContext(), R.dimen.tbds47), ap.getColor(R.color.CAM_X0209)));
        }
        if (dmG() != null && dmG().bkb()) {
            WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else {
            WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
        WebPManager.a(this.mbS, R.drawable.icon_pure_pb_bottom_comment26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        SvgManager.bsU().a(this.mmz, R.drawable.icon_pure_close16_n_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        if (dmG() != null) {
            x(dmG().getPbData());
        }
        ap.setBackgroundResource(this.mmp, R.drawable.personalize_tab_shadow);
        ap.setBackgroundColor(this.mmv, R.color.CAM_X0206);
        ap.setBackgroundColor(this.mbP, R.color.CAM_X0207);
        ap.setBackgroundColor(this.mbO, R.color.CAM_X0203);
        ap.setViewTextColor(this.mmy, R.color.CAM_X0109);
        ap.setViewTextColor(this.mmx, R.color.CAM_X0105);
        ap.setViewTextColor(this.krw, R.color.CAM_X0109);
        ap.setViewTextColor(this.mbX, R.color.CAM_X0105);
        ap.setViewTextColor(this.mbW, R.color.CAM_X0107);
        ap.d(this.mbW, l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds18), R.color.CAM_X0207, R.color.CAM_X0207);
        if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
            duy().onChangeSkinType(i);
        } else if (duw() != null) {
            duw().onChangeSkinType(i);
        }
        if (dux() != null) {
            dux().onChangeSkinType(i);
        }
        if (this.mmC != null) {
            this.mmC.setBackgroundDrawable(ap.aL(l.getDimens(this.mmC.getContext(), R.dimen.tbds32), ap.getColor(R.color.CAM_X0309)));
        }
        cDh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jie == null) {
            this.jie = VoiceManager.instance();
        }
        return this.jie;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDh() {
        if (this.jie != null) {
            this.jie.stopPlay();
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbFragment doo() {
        return null;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public VideoPbFragment dop() {
        return this;
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel dmG() {
        return this.lTk.dmG();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbActivity doq() {
        return this.lTk;
    }

    public com.baidu.tbadk.baseEditMark.a duk() {
        return this.lTS;
    }

    public View.OnClickListener dul() {
        return this.aFH;
    }

    public View.OnClickListener dum() {
        return this.lQu;
    }

    public View.OnLongClickListener dun() {
        return this.mOnLongClickListener;
    }

    @Override // com.baidu.tbadk.widget.richText.TbRichTextView.c
    public void a(SpannableStringBuilder spannableStringBuilder, TextView textView, TbRichTextView tbRichTextView) {
        Drawable drawable;
        if (spannableStringBuilder != null && textView != null && tbRichTextView != null && !spannableStringBuilder.toString().contains("#4%2&@#907$12#@96476)w7we9e~@$%&&")) {
            Object[] objArr = (com.baidu.tbadk.widget.richText.f[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), com.baidu.tbadk.widget.richText.f.class);
            for (int i = 0; i < objArr.length; i++) {
                if (com.baidu.tieba.pb.pb.main.au.PS(objArr[i].getLink()) && (drawable = ap.getDrawable(R.drawable.icon_pb_wenxue)) != null) {
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

    public BdTypeRecyclerView cGb() {
        Iterator<BaseFragment> it = this.mmo.duG().iterator();
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

    private void uY(boolean z) {
        this.lUg.kV(z);
        this.lUg.kW(z);
        this.lUg.kX(z);
    }

    public void b(boolean z, PostWriteCallBackData postWriteCallBackData) {
        hideProgressBar();
        if (this.mmF != null) {
            if (z) {
                this.mmF.drt();
            } else if (postWriteCallBackData != null && postWriteCallBackData.isSensitiveError()) {
                this.mmF.dru();
            } else {
                this.mmF.drt();
            }
        }
    }

    public boolean FL(int i) {
        if (this.kUB == null || dmG() == null || dmG().getPbData() == null || dmG().getPbData().getAnti() == null) {
            return true;
        }
        return this.kUB.aK(dmG().getPbData().getAnti().replyPrivateFlag, i);
    }

    public boolean dnJ() {
        if ((dmG() != null && dmG().getPbData().dlS()) || this.kUB == null || dmG() == null || dmG().getPbData() == null || dmG().getPbData().getAnti() == null) {
            return true;
        }
        return this.kUB.oy(dmG().getPbData().getAnti().replyPrivateFlag);
    }

    private void d(g gVar) {
        if (gVar != null && dmG() != null) {
            gVar.setForumName(dmG().dmz());
            if (dmG().getPbData() != null && dmG().getPbData().getForum() != null) {
                gVar.a(dmG().getPbData().getForum());
            }
            gVar.setFrom("pb");
            gVar.a(dmG());
        }
    }

    public void dqS() {
        if (this.ael != null) {
            this.ael.display();
            if (this.lUg != null) {
                this.lUg.bBV();
            }
            drC();
        }
    }

    public com.baidu.tbadk.editortools.pb.e dnw() {
        return this.lUg;
    }

    private boolean dnG() {
        PbModel dmG = dmG();
        if (dmG == null || dmG.getPbData() == null) {
            return false;
        }
        cb dlp = dmG.getPbData().dlp();
        dmG.getPbData().getAnti();
        return AntiHelper.b(getPageContext(), dlp);
    }

    public void dnH() {
        if (checkUpIsLogin() && dmG() != null && dmG().getPbData() != null && dmG().getPbData().getForum() != null && !dnG()) {
            if (dmG().getPbData().dlS()) {
                cSA();
                return;
            }
            if (this.jmA == null) {
                this.jmA = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.jmA.Af(0);
                this.jmA.a(new c.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.42
                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qM(boolean z) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void B(boolean z, int i) {
                    }

                    @Override // com.baidu.tieba.frs.profession.permission.c.a
                    public void qN(boolean z) {
                        if (z) {
                            if (VideoPbFragment.this.lUg != null && VideoPbFragment.this.lUg.bBk() != null) {
                                VideoPbFragment.this.lUg.bBk().b(new com.baidu.tbadk.editortools.a(45, 27, null));
                            }
                            VideoPbFragment.this.cSA();
                        }
                    }
                });
            }
            this.jmA.G(dmG().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dmG().doJ(), 0L));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        EmotionImageData emotionImageData;
        super.onActivityResult(i, i2, intent);
        this.lUg.onActivityResult(i, i2, intent);
        if (this.lTD != null) {
            this.lTD.onActivityResult(i, i2, intent);
        }
        if (this.mcx != null) {
            this.mcx.onActivityResult(i, i2, intent);
        }
        if (i == 25035) {
            d(i2, intent);
        }
        if (i2 == -1) {
            switch (i) {
                case RequestResponseCode.REQUEST_LOGIN_PB_MARK /* 11009 */:
                    dnT();
                    return;
                case RequestResponseCode.REQUEST_TRANSMIT_POST_EDIT /* 13011 */:
                    com.baidu.tieba.o.a.dDg().I(getPageContext());
                    return;
                case RequestResponseCode.REQUEST_TO_SHARE /* 24007 */:
                case RequestResponseCode.REQUEST_PB_TO_PUSH_THREAD /* 24008 */:
                case RequestResponseCode.REQUEST_PB_SEARCH_EMOTION /* 25016 */:
                case RequestResponseCode.REQUEST_EMOTION_EDIT /* 25023 */:
                    Serializable serializableExtra = intent.getSerializableExtra("emotion_data");
                    if (serializableExtra != null && (serializableExtra instanceof EmotionImageData) && (emotionImageData = (EmotionImageData) serializableExtra) != null) {
                        this.lUj = emotionImageData;
                        if (FL(am.fcb)) {
                            c(emotionImageData);
                            return;
                        }
                        return;
                    }
                    return;
                case RequestResponseCode.REQUEST_SHOW_LONG_PRESS_EMOTION_TIPS /* 25033 */:
                default:
                    return;
                case 25055:
                    if (this.lTF != null) {
                        this.lTF.performClick();
                        return;
                    }
                    return;
                case 25056:
                    if (this.lTG != null) {
                        this.lTG.performClick();
                        return;
                    }
                    return;
                case 25057:
                    if (drS() != null) {
                        drS().performClick();
                        return;
                    }
                    return;
                case 25058:
                    if (this.lTH != null) {
                        this.lTH.performClick();
                        return;
                    }
                    return;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (doq() != null) {
            if (this.mmM && !TbSingleton.getInstance().isNotchScreen(doq()) && !TbSingleton.getInstance().isCutoutScreen(doq())) {
                duB();
                UtilHelper.hideStatusBar(doq(), doq().getRootView());
                this.mmM = false;
            }
            this.mmG.mnb = z;
            duo();
            dup();
        }
    }

    private void d(int i, Intent intent) {
        PbActivity pbActivity = this.lTk;
        if (i == 0) {
            dqx();
            if (this.mcx != null) {
                this.mcx.dnq();
            }
            vK(false);
        }
        dqB();
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
                        this.lUg.resetData();
                        this.lUg.setVoiceModel(pbEditorData.getVoiceModel());
                        this.lUg.c(writeData);
                        m qV = this.lUg.bBk().qV(6);
                        if (qV != null && qV.fCN != null) {
                            qV.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                        }
                        PbActivity pbActivity2 = this.lTk;
                        if (i == -1) {
                            this.lUg.a((String) null, (WriteData) null);
                            return;
                        }
                        return;
                    case 1:
                        if (this.mcx != null && this.mcx.dnv() != null) {
                            com.baidu.tbadk.editortools.pb.h dnv = this.mcx.dnv();
                            dnv.setThreadData(dmG().getPbData().dlp());
                            dnv.c(writeData);
                            dnv.setVoiceModel(pbEditorData.getVoiceModel());
                            m qV2 = dnv.bBk().qV(6);
                            if (qV2 != null && qV2.fCN != null) {
                                qV2.fCN.a(new com.baidu.tbadk.editortools.a(52, 0, pbEditorData.getVoiceModel()));
                            }
                            PbActivity pbActivity3 = this.lTk;
                            if (i == -1) {
                                dnv.bCp();
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
                if (dmG() != null && !dmG().doR()) {
                    antiData.setBlock_forum_name(dmG().getPbData().getForum().getName());
                    antiData.setBlock_forum_id(dmG().getPbData().getForum().getId());
                    antiData.setUser_name(dmG().getPbData().getUserData().getUserName());
                    antiData.setUser_id(dmG().getPbData().getUserData().getUserId());
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
                com.baidu.tieba.tbadkCore.writeModel.g.j(getPageContext().getPageActivity(), errorString, preMsg, colorMsg);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, AntiData antiData, String str) {
        if (AntiHelper.bX(i, str)) {
            if (AntiHelper.a(getPageContext().getPageActivity(), str, i, new AntiHelper.a() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.43
                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onPositiveButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY));
                }

                @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.a
                public void onNavigationButtonClick(com.baidu.tbadk.core.dialog.a aVar) {
                    TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).aq("obj_locate", ay.a.LOCATE_REPLY));
                }
            }) != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).aq("obj_locate", ay.a.LOCATE_REPLY));
            }
        } else if (i == 230277) {
            if (this.mmF != null) {
                this.mmF.Dh(str);
            }
        } else {
            showToast(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v9, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.pb.pb.main.PbActivity */
    /* JADX WARN: Multi-variable type inference failed */
    private void dos() {
        if (dmG() != null && this.lTk != null) {
            if (this.lUg == null || !this.lUg.isBJH) {
                com.baidu.tbadk.editortools.pb.d dVar = new com.baidu.tbadk.editortools.pb.d();
                d(dVar);
                this.lUg = (com.baidu.tbadk.editortools.pb.e) dVar.ff(getContext());
                this.lUg.a(this.lTk.getPageContext());
                this.lUg.a(this.fFv);
                this.lUg.a(this.fFn);
                this.lUg.a(this.lTk.getPageContext(), this.lTk.getIntent() == null ? null : this.lTk.getIntent().getExtras());
                this.lUg.bBk().kN(true);
                setEditorTools(this.lUg.bBk());
                if (!dmG().doR()) {
                    this.lUg.Dc(dmG().doJ());
                }
                if (dmG().dps()) {
                    this.lUg.Da(getPageContext().getString(R.string.pb_reply_hint_from_smart_frs));
                } else {
                    this.lUg.Da(dqD());
                }
            }
        }
    }

    public void setEditorTools(EditorTools editorTools) {
        this.ael = editorTools;
        this.ael.setId(R.id.pb_editor);
        this.ael.setOnCancelClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.44
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPbFragment.this.dqB();
            }
        });
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        if (this.ael.getParent() == null) {
            this.rootView.addView(this.ael, layoutParams);
        }
        this.ael.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        this.ael.setActionListener(24, new com.baidu.tbadk.editortools.b() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.46
            @Override // com.baidu.tbadk.editortools.b
            public void a(com.baidu.tbadk.editortools.a aVar) {
                if (aVar.data instanceof u) {
                    if (((u) aVar.data).bwy() == EmotionGroupType.BIG_EMOTION || ((u) aVar.data).bwy() == EmotionGroupType.USER_COLLECT) {
                        if (VideoPbFragment.this.mPermissionJudgePolicy == null) {
                            VideoPbFragment.this.mPermissionJudgePolicy = new PermissionJudgePolicy();
                        }
                        VideoPbFragment.this.mPermissionJudgePolicy.clearRequestPermissionList();
                        VideoPbFragment.this.mPermissionJudgePolicy.appendRequestPermission(VideoPbFragment.this.getBaseFragmentActivity(), "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!VideoPbFragment.this.mPermissionJudgePolicy.startRequestPermission(VideoPbFragment.this.getBaseFragmentActivity())) {
                            VideoPbFragment.this.lUg.c((u) aVar.data);
                            VideoPbFragment.this.lUg.a(false, (PostWriteCallBackData) null);
                        }
                    }
                }
            }
        });
        dqx();
        this.lUg.a(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.47
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (VideoPbFragment.this.ael != null && VideoPbFragment.this.ael.getVisibility() == 0 && charSequence != null && charSequence.length() >= i + i3 && TextUtils.isEmpty(charSequence.toString().substring(i, i + i3))) {
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (VideoPbFragment.this.kYE != null && VideoPbFragment.this.kYE.drV() != null) {
                    if (!VideoPbFragment.this.kYE.drV().dWG()) {
                        VideoPbFragment.this.kYE.vQ(false);
                    }
                    VideoPbFragment.this.kYE.drV().zt(false);
                }
            }
        });
    }

    public void cSA() {
        if (!checkUpIsLogin()) {
            if (dmG() != null) {
                TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c10517").aq("obj_locate", 2).dR("fid", dmG().getForumId()));
            }
        } else if (dnJ()) {
            if (this.lUg != null && (this.lUg.bCf() || this.lUg.bCg())) {
                this.lUg.a(false, (PostWriteCallBackData) null);
                return;
            }
            if (this.ael != null) {
                dqS();
                this.mmG.mna = false;
                if (this.ael.qV(2) != null) {
                    com.baidu.tieba.tbadkCore.b.a.a(getPageContext(), (View) this.ael.qV(2).fCN, false, null);
                }
            }
            drC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, final String str, final String str2, PostData postData) {
        if (view != null && str != null && str2 != null && !dnG() && dnJ()) {
            if (view.getParent() instanceof View) {
                ((View) view.getParent()).getLocationOnScreen(this.lTI);
                this.lTJ = ((View) view.getParent()).getMeasuredHeight();
            }
            if (this.mcx != null && postData != null) {
                String str3 = "";
                if (postData.dNQ() != null) {
                    str3 = postData.dNQ().toString();
                }
                this.mcx.Px(String.format(TbadkCoreApplication.getInst().getResources().getString(R.string.reply_title), postData.bnS().getName_show(), str3));
            }
            if (dmG() != null && dmG().getPbData() != null && dmG().getPbData().dlS()) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.lTk.getApplicationContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lTI[1] + VideoPbFragment.this.lTJ) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cGb() != null) {
                            VideoPbFragment.this.cGb().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.mcx != null) {
                            VideoPbFragment.this.lUg.bBk().setVisibility(8);
                            VideoPbFragment.this.mcx.j(str, str2, VideoPbFragment.this.dqD(), (VideoPbFragment.this.dmG() == null || VideoPbFragment.this.dmG().getPbData() == null || VideoPbFragment.this.dmG().getPbData().dlp() == null || !VideoPbFragment.this.dmG().getPbData().dlp().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnv = VideoPbFragment.this.mcx.dnv();
                            if (dnv != null && VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                                dnv.a(VideoPbFragment.this.dmG().getPbData().getAnti());
                                dnv.setThreadData(VideoPbFragment.this.dmG().getPbData().dlp());
                            }
                            if (VideoPbFragment.this.kYE.drX() == null && VideoPbFragment.this.mcx.dnv().bCx() != null) {
                                VideoPbFragment.this.mcx.dnv().bCx().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.48.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kYE != null && VideoPbFragment.this.kYE.drW() != null) {
                                            if (!VideoPbFragment.this.kYE.drW().dWG()) {
                                                VideoPbFragment.this.kYE.vR(false);
                                            }
                                            VideoPbFragment.this.kYE.drW().zt(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kYE.g(VideoPbFragment.this.mcx.dnv().bCx().getInputView());
                                VideoPbFragment.this.mcx.dnv().a(VideoPbFragment.this.lUl);
                            }
                        }
                        VideoPbFragment.this.drC();
                    }
                }, 0L);
                return;
            }
            if (this.lUi == null) {
                this.lUi = new com.baidu.tieba.frs.profession.permission.c(getPageContext());
                this.lUi.Af(1);
                this.lUi.a(new AnonymousClass49(str, str2));
            }
            if (dmG() != null && dmG().getPbData() != null && dmG().getPbData().getForum() != null) {
                this.lUi.G(dmG().getPbData().getForum().getId(), com.baidu.adp.lib.f.b.toLong(dmG().doJ(), 0L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.pb.videopb.VideoPbFragment$49  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass49 implements c.a {
        final /* synthetic */ String lVp;
        final /* synthetic */ String lVq;

        AnonymousClass49(String str, String str2) {
            this.lVp = str;
            this.lVq = str2;
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
            if (z) {
                com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int dimens;
                        int equipmentHeight = l.getEquipmentHeight(VideoPbFragment.this.getContext());
                        if (TbadkCoreApplication.getInst().getKeyboardHeight() > 0) {
                            dimens = TbadkCoreApplication.getInst().getKeyboardHeight() + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        } else {
                            dimens = (equipmentHeight / 2) + l.getDimens(VideoPbFragment.this.getPageContext().getPageActivity(), R.dimen.tbds256);
                        }
                        int i = (VideoPbFragment.this.lTI[1] + VideoPbFragment.this.lTJ) - (equipmentHeight - dimens);
                        if (VideoPbFragment.this.cGb() != null) {
                            VideoPbFragment.this.cGb().smoothScrollBy(0, i);
                        }
                        if (VideoPbFragment.this.mcx != null) {
                            VideoPbFragment.this.lUg.bBk().setVisibility(8);
                            VideoPbFragment.this.mcx.j(AnonymousClass49.this.lVp, AnonymousClass49.this.lVq, VideoPbFragment.this.dqD(), (VideoPbFragment.this.dmG() == null || VideoPbFragment.this.dmG().getPbData() == null || VideoPbFragment.this.dmG().getPbData().dlp() == null || !VideoPbFragment.this.dmG().getPbData().dlp().isBjh()) ? false : true);
                            com.baidu.tbadk.editortools.pb.h dnv = VideoPbFragment.this.mcx.dnv();
                            if (dnv != null && VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null) {
                                dnv.a(VideoPbFragment.this.dmG().getPbData().getAnti());
                                dnv.setThreadData(VideoPbFragment.this.dmG().getPbData().dlp());
                            }
                            if (VideoPbFragment.this.kYE.drX() == null && VideoPbFragment.this.mcx.dnv().bCx() != null) {
                                VideoPbFragment.this.mcx.dnv().bCx().b(new TextWatcher() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.49.1.1
                                    @Override // android.text.TextWatcher
                                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                                    }

                                    @Override // android.text.TextWatcher
                                    public void afterTextChanged(Editable editable) {
                                        if (VideoPbFragment.this.kYE != null && VideoPbFragment.this.kYE.drW() != null) {
                                            if (!VideoPbFragment.this.kYE.drW().dWG()) {
                                                VideoPbFragment.this.kYE.vR(false);
                                            }
                                            VideoPbFragment.this.kYE.drW().zt(false);
                                        }
                                    }
                                });
                                VideoPbFragment.this.kYE.g(VideoPbFragment.this.mcx.dnv().bCx().getInputView());
                                VideoPbFragment.this.mcx.dnv().a(VideoPbFragment.this.lUl);
                            }
                        }
                        VideoPbFragment.this.drC();
                    }
                }, 0L);
            }
        }
    }

    public SparseArray<Object> b(com.baidu.tieba.pb.data.f fVar, boolean z, int i) {
        PostData L;
        ad adVar;
        StringBuilder sb = null;
        if (fVar != null && (L = L(fVar)) != null) {
            String userId = L.bnS().getUserId();
            boolean z2 = userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount());
            SparseArray<Object> sparseArray = new SparseArray<>();
            if (i == 0) {
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlE()));
                sparseArray.put(R.id.tag_should_manage_visible, false);
            } else if (i == 1) {
                if (L.bnS() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, L.bnS().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, L.bnS().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, L.bnS().getPortrait());
                    sparseArray.put(R.id.tag_forbid_user_post_id, L.getId());
                }
                sparseArray.put(R.id.tag_del_post_id, L.getId());
                sparseArray.put(R.id.tag_del_post_type, 0);
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z2));
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(fVar.dlE()));
                sparseArray.put(R.id.tag_should_manage_visible, true);
            }
            if (!z2) {
                List<bx> dlM = fVar.dlM();
                if (y.getCount(dlM) > 0) {
                    sb = new StringBuilder();
                    for (bx bxVar : dlM) {
                        if (bxVar != null && !StringUtils.isNull(bxVar.getForumName()) && (adVar = bxVar.eRn) != null && adVar.eOX && !adVar.eOY && (adVar.type == 1 || adVar.type == 2)) {
                            sb.append(com.baidu.adp.lib.util.k.cutString(bxVar.getForumName(), 12)).append(TbadkCoreApplication.getInst().getString(R.string.forum)).append("、");
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
    public void dnT() {
        MarkData FY;
        if (dmG() != null && dmG().getPbData() != null) {
            if (com.baidu.tbadk.a.d.bjc() || duw() != null) {
                if ((!com.baidu.tbadk.a.d.bjc() || duy() != null) && this.lTS != null) {
                    if (dmG().getPbData() != null && dmG().getPbData().dlS()) {
                        FY = dmG().FY(0);
                    } else if (this.faC != null && this.faC.getCurrentItem() == mmj) {
                        FY = dmG().o(L(dmG().getPbData()));
                    } else if (com.baidu.tbadk.a.d.bjc()) {
                        FY = dmG().FY(duy().drf());
                    } else {
                        FY = dmG().FY(duw().drf());
                    }
                    if (FY != null) {
                        if (!FY.isApp() || (FY = dmG().FY(duw().drf() + 1)) != null) {
                            dra();
                            this.lTS.a(FY);
                            if (!this.lTS.bkb()) {
                                this.lTS.bkd();
                                TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_collect", "pbclick", 1, new Object[0]);
                                return;
                            }
                            this.lTS.bkc();
                            TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_cancel_collect", "pbclick", 1, new Object[0]);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean FN(int i) {
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
            if (this.lTD == null) {
                this.lTD = new com.baidu.tieba.pb.pb.main.emotion.model.a(this.lTk);
                this.lTD.b(this.fFn);
                this.lTD.c(this.fFv);
            }
            this.lTD.a(emotionImageData, dmG(), dmG().getPbData());
        }
    }

    public PostData L(com.baidu.tieba.pb.data.f fVar) {
        PostData postData;
        if (fVar == null) {
            return null;
        }
        if (fVar.dlC() != null) {
            return fVar.dlC();
        }
        if (!y.isEmpty(fVar.dlr())) {
            Iterator<PostData> it = fVar.dlr().iterator();
            while (it.hasNext()) {
                postData = it.next();
                if (postData != null && postData.dNO() == 1) {
                    break;
                }
            }
        }
        postData = null;
        if (postData == null) {
            postData = fVar.dly();
        }
        if (postData == null) {
            postData = a(fVar);
        }
        if (postData != null && postData.bnS() != null && postData.bnS().getUserTbVipInfoData() != null && postData.bnS().getUserTbVipInfoData().getvipIntro() != null) {
            postData.bnS().getGodUserData().setIntro(postData.bnS().getUserTbVipInfoData().getvipIntro());
            return postData;
        }
        return postData;
    }

    private PostData a(com.baidu.tieba.pb.data.f fVar) {
        MetaData metaData;
        if (fVar == null || fVar.dlp() == null || fVar.dlp().bnS() == null) {
            return null;
        }
        PostData postData = new PostData();
        MetaData bnS = fVar.dlp().bnS();
        String userId = bnS.getUserId();
        HashMap<String, MetaData> userMap = fVar.dlp().getUserMap();
        if (userMap == null || (metaData = userMap.get(userId)) == null || metaData.getUserId() == null) {
            metaData = bnS;
        }
        postData.JJ(1);
        postData.setId(fVar.dlp().boi());
        postData.setTitle(fVar.dlp().getTitle());
        postData.setTime(fVar.dlp().getCreateTime());
        postData.a(metaData);
        return postData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dnY() {
        ArrayList<PostData> dlr;
        int count;
        int i;
        if (dmG() == null || dmG().getPbData() == null || dmG().getPbData().dlr() == null || (count = y.getCount((dlr = dmG().getPbData().dlr()))) == 0) {
            return "";
        }
        if (dmG().dpc()) {
            Iterator<PostData> it = dlr.iterator();
            while (it.hasNext()) {
                PostData next = it.next();
                if (next != null && next.dNO() == 1) {
                    return next.getId();
                }
            }
        }
        if (cGb() == null) {
            i = 0;
        } else if (com.baidu.tbadk.a.d.bjc()) {
            i = duy().dre();
        } else {
            i = duw().dre();
        }
        PostData postData = (PostData) y.getItem(dlr, i);
        if (postData == null || postData.bnS() == null) {
            return "";
        }
        if (dmG().PG(postData.bnS().getUserId())) {
            return postData.getId();
        }
        for (int i2 = i - 1; i2 != 0; i2--) {
            PostData postData2 = (PostData) y.getItem(dlr, i2);
            if (postData2 == null || postData2.bnS() == null || postData2.bnS().getUserId() == null) {
                break;
            } else if (dmG().PG(postData2.bnS().getUserId())) {
                return postData2.getId();
            }
        }
        for (int i3 = i + 1; i3 < count; i3++) {
            PostData postData3 = (PostData) y.getItem(dlr, i3);
            if (postData3 == null || postData3.bnS() == null || postData3.bnS().getUserId() == null) {
                return "";
            }
            if (dmG().PG(postData3.bnS().getUserId())) {
                return postData3.getId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnU() {
        if (dmG() != null) {
            com.baidu.tieba.pb.data.f pbData = dmG().getPbData();
            dmG().vo(true);
            if (this.lTS != null) {
                pbData.Pr(this.lTS.bka());
            }
            if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
                duy().dvh();
            } else if (duw() != null) {
                duw().dvh();
            }
        }
    }

    public void a(boolean z, MarkData markData) {
        if (dmG() != null) {
            drc();
            dmG().vo(z);
            if (this.lTS != null) {
                this.lTS.ja(z);
                if (markData != null) {
                    this.lTS.a(markData);
                }
            }
            if (dmG().bkb()) {
                dnU();
            } else if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
                duy().dvh();
            } else if (duw() != null) {
                duw().dvh();
            }
        }
    }

    public void b(q qVar) {
        boolean z;
        MetaData metaData;
        if (dmG() != null && dmG().getPbData() != null && qVar.dmh() != null) {
            String id = qVar.dmh().getId();
            ArrayList<PostData> dlr = dmG().getPbData().dlr();
            int i = 0;
            while (true) {
                if (i >= dlr.size()) {
                    z = true;
                    break;
                }
                PostData postData = dlr.get(i);
                if (postData.getId() == null || !postData.getId().equals(id)) {
                    i++;
                } else {
                    ArrayList<PostData> dmq = qVar.dmq();
                    postData.JI(qVar.getTotalCount());
                    if (postData.dNL() == null || dmq == null) {
                        z = true;
                    } else {
                        Iterator<PostData> it = dmq.iterator();
                        while (it.hasNext()) {
                            PostData next = it.next();
                            if (postData.getUserMap() != null && next != null && next.bnS() != null && (metaData = postData.getUserMap().get(next.bnS().getUserId())) != null) {
                                next.a(metaData);
                                next.yv(true);
                                next.a(getPageContext(), dmG().PG(metaData.getUserId()));
                            }
                        }
                        z = dmq.size() != postData.dNL().size();
                        if (postData.dNL() != null && postData.dNL().size() < 2) {
                            postData.dNL().clear();
                            postData.dNL().addAll(dmq);
                        }
                    }
                    if (postData.dNH() != null) {
                        postData.dNI();
                    }
                }
            }
            if (!dmG().getIsFromMark() && z) {
                if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
                    duy().dvh();
                } else if (duw() != null) {
                    duw().dvh();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dnL() {
        if (dmG() != null && TbadkCoreApplication.isLogin() && AddExperiencedModel.SG(dmG().getForumId()) && dmG().getPbData() != null && dmG().getPbData().getForum() != null) {
            if (dmG().getPbData().getForum().isLike() == 1) {
                dmG().dpq().gr(dmG().getForumId(), dmG().doJ());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null) {
            cb dlp = fVar.dlp();
            if (dlp != null && dlp.bmB()) {
                dos();
            } else {
                d(this.lUf);
            }
            if (this.lUg != null) {
                vI(this.lUg.bBY());
                this.lUg.a(fVar.getAnti());
                this.lUg.a(fVar.getForum(), fVar.getUserData());
                this.lUg.setThreadData(dlp);
                if (dmG() != null) {
                    this.lUg.a(dmG().dpa(), dmG().doJ(), dmG().dpr());
                }
                if (dlp != null) {
                    this.lUg.kY(dlp.bpr());
                }
            }
        }
    }

    public void dqB() {
        reset();
        dqx();
        this.mcx.dnq();
        vK(false);
    }

    private void reset() {
        if (this.lUg != null && this.ael != null) {
            com.baidu.tbadk.editortools.pb.a.bBN().setStatus(0);
            this.lUg.bCi();
            this.lUg.bBx();
            if (this.lUg.getWriteImagesInfo() != null) {
                this.lUg.getWriteImagesInfo().setMaxImagesAllowed(this.lUg.isBJH ? 1 : 9);
            }
            this.lUg.rf(SendView.ALL);
            this.lUg.rg(SendView.ALL);
            com.baidu.tbadk.editortools.h qS = this.ael.qS(23);
            com.baidu.tbadk.editortools.h qS2 = this.ael.qS(2);
            com.baidu.tbadk.editortools.h qS3 = this.ael.qS(5);
            if (qS2 != null) {
                qS2.display();
            }
            if (qS3 != null) {
                qS3.display();
            }
            if (qS != null) {
                qS.hide();
            }
            this.ael.invalidate();
        }
    }

    public void u(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            x(fVar);
            this.mbT.setVisibility(fVar.dlS() ? 8 : 0);
            if (fVar.bkb()) {
                WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collected26_selection, R.color.CAM_X0305, WebPManager.ResourceStateType.NORMAL_PRESS);
            } else {
                WebPManager.a(this.mbT, R.drawable.icon_pure_pb_bottom_collect26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
            }
            String Gg = Gg(fVar.dlp().bnJ());
            if (this.mbW != null) {
                this.mbW.setText(Gg);
            }
            if (this.mbX != null) {
                this.mbX.setText(Gg);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921416, fVar.dlp()));
        }
    }

    public void x(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && AntiHelper.bd(fVar.dlp())) {
            if (this.mbV != null) {
                this.mbV.setEnable(false);
                this.mbV.onDestroy();
            }
            ViewGroup.LayoutParams layoutParams = this.mbU.getLayoutParams();
            layoutParams.height = -2;
            layoutParams.width = -2;
            this.mbU.setLayoutParams(layoutParams);
            WebPManager.a(this.mbU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0110, WebPManager.ResourceStateType.NORMAL_PRESS);
        } else if (this.mbV == null || !this.mbV.isEnable()) {
            ViewGroup.LayoutParams layoutParams2 = this.mbU.getLayoutParams();
            layoutParams2.height = -2;
            layoutParams2.width = -2;
            this.mbU.setLayoutParams(layoutParams2);
            WebPManager.a(this.mbU, R.drawable.icon_pure_pb_bottom_share26, R.color.CAM_X0107, WebPManager.ResourceStateType.NORMAL_PRESS);
        }
    }

    private String Gg(int i) {
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

    public void vK(boolean z) {
        if (this.mbP != null) {
            vI(this.lUg.bBY());
            if (this.mbL) {
                vz(z);
            } else {
                vA(z);
            }
            duo();
            dup();
        }
    }

    public void drC() {
        if (this.mbP != null) {
            this.mbO.setVisibility(8);
            this.mbP.setVisibility(8);
            this.mmG.mna = false;
            duo();
            dup();
        }
    }

    private void duo() {
        if (this.mms != null) {
            if (this.mmG.duF()) {
                this.mms.xp(false);
            } else {
                this.mms.xp(this.mms.isVertical() ? false : true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dup() {
        if (this.mms != null && this.faC != null) {
            if (com.baidu.tbadk.a.d.bjc()) {
                this.mms.ww(false);
            } else if (this.faC.getCurrentItem() != 0) {
                this.mms.ww(false);
            } else if (this.mmG.duF()) {
                this.mms.ww(false);
            } else {
                VideoPbViewModel videoPbViewModel = (VideoPbViewModel) ViewModelProviders.of(getActivity()).get(VideoPbViewModel.class);
                if (videoPbViewModel != null) {
                    this.mms.ww(videoPbViewModel.duP() == null || videoPbViewModel.duP().getValue() == null || videoPbViewModel.duP().getValue().booleanValue());
                }
            }
        }
    }

    private void FO(int i) {
        com.baidu.tieba.pb.videopb.d.a.a(doq(), dnK(), i);
    }

    private int dnK() {
        if (dmG() == null || dmG().getPbData() == null || dmG().getPbData().dlp() == null) {
            return -1;
        }
        return dmG().getPbData().dlp().boE();
    }

    public void vI(boolean z) {
        this.mbL = z;
    }

    public void vz(boolean z) {
        if (this.mbP != null && this.krw != null) {
            this.krw.setText(R.string.draft_to_send);
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.mbP.startAnimation(alphaAnimation);
            }
            this.mbO.setVisibility(0);
            this.mbP.setVisibility(0);
            this.mmG.mna = true;
        }
    }

    public void vA(boolean z) {
        if (this.mbP != null && this.krw != null) {
            this.krw.setText(dqD());
            if (z) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(400L);
                this.mbP.startAnimation(alphaAnimation);
            }
            this.mbO.setVisibility(0);
            this.mbP.setVisibility(0);
            this.mmG.mna = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.pb.videopb.c.a aVar) {
        if (aVar != null && this.lMY == null) {
            this.lMY = aVar;
            this.mmx.setText(aVar.getTitle());
            this.mmy.setText(aVar.dvu());
            String dvv = aVar.dvv();
            TBSpecificationBtn tBSpecificationBtn = this.mmA;
            if (TextUtils.isEmpty(dvv)) {
                dvv = getPageContext().getString(R.string.pb_video_promotion_mount_open);
            }
            tBSpecificationBtn.setText(dvv);
            this.mmB.startLoad(aVar.getImage(), 10, false);
            this.mmC.setVisibility(aVar.dvx() ? 0 : 8);
            com.baidu.adp.lib.f.e.mA().postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.50
                @Override // java.lang.Runnable
                public void run() {
                    if (VideoPbFragment.this.lMY == null || VideoPbFragment.this.lMY.dvx()) {
                        if (VideoPbFragment.this.lMY != null && VideoPbFragment.this.dmG() != null && VideoPbFragment.this.dmG().getPbData() != null && VideoPbFragment.this.dmG().getPbData().getForum() != null) {
                            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13712").dR("fid", VideoPbFragment.this.dmG().getPbData().getForum().getId()).dR("fname", VideoPbFragment.this.dmG().getPbData().getForum().getName()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmG().getPbData().getThreadId()).v("obj_param1", VideoPbFragment.this.lMY.userId));
                        }
                    } else {
                        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13608").dR("obj_id", VideoPbFragment.this.lMY.getTitle()).dR("obj_name", VideoPbFragment.this.lMY.dvu()).aq("obj_type", 2).dR("fid", VideoPbFragment.this.dmG().getPbData().getForumId()).dR("uid", TbadkCoreApplication.getCurrentAccount()).dR("tid", VideoPbFragment.this.dmG().getPbData().getThreadId()));
                    }
                    VideoPbFragment.this.duq();
                }
            }, aVar.dvw().longValue() * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duq() {
        ViewGroup.LayoutParams layoutParams = this.mmv.getLayoutParams();
        if (layoutParams != null) {
            if (this.mmD == null || !this.mmD.isRunning()) {
                this.mmv.setAlpha(0.0f);
                this.mmv.setVisibility(0);
                g(layoutParams);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dur() {
        if (this.mmv.getLayoutParams() != null) {
            if (this.mmD == null || !this.mmD.isRunning()) {
                dus();
            }
        }
    }

    private void dus() {
        final ViewGroup.LayoutParams layoutParams = this.mmv.getLayoutParams();
        if (layoutParams != null) {
            if (this.mmE == null || !this.mmE.isRunning()) {
                this.mmE = ValueAnimator.ofFloat(1.0f, 0.0f);
                this.mmE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.51
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        VideoPbFragment.this.mmv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
                this.mmE.setDuration(200L);
                this.mmE.start();
                this.mmE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.52
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        VideoPbFragment.this.f(layoutParams);
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
    public void f(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.abf.getLayoutParams();
        final int i = layoutParams2.height;
        this.mmD = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mmD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.53
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kog);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + (i - VideoPbFragment.kog);
                VideoPbFragment.this.mmv.setLayoutParams(layoutParams);
                VideoPbFragment.this.abf.setLayoutParams(layoutParams2);
            }
        });
        this.mmD.setDuration(300L);
        this.mmD.start();
        this.mmD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.54
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.mmv.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    private void g(final ViewGroup.LayoutParams layoutParams) {
        final ViewGroup.LayoutParams layoutParams2 = this.abf.getLayoutParams();
        final int i = layoutParams2.height;
        this.mmD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mmD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.55
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * VideoPbFragment.kog);
                layoutParams.height = floatValue;
                layoutParams2.height = floatValue + i;
                VideoPbFragment.this.mmv.setLayoutParams(layoutParams);
                VideoPbFragment.this.abf.setLayoutParams(layoutParams2);
            }
        });
        this.mmD.setDuration(300L);
        this.mmD.start();
        this.mmD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.57
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                VideoPbFragment.this.dut();
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
    public void dut() {
        this.mmD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mmD.setDuration(300L);
        this.mmD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.58
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                VideoPbFragment.this.mmv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        this.mmD.start();
    }

    public String dqD() {
        if (!au.isEmpty(this.mcP)) {
            return this.mcP;
        }
        this.mcP = TbadkCoreApplication.getInst().getResources().getString(ao.dqt());
        return this.mcP;
    }

    public void drc() {
        hideProgressBar();
        if (com.baidu.tbadk.a.d.bjc() && duy() != null) {
            duy().endLoadData();
            duy().drd();
        } else if (duw() != null) {
            duw().endLoadData();
            duw().drd();
        }
    }

    public boolean dC(View view) {
        if (view != null && (view.getTag() instanceof SparseArray)) {
            Object obj = ((SparseArray) view.getTag()).get(R.id.tag_clip_board);
            if (obj instanceof PostData) {
                PostData postData = (PostData) obj;
                if (!TextUtils.isEmpty(postData.getBimg_url()) && com.baidu.tbadk.core.k.bkV().isShowImages()) {
                    return PC(postData.getId());
                }
                if (checkUpIsLogin()) {
                    if (dmG() == null || dmG().getPbData() == null) {
                        return true;
                    }
                    if (this.mcx != null) {
                        this.mcx.dnq();
                    }
                    q qVar = new q();
                    qVar.a(dmG().getPbData().getForum());
                    qVar.setThreadData(dmG().getPbData().dlp());
                    qVar.g(postData);
                    this.lTf.d(qVar);
                    this.lTf.setPostId(postData.getId());
                    a(view, postData.bnS().getUserId(), "", postData);
                    TiebaStatic.log("c11743");
                    if (this.lUg != null) {
                        vI(this.lUg.bBY());
                    }
                    return true;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public void duu() {
        if (this.lUg != null) {
            vI(this.lUg.bBY());
        }
        dqB();
        this.mmF.drt();
    }

    private boolean PC(String str) {
        if (!StringUtils.isNull(str) && bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("bubble_link", "");
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

    public void dqW() {
        if (this.mbw != null) {
            this.mbw.setVisibility(0);
        }
    }

    public void dqX() {
        if (this.mbw != null) {
            this.mbw.setVisibility(8);
        }
    }

    public void Gy(int i) {
        if (this.mmp != null) {
            this.mmp.setVisibility(i);
        }
    }

    public void dra() {
        l.hideSoftKeyPad(getPageContext().getPageActivity(), getBaseFragmentActivity().getCurrentFocus());
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public PbModel.a dnO() {
        return this.lUW;
    }

    public void dqx() {
        if (this.ael != null) {
            this.ael.hide();
        }
    }

    public void cDi() {
        if (this.lTk.getCurrentFocus() != null) {
            l.hideSoftKeyPad(getPageContext().getPageActivity(), this.lTk.getCurrentFocus());
        }
    }

    public void N(com.baidu.tieba.pb.data.f fVar) {
        if (fVar != null && fVar.dlp() != null) {
            String valueOf = String.valueOf(fVar.dlp().bnJ());
            if (fVar.dlp().bnJ() == 0) {
                valueOf = "";
            }
            this.mmn.En(valueOf);
        }
    }

    public void c(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
        for (BaseFragment baseFragment : this.mmo.duG()) {
            if (baseFragment instanceof com.baidu.tieba.pb.videopb.a) {
                ((com.baidu.tieba.pb.videopb.a) baseFragment).b(z, i, i2, i3, fVar, str, i4);
            }
        }
        b(z, i, i2, i3, fVar, str, i4);
    }

    public void a(com.baidu.tbadk.core.dialog.a aVar, JSONArray jSONArray) {
        aVar.dismiss();
        if (dmG() != null && dmG().getPbData() != null && dmG().getPbData().dlp() != null && dmG().getPbData().getForum() != null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(getPageContext().getPageActivity(), true, RequestResponseCode.REQUEST_LOGIN_PB_DEL_POST)));
            } else if (aVar.getYesButtonTag() instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) aVar.getYesButtonTag();
                int intValue = ((Integer) sparseArray.get(mcq)).intValue();
                if (intValue == mcr) {
                    if (!this.gfY.dOJ()) {
                        showProgressBar();
                        String str = (String) sparseArray.get(R.id.tag_del_post_id);
                        int intValue2 = ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue();
                        boolean booleanValue = ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue();
                        int intValue3 = ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue();
                        if (jSONArray != null) {
                            this.gfY.TL(au.R(jSONArray));
                        }
                        this.gfY.a(dmG().getPbData().getForum().getId(), dmG().getPbData().getForum().getName(), dmG().getPbData().dlp().getId(), str, intValue3, intValue2, booleanValue, dmG().getPbData().dlp().getBaijiahaoData());
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_DEL_THREAD_SUCCESS, true));
                    }
                } else if (intValue == mcs || intValue == mcu) {
                    if (dmG().dpn() != null) {
                        dmG().dpn().FG(PbModel.UPGRADE_TO_PHOTO_LIVE);
                    }
                    if (intValue == mcs) {
                        TiebaStatic.log("c10499");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eI(String str, String str2) {
        bf.bsY().b(getPageContext(), new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public ListView getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public int bIk() {
        return 0;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<ImageView> bIl() {
        if (this.fVL == null) {
            this.fVL = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<ImageView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.59
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: bIx */
                public ImageView makeObject() {
                    ForeDrawableImageView foreDrawableImageView = new ForeDrawableImageView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkV().isShowImages();
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
                /* renamed from: b */
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
                /* renamed from: c */
                public ImageView activateObject(ImageView imageView) {
                    if (imageView instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) imageView;
                        tbImageView.setTag(null);
                        if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
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
                /* renamed from: d */
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
        return this.fVL;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<TextView> bIm() {
        if (this.fZb == null) {
            this.fZb = TbRichTextView.K(getPageContext().getPageActivity(), 8);
        }
        return this.fZb;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<GifView> bIn() {
        if (this.fVM == null) {
            this.fVM = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<GifView>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.60
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: cxm */
                public GifView makeObject() {
                    GifView gifView = new GifView(VideoPbFragment.this.getPageContext().getPageActivity());
                    boolean isShowImages = com.baidu.tbadk.core.k.bkV().isShowImages();
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
                    if (com.baidu.tbadk.core.k.bkV().isShowImages()) {
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
                    gifView.bCQ();
                    gifView.setBackgroundDrawable(null);
                    gifView.setTag(null);
                    gifView.setOnClickListener(null);
                    gifView.setDefaultBgResource(R.color.common_color_10220);
                    return gifView;
                }
            }, 20, 0);
        }
        return this.fVM;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<View> bIo() {
        if (this.fZc == null) {
            this.fZc = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<View>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.61
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dot */
                public View makeObject() {
                    PlayVoiceBntNew playVoiceBntNew = new PlayVoiceBntNew(VideoPbFragment.this.getPageContext().getPageActivity(), PlayVoiceBntNew.PLAY_TYPE.NORMAL);
                    playVoiceBntNew.setVoiceManager(VideoPbFragment.this.getVoiceManager());
                    playVoiceBntNew.setPlayTimeTextView(R.dimen.fontsize28);
                    return playVoiceBntNew;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dH */
                public void destroyObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dI */
                public View activateObject(View view) {
                    ((PlayVoiceBntNew) view).ccH();
                    return view;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dJ */
                public View passivateObject(View view) {
                    ((PlayVoiceBntNew) view).reset();
                    return view;
                }
            }, 8, 0);
        }
        return this.fZc;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<LinearLayout> bIp() {
        if (this.fZd == null) {
            this.fZd = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<LinearLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.62
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.lib.d.c
                /* renamed from: dov */
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
        return this.fZd;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public com.baidu.adp.lib.d.b<RelativeLayout> bIq() {
        this.fZe = new com.baidu.adp.lib.d.b<>(new com.baidu.adp.lib.d.c<RelativeLayout>() { // from class: com.baidu.tieba.pb.videopb.VideoPbFragment.63
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.d.c
            /* renamed from: dou */
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
        return this.fZe;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aE(Context context, String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(getPageContext().getPageActivity(), str, null)));
        this.lTw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void g(Context context, String str, boolean z) {
        if (com.baidu.tieba.pb.pb.main.au.PS(str) && dmG() != null && dmG().doJ() != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c11664").aq("obj_param1", 1).dR("post_id", dmG().doJ()));
        }
        if (z) {
            if (!TextUtils.isEmpty(str)) {
                com.baidu.tbadk.data.m mVar = new com.baidu.tbadk.data.m();
                mVar.mLink = str;
                mVar.type = 3;
                mVar.fBL = "2";
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_START_HOT_TOPIC_ACTIVITY, mVar));
            }
        } else {
            com.baidu.tieba.pb.pb.main.au.drZ().h(getPageContext(), str);
        }
        this.lTw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aF(Context context, String str) {
        com.baidu.tieba.pb.pb.main.au.drZ().h(getPageContext(), str);
        TiebaStatic.eventStat(getPageContext().getPageActivity(), "pb_video", "pbclick", 1, new Object[0]);
        this.lTw = true;
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aG(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aH(Context context, String str) {
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void u(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mmF.setPhoneNumber(str);
            com.baidu.tbadk.core.dialog.b dvd = this.mmF.dvd();
            if (dvd == null) {
                this.mmF.dnF();
            }
            TiebaStatic.log("pb_show_phonedialog");
            if (str2.equals("2")) {
                dvd.getItemView(1).setVisibility(8);
            } else {
                dvd.getItemView(1).setVisibility(0);
            }
            dvd.bqB();
            this.lTw = true;
        }
    }

    @Override // com.baidu.tbadk.widget.richText.h
    public void aI(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            bf.bsY().b(getPageContext(), new String[]{str});
            this.lTw = true;
        }
    }

    @Override // com.baidu.tieba.pb.videopb.a
    public void b(boolean z, int i, int i2, int i3, com.baidu.tieba.pb.data.f fVar, String str, int i4) {
    }

    public com.baidu.tbadk.coreExtra.model.a duv() {
        return this.fce;
    }

    public void setIsLoading(boolean z) {
        this.mIsLoading = z;
    }

    public View.OnTouchListener bFK() {
        return this.bUt;
    }

    public ReplyFragment duw() {
        if (this.mmo == null || !(this.mmo.Gz(mmk) instanceof ReplyFragment)) {
            return null;
        }
        return (ReplyFragment) this.mmo.Gz(mmk);
    }

    public DetailInfoFragment dux() {
        if (this.mmo == null || !(this.mmo.Gz(mmj) instanceof DetailInfoFragment)) {
            return null;
        }
        return (DetailInfoFragment) this.mmo.Gz(mmj);
    }

    public DetailInfoAndReplyFragment duy() {
        if (this.mmo == null || !(this.mmo.Gz(mml) instanceof DetailInfoAndReplyFragment)) {
            return null;
        }
        return (DetailInfoAndReplyFragment) this.mmo.Gz(mml);
    }

    public boolean dmy() {
        PbModel dmG = this.lTk.dmG();
        if (dmG == null) {
            return false;
        }
        return dmG.dmy();
    }

    @Override // com.baidu.tieba.pb.videopb.b
    public void finish() {
        CardHListViewData dlB;
        PbModel dmG = this.lTk.dmG();
        if (dmG != null && dmG.getPbData() != null && !dmG.getPbData().dlS()) {
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = getPageContext();
            historyMessage.threadId = dmG.getPbData().dlp().getId();
            if (dmG.isShareThread() && dmG.getPbData().dlp().eUD != null) {
                historyMessage.threadName = dmG.getPbData().dlp().eUD.showText;
            } else {
                historyMessage.threadName = dmG.getPbData().dlp().getTitle();
            }
            if (dmG.isShareThread() && !dmy()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = dmG.getPbData().getForum().getName();
            }
            ArrayList<PostData> dlr = dmG.getPbData().dlr();
            int dre = duw() != null ? duw().dre() : 0;
            if (dlr != null && dre >= 0 && dre < dlr.size()) {
                historyMessage.postID = dlr.get(dre).getId();
            }
            historyMessage.isHostOnly = dmG.getHostMode();
            historyMessage.isSquence = dmG.doL();
            historyMessage.isShareThread = dmG.isShareThread();
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
        if (this.lUg != null) {
            this.lUg.onDestroy();
        }
        if (dmG != null && (dmG.doM() || dmG.doO())) {
            Intent intent = new Intent();
            intent.putExtra("tid", dmG.doJ());
            if (this.lTV) {
                if (this.lTX) {
                    intent.putExtra("type", 4);
                    intent.putExtra("top_data", dmG.cvv());
                }
                if (this.lTW) {
                    intent.putExtra("type", 2);
                    intent.putExtra("good_data", dmG.getIsGood());
                }
            }
            if (dmG.getPbData() != null && System.currentTimeMillis() - this.lTs >= 40000 && (dlB = dmG.getPbData().dlB()) != null && !y.isEmpty(dlB.getDataList())) {
                intent.putExtra("guess_like_data", dlB);
            }
            PbActivity pbActivity = this.lTk;
            PbActivity pbActivity2 = this.lTk;
            pbActivity.setResult(-1, intent);
        }
        if (dnV()) {
            if (dmG != null) {
                com.baidu.tieba.pb.data.f pbData = dmG.getPbData();
                if (pbData != null) {
                    if (pbData.getUserData() != null) {
                        pbData.getUserData().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
                    }
                    if (!this.lTy) {
                        if (this.mmr != null) {
                            Rect rect = new Rect();
                            this.mmr.getGlobalVisibleRect(rect);
                            aj.dqi().g(rect);
                        }
                        aj.dqi().Gc(this.faC.getCurrentItem());
                        BdTypeRecyclerView cGb = cGb();
                        Parcelable parcelable = null;
                        if (cGb != null) {
                            parcelable = cGb.onSaveInstanceState();
                        }
                        aj.dqi().a(dmG.doU(), parcelable, dmG.doL(), dmG.getHostMode(), false);
                    }
                }
            } else {
                aj.dqi().reset();
            }
            dmU();
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.mms != null && !this.mms.isVertical()) {
            if ((this.mms.isFullScreen() && configuration.orientation == 1) || (!this.mms.isFullScreen() && configuration.orientation == 2)) {
                this.mms.wx(false);
            }
        }
    }

    public boolean cFI() {
        if (this.mms == null) {
            return false;
        }
        return this.mms.isVertical();
    }

    public void onScrollStateChanged(int i) {
        if (i == 0) {
            com.baidu.tieba.s.c.dMH().b(getUniqueId(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {
        public boolean mna;
        public boolean mnb;

        private a() {
            this.mnb = true;
        }

        public boolean duF() {
            return (this.mna && this.mnb) ? false : true;
        }
    }

    public void duz() {
        this.lTK = -1;
        this.lTL = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dom() {
        if (dmG() != null && !au.isEmpty(dmG().doJ())) {
            com.baidu.tbadk.BdToken.c.bhp().q(com.baidu.tbadk.BdToken.b.eDG, com.baidu.adp.lib.f.b.toLong(dmG().doJ(), 0L));
        }
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        this.mmq.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duA() {
        if (this.mmP == null) {
            this.mmP = ObjectAnimator.ofFloat(this.mmu, "alpha", 0.0f, 1.0f);
            this.mmP.setDuration(200L);
        }
        this.mmP.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duB() {
        if (this.mmQ == null) {
            this.mmQ = ObjectAnimator.ofFloat(this.mmu, "alpha", 1.0f, 0.0f);
            this.mmQ.setDuration(200L);
        }
        this.mmQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean duC() {
        return this.mms != null && this.mms.duD();
    }

    public boolean duD() {
        return this.mmM;
    }

    public void wo(boolean z) {
        this.mmM = z;
    }

    public void vf(boolean z) {
        this.lTz = z;
    }

    public boolean dok() {
        return this.lTz;
    }

    public LinearLayout drS() {
        return this.mbQ;
    }
}
