package com.baidu.webkit.sdk.plugin;
/* loaded from: classes9.dex */
public interface ZeusPlugin {

    /* loaded from: classes9.dex */
    public interface Callback {
        boolean onCallback(ZeusPlugin zeusPlugin, String str, Object obj);
    }

    /* loaded from: classes9.dex */
    public static class Command {
        private static final int MAX_POOL_SIZE = 50;
        private static Command sPool;
        public int arg1;
        public int arg2;
        public int arg3;
        public int arg4;
        public int arg5;
        private int flag;
        private Command next;
        public Object obj;
        public int ret;
        public String what;
        private static final Object sPoolSync = new Object();
        private static int sPoolSize = 0;

        public static Command obtain() {
            synchronized (sPoolSync) {
                if (sPool != null) {
                    Command command = sPool;
                    sPool = command.next;
                    command.next = null;
                    command.flag = 0;
                    sPoolSize--;
                    return command;
                }
                return new Command();
            }
        }

        public static Command obtain(String str) {
            Command obtain = obtain();
            obtain.what = str;
            return obtain;
        }

        public void recycle() {
            if (this.flag == 1) {
                return;
            }
            this.flag = 1;
            this.what = null;
            this.arg1 = 0;
            this.arg2 = 0;
            this.arg3 = 0;
            this.arg4 = 0;
            this.obj = null;
            this.ret = 0;
            synchronized (sPoolSync) {
                if (sPoolSize < 50) {
                    this.next = sPool;
                    sPool = this;
                    sPoolSize++;
                }
            }
        }
    }

    void sendCommand(Command command);

    void setCallback(Callback callback);
}
