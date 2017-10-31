package com.baidu.tieba.monitor;

import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.searchbox.plugin.api.PayPluginManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class VideoMonitorStatic {
    private static CustomMessageListener exC = new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.monitor.VideoMonitorStatic.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.monitor.b.b.aNm().aNn();
        }
    };

    static {
        aNi();
        MessageManager.getInstance().registerListener(exC);
    }

    private static void aNi() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_VIDEO_MONITOR_FACTORY, new CustomMessageTask.CustomRunnable<com.baidu.tieba.play.b.b>() { // from class: com.baidu.tieba.monitor.VideoMonitorStatic.2
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.play.b.b> run(CustomMessage<com.baidu.tieba.play.b.b> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_VIDEO_MONITOR_FACTORY, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static String aNj() {
        if (j.hi()) {
            return "WIFI";
        }
        if (j.hm()) {
            return "2G";
        }
        if (j.hl()) {
            return "3G";
        }
        if (!j.hk() && !j.hh()) {
            return "NONE";
        }
        return "4G";
    }

    public static int pb(int i) {
        switch (i) {
            case SapiErrorCode.NETWORK_FAILED /* -200 */:
                return 1;
            case -100:
                return 2;
            default:
                return 3;
        }
    }

    public static int oJ(String str) {
        if (str.contains("127.0.0.1")) {
            return 1;
        }
        if (!str.contains("http")) {
            return 2;
        }
        return 0;
    }

    public static String pc(int i) {
        switch (i) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_system);
            case -44399:
                return TbadkCoreApplication.getInst().getString(d.j.error_url_empty);
            case -34399:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_oom);
            case -24399:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_exception);
            case -14399:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_service_crash);
            case -10040:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_stream_index);
            case -10039:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_alloc_context3);
            case -10038:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_configure_audio_filters);
            case -10037:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_parameters_to_context);
            case -10035:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_open_video_decoder);
            case -10032:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_open);
            case -10031:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avcodec_not_find);
            case -10028:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_auto_exit);
            case -10027:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_av_copy_packet);
            case -10026:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_av_dict_get);
            case -10025:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_no_video_or_audio_stream);
            case -10024:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avformat_find_stream_info);
            case -10023:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avformat_open_input);
            case -10022:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_avformat_alloc_context);
            case -10021:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_wait_mutex);
            case -10019:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_av_mallocz);
            case -10018:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_file_name);
            case -10017:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_read_tid);
            case -10016:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_video_refresh_tid);
            case -10015:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_continue_read_thread);
            case -10014:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_packet_queue_init_all);
            case -10013:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_frame_queue_init_audio);
            case -10012:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_frame_queue_init_subtitle);
            case -10011:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_frame_queue_init_video);
            case -10010:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_ijk_stream_open);
            case PayPluginManager.RESULT_CODE_UNKNOWN /* -10000 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_ijk);
            case -5000:
                return TbadkCoreApplication.getInst().getString(d.j.error_warning_prepare_timeout);
            case -4399:
                return TbadkCoreApplication.getInst().getString(d.j.error_prepare_timeout);
            case -1010:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_unsupported);
            case TbErrInfo.ERR_IMG_FILE /* -1007 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_malformed);
            case TbErrInfo.ERR_IMG_CACHE /* -1004 */:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_io);
            case -110:
                return TbadkCoreApplication.getInst().getString(d.j.error_extra_system_timed_out);
            case 1:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_system_unknown);
            case 100:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_server_died);
            case 200:
                return TbadkCoreApplication.getInst().getString(d.j.error_what_system_not_valid_for_progressive_playback);
            default:
                return TbadkCoreApplication.getInst().getString(d.j.error_not_record) + i;
        }
    }

    public static String oK(String str) {
        if (TextUtils.equals(str, "1")) {
            return "index";
        }
        if (TextUtils.equals(str, "2")) {
            return "frs";
        }
        if (TextUtils.equals(str, "6")) {
            return "pb";
        }
        if (TextUtils.equals(str, "12")) {
            return "frs_bavideotab";
        }
        if (TextUtils.equals(str, TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE)) {
            return "floor5";
        }
        if (TextUtils.equals(str, "10")) {
            return "floor10";
        }
        if (TextUtils.equals(str, "11")) {
            return "floor15";
        }
        if (TextUtils.equals(str, "13")) {
            return "auto_midpage";
        }
        return str;
    }
}
