package com.baidu.tieba;

import com.baidu.live.arch.utils.LiveActivityHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class ti5 {
    public static /* synthetic */ Interceptable $ic;
    public static final List<String> a;
    public static final List<String> b;
    public static final List<String> c;
    public static final List<String> d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948182185, "Lcom/baidu/tieba/ti5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948182185, "Lcom/baidu/tieba/ti5;");
                return;
            }
        }
        a = Arrays.asList("com.baidu.searchbox.feed.video.VideoDetailActivity", LiveActivityHelper.MEDIA_ACTIVITY_NAME, "com.baidu.searchbox.schemedispatch.BdBoxSchemeDispatchActivity", "com.baidu.searchbox.music.TTSFullScreenPlayerActivity", "com.baidu.megapp.proxy.activity.FragmentActivityProxy", "com.baidu.searchbox.home.feed.AdVideoDetailScrollActivity", "com.baidu.searchbox.home.feed.video.minidetail.vertical.MiniVideoDetailVerticalNaActivity", "com.baidu.live.master.activity.VoteListActivity", "com.baidu.live.master.activity.EditLiveVoteActivity", "com.baidu.live.master.prepare.AlaLiveIntroActivity", "com.baidu.live.master.prepare.AlaLiveIntroActivity", "com.baidu.live.master.prepare.AlaLiveGoodsActivity", "com.baidu.live.master.prepare.AlaLiveVoteListActivity", "com.baidu.live.master.prepare.AlaLiveVoteEditActivity", "com.baidu.live.master.prepare.AlaLiveSuitableActivity", "com.baidu.live.master.prepare.AlaLiveMoreInfoActivity", "com.baidu.live.master.prepare.AlaLiveCategorySelectActivity", "com.baidu.live.master.prepare.AlaLiveTagEditActivity", "com.baidu.live.master.prepare.MasterMicTypeChooseActivity", "com.baidu.live.master.sdk.activity.CommonWebViewActivity", "com.baidu.live.master.sdk.activity.LivePlayerActivity", "com.baidu.live.master.tieba.personextra.EditHeadActivity", "com.baidu.live.master.tieba.write.album.AlbumActivity", "com.baidu.live.master.ala.person.PersonCardActivity", "com.baidu.live.master.gift.AlaGiftLuckyStarActivity", "com.baidu.live.master.gift.container.AlaGiftTabActivity", "com.baidu.live.master.AlaLiveEndActivity", "com.baidu.live.master.AlaMasterLiveRoomActivity", "com.baidu.live.master.prepare.LivePreLiveListActivity", "com.baidu.live.master.core.prepare.EditOrderLiveActivity", "com.baidu.live.master.prepare.LiveMasterPrepareGoodsActivity", "com.baidu.live.master.bjhlive.activity.LiveCouponDetailActivity", "com.baidu.searchbox.live.liveshow.LiveShowActivity", "com.duowan.mobile.basemedia.watchlive.activity.LiveTemplateActivity", "com.yy.mobile.plugin.pluginmobilelive.MobileLiveActivity");
        b = Arrays.asList("com.baidu.tieba.write.write.NewWriteActivity", "com.baidu.tieba.write.write.work.WorkPublishActivity", "com.baidu.tieba.video.record.RecordVideoActivity", "com.baidu.tieba.view.capture.TbCaptureActivity", "com.baidu.tieba.videoplay.VideoPlayActivity", "com.baidu.tieba.videoplay.VideoRecommentPlayActivity", "com.baidu.tieba.videoplay.FrsVideoTabPlayActivity", "com.baidu.tieba.pb.pb.main.PbFullScreenEditorActivity", "com.baidu.tieba.pb.pb.foldcomment.FoldCommentActivity", "com.baidu.tieba.pb.pb.main.PbCommentFloatActivity", "com.baidu.tieba.view.videofile.TbFileVideoActivity", "com.baidu.tieba.view.videoedit.TbEditVideoActivity", "com.baidu.tieba.pb.pb.sub.NewSubPbActivity", "com.baidu.tieba.personExtra.PersonChangeActivity");
        c = Arrays.asList("com.baidu.tieba.view.capture.TbCaptureActivity", "com.baidu.tieba.videoplay.VideoPlayActivity", "com.baidu.tieba.videoplay.VideoRecommentPlayActivity", "com.baidu.tieba.videoplay.FrsVideoTabPlayActivity", "com.baidu.tieba.view.videofile.TbFileVideoActivity", "com.baidu.tieba.view.videoedit.TbEditVideoActivity");
        d = Arrays.asList("com.baidu.tieba.pb.pb.main.PbActivity", "com.baidu.tieba.frs.FrsActivity");
    }
}
