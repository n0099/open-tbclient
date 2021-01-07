package com.baidu.webkit.internal.brotli;

import com.baidu.webkit.internal.INoProGuard;
import com.baidu.webkit.internal.blink.WebSettingsGlobalBlink;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes15.dex */
public class DecoderJNI implements INoProGuard {

    /* loaded from: classes15.dex */
    public static class Wrapper implements INoProGuard {
        private final ByteBuffer inputBuffer;
        private final long[] context = new long[3];
        private a lastStatus = a.NEEDS_MORE_INPUT;
        private boolean fresh = true;

        public Wrapper(int i) throws IOException {
            this.context[1] = i;
            this.inputBuffer = WebSettingsGlobalBlink.kernelBrotliCreate(this.context);
            if (this.context[0] == 0) {
                throw new IOException("failed to initialize native brotli decoder");
            }
        }

        private void parseStatus() {
            long j = this.context[1];
            if (j == 1) {
                this.lastStatus = a.DONE;
            } else if (j == 2) {
                this.lastStatus = a.NEEDS_MORE_INPUT;
            } else if (j == 3) {
                this.lastStatus = a.NEEDS_MORE_OUTPUT;
            } else if (j == 4) {
                this.lastStatus = a.OK;
            } else {
                this.lastStatus = a.ERROR;
            }
        }

        public void destroy() {
            if (this.context[0] == 0) {
                throw new IllegalStateException("brotli decoder is already destroyed");
            }
            WebSettingsGlobalBlink.kernelBrotliDestroy(this.context);
            this.context[0] = 0;
        }

        protected void finalize() throws Throwable {
            if (this.context[0] != 0) {
                destroy();
            }
            super.finalize();
        }

        public ByteBuffer getInputBuffer() {
            return this.inputBuffer;
        }

        public a getStatus() {
            return this.lastStatus;
        }

        public boolean hasOutput() {
            return this.context[2] != 0;
        }

        public ByteBuffer pull() {
            if (this.context[0] == 0) {
                throw new IllegalStateException("brotli decoder is already destroyed");
            }
            if (this.lastStatus == a.NEEDS_MORE_OUTPUT || hasOutput()) {
                this.fresh = false;
                ByteBuffer kernelBrotliPull = WebSettingsGlobalBlink.kernelBrotliPull(this.context);
                parseStatus();
                return kernelBrotliPull;
            }
            throw new IllegalStateException("pulling output from decoder in " + this.lastStatus + " state");
        }

        public void push(int i) {
            if (i < 0) {
                throw new IllegalArgumentException("negative block length");
            }
            if (this.context[0] == 0) {
                throw new IllegalStateException("brotli decoder is already destroyed");
            }
            if (this.lastStatus != a.NEEDS_MORE_INPUT && this.lastStatus != a.OK) {
                throw new IllegalStateException("pushing input to decoder in " + this.lastStatus + " state");
            }
            if (this.lastStatus == a.OK && i != 0) {
                throw new IllegalStateException("pushing input to decoder in OK state");
            }
            this.fresh = false;
            WebSettingsGlobalBlink.kernelBrotliPush(this.context, i);
            parseStatus();
        }
    }

    /* loaded from: classes15.dex */
    public enum a {
        ERROR,
        DONE,
        NEEDS_MORE_INPUT,
        NEEDS_MORE_OUTPUT,
        OK
    }
}
